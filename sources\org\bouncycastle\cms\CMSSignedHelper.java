package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.x509.NoSuchStoreException;
import org.bouncycastle.x509.X509CollectionStoreParameters;
import org.bouncycastle.x509.X509Store;
import org.bouncycastle.x509.X509V2AttributeCertificate;

class CMSSignedHelper {
    static final CMSSignedHelper INSTANCE = new CMSSignedHelper();
    private static final Map digestAlgs;
    private static final Map digestAliases;
    private static final Map encryptionAlgs;

    static {
        HashMap hashMap = new HashMap();
        encryptionAlgs = hashMap;
        HashMap hashMap2 = new HashMap();
        digestAlgs = hashMap2;
        HashMap hashMap3 = new HashMap();
        digestAliases = hashMap3;
        addEntries(NISTObjectIdentifiers.dsa_with_sha224, "SHA224", "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha256, "SHA256", "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha384, "SHA384", "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha512, "SHA512", "DSA");
        addEntries(OIWObjectIdentifiers.dsaWithSHA1, "SHA1", "DSA");
        addEntries(OIWObjectIdentifiers.md4WithRSA, "MD4", "RSA");
        addEntries(OIWObjectIdentifiers.md4WithRSAEncryption, "MD4", "RSA");
        addEntries(OIWObjectIdentifiers.md5WithRSA, "MD5", "RSA");
        addEntries(OIWObjectIdentifiers.sha1WithRSA, "SHA1", "RSA");
        addEntries(PKCSObjectIdentifiers.md2WithRSAEncryption, "MD2", "RSA");
        addEntries(PKCSObjectIdentifiers.md4WithRSAEncryption, "MD4", "RSA");
        addEntries(PKCSObjectIdentifiers.md5WithRSAEncryption, "MD5", "RSA");
        addEntries(PKCSObjectIdentifiers.sha1WithRSAEncryption, "SHA1", "RSA");
        addEntries(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224", "RSA");
        addEntries(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256", "RSA");
        addEntries(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384", "RSA");
        addEntries(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512", "RSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512", "ECDSA");
        addEntries(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1", "DSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1, "SHA1", "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256, "SHA256", "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1, "SHA1", "RSAandMGF1");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256, "SHA256", "RSAandMGF1");
        hashMap.put(X9ObjectIdentifiers.id_dsa.getId(), "DSA");
        hashMap.put(PKCSObjectIdentifiers.rsaEncryption.getId(), "RSA");
        hashMap.put(TeleTrusTObjectIdentifiers.teleTrusTRSAsignatureAlgorithm, "RSA");
        hashMap.put(X509ObjectIdentifiers.id_ea_rsa.getId(), "RSA");
        hashMap.put(CMSSignedDataGenerator.ENCRYPTION_RSA_PSS, "RSAandMGF1");
        hashMap.put(CryptoProObjectIdentifiers.gostR3410_94.getId(), "GOST3410");
        hashMap.put(CryptoProObjectIdentifiers.gostR3410_2001.getId(), "ECGOST3410");
        hashMap.put("1.3.6.1.4.1.5849.1.6.2", "ECGOST3410");
        hashMap.put("1.3.6.1.4.1.5849.1.1.5", "GOST3410");
        hashMap.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001.getId(), "ECGOST3410");
        hashMap.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94.getId(), "GOST3410");
        hashMap2.put(PKCSObjectIdentifiers.md2.getId(), "MD2");
        hashMap2.put(PKCSObjectIdentifiers.md4.getId(), "MD4");
        hashMap2.put(PKCSObjectIdentifiers.md5.getId(), "MD5");
        hashMap2.put(OIWObjectIdentifiers.idSHA1.getId(), "SHA1");
        hashMap2.put(NISTObjectIdentifiers.id_sha224.getId(), "SHA224");
        hashMap2.put(NISTObjectIdentifiers.id_sha256.getId(), "SHA256");
        hashMap2.put(NISTObjectIdentifiers.id_sha384.getId(), "SHA384");
        hashMap2.put(NISTObjectIdentifiers.id_sha512.getId(), "SHA512");
        hashMap2.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), "RIPEMD128");
        hashMap2.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), "RIPEMD160");
        hashMap2.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), "RIPEMD256");
        hashMap2.put(CryptoProObjectIdentifiers.gostR3411.getId(), "GOST3411");
        hashMap2.put("1.3.6.1.4.1.5849.1.2.1", "GOST3411");
        hashMap3.put("SHA1", new String[]{"SHA-1"});
        hashMap3.put("SHA224", new String[]{"SHA-224"});
        hashMap3.put("SHA256", new String[]{"SHA-256"});
        hashMap3.put("SHA384", new String[]{"SHA-384"});
        hashMap3.put("SHA512", new String[]{"SHA-512"});
    }

    CMSSignedHelper() {
    }

    private void addCRLsFromSet(List list, ASN1Set aSN1Set, Provider provider) throws CMSException {
        CertificateFactory certificateFactory;
        if (provider != null) {
            try {
                certificateFactory = CertificateFactory.getInstance("X.509", provider);
            } catch (CertificateException e) {
                throw new CMSException("can't get certificate factory.", e);
            }
        } else {
            certificateFactory = CertificateFactory.getInstance("X.509");
        }
        Enumeration objects = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            try {
                list.add(certificateFactory.generateCRL(new ByteArrayInputStream(((DEREncodable) objects.nextElement()).getDERObject().getEncoded())));
            } catch (IOException e2) {
                throw new CMSException("can't re-encode CRL!", e2);
            } catch (CRLException e3) {
                throw new CMSException("can't re-encode CRL!", e3);
            }
        }
    }

    private void addCertsFromSet(List list, ASN1Set aSN1Set, Provider provider) throws CMSException {
        CertificateFactory certificateFactory;
        if (provider != null) {
            try {
                certificateFactory = CertificateFactory.getInstance("X.509", provider);
            } catch (CertificateException e) {
                throw new CMSException("can't get certificate factory.", e);
            }
        } else {
            certificateFactory = CertificateFactory.getInstance("X.509");
        }
        Enumeration objects = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            try {
                DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
                if (dERObject instanceof ASN1Sequence) {
                    list.add(certificateFactory.generateCertificate(new ByteArrayInputStream(dERObject.getEncoded())));
                }
            } catch (IOException e2) {
                throw new CMSException("can't re-encode certificate!", e2);
            } catch (CertificateException e3) {
                throw new CMSException("can't re-encode certificate!", e3);
            }
        }
    }

    private static void addEntries(DERObjectIdentifier dERObjectIdentifier, String str, String str2) {
        digestAlgs.put(dERObjectIdentifier.getId(), str);
        encryptionAlgs.put(dERObjectIdentifier.getId(), str2);
    }

    private MessageDigest createDigestInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        return provider != null ? MessageDigest.getInstance(str, provider) : MessageDigest.getInstance(str);
    }

    /* access modifiers changed from: package-private */
    public X509Store createAttributeStore(String str, Provider provider, ASN1Set aSN1Set) throws NoSuchStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        if (aSN1Set != null) {
            Enumeration objects = aSN1Set.getObjects();
            while (objects.hasMoreElements()) {
                try {
                    DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
                    if (dERObject instanceof ASN1TaggedObject) {
                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) dERObject;
                        if (aSN1TaggedObject.getTagNo() == 2) {
                            arrayList.add(new X509V2AttributeCertificate(ASN1Sequence.getInstance(aSN1TaggedObject, false).getEncoded()));
                        }
                    }
                } catch (IOException e) {
                    throw new CMSException("can't re-encode attribute certificate!", e);
                }
            }
        }
        try {
            return X509Store.getInstance("AttributeCertificate/" + str, new X509CollectionStoreParameters(arrayList), provider);
        } catch (IllegalArgumentException e2) {
            throw new CMSException("can't setup the X509Store", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public X509Store createCRLsStore(String str, Provider provider, ASN1Set aSN1Set) throws NoSuchStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        if (aSN1Set != null) {
            addCRLsFromSet(arrayList, aSN1Set, provider);
        }
        try {
            return X509Store.getInstance("CRL/" + str, new X509CollectionStoreParameters(arrayList), provider);
        } catch (IllegalArgumentException e) {
            throw new CMSException("can't setup the X509Store", e);
        }
    }

    /* access modifiers changed from: package-private */
    public CertStore createCertStore(String str, Provider provider, ASN1Set aSN1Set, ASN1Set aSN1Set2) throws CMSException, NoSuchAlgorithmException {
        ArrayList arrayList = new ArrayList();
        if (aSN1Set != null) {
            addCertsFromSet(arrayList, aSN1Set, provider);
        }
        if (aSN1Set2 != null) {
            addCRLsFromSet(arrayList, aSN1Set2, provider);
        }
        if (provider == null) {
            return CertStore.getInstance(str, new CollectionCertStoreParameters(arrayList));
        }
        try {
            return CertStore.getInstance(str, new CollectionCertStoreParameters(arrayList), provider);
        } catch (InvalidAlgorithmParameterException e) {
            throw new CMSException("can't setup the CertStore", e);
        }
    }

    /* access modifiers changed from: package-private */
    public X509Store createCertificateStore(String str, Provider provider, ASN1Set aSN1Set) throws NoSuchStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        if (aSN1Set != null) {
            addCertsFromSet(arrayList, aSN1Set, provider);
        }
        try {
            return X509Store.getInstance("Certificate/" + str, new X509CollectionStoreParameters(arrayList), provider);
        } catch (IllegalArgumentException e) {
            throw new CMSException("can't setup the X509Store", e);
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmIdentifier fixAlgID(AlgorithmIdentifier algorithmIdentifier) {
        return algorithmIdentifier.getParameters() == null ? new AlgorithmIdentifier(algorithmIdentifier.getObjectId(), DERNull.INSTANCE) : algorithmIdentifier;
    }

    /* access modifiers changed from: package-private */
    public String getDigestAlgName(String str) {
        String str2 = (String) digestAlgs.get(str);
        return str2 != null ? str2 : str;
    }

    /* access modifiers changed from: package-private */
    public String[] getDigestAliases(String str) {
        String[] strArr = (String[]) digestAliases.get(str);
        return strArr != null ? strArr : new String[0];
    }

    /* access modifiers changed from: package-private */
    public MessageDigest getDigestInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createDigestInstance(str, provider);
        } catch (NoSuchAlgorithmException e) {
            String[] digestAliases2 = getDigestAliases(str);
            for (int i = 0; i != digestAliases2.length; i++) {
                try {
                    return createDigestInstance(digestAliases2[i], provider);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            if (provider != null) {
                return getDigestInstance(str, null);
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public String getEncryptionAlgName(String str) {
        String str2 = (String) encryptionAlgs.get(str);
        return str2 != null ? str2 : str;
    }

    /* access modifiers changed from: package-private */
    public Signature getSignatureInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        return provider != null ? Signature.getInstance(str, provider) : Signature.getInstance(str);
    }

    /* access modifiers changed from: package-private */
    public void setSigningDigestAlgorithmMapping(DERObjectIdentifier dERObjectIdentifier, String str) {
        digestAlgs.put(dERObjectIdentifier.getId(), str);
    }

    /* access modifiers changed from: package-private */
    public void setSigningEncryptionAlgorithmMapping(DERObjectIdentifier dERObjectIdentifier, String str) {
        encryptionAlgs.put(dERObjectIdentifier.getId(), str);
    }
}
