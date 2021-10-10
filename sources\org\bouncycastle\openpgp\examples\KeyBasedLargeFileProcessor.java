package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPOnePassSignatureList;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.util.io.Streams;

public class KeyBasedLargeFileProcessor {
    private static void decryptFile(InputStream inputStream, InputStream inputStream2, char[] cArr, String str) throws IOException, NoSuchProviderException {
        PrintStream printStream;
        String str2;
        try {
            PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream));
            Object nextObject = pGPObjectFactory.nextObject();
            if (!(nextObject instanceof PGPEncryptedDataList)) {
                nextObject = pGPObjectFactory.nextObject();
            }
            Iterator encryptedDataObjects = ((PGPEncryptedDataList) nextObject).getEncryptedDataObjects();
            PGPSecretKeyRingCollection pGPSecretKeyRingCollection = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream2));
            PGPPrivateKey pGPPrivateKey = null;
            PGPPublicKeyEncryptedData pGPPublicKeyEncryptedData = null;
            while (pGPPrivateKey == null && encryptedDataObjects.hasNext()) {
                pGPPublicKeyEncryptedData = (PGPPublicKeyEncryptedData) encryptedDataObjects.next();
                pGPPrivateKey = PGPExampleUtil.findSecretKey(pGPSecretKeyRingCollection, pGPPublicKeyEncryptedData.getKeyID(), cArr);
            }
            if (pGPPrivateKey != null) {
                Object nextObject2 = new PGPObjectFactory(new BufferedInputStream(((PGPCompressedData) new PGPObjectFactory(pGPPublicKeyEncryptedData.getDataStream(pGPPrivateKey, "BC")).nextObject()).getDataStream())).nextObject();
                if (nextObject2 instanceof PGPLiteralData) {
                    PGPLiteralData pGPLiteralData = (PGPLiteralData) nextObject2;
                    String fileName = pGPLiteralData.getFileName();
                    if (fileName.length() != 0) {
                        str = fileName;
                    }
                    InputStream inputStream3 = pGPLiteralData.getInputStream();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                    Streams.pipeAll(inputStream3, bufferedOutputStream);
                    bufferedOutputStream.close();
                    if (!pGPPublicKeyEncryptedData.isIntegrityProtected()) {
                        printStream = System.err;
                        str2 = "no message integrity check";
                    } else if (!pGPPublicKeyEncryptedData.verify()) {
                        printStream = System.err;
                        str2 = "message failed integrity check";
                    } else {
                        printStream = System.err;
                        str2 = "message integrity check passed";
                    }
                    printStream.println(str2);
                } else if (nextObject2 instanceof PGPOnePassSignatureList) {
                    throw new PGPException("encrypted message contains a signed message - not literal data.");
                } else {
                    throw new PGPException("message is not a simple encrypted file - type unknown.");
                }
            } else {
                throw new IllegalArgumentException("secret key for message not found.");
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    private static void decryptFile(String str, String str2, char[] cArr, String str3) throws IOException, NoSuchProviderException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str2));
        decryptFile(bufferedInputStream, bufferedInputStream2, cArr, str3);
        bufferedInputStream2.close();
        bufferedInputStream.close();
    }

    private static void encryptFile(OutputStream outputStream, String str, PGPPublicKey pGPPublicKey, boolean z, boolean z2) throws IOException, NoSuchProviderException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        try {
            PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(3, z2, new SecureRandom(), "BC");
            pGPEncryptedDataGenerator.addMethod(pGPPublicKey);
            OutputStream open = pGPEncryptedDataGenerator.open(outputStream, new byte[65536]);
            PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(1);
            PGPUtil.writeFileToLiteralData(pGPCompressedDataGenerator.open(open), 'b', new File(str), new byte[65536]);
            pGPCompressedDataGenerator.close();
            open.close();
            if (z) {
                outputStream.close();
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    private static void encryptFile(String str, String str2, String str3, boolean z, boolean z2) throws IOException, NoSuchProviderException, PGPException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        encryptFile(bufferedOutputStream, str2, PGPExampleUtil.readPublicKey(str3), z, z2);
        bufferedOutputStream.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr.length == 0) {
            System.err.println("usage: KeyBasedLargeFileProcessor -e|-d [-a|ai] file [secretKeyFile passPhrase|pubKeyFile]");
            return;
        }
        boolean z = false;
        if (strArr[0].equals("-e")) {
            if (strArr[1].equals("-a") || strArr[1].equals("-ai") || strArr[1].equals("-ia")) {
                String str = strArr[2] + ".asc";
                String str2 = strArr[2];
                String str3 = strArr[3];
                if (strArr[1].indexOf(105) > 0) {
                    z = true;
                }
                encryptFile(str, str2, str3, true, z);
            } else if (strArr[1].equals("-i")) {
                encryptFile(strArr[2] + ".bpg", strArr[2], strArr[3], false, true);
            } else {
                encryptFile(strArr[1] + ".bpg", strArr[1], strArr[2], false, false);
            }
        } else if (strArr[0].equals("-d")) {
            decryptFile(strArr[1], strArr[2], strArr[3].toCharArray(), new File(strArr[1]).getName() + ".out");
        } else {
            System.err.println("usage: KeyBasedLargeFileProcessor -d|-e [-a|ai] file [secretKeyFile passPhrase|pubKeyFile]");
        }
    }
}
