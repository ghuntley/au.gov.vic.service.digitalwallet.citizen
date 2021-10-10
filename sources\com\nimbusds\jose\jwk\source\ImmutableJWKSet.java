package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import java.util.List;
import net.jcip.annotations.Immutable;

@Immutable
public class ImmutableJWKSet<C extends SecurityContext> implements JWKSource<C> {
    private final JWKSet jwkSet;

    public ImmutableJWKSet(JWKSet jWKSet) {
        if (jWKSet != null) {
            this.jwkSet = jWKSet;
            return;
        }
        throw new IllegalArgumentException("The JWK set must not be null");
    }

    public JWKSet getJWKSet() {
        return this.jwkSet;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSource
    public List<JWK> get(JWKSelector jWKSelector, C c) {
        return jWKSelector.select(this.jwkSet);
    }
}
