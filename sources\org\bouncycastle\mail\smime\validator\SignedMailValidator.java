package org.bouncycastle.mail.smime.validator;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.Time;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.mail.smime.SMIMESigned;
import org.bouncycastle.x509.PKIXCertPathReviewer;

public class SignedMailValidator {
    private static final Class DEFAULT_CERT_PATH_REVIEWER = PKIXCertPathReviewer.class;
    private static final String EXT_KEY_USAGE = X509Extensions.ExtendedKeyUsage.getId();
    private static final String RESOURCE_NAME = "org.bouncycastle.mail.smime.validator.SignedMailValidatorMessages";
    private static final String SUBJECT_ALTERNATIVE_NAME = X509Extensions.SubjectAlternativeName.getId();
    private static final long THIRTY_YEARS_IN_MILLI_SEC = 946728000000L;
    private static final int shortKeyLength = 512;
    private Class certPathReviewerClass;
    private CertStore certs;
    private String[] fromAddresses;
    private Map results;
    private SignerInformationStore signers;

    public class ValidationResult {
        private List errors;
        private List notifications;
        private PKIXCertPathReviewer review;
        private boolean signVerified;
        private List userProvidedCerts;

        ValidationResult(PKIXCertPathReviewer pKIXCertPathReviewer, boolean z, List list, List list2, List list3) {
            this.review = pKIXCertPathReviewer;
            this.errors = list;
            this.notifications = list2;
            this.signVerified = z;
            this.userProvidedCerts = list3;
        }

        public CertPath getCertPath() {
            PKIXCertPathReviewer pKIXCertPathReviewer = this.review;
            if (pKIXCertPathReviewer != null) {
                return pKIXCertPathReviewer.getCertPath();
            }
            return null;
        }

        public PKIXCertPathReviewer getCertPathReview() {
            return this.review;
        }

        public List getErrors() {
            return this.errors;
        }

        public List getNotifications() {
            return this.notifications;
        }

        public List getUserProvidedCerts() {
            return this.userProvidedCerts;
        }

        public boolean isValidSignature() {
            PKIXCertPathReviewer pKIXCertPathReviewer = this.review;
            return pKIXCertPathReviewer != null && this.signVerified && pKIXCertPathReviewer.isValidCertPath() && this.errors.isEmpty();
        }

        public boolean isVerifiedSignature() {
            return this.signVerified;
        }
    }

    public SignedMailValidator(MimeMessage mimeMessage, PKIXParameters pKIXParameters) throws SignedMailValidatorException {
        this(mimeMessage, pKIXParameters, DEFAULT_CERT_PATH_REVIEWER);
    }

    public SignedMailValidator(MimeMessage mimeMessage, PKIXParameters pKIXParameters, Class cls) throws SignedMailValidatorException {
        SMIMESigned sMIMESigned;
        this.certPathReviewerClass = cls;
        Class cls2 = DEFAULT_CERT_PATH_REVIEWER;
        if (cls2.isAssignableFrom(cls)) {
            try {
                if (mimeMessage.isMimeType("multipart/signed")) {
                    sMIMESigned = new SMIMESigned((MimeMultipart) mimeMessage.getContent());
                } else {
                    if (!mimeMessage.isMimeType("application/pkcs7-mime")) {
                        if (!mimeMessage.isMimeType("application/x-pkcs7-mime")) {
                            throw new SignedMailValidatorException(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.noSignedMessage"));
                        }
                    }
                    sMIMESigned = new SMIMESigned((Part) mimeMessage);
                }
                this.certs = sMIMESigned.getCertificatesAndCRLs("Collection", "BC");
                this.signers = sMIMESigned.getSignerInfos();
                InternetAddress[] from = mimeMessage.getFrom();
                InternetAddress internetAddress = null;
                try {
                    if (mimeMessage.getHeader("Sender") != null) {
                        internetAddress = new InternetAddress(mimeMessage.getHeader("Sender")[0]);
                    }
                } catch (MessagingException unused) {
                }
                this.fromAddresses = new String[(from.length + (internetAddress != null ? 1 : 0))];
                for (int i = 0; i < from.length; i++) {
                    this.fromAddresses[i] = from[i].getAddress();
                }
                if (internetAddress != null) {
                    this.fromAddresses[from.length] = internetAddress.getAddress();
                }
                this.results = new HashMap();
                validateSignatures(pKIXParameters);
            } catch (Exception e) {
                if (e instanceof SignedMailValidatorException) {
                    throw ((SignedMailValidatorException) e);
                }
                throw new SignedMailValidatorException(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.exceptionReadingMessage", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
            }
        } else {
            throw new IllegalArgumentException("certPathReviewerClass is not a subclass of " + cls2.getName());
        }
    }

    static String addressesToString(Object[] objArr) {
        if (objArr == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (int i = 0; i != objArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.valueOf(objArr[i]));
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public static CertPath createCertPath(X509Certificate x509Certificate, Set set, List list) throws GeneralSecurityException {
        return (CertPath) createCertPath(x509Certificate, set, list, null)[0];
    }

    public static Object[] createCertPath(X509Certificate x509Certificate, Set set, List list, List list2) throws GeneralSecurityException {
        boolean z;
        boolean z2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        linkedHashSet.add(x509Certificate);
        arrayList.add(new Boolean(true));
        X509Certificate x509Certificate2 = null;
        boolean z3 = false;
        while (x509Certificate != null && !z3) {
            Iterator it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TrustAnchor trustAnchor = (TrustAnchor) it.next();
                X509Certificate trustedCert = trustAnchor.getTrustedCert();
                if (trustedCert != null) {
                    if (trustedCert.getSubjectX500Principal().equals(x509Certificate.getIssuerX500Principal())) {
                        try {
                            x509Certificate.verify(trustedCert.getPublicKey(), "BC");
                            z3 = true;
                            x509Certificate2 = trustedCert;
                            break;
                        } catch (Exception unused) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else if (trustAnchor.getCAName().equals(x509Certificate.getIssuerX500Principal().getName())) {
                    x509Certificate.verify(trustAnchor.getCAPublicKey(), "BC");
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                X509CertSelector x509CertSelector = new X509CertSelector();
                try {
                    x509CertSelector.setSubject(x509Certificate.getIssuerX500Principal().getEncoded());
                    byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
                    if (extensionValue != null) {
                        try {
                            AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(getObject(extensionValue));
                            if (instance.getKeyIdentifier() != null) {
                                x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(instance.getKeyIdentifier()).getDEREncoded());
                            }
                        } catch (IOException unused2) {
                        }
                    }
                    x509Certificate = findNextCert(list, x509CertSelector, linkedHashSet);
                    if (x509Certificate != null || list2 == null) {
                        z2 = false;
                    } else {
                        x509Certificate = findNextCert(list2, x509CertSelector, linkedHashSet);
                        z2 = true;
                    }
                    if (x509Certificate != null) {
                        linkedHashSet.add(x509Certificate);
                        arrayList.add(new Boolean(z2));
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e.toString());
                }
            }
        }
        if (z3) {
            if (x509Certificate2 == null || !x509Certificate2.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
                X509CertSelector x509CertSelector2 = new X509CertSelector();
                try {
                    x509CertSelector2.setSubject(x509Certificate.getIssuerX500Principal().getEncoded());
                    x509CertSelector2.setIssuer(x509Certificate.getIssuerX500Principal().getEncoded());
                    X509Certificate findNextCert = findNextCert(list, x509CertSelector2, linkedHashSet);
                    if (findNextCert != null || list2 == null) {
                        z = false;
                    } else {
                        findNextCert = findNextCert(list2, x509CertSelector2, linkedHashSet);
                        z = true;
                    }
                    if (findNextCert != null) {
                        try {
                            x509Certificate.verify(findNextCert.getPublicKey(), "BC");
                            linkedHashSet.add(findNextCert);
                            arrayList.add(new Boolean(z));
                        } catch (GeneralSecurityException unused3) {
                        }
                    }
                } catch (IOException e2) {
                    throw new IllegalStateException(e2.toString());
                }
            } else {
                linkedHashSet.add(x509Certificate2);
                arrayList.add(new Boolean(false));
            }
        }
        return new Object[]{CertificateFactory.getInstance("X.509", "BC").generateCertPath(new ArrayList(linkedHashSet)), arrayList};
    }

    private static List findCerts(List list, X509CertSelector x509CertSelector) throws CertStoreException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((CertStore) it.next()).getCertificates(x509CertSelector));
        }
        return arrayList;
    }

    private static X509Certificate findNextCert(List list, X509CertSelector x509CertSelector, Set set) throws CertStoreException {
        boolean z;
        Iterator it = findCerts(list, x509CertSelector).iterator();
        X509Certificate x509Certificate = null;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            x509Certificate = (X509Certificate) it.next();
            if (!set.contains(x509Certificate)) {
                z = true;
                break;
            }
        }
        if (z) {
            return x509Certificate;
        }
        return null;
    }

    public static Set getEmailAddresses(X509Certificate x509Certificate) throws IOException, CertificateEncodingException {
        HashSet hashSet = new HashSet();
        X509Principal subjectX509Principal = PrincipalUtil.getSubjectX509Principal(x509Certificate);
        Vector oIDs = subjectX509Principal.getOIDs();
        Vector values = subjectX509Principal.getValues();
        int i = 0;
        while (true) {
            if (i >= oIDs.size()) {
                break;
            } else if (oIDs.get(i).equals(X509Principal.EmailAddress)) {
                hashSet.add(((String) values.get(i)).toLowerCase());
                break;
            } else {
                i++;
            }
        }
        byte[] extensionValue = x509Certificate.getExtensionValue(SUBJECT_ALTERNATIVE_NAME);
        if (extensionValue != null) {
            DERSequence dERSequence = (DERSequence) getObject(extensionValue);
            for (int i2 = 0; i2 < dERSequence.size(); i2++) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) dERSequence.getObjectAt(i2);
                if (aSN1TaggedObject.getTagNo() == 1) {
                    hashSet.add(DERIA5String.getInstance(aSN1TaggedObject, true).getString().toLowerCase());
                }
            }
        }
        return hashSet;
    }

    private static DERObject getObject(byte[] bArr) throws IOException {
        return new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(bArr).readObject()).getOctets()).readObject();
    }

    public static Date getSignatureTime(SignerInformation signerInformation) {
        Attribute attribute;
        AttributeTable signedAttributes = signerInformation.getSignedAttributes();
        if (signedAttributes == null || (attribute = signedAttributes.get(CMSAttributes.signingTime)) == null) {
            return null;
        }
        return Time.getInstance(attribute.getAttrValues().getObjectAt(0).getDERObject()).getDate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009f A[Catch:{ Exception -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb A[Catch:{ Exception -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f6 A[Catch:{ Exception -> 0x0131 }] */
    public void checkSignerCert(X509Certificate x509Certificate, List list, List list2) {
        int i;
        Set emailAddresses;
        boolean z;
        byte[] extensionValue;
        BigInteger p;
        PublicKey publicKey = x509Certificate.getPublicKey();
        if (publicKey instanceof RSAPublicKey) {
            p = ((RSAPublicKey) publicKey).getModulus();
        } else if (publicKey instanceof DSAPublicKey) {
            p = ((DSAPublicKey) publicKey).getParams().getP();
        } else {
            i = -1;
            if (i != -1 && i <= 512) {
                list2.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.shortSigningKey", new Object[]{new Integer(i)}));
            }
            if (x509Certificate.getNotAfter().getTime() - x509Certificate.getNotBefore().getTime() > THIRTY_YEARS_IN_MILLI_SEC) {
                list2.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.longValidity", new Object[]{new TrustedInput(x509Certificate.getNotBefore()), new TrustedInput(x509Certificate.getNotAfter())}));
            }
            boolean[] keyUsage = x509Certificate.getKeyUsage();
            if (keyUsage != null && !keyUsage[0] && !keyUsage[1]) {
                list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.signingNotPermitted"));
            }
            extensionValue = x509Certificate.getExtensionValue(EXT_KEY_USAGE);
            if (extensionValue != null) {
                ExtendedKeyUsage instance = ExtendedKeyUsage.getInstance(getObject(extensionValue));
                if (!instance.hasKeyPurposeId(KeyPurposeId.anyExtendedKeyUsage) && !instance.hasKeyPurposeId(KeyPurposeId.id_kp_emailProtection)) {
                    list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.extKeyUsageNotPermitted"));
                }
            }
            emailAddresses = getEmailAddresses(x509Certificate);
            if (!emailAddresses.isEmpty()) {
                list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.noEmailInCert"));
                return;
            }
            int i2 = 0;
            while (true) {
                String[] strArr = this.fromAddresses;
                if (i2 >= strArr.length) {
                    z = false;
                    break;
                } else if (emailAddresses.contains(strArr[i2].toLowerCase())) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.emailFromCertMismatch", new Object[]{new UntrustedInput(addressesToString(this.fromAddresses)), new UntrustedInput(emailAddresses)}));
                return;
            }
            return;
        }
        i = p.bitLength();
        list2.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.shortSigningKey", new Object[]{new Integer(i)}));
        if (x509Certificate.getNotAfter().getTime() - x509Certificate.getNotBefore().getTime() > THIRTY_YEARS_IN_MILLI_SEC) {
        }
        boolean[] keyUsage2 = x509Certificate.getKeyUsage();
        list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.signingNotPermitted"));
        try {
            extensionValue = x509Certificate.getExtensionValue(EXT_KEY_USAGE);
            if (extensionValue != null) {
            }
        } catch (Exception e) {
            list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.extKeyUsageError", new Object[]{e.getMessage(), e, e.getClass().getName()}));
        }
        try {
            emailAddresses = getEmailAddresses(x509Certificate);
            if (!emailAddresses.isEmpty()) {
            }
        } catch (Exception e2) {
            list.add(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.certGetEmailError", new Object[]{e2.getMessage(), e2, e2.getClass().getName()}));
        }
    }

    public CertStore getCertsAndCRLs() {
        return this.certs;
    }

    public SignerInformationStore getSignerInformationStore() {
        return this.signers;
    }

    public ValidationResult getValidationResult(SignerInformation signerInformation) throws SignedMailValidatorException {
        if (!this.signers.getSigners(signerInformation.getSID()).isEmpty()) {
            return (ValidationResult) this.results.get(signerInformation);
        }
        throw new SignedMailValidatorException(new ErrorBundle(RESOURCE_NAME, "SignedMailValidator.wrongSigner"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: org.bouncycastle.cms.SignerInformation */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8 A[SYNTHETIC, Splitter:B:29:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0159  */
    public void validateSignatures(java.security.cert.PKIXParameters r24) {
        /*
        // Method dump skipped, instructions count: 624
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.mail.smime.validator.SignedMailValidator.validateSignatures(java.security.cert.PKIXParameters):void");
    }
}
