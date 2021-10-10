package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;
import java.util.Iterator;
import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPUtil;

public class ClearSignedFileProcessor {
    private static int getLengthWithoutSeparatorOrTrailingWhitespace(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && isWhiteSpace(bArr[length])) {
            length--;
        }
        return length + 1;
    }

    private static int getLengthWithoutWhiteSpace(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && isWhiteSpace(bArr[length])) {
            length--;
        }
        return length + 1;
    }

    private static byte[] getLineSeparator() {
        String property = System.getProperty("line.separator");
        int length = property.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) property.charAt(i);
        }
        return bArr;
    }

    private static boolean isLineEnding(byte b) {
        return b == 13 || b == 10;
    }

    private static boolean isWhiteSpace(byte b) {
        return isLineEnding(b) || b == 9 || b == 32;
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr[0].equals("-s")) {
            InputStream decoderStream = PGPUtil.getDecoderStream(new FileInputStream(strArr[2]));
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1] + ".asc");
            if (strArr.length == 4) {
                signFile(strArr[1], decoderStream, fileOutputStream, strArr[3].toCharArray(), "SHA1");
            } else {
                signFile(strArr[1], decoderStream, fileOutputStream, strArr[3].toCharArray(), strArr[4]);
            }
        } else if (strArr[0].equals("-v")) {
            if (strArr[1].indexOf(".asc") < 0) {
                System.err.println("file needs to end in \".asc\"");
                System.exit(1);
            }
            verifyFile(new FileInputStream(strArr[1]), PGPUtil.getDecoderStream(new FileInputStream(strArr[2])), strArr[1].substring(0, strArr[1].length() - 4));
        } else {
            System.err.println("usage: ClearSignedFileProcessor [-s file keyfile passPhrase]|[-v sigFile keyFile]");
        }
    }

    private static void processLine(OutputStream outputStream, PGPSignatureGenerator pGPSignatureGenerator, byte[] bArr) throws SignatureException, IOException {
        int lengthWithoutWhiteSpace = getLengthWithoutWhiteSpace(bArr);
        if (lengthWithoutWhiteSpace > 0) {
            pGPSignatureGenerator.update(bArr, 0, lengthWithoutWhiteSpace);
        }
        outputStream.write(bArr, 0, bArr.length);
    }

    private static void processLine(PGPSignature pGPSignature, byte[] bArr) throws SignatureException, IOException {
        int lengthWithoutWhiteSpace = getLengthWithoutWhiteSpace(bArr);
        if (lengthWithoutWhiteSpace > 0) {
            pGPSignature.update(bArr, 0, lengthWithoutWhiteSpace);
        }
    }

    private static int readInputLine(ByteArrayOutputStream byteArrayOutputStream, int i, InputStream inputStream) throws IOException {
        byteArrayOutputStream.reset();
        int i2 = i;
        while (true) {
            byteArrayOutputStream.write(i2);
            if (i2 != 13 && i2 != 10) {
                i2 = inputStream.read();
                if (i2 < 0) {
                    break;
                }
            } else {
                i = readPassedEOL(byteArrayOutputStream, i2, inputStream);
            }
        }
        i = readPassedEOL(byteArrayOutputStream, i2, inputStream);
        if (i2 < 0) {
            return -1;
        }
        return i;
    }

    private static int readInputLine(ByteArrayOutputStream byteArrayOutputStream, InputStream inputStream) throws IOException {
        int read;
        byteArrayOutputStream.reset();
        do {
            read = inputStream.read();
            if (read >= 0) {
                byteArrayOutputStream.write(read);
                if (read == 13) {
                    break;
                }
            } else {
                return -1;
            }
        } while (read != 10);
        return readPassedEOL(byteArrayOutputStream, read, inputStream);
    }

    private static int readPassedEOL(ByteArrayOutputStream byteArrayOutputStream, int i, InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (i != 13 || read != 10) {
            return read;
        }
        byteArrayOutputStream.write(read);
        return inputStream.read();
    }

    private static void signFile(String str, InputStream inputStream, OutputStream outputStream, char[] cArr, String str2) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, PGPException, SignatureException {
        int i = str2.equals("SHA256") ? 8 : str2.equals("SHA384") ? 9 : str2.equals("SHA512") ? 10 : str2.equals("MD5") ? 1 : str2.equals("RIPEMD160") ? 3 : 2;
        PGPSecretKey readSecretKey = PGPExampleUtil.readSecretKey(inputStream);
        PGPPrivateKey extractPrivateKey = readSecretKey.extractPrivateKey(cArr, "BC");
        PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(readSecretKey.getPublicKey().getAlgorithm(), i, "BC");
        PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
        pGPSignatureGenerator.initSign(1, extractPrivateKey);
        Iterator userIDs = readSecretKey.getPublicKey().getUserIDs();
        if (userIDs.hasNext()) {
            pGPSignatureSubpacketGenerator.setSignerUserID(false, (String) userIDs.next());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketGenerator.generate());
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(outputStream);
        armoredOutputStream.beginClearText(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int readInputLine = readInputLine(byteArrayOutputStream, bufferedInputStream);
        processLine(armoredOutputStream, pGPSignatureGenerator, byteArrayOutputStream.toByteArray());
        if (readInputLine != -1) {
            do {
                readInputLine = readInputLine(byteArrayOutputStream, readInputLine, bufferedInputStream);
                pGPSignatureGenerator.update((byte) 13);
                pGPSignatureGenerator.update((byte) 10);
                processLine(armoredOutputStream, pGPSignatureGenerator, byteArrayOutputStream.toByteArray());
            } while (readInputLine != -1);
        }
        bufferedInputStream.close();
        armoredOutputStream.endClearText();
        pGPSignatureGenerator.generate().encode(new BCPGOutputStream(armoredOutputStream));
        armoredOutputStream.close();
    }

    private static void verifyFile(InputStream inputStream, InputStream inputStream2, String str) throws Exception {
        String str2;
        PrintStream printStream;
        ArmoredInputStream armoredInputStream = new ArmoredInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int readInputLine = readInputLine(byteArrayOutputStream, armoredInputStream);
        byte[] lineSeparator = getLineSeparator();
        if (readInputLine != -1 && armoredInputStream.isClearText()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedOutputStream.write(byteArray, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray));
            while (true) {
                bufferedOutputStream.write(lineSeparator);
                if (readInputLine == -1 || !armoredInputStream.isClearText()) {
                    break;
                }
                readInputLine = readInputLine(byteArrayOutputStream, readInputLine, armoredInputStream);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                bufferedOutputStream.write(byteArray2, 0, getLengthWithoutSeparatorOrTrailingWhitespace(byteArray2));
            }
        }
        bufferedOutputStream.close();
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = new PGPPublicKeyRingCollection(inputStream2);
        PGPSignature pGPSignature = ((PGPSignatureList) new PGPObjectFactory(armoredInputStream).nextObject()).get(0);
        pGPSignature.initVerify(pGPPublicKeyRingCollection.getPublicKey(pGPSignature.getKeyID()), "BC");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        int readInputLine2 = readInputLine(byteArrayOutputStream, bufferedInputStream);
        processLine(pGPSignature, byteArrayOutputStream.toByteArray());
        if (readInputLine2 != -1) {
            do {
                readInputLine2 = readInputLine(byteArrayOutputStream, readInputLine2, bufferedInputStream);
                pGPSignature.update((byte) 13);
                pGPSignature.update((byte) 10);
                processLine(pGPSignature, byteArrayOutputStream.toByteArray());
            } while (readInputLine2 != -1);
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
}
