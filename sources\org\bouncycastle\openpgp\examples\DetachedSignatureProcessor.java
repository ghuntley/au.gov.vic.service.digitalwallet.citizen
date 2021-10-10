package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.GeneralSecurityException;
import java.security.Security;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPUtil;

public class DetachedSignatureProcessor {
    private static void createSignature(String str, InputStream inputStream, OutputStream outputStream, char[] cArr, boolean z) throws GeneralSecurityException, IOException, PGPException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        PGPSecretKey readSecretKey = PGPExampleUtil.readSecretKey(inputStream);
        PGPPrivateKey extractPrivateKey = readSecretKey.extractPrivateKey(cArr, "BC");
        PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(readSecretKey.getPublicKey().getAlgorithm(), 2, "BC");
        pGPSignatureGenerator.initSign(0, extractPrivateKey);
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(outputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        while (true) {
            int read = bufferedInputStream.read();
            if (read < 0) {
                break;
            }
            pGPSignatureGenerator.update((byte) read);
        }
        bufferedInputStream.close();
        pGPSignatureGenerator.generate().encode(bCPGOutputStream);
        if (z) {
            outputStream.close();
        }
    }

    private static void createSignature(String str, String str2, String str3, char[] cArr, boolean z) throws GeneralSecurityException, IOException, PGPException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
        createSignature(str, bufferedInputStream, bufferedOutputStream, cArr, z);
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr[0].equals("-s")) {
            if (strArr[1].equals("-a")) {
                String str = strArr[2];
                String str2 = strArr[3];
                createSignature(str, str2, strArr[2] + ".asc", strArr[4].toCharArray(), true);
                return;
            }
            String str3 = strArr[1];
            String str4 = strArr[2];
            createSignature(str3, str4, strArr[1] + ".bpg", strArr[3].toCharArray(), false);
        } else if (strArr[0].equals("-v")) {
            verifySignature(strArr[1], strArr[2], strArr[3]);
        } else {
            System.err.println("usage: DetachedSignatureProcessor [-s [-a] file keyfile passPhrase]|[-v file sigFile keyFile]");
        }
    }

    private static void verifySignature(String str, InputStream inputStream, InputStream inputStream2) throws GeneralSecurityException, IOException, PGPException {
        String str2;
        PrintStream printStream;
        Object nextObject = new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream)).nextObject();
        if (nextObject instanceof PGPCompressedData) {
            nextObject = new PGPObjectFactory(((PGPCompressedData) nextObject).getDataStream()).nextObject();
        }
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream2));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        PGPSignature pGPSignature = ((PGPSignatureList) nextObject).get(0);
        pGPSignature.initVerify(pGPPublicKeyRingCollection.getPublicKey(pGPSignature.getKeyID()), "BC");
        while (true) {
            int read = bufferedInputStream.read();
            if (read < 0) {
                break;
            }
            pGPSignature.update((byte) read);
        }
        bufferedInputStream.close();
        if (pGPSignature.verify()) {
            printStream = System.out;
            str2 = "signature verified.";
        } else {
            printStream = System.out;
            str2 = "signature verification failed.";
        }
        printStream.println(str2);
    }

    private static void verifySignature(String str, String str2, String str3) throws GeneralSecurityException, IOException, PGPException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str3));
        verifySignature(str, bufferedInputStream, bufferedInputStream2);
        bufferedInputStream2.close();
        bufferedInputStream.close();
    }
}
