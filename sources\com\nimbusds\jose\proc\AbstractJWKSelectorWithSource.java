package com.nimbusds.jose.proc;

import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
abstract class AbstractJWKSelectorWithSource<C extends SecurityContext> {
    private final JWKSource<C> jwkSource;

    public AbstractJWKSelectorWithSource(JWKSource<C> jWKSource) {
        if (jWKSource != null) {
            this.jwkSource = jWKSource;
            return;
        }
        throw new IllegalArgumentException("The JWK source must not be null");
    }

    public JWKSource<C> getJWKSource() {
        return this.jwkSource;
    }
}
