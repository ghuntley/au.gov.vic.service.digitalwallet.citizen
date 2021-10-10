package com.nimbusds.jose.jwk;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import net.minidev.json.JSONObject;

public final class ThumbprintUtils {
    public static Base64URL compute(JWK jwk) throws JOSEException {
        return compute("SHA-256", jwk);
    }

    public static Base64URL compute(String str, JWK jwk) throws JOSEException {
        return compute(str, jwk.getRequiredParams());
    }

    public static Base64URL compute(String str, LinkedHashMap<String, ?> linkedHashMap) throws JOSEException {
        String jSONString = JSONObject.toJSONString(linkedHashMap);
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(jSONString.getBytes(StandardCharset.UTF_8));
            return Base64URL.encode(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new JOSEException("Couldn't compute JWK thumbprint: Unsupported hash algorithm: " + e.getMessage(), e);
        }
    }
}
