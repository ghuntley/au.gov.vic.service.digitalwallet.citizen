package org.bouncycastle.operator.jcajce;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.NamedJcaJceHelper;
import org.bouncycastle.jcajce.ProviderJcaJceHelper;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;

public class JceAsymmetricKeyWrapper extends AsymmetricKeyWrapper {
    private OperatorHelper helper;
    private PublicKey publicKey;
    private SecureRandom random;

    public JceAsymmetricKeyWrapper(PublicKey publicKey2) {
        super(SubjectPublicKeyInfo.getInstance(publicKey2.getEncoded()).getAlgorithmId());
        this.helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.publicKey = publicKey2;
    }

    public JceAsymmetricKeyWrapper(X509Certificate x509Certificate) {
        this(x509Certificate.getPublicKey());
    }

    @Override // org.bouncycastle.operator.KeyWrapper
    public byte[] generateWrappedKey(GenericKey genericKey) throws OperatorException {
        byte[] bArr;
        Cipher createAsymmetricWrapper = this.helper.createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
        try {
            createAsymmetricWrapper.init(3, this.publicKey, this.random);
            bArr = createAsymmetricWrapper.wrap(OperatorUtils.getJceKey(genericKey));
        } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException unused) {
            bArr = null;
        }
        if (bArr != null) {
            return bArr;
        }
        try {
            createAsymmetricWrapper.init(1, this.publicKey, this.random);
            return createAsymmetricWrapper.doFinal(OperatorUtils.getJceKey(genericKey).getEncoded());
        } catch (GeneralSecurityException e) {
            throw new OperatorException("unable to encrypt contents key", e);
        }
    }

    public JceAsymmetricKeyWrapper setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceAsymmetricKeyWrapper setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceAsymmetricKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
