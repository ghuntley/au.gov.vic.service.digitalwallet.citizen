package org.bouncycastle.mail.smime.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.mail.smime.SMIMEEnvelopedGenerator;

public class CreateEncryptedMail {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 2) {
            System.err.println("usage: CreateEncryptedMail pkcs12Keystore password");
            System.exit(0);
        }
        KeyStore instance = KeyStore.getInstance("PKCS12", "BC");
        instance.load(new FileInputStream(strArr[0]), strArr[1].toCharArray());
        Enumeration<String> aliases = instance.aliases();
        String str = null;
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            if (instance.isKeyEntry(nextElement)) {
                str = nextElement;
            }
        }
        if (str == null) {
            System.err.println("can't find a private key!");
            System.exit(0);
        }
        Certificate[] certificateChain = instance.getCertificateChain(str);
        SMIMEEnvelopedGenerator sMIMEEnvelopedGenerator = new SMIMEEnvelopedGenerator();
        sMIMEEnvelopedGenerator.addKeyTransRecipient((X509Certificate) certificateChain[0]);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText("Hello world!");
        MimeBodyPart generate = sMIMEEnvelopedGenerator.generate(mimeBodyPart, SMIMEEnvelopedGenerator.RC2_CBC, "BC");
        Session defaultInstance = Session.getDefaultInstance(System.getProperties(), (Authenticator) null);
        InternetAddress internetAddress = new InternetAddress("\"Eric H. Echidna\"<eric@bouncycastle.org>");
        InternetAddress internetAddress2 = new InternetAddress("example@bouncycastle.org");
        MimeMessage mimeMessage = new MimeMessage(defaultInstance);
        mimeMessage.setFrom(internetAddress);
        mimeMessage.setRecipient(Message.RecipientType.TO, internetAddress2);
        mimeMessage.setSubject("example encrypted message");
        mimeMessage.setContent(generate.getContent(), generate.getContentType());
        mimeMessage.saveChanges();
        mimeMessage.writeTo(new FileOutputStream("encrypted.message"));
    }
}
