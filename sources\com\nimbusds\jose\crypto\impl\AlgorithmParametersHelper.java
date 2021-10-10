package com.nimbusds.jose.crypto.impl;

import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class AlgorithmParametersHelper {
    public static AlgorithmParameters getInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            return AlgorithmParameters.getInstance(str);
        }
        return AlgorithmParameters.getInstance(str, provider);
    }
}
