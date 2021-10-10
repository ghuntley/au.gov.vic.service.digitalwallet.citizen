package com.nimbusds.jose.crypto.impl;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CipherHelper {
    public static Cipher getInstance(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (provider == null) {
            return Cipher.getInstance(str);
        }
        return Cipher.getInstance(str, provider);
    }
}
