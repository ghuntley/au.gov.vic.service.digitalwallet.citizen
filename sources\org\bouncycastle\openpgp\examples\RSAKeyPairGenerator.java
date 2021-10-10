package org.bouncycastle.openpgp.examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.util.Date;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKey;

public class RSAKeyPairGenerator {
    private static void exportKeyPair(OutputStream outputStream, OutputStream outputStream2, PublicKey publicKey, PrivateKey privateKey, String str, char[] cArr, boolean z) throws IOException, InvalidKeyException, NoSuchProviderException, SignatureException, PGPException {
        OutputStream armoredOutputStream = z ? new ArmoredOutputStream(outputStream) : outputStream;
        PGPSecretKey pGPSecretKey = new PGPSecretKey(16, 1, publicKey, privateKey, new Date(), str, 3, cArr, null, null, new SecureRandom(), "BC");
        pGPSecretKey.encode(armoredOutputStream);
        armoredOutputStream.close();
        OutputStream armoredOutputStream2 = z ? new ArmoredOutputStream(outputStream2) : outputStream2;
        pGPSecretKey.getPublicKey().encode(armoredOutputStream2);
        armoredOutputStream2.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "BC");
        instance.initialize(1024);
        KeyPair generateKeyPair = instance.generateKeyPair();
        if (strArr.length < 2) {
            System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
            System.exit(0);
        }
        if (strArr[0].equals("-a")) {
            if (strArr.length < 3) {
                System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
                System.exit(0);
            }
            exportKeyPair(new FileOutputStream("secret.asc"), new FileOutputStream("pub.asc"), generateKeyPair.getPublic(), generateKeyPair.getPrivate(), strArr[1], strArr[2].toCharArray(), true);
            return;
        }
        exportKeyPair(new FileOutputStream("secret.bpg"), new FileOutputStream("pub.bpg"), generateKeyPair.getPublic(), generateKeyPair.getPrivate(), strArr[0], strArr[1].toCharArray(), false);
    }
}
