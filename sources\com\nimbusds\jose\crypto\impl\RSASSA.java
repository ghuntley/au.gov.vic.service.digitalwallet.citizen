package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

public class RSASSA {
    public static Signature getSignerAndVerifier(JWSAlgorithm jWSAlgorithm, Provider provider) throws JOSEException {
        String str;
        Signature signature;
        String str2;
        PSSParameterSpec pSSParameterSpec = null;
        if (jWSAlgorithm.equals(JWSAlgorithm.RS256)) {
            str = "SHA256withRSA";
        } else if (jWSAlgorithm.equals(JWSAlgorithm.RS384)) {
            str = "SHA384withRSA";
        } else if (jWSAlgorithm.equals(JWSAlgorithm.RS512)) {
            str = "SHA512withRSA";
        } else {
            if (jWSAlgorithm.equals(JWSAlgorithm.PS256)) {
                pSSParameterSpec = new PSSParameterSpec("SHA256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
                str2 = "SHA256withRSAandMGF1";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.PS384)) {
                pSSParameterSpec = new PSSParameterSpec("SHA384", "MGF1", MGF1ParameterSpec.SHA384, 48, 1);
                str2 = "SHA384withRSAandMGF1";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.PS512)) {
                pSSParameterSpec = new PSSParameterSpec("SHA512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
                str2 = "SHA512withRSAandMGF1";
            } else {
                throw new JOSEException(AlgorithmSupportMessage.unsupportedJWSAlgorithm(jWSAlgorithm, RSASSAProvider.SUPPORTED_ALGORITHMS));
            }
            str = str2;
        }
        if (provider != null) {
            try {
                signature = Signature.getInstance(str, provider);
            } catch (NoSuchAlgorithmException e) {
                throw new JOSEException("Unsupported RSASSA algorithm: " + e.getMessage(), e);
            }
        } else {
            signature = Signature.getInstance(str);
        }
        if (pSSParameterSpec != null) {
            try {
                signature.setParameter(pSSParameterSpec);
            } catch (InvalidAlgorithmParameterException e2) {
                throw new JOSEException("Invalid RSASSA-PSS salt length parameter: " + e2.getMessage(), e2);
            }
        }
        return signature;
    }

    private RSASSA() {
    }
}
