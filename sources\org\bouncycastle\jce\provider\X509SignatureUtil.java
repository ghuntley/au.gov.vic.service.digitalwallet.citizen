package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

/* access modifiers changed from: package-private */
public class X509SignatureUtil {
    private static final ASN1Null derNull = new DERNull();

    X509SignatureUtil() {
    }

    private static String getDigestAlgName(DERObjectIdentifier dERObjectIdentifier) {
        return PKCSObjectIdentifiers.md5.equals(dERObjectIdentifier) ? "MD5" : OIWObjectIdentifiers.idSHA1.equals(dERObjectIdentifier) ? "SHA1" : NISTObjectIdentifiers.id_sha224.equals(dERObjectIdentifier) ? "SHA224" : NISTObjectIdentifiers.id_sha256.equals(dERObjectIdentifier) ? "SHA256" : NISTObjectIdentifiers.id_sha384.equals(dERObjectIdentifier) ? "SHA384" : NISTObjectIdentifiers.id_sha512.equals(dERObjectIdentifier) ? "SHA512" : TeleTrusTObjectIdentifiers.ripemd128.equals(dERObjectIdentifier) ? "RIPEMD128" : TeleTrusTObjectIdentifiers.ripemd160.equals(dERObjectIdentifier) ? "RIPEMD160" : TeleTrusTObjectIdentifiers.ripemd256.equals(dERObjectIdentifier) ? "RIPEMD256" : CryptoProObjectIdentifiers.gostR3411.equals(dERObjectIdentifier) ? "GOST3411" : dERObjectIdentifier.getId();
    }

    static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        DEREncodable parameters = algorithmIdentifier.getParameters();
        if (parameters != null && !derNull.equals(parameters)) {
            if (algorithmIdentifier.getObjectId().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
                RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
                return getDigestAlgName(instance.getHashAlgorithm().getObjectId()) + "withRSAandMGF1";
            } else if (algorithmIdentifier.getObjectId().equals(X9ObjectIdentifiers.ecdsa_with_SHA2)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(parameters);
                return getDigestAlgName((DERObjectIdentifier) instance2.getObjectAt(0)) + "withECDSA";
            }
        }
        return algorithmIdentifier.getObjectId().getId();
    }

    static void setSignatureParameters(Signature signature, DEREncodable dEREncodable) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (dEREncodable != null && !derNull.equals(dEREncodable)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(dEREncodable.getDERObject().getDEREncoded());
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e) {
                        throw new SignatureException("Exception extracting parameters: " + e.getMessage());
                    }
                }
            } catch (IOException e2) {
                throw new SignatureException("IOException decoding parameters: " + e2.getMessage());
            }
        }
    }
}
