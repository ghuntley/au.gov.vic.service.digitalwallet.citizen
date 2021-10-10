package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.KeyUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class AESKW {
    public static byte[] wrapCEK(SecretKey secretKey, SecretKey secretKey2, Provider provider) throws JOSEException {
        Cipher cipher;
        if (provider != null) {
            try {
                cipher = Cipher.getInstance("AESWrap", provider);
            } catch (InvalidKeyException | NoSuchAlgorithmException | IllegalBlockSizeException | NoSuchPaddingException e) {
                throw new JOSEException("Couldn't wrap AES key: " + e.getMessage(), e);
            }
        } else {
            cipher = Cipher.getInstance("AESWrap");
        }
        cipher.init(3, secretKey2);
        return cipher.wrap(secretKey);
    }

    public static SecretKey unwrapCEK(SecretKey secretKey, byte[] bArr, Provider provider) throws JOSEException {
        Cipher cipher;
        if (provider != null) {
            try {
                cipher = Cipher.getInstance("AESWrap", provider);
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new JOSEException("Couldn't unwrap AES key: " + e.getMessage(), e);
            }
        } else {
            cipher = Cipher.getInstance("AESWrap");
        }
        cipher.init(4, KeyUtils.toAESKey(secretKey));
        return (SecretKey) cipher.unwrap(bArr, "AES", 3);
    }

    private AESKW() {
    }
}
