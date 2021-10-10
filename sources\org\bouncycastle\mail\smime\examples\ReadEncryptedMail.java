package org.bouncycastle.mail.smime.examples;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientId;
import org.bouncycastle.mail.smime.SMIMEEnveloped;
import org.bouncycastle.mail.smime.SMIMEUtil;

public class ReadEncryptedMail {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 2) {
            System.err.println("usage: ReadEncryptedMail pkcs12Keystore password");
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
        MimeBodyPart mimeBodyPart = SMIMEUtil.toMimeBodyPart(new SMIMEEnveloped(new MimeMessage(Session.getDefaultInstance(System.getProperties(), (Authenticator) null), new FileInputStream("encrypted.message"))).getRecipientInfos().get(new JceKeyTransRecipientId((X509Certificate) instance.getCertificate(str))).getContent(new JceKeyTransEnvelopedRecipient((PrivateKey) instance.getKey(str, null)).setProvider("BC")));
        System.out.println("Message Contents");
        System.out.println("----------------");
        System.out.println(mimeBodyPart.getContent());
    }
}
