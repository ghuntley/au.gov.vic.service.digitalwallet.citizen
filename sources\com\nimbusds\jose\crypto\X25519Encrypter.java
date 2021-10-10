package com.nimbusds.jose.crypto;

import com.google.crypto.tink.subtle.X25519;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.ECDH;
import com.nimbusds.jose.crypto.impl.ECDHCryptoProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class X25519Encrypter extends ECDHCryptoProvider implements JWEEncrypter {
    private final OctetKeyPair publicKey;

    public X25519Encrypter(OctetKeyPair octetKeyPair) throws JOSEException {
        super(octetKeyPair.getCurve());
        if (!Curve.X25519.equals(octetKeyPair.getCurve())) {
            throw new JOSEException("X25519Encrypter only supports OctetKeyPairs with crv=X25519");
        } else if (!octetKeyPair.isPrivate()) {
            this.publicKey = octetKeyPair;
        } else {
            throw new JOSEException("X25519Encrypter requires a public key, use OctetKeyPair.toPublicJWK()");
        }
    }

    @Override // com.nimbusds.jose.crypto.impl.ECDHCryptoProvider
    public Set<Curve> supportedEllipticCurves() {
        return Collections.singleton(Curve.X25519);
    }

    public OctetKeyPair getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        byte[] generatePrivateKey = X25519.generatePrivateKey();
        try {
            OctetKeyPair build = new OctetKeyPair.Builder(getCurve(), Base64URL.encode(X25519.publicFromPrivate(generatePrivateKey))).d(Base64URL.encode(generatePrivateKey)).build();
            return encryptWithZ(new JWEHeader.Builder(jWEHeader).ephemeralPublicKey(build.toPublicJWK()).build(), ECDH.deriveSharedSecret(this.publicKey, build), bArr);
        } catch (InvalidKeyException e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }
}
