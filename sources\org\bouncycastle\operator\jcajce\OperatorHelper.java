package org.bouncycastle.operator.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.jcajce.JcaJceHelper;
import org.bouncycastle.operator.OperatorCreationException;

/* access modifiers changed from: package-private */
public class OperatorHelper {
    private static final Map asymmetricWrapperAlgNames;
    private static final Map oids;
    private static final Map symmetricWrapperAlgNames;
    private JcaJceHelper helper;

    /* access modifiers changed from: private */
    public static class OpCertificateException extends CertificateException {
        private Throwable cause;

        public OpCertificateException(String str, Throwable th) {
            super(str);
            this.cause = th;
        }

        public Throwable getCause() {
            return this.cause;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        oids = hashMap;
        HashMap hashMap2 = new HashMap();
        asymmetricWrapperAlgNames = hashMap2;
        HashMap hashMap3 = new HashMap();
        symmetricWrapperAlgNames = hashMap3;
        hashMap.put(new DERObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        hashMap.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        hashMap.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        hashMap.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        hashMap.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        hashMap.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        hashMap.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        hashMap.put(new DERObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        hashMap.put(new DERObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        hashMap.put(new DERObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        hashMap.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        hashMap.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        hashMap.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        hashMap.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        hashMap.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        hashMap.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        hashMap.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        hashMap.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        hashMap.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        hashMap2.put(new ASN1ObjectIdentifier(PKCSObjectIdentifiers.rsaEncryption.getId()), "RSA/ECB/PKCS1Padding");
        hashMap3.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, "DESEDEWrap");
        hashMap3.put(NISTObjectIdentifiers.id_aes128_wrap, "AESWrap");
        hashMap3.put(NISTObjectIdentifiers.id_aes192_wrap, "AESWrap");
        hashMap3.put(NISTObjectIdentifiers.id_aes256_wrap, "AESWrap");
        hashMap3.put(NTTObjectIdentifiers.id_camellia128_wrap, "CamilliaWrap");
        hashMap3.put(NTTObjectIdentifiers.id_camellia192_wrap, "CamilliaWrap");
        hashMap3.put(NTTObjectIdentifiers.id_camellia256_wrap, "CamilliaWrap");
        hashMap3.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap, "SEEDWrap");
    }

    OperatorHelper(JcaJceHelper jcaJceHelper) {
        this.helper = jcaJceHelper;
    }

    private static String getDigestAlgName(DERObjectIdentifier dERObjectIdentifier) {
        return PKCSObjectIdentifiers.md5.equals(dERObjectIdentifier) ? "MD5" : OIWObjectIdentifiers.idSHA1.equals(dERObjectIdentifier) ? "SHA1" : NISTObjectIdentifiers.id_sha224.equals(dERObjectIdentifier) ? "SHA224" : NISTObjectIdentifiers.id_sha256.equals(dERObjectIdentifier) ? "SHA256" : NISTObjectIdentifiers.id_sha384.equals(dERObjectIdentifier) ? "SHA384" : NISTObjectIdentifiers.id_sha512.equals(dERObjectIdentifier) ? "SHA512" : TeleTrusTObjectIdentifiers.ripemd128.equals(dERObjectIdentifier) ? "RIPEMD128" : TeleTrusTObjectIdentifiers.ripemd160.equals(dERObjectIdentifier) ? "RIPEMD160" : TeleTrusTObjectIdentifiers.ripemd256.equals(dERObjectIdentifier) ? "RIPEMD256" : CryptoProObjectIdentifiers.gostR3411.equals(dERObjectIdentifier) ? "GOST3411" : dERObjectIdentifier.getId();
    }

    private static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        DEREncodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || DERNull.INSTANCE.equals(parameters) || !algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            Map map = oids;
            boolean containsKey = map.containsKey(algorithmIdentifier.getAlgorithm());
            ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
            return containsKey ? (String) map.get(algorithm) : algorithm.getId();
        }
        RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
        return getDigestAlgName(instance.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    }

    public X509Certificate convertCertificate(X509CertificateHolder x509CertificateHolder) throws CertificateException {
        try {
            return (X509Certificate) this.helper.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e) {
            throw new OpCertificateException("cannot get encoded form of certificate: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new OpCertificateException("cannot create certificate factory: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new OpCertificateException("cannot find factory provider: " + e3.getMessage(), e3);
        }
    }

    /* access modifiers changed from: package-private */
    public Cipher createAsymmetricWrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws OperatorCreationException {
        try {
            String str = (String) asymmetricWrapperAlgNames.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.helper.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.helper.createCipher(aSN1ObjectIdentifier.getId());
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public MessageDigest createDigest(AlgorithmIdentifier algorithmIdentifier) throws GeneralSecurityException {
        try {
            return this.helper.createDigest(getSignatureName(algorithmIdentifier));
        } catch (NoSuchAlgorithmException e) {
            Map map = oids;
            if (map.get(algorithmIdentifier.getAlgorithm()) != null) {
                return this.helper.createDigest((String) map.get(algorithmIdentifier.getAlgorithm()));
            }
            throw e;
        }
    }

    public Signature createRawSignature(AlgorithmIdentifier algorithmIdentifier) {
        try {
            String signatureName = getSignatureName(algorithmIdentifier);
            return this.helper.createSignature("NONE" + signatureName.substring(signatureName.indexOf("WITH")));
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Signature createSignature(AlgorithmIdentifier algorithmIdentifier) throws GeneralSecurityException {
        try {
            return this.helper.createSignature(getSignatureName(algorithmIdentifier));
        } catch (NoSuchAlgorithmException e) {
            Map map = oids;
            if (map.get(algorithmIdentifier.getAlgorithm()) != null) {
                return this.helper.createSignature((String) map.get(algorithmIdentifier.getAlgorithm()));
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public Cipher createSymmetricWrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws OperatorCreationException {
        try {
            String str = (String) symmetricWrapperAlgNames.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.helper.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.helper.createCipher(aSN1ObjectIdentifier.getId());
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
        }
    }
}
