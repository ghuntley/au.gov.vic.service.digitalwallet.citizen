package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.Map;
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

public class DefaultDigestAlgorithmIdentifierFinder implements DigestAlgorithmIdentifierFinder {
    private static Map digestOids;

    static {
        HashMap hashMap = new HashMap();
        digestOids = hashMap;
        hashMap.put(OIWObjectIdentifiers.md4WithRSAEncryption, PKCSObjectIdentifiers.md4);
        digestOids.put(OIWObjectIdentifiers.md4WithRSA, PKCSObjectIdentifiers.md4);
        digestOids.put(OIWObjectIdentifiers.sha1WithRSA, OIWObjectIdentifiers.idSHA1);
        digestOids.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, NISTObjectIdentifiers.id_sha224);
        digestOids.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, NISTObjectIdentifiers.id_sha256);
        digestOids.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, NISTObjectIdentifiers.id_sha384);
        digestOids.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, NISTObjectIdentifiers.id_sha512);
        digestOids.put(PKCSObjectIdentifiers.md2WithRSAEncryption, PKCSObjectIdentifiers.md2);
        digestOids.put(PKCSObjectIdentifiers.md4WithRSAEncryption, PKCSObjectIdentifiers.md4);
        digestOids.put(PKCSObjectIdentifiers.md5WithRSAEncryption, PKCSObjectIdentifiers.md5);
        digestOids.put(PKCSObjectIdentifiers.sha1WithRSAEncryption, OIWObjectIdentifiers.idSHA1);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA1, OIWObjectIdentifiers.idSHA1);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA224, NISTObjectIdentifiers.id_sha224);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA256, NISTObjectIdentifiers.id_sha256);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA384, NISTObjectIdentifiers.id_sha384);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA512, NISTObjectIdentifiers.id_sha512);
        digestOids.put(X9ObjectIdentifiers.id_dsa_with_sha1, OIWObjectIdentifiers.idSHA1);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha224, NISTObjectIdentifiers.id_sha224);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha256, NISTObjectIdentifiers.id_sha256);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha384, NISTObjectIdentifiers.id_sha384);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha512, NISTObjectIdentifiers.id_sha512);
        digestOids.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128, TeleTrusTObjectIdentifiers.ripemd128);
        digestOids.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160, TeleTrusTObjectIdentifiers.ripemd160);
        digestOids.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256, TeleTrusTObjectIdentifiers.ripemd256);
        digestOids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, CryptoProObjectIdentifiers.gostR3411);
        digestOids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, CryptoProObjectIdentifiers.gostR3411);
    }

    @Override // org.bouncycastle.operator.DigestAlgorithmIdentifierFinder
    public AlgorithmIdentifier find(AlgorithmIdentifier algorithmIdentifier) {
        return algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) ? ((RSASSAPSSparams) algorithmIdentifier.getParameters()).getHashAlgorithm() : new AlgorithmIdentifier((DERObjectIdentifier) digestOids.get(algorithmIdentifier.getAlgorithm()), new DERNull());
    }
}
