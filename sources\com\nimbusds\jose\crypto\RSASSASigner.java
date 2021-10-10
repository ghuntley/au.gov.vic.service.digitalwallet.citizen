package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.impl.RSAKeyUtils;
import com.nimbusds.jose.crypto.impl.RSASSA;
import com.nimbusds.jose.crypto.impl.RSASSAProvider;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSASSASigner extends RSASSAProvider implements JWSSigner {
    private final PrivateKey privateKey;

    public RSASSASigner(PrivateKey privateKey2) {
        this(privateKey2, false);
    }

    public RSASSASigner(PrivateKey privateKey2, boolean z) {
        int keyBitLength;
        if (!"RSA".equalsIgnoreCase(privateKey2.getAlgorithm())) {
            throw new IllegalArgumentException("The private key algorithm must be RSA");
        } else if (z || (keyBitLength = RSAKeyUtils.keyBitLength(privateKey2)) <= 0 || keyBitLength >= 2048) {
            this.privateKey = privateKey2;
        } else {
            throw new IllegalArgumentException("The RSA key size must be at least 2048 bits");
        }
    }

    public RSASSASigner(RSAKey rSAKey) throws JOSEException {
        this(rSAKey, false);
    }

    public RSASSASigner(RSAKey rSAKey, boolean z) throws JOSEException {
        this(RSAKeyUtils.toRSAPrivateKey(rSAKey), z);
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    @Override // com.nimbusds.jose.JWSSigner
    public Base64URL sign(JWSHeader jWSHeader, byte[] bArr) throws JOSEException {
        Signature signerAndVerifier = RSASSA.getSignerAndVerifier(jWSHeader.getAlgorithm(), getJCAContext().getProvider());
        try {
            signerAndVerifier.initSign(this.privateKey);
            signerAndVerifier.update(bArr);
            return Base64URL.encode(signerAndVerifier.sign());
        } catch (InvalidKeyException e) {
            throw new JOSEException("Invalid private RSA key: " + e.getMessage(), e);
        } catch (SignatureException e2) {
            throw new JOSEException("RSA signature exception: " + e2.getMessage(), e2);
        }
    }
}
