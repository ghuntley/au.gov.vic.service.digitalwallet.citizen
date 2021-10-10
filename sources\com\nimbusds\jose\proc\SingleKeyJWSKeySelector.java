package com.nimbusds.jose.proc;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.Key;
import java.util.Collections;
import java.util.List;

public class SingleKeyJWSKeySelector<C extends SecurityContext> implements JWSKeySelector<C> {
    private final JWSAlgorithm expectedJWSAlg;
    private final List<Key> singletonKeyList;

    public SingleKeyJWSKeySelector(JWSAlgorithm jWSAlgorithm, Key key) {
        if (jWSAlgorithm == null) {
            throw new IllegalArgumentException("The expected JWS algorithm cannot be null");
        } else if (key != null) {
            this.singletonKeyList = Collections.singletonList(key);
            this.expectedJWSAlg = jWSAlgorithm;
        } else {
            throw new IllegalArgumentException("The key cannot be null");
        }
    }

    @Override // com.nimbusds.jose.proc.JWSKeySelector
    public List<? extends Key> selectJWSKeys(JWSHeader jWSHeader, C c) {
        if (!this.expectedJWSAlg.equals(jWSHeader.getAlgorithm())) {
            return Collections.emptyList();
        }
        return this.singletonKeyList;
    }
}
