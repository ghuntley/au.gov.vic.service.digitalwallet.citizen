package org.bouncycastle.mail.smime.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.KeyStore;
import java.util.Enumeration;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

public class ExampleUtils {
    public static void dumpContent(MimeBodyPart mimeBodyPart, String str) throws MessagingException, IOException {
        PrintStream printStream = System.out;
        printStream.println("content type: " + mimeBodyPart.getContentType());
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        InputStream inputStream = mimeBodyPart.getInputStream();
        byte[] bArr = new byte[10000];
        while (true) {
            int read = inputStream.read(bArr, 0, 10000);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                return;
            }
        }
    }

    public static String findKeyAlias(KeyStore keyStore, String str, char[] cArr) throws Exception {
        keyStore.load(new FileInputStream(str), cArr);
        Enumeration<String> aliases = keyStore.aliases();
        String str2 = null;
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            if (keyStore.isKeyEntry(nextElement)) {
                str2 = nextElement;
            }
        }
        if (str2 != null) {
            return str2;
        }
        throw new IllegalArgumentException("can't find a private key in keyStore: " + str);
    }
}
