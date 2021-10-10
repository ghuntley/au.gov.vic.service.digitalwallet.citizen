package org.bouncycastle.openpgp.examples;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.util.Iterator;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;

class PGPExampleUtil {
    PGPExampleUtil() {
    }

    static byte[] compressFile(String str, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PGPCompressedDataGenerator pGPCompressedDataGenerator = new PGPCompressedDataGenerator(i);
        PGPUtil.writeFileToLiteralData(pGPCompressedDataGenerator.open(byteArrayOutputStream), 'b', new File(str));
        pGPCompressedDataGenerator.close();
        return byteArrayOutputStream.toByteArray();
    }

    static PGPPrivateKey findSecretKey(PGPSecretKeyRingCollection pGPSecretKeyRingCollection, long j, char[] cArr) throws PGPException, NoSuchProviderException {
        PGPSecretKey secretKey = pGPSecretKeyRingCollection.getSecretKey(j);
        if (secretKey == null) {
            return null;
        }
        return secretKey.extractPrivateKey(cArr, "BC");
    }

    static PGPPublicKey readPublicKey(InputStream inputStream) throws IOException, PGPException {
        Iterator keyRings = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream)).getKeyRings();
        while (keyRings.hasNext()) {
            Iterator publicKeys = ((PGPPublicKeyRing) keyRings.next()).getPublicKeys();
            while (true) {
                if (publicKeys.hasNext()) {
                    PGPPublicKey pGPPublicKey = (PGPPublicKey) publicKeys.next();
                    if (pGPPublicKey.isEncryptionKey()) {
                        return pGPPublicKey;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Can't find encryption key in key ring.");
    }

    static PGPPublicKey readPublicKey(String str) throws IOException, PGPException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        PGPPublicKey readPublicKey = readPublicKey(bufferedInputStream);
        bufferedInputStream.close();
        return readPublicKey;
    }

    static PGPSecretKey readSecretKey(InputStream inputStream) throws IOException, PGPException {
        Iterator keyRings = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream)).getKeyRings();
        while (keyRings.hasNext()) {
            Iterator secretKeys = ((PGPSecretKeyRing) keyRings.next()).getSecretKeys();
            while (true) {
                if (secretKeys.hasNext()) {
                    PGPSecretKey pGPSecretKey = (PGPSecretKey) secretKeys.next();
                    if (pGPSecretKey.isSigningKey()) {
                        return pGPSecretKey;
                    }
                }
            }
        }
        throw new IllegalArgumentException("Can't find signing key in key ring.");
    }

    static PGPSecretKey readSecretKey(String str) throws IOException, PGPException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        PGPSecretKey readSecretKey = readSecretKey(bufferedInputStream);
        bufferedInputStream.close();
        return readSecretKey;
    }
}
