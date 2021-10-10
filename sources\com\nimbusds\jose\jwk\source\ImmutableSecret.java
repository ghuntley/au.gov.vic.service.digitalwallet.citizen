package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.proc.SecurityContext;
import javax.crypto.SecretKey;
import net.jcip.annotations.Immutable;

@Immutable
public class ImmutableSecret<C extends SecurityContext> extends ImmutableJWKSet<C> {
    public ImmutableSecret(byte[] bArr) {
        super(new JWKSet(new OctetSequenceKey.Builder(bArr).build()));
    }

    public ImmutableSecret(SecretKey secretKey) {
        super(new JWKSet(new OctetSequenceKey.Builder(secretKey).build()));
    }

    public byte[] getSecret() {
        return ((OctetSequenceKey) getJWKSet().getKeys().get(0)).toByteArray();
    }

    public SecretKey getSecretKey() {
        return ((OctetSequenceKey) getJWKSet().getKeys().get(0)).toSecretKey();
    }
}
