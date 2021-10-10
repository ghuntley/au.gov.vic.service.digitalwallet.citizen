package org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class TSPUtil {
    private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
    private static final Map digestLengths;
    private static final Map digestNames;

    static {
        HashMap hashMap = new HashMap();
        digestLengths = hashMap;
        HashMap hashMap2 = new HashMap();
        digestNames = hashMap2;
        hashMap.put(PKCSObjectIdentifiers.md5.getId(), new Integer(16));
        hashMap.put(OIWObjectIdentifiers.idSHA1.getId(), new Integer(20));
        hashMap.put(NISTObjectIdentifiers.id_sha224.getId(), new Integer(28));
        hashMap.put(NISTObjectIdentifiers.id_sha256.getId(), new Integer(32));
        hashMap.put(NISTObjectIdentifiers.id_sha384.getId(), new Integer(48));
        hashMap.put(NISTObjectIdentifiers.id_sha512.getId(), new Integer(64));
        hashMap.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), new Integer(16));
        hashMap.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), new Integer(20));
        hashMap.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), new Integer(32));
        hashMap.put(CryptoProObjectIdentifiers.gostR3411.getId(), new Integer(32));
        hashMap2.put(PKCSObjectIdentifiers.md5.getId(), "MD5");
        hashMap2.put(OIWObjectIdentifiers.idSHA1.getId(), "SHA1");
        hashMap2.put(NISTObjectIdentifiers.id_sha224.getId(), "SHA224");
        hashMap2.put(NISTObjectIdentifiers.id_sha256.getId(), "SHA256");
        hashMap2.put(NISTObjectIdentifiers.id_sha384.getId(), "SHA384");
        hashMap2.put(NISTObjectIdentifiers.id_sha512.getId(), "SHA512");
        hashMap2.put(PKCSObjectIdentifiers.sha1WithRSAEncryption.getId(), "SHA1");
        hashMap2.put(PKCSObjectIdentifiers.sha224WithRSAEncryption.getId(), "SHA224");
        hashMap2.put(PKCSObjectIdentifiers.sha256WithRSAEncryption.getId(), "SHA256");
        hashMap2.put(PKCSObjectIdentifiers.sha384WithRSAEncryption.getId(), "SHA384");
        hashMap2.put(PKCSObjectIdentifiers.sha512WithRSAEncryption.getId(), "SHA512");
        hashMap2.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), "RIPEMD128");
        hashMap2.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), "RIPEMD160");
        hashMap2.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), "RIPEMD256");
        hashMap2.put(CryptoProObjectIdentifiers.gostR3411.getId(), "GOST3411");
    }

    static MessageDigest createDigestInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        String digestAlgName = getDigestAlgName(str);
        if (provider != null) {
            try {
                return MessageDigest.getInstance(digestAlgName, provider);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return MessageDigest.getInstance(digestAlgName);
    }

    static Set getCriticalExtensionOIDs(X509Extensions x509Extensions) {
        return x509Extensions == null ? EMPTY_SET : Collections.unmodifiableSet(new HashSet(Arrays.asList(x509Extensions.getCriticalExtensionOIDs())));
    }

    static String getDigestAlgName(String str) {
        String str2 = (String) digestNames.get(str);
        return str2 != null ? str2 : str;
    }

    static int getDigestLength(String str) throws TSPException {
        Integer num = (Integer) digestLengths.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new TSPException("digest algorithm cannot be found.");
    }

    static List getExtensionOIDs(X509Extensions x509Extensions) {
        return x509Extensions == null ? EMPTY_LIST : Collections.unmodifiableList(Arrays.asList(x509Extensions.getExtensionOIDs()));
    }

    static Set getNonCriticalExtensionOIDs(X509Extensions x509Extensions) {
        return x509Extensions == null ? EMPTY_SET : Collections.unmodifiableSet(new HashSet(Arrays.asList(x509Extensions.getNonCriticalExtensionOIDs())));
    }

    public static Collection getSignatureTimestamps(SignerInformation signerInformation, Provider provider) throws TSPValidationException {
        ArrayList arrayList = new ArrayList();
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            ASN1EncodableVector all = unsignedAttributes.getAll(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
            for (int i = 0; i < all.size(); i++) {
                ASN1Set attrValues = ((Attribute) all.get(i)).getAttrValues();
                for (int i2 = 0; i2 < attrValues.size(); i2++) {
                    try {
                        TimeStampToken timeStampToken = new TimeStampToken(ContentInfo.getInstance(attrValues.getObjectAt(i2).getDERObject()));
                        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                        if (org.bouncycastle.util.Arrays.constantTimeAreEqual(createDigestInstance(timeStampInfo.getMessageImprintAlgOID(), provider).digest(signerInformation.getSignature()), timeStampInfo.getMessageImprintDigest())) {
                            arrayList.add(timeStampToken);
                        } else {
                            throw new TSPValidationException("Incorrect digest in message imprint");
                        }
                    } catch (NoSuchAlgorithmException unused) {
                        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
                    } catch (Exception unused2) {
                        throw new TSPValidationException("Timestamp could not be parsed");
                    }
                }
            }
        }
        return arrayList;
    }

    public static Collection getSignatureTimestamps(SignerInformation signerInformation, DigestCalculatorProvider digestCalculatorProvider) throws TSPValidationException {
        ArrayList arrayList = new ArrayList();
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            ASN1EncodableVector all = unsignedAttributes.getAll(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
            for (int i = 0; i < all.size(); i++) {
                ASN1Set attrValues = ((Attribute) all.get(i)).getAttrValues();
                for (int i2 = 0; i2 < attrValues.size(); i2++) {
                    try {
                        TimeStampToken timeStampToken = new TimeStampToken(ContentInfo.getInstance(attrValues.getObjectAt(i2).getDERObject()));
                        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                        DigestCalculator digestCalculator = digestCalculatorProvider.get(timeStampInfo.getHashAlgorithm());
                        OutputStream outputStream = digestCalculator.getOutputStream();
                        outputStream.write(signerInformation.getSignature());
                        outputStream.close();
                        if (org.bouncycastle.util.Arrays.constantTimeAreEqual(digestCalculator.getDigest(), timeStampInfo.getMessageImprintDigest())) {
                            arrayList.add(timeStampToken);
                        } else {
                            throw new TSPValidationException("Incorrect digest in message imprint");
                        }
                    } catch (OperatorCreationException unused) {
                        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
                    } catch (Exception unused2) {
                        throw new TSPValidationException("Timestamp could not be parsed");
                    }
                }
            }
        }
        return arrayList;
    }

    public static void validateCertificate(X509Certificate x509Certificate) throws TSPValidationException {
        if (x509Certificate.getVersion() == 3) {
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.ExtendedKeyUsage.getId());
            if (extensionValue == null) {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
            } else if (x509Certificate.getCriticalExtensionOIDs().contains(X509Extensions.ExtendedKeyUsage.getId())) {
                try {
                    ExtendedKeyUsage instance = ExtendedKeyUsage.getInstance(new ASN1InputStream(new ByteArrayInputStream(((ASN1OctetString) new ASN1InputStream(new ByteArrayInputStream(extensionValue)).readObject()).getOctets())).readObject());
                    if (!instance.hasKeyPurposeId(KeyPurposeId.id_kp_timeStamping) || instance.size() != 1) {
                        throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
                    }
                } catch (IOException unused) {
                    throw new TSPValidationException("cannot process ExtendedKeyUsage extension");
                }
            } else {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
            }
        } else {
            throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
        }
    }

    public static void validateCertificate(X509CertificateHolder x509CertificateHolder) throws TSPValidationException {
        if (x509CertificateHolder.toASN1Structure().getVersion() == 3) {
            X509Extension extension = x509CertificateHolder.getExtension(X509Extension.extendedKeyUsage);
            if (extension == null) {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
            } else if (extension.isCritical()) {
                ExtendedKeyUsage instance = ExtendedKeyUsage.getInstance(X509Extension.convertValueToObject(extension));
                if (!instance.hasKeyPurposeId(KeyPurposeId.id_kp_timeStamping) || instance.size() != 1) {
                    throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
                }
            } else {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
            }
        } else {
            throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
        }
    }
}
