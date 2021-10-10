package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public class ECGOST3410NamedCurves {
    static final Hashtable names;
    static final Hashtable objIds;
    static final Hashtable params;

    static {
        Hashtable hashtable = new Hashtable();
        objIds = hashtable;
        Hashtable hashtable2 = new Hashtable();
        params = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        names = hashtable3;
        BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve.Fp fp = new ECCurve.Fp(bigInteger, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"));
        hashtable2.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A, new ECDomainParameters(fp, new ECPoint.Fp(fp, new ECFieldElement.Fp(fp.getQ(), new BigInteger("1")), new ECFieldElement.Fp(fp.getQ(), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"))), bigInteger2));
        BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger4 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve.Fp fp2 = new ECCurve.Fp(bigInteger3, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"));
        hashtable2.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA, new ECDomainParameters(fp2, new ECPoint.Fp(fp2, new ECFieldElement.Fp(fp2.getQ(), new BigInteger("1")), new ECFieldElement.Fp(fp2.getQ(), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612"))), bigInteger4));
        BigInteger bigInteger5 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        BigInteger bigInteger6 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        ECCurve.Fp fp3 = new ECCurve.Fp(bigInteger5, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"));
        hashtable2.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B, new ECDomainParameters(fp3, new ECPoint.Fp(fp3, new ECFieldElement.Fp(bigInteger5, new BigInteger("1")), new ECFieldElement.Fp(bigInteger5, new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124"))), bigInteger6));
        BigInteger bigInteger7 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger8 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve.Fp fp4 = new ECCurve.Fp(bigInteger7, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"));
        hashtable2.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB, new ECDomainParameters(fp4, new ECPoint.Fp(fp4, new ECFieldElement.Fp(bigInteger7, new BigInteger("0")), new ECFieldElement.Fp(bigInteger7, new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"))), bigInteger8));
        BigInteger bigInteger9 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger10 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve.Fp fp5 = new ECCurve.Fp(bigInteger9, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"));
        hashtable2.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C, new ECDomainParameters(fp5, new ECPoint.Fp(fp5, new ECFieldElement.Fp(bigInteger9, new BigInteger("0")), new ECFieldElement.Fp(bigInteger9, new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247"))), bigInteger10));
        hashtable.put("GostR3410-2001-CryptoPro-A", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A);
        hashtable.put("GostR3410-2001-CryptoPro-B", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B);
        hashtable.put("GostR3410-2001-CryptoPro-C", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C);
        hashtable.put("GostR3410-2001-CryptoPro-XchA", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA);
        hashtable.put("GostR3410-2001-CryptoPro-XchB", CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB);
        hashtable3.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A, "GostR3410-2001-CryptoPro-A");
        hashtable3.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B, "GostR3410-2001-CryptoPro-B");
        hashtable3.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C, "GostR3410-2001-CryptoPro-C");
        hashtable3.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA, "GostR3410-2001-CryptoPro-XchA");
        hashtable3.put(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB, "GostR3410-2001-CryptoPro-XchB");
    }

    public static ECDomainParameters getByName(String str) {
        DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) objIds.get(str);
        if (dERObjectIdentifier != null) {
            return (ECDomainParameters) params.get(dERObjectIdentifier);
        }
        return null;
    }

    public static ECDomainParameters getByOID(DERObjectIdentifier dERObjectIdentifier) {
        return (ECDomainParameters) params.get(dERObjectIdentifier);
    }

    public static String getName(DERObjectIdentifier dERObjectIdentifier) {
        return (String) names.get(dERObjectIdentifier);
    }

    public static Enumeration getNames() {
        return objIds.keys();
    }

    public static DERObjectIdentifier getOID(String str) {
        return (DERObjectIdentifier) objIds.get(str);
    }
}
