package org.bouncycastle.mail.smime.examples;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.smime.SMIMECapabilitiesAttribute;
import org.bouncycastle.asn1.smime.SMIMECapability;
import org.bouncycastle.asn1.smime.SMIMECapabilityVector;
import org.bouncycastle.asn1.smime.SMIMEEncryptionKeyPreferenceAttribute;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoGeneratorBuilder;
import org.bouncycastle.mail.smime.SMIMESignedGenerator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class CreateSignedMultipartMail {
    static int serialNo = 1;

    static AuthorityKeyIdentifier createAuthorityKeyId(PublicKey publicKey) throws IOException {
        return new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(publicKey.getEncoded())).readObject()));
    }

    static SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) throws IOException {
        return new SubjectKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(publicKey.getEncoded())).readObject()));
    }

    public static void main(String[] strArr) throws Exception {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "BC");
        instance.initialize(1024, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        X509Certificate makeCertificate = makeCertificate(generateKeyPair, "O=Bouncy Castle, C=AU", generateKeyPair, "O=Bouncy Castle, C=AU");
        KeyPair generateKeyPair2 = instance.generateKeyPair();
        X509Certificate makeCertificate2 = makeCertificate(generateKeyPair2, "CN=Eric H. Echidna, E=eric@bouncycastle.org, O=Bouncy Castle, C=AU", generateKeyPair, "O=Bouncy Castle, C=AU");
        ArrayList arrayList = new ArrayList();
        arrayList.add(makeCertificate2);
        arrayList.add(makeCertificate);
        JcaCertStore jcaCertStore = new JcaCertStore(arrayList);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        SMIMECapabilityVector sMIMECapabilityVector = new SMIMECapabilityVector();
        sMIMECapabilityVector.addCapability(SMIMECapability.dES_EDE3_CBC);
        sMIMECapabilityVector.addCapability(SMIMECapability.rC2_CBC, 128);
        sMIMECapabilityVector.addCapability(SMIMECapability.dES_CBC);
        aSN1EncodableVector.add(new SMIMECapabilitiesAttribute(sMIMECapabilityVector));
        aSN1EncodableVector.add(new SMIMEEncryptionKeyPreferenceAttribute(new IssuerAndSerialNumber(new X500Name("O=Bouncy Castle, C=AU"), makeCertificate2.getSerialNumber())));
        SMIMESignedGenerator sMIMESignedGenerator = new SMIMESignedGenerator();
        sMIMESignedGenerator.addSignerInfoGenerator(new JcaSimpleSignerInfoGeneratorBuilder().setProvider("BC").setSignedAttributeGenerator(new AttributeTable(aSN1EncodableVector)).build("SHA1withRSA", generateKeyPair2.getPrivate(), makeCertificate2));
        sMIMESignedGenerator.addCertificates(jcaCertStore);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText("Hello part 1!");
        MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
        mimeBodyPart2.setText("Hello part 2!");
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);
        mimeMultipart.addBodyPart(mimeBodyPart2);
        MimeBodyPart mimeBodyPart3 = new MimeBodyPart();
        mimeBodyPart3.setContent(mimeMultipart);
        MimeMultipart generate = sMIMESignedGenerator.generate(mimeBodyPart3);
        Session defaultInstance = Session.getDefaultInstance(System.getProperties(), (Authenticator) null);
        InternetAddress internetAddress = new InternetAddress("\"Eric H. Echidna\"<eric@bouncycastle.org>");
        InternetAddress internetAddress2 = new InternetAddress("example@bouncycastle.org");
        MimeMessage mimeMessage = new MimeMessage(defaultInstance);
        mimeMessage.setFrom(internetAddress);
        mimeMessage.setRecipient(Message.RecipientType.TO, internetAddress2);
        mimeMessage.setSubject("example signed message");
        mimeMessage.setContent(generate, generate.getContentType());
        mimeMessage.saveChanges();
        mimeMessage.writeTo(new FileOutputStream("signed.message"));
    }

    static X509Certificate makeCertificate(KeyPair keyPair, String str, KeyPair keyPair2, String str2) throws GeneralSecurityException, IOException, OperatorCreationException {
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair2.getPrivate();
        PublicKey publicKey2 = keyPair2.getPublic();
        X500Name x500Name = new X500Name(str2);
        int i = serialNo;
        serialNo = i + 1;
        JcaX509v3CertificateBuilder jcaX509v3CertificateBuilder = new JcaX509v3CertificateBuilder(x500Name, BigInteger.valueOf((long) i), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 8640000000L), new X500Name(str), publicKey);
        jcaX509v3CertificateBuilder.addExtension(X509Extension.subjectKeyIdentifier, false, createSubjectKeyId(publicKey));
        jcaX509v3CertificateBuilder.addExtension(X509Extension.authorityKeyIdentifier, false, createAuthorityKeyId(publicKey2));
        return new JcaX509CertificateConverter().setProvider("BC").getCertificate(jcaX509v3CertificateBuilder.build(new JcaContentSignerBuilder("MD5withRSA").setProvider("BC").build(privateKey)));
    }
}
