package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.ByteUtils;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSA1_5 {
    public static byte[] encryptCEK(RSAPublicKey rSAPublicKey, SecretKey secretKey, Provider provider) throws JOSEException {
        try {
            Cipher instance = CipherHelper.getInstance("RSA/ECB/PKCS1Padding", provider);
            instance.init(1, rSAPublicKey);
            return instance.doFinal(secretKey.getEncoded());
        } catch (IllegalBlockSizeException e) {
            throw new JOSEException("RSA block size exception: The RSA key is too short, try a longer one", e);
        } catch (Exception e2) {
            throw new JOSEException("Couldn't encrypt Content Encryption Key (CEK): " + e2.getMessage(), e2);
        }
    }

    public static SecretKey decryptCEK(PrivateKey privateKey, byte[] bArr, int i, Provider provider) throws JOSEException {
        try {
            Cipher instance = CipherHelper.getInstance("RSA/ECB/PKCS1Padding", provider);
            instance.init(2, privateKey);
            byte[] doFinal = instance.doFinal(bArr);
            if (ByteUtils.safeBitLength(doFinal) != i) {
                return null;
            }
            return new SecretKeySpec(doFinal, "AES");
        } catch (Exception e) {
            throw new JOSEException("Couldn't decrypt Content Encryption Key (CEK): " + e.getMessage(), e);
        }
    }

    private RSA1_5() {
    }
}
