package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import com.nimbusds.jose.util.KeyUtils;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class AESGCM {
    public static final int AUTH_TAG_BIT_LENGTH = 128;
    public static final int IV_BIT_LENGTH = 96;

    public static byte[] generateIV(SecureRandom secureRandom) {
        byte[] bArr = new byte[12];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static AuthenticatedCipherText encrypt(SecretKey secretKey, Container<byte[]> container, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        Cipher cipher;
        SecretKey aESKey = KeyUtils.toAESKey(secretKey);
        byte[] bArr3 = container.get();
        if (provider != null) {
            try {
                cipher = Cipher.getInstance("AES/GCM/NoPadding", provider);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new JOSEException("Couldn't create AES/GCM/NoPadding cipher: " + e.getMessage(), e);
            } catch (NoClassDefFoundError unused) {
                return LegacyAESGCM.encrypt(aESKey, bArr3, bArr, bArr2);
            }
        } else {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
        }
        cipher.init(1, aESKey, new GCMParameterSpec(128, bArr3));
        cipher.updateAAD(bArr2);
        try {
            byte[] doFinal = cipher.doFinal(bArr);
            int length = doFinal.length - ByteUtils.byteLength(128);
            byte[] subArray = ByteUtils.subArray(doFinal, 0, length);
            byte[] subArray2 = ByteUtils.subArray(doFinal, length, ByteUtils.byteLength(128));
            container.set(actualIVOf(cipher));
            return new AuthenticatedCipherText(subArray, subArray2);
        } catch (BadPaddingException | IllegalBlockSizeException e2) {
            throw new JOSEException("Couldn't encrypt with AES/GCM/NoPadding: " + e2.getMessage(), e2);
        }
    }

    private static byte[] actualIVOf(Cipher cipher) throws JOSEException {
        GCMParameterSpec actualParamsOf = actualParamsOf(cipher);
        byte[] iv = actualParamsOf.getIV();
        validate(iv, actualParamsOf.getTLen());
        return iv;
    }

    private static void validate(byte[] bArr, int i) throws JOSEException {
        if (ByteUtils.safeBitLength(bArr) != 96) {
            throw new JOSEException(String.format("IV length of %d bits is required, got %d", 96, Integer.valueOf(ByteUtils.safeBitLength(bArr))));
        } else if (i != 128) {
            throw new JOSEException(String.format("Authentication tag length of %d bits is required, got %d", 128, Integer.valueOf(i)));
        }
    }

    private static GCMParameterSpec actualParamsOf(Cipher cipher) throws JOSEException {
        AlgorithmParameters parameters = cipher.getParameters();
        if (parameters != null) {
            try {
                return (GCMParameterSpec) parameters.getParameterSpec(GCMParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            throw new JOSEException("AES GCM ciphers are expected to make use of algorithm parameters");
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Provider provider) throws JOSEException {
        Cipher cipher;
        SecretKey aESKey = KeyUtils.toAESKey(secretKey);
        if (provider != null) {
            try {
                cipher = Cipher.getInstance("AES/GCM/NoPadding", provider);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new JOSEException("Couldn't create AES/GCM/NoPadding cipher: " + e.getMessage(), e);
            } catch (NoClassDefFoundError unused) {
                return LegacyAESGCM.decrypt(aESKey, bArr, bArr2, bArr3, bArr4);
            }
        } else {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
        }
        cipher.init(2, aESKey, new GCMParameterSpec(128, bArr));
        cipher.updateAAD(bArr3);
        try {
            return cipher.doFinal(ByteUtils.concat(bArr2, bArr4));
        } catch (BadPaddingException | IllegalBlockSizeException e2) {
            throw new JOSEException("AES/GCM/NoPadding decryption failed: " + e2.getMessage(), e2);
        }
    }

    private AESGCM() {
    }
}
