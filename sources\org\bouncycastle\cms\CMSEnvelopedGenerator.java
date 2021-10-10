package org.bouncycastle.cms;

import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.crypto.SecretKey;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.KEKIdentifier;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

public class CMSEnvelopedGenerator {
    public static final String AES128_CBC = NISTObjectIdentifiers.id_aes128_CBC.getId();
    public static final String AES128_WRAP = NISTObjectIdentifiers.id_aes128_wrap.getId();
    public static final String AES192_CBC = NISTObjectIdentifiers.id_aes192_CBC.getId();
    public static final String AES192_WRAP = NISTObjectIdentifiers.id_aes192_wrap.getId();
    public static final String AES256_CBC = NISTObjectIdentifiers.id_aes256_CBC.getId();
    public static final String AES256_WRAP = NISTObjectIdentifiers.id_aes256_wrap.getId();
    public static final String CAMELLIA128_CBC = NTTObjectIdentifiers.id_camellia128_cbc.getId();
    public static final String CAMELLIA128_WRAP = NTTObjectIdentifiers.id_camellia128_wrap.getId();
    public static final String CAMELLIA192_CBC = NTTObjectIdentifiers.id_camellia192_cbc.getId();
    public static final String CAMELLIA192_WRAP = NTTObjectIdentifiers.id_camellia192_wrap.getId();
    public static final String CAMELLIA256_CBC = NTTObjectIdentifiers.id_camellia256_cbc.getId();
    public static final String CAMELLIA256_WRAP = NTTObjectIdentifiers.id_camellia256_wrap.getId();
    public static final String CAST5_CBC = "1.2.840.113533.7.66.10";
    public static final String DES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.getId();
    public static final String DES_EDE3_WRAP = PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId();
    public static final String ECDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme.getId();
    public static final String ECMQV_SHA1KDF = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme.getId();
    public static final String IDEA_CBC = "1.3.6.1.4.1.188.7.1.1.2";
    public static final String RC2_CBC = PKCSObjectIdentifiers.RC2_CBC.getId();
    public static final String SEED_CBC = KISAObjectIdentifiers.id_seedCBC.getId();
    public static final String SEED_WRAP = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId();
    final List oldRecipientInfoGenerators;
    final SecureRandom rand;
    final List recipientInfoGenerators;
    protected CMSAttributeTableGenerator unprotectedAttributeGenerator;

    public CMSEnvelopedGenerator() {
        this(new SecureRandom());
    }

    public CMSEnvelopedGenerator(SecureRandom secureRandom) {
        this.oldRecipientInfoGenerators = new ArrayList();
        this.recipientInfoGenerators = new ArrayList();
        this.unprotectedAttributeGenerator = null;
        this.rand = secureRandom;
    }

    public void addKEKRecipient(SecretKey secretKey, KEKIdentifier kEKIdentifier) {
        KEKIntRecipientInfoGenerator kEKIntRecipientInfoGenerator = new KEKIntRecipientInfoGenerator();
        kEKIntRecipientInfoGenerator.setKEKIdentifier(kEKIdentifier);
        kEKIntRecipientInfoGenerator.setKeyEncryptionKey(secretKey);
        this.oldRecipientInfoGenerators.add(kEKIntRecipientInfoGenerator);
    }

    public void addKEKRecipient(SecretKey secretKey, byte[] bArr) {
        addKEKRecipient(secretKey, new KEKIdentifier(bArr, null, null));
    }

    public void addKeyAgreementRecipient(String str, PrivateKey privateKey, PublicKey publicKey, X509Certificate x509Certificate, String str2, String str3) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        addKeyAgreementRecipient(str, privateKey, publicKey, x509Certificate, str2, CMSUtils.getProvider(str3));
    }

    public void addKeyAgreementRecipient(String str, PrivateKey privateKey, PublicKey publicKey, X509Certificate x509Certificate, String str2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        addKeyAgreementRecipients(str, privateKey, publicKey, Collections.singletonList(x509Certificate), str2, provider);
    }

    public void addKeyAgreementRecipients(String str, PrivateKey privateKey, PublicKey publicKey, Collection collection, String str2, String str3) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        addKeyAgreementRecipients(str, privateKey, publicKey, collection, str2, CMSUtils.getProvider(str3));
    }

    public void addKeyAgreementRecipients(String str, PrivateKey privateKey, PublicKey publicKey, Collection collection, String str2, Provider provider) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyAgreeIntRecipientInfoGenerator keyAgreeIntRecipientInfoGenerator = new KeyAgreeIntRecipientInfoGenerator();
        keyAgreeIntRecipientInfoGenerator.setKeyAgreementOID(new DERObjectIdentifier(str));
        keyAgreeIntRecipientInfoGenerator.setKeyEncryptionOID(new DERObjectIdentifier(str2));
        keyAgreeIntRecipientInfoGenerator.setRecipientCerts(collection);
        keyAgreeIntRecipientInfoGenerator.setSenderKeyPair(new KeyPair(publicKey, privateKey));
        this.oldRecipientInfoGenerators.add(keyAgreeIntRecipientInfoGenerator);
    }

    public void addKeyTransRecipient(PublicKey publicKey, byte[] bArr) throws IllegalArgumentException {
        KeyTransIntRecipientInfoGenerator keyTransIntRecipientInfoGenerator = new KeyTransIntRecipientInfoGenerator();
        keyTransIntRecipientInfoGenerator.setRecipientPublicKey(publicKey);
        keyTransIntRecipientInfoGenerator.setSubjectKeyIdentifier(new DEROctetString(bArr));
        this.oldRecipientInfoGenerators.add(keyTransIntRecipientInfoGenerator);
    }

    public void addKeyTransRecipient(X509Certificate x509Certificate) throws IllegalArgumentException {
        KeyTransIntRecipientInfoGenerator keyTransIntRecipientInfoGenerator = new KeyTransIntRecipientInfoGenerator();
        keyTransIntRecipientInfoGenerator.setRecipientCert(x509Certificate);
        this.oldRecipientInfoGenerators.add(keyTransIntRecipientInfoGenerator);
    }

    public void addPasswordRecipient(CMSPBEKey cMSPBEKey, String str) {
        PBKDF2Params pBKDF2Params = new PBKDF2Params(cMSPBEKey.getSalt(), cMSPBEKey.getIterationCount());
        PasswordIntRecipientInfoGenerator passwordIntRecipientInfoGenerator = new PasswordIntRecipientInfoGenerator();
        passwordIntRecipientInfoGenerator.setKeyDerivationAlgorithm(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, pBKDF2Params));
        passwordIntRecipientInfoGenerator.setKeyEncryptionKey(new SecretKeySpec(cMSPBEKey.getEncoded(str), str));
        this.oldRecipientInfoGenerators.add(passwordIntRecipientInfoGenerator);
    }

    public void addRecipientInfoGenerator(RecipientInfoGenerator recipientInfoGenerator) {
        this.recipientInfoGenerators.add(recipientInfoGenerator);
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters generateParameters(String str, SecretKey secretKey, Provider provider) throws CMSException {
        try {
            AlgorithmParameterGenerator instance = AlgorithmParameterGenerator.getInstance(str, provider);
            if (str.equals(RC2_CBC)) {
                byte[] bArr = new byte[8];
                this.rand.nextBytes(bArr);
                try {
                    instance.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), this.rand);
                } catch (InvalidAlgorithmParameterException e) {
                    throw new CMSException("parameters generation error: " + e, e);
                }
            }
            return instance.generateParameters();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AlgorithmIdentifier getAlgorithmIdentifier(String str, AlgorithmParameters algorithmParameters) throws IOException {
        return new AlgorithmIdentifier(new DERObjectIdentifier(str), algorithmParameters != null ? ASN1Object.fromByteArray(algorithmParameters.getEncoded("ASN.1")) : DERNull.INSTANCE);
    }

    public void setUnprotectedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unprotectedAttributeGenerator = cMSAttributeTableGenerator;
    }
}
