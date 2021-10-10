package org.bouncycastle.cms;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.util.Store;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509Store;

public class CMSSignedGenerator {
    public static final String DATA = CMSObjectIdentifiers.data.getId();
    public static final String DIGEST_GOST3411 = CryptoProObjectIdentifiers.gostR3411.getId();
    public static final String DIGEST_MD5 = PKCSObjectIdentifiers.md5.getId();
    public static final String DIGEST_RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.getId();
    public static final String DIGEST_RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.getId();
    public static final String DIGEST_RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.getId();
    public static final String DIGEST_SHA1;
    public static final String DIGEST_SHA224;
    public static final String DIGEST_SHA256;
    public static final String DIGEST_SHA384;
    public static final String DIGEST_SHA512;
    private static final Map EC_ALGORITHMS;
    public static final String ENCRYPTION_DSA;
    public static final String ENCRYPTION_ECDSA;
    private static final String ENCRYPTION_ECDSA_WITH_SHA1;
    private static final String ENCRYPTION_ECDSA_WITH_SHA224;
    private static final String ENCRYPTION_ECDSA_WITH_SHA256;
    private static final String ENCRYPTION_ECDSA_WITH_SHA384;
    private static final String ENCRYPTION_ECDSA_WITH_SHA512;
    public static final String ENCRYPTION_ECGOST3410 = CryptoProObjectIdentifiers.gostR3410_2001.getId();
    public static final String ENCRYPTION_GOST3410 = CryptoProObjectIdentifiers.gostR3410_94.getId();
    public static final String ENCRYPTION_RSA = PKCSObjectIdentifiers.rsaEncryption.getId();
    public static final String ENCRYPTION_RSA_PSS = PKCSObjectIdentifiers.id_RSASSA_PSS.getId();
    private static final Set NO_PARAMS;
    protected List _signers;
    protected List certs;
    protected List crls;
    protected Map digests;
    protected final SecureRandom rand;
    protected List signerGens;

    static {
        String id = OIWObjectIdentifiers.idSHA1.getId();
        DIGEST_SHA1 = id;
        String id2 = NISTObjectIdentifiers.id_sha224.getId();
        DIGEST_SHA224 = id2;
        String id3 = NISTObjectIdentifiers.id_sha256.getId();
        DIGEST_SHA256 = id3;
        String id4 = NISTObjectIdentifiers.id_sha384.getId();
        DIGEST_SHA384 = id4;
        String id5 = NISTObjectIdentifiers.id_sha512.getId();
        DIGEST_SHA512 = id5;
        String id6 = X9ObjectIdentifiers.id_dsa_with_sha1.getId();
        ENCRYPTION_DSA = id6;
        String id7 = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
        ENCRYPTION_ECDSA = id7;
        String id8 = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
        ENCRYPTION_ECDSA_WITH_SHA1 = id8;
        String id9 = X9ObjectIdentifiers.ecdsa_with_SHA224.getId();
        ENCRYPTION_ECDSA_WITH_SHA224 = id9;
        String id10 = X9ObjectIdentifiers.ecdsa_with_SHA256.getId();
        ENCRYPTION_ECDSA_WITH_SHA256 = id10;
        String id11 = X9ObjectIdentifiers.ecdsa_with_SHA384.getId();
        ENCRYPTION_ECDSA_WITH_SHA384 = id11;
        String id12 = X9ObjectIdentifiers.ecdsa_with_SHA512.getId();
        ENCRYPTION_ECDSA_WITH_SHA512 = id12;
        HashSet hashSet = new HashSet();
        NO_PARAMS = hashSet;
        HashMap hashMap = new HashMap();
        EC_ALGORITHMS = hashMap;
        hashSet.add(id6);
        hashSet.add(id7);
        hashSet.add(id8);
        hashSet.add(id9);
        hashSet.add(id10);
        hashSet.add(id11);
        hashSet.add(id12);
        hashMap.put(id, id8);
        hashMap.put(id2, id9);
        hashMap.put(id3, id10);
        hashMap.put(id4, id11);
        hashMap.put(id5, id12);
    }

    protected CMSSignedGenerator() {
        this(new SecureRandom());
    }

    protected CMSSignedGenerator(SecureRandom secureRandom) {
        this.certs = new ArrayList();
        this.crls = new ArrayList();
        this._signers = new ArrayList();
        this.signerGens = new ArrayList();
        this.digests = new HashMap();
        this.rand = secureRandom;
    }

    static SignerIdentifier getSignerIdentifier(X509Certificate x509Certificate) {
        return new SignerIdentifier(CMSUtils.getIssuerAndSerialNumber(x509Certificate));
    }

    static SignerIdentifier getSignerIdentifier(byte[] bArr) {
        return new SignerIdentifier((ASN1OctetString) new DEROctetString(bArr));
    }

    public void addAttributeCertificates(Store store) throws CMSException {
        this.certs.addAll(CMSUtils.getAttributeCertificatesFromStore(store));
    }

    public void addAttributeCertificates(X509Store x509Store) throws CMSException {
        try {
            for (X509AttributeCertificate x509AttributeCertificate : x509Store.getMatches(null)) {
                this.certs.add(new DERTaggedObject(false, 2, AttributeCertificate.getInstance(ASN1Object.fromByteArray(x509AttributeCertificate.getEncoded()))));
            }
        } catch (IllegalArgumentException e) {
            throw new CMSException("error processing attribute certs", e);
        } catch (IOException e2) {
            throw new CMSException("error processing attribute certs", e2);
        }
    }

    public void addCRLs(Store store) throws CMSException {
        this.crls.addAll(CMSUtils.getCRLsFromStore(store));
    }

    public void addCertificates(Store store) throws CMSException {
        this.certs.addAll(CMSUtils.getCertificatesFromStore(store));
    }

    public void addCertificatesAndCRLs(CertStore certStore) throws CertStoreException, CMSException {
        this.certs.addAll(CMSUtils.getCertificatesFromStore(certStore));
        this.crls.addAll(CMSUtils.getCRLsFromStore(certStore));
    }

    public void addSignerInfoGenerator(SignerInfoGenerator signerInfoGenerator) {
        this.signerGens.add(signerInfoGenerator);
    }

    public void addSigners(SignerInformationStore signerInformationStore) {
        for (Object obj : signerInformationStore.getSigners()) {
            this._signers.add(obj);
        }
    }

    /* access modifiers changed from: protected */
    public ASN1Set getAttributeSet(AttributeTable attributeTable) {
        if (attributeTable != null) {
            return new DERSet(attributeTable.toASN1EncodableVector());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Map getBaseParameters(DERObjectIdentifier dERObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(CMSAttributeTableGenerator.CONTENT_TYPE, dERObjectIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER, algorithmIdentifier);
        hashMap.put(CMSAttributeTableGenerator.DIGEST, bArr.clone());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public AlgorithmIdentifier getEncAlgorithmIdentifier(String str, Signature signature) throws IOException {
        if (NO_PARAMS.contains(str)) {
            return new AlgorithmIdentifier(new DERObjectIdentifier(str));
        }
        if (!str.equals(ENCRYPTION_RSA_PSS)) {
            return new AlgorithmIdentifier(new DERObjectIdentifier(str), new DERNull());
        }
        return new AlgorithmIdentifier(new DERObjectIdentifier(str), ASN1Object.fromByteArray(signature.getParameters().getEncoded()));
    }

    /* access modifiers changed from: protected */
    public String getEncOID(PrivateKey privateKey, String str) {
        if ((privateKey instanceof RSAPrivateKey) || "RSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            return ENCRYPTION_RSA;
        }
        if ((privateKey instanceof DSAPrivateKey) || "DSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
            String str2 = ENCRYPTION_DSA;
            if (str.equals(DIGEST_SHA1)) {
                return str2;
            }
            throw new IllegalArgumentException("can't mix DSA with anything but SHA1");
        } else if ("ECDSA".equalsIgnoreCase(privateKey.getAlgorithm()) || "EC".equalsIgnoreCase(privateKey.getAlgorithm())) {
            String str3 = (String) EC_ALGORITHMS.get(str);
            if (str3 != null) {
                return str3;
            }
            throw new IllegalArgumentException("can't mix ECDSA with anything but SHA family digests");
        } else if ((privateKey instanceof GOST3410PrivateKey) || "GOST3410".equalsIgnoreCase(privateKey.getAlgorithm())) {
            return ENCRYPTION_GOST3410;
        } else {
            if ("ECGOST3410".equalsIgnoreCase(privateKey.getAlgorithm())) {
                return ENCRYPTION_ECGOST3410;
            }
            return null;
        }
    }

    public Map getGeneratedDigests() {
        return new HashMap(this.digests);
    }
}
