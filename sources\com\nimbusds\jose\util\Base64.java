package com.nimbusds.jose.util;

import java.io.Serializable;
import java.math.BigInteger;
import net.jcip.annotations.Immutable;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONValue;

@Immutable
public class Base64 implements JSONAware, Serializable {
    private static final long serialVersionUID = 1;
    private final String value;

    public Base64(String str) {
        if (str != null) {
            this.value = str;
            return;
        }
        throw new IllegalArgumentException("The Base64 value must not be null");
    }

    public byte[] decode() {
        return Base64Codec.decode(this.value);
    }

    public BigInteger decodeToBigInteger() {
        return new BigInteger(1, decode());
    }

    public String decodeToString() {
        return new String(decode(), StandardCharset.UTF_8);
    }

    @Override // net.minidev.json.JSONAware
    public String toJSONString() {
        return "\"" + JSONValue.escape(this.value) + "\"";
    }

    public String toString() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Base64) && toString().equals(obj.toString());
    }

    public static Base64 from(String str) {
        if (str == null) {
            return null;
        }
        return new Base64(str);
    }

    public static Base64 encode(byte[] bArr) {
        return new Base64(Base64Codec.encodeToString(bArr, false));
    }

    public static Base64 encode(BigInteger bigInteger) {
        return encode(BigIntegerUtils.toBytesUnsigned(bigInteger));
    }

    public static Base64 encode(String str) {
        return encode(str.getBytes(StandardCharset.UTF_8));
    }
}
