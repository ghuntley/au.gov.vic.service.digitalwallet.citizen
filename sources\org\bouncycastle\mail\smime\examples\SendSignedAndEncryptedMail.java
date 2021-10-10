package org.bouncycastle.mail.smime.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.smime.SMIMECapabilitiesAttribute;
import org.bouncycastle.asn1.smime.SMIMECapability;
import org.bouncycastle.asn1.smime.SMIMECapabilityVector;
import org.bouncycastle.asn1.smime.SMIMEEncryptionKeyPreferenceAttribute;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoGeneratorBuilder;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.mail.smime.SMIMEEnvelopedGenerator;
import org.bouncycastle.mail.smime.SMIMEException;
import org.bouncycastle.mail.smime.SMIMESignedGenerator;
import org.bouncycastle.util.Strings;

public class SendSignedAndEncryptedMail {
    public static void main(String[] strArr) {
        if (strArr.length != 5) {
            System.err.println("usage: SendSignedAndEncryptedMail <pkcs12Keystore> <password> <keyalias> <smtp server> <email address>");
            System.exit(0);
        }
        try {
            MailcapCommandMap defaultCommandMap = CommandMap.getDefaultCommandMap();
            defaultCommandMap.addMailcap("application/pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_signature");
            defaultCommandMap.addMailcap("application/pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.pkcs7_mime");
            defaultCommandMap.addMailcap("application/x-pkcs7-signature;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_signature");
            defaultCommandMap.addMailcap("application/x-pkcs7-mime;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.x_pkcs7_mime");
            defaultCommandMap.addMailcap("multipart/signed;; x-java-content-handler=org.bouncycastle.mail.smime.handlers.multipart_signed");
            CommandMap.setDefaultCommandMap(defaultCommandMap);
            Security.addProvider(new BouncyCastleProvider());
            KeyStore instance = KeyStore.getInstance("PKCS12", "BC");
            instance.load(new FileInputStream(strArr[0]), strArr[1].toCharArray());
            Certificate[] certificateChain = instance.getCertificateChain(strArr[2]);
            PrivateKey privateKey = (PrivateKey) instance.getKey(strArr[2], strArr[1].toCharArray());
            if (privateKey != null) {
                Properties properties = System.getProperties();
                properties.put("mail.smtp.host", strArr[3]);
                Session defaultInstance = Session.getDefaultInstance(properties, (Authenticator) null);
                MimeMessage mimeMessage = new MimeMessage(defaultInstance);
                mimeMessage.setFrom(new InternetAddress(strArr[4]));
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(strArr[4]));
                mimeMessage.setSubject("example encrypted message");
                mimeMessage.setContent("example encrypted message", "text/plain");
                mimeMessage.saveChanges();
                SMIMECapabilityVector sMIMECapabilityVector = new SMIMECapabilityVector();
                sMIMECapabilityVector.addCapability(SMIMECapability.dES_EDE3_CBC);
                sMIMECapabilityVector.addCapability(SMIMECapability.rC2_CBC, 128);
                sMIMECapabilityVector.addCapability(SMIMECapability.dES_CBC);
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(new SMIMEEncryptionKeyPreferenceAttribute(new IssuerAndSerialNumber(new X500Name(((X509Certificate) certificateChain[0]).getIssuerDN().getName()), ((X509Certificate) certificateChain[0]).getSerialNumber())));
                aSN1EncodableVector.add(new SMIMECapabilitiesAttribute(sMIMECapabilityVector));
                SMIMESignedGenerator sMIMESignedGenerator = new SMIMESignedGenerator();
                sMIMESignedGenerator.addSignerInfoGenerator(new JcaSimpleSignerInfoGeneratorBuilder().setProvider("BC").setSignedAttributeGenerator(new AttributeTable(aSN1EncodableVector)).build("DSA".equals(privateKey.getAlgorithm()) ? "SHA1withDSA" : "MD5withDSA", privateKey, (X509Certificate) certificateChain[0]));
                ArrayList arrayList = new ArrayList();
                arrayList.add(certificateChain[0]);
                sMIMESignedGenerator.addCertificates(new JcaCertStore(arrayList));
                MimeMultipart generate = sMIMESignedGenerator.generate(mimeMessage, "BC");
                MimeMessage mimeMessage2 = new MimeMessage(defaultInstance);
                Enumeration allHeaderLines = mimeMessage.getAllHeaderLines();
                while (allHeaderLines.hasMoreElements()) {
                    mimeMessage2.addHeaderLine((String) allHeaderLines.nextElement());
                }
                mimeMessage2.setContent(generate);
                mimeMessage2.saveChanges();
                SMIMEEnvelopedGenerator sMIMEEnvelopedGenerator = new SMIMEEnvelopedGenerator();
                sMIMEEnvelopedGenerator.addRecipientInfoGenerator(new JceKeyTransRecipientInfoGenerator((X509Certificate) certificateChain[0]).setProvider("BC"));
                MimeBodyPart generate2 = sMIMEEnvelopedGenerator.generate(mimeMessage2, new JceCMSContentEncryptorBuilder(CMSAlgorithm.RC2_CBC).setProvider("BC").build());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                generate2.writeTo(byteArrayOutputStream);
                MimeMessage mimeMessage3 = new MimeMessage(defaultInstance, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                Enumeration allHeaderLines2 = mimeMessage.getAllHeaderLines();
                while (allHeaderLines2.hasMoreElements()) {
                    String str = (String) allHeaderLines2.nextElement();
                    if (!Strings.toLowerCase(str).startsWith("content-")) {
                        mimeMessage3.addHeaderLine(str);
                    }
                }
                Transport.send(mimeMessage3);
                return;
            }
            throw new Exception("cannot find private key for alias: " + strArr[2]);
        } catch (SMIMEException e) {
            e.getUnderlyingException().printStackTrace(System.err);
            e.printStackTrace(System.err);
        } catch (Exception e2) {
            e2.printStackTrace(System.err);
        }
    }
}
