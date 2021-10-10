package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class ECDSAProvider extends BaseJWSProvider {
    public static final Set<JWSAlgorithm> SUPPORTED_ALGORITHMS;

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWSAlgorithm.ES256);
        linkedHashSet.add(JWSAlgorithm.ES256K);
        linkedHashSet.add(JWSAlgorithm.ES384);
        linkedHashSet.add(JWSAlgorithm.ES512);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    protected ECDSAProvider(JWSAlgorithm jWSAlgorithm) throws JOSEException {
        super(new HashSet(Collections.singletonList(jWSAlgorithm)));
        if (!SUPPORTED_ALGORITHMS.contains(jWSAlgorithm)) {
            throw new JOSEException("Unsupported EC DSA algorithm: " + jWSAlgorithm);
        }
    }

    public JWSAlgorithm supportedECDSAAlgorithm() {
        return supportedJWSAlgorithms().iterator().next();
    }
}
