package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.impl.AESCryptoProvider;
import com.nimbusds.jose.crypto.impl.AESGCMKW;
import com.nimbusds.jose.crypto.impl.AESKW;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class AESDecrypter extends AESCryptoProvider implements JWEDecrypter, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy;

    public AESDecrypter(SecretKey secretKey) throws KeyLengthException {
        this(secretKey, null);
    }

    public AESDecrypter(byte[] bArr) throws KeyLengthException {
        this(new SecretKeySpec(bArr, "AES"));
    }

    public AESDecrypter(OctetSequenceKey octetSequenceKey) throws KeyLengthException {
        this(octetSequenceKey.toSecretKey("AES"));
    }

    public AESDecrypter(SecretKey secretKey, Set<String> set) throws KeyLengthException {
        super(secretKey);
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getProcessedCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.CriticalHeaderParamsAware
    public Set<String> getDeferredCriticalHeaderParams() {
        return this.critPolicy.getProcessedCriticalHeaderParams();
    }

    @Override // com.nimbusds.jose.JWEDecrypter
    public byte[] decrypt(JWEHeader jWEHeader, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) throws JOSEException {
        SecretKey secretKey;
        if (base64URL == null) {
            throw new JOSEException("Missing JWE encrypted key");
        } else if (base64URL2 == null) {
            throw new JOSEException("Missing JWE initialization vector (IV)");
        } else if (base64URL4 != null) {
            this.critPolicy.ensureHeaderPasses(jWEHeader);
            JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
            int cekBitLength = jWEHeader.getEncryptionMethod().cekBitLength();
            if (algorithm.equals(JWEAlgorithm.A128KW) || algorithm.equals(JWEAlgorithm.A192KW) || algorithm.equals(JWEAlgorithm.A256KW)) {
                secretKey = AESKW.unwrapCEK(getKey(), base64URL.decode(), getJCAContext().getKeyEncryptionProvider());
            } else if (!algorithm.equals(JWEAlgorithm.A128GCMKW) && !algorithm.equals(JWEAlgorithm.A192GCMKW) && !algorithm.equals(JWEAlgorithm.A256GCMKW)) {
                throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithm, SUPPORTED_ALGORITHMS));
            } else if (jWEHeader.getIV() != null) {
                byte[] decode = jWEHeader.getIV().decode();
                if (jWEHeader.getAuthTag() != null) {
                    secretKey = AESGCMKW.decryptCEK(getKey(), decode, new AuthenticatedCipherText(base64URL.decode(), jWEHeader.getAuthTag().decode()), cekBitLength, getJCAContext().getKeyEncryptionProvider());
                } else {
                    throw new JOSEException("Missing JWE \"tag\" header parameter");
                }
            } else {
                throw new JOSEException("Missing JWE \"iv\" header parameter");
            }
            return ContentCryptoProvider.decrypt(jWEHeader, base64URL, base64URL2, base64URL3, base64URL4, secretKey, getJCAContext());
        } else {
            throw new JOSEException("Missing JWE authentication tag");
        }
    }
}
