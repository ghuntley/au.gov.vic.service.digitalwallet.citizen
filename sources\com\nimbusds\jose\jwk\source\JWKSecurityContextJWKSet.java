package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.JWKSecurityContext;
import java.util.List;

public class JWKSecurityContextJWKSet implements JWKSource<JWKSecurityContext> {
    public List<JWK> get(JWKSelector jWKSelector, JWKSecurityContext jWKSecurityContext) throws KeySourceException {
        if (jWKSecurityContext != null) {
            return jWKSelector.select(new JWKSet(jWKSecurityContext.getKeys()));
        }
        throw new IllegalArgumentException("Security Context must not be null");
    }
}
