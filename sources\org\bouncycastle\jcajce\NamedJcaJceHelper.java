package org.bouncycastle.jcajce;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.operator.jcajce.JceSymmetricKeyUnwrapper;

public class NamedJcaJceHelper implements JcaJceHelper {
    private final String providerName;

    public NamedJcaJceHelper(String str) {
        this.providerName = str;
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return AlgorithmParameterGenerator.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public AlgorithmParameters createAlgorithmParameters(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return AlgorithmParameters.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public AsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return new JceAsymmetricKeyUnwrapper(algorithmIdentifier, privateKey).setProvider(this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public CertificateFactory createCertificateFactory(String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException {
        return CertificateFactory.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public Cipher createCipher(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        return Cipher.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public MessageDigest createDigest(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return MessageDigest.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public KeyAgreement createKeyAgreement(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyAgreement.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public KeyFactory createKeyFactory(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyFactory.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public KeyGenerator createKeyGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyGenerator.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public KeyPairGenerator createKeyPairGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyPairGenerator.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public Mac createMac(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Mac.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public Signature createSignature(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Signature.getInstance(str, this.providerName);
    }

    @Override // org.bouncycastle.jcajce.JcaJceHelper
    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return new JceSymmetricKeyUnwrapper(algorithmIdentifier, secretKey).setProvider(this.providerName);
    }
}
