package org.bouncycastle.mail.smime.examples;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientId;
import org.bouncycastle.mail.smime.SMIMEEnvelopedParser;
import org.bouncycastle.mail.smime.SMIMEUtil;
import org.bouncycastle.mail.smime.util.SharedFileInputStream;

public class ReadLargeEncryptedMail {
    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 3) {
            System.err.println("usage: ReadLargeEncryptedMail pkcs12Keystore password outputFile");
            System.exit(0);
        }
        KeyStore instance = KeyStore.getInstance("PKCS12", "BC");
        String findKeyAlias = ExampleUtils.findKeyAlias(instance, strArr[0], strArr[1].toCharArray());
        ExampleUtils.dumpContent(SMIMEUtil.toMimeBodyPart(new SMIMEEnvelopedParser(new MimeMessage(Session.getDefaultInstance(System.getProperties(), (Authenticator) null), new SharedFileInputStream("encrypted.message"))).getRecipientInfos().get(new JceKeyTransRecipientId((X509Certificate) instance.getCertificate(findKeyAlias))).getContentStream(new JceKeyTransEnvelopedRecipient((PrivateKey) instance.getKey(findKeyAlias, null)).setProvider("BC"))), strArr[2]);
    }
}
