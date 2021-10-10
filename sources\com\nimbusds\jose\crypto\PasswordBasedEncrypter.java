package com.nimbusds.jose.crypto;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEEncrypter;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.impl.AESKW;
import com.nimbusds.jose.crypto.impl.ContentCryptoProvider;
import com.nimbusds.jose.crypto.impl.PBKDF2;
import com.nimbusds.jose.crypto.impl.PRFParams;
import com.nimbusds.jose.crypto.impl.PasswordBasedCryptoProvider;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.StandardCharset;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class PasswordBasedEncrypter extends PasswordBasedCryptoProvider implements JWEEncrypter {
    public static final int MIN_RECOMMENDED_ITERATION_COUNT = 1000;
    public static final int MIN_SALT_LENGTH = 8;
    private final int iterationCount;
    private final int saltLength;

    public PasswordBasedEncrypter(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i >= 8) {
            this.saltLength = i;
            if (i2 >= 1000) {
                this.iterationCount = i2;
                return;
            }
            throw new IllegalArgumentException("The minimum recommended iteration count (p2c) is 1000");
        }
        throw new IllegalArgumentException("The minimum salt length (p2s) is 8 bytes");
    }

    public PasswordBasedEncrypter(String str, int i, int i2) {
        this(str.getBytes(StandardCharset.UTF_8), i, i2);
    }

    @Override // com.nimbusds.jose.JWEEncrypter
    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
        EncryptionMethod encryptionMethod = jWEHeader.getEncryptionMethod();
        byte[] bArr2 = new byte[this.saltLength];
        getJCAContext().getSecureRandom().nextBytes(bArr2);
        SecretKey deriveKey = PBKDF2.deriveKey(getPassword(), PBKDF2.formatSalt(algorithm, bArr2), this.iterationCount, PRFParams.resolve(algorithm, getJCAContext().getMACProvider()));
        JWEHeader build = new JWEHeader.Builder(jWEHeader).pbes2Salt(Base64URL.encode(bArr2)).pbes2Count(this.iterationCount).build();
        SecretKey generateCEK = ContentCryptoProvider.generateCEK(encryptionMethod, getJCAContext().getSecureRandom());
        return ContentCryptoProvider.encrypt(build, bArr, generateCEK, Base64URL.encode(AESKW.wrapCEK(generateCEK, deriveKey, getJCAContext().getKeyEncryptionProvider())), getJCAContext());
    }

    public int getSaltLength() {
        return this.saltLength;
    }

    public int getIterationCount() {
        return this.iterationCount;
    }
}
