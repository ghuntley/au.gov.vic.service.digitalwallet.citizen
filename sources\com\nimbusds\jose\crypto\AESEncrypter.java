package com.nimbusds.jose.crypto;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.impl.AESCryptoProvider;
import com.nimbusds.jose.crypto.impl.AESGCM;
import com.nimbusds.jose.crypto.impl.AESGCMKW;
import com.nimbusds.jose.crypto.impl.AESKW;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class AESEncrypter extends AESCryptoProvider implements JWEEncrypter {

    private enum AlgFamily {
        AESKW,
        AESGCMKW
    }

    public AESEncrypter(SecretKey secretKey) throws KeyLengthException {
        super(secretKey);
    }

    public AESEncrypter(byte[] bArr) throws KeyLengthException {
        this(new SecretKeySpec(bArr, "AES"));
    }

    public AESEncrypter(OctetSequenceKey octetSequenceKey) throws KeyLengthException {
        this(octetSequenceKey.toSecretKey("AES"));
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        AlgFamily algFamily;
        Base64URL base64URL;
        JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
        if (algorithm.equals(JWEAlgorithm.A128KW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) == 128) {
                algFamily = AlgFamily.AESKW;
            } else {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 128 bits for A128KW encryption");
            }
        } else if (algorithm.equals(JWEAlgorithm.A192KW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) == 192) {
                algFamily = AlgFamily.AESKW;
            } else {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 192 bits for A192KW encryption");
            }
        } else if (algorithm.equals(JWEAlgorithm.A256KW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) == 256) {
                algFamily = AlgFamily.AESKW;
            } else {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 256 bits for A256KW encryption");
            }
        } else if (algorithm.equals(JWEAlgorithm.A128GCMKW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) == 128) {
                algFamily = AlgFamily.AESGCMKW;
            } else {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 128 bits for A128GCMKW encryption");
            }
        } else if (algorithm.equals(JWEAlgorithm.A192GCMKW)) {
            if (ByteUtils.safeBitLength(getKey().getEncoded()) == 192) {
                algFamily = AlgFamily.AESGCMKW;
            } else {
                throw new KeyLengthException("The Key Encryption Key (KEK) length must be 192 bits for A192GCMKW encryption");
            }
        } else if (!algorithm.equals(JWEAlgorithm.A256GCMKW)) {
            throw new JOSEException(AlgorithmSupportMessage.unsupportedJWEAlgorithm(algorithm, SUPPORTED_ALGORITHMS));
        } else if (ByteUtils.safeBitLength(getKey().getEncoded()) == 256) {
            algFamily = AlgFamily.AESGCMKW;
        } else {
            throw new KeyLengthException("The Key Encryption Key (KEK) length must be 256 bits for A256GCMKW encryption");
        }
        SecretKey generateCEK = ContentCryptoProvider.generateCEK(jWEHeader.getEncryptionMethod(), getJCAContext().getSecureRandom());
        if (AlgFamily.AESKW.equals(algFamily)) {
            base64URL = Base64URL.encode(AESKW.wrapCEK(generateCEK, getKey(), getJCAContext().getKeyEncryptionProvider()));
        } else if (AlgFamily.AESGCMKW.equals(algFamily)) {
            Container container = new Container(AESGCM.generateIV(getJCAContext().getSecureRandom()));
            AuthenticatedCipherText encryptCEK = AESGCMKW.encryptCEK(generateCEK, container, getKey(), getJCAContext().getKeyEncryptionProvider());
            Base64URL encode = Base64URL.encode(encryptCEK.getCipherText());
            jWEHeader = new JWEHeader.Builder(jWEHeader).iv(Base64URL.encode((byte[]) container.get())).authTag(Base64URL.encode(encryptCEK.getAuthenticationTag())).build();
            base64URL = encode;
        } else {
            throw new JOSEException("Unexpected JWE algorithm: " + algorithm);
        }
        return ContentCryptoProvider.encrypt(jWEHeader, bArr, generateCEK, base64URL, getJCAContext());
    }
}
