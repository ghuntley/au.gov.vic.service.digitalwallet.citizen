package com.nimbusds.jose.jwk.gen;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;

public class ECKeyGenerator extends JWKGenerator<ECKey> {
    private final Curve crv;

    public ECKeyGenerator(Curve curve) {
        if (curve != null) {
            this.crv = curve;
            return;
        }
        throw new IllegalArgumentException("The curve must not be null");
    }

    @Override // com.nimbusds.jose.jwk.gen.JWKGenerator
    public ECKey generate() throws JOSEException {
        KeyPairGenerator keyPairGenerator;
        ECParameterSpec eCParameterSpec = this.crv.toECParameterSpec();
        try {
            if (this.keyStore != null) {
                keyPairGenerator = KeyPairGenerator.getInstance("EC", this.keyStore.getProvider());
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance("EC");
            }
            keyPairGenerator.initialize(eCParameterSpec);
            KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
            ECKey.Builder keyStore = new ECKey.Builder(this.crv, (ECPublicKey) generateKeyPair.getPublic()).privateKey(generateKeyPair.getPrivate()).keyUse(this.use).keyOperations(this.ops).algorithm(this.alg).keyStore(this.keyStore);
            if (this.x5tKid) {
                keyStore.keyIDFromThumbprint();
            } else {
                keyStore.keyID(this.kid);
            }
            return keyStore.build();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
