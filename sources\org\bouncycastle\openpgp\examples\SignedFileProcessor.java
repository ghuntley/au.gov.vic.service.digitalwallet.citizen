package org.bouncycastle.openpgp.examples;

import java.io.File;
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
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPOnePassSignature;
import org.bouncycastle.openpgp.PGPOnePassSignatureList;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSignatureGenerator;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPUtil;

public class SignedFileProcessor {
    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        if (strArr[0].equals("-s")) {
            if (strArr[1].equals("-a")) {
                FileInputStream fileInputStream = new FileInputStream(strArr[3]);
                signFile(strArr[2], fileInputStream, new FileOutputStream(strArr[2] + ".asc"), strArr[4].toCharArray(), true);
                return;
            }
            FileInputStream fileInputStream2 = new FileInputStream(strArr[2]);
            signFile(strArr[1], fileInputStream2, new FileOutputStream(strArr[1] + ".bpg"), strArr[3].toCharArray(), false);
        } else if (strArr[0].equals("-v")) {
            verifyFile(new FileInputStream(strArr[1]), new FileInputStream(strArr[2]));
        } else {
            System.err.println("usage: SignedFileProcessor -v|-s [-a] file keyfile [passPhrase]");
        }
    }

    private static void signFile(String str, InputStream inputStream, OutputStream outputStream, char[] cArr, boolean z) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, PGPException, SignatureException {
        if (z) {
            outputStream = new ArmoredOutputStream(outputStream);
        }
        PGPSecretKey readSecretKey = PGPExampleUtil.readSecretKey(inputStream);
        PGPPrivateKey extractPrivateKey = readSecretKey.extractPrivateKey(cArr, "BC");
        PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(readSecretKey.getPublicKey().getAlgorithm(), 2, "BC");
        pGPSignatureGenerator.initSign(0, extractPrivateKey);
        Iterator userIDs = readSecretKey.getPublicKey().getUserIDs();
        if (userIDs.hasNext()) {
            PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = new PGPSignatureSubpacketGenerator();
            pGPSignatureSubpacketGenerator.setSignerUserID(false, (String) userIDs.next());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketGenerator.generate());
        }
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(2);
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(pGPCompressedDataGenerator.open(outputStream));
        pGPSignatureGenerator.generateOnePassVersion(false).encode(bCPGOutputStream);
        File file = new File(str);
        PGPLiteralDataGenerator pGPLiteralDataGenerator = new PGPLiteralDataGenerator();
        OutputStream open = pGPLiteralDataGenerator.open(bCPGOutputStream, 'b', file);
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            int read = fileInputStream.read();
            if (read < 0) {
                break;
            }
            open.write(read);
            pGPSignatureGenerator.update((byte) read);
        }
        pGPLiteralDataGenerator.close();
        pGPSignatureGenerator.generate().encode(bCPGOutputStream);
        pGPCompressedDataGenerator.close();
        if (z) {
            outputStream.close();
        }
    }

    private static void verifyFile(InputStream inputStream, InputStream inputStream2) throws Exception {
        String str;
        PrintStream printStream;
        PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(((PGPCompressedData) new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream)).nextObject()).getDataStream());
        PGPOnePassSignature pGPOnePassSignature = ((PGPOnePassSignatureList) pGPObjectFactory.nextObject()).get(0);
        PGPLiteralData pGPLiteralData = (PGPLiteralData) pGPObjectFactory.nextObject();
        InputStream inputStream3 = pGPLiteralData.getInputStream();
        PGPPublicKey publicKey = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream2)).getPublicKey(pGPOnePassSignature.getKeyID());
        FileOutputStream fileOutputStream = new FileOutputStream(pGPLiteralData.getFileName());
        pGPOnePassSignature.initVerify(publicKey, "BC");
        while (true) {
            int read = inputStream3.read();
            if (read < 0) {
                break;
            }
            pGPOnePassSignature.update((byte) read);
            fileOutputStream.write(read);
        }
        fileOutputStream.close();
        if (pGPOnePassSignature.verify(((PGPSignatureList) pGPObjectFactory.nextObject()).get(0))) {
            printStream = System.out;
            str = "signature verified.";
        } else {
            printStream = System.out;
            str = "signature verification failed.";
        }
        printStream.println(str);
    }
}
