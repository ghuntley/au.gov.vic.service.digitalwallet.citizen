package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;

public interface JWKSetCache {
    JWKSet get();

    void put(JWKSet jWKSet);
}
