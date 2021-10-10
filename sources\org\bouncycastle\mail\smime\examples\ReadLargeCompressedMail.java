package org.bouncycastle.mail.smime.examples;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.mail.smime.SMIMECompressedParser;
import org.bouncycastle.mail.smime.SMIMEUtil;
import org.bouncycastle.mail.smime.util.SharedFileInputStream;

public class ReadLargeCompressedMail {
    public static void main(String[] strArr) throws Exception {
        ExampleUtils.dumpContent(SMIMEUtil.toMimeBodyPart(new SMIMECompressedParser(new MimeMessage(Session.getDefaultInstance(System.getProperties(), (Authenticator) null), new SharedFileInputStream("compressed.message"))).getContent()), strArr[0]);
    }
}
