package org.bouncycastle.mail.smime.examples;

import java.io.FileOutputStream;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.mail.smime.SMIMECompressedGenerator;

public class CreateCompressedMail {
    public static void main(String[] strArr) throws Exception {
        SMIMECompressedGenerator sMIMECompressedGenerator = new SMIMECompressedGenerator();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText("Hello world!");
        MimeBodyPart generate = sMIMECompressedGenerator.generate(mimeBodyPart, "1.2.840.113549.1.9.16.3.8");
        Session defaultInstance = Session.getDefaultInstance(System.getProperties(), (Authenticator) null);
        InternetAddress internetAddress = new InternetAddress("\"Eric H. Echidna\"<eric@bouncycastle.org>");
        InternetAddress internetAddress2 = new InternetAddress("example@bouncycastle.org");
        MimeMessage mimeMessage = new MimeMessage(defaultInstance);
        mimeMessage.setFrom(internetAddress);
        mimeMessage.setRecipient(Message.RecipientType.TO, internetAddress2);
        mimeMessage.setSubject("example compressed message");
        mimeMessage.setContent(generate.getContent(), generate.getContentType());
        mimeMessage.saveChanges();
        mimeMessage.writeTo(new FileOutputStream("compressed.message"));
    }
}
