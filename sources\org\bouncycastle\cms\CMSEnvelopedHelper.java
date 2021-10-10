package org.bouncycastle.cms;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.util.io.TeeInputStream;
import org.objectweb.asm.Opcodes;

/* access modifiers changed from: package-private */
public class CMSEnvelopedHelper {
    private static final Map BASE_CIPHER_NAMES;
    private static final Map CIPHER_ALG_NAMES;
    static final CMSEnvelopedHelper INSTANCE = new CMSEnvelopedHelper();
    private static final Map KEYSIZES;
    private static final Map MAC_ALG_NAMES;

    /* access modifiers changed from: package-private */
    public static class CMSAuthenticatedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private Mac mac;
        private CMSReadable readable;

        CMSAuthenticatedSecureReadable(AlgorithmIdentifier algorithmIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public AlgorithmIdentifier getAlgorithm() {
            return this.algorithm;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public Object getCryptoObject() {
            return this.mac;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public CMSReadable getReadable(final SecretKey secretKey, final Provider provider) throws CMSException {
            final String id = this.algorithm.getObjectId().getId();
            final ASN1Object aSN1Object = (ASN1Object) this.algorithm.getParameters();
            this.mac = (Mac) CMSEnvelopedHelper.execute(new JCECallback() {
                /* class org.bouncycastle.cms.CMSEnvelopedHelper.CMSAuthenticatedSecureReadable.AnonymousClass1 */

                @Override // org.bouncycastle.cms.CMSEnvelopedHelper.JCECallback
                public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException {
                    Mac mac = CMSEnvelopedHelper.INSTANCE.getMac(id, provider);
                    ASN1Object aSN1Object = aSN1Object;
                    if (aSN1Object == null || (aSN1Object instanceof ASN1Null)) {
                        mac.init(secretKey);
                    } else {
                        AlgorithmParameters createAlgorithmParameters = CMSEnvelopedHelper.INSTANCE.createAlgorithmParameters(id, provider);
                        try {
                            createAlgorithmParameters.init(aSN1Object.getEncoded(), "ASN.1");
                            mac.init(secretKey, createAlgorithmParameters.getParameterSpec(IvParameterSpec.class));
                        } catch (IOException e) {
                            throw new CMSException("error decoding algorithm parameters.", e);
                        }
                    }
                    return mac;
                }
            });
            try {
                return new CMSProcessableInputStream(new TeeInputStream(this.readable.getInputStream(), new MacOutputStream(this.mac)));
            } catch (IOException e) {
                throw new CMSException("error reading content.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class CMSDigestAuthenticatedSecureReadable implements CMSSecureReadable {
        private DigestCalculator digestCalculator;
        private CMSReadable readable;

        public CMSDigestAuthenticatedSecureReadable(DigestCalculator digestCalculator2, CMSReadable cMSReadable) {
            this.digestCalculator = digestCalculator2;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public AlgorithmIdentifier getAlgorithm() {
            return null;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public Object getCryptoObject() {
            return null;
        }

        public byte[] getDigest() {
            return this.digestCalculator.getDigest();
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() throws IOException, CMSException {
            return new FilterInputStream(this.readable.getInputStream()) {
                /* class org.bouncycastle.cms.CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable.AnonymousClass1 */

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    int read = this.in.read();
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(read);
                    }
                    return read;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int read = this.in.read(bArr, i, i2);
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(bArr, i, read);
                    }
                    return read;
                }
            };
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class CMSEnvelopedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private Cipher cipher;
        private CMSReadable readable;

        CMSEnvelopedSecureReadable(AlgorithmIdentifier algorithmIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public AlgorithmIdentifier getAlgorithm() {
            return this.algorithm;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public Object getCryptoObject() {
            return this.cipher;
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }

        @Override // org.bouncycastle.cms.CMSSecureReadable
        public CMSReadable getReadable(final SecretKey secretKey, final Provider provider) throws CMSException {
            final String id = this.algorithm.getObjectId().getId();
            final ASN1Object aSN1Object = (ASN1Object) this.algorithm.getParameters();
            this.cipher = (Cipher) CMSEnvelopedHelper.execute(new JCECallback() {
                /* class org.bouncycastle.cms.CMSEnvelopedHelper.CMSEnvelopedSecureReadable.AnonymousClass1 */

                @Override // org.bouncycastle.cms.CMSEnvelopedHelper.JCECallback
                public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException {
                    IvParameterSpec ivParameterSpec;
                    SecretKey secretKey;
                    Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(id, provider);
                    ASN1Object aSN1Object = aSN1Object;
                    if (aSN1Object != null && !(aSN1Object instanceof ASN1Null)) {
                        try {
                            AlgorithmParameters createAlgorithmParameters = CMSEnvelopedHelper.INSTANCE.createAlgorithmParameters(id, createSymmetricCipher.getProvider());
                            try {
                                createAlgorithmParameters.init(aSN1Object.getEncoded(), "ASN.1");
                                createSymmetricCipher.init(2, secretKey, createAlgorithmParameters);
                                return createSymmetricCipher;
                            } catch (IOException e) {
                                throw new CMSException("error decoding algorithm parameters.", e);
                            }
                        } catch (NoSuchAlgorithmException e2) {
                            if (id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals("1.3.6.1.4.1.188.7.1.1.2") || id.equals(CMSEnvelopedDataGenerator.AES128_CBC) || id.equals(CMSEnvelopedDataGenerator.AES192_CBC) || id.equals(CMSEnvelopedDataGenerator.AES256_CBC)) {
                                secretKey = secretKey;
                                ivParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(aSN1Object).getOctets());
                            } else {
                                throw e2;
                            }
                        }
                    } else if (id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals("1.3.6.1.4.1.188.7.1.1.2") || id.equals("1.2.840.113533.7.66.10")) {
                        secretKey = secretKey;
                        ivParameterSpec = new IvParameterSpec(new byte[8]);
                    } else {
                        createSymmetricCipher.init(2, secretKey);
                        return createSymmetricCipher;
                    }
                    createSymmetricCipher.init(2, secretKey, ivParameterSpec);
                    return createSymmetricCipher;
                }
            });
            try {
                return new CMSProcessableInputStream(new CipherInputStream(this.readable.getInputStream(), this.cipher));
            } catch (IOException e) {
                throw new CMSException("error reading content.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public interface JCECallback {
        Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException;
    }

    static {
        HashMap hashMap = new HashMap();
        KEYSIZES = hashMap;
        HashMap hashMap2 = new HashMap();
        BASE_CIPHER_NAMES = hashMap2;
        HashMap hashMap3 = new HashMap();
        CIPHER_ALG_NAMES = hashMap3;
        HashMap hashMap4 = new HashMap();
        MAC_ALG_NAMES = hashMap4;
        hashMap.put(CMSEnvelopedGenerator.DES_EDE3_CBC, new Integer((int) Opcodes.CHECKCAST));
        hashMap.put(CMSEnvelopedGenerator.AES128_CBC, new Integer(128));
        hashMap.put(CMSEnvelopedGenerator.AES192_CBC, new Integer((int) Opcodes.CHECKCAST));
        hashMap.put(CMSEnvelopedGenerator.AES256_CBC, new Integer(256));
        hashMap2.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE");
        hashMap2.put(CMSEnvelopedGenerator.AES128_CBC, "AES");
        hashMap2.put(CMSEnvelopedGenerator.AES192_CBC, "AES");
        hashMap2.put(CMSEnvelopedGenerator.AES256_CBC, "AES");
        hashMap3.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        hashMap3.put(CMSEnvelopedGenerator.AES128_CBC, "AES/CBC/PKCS5Padding");
        hashMap3.put(CMSEnvelopedGenerator.AES192_CBC, "AES/CBC/PKCS5Padding");
        hashMap3.put(CMSEnvelopedGenerator.AES256_CBC, "AES/CBC/PKCS5Padding");
        hashMap4.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDEMac");
        hashMap4.put(CMSEnvelopedGenerator.AES128_CBC, "AESMac");
        hashMap4.put(CMSEnvelopedGenerator.AES192_CBC, "AESMac");
        hashMap4.put(CMSEnvelopedGenerator.AES256_CBC, "AESMac");
    }

    CMSEnvelopedHelper() {
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        return buildRecipientInformationStore(aSN1Set, algorithmIdentifier, cMSSecureReadable, null);
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != aSN1Set.size(); i++) {
            readRecipientInfo(arrayList, RecipientInfo.getInstance(aSN1Set.getObjectAt(i)), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        }
        return new RecipientInformationStore(arrayList);
    }

    private AlgorithmParameters createAlgorithmParams(String str, Provider provider) throws NoSuchAlgorithmException {
        return provider != null ? AlgorithmParameters.getInstance(str, provider) : AlgorithmParameters.getInstance(str);
    }

    private AlgorithmParameterGenerator createAlgorithmParamsGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        return provider != null ? AlgorithmParameterGenerator.getInstance(str, provider) : AlgorithmParameterGenerator.getInstance(str);
    }

    private KeyGenerator createKeyGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        return provider != null ? KeyGenerator.getInstance(str, provider) : KeyGenerator.getInstance(str);
    }

    private Mac createMac(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return provider != null ? Mac.getInstance(str, provider) : Mac.getInstance(str);
    }

    static Object execute(JCECallback jCECallback) throws CMSException {
        try {
            return jCECallback.doInJCE();
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchPaddingException e3) {
            throw new CMSException("required padding not supported.", e3);
        } catch (InvalidAlgorithmParameterException e4) {
            throw new CMSException("algorithm parameters invalid.", e4);
        } catch (InvalidParameterSpecException e5) {
            throw new CMSException("MAC algorithm parameter spec invalid.", e5);
        }
    }

    private Cipher getCipherInstance(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        return provider != null ? Cipher.getInstance(str, provider) : Cipher.getInstance(str);
    }

    private static void readRecipientInfo(List list, RecipientInfo recipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        Object passwordRecipientInformation;
        DEREncodable info = recipientInfo.getInfo();
        if (info instanceof KeyTransRecipientInfo) {
            passwordRecipientInformation = new KeyTransRecipientInformation((KeyTransRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else if (info instanceof KEKRecipientInfo) {
            passwordRecipientInformation = new KEKRecipientInformation((KEKRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else if (info instanceof KeyAgreeRecipientInfo) {
            KeyAgreeRecipientInformation.readRecipientInfo(list, (KeyAgreeRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
            return;
        } else if (info instanceof PasswordRecipientInfo) {
            passwordRecipientInformation = new PasswordRecipientInformation((PasswordRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else {
            return;
        }
        list.add(passwordRecipientInformation);
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createAlgorithmParamsGenerator(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createAlgorithmParamsGenerator(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters createAlgorithmParameters(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createAlgorithmParams(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createAlgorithmParams(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public Cipher createAsymmetricCipher(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        String asymmetricEncryptionAlgName = getAsymmetricEncryptionAlgName(str);
        if (!asymmetricEncryptionAlgName.equals(str)) {
            try {
                return Cipher.getInstance(asymmetricEncryptionAlgName, str2);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return Cipher.getInstance(str, str2);
    }

    /* access modifiers changed from: package-private */
    public Cipher createAsymmetricCipher(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        String asymmetricEncryptionAlgName = getAsymmetricEncryptionAlgName(str);
        if (!asymmetricEncryptionAlgName.equals(str)) {
            try {
                return getCipherInstance(asymmetricEncryptionAlgName, provider);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return getCipherInstance(str, provider);
    }

    /* access modifiers changed from: package-private */
    public Cipher createSymmetricCipher(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            return getCipherInstance(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                return getCipherInstance((String) CIPHER_ALG_NAMES.get(str), provider);
            } catch (NoSuchAlgorithmException unused) {
                if (provider != null) {
                    return createSymmetricCipher(str, null);
                }
                throw e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public KeyGenerator createSymmetricKeyGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createKeyGenerator(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createKeyGenerator(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            if (provider != null) {
                return createSymmetricKeyGenerator(str, null);
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public String getAsymmetricEncryptionAlgName(String str) {
        return PKCSObjectIdentifiers.rsaEncryption.getId().equals(str) ? "RSA/ECB/PKCS1Padding" : str;
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters getEncryptionAlgorithmParameters(String str, byte[] bArr, Provider provider) throws CMSException {
        if (bArr == null) {
            return null;
        }
        try {
            AlgorithmParameters createAlgorithmParameters = createAlgorithmParameters(str, provider);
            createAlgorithmParameters.init(bArr, "ASN.1");
            return createAlgorithmParameters;
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find parameters for algorithm", e);
        } catch (IOException e2) {
            throw new CMSException("can't find parse parameters", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int getKeySize(String str) {
        Integer num = (Integer) KEYSIZES.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("no keysize for " + str);
    }

    /* access modifiers changed from: package-private */
    public Mac getMac(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            return createMac(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                return createMac((String) MAC_ALG_NAMES.get(str), provider);
            } catch (NoSuchAlgorithmException unused) {
                if (provider != null) {
                    return getMac(str, null);
                }
                throw e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getRFC3211WrapperName(String str) {
        String str2 = (String) BASE_CIPHER_NAMES.get(str);
        if (str2 != null) {
            return str2 + "RFC3211Wrap";
        }
        throw new IllegalArgumentException("no name for " + str);
    }

    /* access modifiers changed from: package-private */
    public String getSymmetricCipherName(String str) {
        String str2 = (String) BASE_CIPHER_NAMES.get(str);
        return str2 != null ? str2 : str;
    }
}
