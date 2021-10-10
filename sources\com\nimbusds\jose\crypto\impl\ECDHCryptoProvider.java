package com.nimbusds.jose.crypto.impl;

import androidx.core.os.EnvironmentCompat;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.ECDH;
import com.nimbusds.jose.jca.JWEJCAContext;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.util.Base64URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.crypto.SecretKey;

public abstract class ECDHCryptoProvider extends BaseJWEProvider {
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS = ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS;
    private final ConcatKDF concatKDF;
    private final Curve curve;

    public abstract Set<Curve> supportedEllipticCurves();

    @Override // com.nimbusds.jose.crypto.impl.BaseJWEProvider, com.nimbusds.jose.crypto.impl.BaseJWEProvider, com.nimbusds.jose.jca.JCAAware
    public /* bridge */ /* synthetic */ JWEJCAContext getJCAContext() {
        return super.getJCAContext();
    }

    @Override // com.nimbusds.jose.JWEProvider, com.nimbusds.jose.crypto.impl.BaseJWEProvider
    public /* bridge */ /* synthetic */ Set supportedEncryptionMethods() {
        return super.supportedEncryptionMethods();
    }

    @Override // com.nimbusds.jose.JWEProvider, com.nimbusds.jose.crypto.impl.BaseJWEProvider
    public /* bridge */ /* synthetic */ Set supportedJWEAlgorithms() {
        return super.supportedJWEAlgorithms();
    }

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWEAlgorithm.ECDH_ES);
        linkedHashSet.add(JWEAlgorithm.ECDH_ES_A128KW);
        linkedHashSet.add(JWEAlgorithm.ECDH_ES_A192KW);
        linkedHashSet.add(JWEAlgorithm.ECDH_ES_A256KW);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
    }

    protected ECDHCryptoProvider(Curve curve2) throws JOSEException {
        super(SUPPORTED_ALGORITHMS, ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        Curve curve3;
        if (curve2 != null) {
            curve3 = curve2;
        } else {
            curve3 = new Curve(EnvironmentCompat.MEDIA_UNKNOWN);
        }
        if (supportedEllipticCurves().contains(curve2)) {
            this.curve = curve2;
            this.concatKDF = new ConcatKDF("SHA-256");
            return;
        }
        throw new JOSEException(AlgorithmSupportMessage.unsupportedEllipticCurve(curve3, supportedEllipticCurves()));
    }

    /* access modifiers changed from: protected */
    public ConcatKDF getConcatKDF() {
        return this.concatKDF;
    }

    public Curve getCurve() {
        return this.curve;
    }

    /* access modifiers changed from: protected */
    public JWECryptoParts encryptWithZ(JWEHeader jWEHeader, SecretKey secretKey, byte[] bArr) throws JOSEException {
        return encryptWithZ(jWEHeader, secretKey, bArr, null);
    }

    /* access modifiers changed from: protected */
    public JWECryptoParts encryptWithZ(JWEHeader jWEHeader, SecretKey secretKey, byte[] bArr, SecretKey secretKey2) throws JOSEException {
        Base64URL base64URL;
        ECDH.AlgorithmMode resolveAlgorithmMode = ECDH.resolveAlgorithmMode(jWEHeader.getAlgorithm());
        EncryptionMethod encryptionMethod = jWEHeader.getEncryptionMethod();
        getConcatKDF().getJCAContext().setProvider(getJCAContext().getMACProvider());
        SecretKey deriveSharedKey = ECDH.deriveSharedKey(jWEHeader, secretKey, getConcatKDF());
        if (resolveAlgorithmMode.equals(ECDH.AlgorithmMode.DIRECT)) {
            base64URL = null;
        } else if (resolveAlgorithmMode.equals(ECDH.AlgorithmMode.KW)) {
            if (secretKey2 == null) {
                secretKey2 = ContentCryptoProvider.generateCEK(encryptionMethod, getJCAContext().getSecureRandom());
            }
            base64URL = Base64URL.encode(AESKW.wrapCEK(secretKey2, deriveSharedKey, getJCAContext().getKeyEncryptionProvider()));
            deriveSharedKey = secretKey2;
        } else {
            throw new JOSEException("Unexpected JWE ECDH algorithm mode: " + resolveAlgorithmMode);
        }
        return ContentCryptoProvider.encrypt(jWEHeader, bArr, deriveSharedKey, base64URL, getJCAContext());
    }

    /* access modifiers changed from: protected */
    public byte[] decryptWithZ(JWEHeader jWEHeader, SecretKey secretKey, Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4) throws JOSEException {
        ECDH.AlgorithmMode resolveAlgorithmMode = ECDH.resolveAlgorithmMode(jWEHeader.getAlgorithm());
        getConcatKDF().getJCAContext().setProvider(getJCAContext().getMACProvider());
        SecretKey deriveSharedKey = ECDH.deriveSharedKey(jWEHeader, secretKey, getConcatKDF());
        if (!resolveAlgorithmMode.equals(ECDH.AlgorithmMode.DIRECT)) {
            if (!resolveAlgorithmMode.equals(ECDH.AlgorithmMode.KW)) {
                throw new JOSEException("Unexpected JWE ECDH algorithm mode: " + resolveAlgorithmMode);
            } else if (base64URL != null) {
                deriveSharedKey = AESKW.unwrapCEK(deriveSharedKey, base64URL.decode(), getJCAContext().getKeyEncryptionProvider());
            } else {
                throw new JOSEException("Missing JWE encrypted key");
            }
        }
        return ContentCryptoProvider.decrypt(jWEHeader, base64URL, base64URL2, base64URL3, base64URL4, deriveSharedKey, getJCAContext());
    }
}
