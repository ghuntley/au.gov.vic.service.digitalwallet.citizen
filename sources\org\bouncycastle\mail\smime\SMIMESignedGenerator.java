package org.bouncycastle.mail.smime;

import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import kotlin.text.Typography;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedDataStreamGenerator;
import org.bouncycastle.cms.SignerInfoGenerator;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.mail.smime.SMIMEUtil;
import org.bouncycastle.mail.smime.util.CRLFOutputStream;
import org.bouncycastle.util.Store;
import org.bouncycastle.x509.X509Store;

public class SMIMESignedGenerator extends SMIMEGenerator {
    private static final String CERTIFICATE_MANAGEMENT_CONTENT = "application/pkcs7-mime; name=smime.p7c; smime-type=certs-only";
    private static final String DETACHED_SIGNATURE_TYPE = "application/pkcs7-signature; name=smime.p7s; smime-type=signed-data";
    public static final String DIGEST_GOST3411 = CryptoProObjectIdentifiers.gostR3411.getId();
    public static final String DIGEST_MD5 = PKCSObjectIdentifiers.md5.getId();
    public static final String DIGEST_RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.getId();
    public static final String DIGEST_RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.getId();
    public static final String DIGEST_RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.getId();
    public static final String DIGEST_SHA1 = OIWObjectIdentifiers.idSHA1.getId();
    public static final String DIGEST_SHA224 = NISTObjectIdentifiers.id_sha224.getId();
    public static final String DIGEST_SHA256 = NISTObjectIdentifiers.id_sha256.getId();
    public static final String DIGEST_SHA384 = NISTObjectIdentifiers.id_sha384.getId();
    public static final String DIGEST_SHA512 = NISTObjectIdentifiers.id_sha512.getId();
    private static final String ENCAPSULATED_SIGNED_CONTENT_TYPE = "application/pkcs7-mime; name=smime.p7m; smime-type=signed-data";
    public static final String ENCRYPTION_DSA = X9ObjectIdentifiers.id_dsa_with_sha1.getId();
    public static final String ENCRYPTION_ECDSA = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
    public static final String ENCRYPTION_ECGOST3410 = CryptoProObjectIdentifiers.gostR3410_2001.getId();
    public static final String ENCRYPTION_GOST3410 = CryptoProObjectIdentifiers.gostR3410_94.getId();
    public static final String ENCRYPTION_RSA = PKCSObjectIdentifiers.rsaEncryption.getId();
    public static final String ENCRYPTION_RSA_PSS = PKCSObjectIdentifiers.id_RSASSA_PSS.getId();
    private List _attributeCerts;
    private List _certStores;
    private final String _defaultContentTransferEncoding;
    private Map _digests;
    private List _oldSigners;
    private List _signers;
    private List attrCertStores;
    private List certStores;
    private List crlStores;
    private List signerInfoGens;

    /* access modifiers changed from: private */
    public class ContentSigner implements SMIMEStreamingProcessor {
        private final MimeBodyPart content;
        private final boolean encapsulate;
        private final boolean noProvider;
        private final Provider provider;

        ContentSigner(MimeBodyPart mimeBodyPart, boolean z) {
            this.content = mimeBodyPart;
            this.encapsulate = z;
            this.provider = null;
            this.noProvider = true;
        }

        ContentSigner(MimeBodyPart mimeBodyPart, boolean z, Provider provider2) {
            this.content = mimeBodyPart;
            this.encapsulate = z;
            this.provider = provider2;
            this.noProvider = false;
        }

        private void writeBodyPart(OutputStream outputStream, MimeBodyPart mimeBodyPart) throws IOException, MessagingException {
            if (mimeBodyPart.getContent() instanceof Multipart) {
                Multipart multipart = (Multipart) mimeBodyPart.getContent();
                ContentType contentType = new ContentType(multipart.getContentType());
                String str = "--" + contentType.getParameter("boundary");
                SMIMEUtil.LineOutputStream lineOutputStream = new SMIMEUtil.LineOutputStream(outputStream);
                Enumeration allHeaderLines = mimeBodyPart.getAllHeaderLines();
                while (allHeaderLines.hasMoreElements()) {
                    lineOutputStream.writeln((String) allHeaderLines.nextElement());
                }
                lineOutputStream.writeln();
                SMIMEUtil.outputPreamble(lineOutputStream, mimeBodyPart, str);
                for (int i = 0; i < multipart.getCount(); i++) {
                    lineOutputStream.writeln(str);
                    writeBodyPart(outputStream, (MimeBodyPart) multipart.getBodyPart(i));
                    lineOutputStream.writeln();
                }
                lineOutputStream.writeln(str + "--");
                return;
            }
            if (SMIMEUtil.isCanonicalisationRequired(mimeBodyPart, SMIMESignedGenerator.this._defaultContentTransferEncoding)) {
                outputStream = new CRLFOutputStream(outputStream);
            }
            mimeBodyPart.writeTo(outputStream);
        }

        /* access modifiers changed from: protected */
        public CMSSignedDataStreamGenerator getGenerator() throws CMSException, CertStoreException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException {
            CMSSignedDataStreamGenerator cMSSignedDataStreamGenerator = new CMSSignedDataStreamGenerator();
            for (CertStore certStore : SMIMESignedGenerator.this._certStores) {
                cMSSignedDataStreamGenerator.addCertificatesAndCRLs(certStore);
            }
            for (Store store : SMIMESignedGenerator.this.certStores) {
                cMSSignedDataStreamGenerator.addCertificates(store);
            }
            for (Store store2 : SMIMESignedGenerator.this.crlStores) {
                cMSSignedDataStreamGenerator.addCRLs(store2);
            }
            for (Store store3 : SMIMESignedGenerator.this.attrCertStores) {
                cMSSignedDataStreamGenerator.addAttributeCertificates(store3);
            }
            for (X509Store x509Store : SMIMESignedGenerator.this._attributeCerts) {
                cMSSignedDataStreamGenerator.addAttributeCertificates(x509Store);
            }
            for (Signer signer : SMIMESignedGenerator.this._signers) {
                if (signer.getEncryptionOID() != null) {
                    cMSSignedDataStreamGenerator.addSigner(signer.getKey(), signer.getCert(), signer.getEncryptionOID(), signer.getDigestOID(), signer.getSignedAttr(), signer.getUnsignedAttr(), this.provider);
                } else {
                    cMSSignedDataStreamGenerator.addSigner(signer.getKey(), signer.getCert(), signer.getDigestOID(), signer.getSignedAttr(), signer.getUnsignedAttr(), this.provider);
                }
            }
            for (SignerInfoGenerator signerInfoGenerator : SMIMESignedGenerator.this.signerInfoGens) {
                cMSSignedDataStreamGenerator.addSignerInfoGenerator(signerInfoGenerator);
            }
            cMSSignedDataStreamGenerator.addSigners(new SignerInformationStore(SMIMESignedGenerator.this._oldSigners));
            return cMSSignedDataStreamGenerator;
        }

        @Override // org.bouncycastle.mail.smime.SMIMEStreamingProcessor
        public void write(OutputStream outputStream) throws IOException {
            try {
                CMSSignedDataStreamGenerator generator = getGenerator();
                OutputStream open = generator.open(outputStream, this.encapsulate);
                MimeBodyPart mimeBodyPart = this.content;
                if (mimeBodyPart != null) {
                    if (!this.encapsulate) {
                        writeBodyPart(open, mimeBodyPart);
                    } else {
                        mimeBodyPart.getDataHandler().setCommandMap(SMIMESignedGenerator.addCommands(CommandMap.getDefaultCommandMap()));
                        this.content.writeTo(open);
                    }
                }
                open.close();
                SMIMESignedGenerator.this._digests = generator.getGeneratedDigests();
            } catch (MessagingException e) {
                throw new IOException(e.toString());
            } catch (NoSuchAlgorithmException e2) {
                throw new IOException(e2.toString());
            } catch (NoSuchProviderException e3) {
                throw new IOException(e3.toString());
            } catch (CMSException e4) {
                throw new IOException(e4.toString());
            } catch (InvalidKeyException e5) {
                throw new IOException(e5.toString());
            } catch (CertStoreException e6) {
                throw new IOException(e6.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public class Signer {
        final X509Certificate cert;
        final String digestOID;
        final String encryptionOID;
        final PrivateKey key;
        final AttributeTable signedAttr;
        final AttributeTable unsignedAttr;

        Signer(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2) {
            this.key = privateKey;
            this.cert = x509Certificate;
            this.encryptionOID = str;
            this.digestOID = str2;
            this.signedAttr = attributeTable;
            this.unsignedAttr = attributeTable2;
        }

        Signer(SMIMESignedGenerator sMIMESignedGenerator, PrivateKey privateKey, X509Certificate x509Certificate, String str, AttributeTable attributeTable, AttributeTable attributeTable2) {
            this(privateKey, x509Certificate, null, str, attributeTable, attributeTable2);
        }

        public X509Certificate getCert() {
            return this.cert;
        }

        public String getDigestOID() {
            return this.digestOID;
        }

        public String getEncryptionOID() {
            return this.encryptionOID;
        }

        public PrivateKey getKey() {
            return this.key;
        }

        public AttributeTable getSignedAttr() {
            return this.signedAttr;
        }

        public AttributeTable getUnsignedAttr() {
            return this.unsignedAttr;
        }
    }

    static {
        CommandMap.setDefaultCommandMap(addCommands(CommandMap.getDefaultCommandMap()));
    }

    public SMIMESignedGenerator() {
        this._certStores = new ArrayList();
        this.certStores = new ArrayList();
        this.crlStores = new ArrayList();
        this.attrCertStores = new ArrayList();
        this.signerInfoGens = new ArrayList();
        this._signers = new ArrayList();
        this._oldSigners = new ArrayList();
        this._attributeCerts = new ArrayList();
        this._digests = new HashMap();
        this._defaultContentTransferEncoding = "7bit";
    }

    public SMIMESignedGenerator(String str) {
        this._certStores = new ArrayList();
        this.certStores = new ArrayList();
        this.crlStores = new ArrayList();
        this.attrCertStores = new ArrayList();
        this.signerInfoGens = new ArrayList();
        this._signers = new ArrayList();
        this._oldSigners = new ArrayList();
        this._attributeCerts = new ArrayList();
        this._digests = new HashMap();
        this._defaultContentTransferEncoding = str;
    }

    /* access modifiers changed from: private */
    public static MailcapCommandMap addCommands(CommandMap commandMap) {
        MailcapCommandMap mailcapCommandMap = (MailcapCommandMap) commandMap;
        mailcapCommandMap.addMailcap("application/pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_signature");
        mailcapCommandMap.addMailcap("application/pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_mime");
        mailcapCommandMap.addMailcap("application/x-pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_signature");
        mailcapCommandMap.addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_mime");
        mailcapCommandMap.addMailcap("multipart/signed;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.multipart_signed");
        return mailcapCommandMap;
    }

    private void addHashHeader(StringBuffer stringBuffer, List list) {
        HashSet<String> hashSet = new HashSet();
        for (Object obj : list) {
            String digestOID = obj instanceof Signer ? ((Signer) obj).getDigestOID() : obj instanceof SignerInformation ? ((SignerInformation) obj).getDigestAlgOID() : ((SignerInfoGenerator) obj).getDigestAlgorithm().getAlgorithm().getId();
            hashSet.add(digestOID.equals(DIGEST_SHA1) ? "sha1" : digestOID.equals(DIGEST_MD5) ? "md5" : digestOID.equals(DIGEST_SHA224) ? "sha224" : digestOID.equals(DIGEST_SHA256) ? "sha256" : digestOID.equals(DIGEST_SHA384) ? "sha384" : digestOID.equals(DIGEST_SHA512) ? "sha512" : digestOID.equals(DIGEST_GOST3411) ? "gostr3411-94" : EnvironmentCompat.MEDIA_UNKNOWN);
        }
        int i = 0;
        for (String str : hashSet) {
            if (i == 0) {
                stringBuffer.append(hashSet.size() != 1 ? "; micalg=\"" : "; micalg=");
            } else {
                stringBuffer.append(',');
            }
            stringBuffer.append(str);
            i++;
        }
        if (!(i == 0 || hashSet.size() == 1)) {
            stringBuffer.append(Typography.quote);
        }
    }

    private MimeMultipart make(MimeBodyPart mimeBodyPart) throws SMIMEException {
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentSigner(mimeBodyPart, false), DETACHED_SIGNATURE_TYPE);
            mimeBodyPart2.addHeader("Content-Type", DETACHED_SIGNATURE_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7s\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Cryptographic Signature");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            StringBuffer stringBuffer = new StringBuffer("signed; protocol=\"application/pkcs7-signature\"");
            ArrayList arrayList = new ArrayList(this._signers);
            arrayList.addAll(this._oldSigners);
            arrayList.addAll(this.signerInfoGens);
            addHashHeader(stringBuffer, arrayList);
            MimeMultipart mimeMultipart = new MimeMultipart(stringBuffer.toString());
            mimeMultipart.addBodyPart(mimeBodyPart);
            mimeMultipart.addBodyPart(mimeBodyPart2);
            return mimeMultipart;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting multi-part together.", e);
        }
    }

    private MimeMultipart make(MimeBodyPart mimeBodyPart, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentSigner(mimeBodyPart, false, provider), DETACHED_SIGNATURE_TYPE);
            mimeBodyPart2.addHeader("Content-Type", DETACHED_SIGNATURE_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7s\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Cryptographic Signature");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            StringBuffer stringBuffer = new StringBuffer("signed; protocol=\"application/pkcs7-signature\"");
            ArrayList arrayList = new ArrayList(this._signers);
            arrayList.addAll(this._oldSigners);
            arrayList.addAll(this.signerInfoGens);
            addHashHeader(stringBuffer, arrayList);
            MimeMultipart mimeMultipart = new MimeMultipart(stringBuffer.toString());
            mimeMultipart.addBodyPart(mimeBodyPart);
            mimeMultipart.addBodyPart(mimeBodyPart2);
            return mimeMultipart;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting multi-part together.", e);
        }
    }

    private MimeBodyPart makeEncapsulated(MimeBodyPart mimeBodyPart) throws SMIMEException {
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentSigner(mimeBodyPart, true), ENCAPSULATED_SIGNED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Type", ENCAPSULATED_SIGNED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7m\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Cryptographic Signed Data");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            return mimeBodyPart2;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting body part together.", e);
        }
    }

    private MimeBodyPart makeEncapsulated(MimeBodyPart mimeBodyPart, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentSigner(mimeBodyPart, true, provider), ENCAPSULATED_SIGNED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Type", ENCAPSULATED_SIGNED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7m\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Cryptographic Signed Data");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            return mimeBodyPart2;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting body part together.", e);
        }
    }

    public void addAttributeCertificates(Store store) {
        this.attrCertStores.add(store);
    }

    public void addAttributeCertificates(X509Store x509Store) throws CMSException {
        this._attributeCerts.add(x509Store);
    }

    public void addCRLs(Store store) {
        this.crlStores.add(store);
    }

    public void addCertificates(Store store) {
        this.certStores.add(store);
    }

    public void addCertificatesAndCRLs(CertStore certStore) throws CertStoreException, SMIMEException {
        this._certStores.add(certStore);
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str) throws IllegalArgumentException {
        this._signers.add(new Signer(this, privateKey, x509Certificate, str, null, null));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2) throws IllegalArgumentException {
        this._signers.add(new Signer(privateKey, x509Certificate, str, str2, null, null));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, String str2, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException {
        this._signers.add(new Signer(privateKey, x509Certificate, str, str2, attributeTable, attributeTable2));
    }

    public void addSigner(PrivateKey privateKey, X509Certificate x509Certificate, String str, AttributeTable attributeTable, AttributeTable attributeTable2) throws IllegalArgumentException {
        this._signers.add(new Signer(this, privateKey, x509Certificate, str, attributeTable, attributeTable2));
    }

    public void addSignerInfoGenerator(SignerInfoGenerator signerInfoGenerator) {
        this.signerInfoGens.add(signerInfoGenerator);
    }

    public void addSigners(SignerInformationStore signerInformationStore) {
        for (Object obj : signerInformationStore.getSigners()) {
            this._oldSigners.add(obj);
        }
    }

    public MimeMultipart generate(MimeBodyPart mimeBodyPart) throws SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart));
    }

    public MimeMultipart generate(MimeBodyPart mimeBodyPart, String str) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), SMIMEUtil.getProvider(str));
    }

    public MimeMultipart generate(MimeBodyPart mimeBodyPart, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), provider);
    }

    public MimeMultipart generate(MimeMessage mimeMessage, String str) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return generate(mimeMessage, SMIMEUtil.getProvider(str));
    }

    public MimeMultipart generate(MimeMessage mimeMessage, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        try {
            mimeMessage.saveChanges();
            return make(makeContentBodyPart(mimeMessage), provider);
        } catch (MessagingException e) {
            throw new SMIMEException("unable to save message", e);
        }
    }

    public MimeBodyPart generateCertificateManagement(String str) throws SMIMEException, NoSuchProviderException {
        return generateCertificateManagement(SMIMEUtil.getProvider(str));
    }

    public MimeBodyPart generateCertificateManagement(Provider provider) throws SMIMEException {
        try {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(new ContentSigner(null, true, provider), CERTIFICATE_MANAGEMENT_CONTENT);
            mimeBodyPart.addHeader("Content-Type", CERTIFICATE_MANAGEMENT_CONTENT);
            mimeBodyPart.addHeader("Content-Disposition", "attachment; filename=\"smime.p7c\"");
            mimeBodyPart.addHeader("Content-Description", "S/MIME Certificate Management Message");
            mimeBodyPart.addHeader("Content-Transfer-Encoding", this.encoding);
            return mimeBodyPart;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting body part together.", e);
        }
    }

    public MimeBodyPart generateEncapsulated(MimeBodyPart mimeBodyPart) throws SMIMEException {
        return makeEncapsulated(makeContentBodyPart(mimeBodyPart));
    }

    public MimeBodyPart generateEncapsulated(MimeBodyPart mimeBodyPart, String str) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return makeEncapsulated(makeContentBodyPart(mimeBodyPart), SMIMEUtil.getProvider(str));
    }

    public MimeBodyPart generateEncapsulated(MimeBodyPart mimeBodyPart, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return makeEncapsulated(makeContentBodyPart(mimeBodyPart), provider);
    }

    public MimeBodyPart generateEncapsulated(MimeMessage mimeMessage, String str) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return generateEncapsulated(mimeMessage, SMIMEUtil.getProvider(str));
    }

    public MimeBodyPart generateEncapsulated(MimeMessage mimeMessage, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        try {
            mimeMessage.saveChanges();
            return makeEncapsulated(makeContentBodyPart(mimeMessage), provider);
        } catch (MessagingException e) {
            throw new SMIMEException("unable to save message", e);
        }
    }

    public Map getGeneratedDigests() {
        return new HashMap(this._digests);
    }
}
