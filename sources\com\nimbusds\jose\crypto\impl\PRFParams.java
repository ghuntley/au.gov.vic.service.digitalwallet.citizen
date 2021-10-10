package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import java.security.Provider;
import net.jcip.annotations.Immutable;

@Immutable
public final class PRFParams {
    private final int dkLen;
    private final String jcaMacAlg;
    private final Provider macProvider;

    public PRFParams(String str, Provider provider, int i) {
        this.jcaMacAlg = str;
        this.macProvider = provider;
        this.dkLen = i;
    }

    public String getMACAlgorithm() {
        return this.jcaMacAlg;
    }

    public Provider getMacProvider() {
        return this.macProvider;
    }

    public int getDerivedKeyByteLength() {
        return this.dkLen;
    }

    public static PRFParams resolve(JWEAlgorithm jWEAlgorithm, Provider provider) throws JOSEException {
        int i;
        String str;
        if (JWEAlgorithm.PBES2_HS256_A128KW.equals(jWEAlgorithm)) {
            i = 16;
            str = "HmacSHA256";
        } else if (JWEAlgorithm.PBES2_HS384_A192KW.equals(jWEAlgorithm)) {
            i = 24;
            str = "HmacSHA384";
        } else if (JWEAlgorithm.PBES2_HS512_A256KW.equals(jWEAlgorithm)) {
            i = 32;
            str = "HmacSHA512";
        } else {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(jWEAlgorithm, PasswordBasedCryptoProvider.SUPPORTED_ALGORITHMS));
        }
        return new PRFParams(str, provider, i);
    }
}
