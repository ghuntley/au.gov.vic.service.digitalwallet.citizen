package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class HMAC {
    public static Mac getInitMac(SecretKey secretKey, Provider provider) throws JOSEException {
        Mac mac;
        if (provider != null) {
            try {
                mac = Mac.getInstance(secretKey.getAlgorithm(), provider);
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException("Unsupported HMAC algorithm: " + e.getMessage(), e);
            } catch (InvalidKeyException e2) {
                throw new JOSEException("Invalid HMAC key: " + e2.getMessage(), e2);
            }
        } else {
            mac = Mac.getInstance(secretKey.getAlgorithm());
        }
        mac.init(secretKey);
        return mac;
    }

    public static byte[] compute(String str, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        return compute(new SecretKeySpec(bArr, str), bArr2, provider);
    }

    public static byte[] compute(SecretKey secretKey, byte[] bArr, Provider provider) throws JOSEException {
        Mac initMac = getInitMac(secretKey, provider);
        initMac.update(bArr);
        return initMac.doFinal();
    }
}
