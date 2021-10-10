package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class PBKDF2 {
    public static byte[] ZERO_BYTE = {0};

    public static byte[] formatSalt(JWEAlgorithm jWEAlgorithm, byte[] bArr) throws JOSEException {
        byte[] bytes = jWEAlgorithm.toString().getBytes(StandardCharset.UTF_8);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bytes);
            byteArrayOutputStream.write(ZERO_BYTE);
            byteArrayOutputStream.write(bArr);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static SecretKey deriveKey(byte[] bArr, byte[] bArr2, int i, PRFParams pRFParams) throws JOSEException {
        Mac initMac = HMAC.getInitMac(new SecretKeySpec(bArr, pRFParams.getMACAlgorithm()), pRFParams.getMacProvider());
        int macLength = initMac.getMacLength();
        if (((long) pRFParams.getDerivedKeyByteLength()) <= 4294967295L) {
            int ceil = (int) Math.ceil(((double) pRFParams.getDerivedKeyByteLength()) / ((double) macLength));
            int i2 = ceil - 1;
            int derivedKeyByteLength = pRFParams.getDerivedKeyByteLength() - (macLength * i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (i3 < ceil) {
                int i4 = i3 + 1;
                byte[] extractBlock = extractBlock(bArr2, i, i4, initMac);
                if (i3 == i2) {
                    extractBlock = ByteUtils.subArray(extractBlock, 0, derivedKeyByteLength);
                }
                byteArrayOutputStream.write(extractBlock, 0, extractBlock.length);
                i3 = i4;
            }
            return new SecretKeySpec(byteArrayOutputStream.toByteArray(), "AES");
        }
        throw new JOSEException("derived key too long " + pRFParams.getDerivedKeyByteLength());
    }

    private static byte[] extractBlock(byte[] bArr, int i, int i2, Mac mac) {
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        for (int i3 = 1; i3 <= i; i3++) {
            if (i3 == 1) {
                bArr2 = mac.doFinal(ByteUtils.concat(bArr, IntegerUtils.toBytes(i2)));
                bArr3 = bArr2;
            } else {
                bArr3 = mac.doFinal(bArr3);
                for (int i4 = 0; i4 < bArr3.length; i4++) {
                    bArr2[i4] = (byte) (bArr3[i4] ^ bArr2[i4]);
                }
            }
        }
        return bArr2;
    }

    private PBKDF2() {
    }
}
