package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.RSA1_5;
import com.nimbusds.jose.crypto.impl.RSACryptoProvider;
import com.nimbusds.jose.crypto.impl.RSAKeyUtils;
import com.nimbusds.jose.crypto.impl.RSA_OAEP;
import com.nimbusds.jose.crypto.impl.RSA_OAEP_256;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64URL;
import java.security.PrivateKey;
import java.util.Set;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSADecrypter extends RSACryptoProvider implements JWEDecrypter, CriticalHeaderParamsAware {
    private Exception cekDecryptionException;
    private final CriticalHeaderParamsDeferral critPolicy;
    private final PrivateKey privateKey;

    public RSADecrypter(PrivateKey privateKey2) {
        this(privateKey2, null, false);
    }

    public RSADecrypter(RSAKey rSAKey) throws JOSEException {
        this(RSAKeyUtils.toRSAPrivateKey(rSAKey));
    }

    public RSADecrypter(PrivateKey privateKey2, Set<String> set) {
        this(privateKey2, set, false);
    }

    public RSADecrypter(PrivateKey privateKey2, Set<String> set, boolean z) {
        int keyBitLength;
        CriticalHeaderParamsDeferral criticalHeaderParamsDeferral = new CriticalHeaderParamsDeferral();
        this.critPolicy = criticalHeaderParamsDeferral;
        if (!privateKey2.getAlgorithm().equalsIgnoreCase("RSA")) {
            throw new IllegalArgumentException("The private key algorithm must be RSA");
        } else if (z || (keyBitLength = RSAKeyUtils.keyBitLength(privateKey2)) <= 0 || keyBitLength >= 2048) {
            this.privateKey = privateKey2;
            criticalHeaderParamsDeferral.setDeferredCriticalHeaderParams(set);
        } else {
            throw new IllegalArgumentException("The RSA key size must be at least 2048 bits");
        }
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
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
            if (algorithm.equals(JWEAlgorithm.RSA1_5)) {
                int cekBitLength = jWEHeader.getEncryptionMethod().cekBitLength();
                secretKey = ContentCryptoProvider.generateCEK(jWEHeader.getEncryptionMethod(), getJCAContext().getSecureRandom());
                try {
                    SecretKey decryptCEK = RSA1_5.decryptCEK(this.privateKey, base64URL.decode(), cekBitLength, getJCAContext().getKeyEncryptionProvider());
                    if (decryptCEK != null) {
                        secretKey = decryptCEK;
                    }
                } catch (Exception e) {
                    this.cekDecryptionException = e;
                }
                this.cekDecryptionException = null;
            } else if (algorithm.equals(JWEAlgorithm.RSA_OAEP)) {
                secretKey = RSA_OAEP.decryptCEK(this.privateKey, base64URL.decode(), getJCAContext().getKeyEncryptionProvider());
            } else if (algorithm.equals(JWEAlgorithm.RSA_OAEP_256)) {
                secretKey = RSA_OAEP_256.decryptCEK(this.privateKey, base64URL.decode(), getJCAContext().getKeyEncryptionProvider());
            } else {
                throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithm, SUPPORTED_ALGORITHMS));
            }
            return ContentCryptoProvider.decrypt(jWEHeader, base64URL, base64URL2, base64URL3, base64URL4, secretKey, getJCAContext());
        } else {
            throw new JOSEException("Missing JWE authentication tag");
        }
    }

    public Exception getCEKDecryptionException() {
        return this.cekDecryptionException;
    }
}
