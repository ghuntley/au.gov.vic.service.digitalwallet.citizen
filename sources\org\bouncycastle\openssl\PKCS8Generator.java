package org.bouncycastle.openssl;

import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;

public class PKCS8Generator implements PemObjectGenerator {
    public static final String AES_128_CBC = NISTObjectIdentifiers.id_aes128_CBC.getId();
    public static final String AES_192_CBC = NISTObjectIdentifiers.id_aes192_CBC.getId();
    public static final String AES_256_CBC = NISTObjectIdentifiers.id_aes256_CBC.getId();
    public static final String DES3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.getId();
    public static final String PBE_SHA1_2DES = PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC.getId();
    public static final String PBE_SHA1_3DES = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC.getId();
    public static final String PBE_SHA1_RC2_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC.getId();
    public static final String PBE_SHA1_RC2_40 = PKCSObjectIdentifiers.pbewithSHAAnd40BitRC2_CBC.getId();
    public static final String PBE_SHA1_RC4_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.getId();
    public static final String PBE_SHA1_RC4_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4.getId();
    private String algorithm;
    private Cipher cipher;
    private int iterationCount;
    private PrivateKey key;
    private AlgorithmParameterGenerator paramGen;
    private char[] password;
    private SecureRandom random;
    private SecretKeyFactory secKeyFact;

    public PKCS8Generator(PrivateKey privateKey) {
        this.key = privateKey;
    }

    public PKCS8Generator(PrivateKey privateKey, String str, String str2) throws NoSuchProviderException, NoSuchAlgorithmException {
        Provider provider = Security.getProvider(str2);
        if (provider != null) {
            init(privateKey, str, provider);
            return;
        }
        throw new NoSuchProviderException("cannot find provider: " + str2);
    }

    public PKCS8Generator(PrivateKey privateKey, String str, Provider provider) throws NoSuchAlgorithmException {
        init(privateKey, str, provider);
    }

    private void init(PrivateKey privateKey, String str, Provider provider) throws NoSuchAlgorithmException {
        this.key = privateKey;
        this.algorithm = str;
        this.iterationCount = 2048;
        try {
            this.cipher = Cipher.getInstance(str, provider);
            if (PEMUtilities.isPKCS5Scheme2(new DERObjectIdentifier(str))) {
                this.paramGen = AlgorithmParameterGenerator.getInstance(str, provider);
            } else {
                this.secKeyFact = SecretKeyFactory.getInstance(str, provider);
            }
        } catch (NoSuchPaddingException e) {
            throw new NoSuchAlgorithmException(str + " found, but padding not available: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.util.io.pem.PemObjectGenerator
    public PemObject generate() throws PemGenerationException {
        byte[] encoded = this.key.getEncoded();
        String str = this.algorithm;
        if (str == null) {
            return new PemObject("PRIVATE KEY", encoded);
        }
        DERObjectIdentifier dERObjectIdentifier = new DERObjectIdentifier(str);
        if (PEMUtilities.isPKCS5Scheme2(dERObjectIdentifier)) {
            byte[] bArr = new byte[20];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            SecretKey generateSecretKeyForPKCS5Scheme2 = PEMUtilities.generateSecretKeyForPKCS5Scheme2(this.algorithm, this.password, bArr, this.iterationCount);
            AlgorithmParameters generateParameters = this.paramGen.generateParameters();
            try {
                this.cipher.init(1, generateSecretKeyForPKCS5Scheme2, generateParameters);
                EncryptionScheme encryptionScheme = new EncryptionScheme(new DERObjectIdentifier(this.algorithm), ASN1Object.fromByteArray(generateParameters.getEncoded()));
                KeyDerivationFunc keyDerivationFunc = new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr, this.iterationCount));
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(keyDerivationFunc);
                aSN1EncodableVector.add(encryptionScheme);
                return new PemObject("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(new DERSequence(aSN1EncodableVector))), this.cipher.doFinal(encoded)).getEncoded());
            } catch (IOException e) {
                throw new PemGenerationException(e.getMessage(), e);
            } catch (GeneralSecurityException e2) {
                throw new PemGenerationException(e2.getMessage(), e2);
            }
        } else if (PEMUtilities.isPKCS12(dERObjectIdentifier)) {
            byte[] bArr2 = new byte[20];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr2);
            try {
                PBEKeySpec pBEKeySpec = new PBEKeySpec(this.password);
                this.cipher.init(1, this.secKeyFact.generateSecret(pBEKeySpec), new PBEParameterSpec(bArr2, this.iterationCount));
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.add(new DEROctetString(bArr2));
                aSN1EncodableVector2.add(new DERInteger(this.iterationCount));
                return new PemObject("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(dERObjectIdentifier, new PKCS12PBEParams(new DERSequence(aSN1EncodableVector2))), this.cipher.doFinal(encoded)).getEncoded());
            } catch (IOException e3) {
                throw new PemGenerationException(e3.getMessage(), e3);
            } catch (GeneralSecurityException e4) {
                throw new PemGenerationException(e4.getMessage(), e4);
            }
        } else {
            throw new PemGenerationException("unknown algorithm: " + this.algorithm);
        }
    }

    public PKCS8Generator setIterationCount(int i) {
        this.iterationCount = i;
        return this;
    }

    public PKCS8Generator setPassword(char[] cArr) {
        this.password = cArr;
        return this;
    }

    public PKCS8Generator setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }
}
