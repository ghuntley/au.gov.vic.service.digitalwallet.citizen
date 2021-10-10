package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.utils.ConstantTimeUtils;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.StandardCharset;
import java.nio.ByteBuffer;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class AESCBC {
    public static final int IV_BIT_LENGTH = 128;

    public static byte[] generateIV(SecureRandom secureRandom) {
        byte[] bArr = new byte[ByteUtils.byteLength(128)];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    private static Cipher createAESCBCCipher(SecretKey secretKey, boolean z, byte[] bArr, Provider provider) throws JOSEException {
        try {
            Cipher instance = CipherHelper.getInstance("AES/CBC/PKCS5Padding", provider);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            if (z) {
                instance.init(1, secretKeySpec, ivParameterSpec);
            } else {
                instance.init(2, secretKeySpec, ivParameterSpec);
            }
            return instance;
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        try {
            return createAESCBCCipher(secretKey, true, bArr, provider).doFinal(bArr2);
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static AuthenticatedCipherText encryptAuthenticated(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, Provider provider, Provider provider2) throws JOSEException {
        CompositeKey compositeKey = new CompositeKey(secretKey);
        byte[] encrypt = encrypt(compositeKey.getAESKey(), bArr, bArr2, provider);
        byte[] computeLength = AAD.computeLength(bArr3);
        return new AuthenticatedCipherText(encrypt, Arrays.copyOf(HMAC.compute(compositeKey.getMACKey(), ByteBuffer.allocate(bArr3.length + bArr.length + encrypt.length + computeLength.length).put(bArr3).put(bArr).put(encrypt).put(computeLength).array(), provider2), compositeKey.getTruncatedMACByteLength()));
    }

    public static AuthenticatedCipherText encryptWithConcatKDF(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, byte[] bArr, byte[] bArr2, Provider provider, Provider provider2) throws JOSEException {
        byte[] bArr3 = null;
        byte[] decode = jWEHeader.getCustomParam("epu") instanceof String ? new Base64URL((String) jWEHeader.getCustomParam("epu")).decode() : null;
        if (jWEHeader.getCustomParam("epv") instanceof String) {
            bArr3 = new Base64URL((String) jWEHeader.getCustomParam("epv")).decode();
        }
        byte[] encrypt = encrypt(LegacyConcatKDF.generateCEK(secretKey, jWEHeader.getEncryptionMethod(), decode, bArr3), bArr, bArr2, provider);
        SecretKey generateCIK = LegacyConcatKDF.generateCIK(secretKey, jWEHeader.getEncryptionMethod(), decode, bArr3);
        return new AuthenticatedCipherText(encrypt, HMAC.compute(generateCIK, (jWEHeader.toBase64URL().toString() + "." + base64URL.toString() + "." + Base64URL.encode(bArr).toString() + "." + Base64URL.encode(encrypt)).getBytes(StandardCharset.UTF_8), provider2));
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr, byte[] bArr2, Provider provider) throws JOSEException {
        try {
            return createAESCBCCipher(secretKey, false, bArr, provider).doFinal(bArr2);
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    public static byte[] decryptAuthenticated(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Provider provider, Provider provider2) throws JOSEException {
        CompositeKey compositeKey = new CompositeKey(secretKey);
        byte[] computeLength = AAD.computeLength(bArr3);
        if (ConstantTimeUtils.areEqual(Arrays.copyOf(HMAC.compute(compositeKey.getMACKey(), ByteBuffer.allocate(bArr3.length + bArr.length + bArr2.length + computeLength.length).put(bArr3).put(bArr).put(bArr2).put(computeLength).array(), provider2), compositeKey.getTruncatedMACByteLength()), bArr4)) {
            return decrypt(compositeKey.getAESKey(), bArr, bArr2, provider);
        }
        throw new JOSEException("MAC check failed");
    }

    public static byte[] decryptWithConcatKDF(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Provider provider, Provider provider2) throws JOSEException {
        byte[] bArr = null;
        byte[] decode = jWEHeader.getCustomParam("epu") instanceof String ? new Base64URL((String) jWEHeader.getCustomParam("epu")).decode() : null;
        if (jWEHeader.getCustomParam("epv") instanceof String) {
            bArr = new Base64URL((String) jWEHeader.getCustomParam("epv")).decode();
        }
        SecretKey generateCIK = LegacyConcatKDF.generateCIK(secretKey, jWEHeader.getEncryptionMethod(), decode, bArr);
        if (ConstantTimeUtils.areEqual(base64URL4.decode(), HMAC.compute(generateCIK, (jWEHeader.toBase64URL().toString() + "." + base64URL.toString() + "." + base64URL2.toString() + "." + base64URL3.toString()).getBytes(StandardCharset.UTF_8), provider2))) {
            return decrypt(LegacyConcatKDF.generateCEK(secretKey, jWEHeader.getEncryptionMethod(), decode, bArr), base64URL2.decode(), base64URL3.decode(), provider);
        }
        throw new JOSEException("MAC check failed");
    }

    private AESCBC() {
    }
}
