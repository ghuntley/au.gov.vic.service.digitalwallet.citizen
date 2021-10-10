package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerOverflowException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class AAD {
    public static byte[] compute(JWEHeader jWEHeader) {
        return compute(jWEHeader.toBase64URL());
    }

    public static byte[] compute(Base64URL base64URL) {
        return base64URL.toString().getBytes(Charset.forName("ASCII"));
    }

    public static byte[] computeLength(byte[] bArr) throws IntegerOverflowException {
        return ByteBuffer.allocate(8).putLong((long) ByteUtils.safeBitLength(bArr)).array();
    }
}
