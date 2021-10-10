package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.Requirement;
import java.io.Serializable;
import kotlin.text.Typography;
import net.jcip.annotations.Immutable;
import net.minidev.json.JSONAware;
import net.minidev.json.JSONObject;

@Immutable
public final class KeyType implements JSONAware, Serializable {
    public static final KeyType EC = new KeyType("EC", Requirement.RECOMMENDED);
    public static final KeyType OCT = new KeyType("oct", Requirement.OPTIONAL);
    public static final KeyType OKP = new KeyType("OKP", Requirement.OPTIONAL);
    public static final KeyType RSA = new KeyType("RSA", Requirement.REQUIRED);
    private static final long serialVersionUID = 1;
    private final Requirement requirement;
    private final String value;

    public KeyType(String str, Requirement requirement2) {
        if (str != null) {
            this.value = str;
            this.requirement = requirement2;
            return;
        }
        throw new IllegalArgumentException("The key type value must not be null");
    }

    public String getValue() {
        return this.value;
    }

    public Requirement getRequirement() {
        return this.requirement;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof KeyType) && toString().equals(obj.toString());
    }

    public String toString() {
        return this.value;
    }

    @Override // net.minidev.json.JSONAware
    public String toJSONString() {
        return "\"" + JSONObject.escape(this.value) + Typography.quote;
    }

    public static KeyType parse(String str) {
        if (str != null) {
            KeyType keyType = EC;
            if (str.equals(keyType.getValue())) {
                return keyType;
            }
            KeyType keyType2 = RSA;
            if (str.equals(keyType2.getValue())) {
                return keyType2;
            }
            KeyType keyType3 = OCT;
            if (str.equals(keyType3.getValue())) {
                return keyType3;
            }
            KeyType keyType4 = OKP;
            if (str.equals(keyType4.getValue())) {
                return keyType4;
            }
            return new KeyType(str, null);
        }
        throw new IllegalArgumentException("The key type to parse must not be null");
    }

    public static KeyType forAlgorithm(Algorithm algorithm) {
        if (algorithm == null) {
            return null;
        }
        if (JWSAlgorithm.Family.RSA.contains(algorithm)) {
            return RSA;
        }
        if (JWSAlgorithm.Family.EC.contains(algorithm)) {
            return EC;
        }
        if (JWSAlgorithm.Family.HMAC_SHA.contains(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.RSA.contains(algorithm)) {
            return RSA;
        }
        if (JWEAlgorithm.Family.ECDH_ES.contains(algorithm)) {
            return EC;
        }
        if (JWEAlgorithm.DIR.equals(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.AES_GCM_KW.contains(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.AES_KW.contains(algorithm)) {
            return OCT;
        }
        if (JWEAlgorithm.Family.PBES2.contains(algorithm)) {
            return OCT;
        }
        if (JWSAlgorithm.Family.ED.contains(algorithm)) {
            return OKP;
        }
        return null;
    }
}
