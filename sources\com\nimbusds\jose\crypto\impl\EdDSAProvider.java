package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JWSAlgorithm;
import java.util.Collections;
import java.util.Set;

public abstract class EdDSAProvider extends BaseJWSProvider {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS = Collections.singleton(JWSAlgorithm.EdDSA);

    protected EdDSAProvider() {
        super(SUPPORTED_ALGORITHMS);
    }
}
