package com.nimbusds.jose.crypto;

import com.google.crypto.tink.subtle.Ed25519Sign;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.impl.EdDSAProvider;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.util.Base64URL;
import java.security.GeneralSecurityException;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Ed25519Signer extends EdDSAProvider implements JWSSigner {
    private final OctetKeyPair privateKey;
    private final Ed25519Sign tinkSigner;

    public Ed25519Signer(OctetKeyPair octetKeyPair) throws JOSEException {
        if (!Curve.Ed25519.equals(octetKeyPair.getCurve())) {
            throw new JOSEException("Ed25519Signer only supports OctetKeyPairs with crv=Ed25519");
        } else if (octetKeyPair.isPrivate()) {
            this.privateKey = octetKeyPair;
            try {
                this.tinkSigner = new Ed25519Sign(octetKeyPair.getDecodedD());
            } catch (GeneralSecurityException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            throw new JOSEException("The OctetKeyPair doesn't contain a private part");
        }
    }

    public OctetKeyPair getPrivateKey() {
        return this.privateKey;
    }

    @Override // com.nimbusds.jose.JWSSigner
    public Base64URL sign(JWSHeader jWSHeader, byte[] bArr) throws JOSEException {
        if (JWSAlgorithm.EdDSA.equals(jWSHeader.getAlgorithm())) {
            try {
                return Base64URL.encode(this.tinkSigner.sign(bArr));
            } catch (GeneralSecurityException e) {
                throw new JOSEException(e.getMessage(), e);
            }
        } else {
            throw new JOSEException("Ed25519Signer requires alg=EdDSA in JWSHeader");
        }
    }
}
