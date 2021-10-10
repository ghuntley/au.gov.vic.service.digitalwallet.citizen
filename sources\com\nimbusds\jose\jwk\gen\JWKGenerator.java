package com.nimbusds.jose.jwk.gen;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyOperation;
import com.nimbusds.jose.jwk.KeyUse;
import java.security.KeyStore;
import java.util.Set;

public abstract class JWKGenerator<T extends JWK> {
    protected Algorithm alg;
    protected KeyStore keyStore;
    protected String kid;
    protected Set<KeyOperation> ops;
    protected KeyUse use;
    protected boolean x5tKid;

    public abstract T generate() throws JOSEException;

    public JWKGenerator<T> keyUse(KeyUse keyUse) {
        this.use = keyUse;
        return this;
    }

    public JWKGenerator<T> keyOperations(Set<KeyOperation> set) {
        this.ops = set;
        return this;
    }

    public JWKGenerator<T> algorithm(Algorithm algorithm) {
        this.alg = algorithm;
        return this;
    }

    public JWKGenerator<T> keyID(String str) {
        this.kid = str;
        return this;
    }

    public JWKGenerator<T> keyIDFromThumbprint(boolean z) {
        this.x5tKid = z;
        return this;
    }

    public JWKGenerator<T> keyStore(KeyStore keyStore2) {
        this.keyStore = keyStore2;
        return this;
    }
}
