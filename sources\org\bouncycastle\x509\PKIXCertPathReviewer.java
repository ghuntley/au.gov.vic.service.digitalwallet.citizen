package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.qualified.MonetaryValue;
import org.bouncycastle.asn1.x509.qualified.QCStatement;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.LocaleString;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.i18n.filter.UntrustedUrlInput;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.CertPathValidatorUtilities;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidator;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException;
import org.bouncycastle.jce.provider.PKIXPolicyNode;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String AUTH_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();
    private static final String CRL_DIST_POINTS = X509Extensions.CRLDistributionPoints.getId();
    private static final String QC_STATEMENT = X509Extensions.QCStatements.getId();
    private static final String RESOURCE_NAME = "org.bouncycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected List[] errors;
    private boolean initialized;
    protected int n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;

    public PKIXCertPathReviewer() {
    }

    public PKIXCertPathReviewer(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath2, pKIXParameters);
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & UByte.MAX_VALUE));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    private void checkCriticalExtensions() {
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        for (PKIXCertPathChecker pKIXCertPathChecker : certPathCheckers) {
            try {
                pKIXCertPathChecker.init(false);
            } catch (CertPathValidatorException e) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
            }
        }
        try {
            for (int size = this.certs.size() - 1; size >= 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
                Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
                if (criticalExtensionOIDs != null) {
                    if (!criticalExtensionOIDs.isEmpty()) {
                        criticalExtensionOIDs.remove(KEY_USAGE);
                        criticalExtensionOIDs.remove(CERTIFICATE_POLICIES);
                        criticalExtensionOIDs.remove(POLICY_MAPPINGS);
                        criticalExtensionOIDs.remove(INHIBIT_ANY_POLICY);
                        criticalExtensionOIDs.remove(ISSUING_DISTRIBUTION_POINT);
                        criticalExtensionOIDs.remove(DELTA_CRL_INDICATOR);
                        criticalExtensionOIDs.remove(POLICY_CONSTRAINTS);
                        criticalExtensionOIDs.remove(BASIC_CONSTRAINTS);
                        criticalExtensionOIDs.remove(SUBJECT_ALTERNATIVE_NAME);
                        criticalExtensionOIDs.remove(NAME_CONSTRAINTS);
                        String str = QC_STATEMENT;
                        if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                            criticalExtensionOIDs.remove(str);
                        }
                        for (PKIXCertPathChecker pKIXCertPathChecker2 : certPathCheckers) {
                            try {
                                pKIXCertPathChecker2.check(x509Certificate, criticalExtensionOIDs);
                            } catch (CertPathValidatorException e2) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e2.getMessage(), e2, e2.getClass().getName()}), e2.getCause(), this.certPath, size);
                            }
                        }
                        if (!criticalExtensionOIDs.isEmpty()) {
                            Iterator<String> it = criticalExtensionOIDs.iterator();
                            while (it.hasNext()) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new DERObjectIdentifier(it.next())}), size);
                            }
                        }
                    }
                }
            }
        } catch (CertPathReviewerException e3) {
            addError(e3.getErrorMessage(), e3.getIndex());
        }
    }

    private void checkNameConstraints() {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
                if (!isSelfIssued(x509Certificate)) {
                    X500Principal subjectPrincipal = getSubjectPrincipal(x509Certificate);
                    try {
                        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                        try {
                            pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                            try {
                                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                                try {
                                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME);
                                    if (aSN1Sequence2 != null) {
                                        for (int i = 0; i < aSN1Sequence2.size(); i++) {
                                            GeneralName instance = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(instance);
                                                pKIXNameConstraintValidator.checkExcluded(instance);
                                            } catch (PKIXNameConstraintValidatorException e) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(instance)}), e, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e2, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e3) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e4) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                        }
                    } catch (IOException e5) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e5, this.certPath, size);
                    }
                }
                try {
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) getExtensionValue(x509Certificate, NAME_CONSTRAINTS);
                    if (aSN1Sequence3 != null) {
                        NameConstraints nameConstraints = new NameConstraints(aSN1Sequence3);
                        ASN1Sequence permittedSubtrees = nameConstraints.getPermittedSubtrees();
                        if (permittedSubtrees != null) {
                            pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                        }
                        ASN1Sequence excludedSubtrees = nameConstraints.getExcludedSubtrees();
                        if (excludedSubtrees != null) {
                            Enumeration objects = excludedSubtrees.getObjects();
                            while (objects.hasMoreElements()) {
                                pKIXNameConstraintValidator.addExcludedSubtree(GeneralSubtree.getInstance(objects.nextElement()));
                            }
                        }
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e6, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int intValue;
        int i = this.n;
        int i2 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!isSelfIssued(x509Certificate)) {
                if (i <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLenghtExtended"));
                }
                i--;
                i2++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (!(basicConstraints == null || (pathLenConstraint = basicConstraints.getPathLenConstraint()) == null || (intValue = pathLenConstraint.intValue()) >= i)) {
                i = intValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{new Integer(i2)}));
    }

    private void checkPolicy() {
        int i;
        int i2;
        int i3;
        PKIXPolicyNode pKIXPolicyNode;
        int i4;
        int i5;
        String str;
        Set<String> set;
        HashSet hashSet;
        String str2;
        int i6;
        int intValue;
        String str3;
        HashSet hashSet2;
        HashSet hashSet3;
        String str4;
        int i7;
        String str5 = "CertPathReviewer.policyExtError";
        Set<String> initialPolicies = this.pkixParams.getInitialPolicies();
        int i8 = this.n + 1;
        ArrayList[] arrayListArr = new ArrayList[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            arrayListArr[i9] = new ArrayList();
        }
        HashSet hashSet4 = new HashSet();
        hashSet4.add("2.5.29.32.0");
        PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), 0, hashSet4, null, new HashSet(), "2.5.29.32.0", false);
        arrayListArr[0].add(pKIXPolicyNode2);
        if (this.pkixParams.isExplicitPolicyRequired()) {
            i2 = 0;
            i = 1;
        } else {
            i = 1;
            i2 = this.n + 1;
        }
        int i10 = this.pkixParams.isAnyPolicyInhibited() ? 0 : this.n + i;
        int i11 = this.pkixParams.isPolicyMappingInhibited() ? 0 : this.n + i;
        try {
            int size = this.certs.size() - i;
            PKIXPolicyNode pKIXPolicyNode3 = pKIXPolicyNode2;
            X509Certificate x509Certificate = null;
            HashSet hashSet5 = null;
            while (size >= 0) {
                int i12 = this.n - size;
                X509Certificate x509Certificate2 = (X509Certificate) this.certs.get(size);
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) getExtensionValue(x509Certificate2, CERTIFICATE_POLICIES);
                    if (aSN1Sequence == null || pKIXPolicyNode3 == null) {
                        set = initialPolicies;
                        str = str5;
                        i5 = i10;
                        i4 = i11;
                        pKIXPolicyNode3 = pKIXPolicyNode3;
                    } else {
                        Enumeration objects = aSN1Sequence.getObjects();
                        set = initialPolicies;
                        HashSet hashSet6 = new HashSet();
                        while (objects.hasMoreElements()) {
                            PolicyInformation instance = PolicyInformation.getInstance(objects.nextElement());
                            DERObjectIdentifier policyIdentifier = instance.getPolicyIdentifier();
                            hashSet6.add(policyIdentifier.getId());
                            if (!"2.5.29.32.0".equals(policyIdentifier.getId())) {
                                try {
                                    Set qualifierSet = getQualifierSet(instance.getPolicyQualifiers());
                                    if (!processCertD1i(i12, arrayListArr, policyIdentifier, qualifierSet)) {
                                        processCertD1ii(i12, arrayListArr, policyIdentifier, qualifierSet);
                                    }
                                } catch (CertPathValidatorException e) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e, this.certPath, size);
                                }
                            }
                            pKIXPolicyNode3 = pKIXPolicyNode3;
                            str5 = str5;
                        }
                        str = str5;
                        if (hashSet5 == null || hashSet5.contains("2.5.29.32.0")) {
                            hashSet2 = hashSet6;
                        } else {
                            hashSet2 = new HashSet();
                            for (Object obj : hashSet5) {
                                if (hashSet6.contains(obj)) {
                                    hashSet2.add(obj);
                                }
                            }
                        }
                        if (i10 > 0 || (i12 < this.n && isSelfIssued(x509Certificate2))) {
                            Enumeration objects2 = aSN1Sequence.getObjects();
                            while (true) {
                                if (!objects2.hasMoreElements()) {
                                    break;
                                }
                                PolicyInformation instance2 = PolicyInformation.getInstance(objects2.nextElement());
                                if ("2.5.29.32.0".equals(instance2.getPolicyIdentifier().getId())) {
                                    try {
                                        Set qualifierSet2 = getQualifierSet(instance2.getPolicyQualifiers());
                                        ArrayList arrayList = arrayListArr[i12 - 1];
                                        hashSet3 = hashSet2;
                                        for (int i13 = 0; i13 < arrayList.size(); i13++) {
                                            PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) arrayList.get(i13);
                                            for (Object obj2 : pKIXPolicyNode4.getExpectedPolicies()) {
                                                if (obj2 instanceof String) {
                                                    str4 = (String) obj2;
                                                } else if (obj2 instanceof DERObjectIdentifier) {
                                                    str4 = ((DERObjectIdentifier) obj2).getId();
                                                } else {
                                                    arrayList = arrayList;
                                                    i10 = i10;
                                                }
                                                boolean z = false;
                                                for (Iterator children = pKIXPolicyNode4.getChildren(); children.hasNext(); children = children) {
                                                    if (str4.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                                        z = true;
                                                    }
                                                }
                                                if (!z) {
                                                    HashSet hashSet7 = new HashSet();
                                                    hashSet7.add(str4);
                                                    i7 = i11;
                                                    PKIXPolicyNode pKIXPolicyNode5 = new PKIXPolicyNode(new ArrayList(), i12, hashSet7, pKIXPolicyNode4, qualifierSet2, str4, false);
                                                    pKIXPolicyNode4.addChild(pKIXPolicyNode5);
                                                    arrayListArr[i12].add(pKIXPolicyNode5);
                                                } else {
                                                    i7 = i11;
                                                }
                                                arrayList = arrayList;
                                                i10 = i10;
                                                i11 = i7;
                                            }
                                        }
                                        i5 = i10;
                                        i4 = i11;
                                    } catch (CertPathValidatorException e2) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e2, this.certPath, size);
                                    }
                                }
                            }
                        }
                        i5 = i10;
                        i4 = i11;
                        hashSet3 = hashSet2;
                        pKIXPolicyNode3 = pKIXPolicyNode3;
                        for (int i14 = i12 - 1; i14 >= 0; i14--) {
                            ArrayList arrayList2 = arrayListArr[i14];
                            for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                                PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) arrayList2.get(i15);
                                if (!pKIXPolicyNode6.hasChildren()) {
                                    PKIXPolicyNode removePolicyNode = removePolicyNode(pKIXPolicyNode3, arrayListArr, pKIXPolicyNode6);
                                    pKIXPolicyNode3 = removePolicyNode;
                                    if (removePolicyNode == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs != null) {
                            boolean contains = criticalExtensionOIDs.contains(CERTIFICATE_POLICIES);
                            ArrayList arrayList3 = arrayListArr[i12];
                            for (int i16 = 0; i16 < arrayList3.size(); i16++) {
                                ((PKIXPolicyNode) arrayList3.get(i16)).setCritical(contains);
                            }
                        }
                        hashSet5 = hashSet3;
                    }
                    if (aSN1Sequence == null) {
                        pKIXPolicyNode3 = null;
                    }
                    if (i2 > 0 || pKIXPolicyNode3 != null) {
                        if (i12 != this.n) {
                            try {
                                DERObject extensionValue = getExtensionValue(x509Certificate2, POLICY_MAPPINGS);
                                if (extensionValue != null) {
                                    int i17 = 0;
                                    for (ASN1Sequence aSN1Sequence2 = (ASN1Sequence) extensionValue; i17 < aSN1Sequence2.size(); aSN1Sequence2 = aSN1Sequence2) {
                                        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(i17);
                                        DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) aSN1Sequence3.getObjectAt(1);
                                        if ("2.5.29.32.0".equals(((DERObjectIdentifier) aSN1Sequence3.getObjectAt(0)).getId())) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                        } else if (!"2.5.29.32.0".equals(dERObjectIdentifier.getId())) {
                                            i17++;
                                        } else {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicyMapping"), this.certPath, size);
                                        }
                                    }
                                }
                                if (extensionValue != null) {
                                    ASN1Sequence aSN1Sequence4 = (ASN1Sequence) extensionValue;
                                    HashMap hashMap = new HashMap();
                                    HashSet<String> hashSet8 = new HashSet();
                                    int i18 = 0;
                                    while (i18 < aSN1Sequence4.size()) {
                                        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence4.getObjectAt(i18);
                                        String id = ((DERObjectIdentifier) aSN1Sequence5.getObjectAt(0)).getId();
                                        String id2 = ((DERObjectIdentifier) aSN1Sequence5.getObjectAt(1)).getId();
                                        if (!hashMap.containsKey(id)) {
                                            HashSet hashSet9 = new HashSet();
                                            hashSet9.add(id2);
                                            hashMap.put(id, hashSet9);
                                            hashSet8.add(id);
                                        } else {
                                            ((Set) hashMap.get(id)).add(id2);
                                        }
                                        i18++;
                                        aSN1Sequence4 = aSN1Sequence4;
                                        hashSet5 = hashSet5;
                                    }
                                    hashSet = hashSet5;
                                    for (String str6 : hashSet8) {
                                        if (i4 > 0) {
                                            try {
                                                prepareNextCertB1(i12, arrayListArr, str6, hashMap, x509Certificate2);
                                                str3 = str;
                                            } catch (AnnotatedException e3) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, str), e3, this.certPath, size);
                                            } catch (CertPathValidatorException e4) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyQualifierError"), e4, this.certPath, size);
                                            }
                                        } else {
                                            str3 = str;
                                            if (i4 <= 0) {
                                                pKIXPolicyNode3 = prepareNextCertB2(i12, arrayListArr, str6, pKIXPolicyNode3);
                                            }
                                        }
                                        str = str3;
                                    }
                                } else {
                                    hashSet = hashSet5;
                                }
                                str2 = str;
                                if (!isSelfIssued(x509Certificate2)) {
                                    if (i2 != 0) {
                                        i2--;
                                    }
                                    i11 = i4 != 0 ? i4 - 1 : i4;
                                    i6 = i5 != 0 ? i5 - 1 : i5;
                                } else {
                                    i6 = i5;
                                    i11 = i4;
                                }
                                try {
                                    ASN1Sequence aSN1Sequence6 = (ASN1Sequence) getExtensionValue(x509Certificate2, POLICY_CONSTRAINTS);
                                    if (aSN1Sequence6 != null) {
                                        Enumeration objects3 = aSN1Sequence6.getObjects();
                                        while (objects3.hasMoreElements()) {
                                            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects3.nextElement();
                                            int tagNo = aSN1TaggedObject.getTagNo();
                                            if (tagNo == 0) {
                                                int intValue2 = DERInteger.getInstance(aSN1TaggedObject, false).getValue().intValue();
                                                if (intValue2 < i2) {
                                                    i2 = intValue2;
                                                }
                                            } else if (tagNo == 1) {
                                                int intValue3 = DERInteger.getInstance(aSN1TaggedObject, false).getValue().intValue();
                                                if (intValue3 < i11) {
                                                    i11 = intValue3;
                                                }
                                            }
                                        }
                                    }
                                    try {
                                        DERInteger dERInteger = (DERInteger) getExtensionValue(x509Certificate2, INHIBIT_ANY_POLICY);
                                        if (dERInteger != null && (intValue = dERInteger.getValue().intValue()) < i6) {
                                            i6 = intValue;
                                        }
                                    } catch (AnnotatedException unused) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyInhibitExtError"), this.certPath, size);
                                    }
                                } catch (AnnotatedException unused2) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyConstExtError"), this.certPath, size);
                                }
                            } catch (AnnotatedException e5) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyMapExtError"), e5, this.certPath, size);
                            }
                        } else {
                            hashSet = hashSet5;
                            str2 = str;
                            i6 = i5;
                            i11 = i4;
                        }
                        size--;
                        x509Certificate = x509Certificate2;
                        str5 = str2;
                        hashSet5 = hashSet;
                        i8 = i8;
                        i10 = i6;
                        initialPolicies = set;
                    } else {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noValidPolicyTree"));
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, str5), e6, this.certPath, size);
                }
            }
            Set<String> set2 = initialPolicies;
            int i19 = i8;
            if (!isSelfIssued(x509Certificate) && i2 > 0) {
                i2--;
            }
            try {
                ASN1Sequence aSN1Sequence7 = (ASN1Sequence) getExtensionValue(x509Certificate, POLICY_CONSTRAINTS);
                if (aSN1Sequence7 != null) {
                    Enumeration objects4 = aSN1Sequence7.getObjects();
                    int i20 = i2;
                    while (objects4.hasMoreElements()) {
                        ASN1TaggedObject aSN1TaggedObject2 = (ASN1TaggedObject) objects4.nextElement();
                        if (aSN1TaggedObject2.getTagNo() == 0) {
                            if (DERInteger.getInstance(aSN1TaggedObject2, false).getValue().intValue() == 0) {
                                i20 = 0;
                            }
                        }
                    }
                    i3 = 0;
                    i2 = i20;
                } else {
                    i3 = 0;
                }
                if (pKIXPolicyNode3 == null) {
                    if (!this.pkixParams.isExplicitPolicyRequired()) {
                        pKIXPolicyNode = null;
                    } else {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.explicitPolicy"), this.certPath, size);
                    }
                } else if (isAnyPolicy(set2)) {
                    if (this.pkixParams.isExplicitPolicyRequired()) {
                        if (!hashSet5.isEmpty()) {
                            HashSet<PKIXPolicyNode> hashSet10 = new HashSet();
                            int i21 = i3;
                            while (i21 < i19) {
                                ArrayList arrayList4 = arrayListArr[i21];
                                for (int i22 = i3; i22 < arrayList4.size(); i22++) {
                                    PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) arrayList4.get(i22);
                                    if ("2.5.29.32.0".equals(pKIXPolicyNode7.getValidPolicy())) {
                                        Iterator children2 = pKIXPolicyNode7.getChildren();
                                        while (children2.hasNext()) {
                                            hashSet10.add(children2.next());
                                        }
                                    }
                                }
                                i21++;
                                i19 = i19;
                            }
                            for (PKIXPolicyNode pKIXPolicyNode8 : hashSet10) {
                                hashSet5.contains(pKIXPolicyNode8.getValidPolicy());
                            }
                            if (pKIXPolicyNode3 != null) {
                                pKIXPolicyNode = pKIXPolicyNode3;
                                for (int i23 = this.n - 1; i23 >= 0; i23--) {
                                    ArrayList arrayList5 = arrayListArr[i23];
                                    for (int i24 = i3; i24 < arrayList5.size(); i24++) {
                                        PKIXPolicyNode pKIXPolicyNode9 = (PKIXPolicyNode) arrayList5.get(i24);
                                        if (!pKIXPolicyNode9.hasChildren()) {
                                            pKIXPolicyNode = removePolicyNode(pKIXPolicyNode, arrayListArr, pKIXPolicyNode9);
                                        }
                                    }
                                }
                            }
                        } else {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.explicitPolicy"), this.certPath, size);
                        }
                    }
                    pKIXPolicyNode = pKIXPolicyNode3;
                } else {
                    HashSet<PKIXPolicyNode> hashSet11 = new HashSet();
                    for (int i25 = i3; i25 < i19; i25++) {
                        ArrayList arrayList6 = arrayListArr[i25];
                        for (int i26 = i3; i26 < arrayList6.size(); i26++) {
                            PKIXPolicyNode pKIXPolicyNode10 = (PKIXPolicyNode) arrayList6.get(i26);
                            if ("2.5.29.32.0".equals(pKIXPolicyNode10.getValidPolicy())) {
                                Iterator children3 = pKIXPolicyNode10.getChildren();
                                while (children3.hasNext()) {
                                    PKIXPolicyNode pKIXPolicyNode11 = (PKIXPolicyNode) children3.next();
                                    if (!"2.5.29.32.0".equals(pKIXPolicyNode11.getValidPolicy())) {
                                        hashSet11.add(pKIXPolicyNode11);
                                    }
                                }
                            }
                        }
                    }
                    pKIXPolicyNode = pKIXPolicyNode3;
                    for (PKIXPolicyNode pKIXPolicyNode12 : hashSet11) {
                        if (!set2.contains(pKIXPolicyNode12.getValidPolicy())) {
                            pKIXPolicyNode = removePolicyNode(pKIXPolicyNode, arrayListArr, pKIXPolicyNode12);
                        }
                        set2 = set2;
                    }
                    if (pKIXPolicyNode != null) {
                        for (int i27 = this.n - 1; i27 >= 0; i27--) {
                            ArrayList arrayList7 = arrayListArr[i27];
                            for (int i28 = i3; i28 < arrayList7.size(); i28++) {
                                PKIXPolicyNode pKIXPolicyNode13 = (PKIXPolicyNode) arrayList7.get(i28);
                                if (!pKIXPolicyNode13.hasChildren()) {
                                    pKIXPolicyNode = removePolicyNode(pKIXPolicyNode, arrayListArr, pKIXPolicyNode13);
                                }
                            }
                        }
                    }
                }
                if (i2 <= 0 && pKIXPolicyNode == null) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.invalidPolicy"));
                }
            } catch (AnnotatedException unused3) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyConstExtError"), this.certPath, size);
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x02cb A[LOOP:1: B:103:0x02c5->B:105:0x02cb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02f4 A[LOOP:2: B:107:0x02ee->B:109:0x02f4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0287 A[SYNTHETIC, Splitter:B:88:0x0287] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02a9 A[Catch:{ AnnotatedException -> 0x02ae }] */
    private void checkSignatures() {
        TrustAnchor trustAnchor2;
        TrustAnchor trustAnchor3;
        X500Principal x500Principal;
        PublicKey publicKey;
        X509Certificate x509Certificate;
        X509Certificate x509Certificate2;
        X500Principal x500Principal2;
        PublicKey publicKey2;
        int size;
        X509Certificate x509Certificate3;
        PublicKey publicKey3;
        int i;
        X509Certificate x509Certificate4;
        int i2;
        X500Principal x500Principal3;
        TrustAnchor trustAnchor4;
        char c;
        char c2;
        char c3;
        CRLDistPoint cRLDistPoint;
        AuthorityInformationAccess authorityInformationAccess;
        Iterator it;
        Iterator it2;
        CertPathReviewerException e;
        DERObject extensionValue;
        ErrorBundle errorBundle;
        ErrorBundle errorBundle2;
        boolean[] keyUsage;
        CertPathReviewerException e2;
        Throwable th;
        char c4 = 2;
        char c5 = 0;
        char c6 = 1;
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathValidDate", new Object[]{new TrustedInput(this.validDate), new TrustedInput(new Date())}));
        try {
            List list = this.certs;
            X509Certificate x509Certificate5 = (X509Certificate) list.get(list.size() - 1);
            Collection trustAnchors = getTrustAnchors(x509Certificate5, this.pkixParams.getTrustAnchors());
            if (trustAnchors.size() > 1) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.conflictingTrustAnchors", new Object[]{new Integer(trustAnchors.size()), new UntrustedInput(x509Certificate5.getIssuerX500Principal())}));
            } else if (trustAnchors.isEmpty()) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noTrustAnchorFound", new Object[]{new UntrustedInput(x509Certificate5.getIssuerX500Principal()), new Integer(this.pkixParams.getTrustAnchors().size())}));
            } else {
                trustAnchor2 = (TrustAnchor) trustAnchors.iterator().next();
                try {
                    try {
                        CertPathValidatorUtilities.verifyX509Certificate(x509Certificate5, trustAnchor2.getTrustedCert() != null ? trustAnchor2.getTrustedCert().getPublicKey() : trustAnchor2.getCAPublicKey(), this.pkixParams.getSigProvider());
                    } catch (SignatureException unused) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustButInvalidCert"));
                    } catch (Exception unused2) {
                    }
                } catch (CertPathReviewerException e3) {
                    e2 = e3;
                    addError(e2.getErrorMessage());
                    trustAnchor3 = trustAnchor2;
                    if (trustAnchor3 == null) {
                    }
                    if (trustAnchor3 == null) {
                    }
                    x509Certificate2 = x509Certificate;
                    x500Principal2 = x500Principal;
                    publicKey2 = publicKey;
                    size = this.certs.size() - 1;
                    while (size >= 0) {
                    }
                    this.trustAnchor = trustAnchor3;
                    this.subjectPublicKey = publicKey2;
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknown", new Object[]{new UntrustedInput(th.getMessage()), new UntrustedInput(th)}));
                    trustAnchor3 = trustAnchor2;
                    if (trustAnchor3 == null) {
                    }
                    if (trustAnchor3 == null) {
                    }
                    x509Certificate2 = x509Certificate;
                    x500Principal2 = x500Principal;
                    publicKey2 = publicKey;
                    size = this.certs.size() - 1;
                    while (size >= 0) {
                    }
                    this.trustAnchor = trustAnchor3;
                    this.subjectPublicKey = publicKey2;
                    return;
                }
                trustAnchor3 = trustAnchor2;
                if (trustAnchor3 == null) {
                    X509Certificate trustedCert = trustAnchor3.getTrustedCert();
                    if (trustedCert != null) {
                        try {
                            x500Principal = getSubjectPrincipal(trustedCert);
                        } catch (IllegalArgumentException unused3) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustDNInvalid", new Object[]{new UntrustedInput(trustAnchor3.getCAName())}));
                            x500Principal = null;
                        }
                    } else {
                        x500Principal = new X500Principal(trustAnchor3.getCAName());
                    }
                    if (!(trustedCert == null || (keyUsage = trustedCert.getKeyUsage()) == null || keyUsage[5])) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustKeyUsage"));
                    }
                } else {
                    x500Principal = null;
                }
                if (trustAnchor3 == null) {
                    x509Certificate = trustAnchor3.getTrustedCert();
                    publicKey = x509Certificate != null ? x509Certificate.getPublicKey() : trustAnchor3.getCAPublicKey();
                    try {
                        AlgorithmIdentifier algorithmIdentifier = getAlgorithmIdentifier(publicKey);
                        algorithmIdentifier.getObjectId();
                        algorithmIdentifier.getParameters();
                    } catch (CertPathValidatorException unused4) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustPubKeyError"));
                    }
                } else {
                    x509Certificate = null;
                    publicKey = null;
                }
                x509Certificate2 = x509Certificate;
                x500Principal2 = x500Principal;
                publicKey2 = publicKey;
                size = this.certs.size() - 1;
                while (size >= 0) {
                    int i3 = this.n - size;
                    x509Certificate3 = (X509Certificate) this.certs.get(size);
                    if (publicKey2 != null) {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate3, publicKey2, this.pkixParams.getSigProvider());
                        } catch (GeneralSecurityException e4) {
                            Object[] objArr = new Object[3];
                            objArr[c5] = e4.getMessage();
                            objArr[c6] = e4;
                            objArr[c4] = e4.getClass().getName();
                            errorBundle2 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.signatureNotVerified", objArr);
                        }
                    } else if (isSelfIssued(x509Certificate3)) {
                        try {
                            CertPathValidatorUtilities.verifyX509Certificate(x509Certificate3, x509Certificate3.getPublicKey(), this.pkixParams.getSigProvider());
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.rootKeyIsValidButNotATrustAnchor"), size);
                        } catch (GeneralSecurityException e5) {
                            Object[] objArr2 = new Object[3];
                            objArr2[c5] = e5.getMessage();
                            objArr2[c6] = e5;
                            objArr2[c4] = e5.getClass().getName();
                            errorBundle2 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.signatureNotVerified", objArr2);
                        }
                    } else {
                        ErrorBundle errorBundle3 = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.NoIssuerPublicKey");
                        byte[] extensionValue2 = x509Certificate3.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
                        if (extensionValue2 != null) {
                            try {
                                AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(X509ExtensionUtil.fromExtensionValue(extensionValue2));
                                GeneralNames authorityCertIssuer = instance.getAuthorityCertIssuer();
                                if (authorityCertIssuer != null) {
                                    GeneralName generalName = authorityCertIssuer.getNames()[c5];
                                    BigInteger authorityCertSerialNumber = instance.getAuthorityCertSerialNumber();
                                    if (authorityCertSerialNumber != null) {
                                        Object[] objArr3 = new Object[7];
                                        objArr3[c5] = new LocaleString(RESOURCE_NAME, "missingIssuer");
                                        objArr3[1] = " \"";
                                        objArr3[2] = generalName;
                                        objArr3[3] = "\" ";
                                        objArr3[4] = new LocaleString(RESOURCE_NAME, "missingSerial");
                                        objArr3[5] = " ";
                                        objArr3[6] = authorityCertSerialNumber;
                                        errorBundle3.setExtraArguments(objArr3);
                                    }
                                }
                            } catch (IOException unused5) {
                            }
                        }
                        addError(errorBundle3, size);
                    }
                    try {
                        x509Certificate3.checkValidity(this.validDate);
                    } catch (CertificateNotYetValidException unused6) {
                        Object[] objArr4 = new Object[1];
                        objArr4[c5] = new TrustedInput(x509Certificate3.getNotBefore());
                        errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certificateNotYetValid", objArr4);
                    } catch (CertificateExpiredException unused7) {
                        Object[] objArr5 = new Object[1];
                        objArr5[c5] = new TrustedInput(x509Certificate3.getNotAfter());
                        errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certificateExpired", objArr5);
                    }
                    if (this.pkixParams.isRevocationEnabled()) {
                        try {
                            DERObject extensionValue3 = getExtensionValue(x509Certificate3, CRL_DIST_POINTS);
                            if (extensionValue3 != null) {
                                cRLDistPoint = CRLDistPoint.getInstance(extensionValue3);
                                extensionValue = getExtensionValue(x509Certificate3, AUTH_INFO_ACCESS);
                                if (extensionValue != null) {
                                    authorityInformationAccess = AuthorityInformationAccess.getInstance(extensionValue);
                                    Vector cRLDistUrls = getCRLDistUrls(cRLDistPoint);
                                    Vector oCSPUrls = getOCSPUrls(authorityInformationAccess);
                                    it = cRLDistUrls.iterator();
                                    while (it.hasNext()) {
                                        Object[] objArr6 = new Object[1];
                                        objArr6[c5] = new UntrustedUrlInput(it.next());
                                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlDistPoint", objArr6), size);
                                        x509Certificate3 = x509Certificate3;
                                    }
                                    it2 = oCSPUrls.iterator();
                                    while (it2.hasNext()) {
                                        Object[] objArr7 = new Object[1];
                                        objArr7[c5] = new UntrustedUrlInput(it2.next());
                                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ocspLocation", objArr7), size);
                                    }
                                    x509Certificate4 = x509Certificate3;
                                    i = i3;
                                    i2 = size;
                                    publicKey3 = publicKey2;
                                    x500Principal3 = x500Principal2;
                                    trustAnchor4 = trustAnchor3;
                                    checkRevocation(this.pkixParams, x509Certificate4, this.validDate, x509Certificate2, publicKey2, cRLDistUrls, oCSPUrls, i2);
                                }
                                authorityInformationAccess = null;
                                Vector cRLDistUrls2 = getCRLDistUrls(cRLDistPoint);
                                Vector oCSPUrls2 = getOCSPUrls(authorityInformationAccess);
                                it = cRLDistUrls2.iterator();
                                while (it.hasNext()) {
                                }
                                it2 = oCSPUrls2.iterator();
                                while (it2.hasNext()) {
                                }
                                x509Certificate4 = x509Certificate3;
                                i = i3;
                                i2 = size;
                                publicKey3 = publicKey2;
                                x500Principal3 = x500Principal2;
                                trustAnchor4 = trustAnchor3;
                                checkRevocation(this.pkixParams, x509Certificate4, this.validDate, x509Certificate2, publicKey2, cRLDistUrls2, oCSPUrls2, i2);
                            }
                        } catch (AnnotatedException unused8) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlDistPtExtError"), size);
                        }
                        cRLDistPoint = null;
                        try {
                            extensionValue = getExtensionValue(x509Certificate3, AUTH_INFO_ACCESS);
                            if (extensionValue != null) {
                            }
                        } catch (AnnotatedException unused9) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlAuthInfoAccError"), size);
                        }
                        authorityInformationAccess = null;
                        Vector cRLDistUrls22 = getCRLDistUrls(cRLDistPoint);
                        Vector oCSPUrls22 = getOCSPUrls(authorityInformationAccess);
                        it = cRLDistUrls22.iterator();
                        while (it.hasNext()) {
                        }
                        it2 = oCSPUrls22.iterator();
                        while (it2.hasNext()) {
                        }
                        try {
                            x509Certificate4 = x509Certificate3;
                            i = i3;
                            i2 = size;
                            publicKey3 = publicKey2;
                            x500Principal3 = x500Principal2;
                            trustAnchor4 = trustAnchor3;
                            try {
                                checkRevocation(this.pkixParams, x509Certificate4, this.validDate, x509Certificate2, publicKey2, cRLDistUrls22, oCSPUrls22, i2);
                            } catch (CertPathReviewerException e6) {
                                e = e6;
                            }
                        } catch (CertPathReviewerException e7) {
                            e = e7;
                            i = i3;
                            i2 = size;
                            publicKey3 = publicKey2;
                            x500Principal3 = x500Principal2;
                            trustAnchor4 = trustAnchor3;
                            x509Certificate4 = x509Certificate3;
                            addError(e.getErrorMessage(), i2);
                            if (x500Principal3 != null) {
                            }
                            c2 = 2;
                            c = 0;
                            if (i == this.n) {
                            }
                            x500Principal2 = x509Certificate4.getSubjectX500Principal();
                            publicKey2 = getNextWorkingKey(this.certs, i2);
                            try {
                                AlgorithmIdentifier algorithmIdentifier2 = getAlgorithmIdentifier(publicKey2);
                                algorithmIdentifier2.getObjectId();
                                algorithmIdentifier2.getParameters();
                            } catch (CertPathValidatorException unused10) {
                            }
                            size = i2 - 1;
                            c6 = c3;
                            c5 = c;
                            trustAnchor3 = trustAnchor4;
                            x509Certificate2 = x509Certificate4;
                            c4 = c2;
                        }
                    } else {
                        x509Certificate4 = x509Certificate3;
                        i = i3;
                        i2 = size;
                        publicKey3 = publicKey2;
                        x500Principal3 = x500Principal2;
                        trustAnchor4 = trustAnchor3;
                    }
                    if (x500Principal3 != null || x509Certificate4.getIssuerX500Principal().equals(x500Principal3)) {
                        c2 = 2;
                        c = 0;
                    } else {
                        c2 = 2;
                        c = 0;
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certWrongIssuer", new Object[]{x500Principal3.getName(), x509Certificate4.getIssuerX500Principal().getName()}), i2);
                    }
                    if (i == this.n) {
                        if (x509Certificate4 != null) {
                            c3 = 1;
                            if (x509Certificate4.getVersion() == 1) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCACert"), i2);
                            }
                        } else {
                            c3 = 1;
                        }
                        try {
                            BasicConstraints instance2 = BasicConstraints.getInstance(getExtensionValue(x509Certificate4, BASIC_CONSTRAINTS));
                            if (instance2 == null) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noBasicConstraints"), i2);
                            } else if (!instance2.isCA()) {
                                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCACert"), i2);
                            }
                        } catch (AnnotatedException unused11) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.errorProcesingBC"), i2);
                        }
                        boolean[] keyUsage2 = x509Certificate4.getKeyUsage();
                        if (keyUsage2 != null && !keyUsage2[5]) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCertSign"), i2);
                        }
                    } else {
                        c3 = 1;
                    }
                    x500Principal2 = x509Certificate4.getSubjectX500Principal();
                    try {
                        publicKey2 = getNextWorkingKey(this.certs, i2);
                        AlgorithmIdentifier algorithmIdentifier22 = getAlgorithmIdentifier(publicKey2);
                        algorithmIdentifier22.getObjectId();
                        algorithmIdentifier22.getParameters();
                    } catch (CertPathValidatorException unused12) {
                        publicKey2 = publicKey3;
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pubKeyError"), i2);
                        size = i2 - 1;
                        c6 = c3;
                        c5 = c;
                        trustAnchor3 = trustAnchor4;
                        x509Certificate2 = x509Certificate4;
                        c4 = c2;
                    }
                    size = i2 - 1;
                    c6 = c3;
                    c5 = c;
                    trustAnchor3 = trustAnchor4;
                    x509Certificate2 = x509Certificate4;
                    c4 = c2;
                }
                this.trustAnchor = trustAnchor3;
                this.subjectPublicKey = publicKey2;
                return;
            }
            trustAnchor2 = null;
        } catch (CertPathReviewerException e8) {
            e2 = e8;
            trustAnchor2 = null;
            addError(e2.getErrorMessage());
            trustAnchor3 = trustAnchor2;
            if (trustAnchor3 == null) {
            }
            if (trustAnchor3 == null) {
            }
            x509Certificate2 = x509Certificate;
            x500Principal2 = x500Principal;
            publicKey2 = publicKey;
            size = this.certs.size() - 1;
            while (size >= 0) {
            }
            this.trustAnchor = trustAnchor3;
            this.subjectPublicKey = publicKey2;
            return;
        } catch (Throwable th3) {
            th = th3;
            trustAnchor2 = null;
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknown", new Object[]{new UntrustedInput(th.getMessage()), new UntrustedInput(th)}));
            trustAnchor3 = trustAnchor2;
            if (trustAnchor3 == null) {
            }
            if (trustAnchor3 == null) {
            }
            x509Certificate2 = x509Certificate;
            x500Principal2 = x500Principal;
            publicKey2 = publicKey;
            size = this.certs.size() - 1;
            while (size >= 0) {
            }
            this.trustAnchor = trustAnchor3;
            this.subjectPublicKey = publicKey2;
            return;
        }
        trustAnchor3 = trustAnchor2;
        if (trustAnchor3 == null) {
        }
        if (trustAnchor3 == null) {
        }
        x509Certificate2 = x509Certificate;
        x500Principal2 = x500Principal;
        publicKey2 = publicKey;
        size = this.certs.size() - 1;
        while (size >= 0) {
        }
        this.trustAnchor = trustAnchor3;
        this.subjectPublicKey = publicKey2;
        return;
        addError(errorBundle, size);
        if (this.pkixParams.isRevocationEnabled()) {
        }
        if (x500Principal3 != null) {
        }
        c2 = 2;
        c = 0;
        if (i == this.n) {
        }
        x500Principal2 = x509Certificate4.getSubjectX500Principal();
        publicKey2 = getNextWorkingKey(this.certs, i2);
        AlgorithmIdentifier algorithmIdentifier222 = getAlgorithmIdentifier(publicKey2);
        algorithmIdentifier222.getObjectId();
        algorithmIdentifier222.getParameters();
        size = i2 - 1;
        c6 = c3;
        c5 = c;
        trustAnchor3 = trustAnchor4;
        x509Certificate2 = x509Certificate4;
        c4 = c2;
        addError(errorBundle2, size);
        x509Certificate3.checkValidity(this.validDate);
        if (this.pkixParams.isRevocationEnabled()) {
        }
        if (x500Principal3 != null) {
        }
        c2 = 2;
        c = 0;
        if (i == this.n) {
        }
        x500Principal2 = x509Certificate4.getSubjectX500Principal();
        publicKey2 = getNextWorkingKey(this.certs, i2);
        AlgorithmIdentifier algorithmIdentifier2222 = getAlgorithmIdentifier(publicKey2);
        algorithmIdentifier2222.getObjectId();
        algorithmIdentifier2222.getParameters();
        size = i2 - 1;
        c6 = c3;
        c5 = c;
        trustAnchor3 = trustAnchor4;
        x509Certificate2 = x509Certificate4;
        c4 = c2;
    }

    private X509CRL getCRL(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http")) {
                if (!url.getProtocol().equals("https")) {
                    return null;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", "BC").generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                QCStatement instance = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (QCStatement.id_etsi_qcs_QcCompliance.equals(instance.getStatementId())) {
                    errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance");
                } else {
                    if (!QCStatement.id_qcs_pkixQCSyntax_v1.equals(instance.getStatementId())) {
                        if (QCStatement.id_etsi_qcs_QcSSCD.equals(instance.getStatementId())) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD");
                        } else if (QCStatement.id_etsi_qcs_LimiteValue.equals(instance.getStatementId())) {
                            MonetaryValue instance2 = MonetaryValue.getInstance(instance.getStatementInfo());
                            instance2.getCurrency();
                            double doubleValue = instance2.getAmount().doubleValue() * Math.pow(10.0d, instance2.getExponent().doubleValue());
                            addNotification(instance2.getCurrency().isAlphabetic() ? new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{instance2.getCurrency().getAlphabetic(), new TrustedInput(new Double(doubleValue)), instance2}) : new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{new Integer(instance2.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), instance2}), i);
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{instance.getStatementId(), new UntrustedInput(instance)}), i);
                            z = true;
                        }
                    }
                }
                addNotification(errorBundle, i);
            }
            return true ^ z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03b2, code lost:
        r12 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02bf  */
    public void checkCRLs(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, int i) throws CertPathReviewerException {
        Iterator it;
        X509CRL x509crl;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        boolean[] keyUsage;
        Iterator it2;
        X509CRL x509crl2;
        CertPathReviewerException e;
        boolean z6;
        Iterator it3;
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            x509CRLStoreSelector.addIssuerName(getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            x509CRLStoreSelector.setCertificateChecking(x509Certificate);
            try {
                Set findCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, pKIXParameters);
                Iterator it4 = findCRLs.iterator();
                if (findCRLs.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (X509CRL x509crl3 : CRL_UTIL.findCRLs(new X509CRLStoreSelector(), pKIXParameters)) {
                        arrayList.add(x509crl3.getIssuerX500Principal());
                    }
                    it3 = it4;
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCrlInCertstore", new Object[]{new UntrustedInput(x509CRLStoreSelector.getIssuerNames()), new UntrustedInput(arrayList), new Integer(arrayList.size())}), i);
                } else {
                    it3 = it4;
                }
                it = it3;
            } catch (AnnotatedException e2) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError", new Object[]{e2.getCause().getMessage(), e2.getCause(), e2.getCause().getClass().getName()}), i);
                it = new ArrayList().iterator();
            }
            X509CRL x509crl4 = null;
            while (true) {
                if (!it.hasNext()) {
                    x509crl = x509crl4;
                    z = false;
                    break;
                }
                x509crl4 = (X509CRL) it.next();
                if (x509crl4.getNextUpdate() == null || new Date().before(x509crl4.getNextUpdate())) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.localValidCRL", new Object[]{new TrustedInput(x509crl4.getThisUpdate()), new TrustedInput(x509crl4.getNextUpdate())}), i);
                    x509crl = x509crl4;
                    z = true;
                } else {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.localInvalidCRL", new Object[]{new TrustedInput(x509crl4.getThisUpdate()), new TrustedInput(x509crl4.getNextUpdate())}), i);
                }
            }
            if (!z) {
                Iterator it5 = vector.iterator();
                boolean z7 = z;
                while (true) {
                    if (!it5.hasNext()) {
                        z2 = z7;
                        break;
                    }
                    try {
                        String str2 = (String) it5.next();
                        X509CRL crl = getCRL(str2);
                        if (crl == null) {
                            x509crl2 = x509crl;
                            it2 = it5;
                        } else if (!x509Certificate.getIssuerX500Principal().equals(crl.getIssuerX500Principal())) {
                            try {
                                x509crl2 = x509crl;
                                it2 = it5;
                                try {
                                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineCRLWrongCA", new Object[]{new UntrustedInput(crl.getIssuerX500Principal().getName()), new UntrustedInput(x509Certificate.getIssuerX500Principal().getName()), new UntrustedUrlInput(str2)}), i);
                                } catch (CertPathReviewerException e3) {
                                    e = e3;
                                    addNotification(e.getErrorMessage(), i);
                                    it5 = it2;
                                    x509crl = x509crl2;
                                }
                            } catch (CertPathReviewerException e4) {
                                e = e4;
                                x509crl2 = x509crl;
                                it2 = it5;
                                addNotification(e.getErrorMessage(), i);
                                it5 = it2;
                                x509crl = x509crl2;
                            }
                        } else {
                            x509crl2 = x509crl;
                            it2 = it5;
                            try {
                                if (crl.getNextUpdate() != null) {
                                    if (!new Date().before(crl.getNextUpdate())) {
                                        Object[] objArr = new Object[3];
                                        z6 = z7;
                                        try {
                                            objArr[0] = new TrustedInput(crl.getThisUpdate());
                                            objArr[1] = new TrustedInput(crl.getNextUpdate());
                                            objArr[2] = new UntrustedUrlInput(str2);
                                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineInvalidCRL", objArr), i);
                                            it5 = it2;
                                            x509crl = x509crl2;
                                            z7 = z6;
                                        } catch (CertPathReviewerException e5) {
                                            e = e5;
                                            z7 = z6;
                                        }
                                    }
                                }
                                try {
                                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.onlineValidCRL", new Object[]{new TrustedInput(crl.getThisUpdate()), new TrustedInput(crl.getNextUpdate()), new UntrustedUrlInput(str2)}), i);
                                    x509crl = crl;
                                    z2 = true;
                                    break;
                                } catch (CertPathReviewerException e6) {
                                    e = e6;
                                    z7 = true;
                                }
                            } catch (CertPathReviewerException e7) {
                                e = e7;
                                addNotification(e.getErrorMessage(), i);
                                it5 = it2;
                                x509crl = x509crl2;
                            }
                        }
                        z6 = z7;
                        it5 = it2;
                        x509crl = x509crl2;
                        z7 = z6;
                    } catch (CertPathReviewerException e8) {
                        e = e8;
                        x509crl2 = x509crl;
                        it2 = it5;
                        addNotification(e.getErrorMessage(), i);
                        it5 = it2;
                        x509crl = x509crl2;
                    }
                }
            } else {
                z2 = z;
            }
            if (x509crl != null) {
                if (x509Certificate2 != null && (keyUsage = x509Certificate2.getKeyUsage()) != null && (keyUsage.length < 7 || !keyUsage[6])) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noCrlSigningPermited"));
                } else if (publicKey != null) {
                    try {
                        x509crl.verify(publicKey, "BC");
                        X509CRLEntry revokedCertificate = x509crl.getRevokedCertificate(x509Certificate.getSerialNumber());
                        if (revokedCertificate != null) {
                            if (revokedCertificate.hasExtensions()) {
                                try {
                                    DEREnumerated instance = DEREnumerated.getInstance(getExtensionValue(revokedCertificate, X509Extensions.ReasonCode.getId()));
                                    if (instance != null) {
                                        str = crlReasons[instance.getValue().intValue()];
                                        if (str == null) {
                                            str = crlReasons[7];
                                        }
                                        LocaleString localeString = new LocaleString(RESOURCE_NAME, str);
                                        if (!date.before(revokedCertificate.getRevocationDate())) {
                                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.revokedAfterValidation", new Object[]{new TrustedInput(revokedCertificate.getRevocationDate()), localeString}), i);
                                        } else {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certRevoked", new Object[]{new TrustedInput(revokedCertificate.getRevocationDate()), localeString}));
                                        }
                                    }
                                } catch (AnnotatedException e9) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlReasonExtError"), e9);
                                }
                            }
                            str = null;
                            if (str == null) {
                            }
                            LocaleString localeString2 = new LocaleString(RESOURCE_NAME, str);
                            if (!date.before(revokedCertificate.getRevocationDate())) {
                            }
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notRevoked"), i);
                        }
                        if (x509crl.getNextUpdate() == null || !x509crl.getNextUpdate().before(new Date())) {
                            z4 = true;
                            z3 = false;
                        } else {
                            z4 = true;
                            z3 = false;
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlUpdateAvailable", new Object[]{new TrustedInput(x509crl.getNextUpdate())}), i);
                        }
                        try {
                            DERObject extensionValue = getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT);
                            try {
                                DERObject extensionValue2 = getExtensionValue(x509crl, DELTA_CRL_INDICATOR);
                                if (extensionValue2 != null) {
                                    X509CRLStoreSelector x509CRLStoreSelector2 = new X509CRLStoreSelector();
                                    try {
                                        x509CRLStoreSelector2.addIssuerName(getIssuerPrincipal(x509crl).getEncoded());
                                        x509CRLStoreSelector2.setMinCRLNumber(((DERInteger) extensionValue2).getPositiveValue());
                                        try {
                                            x509CRLStoreSelector2.setMaxCRLNumber(((DERInteger) getExtensionValue(x509crl, CRL_NUMBER)).getPositiveValue().subtract(BigInteger.valueOf(1)));
                                            try {
                                                Iterator it6 = CRL_UTIL.findCRLs(x509CRLStoreSelector2, pKIXParameters).iterator();
                                                while (true) {
                                                    if (!it6.hasNext()) {
                                                        z5 = z3;
                                                        break;
                                                    }
                                                    try {
                                                        DERObject extensionValue3 = getExtensionValue((X509CRL) it6.next(), ISSUING_DISTRIBUTION_POINT);
                                                        if (extensionValue == null) {
                                                            if (extensionValue3 == null) {
                                                                break;
                                                            }
                                                        } else if (extensionValue.equals(extensionValue3)) {
                                                            break;
                                                        }
                                                    } catch (AnnotatedException e10) {
                                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.distrPtExtError"), e10);
                                                    }
                                                }
                                                if (!z5) {
                                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noBaseCRL"));
                                                }
                                            } catch (AnnotatedException e11) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlExtractionError"), e11);
                                            }
                                        } catch (AnnotatedException e12) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlNbrExtError"), e12);
                                        }
                                    } catch (IOException e13) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlIssuerException"), e13);
                                    }
                                }
                                if (extensionValue != null) {
                                    IssuingDistributionPoint instance2 = IssuingDistributionPoint.getInstance(extensionValue);
                                    try {
                                        BasicConstraints instance3 = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
                                        if (instance2.onlyContainsUserCerts() && instance3 != null && instance3.isCA()) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyUserCert"));
                                        } else if (instance2.onlyContainsCACerts() && (instance3 == null || !instance3.isCA())) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyCaCert"));
                                        } else if (instance2.onlyContainsAttributeCerts()) {
                                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlOnlyAttrCert"));
                                        }
                                    } catch (AnnotatedException e14) {
                                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlBCExtError"), e14);
                                    }
                                }
                            } catch (AnnotatedException unused) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.deltaCrlExtError"));
                            }
                        } catch (AnnotatedException unused2) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.distrPtExtError"));
                        }
                    } catch (Exception e15) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlVerifyFailed"), e15);
                    }
                } else {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlNoIssuerPublicKey"));
                }
            }
            if (!z2) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.noValidCrlFound"));
            }
        } catch (IOException e16) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.crlIssuerException"), e16);
        }
    }

    /* access modifiers changed from: protected */
    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws CertPathReviewerException {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    /* access modifiers changed from: protected */
    public void doChecks() {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        } else if (this.notifications == null) {
            int i = this.n;
            this.notifications = new List[(i + 1)];
            this.errors = new List[(i + 1)];
            int i2 = 0;
            while (true) {
                List[] listArr = this.notifications;
                if (i2 < listArr.length) {
                    listArr[i2] = new ArrayList();
                    this.errors[i2] = new ArrayList();
                    i2++;
                } else {
                    checkSignatures();
                    checkNameConstraints();
                    checkPathLength();
                    checkPolicy();
                    checkCriticalExtensions();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        DistributionPoint[] distributionPoints;
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List getErrors(int i) {
        doChecks();
        return this.errors[i + 1];
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List getNotifications(int i) {
        doChecks();
        return this.notifications[i + 1];
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    /* access modifiers changed from: protected */
    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    /* access modifiers changed from: protected */
    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(ASN1Object.fromByteArray(((ASN1OctetString) ASN1Object.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(instance.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = instance.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor2 = (TrustAnchor) it.next();
                if (trustAnchor2.getTrustedCert() != null) {
                    if (!x509CertSelector.match(trustAnchor2.getTrustedCert())) {
                    }
                } else if (trustAnchor2.getCAName() != null) {
                    if (trustAnchor2.getCAPublicKey() != null) {
                        if (!getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor2.getCAName()))) {
                        }
                    }
                }
                arrayList.add(trustAnchor2);
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (!this.initialized) {
            this.initialized = true;
            Objects.requireNonNull(certPath2, "certPath was null");
            this.certPath = certPath2;
            List<? extends Certificate> certificates = certPath2.getCertificates();
            this.certs = certificates;
            this.n = certificates.size();
            if (!this.certs.isEmpty()) {
                PKIXParameters pKIXParameters2 = (PKIXParameters) pKIXParameters.clone();
                this.pkixParams = pKIXParameters2;
                this.validDate = getValidDate(pKIXParameters2);
                this.notifications = null;
                this.errors = null;
                this.trustAnchor = null;
                this.subjectPublicKey = null;
                this.policyTree = null;
                return;
            }
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
        }
        throw new IllegalStateException("object is already initialized!");
    }

    public boolean isValidCertPath() {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }
}
