package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPBEEncryptedData;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.util.io.Streams;

public class PBEFileProcessor {
    private static void decryptFile(InputStream inputStream, char[] cArr) throws IOException, NoSuchProviderException, PGPException {
        String str;
        PrintStream printStream;
        PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream));
        Object nextObject = pGPObjectFactory.nextObject();
        if (!(nextObject instanceof PGPEncryptedDataList)) {
            nextObject = pGPObjectFactory.nextObject();
        }
        PGPPBEEncryptedData pGPPBEEncryptedData = (PGPPBEEncryptedData) ((PGPEncryptedDataList) nextObject).get(0);
        Object nextObject2 = new PGPObjectFactory(pGPPBEEncryptedData.getDataStream(cArr, "BC")).nextObject();
        if (nextObject2 instanceof PGPCompressedData) {
            nextObject2 = new PGPObjectFactory(((PGPCompressedData) nextObject2).getDataStream()).nextObject();
        }
        PGPLiteralData pGPLiteralData = (PGPLiteralData) nextObject2;
        InputStream inputStream2 = pGPLiteralData.getInputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pGPLiteralData.getFileName()));
        Streams.pipeAll(inputStream2, bufferedOutputStream);
        bufferedOutputStream.close();
        if (!pGPPBEEncryptedData.isIntegrityProtected()) {
            printStream = System.err;
            str = "no message integrity check";
        } else if (!pGPPBEEncryptedData.verify()) {
            printStream = System.err;
            str = "message failed integrity check";
        } else {
            printStream = System.err;
            str = "message integrity check passed";
        }
        printStream.println(str);
    }

    private static void decryptFile(String str, char[] cArr) throws IOException, NoSuchProviderException, PGPException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        decryptFile(bufferedInputStream, cArr);
        bufferedInputStream.close();
    }

    private static void encryptFile(OutputStream outputStream, String str, char[] cArr, boolean z, boolean z2) throws IOException, NoSuchProviderException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        try {
            byte[] compressFile = PGPExampleUtil.compressFile(str, 1);
            PGPEncryptedDataGenerator pGPEncryptedDataGenerator = new PGPEncryptedDataGenerator(3, z2, new SecureRandom(), "BC");
            pGPEncryptedDataGenerator.addMethod(cArr);
            OutputStream open = pGPEncryptedDataGenerator.open(outputStream, (long) compressFile.length);
            open.write(compressFile);
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

    private static void encryptFile(String str, String str2, char[] cArr, boolean z, boolean z2) throws IOException, NoSuchProviderException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        encryptFile(bufferedOutputStream, str2, cArr, z, z2);
        bufferedOutputStream.close();
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        boolean z = false;
        if (strArr[0].equals("-e")) {
            if (strArr[1].equals("-a") || strArr[1].equals("-ai") || strArr[1].equals("-ia")) {
                String str = strArr[2] + ".asc";
                String str2 = strArr[2];
                char[] charArray = strArr[3].toCharArray();
                if (strArr[1].indexOf(105) > 0) {
                    z = true;
                }
                encryptFile(str, str2, charArray, true, z);
            } else if (strArr[1].equals("-i")) {
                encryptFile(strArr[2] + ".bpg", strArr[2], strArr[3].toCharArray(), false, true);
            } else {
                encryptFile(strArr[1] + ".bpg", strArr[1], strArr[2].toCharArray(), false, false);
            }
        } else if (strArr[0].equals("-d")) {
            decryptFile(strArr[1], strArr[2].toCharArray());
        } else {
            System.err.println("usage: PBEFileProcessor -e [-ai]|-d file passPhrase");
        }
    }
}
