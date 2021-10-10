package org.bouncycastle.openpgp.examples;

import androidx.core.os.EnvironmentCompat;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.security.Security;
import java.util.Iterator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.util.encoders.Hex;

public class PubringDump {
    public static String getAlgorithm(int i) {
        if (i == 1) {
            return "RSA_GENERAL";
        }
        if (i == 2) {
            return "RSA_ENCRYPT";
        }
        if (i == 3) {
            return "RSA_SIGN";
        }
        switch (i) {
            case 16:
                return "ELGAMAL_ENCRYPT";
            case 17:
                return "DSA";
            case 18:
                return "EC";
            case 19:
                return "ECDSA";
            case 20:
                return "ELGAMAL_GENERAL";
            case 21:
                return "DIFFIE_HELLMAN";
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static void main(String[] strArr) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        PGPUtil.setDefaultProvider("BC");
        Iterator keyRings = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(new FileInputStream(strArr[0]))).getKeyRings();
        while (keyRings.hasNext()) {
            PGPPublicKeyRing pGPPublicKeyRing = (PGPPublicKeyRing) keyRings.next();
            try {
                pGPPublicKeyRing.getPublicKey();
                Iterator publicKeys = pGPPublicKeyRing.getPublicKeys();
                boolean z = true;
                while (publicKeys.hasNext()) {
                    PGPPublicKey pGPPublicKey = (PGPPublicKey) publicKeys.next();
                    if (z) {
                        PrintStream printStream = System.out;
                        printStream.println("Key ID: " + Long.toHexString(pGPPublicKey.getKeyID()));
                        z = false;
                    } else {
                        PrintStream printStream2 = System.out;
                        printStream2.println("Key ID: " + Long.toHexString(pGPPublicKey.getKeyID()) + " (subkey)");
                    }
                    PrintStream printStream3 = System.out;
                    printStream3.println("            Algorithm: " + getAlgorithm(pGPPublicKey.getAlgorithm()));
                    PrintStream printStream4 = System.out;
                    printStream4.println("            Fingerprint: " + new String(Hex.encode(pGPPublicKey.getFingerprint())));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
