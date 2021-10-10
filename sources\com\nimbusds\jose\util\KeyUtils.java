package com.nimbusds.jose.util;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class KeyUtils {
    public static SecretKey toAESKey(SecretKey secretKey) {
        if (secretKey == null) {
            return null;
        }
        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    }

    private KeyUtils() {
    }
}
