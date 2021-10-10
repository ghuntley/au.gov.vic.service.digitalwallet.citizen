package com.nimbusds.jose.jwk.gen;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;

public class RSAKeyGenerator extends JWKGenerator<RSAKey> {
    public static final int MIN_KEY_SIZE_BITS = 2048;
    private final int size;

    public RSAKeyGenerator(int i) {
        this(i, false);
    }

    public RSAKeyGenerator(int i, boolean z) {
        if (z || i >= 2048) {
            this.size = i;
            return;
        }
        throw new IllegalArgumentException("The key size must be at least 2048 bits");
    }

    @Override // com.nimbusds.jose.jwk.gen.JWKGenerator
    public RSAKey generate() throws JOSEException {
        KeyPairGenerator keyPairGenerator;
        try {
            if (this.keyStore != null) {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA", this.keyStore.getProvider());
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            }
            keyPairGenerator.initialize(this.size);
            KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
            RSAKey.Builder keyStore = new RSAKey.Builder((RSAPublicKey) generateKeyPair.getPublic()).privateKey(generateKeyPair.getPrivate()).keyUse(this.use).keyOperations(this.ops).algorithm(this.alg).keyStore(this.keyStore);
            if (this.x5tKid) {
                keyStore.keyIDFromThumbprint();
            } else {
                keyStore.keyID(this.kid);
            }
            return keyStore.build();
        } catch (NoSuchAlgorithmException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
