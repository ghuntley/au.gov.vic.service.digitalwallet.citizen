package com.nimbusds.jose.crypto;

import com.nimbusds.jose.CriticalHeaderParamsAware;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AESKW;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.CriticalHeaderParamsDeferral;
import com.nimbusds.jose.crypto.impl.PBKDF2;
import com.nimbusds.jose.crypto.impl.PRFParams;
import com.nimbusds.jose.crypto.impl.PasswordBasedCryptoProvider;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class PasswordBasedDecrypter extends PasswordBasedCryptoProvider implements JWEDecrypter, CriticalHeaderParamsAware {
    private final CriticalHeaderParamsDeferral critPolicy = new CriticalHeaderParamsDeferral();

    public PasswordBasedDecrypter(byte[] bArr) {
        super(bArr);
    }

    public PasswordBasedDecrypter(String str) {
        super(str.getBytes(StandardCharset.UTF_8));
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
        if (base64URL == null) {
            throw new JOSEException("Missing JWE encrypted key");
        } else if (base64URL2 == null) {
            throw new JOSEException("Missing JWE initialization vector (IV)");
        } else if (base64URL4 == null) {
            throw new JOSEException("Missing JWE authentication tag");
        } else if (jWEHeader.getPBES2Salt() != null) {
            byte[] decode = jWEHeader.getPBES2Salt().decode();
            if (jWEHeader.getPBES2Count() >= 1) {
                int pBES2Count = jWEHeader.getPBES2Count();
                this.critPolicy.ensureHeaderPasses(jWEHeader);
                JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
                return ContentCryptoProvider.decrypt(jWEHeader, base64URL, base64URL2, base64URL3, base64URL4, AESKW.unwrapCEK(PBKDF2.deriveKey(getPassword(), PBKDF2.formatSalt(algorithm, decode), pBES2Count, PRFParams.resolve(algorithm, getJCAContext().getMACProvider())), base64URL.decode(), getJCAContext().getKeyEncryptionProvider()), getJCAContext());
            }
            throw new JOSEException("Missing JWE \"p2c\" header parameter");
        } else {
            throw new JOSEException("Missing JWE \"p2s\" header parameter");
        }
    }
}
