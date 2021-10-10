package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.RSASSA;
import com.nimbusds.jose.crypto.impl.RSASSAProvider;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSASSAVerifier extends RSASSAProvider implements JWSVerifier, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;
    private final RSAPublicKey publicKey;

    public RSASSAVerifier(RSAPublicKey rSAPublicKey) {
        this(rSAPublicKey, null);
    }

    public RSASSAVerifier(RSAKey rSAKey) throws JOSEException {
        this(rSAKey.toRSAPublicKey(), null);
    }

    public RSASSAVerifier(RSAPublicKey rSAPublicKey, Set<String> set) {
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        if (rSAPublicKey != null) {
            this.publicKey = rSAPublicKey;
            criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
            return;
        }
        throw new IllegalArgumentException("The public RSA key must not be null");
    }

    public RSAPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.JWSVerifier
    public boolean verify(JWSHeader jWSHeader, byte[] bArr, Base64URL base64URL) throws JOSEException {
        if (!this.critPolicy.headerPasses(jWSHeader)) {
            return false;
        }
        Signature signerAndVerifier = RSASSA.getSignerAndVerifier(jWSHeader.getAlgorithm(), getJCAContext().getProvider());
        try {
            signerAndVerifier.initVerify(this.publicKey);
            try {
                signerAndVerifier.update(bArr);
                return signerAndVerifier.verify(base64URL.decode());
            } catch (SignatureException unused) {
                return false;
            }
        } catch (InvalidKeyException e) {
            throw new JOSEException("Invalid public RSA key: " + e.getMessage(), e);
        }
    }
}
