package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;
import org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

public abstract class JDKKeyFactory extends KeyFactorySpi {
    protected boolean elGamalFactory = false;

    public static class DH extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DHPrivateKeySpec ? new JCEDHPrivateKey((DHPrivateKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DHPublicKeySpec ? new JCEDHPublicKey((DHPublicKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class DSA extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DSAPrivateKeySpec ? new JDKDSAPrivateKey((DSAPrivateKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DSAPublicKeySpec ? new JDKDSAPublicKey((DSAPublicKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class ElGamal extends JDKKeyFactory {
        public ElGamal() {
            this.elGamalFactory = true;
        }

        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof ElGamalPrivateKeySpec ? new JCEElGamalPrivateKey((ElGamalPrivateKeySpec) keySpec) : keySpec instanceof DHPrivateKeySpec ? new JCEElGamalPrivateKey((DHPrivateKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof ElGamalPublicKeySpec ? new JCEElGamalPublicKey((ElGamalPublicKeySpec) keySpec) : keySpec instanceof DHPublicKeySpec ? new JCEElGamalPublicKey((DHPublicKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class GOST3410 extends JDKKeyFactory {
        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof GOST3410PrivateKeySpec ? new JDKGOST3410PrivateKey((GOST3410PrivateKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePrivate(keySpec);
        }

        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof GOST3410PublicKeySpec ? new JDKGOST3410PublicKey((GOST3410PublicKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class RSA extends JDKKeyFactory {
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:3:0x0005 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.security.spec.KeySpec, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v13, types: [java.security.PrivateKey] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
            throw new java.security.spec.InvalidKeySpecException(r4.toString());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
            return new org.bouncycastle.jce.provider.JCERSAPrivateCrtKey(new org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure((org.bouncycastle.asn1.ASN1Sequence) org.bouncycastle.asn1.ASN1Object.fromByteArray(((java.security.spec.PKCS8EncodedKeySpec) r4).getEncoded())));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0010 */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof PKCS8EncodedKeySpec) {
                keySpec = JDKKeyFactory.createPrivateKeyFromDERStream(((PKCS8EncodedKeySpec) keySpec).getEncoded());
                return keySpec;
            } else if (keySpec instanceof RSAPrivateCrtKeySpec) {
                return new JCERSAPrivateCrtKey((RSAPrivateCrtKeySpec) keySpec);
            } else {
                if (keySpec instanceof RSAPrivateKeySpec) {
                    return new JCERSAPrivateKey((RSAPrivateKeySpec) keySpec);
                }
                throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
            }
        }

        /* access modifiers changed from: protected */
        @Override // java.security.KeyFactorySpi, org.bouncycastle.jce.provider.JDKKeyFactory
        public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof RSAPublicKeySpec ? new JCERSAPublicKey((RSAPublicKeySpec) keySpec) : JDKKeyFactory.super.engineGeneratePublic(keySpec);
        }
    }

    public static class X509 extends JDKKeyFactory {
    }

    protected static PrivateKey createPrivateKeyFromDERStream(byte[] bArr) throws IOException {
        return createPrivateKeyFromPrivateKeyInfo(new PrivateKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(bArr)));
    }

    static PrivateKey createPrivateKeyFromPrivateKeyInfo(PrivateKeyInfo privateKeyInfo) {
        DERObjectIdentifier objectId = privateKeyInfo.getAlgorithmId().getObjectId();
        if (RSAUtil.isRsaOid(objectId)) {
            return new JCERSAPrivateCrtKey(privateKeyInfo);
        }
        if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            return new JCEDHPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.dhpublicnumber)) {
            return new JCEDHPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            return new JCEElGamalPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_dsa)) {
            return new JDKDSAPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            return new JCEECPrivateKey(privateKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
            return new JDKGOST3410PrivateKey(privateKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
            return new JCEECPrivateKey(privateKeyInfo);
        }
        throw new RuntimeException("algorithm identifier " + objectId + " in key not recognised");
    }

    public static PublicKey createPublicKeyFromDERStream(byte[] bArr) throws IOException {
        return createPublicKeyFromPublicKeyInfo(new SubjectPublicKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(bArr)));
    }

    static PublicKey createPublicKeyFromPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        DERObjectIdentifier objectId = subjectPublicKeyInfo.getAlgorithmId().getObjectId();
        if (RSAUtil.isRsaOid(objectId)) {
            return new JCERSAPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            return new JCEDHPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.dhpublicnumber)) {
            return new JCEDHPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            return new JCEElGamalPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_dsa)) {
            return new JDKDSAPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(OIWObjectIdentifiers.dsaWithSHA1)) {
            return new JDKDSAPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            return new JCEECPublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
            return new JDKGOST3410PublicKey(subjectPublicKeyInfo);
        }
        if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_2001)) {
            return new JCEECPublicKey(subjectPublicKeyInfo);
        }
        throw new RuntimeException("algorithm identifier " + objectId + " in key not recognised");
    }

    /* access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return createPrivateKeyFromDERStream(((PKCS8EncodedKeySpec) keySpec).getEncoded());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return createPublicKeyFromDERStream(((X509EncodedKeySpec) keySpec).getEncoded());
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(RSAPublicKeySpec.class) && (key instanceof RSAPublicKey)) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
            return new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        } else if (cls.isAssignableFrom(RSAPrivateKeySpec.class) && (key instanceof RSAPrivateKey)) {
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
            return new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        } else if (cls.isAssignableFrom(RSAPrivateCrtKeySpec.class) && (key instanceof RSAPrivateCrtKey)) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
        } else if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        } else if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            throw new RuntimeException("not implemented yet " + key + " " + cls);
        } else {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof RSAPublicKey) {
            return new JCERSAPublicKey((RSAPublicKey) key);
        }
        if (key instanceof RSAPrivateCrtKey) {
            return new JCERSAPrivateCrtKey((RSAPrivateCrtKey) key);
        }
        if (key instanceof RSAPrivateKey) {
            return new JCERSAPrivateKey((RSAPrivateKey) key);
        }
        if (key instanceof DHPublicKey) {
            return this.elGamalFactory ? new JCEElGamalPublicKey((DHPublicKey) key) : new JCEDHPublicKey((DHPublicKey) key);
        }
        if (key instanceof DHPrivateKey) {
            return this.elGamalFactory ? new JCEElGamalPrivateKey((DHPrivateKey) key) : new JCEDHPrivateKey((DHPrivateKey) key);
        }
        if (key instanceof DSAPublicKey) {
            return new JDKDSAPublicKey((DSAPublicKey) key);
        }
        if (key instanceof DSAPrivateKey) {
            return new JDKDSAPrivateKey((DSAPrivateKey) key);
        }
        if (key instanceof ElGamalPublicKey) {
            return new JCEElGamalPublicKey((ElGamalPublicKey) key);
        }
        if (key instanceof ElGamalPrivateKey) {
            return new JCEElGamalPrivateKey((ElGamalPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
