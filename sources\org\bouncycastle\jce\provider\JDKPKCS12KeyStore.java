package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.BEROutputStream;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import org.bouncycastle.asn1.pkcs.CertBag;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.EncryptedData;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class JDKPKCS12KeyStore extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;
    static final int KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    static final int NULL = 0;
    private static final int SALT_SIZE = 20;
    static final int SEALED = 4;
    static final int SECRET = 3;
    private static final Provider bcProvider = new BouncyCastleProvider();
    private DERObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs = new IgnoresCaseHashtable();
    private Hashtable chainCerts = new Hashtable();
    private DERObjectIdentifier keyAlgorithm;
    private Hashtable keyCerts = new Hashtable();
    private IgnoresCaseHashtable keys = new IgnoresCaseHashtable();
    private Hashtable localIds = new Hashtable();
    protected SecureRandom random = new SecureRandom();

    public static class BCPKCS12KeyStore extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore() {
            super(JDKPKCS12KeyStore.bcProvider, pbeWithSHAAnd3_KeyTripleDES_CBC, pbewithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore3DES() {
            super(JDKPKCS12KeyStore.bcProvider, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    /* access modifiers changed from: private */
    public class CertId {
        byte[] id;

        CertId(PublicKey publicKey) {
            this.id = JDKPKCS12KeyStore.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        CertId(byte[] bArr) {
            this.id = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CertId)) {
                return false;
            }
            return Arrays.areEqual(this.id, ((CertId) obj).id);
        }

        public int hashCode() {
            return Arrays.hashCode(this.id);
        }
    }

    public static class DefPKCS12KeyStore extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore() {
            super(null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbewithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore3DES() {
            super(null, pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
        }
    }

    /* access modifiers changed from: private */
    public static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public Object get(String str) {
            String str2 = (String) this.keys.get(Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.get(str2);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public void put(String str, Object obj) {
            String lowerCase = Strings.toLowerCase(str);
            String str2 = (String) this.keys.get(lowerCase);
            if (str2 != null) {
                this.orig.remove(str2);
            }
            this.keys.put(lowerCase, str);
            this.orig.put(str, obj);
        }

        public Object remove(String str) {
            String str2 = (String) this.keys.remove(Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.remove(str2);
        }
    }

    public JDKPKCS12KeyStore(Provider provider, DERObjectIdentifier dERObjectIdentifier, DERObjectIdentifier dERObjectIdentifier2) {
        CertificateFactory instance;
        this.keyAlgorithm = dERObjectIdentifier;
        this.certAlgorithm = dERObjectIdentifier2;
        if (provider != null) {
            try {
                instance = CertificateFactory.getInstance("X.509", provider);
            } catch (Exception e) {
                throw new IllegalArgumentException("can't create cert factory - " + e.toString());
            }
        } else {
            instance = CertificateFactory.getInstance("X.509");
        }
        this.certFact = instance;
    }

    private static byte[] calculatePbeMac(DERObjectIdentifier dERObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        String id = dERObjectIdentifier.getId();
        Provider provider = bcProvider;
        SecretKeyFactory instance = SecretKeyFactory.getInstance(id, provider);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        JCEPBEKey jCEPBEKey = (JCEPBEKey) instance.generateSecret(new PBEKeySpec(cArr));
        jCEPBEKey.setTryWrongPKCS12Zero(z);
        Mac instance2 = Mac.getInstance(dERObjectIdentifier.getId(), provider);
        instance2.init(jCEPBEKey, pBEParameterSpec);
        instance2.update(bArr2);
        return instance2.doFinal();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) ASN1Object.fromByteArray(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    private void doStore(OutputStream outputStream, char[] cArr, boolean z) throws IOException {
        Enumeration enumeration;
        boolean z2;
        Enumeration enumeration2;
        boolean z3;
        boolean z4;
        Objects.requireNonNull(cArr, "No password supplied for PKCS#12 KeyStore.");
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration keys2 = this.keys.keys();
        while (keys2.hasMoreElements()) {
            byte[] bArr = new byte[20];
            this.random.nextBytes(bArr);
            String str = (String) keys2.nextElement();
            PrivateKey privateKey = (PrivateKey) this.keys.get(str);
            PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, 1024);
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(this.keyAlgorithm, pKCS12PBEParams.getDERObject()), wrapKey(this.keyAlgorithm.getId(), privateKey, pKCS12PBEParams, cArr));
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            if (privateKey instanceof PKCS12BagAttributeCarrier) {
                PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
                DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_friendlyName);
                if (dERBMPString == null || !dERBMPString.getString().equals(str)) {
                    pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str));
                }
                if (pKCS12BagAttributeCarrier.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                    pKCS12BagAttributeCarrier.setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(engineGetCertificate(str).getPublicKey()));
                }
                Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
                z4 = false;
                while (bagAttributeKeys.hasMoreElements()) {
                    DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) bagAttributeKeys.nextElement();
                    ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                    aSN1EncodableVector3.add(dERObjectIdentifier);
                    aSN1EncodableVector3.add(new DERSet(pKCS12BagAttributeCarrier.getBagAttribute(dERObjectIdentifier)));
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                    z4 = true;
                }
            } else {
                z4 = false;
            }
            if (!z4) {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                Certificate engineGetCertificate = engineGetCertificate(str);
                aSN1EncodableVector4.add(pkcs_9_at_localKeyId);
                aSN1EncodableVector4.add(new DERSet(createSubjectKeyId(engineGetCertificate.getPublicKey())));
                aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector4));
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                aSN1EncodableVector5.add(pkcs_9_at_friendlyName);
                aSN1EncodableVector5.add(new DERSet(new DERBMPString(str)));
                aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector5));
            }
            aSN1EncodableVector.add(new SafeBag(pkcs8ShroudedKeyBag, encryptedPrivateKeyInfo.getDERObject(), new DERSet(aSN1EncodableVector2)));
        }
        BERConstructedOctetString bERConstructedOctetString = new BERConstructedOctetString(new DERSequence(aSN1EncodableVector).getDEREncoded());
        byte[] bArr2 = new byte[20];
        this.random.nextBytes(bArr2);
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(this.certAlgorithm, new PKCS12PBEParams(bArr2, 1024).getDERObject());
        Hashtable hashtable = new Hashtable();
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            try {
                String str2 = (String) keys3.nextElement();
                Certificate engineGetCertificate2 = engineGetCertificate(str2);
                CertBag certBag = new CertBag(x509Certificate, new DEROctetString(engineGetCertificate2.getEncoded()));
                ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                if (engineGetCertificate2 instanceof PKCS12BagAttributeCarrier) {
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) engineGetCertificate2;
                    DERBMPString dERBMPString2 = (DERBMPString) pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_friendlyName);
                    if (dERBMPString2 == null || !dERBMPString2.getString().equals(str2)) {
                        pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str2));
                    }
                    if (pKCS12BagAttributeCarrier2.getBagAttribute(pkcs_9_at_localKeyId) == null) {
                        pKCS12BagAttributeCarrier2.setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(engineGetCertificate2.getPublicKey()));
                    }
                    Enumeration bagAttributeKeys2 = pKCS12BagAttributeCarrier2.getBagAttributeKeys();
                    z3 = false;
                    while (bagAttributeKeys2.hasMoreElements()) {
                        DERObjectIdentifier dERObjectIdentifier2 = (DERObjectIdentifier) bagAttributeKeys2.nextElement();
                        ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                        aSN1EncodableVector8.add(dERObjectIdentifier2);
                        aSN1EncodableVector8.add(new DERSet(pKCS12BagAttributeCarrier2.getBagAttribute(dERObjectIdentifier2)));
                        aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector8));
                        keys3 = keys3;
                        z3 = true;
                    }
                    enumeration2 = keys3;
                } else {
                    enumeration2 = keys3;
                    z3 = false;
                }
                if (!z3) {
                    ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                    aSN1EncodableVector9.add(pkcs_9_at_localKeyId);
                    aSN1EncodableVector9.add(new DERSet(createSubjectKeyId(engineGetCertificate2.getPublicKey())));
                    aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector9));
                    ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                    aSN1EncodableVector10.add(pkcs_9_at_friendlyName);
                    aSN1EncodableVector10.add(new DERSet(new DERBMPString(str2)));
                    aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector10));
                }
                aSN1EncodableVector6.add(new SafeBag(certBag, certBag.getDERObject(), new DERSet(aSN1EncodableVector7)));
                hashtable.put(engineGetCertificate2, engineGetCertificate2);
                keys3 = enumeration2;
            } catch (CertificateEncodingException e) {
                throw new IOException("Error encoding certificate: " + e.toString());
            }
        }
        Enumeration keys4 = this.certs.keys();
        while (keys4.hasMoreElements()) {
            try {
                String str3 = (String) keys4.nextElement();
                Certificate certificate = (Certificate) this.certs.get(str3);
                if (this.keys.get(str3) == null) {
                    CertBag certBag2 = new CertBag(x509Certificate, new DEROctetString(certificate.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                    if (certificate instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) certificate;
                        DERBMPString dERBMPString3 = (DERBMPString) pKCS12BagAttributeCarrier3.getBagAttribute(pkcs_9_at_friendlyName);
                        if (dERBMPString3 == null || !dERBMPString3.getString().equals(str3)) {
                            pKCS12BagAttributeCarrier3.setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString(str3));
                        }
                        Enumeration bagAttributeKeys3 = pKCS12BagAttributeCarrier3.getBagAttributeKeys();
                        z2 = false;
                        while (bagAttributeKeys3.hasMoreElements()) {
                            DERObjectIdentifier dERObjectIdentifier3 = (DERObjectIdentifier) bagAttributeKeys3.nextElement();
                            if (dERObjectIdentifier3.equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                keys4 = keys4;
                            } else {
                                ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                                aSN1EncodableVector12.add(dERObjectIdentifier3);
                                aSN1EncodableVector12.add(new DERSet(pKCS12BagAttributeCarrier3.getBagAttribute(dERObjectIdentifier3)));
                                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
                                keys4 = keys4;
                                z2 = true;
                            }
                        }
                        enumeration = keys4;
                    } else {
                        enumeration = keys4;
                        z2 = false;
                    }
                    if (!z2) {
                        ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                        aSN1EncodableVector13.add(pkcs_9_at_friendlyName);
                        aSN1EncodableVector13.add(new DERSet(new DERBMPString(str3)));
                        aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector13));
                    }
                    aSN1EncodableVector6.add(new SafeBag(certBag, certBag2.getDERObject(), new DERSet(aSN1EncodableVector11)));
                    hashtable.put(certificate, certificate);
                    keys4 = enumeration;
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException("Error encoding certificate: " + e2.toString());
            }
        }
        Enumeration keys5 = this.chainCerts.keys();
        while (keys5.hasMoreElements()) {
            try {
                Certificate certificate2 = (Certificate) this.chainCerts.get((CertId) keys5.nextElement());
                if (hashtable.get(certificate2) == null) {
                    CertBag certBag3 = new CertBag(x509Certificate, new DEROctetString(certificate2.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
                    if (certificate2 instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier4 = (PKCS12BagAttributeCarrier) certificate2;
                        Enumeration bagAttributeKeys4 = pKCS12BagAttributeCarrier4.getBagAttributeKeys();
                        while (bagAttributeKeys4.hasMoreElements()) {
                            DERObjectIdentifier dERObjectIdentifier4 = (DERObjectIdentifier) bagAttributeKeys4.nextElement();
                            if (!dERObjectIdentifier4.equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
                                aSN1EncodableVector15.add(dERObjectIdentifier4);
                                aSN1EncodableVector15.add(new DERSet(pKCS12BagAttributeCarrier4.getBagAttribute(dERObjectIdentifier4)));
                                aSN1EncodableVector14.add(new DERSequence(aSN1EncodableVector15));
                            }
                        }
                    }
                    aSN1EncodableVector6.add(new SafeBag(certBag, certBag3.getDERObject(), new DERSet(aSN1EncodableVector14)));
                }
            } catch (CertificateEncodingException e3) {
                throw new IOException("Error encoding certificate: " + e3.toString());
            }
        }
        AuthenticatedSafe authenticatedSafe = new AuthenticatedSafe(new ContentInfo[]{new ContentInfo(data, bERConstructedOctetString), new ContentInfo(encryptedData, new EncryptedData(data, algorithmIdentifier, new BERConstructedOctetString(cryptData(true, algorithmIdentifier, cArr, false, new DERSequence(aSN1EncodableVector6).getDEREncoded()))).getDERObject())});
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        (z ? new DEROutputStream(byteArrayOutputStream) : new BEROutputStream(byteArrayOutputStream)).writeObject(authenticatedSafe);
        ContentInfo contentInfo = new ContentInfo(data, new BERConstructedOctetString(byteArrayOutputStream.toByteArray()));
        byte[] bArr3 = new byte[20];
        this.random.nextBytes(bArr3);
        try {
            (z ? new DEROutputStream(outputStream) : new BEROutputStream(outputStream)).writeObject(new Pfx(contentInfo, new MacData(new DigestInfo(new AlgorithmIdentifier(id_SHA1, new DERNull()), calculatePbeMac(id_SHA1, bArr3, 1024, cArr, false, ((ASN1OctetString) contentInfo.getContent()).getOctets())), bArr3, 1024)));
        } catch (Exception e4) {
            throw new IOException("error constructing MAC: " + e4.toString());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        String id = algorithmIdentifier.getObjectId().getId();
        PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams((ASN1Sequence) algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory instance = SecretKeyFactory.getInstance(id, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            JCEPBEKey jCEPBEKey = (JCEPBEKey) instance.generateSecret(pBEKeySpec);
            jCEPBEKey.setTryWrongPKCS12Zero(z2);
            Cipher instance2 = Cipher.getInstance(id, provider);
            instance2.init(z ? 1 : 2, jCEPBEKey, pBEParameterSpec);
            return instance2.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException("exception decrypting data - " + e.toString());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    public boolean engineContainsAlias(String str) {
        return (this.certs.get(str) == null && this.keys.get(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        Key key = (Key) this.keys.remove(str);
        Certificate certificate = (Certificate) this.certs.remove(str);
        if (certificate != null) {
            this.chainCerts.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.localIds.remove(str);
            if (str2 != null) {
                certificate = (Certificate) this.keyCerts.remove(str2);
            }
            if (certificate != null) {
                this.chainCerts.remove(new CertId(certificate.getPublicKey()));
            }
        }
        if (certificate == null && key == null) {
            throw new KeyStoreException("no such entry as " + str);
        }
    }

    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.certs.get(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.localIds.get(str);
            return (Certificate) (str2 != null ? this.keyCerts.get(str2) : this.keyCerts.get(str));
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.certs.elements();
        Enumeration keys2 = this.certs.keys();
        while (elements.hasMoreElements()) {
            String str = (String) keys2.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.keyCerts.elements();
        Enumeration keys3 = this.keyCerts.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys3.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    public Certificate[] engineGetCertificateChain(String str) {
        X509Certificate x509Certificate;
        if (str != null) {
            Certificate[] certificateArr = null;
            if (!engineIsKeyEntry(str)) {
                return null;
            }
            Certificate engineGetCertificate = engineGetCertificate(str);
            if (engineGetCertificate != null) {
                Vector vector = new Vector();
                while (engineGetCertificate != null) {
                    X509Certificate x509Certificate2 = (X509Certificate) engineGetCertificate;
                    byte[] extensionValue = x509Certificate2.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
                    if (extensionValue != null) {
                        try {
                            AuthorityKeyIdentifier authorityKeyIdentifier = new AuthorityKeyIdentifier((ASN1Sequence) new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(extensionValue).readObject()).getOctets()).readObject());
                            if (authorityKeyIdentifier.getKeyIdentifier() != null) {
                                x509Certificate = (Certificate) this.chainCerts.get(new CertId(authorityKeyIdentifier.getKeyIdentifier()));
                                if (x509Certificate == null) {
                                    Principal issuerDN = x509Certificate2.getIssuerDN();
                                    if (!issuerDN.equals(x509Certificate2.getSubjectDN())) {
                                        Enumeration keys2 = this.chainCerts.keys();
                                        while (true) {
                                            if (!keys2.hasMoreElements()) {
                                                break;
                                            }
                                            X509Certificate x509Certificate3 = (X509Certificate) this.chainCerts.get(keys2.nextElement());
                                            if (x509Certificate3.getSubjectDN().equals(issuerDN)) {
                                                try {
                                                    x509Certificate2.verify(x509Certificate3.getPublicKey());
                                                    x509Certificate = x509Certificate3;
                                                    break;
                                                } catch (Exception unused) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                vector.addElement(engineGetCertificate);
                                engineGetCertificate = x509Certificate == engineGetCertificate ? x509Certificate : null;
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e.toString());
                        }
                    }
                    x509Certificate = null;
                    if (x509Certificate == null) {
                    }
                    vector.addElement(engineGetCertificate);
                    if (x509Certificate == engineGetCertificate) {
                    }
                }
                int size = vector.size();
                certificateArr = new Certificate[size];
                for (int i = 0; i != size; i++) {
                    certificateArr[i] = (Certificate) vector.elementAt(i);
                }
            }
            return certificateArr;
        }
        throw new IllegalArgumentException("null alias passed to getCertificateChain.");
    }

    public Date engineGetCreationDate(String str) {
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    public boolean engineIsCertificateEntry(String str) {
        return this.certs.get(str) != null && this.keys.get(str) == null;
    }

    public boolean engineIsKeyEntry(String str) {
        return this.keys.get(str) != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e7  */
    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
        boolean z;
        boolean z2;
        int i;
        String str;
        ASN1OctetString aSN1OctetString;
        boolean z3;
        int i2;
        ASN1Sequence aSN1Sequence;
        boolean z4;
        DERObject dERObject;
        DERObject dERObject2;
        ASN1OctetString aSN1OctetString2;
        ASN1OctetString aSN1OctetString3;
        DERObject dERObject3;
        if (inputStream != null) {
            Objects.requireNonNull(cArr, "No password supplied for PKCS#12 KeyStore.");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(10);
            if (bufferedInputStream.read() == 48) {
                bufferedInputStream.reset();
                Pfx pfx = new Pfx((ASN1Sequence) new ASN1InputStream(bufferedInputStream).readObject());
                ContentInfo authSafe = pfx.getAuthSafe();
                Vector vector = new Vector();
                int i3 = 1;
                int i4 = 0;
                if (pfx.getMacData() != null) {
                    MacData macData = pfx.getMacData();
                    DigestInfo mac = macData.getMac();
                    AlgorithmIdentifier algorithmId = mac.getAlgorithmId();
                    byte[] salt = macData.getSalt();
                    int intValue = macData.getIterationCount().intValue();
                    byte[] octets = ((ASN1OctetString) authSafe.getContent()).getOctets();
                    try {
                        byte[] calculatePbeMac = calculatePbeMac(algorithmId.getObjectId(), salt, intValue, cArr, false, octets);
                        byte[] digest = mac.getDigest();
                        if (!Arrays.constantTimeAreEqual(calculatePbeMac, digest)) {
                            if (cArr.length > 0) {
                                throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                            } else if (Arrays.constantTimeAreEqual(calculatePbeMac(algorithmId.getObjectId(), salt, intValue, cArr, true, octets), digest)) {
                                z = true;
                                ASN1OctetString aSN1OctetString4 = null;
                                this.keys = new IgnoresCaseHashtable();
                                this.localIds = new Hashtable();
                                if (!authSafe.getContentType().equals(data)) {
                                    ContentInfo[] contentInfo = new AuthenticatedSafe((ASN1Sequence) new ASN1InputStream(((ASN1OctetString) authSafe.getContent()).getOctets()).readObject()).getContentInfo();
                                    int i5 = 0;
                                    z2 = false;
                                    while (i5 != contentInfo.length) {
                                        if (contentInfo[i5].getContentType().equals(data)) {
                                            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) new ASN1InputStream(((ASN1OctetString) contentInfo[i5].getContent()).getOctets()).readObject();
                                            int i6 = i4;
                                            while (i6 != aSN1Sequence2.size()) {
                                                SafeBag safeBag = new SafeBag((ASN1Sequence) aSN1Sequence2.getObjectAt(i6));
                                                if (safeBag.getBagId().equals(pkcs8ShroudedKeyBag)) {
                                                    EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo((ASN1Sequence) safeBag.getBagValue());
                                                    PrivateKey unwrapKey = unwrapKey(encryptedPrivateKeyInfo.getEncryptionAlgorithm(), encryptedPrivateKeyInfo.getEncryptedData(), cArr, z);
                                                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) unwrapKey;
                                                    if (safeBag.getBagAttributes() != null) {
                                                        Enumeration objects = safeBag.getBagAttributes().getObjects();
                                                        String str2 = aSN1OctetString4;
                                                        aSN1OctetString2 = str2;
                                                        while (objects.hasMoreElements()) {
                                                            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) objects.nextElement();
                                                            DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) aSN1Sequence3.getObjectAt(i4);
                                                            ASN1Set aSN1Set = (ASN1Set) aSN1Sequence3.getObjectAt(i3);
                                                            if (aSN1Set.size() > 0) {
                                                                dERObject3 = (DERObject) aSN1Set.getObjectAt(0);
                                                                DEREncodable bagAttribute = pKCS12BagAttributeCarrier.getBagAttribute(dERObjectIdentifier);
                                                                if (bagAttribute == null) {
                                                                    pKCS12BagAttributeCarrier.setBagAttribute(dERObjectIdentifier, dERObject3);
                                                                } else if (!bagAttribute.getDERObject().equals(dERObject3)) {
                                                                    throw new IOException("attempt to add existing attribute with different value");
                                                                }
                                                            } else {
                                                                dERObject3 = null;
                                                            }
                                                            if (dERObjectIdentifier.equals(pkcs_9_at_friendlyName)) {
                                                                String string = ((DERBMPString) dERObject3).getString();
                                                                this.keys.put(string, unwrapKey);
                                                                str2 = string;
                                                            } else if (dERObjectIdentifier.equals(pkcs_9_at_localKeyId)) {
                                                                aSN1OctetString2 = (ASN1OctetString) dERObject3;
                                                            }
                                                            i3 = 1;
                                                            i4 = 0;
                                                        }
                                                        aSN1OctetString3 = str2;
                                                    } else {
                                                        aSN1OctetString3 = null;
                                                        aSN1OctetString2 = null;
                                                    }
                                                    if (aSN1OctetString2 != null) {
                                                        String str3 = new String(Hex.encode(aSN1OctetString2.getOctets()));
                                                        if (aSN1OctetString3 == null) {
                                                            this.keys.put(str3, unwrapKey);
                                                        } else {
                                                            this.localIds.put(aSN1OctetString3, str3);
                                                        }
                                                    } else {
                                                        this.keys.put("unmarked", unwrapKey);
                                                        z2 = true;
                                                    }
                                                } else if (safeBag.getBagId().equals(certBag)) {
                                                    vector.addElement(safeBag);
                                                } else {
                                                    System.out.println("extra in data " + safeBag.getBagId());
                                                    System.out.println(ASN1Dump.dumpAsString(safeBag));
                                                }
                                                i6++;
                                                i3 = 1;
                                                i4 = 0;
                                                aSN1OctetString4 = null;
                                            }
                                            z3 = z;
                                            i2 = i5;
                                        } else if (contentInfo[i5].getContentType().equals(encryptedData)) {
                                            EncryptedData encryptedData = new EncryptedData((ASN1Sequence) contentInfo[i5].getContent());
                                            i2 = i5;
                                            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) ASN1Object.fromByteArray(cryptData(false, encryptedData.getEncryptionAlgorithm(), cArr, z, encryptedData.getContent().getOctets()));
                                            int i7 = 0;
                                            while (i7 != aSN1Sequence4.size()) {
                                                SafeBag safeBag2 = new SafeBag((ASN1Sequence) aSN1Sequence4.getObjectAt(i7));
                                                if (safeBag2.getBagId().equals(certBag)) {
                                                    vector.addElement(safeBag2);
                                                    z4 = z;
                                                    aSN1Sequence = aSN1Sequence4;
                                                } else if (safeBag2.getBagId().equals(pkcs8ShroudedKeyBag)) {
                                                    EncryptedPrivateKeyInfo encryptedPrivateKeyInfo2 = new EncryptedPrivateKeyInfo((ASN1Sequence) safeBag2.getBagValue());
                                                    PrivateKey unwrapKey2 = unwrapKey(encryptedPrivateKeyInfo2.getEncryptionAlgorithm(), encryptedPrivateKeyInfo2.getEncryptedData(), cArr, z);
                                                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) unwrapKey2;
                                                    Enumeration objects2 = safeBag2.getBagAttributes().getObjects();
                                                    ASN1OctetString aSN1OctetString5 = null;
                                                    String str4 = null;
                                                    while (objects2.hasMoreElements()) {
                                                        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) objects2.nextElement();
                                                        DERObjectIdentifier dERObjectIdentifier2 = (DERObjectIdentifier) aSN1Sequence5.getObjectAt(0);
                                                        ASN1Set aSN1Set2 = (ASN1Set) aSN1Sequence5.getObjectAt(1);
                                                        if (aSN1Set2.size() > 0) {
                                                            dERObject2 = (DERObject) aSN1Set2.getObjectAt(0);
                                                            DEREncodable bagAttribute2 = pKCS12BagAttributeCarrier2.getBagAttribute(dERObjectIdentifier2);
                                                            if (bagAttribute2 == null) {
                                                                pKCS12BagAttributeCarrier2.setBagAttribute(dERObjectIdentifier2, dERObject2);
                                                            } else if (!bagAttribute2.getDERObject().equals(dERObject2)) {
                                                                throw new IOException("attempt to add existing attribute with different value");
                                                            }
                                                        } else {
                                                            dERObject2 = null;
                                                        }
                                                        if (dERObjectIdentifier2.equals(pkcs_9_at_friendlyName)) {
                                                            str4 = ((DERBMPString) dERObject2).getString();
                                                            this.keys.put(str4, unwrapKey2);
                                                        } else if (dERObjectIdentifier2.equals(pkcs_9_at_localKeyId)) {
                                                            aSN1OctetString5 = (ASN1OctetString) dERObject2;
                                                        }
                                                        z = z;
                                                        aSN1Sequence4 = aSN1Sequence4;
                                                    }
                                                    z4 = z;
                                                    aSN1Sequence = aSN1Sequence4;
                                                    String str5 = new String(Hex.encode(aSN1OctetString5.getOctets()));
                                                    if (str4 == null) {
                                                        this.keys.put(str5, unwrapKey2);
                                                    } else {
                                                        this.localIds.put(str4, str5);
                                                    }
                                                } else {
                                                    z4 = z;
                                                    aSN1Sequence = aSN1Sequence4;
                                                    if (safeBag2.getBagId().equals(keyBag)) {
                                                        PrivateKey createPrivateKeyFromPrivateKeyInfo = JDKKeyFactory.createPrivateKeyFromPrivateKeyInfo(new PrivateKeyInfo((ASN1Sequence) safeBag2.getBagValue()));
                                                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) createPrivateKeyFromPrivateKeyInfo;
                                                        Enumeration objects3 = safeBag2.getBagAttributes().getObjects();
                                                        ASN1OctetString aSN1OctetString6 = null;
                                                        String str6 = null;
                                                        while (objects3.hasMoreElements()) {
                                                            ASN1Sequence aSN1Sequence6 = (ASN1Sequence) objects3.nextElement();
                                                            DERObjectIdentifier dERObjectIdentifier3 = (DERObjectIdentifier) aSN1Sequence6.getObjectAt(0);
                                                            ASN1Set aSN1Set3 = (ASN1Set) aSN1Sequence6.getObjectAt(1);
                                                            if (aSN1Set3.size() > 0) {
                                                                dERObject = (DERObject) aSN1Set3.getObjectAt(0);
                                                                DEREncodable bagAttribute3 = pKCS12BagAttributeCarrier3.getBagAttribute(dERObjectIdentifier3);
                                                                if (bagAttribute3 == null) {
                                                                    pKCS12BagAttributeCarrier3.setBagAttribute(dERObjectIdentifier3, dERObject);
                                                                } else if (!bagAttribute3.getDERObject().equals(dERObject)) {
                                                                    throw new IOException("attempt to add existing attribute with different value");
                                                                }
                                                            } else {
                                                                dERObject = null;
                                                            }
                                                            if (dERObjectIdentifier3.equals(pkcs_9_at_friendlyName)) {
                                                                str6 = ((DERBMPString) dERObject).getString();
                                                                this.keys.put(str6, createPrivateKeyFromPrivateKeyInfo);
                                                            } else if (dERObjectIdentifier3.equals(pkcs_9_at_localKeyId)) {
                                                                aSN1OctetString6 = (ASN1OctetString) dERObject;
                                                            }
                                                        }
                                                        String str7 = new String(Hex.encode(aSN1OctetString6.getOctets()));
                                                        if (str6 == null) {
                                                            this.keys.put(str7, createPrivateKeyFromPrivateKeyInfo);
                                                        } else {
                                                            this.localIds.put(str6, str7);
                                                        }
                                                    } else {
                                                        System.out.println("extra in encryptedData " + safeBag2.getBagId());
                                                        System.out.println(ASN1Dump.dumpAsString(safeBag2));
                                                    }
                                                }
                                                i7++;
                                                z = z4;
                                                aSN1Sequence4 = aSN1Sequence;
                                            }
                                            z3 = z;
                                        } else {
                                            z3 = z;
                                            i2 = i5;
                                            System.out.println("extra " + contentInfo[i2].getContentType().getId());
                                            System.out.println("extra " + ASN1Dump.dumpAsString(contentInfo[i2].getContent()));
                                        }
                                        i5 = i2 + 1;
                                        z = z3;
                                        i3 = 1;
                                        i4 = 0;
                                        aSN1OctetString4 = null;
                                    }
                                } else {
                                    z2 = false;
                                }
                                this.certs = new IgnoresCaseHashtable();
                                this.chainCerts = new Hashtable();
                                this.keyCerts = new Hashtable();
                                for (i = 0; i != vector.size(); i++) {
                                    SafeBag safeBag3 = (SafeBag) vector.elementAt(i);
                                    CertBag certBag = new CertBag((ASN1Sequence) safeBag3.getBagValue());
                                    if (certBag.getCertId().equals(x509Certificate)) {
                                        try {
                                            Certificate generateCertificate = this.certFact.generateCertificate(new ByteArrayInputStream(((ASN1OctetString) certBag.getCertValue()).getOctets()));
                                            if (safeBag3.getBagAttributes() != null) {
                                                Enumeration objects4 = safeBag3.getBagAttributes().getObjects();
                                                aSN1OctetString = null;
                                                str = null;
                                                while (objects4.hasMoreElements()) {
                                                    ASN1Sequence aSN1Sequence7 = (ASN1Sequence) objects4.nextElement();
                                                    DERObjectIdentifier dERObjectIdentifier4 = (DERObjectIdentifier) aSN1Sequence7.getObjectAt(0);
                                                    DERObject dERObject4 = (DERObject) ((ASN1Set) aSN1Sequence7.getObjectAt(1)).getObjectAt(0);
                                                    if (generateCertificate instanceof PKCS12BagAttributeCarrier) {
                                                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier4 = (PKCS12BagAttributeCarrier) generateCertificate;
                                                        DEREncodable bagAttribute4 = pKCS12BagAttributeCarrier4.getBagAttribute(dERObjectIdentifier4);
                                                        if (bagAttribute4 == null) {
                                                            pKCS12BagAttributeCarrier4.setBagAttribute(dERObjectIdentifier4, dERObject4);
                                                        } else if (!bagAttribute4.getDERObject().equals(dERObject4)) {
                                                            throw new IOException("attempt to add existing attribute with different value");
                                                        }
                                                    }
                                                    if (dERObjectIdentifier4.equals(pkcs_9_at_friendlyName)) {
                                                        str = ((DERBMPString) dERObject4).getString();
                                                    } else if (dERObjectIdentifier4.equals(pkcs_9_at_localKeyId)) {
                                                        aSN1OctetString = (ASN1OctetString) dERObject4;
                                                    }
                                                }
                                            } else {
                                                aSN1OctetString = null;
                                                str = null;
                                            }
                                            this.chainCerts.put(new CertId(generateCertificate.getPublicKey()), generateCertificate);
                                            if (!z2) {
                                                if (aSN1OctetString != null) {
                                                    this.keyCerts.put(new String(Hex.encode(aSN1OctetString.getOctets())), generateCertificate);
                                                }
                                                if (str != null) {
                                                    this.certs.put(str, generateCertificate);
                                                }
                                            } else if (this.keyCerts.isEmpty()) {
                                                String str8 = new String(Hex.encode(createSubjectKeyId(generateCertificate.getPublicKey()).getKeyIdentifier()));
                                                this.keyCerts.put(str8, generateCertificate);
                                                IgnoresCaseHashtable ignoresCaseHashtable = this.keys;
                                                ignoresCaseHashtable.put(str8, ignoresCaseHashtable.remove("unmarked"));
                                            }
                                        } catch (Exception e) {
                                            throw new RuntimeException(e.toString());
                                        }
                                    } else {
                                        throw new RuntimeException("Unsupported certificate type: " + certBag.getCertId());
                                    }
                                }
                                return;
                            } else {
                                throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
                            }
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new IOException("error constructing MAC: " + e3.toString());
                    }
                }
                z = false;
                ASN1OctetString aSN1OctetString42 = null;
                this.keys = new IgnoresCaseHashtable();
                this.localIds = new Hashtable();
                if (!authSafe.getContentType().equals(data)) {
                }
                this.certs = new IgnoresCaseHashtable();
                this.chainCerts = new Hashtable();
                this.keyCerts = new Hashtable();
                while (i != vector.size()) {
                }
                return;
            }
            throw new IOException("stream does not represent a PKCS12 key store");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.keys.get(str) == null) {
            this.certs.put(str, certificate);
            this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException("There is a key entry with the name " + str + ".");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (!(key instanceof PrivateKey) || certificateArr != null) {
            if (this.keys.get(str) != null) {
                engineDeleteEntry(str);
            }
            this.keys.put(str, key);
            this.certs.put(str, certificateArr[0]);
            for (int i = 0; i != certificateArr.length; i++) {
                this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
            }
            return;
        }
        throw new KeyStoreException("no certificate chain for private key");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys2 = this.certs.keys();
        while (keys2.hasMoreElements()) {
            hashtable.put(keys2.nextElement(), "cert");
        }
        Enumeration keys3 = this.keys.keys();
        while (keys3.hasMoreElements()) {
            String str = (String) keys3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        doStore(outputStream, cArr, false);
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        char[] cArr;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        } else if (loadStoreParameter instanceof JDKPKCS12StoreParameter) {
            JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
            KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
            if (protectionParameter == null) {
                cArr = null;
            } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
                cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
            } else {
                throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
            }
            doStore(jDKPKCS12StoreParameter.getOutputStream(), cArr, jDKPKCS12StoreParameter.isUseDEREncoding());
        } else {
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
    }

    @Override // org.bouncycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    /* access modifiers changed from: protected */
    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws IOException {
        String id = algorithmIdentifier.getObjectId().getId();
        PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams((ASN1Sequence) algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory instance = SecretKeyFactory.getInstance(id, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            SecretKey generateSecret = instance.generateSecret(pBEKeySpec);
            ((JCEPBEKey) generateSecret).setTryWrongPKCS12Zero(z);
            Cipher instance2 = Cipher.getInstance(id, provider);
            instance2.init(4, generateSecret, pBEParameterSpec);
            return (PrivateKey) instance2.unwrap(bArr, "", 2);
        } catch (Exception e) {
            throw new IOException("exception unwrapping private key - " + e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws IOException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory instance = SecretKeyFactory.getInstance(str, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher instance2 = Cipher.getInstance(str, provider);
            instance2.init(3, instance.generateSecret(pBEKeySpec), pBEParameterSpec);
            return instance2.wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }
}
