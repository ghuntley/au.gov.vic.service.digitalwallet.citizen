package com.nimbusds.jose;

import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.text.ParseException;

public abstract class JOSEObject implements Serializable {
    public static final String MIME_TYPE_COMPACT = "application/jose; charset=UTF-8";
    public static final String MIME_TYPE_JS = "application/jose+json; charset=UTF-8";
    private static final long serialVersionUID = 1;
    private Base64URL[] parsedParts;
    private Payload payload;

    public abstract Header getHeader();

    public abstract String serialize();

    protected JOSEObject() {
        this.payload = null;
        this.parsedParts = null;
    }

    protected JOSEObject(Payload payload2) {
        this.payload = payload2;
    }

    /* access modifiers changed from: protected */
    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public Payload getPayload() {
        return this.payload;
    }

    /* access modifiers changed from: protected */
    public void setParsedParts(Base64URL... base64URLArr) {
        this.parsedParts = base64URLArr;
    }

    public Base64URL[] getParsedParts() {
        return this.parsedParts;
    }

    public String getParsedString() {
        if (this.parsedParts == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Base64URL[] base64URLArr = this.parsedParts;
        for (Base64URL base64URL : base64URLArr) {
            if (sb.length() > 0) {
                sb.append('.');
            }
            if (base64URL != null) {
                sb.append(base64URL.toString());
            }
        }
        return sb.toString();
    }

    public static Base64URL[] split(String str) throws ParseException {
        String trim = str.trim();
        int indexOf = trim.indexOf(".");
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = trim.indexOf(".", i);
            if (indexOf2 != -1) {
                int i2 = indexOf2 + 1;
                int indexOf3 = trim.indexOf(".", i2);
                if (indexOf3 == -1) {
                    return new Base64URL[]{new Base64URL(trim.substring(0, indexOf)), new Base64URL(trim.substring(i, indexOf2)), new Base64URL(trim.substring(i2))};
                }
                int i3 = indexOf3 + 1;
                int indexOf4 = trim.indexOf(".", i3);
                if (indexOf4 == -1) {
                    throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
                } else if (indexOf4 == -1 || trim.indexOf(".", indexOf4 + 1) == -1) {
                    return new Base64URL[]{new Base64URL(trim.substring(0, indexOf)), new Base64URL(trim.substring(i, indexOf2)), new Base64URL(trim.substring(i2, indexOf3)), new Base64URL(trim.substring(i3, indexOf4)), new Base64URL(trim.substring(indexOf4 + 1))};
                } else {
                    throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
                }
            } else {
                throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
            }
        } else {
            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
        }
    }

    public static JOSEObject parse(String str) throws ParseException {
        try {
            Algorithm parseAlgorithm = Header.parseAlgorithm(JSONObjectUtils.parse(split(str)[0].decodeToString()));
            if (parseAlgorithm.equals(Algorithm.NONE)) {
                return PlainObject.parse(str);
            }
            if (parseAlgorithm instanceof JWSAlgorithm) {
                return JWSObject.parse(str);
            }
            if (parseAlgorithm instanceof JWEAlgorithm) {
                return JWEObject.parse(str);
            }
            throw new AssertionError("Unexpected algorithm type: " + parseAlgorithm);
        } catch (ParseException e) {
            throw new ParseException("Invalid unsecured/JWS/JWE header: " + e.getMessage(), 0);
        }
    }
}
