package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.Curve;
import java.util.Collection;

public class AlgorithmSupportMessage {
    private static String itemize(Collection collection) {
        StringBuilder sb = new StringBuilder();
        Object[] array = collection.toArray();
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                if (i < array.length - 1) {
                    sb.append(", ");
                } else if (i == array.length - 1) {
                    sb.append(" or ");
                }
            }
            sb.append(array[i].toString());
        }
        return sb.toString();
    }

    public static String unsupportedJWSAlgorithm(JWSAlgorithm jWSAlgorithm, Collection<JWSAlgorithm> collection) {
        return "Unsupported JWS algorithm " + jWSAlgorithm + ", must be " + itemize(collection);
    }

    public static String unsupportedJWEAlgorithm(JWEAlgorithm jWEAlgorithm, Collection<JWEAlgorithm> collection) {
        return "Unsupported JWE algorithm " + jWEAlgorithm + ", must be " + itemize(collection);
    }

    public static String unsupportedEncryptionMethod(EncryptionMethod encryptionMethod, Collection<EncryptionMethod> collection) {
        return "Unsupported JWE encryption method " + encryptionMethod + ", must be " + itemize(collection);
    }

    public static String unsupportedEllipticCurve(Curve curve, Collection<Curve> collection) {
        return "Unsupported elliptic curve " + curve + ", must be " + itemize(collection);
    }

    private AlgorithmSupportMessage() {
    }
}
