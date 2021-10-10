package org.bouncycastle.mail.smime;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.crypto.SecretKey;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.cms.CMSEnvelopedDataStreamGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.RecipientInfoGenerator;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKEKRecipientInfoGenerator;
import org.bouncycastle.cms.jcajce.JceKeyAgreeRecipientInfoGenerator;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OutputEncryptor;

public class SMIMEEnvelopedGenerator extends SMIMEGenerator {
    public static final String AES128_CBC = CMSEnvelopedDataGenerator.AES128_CBC;
    public static final String AES128_WRAP = CMSEnvelopedDataGenerator.AES128_WRAP;
    public static final String AES192_CBC = CMSEnvelopedDataGenerator.AES192_CBC;
    public static final String AES256_CBC = CMSEnvelopedDataGenerator.AES256_CBC;
    public static final String AES256_WRAP = CMSEnvelopedDataGenerator.AES256_WRAP;
    public static final String CAMELLIA128_CBC = CMSEnvelopedDataGenerator.CAMELLIA128_CBC;
    public static final String CAMELLIA128_WRAP = CMSEnvelopedDataGenerator.CAMELLIA128_WRAP;
    public static final String CAMELLIA192_CBC = CMSEnvelopedDataGenerator.CAMELLIA192_CBC;
    public static final String CAMELLIA192_WRAP = CMSEnvelopedDataGenerator.CAMELLIA192_WRAP;
    public static final String CAMELLIA256_CBC = CMSEnvelopedDataGenerator.CAMELLIA256_CBC;
    public static final String CAMELLIA256_WRAP = CMSEnvelopedDataGenerator.CAMELLIA256_WRAP;
    public static final String CAST5_CBC = "1.2.840.113533.7.66.10";
    public static final String DES_EDE3_CBC = CMSEnvelopedDataGenerator.DES_EDE3_CBC;
    public static final String DES_EDE3_WRAP = CMSEnvelopedDataGenerator.DES_EDE3_WRAP;
    public static final String ECDH_SHA1KDF = CMSEnvelopedDataGenerator.ECDH_SHA1KDF;
    private static final String ENCRYPTED_CONTENT_TYPE = "application/pkcs7-mime; name=\"smime.p7m\"; smime-type=enveloped-data";
    public static final String IDEA_CBC = "1.3.6.1.4.1.188.7.1.1.2";
    public static final String RC2_CBC = CMSEnvelopedDataGenerator.RC2_CBC;
    public static final String SEED_CBC = CMSEnvelopedDataGenerator.SEED_CBC;
    public static final String SEED_WRAP = CMSEnvelopedDataGenerator.SEED_WRAP;
    private EnvelopedGenerator fact = new EnvelopedGenerator();
    private List recipients = new ArrayList();

    /* access modifiers changed from: private */
    public class ContentEncryptor implements SMIMEStreamingProcessor {
        private final MimeBodyPart _content;
        private OutputEncryptor _encryptor;
        private boolean _firstTime = true;

        ContentEncryptor(MimeBodyPart mimeBodyPart, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, Provider provider) throws CMSException {
            JceCMSContentEncryptorBuilder jceCMSContentEncryptorBuilder;
            this._content = mimeBodyPart;
            if (i != 0) {
                jceCMSContentEncryptorBuilder = new JceCMSContentEncryptorBuilder(aSN1ObjectIdentifier, i);
            }
            this._encryptor = jceCMSContentEncryptorBuilder.setProvider(provider).build();
            if (provider != null) {
                for (RecipientInfoGenerator recipientInfoGenerator : SMIMEEnvelopedGenerator.this.recipients) {
                    try {
                        if (recipientInfoGenerator instanceof JceKeyTransRecipientInfoGenerator) {
                            ((JceKeyTransRecipientInfoGenerator) recipientInfoGenerator).setProvider(provider);
                        } else if (recipientInfoGenerator instanceof JceKEKRecipientInfoGenerator) {
                            ((JceKEKRecipientInfoGenerator) recipientInfoGenerator).setProvider(provider);
                        }
                    } catch (OperatorCreationException e) {
                        throw new CMSException("cannot create recipient: " + e.getMessage(), e);
                    }
                }
            }
        }

        ContentEncryptor(MimeBodyPart mimeBodyPart, OutputEncryptor outputEncryptor) {
            this._content = mimeBodyPart;
            this._encryptor = outputEncryptor;
        }

        @Override // org.bouncycastle.mail.smime.SMIMEStreamingProcessor
        public void write(OutputStream outputStream) throws IOException {
            OutputStream outputStream2;
            try {
                if (this._firstTime) {
                    outputStream2 = SMIMEEnvelopedGenerator.this.fact.open(outputStream, this._encryptor);
                    this._firstTime = false;
                } else {
                    outputStream2 = SMIMEEnvelopedGenerator.this.fact.regenerate(outputStream, this._encryptor);
                }
                this._content.getDataHandler().setCommandMap(SMIMEEnvelopedGenerator.addCommands(CommandMap.getDefaultCommandMap()));
                this._content.writeTo(outputStream2);
                outputStream2.close();
            } catch (MessagingException e) {
                throw new WrappingIOException(e.toString(), e);
            } catch (CMSException e2) {
                throw new WrappingIOException(e2.toString(), e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public class EnvelopedGenerator extends CMSEnvelopedDataStreamGenerator {
        private ASN1ObjectIdentifier dataType;
        private ASN1EncodableVector recipientInfos;

        private EnvelopedGenerator() {
        }

        /* access modifiers changed from: protected */
        @Override // org.bouncycastle.cms.CMSEnvelopedDataStreamGenerator
        public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputEncryptor outputEncryptor) throws IOException {
            this.dataType = aSN1ObjectIdentifier;
            this.recipientInfos = aSN1EncodableVector;
            return super.open(aSN1ObjectIdentifier, outputStream, aSN1EncodableVector, outputEncryptor);
        }

        /* access modifiers changed from: package-private */
        public OutputStream regenerate(OutputStream outputStream, OutputEncryptor outputEncryptor) throws IOException {
            return super.open(this.dataType, outputStream, this.recipientInfos, outputEncryptor);
        }
    }

    private static class WrappingIOException extends IOException {
        private Throwable cause;

        WrappingIOException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    static {
        CommandMap.setDefaultCommandMap(addCommands(CommandMap.getDefaultCommandMap()));
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

    private MimeBodyPart make(MimeBodyPart mimeBodyPart, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        createSymmetricKeyGenerator(aSN1ObjectIdentifier.getId(), provider);
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentEncryptor(mimeBodyPart, aSN1ObjectIdentifier, i, provider), ENCRYPTED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Type", ENCRYPTED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7m\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Encrypted Message");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            return mimeBodyPart2;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting S/MIME message together.", e);
        } catch (CMSException e2) {
            throw new SMIMEException("exception putting envelope together.", e2);
        }
    }

    private MimeBodyPart make(MimeBodyPart mimeBodyPart, OutputEncryptor outputEncryptor) throws SMIMEException {
        try {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(new ContentEncryptor(mimeBodyPart, outputEncryptor), ENCRYPTED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Type", ENCRYPTED_CONTENT_TYPE);
            mimeBodyPart2.addHeader("Content-Disposition", "attachment; filename=\"smime.p7m\"");
            mimeBodyPart2.addHeader("Content-Description", "S/MIME Encrypted Message");
            mimeBodyPart2.addHeader("Content-Transfer-Encoding", this.encoding);
            return mimeBodyPart2;
        } catch (MessagingException e) {
            throw new SMIMEException("exception putting multi-part together.", e);
        }
    }

    public void addKEKRecipient(SecretKey secretKey, byte[] bArr) throws IllegalArgumentException {
        JceKEKRecipientInfoGenerator jceKEKRecipientInfoGenerator = new JceKEKRecipientInfoGenerator(bArr, secretKey);
        this.recipients.add(jceKEKRecipientInfoGenerator);
        this.fact.addRecipientInfoGenerator(jceKEKRecipientInfoGenerator);
    }

    public void addKeyAgreementRecipient(String str, PrivateKey privateKey, PublicKey publicKey, X509Certificate x509Certificate, String str2, String str3) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        addKeyAgreementRecipient(str, privateKey, publicKey, x509Certificate, str2, str3);
    }

    public void addKeyAgreementRecipient(String str, PrivateKey privateKey, PublicKey publicKey, X509Certificate x509Certificate, String str2, Provider provider) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            JceKeyAgreeRecipientInfoGenerator jceKeyAgreeRecipientInfoGenerator = new JceKeyAgreeRecipientInfoGenerator(new ASN1ObjectIdentifier(str), privateKey, publicKey, new ASN1ObjectIdentifier(str2));
            jceKeyAgreeRecipientInfoGenerator.addRecipient(x509Certificate);
            if (provider != null) {
                jceKeyAgreeRecipientInfoGenerator.setProvider(provider);
            }
            this.fact.addRecipientInfoGenerator(jceKeyAgreeRecipientInfoGenerator);
        } catch (CertificateEncodingException e) {
            throw new NoSuchAlgorithmException("cannot set up generator: " + e);
        } catch (CMSException e2) {
            throw new NoSuchAlgorithmException("cannot set up generator: " + e2);
        }
    }

    public void addKeyTransRecipient(PublicKey publicKey, byte[] bArr) throws IllegalArgumentException {
        JceKeyTransRecipientInfoGenerator jceKeyTransRecipientInfoGenerator = new JceKeyTransRecipientInfoGenerator(bArr, publicKey);
        this.recipients.add(jceKeyTransRecipientInfoGenerator);
        this.fact.addRecipientInfoGenerator(jceKeyTransRecipientInfoGenerator);
    }

    public void addKeyTransRecipient(X509Certificate x509Certificate) throws IllegalArgumentException {
        try {
            JceKeyTransRecipientInfoGenerator jceKeyTransRecipientInfoGenerator = new JceKeyTransRecipientInfoGenerator(x509Certificate);
            this.recipients.add(jceKeyTransRecipientInfoGenerator);
            this.fact.addRecipientInfoGenerator(jceKeyTransRecipientInfoGenerator);
        } catch (CertificateEncodingException e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    public void addRecipientInfoGenerator(RecipientInfoGenerator recipientInfoGenerator) throws IllegalArgumentException {
        this.fact.addRecipientInfoGenerator(recipientInfoGenerator);
    }

    public MimeBodyPart generate(MimeBodyPart mimeBodyPart, String str, int i, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return generate(mimeBodyPart, str, i, SMIMEUtil.getProvider(str2));
    }

    public MimeBodyPart generate(MimeBodyPart mimeBodyPart, String str, int i, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), new ASN1ObjectIdentifier(str), i, provider);
    }

    public MimeBodyPart generate(MimeBodyPart mimeBodyPart, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), new ASN1ObjectIdentifier(str), 0, SMIMEUtil.getProvider(str2));
    }

    public MimeBodyPart generate(MimeBodyPart mimeBodyPart, String str, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), new ASN1ObjectIdentifier(str), 0, provider);
    }

    public MimeBodyPart generate(MimeBodyPart mimeBodyPart, OutputEncryptor outputEncryptor) throws SMIMEException {
        return make(makeContentBodyPart(mimeBodyPart), outputEncryptor);
    }

    public MimeBodyPart generate(MimeMessage mimeMessage, String str, int i, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return generate(mimeMessage, str, i, SMIMEUtil.getProvider(str2));
    }

    public MimeBodyPart generate(MimeMessage mimeMessage, String str, int i, Provider provider) throws NoSuchAlgorithmException, SMIMEException {
        try {
            mimeMessage.saveChanges();
            return make(makeContentBodyPart(mimeMessage), new ASN1ObjectIdentifier(str), i, provider);
        } catch (MessagingException e) {
            throw new SMIMEException("unable to save message", e);
        }
    }

    public MimeBodyPart generate(MimeMessage mimeMessage, String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        return generate(mimeMessage, str, SMIMEUtil.getProvider(str2));
    }

    public MimeBodyPart generate(MimeMessage mimeMessage, String str, Provider provider) throws NoSuchAlgorithmException, NoSuchProviderException, SMIMEException {
        try {
            mimeMessage.saveChanges();
            return make(makeContentBodyPart(mimeMessage), new ASN1ObjectIdentifier(str), 0, provider);
        } catch (MessagingException e) {
            throw new SMIMEException("unable to save message", e);
        }
    }

    public MimeBodyPart generate(MimeMessage mimeMessage, OutputEncryptor outputEncryptor) throws SMIMEException {
        try {
            mimeMessage.saveChanges();
            return make(makeContentBodyPart(mimeMessage), outputEncryptor);
        } catch (MessagingException e) {
            throw new SMIMEException("unable to save message", e);
        }
    }

    public void setBerEncodeRecipients(boolean z) {
        this.fact.setBEREncodeRecipients(z);
    }
}
