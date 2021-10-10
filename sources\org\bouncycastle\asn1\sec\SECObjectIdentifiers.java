package org.bouncycastle.asn1.sec;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

public interface SECObjectIdentifiers {
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier secp112r1;
    public static final ASN1ObjectIdentifier secp112r2;
    public static final ASN1ObjectIdentifier secp128r1;
    public static final ASN1ObjectIdentifier secp128r2;
    public static final ASN1ObjectIdentifier secp160k1;
    public static final ASN1ObjectIdentifier secp160r1;
    public static final ASN1ObjectIdentifier secp160r2;
    public static final ASN1ObjectIdentifier secp192k1;
    public static final ASN1ObjectIdentifier secp192r1 = X9ObjectIdentifiers.prime192v1;
    public static final ASN1ObjectIdentifier secp224k1;
    public static final ASN1ObjectIdentifier secp224r1;
    public static final ASN1ObjectIdentifier secp256k1;
    public static final ASN1ObjectIdentifier secp256r1 = X9ObjectIdentifiers.prime256v1;
    public static final ASN1ObjectIdentifier secp384r1;
    public static final ASN1ObjectIdentifier secp521r1;
    public static final ASN1ObjectIdentifier sect113r1;
    public static final ASN1ObjectIdentifier sect113r2;
    public static final ASN1ObjectIdentifier sect131r1;
    public static final ASN1ObjectIdentifier sect131r2;
    public static final ASN1ObjectIdentifier sect163k1;
    public static final ASN1ObjectIdentifier sect163r1;
    public static final ASN1ObjectIdentifier sect163r2;
    public static final ASN1ObjectIdentifier sect193r1;
    public static final ASN1ObjectIdentifier sect193r2;
    public static final ASN1ObjectIdentifier sect233k1;
    public static final ASN1ObjectIdentifier sect233r1;
    public static final ASN1ObjectIdentifier sect239k1;
    public static final ASN1ObjectIdentifier sect283k1;
    public static final ASN1ObjectIdentifier sect283r1;
    public static final ASN1ObjectIdentifier sect409k1;
    public static final ASN1ObjectIdentifier sect409r1;
    public static final ASN1ObjectIdentifier sect571k1;
    public static final ASN1ObjectIdentifier sect571r1;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.132.0");
        ellipticCurve = aSN1ObjectIdentifier;
        sect163k1 = aSN1ObjectIdentifier.branch("1");
        sect163r1 = aSN1ObjectIdentifier.branch("2");
        sect239k1 = aSN1ObjectIdentifier.branch("3");
        sect113r1 = aSN1ObjectIdentifier.branch("4");
        sect113r2 = aSN1ObjectIdentifier.branch("5");
        secp112r1 = aSN1ObjectIdentifier.branch("6");
        secp112r2 = aSN1ObjectIdentifier.branch("7");
        secp160r1 = aSN1ObjectIdentifier.branch("8");
        secp160k1 = aSN1ObjectIdentifier.branch("9");
        secp256k1 = aSN1ObjectIdentifier.branch("10");
        sect163r2 = aSN1ObjectIdentifier.branch("15");
        sect283k1 = aSN1ObjectIdentifier.branch("16");
        sect283r1 = aSN1ObjectIdentifier.branch("17");
        sect131r1 = aSN1ObjectIdentifier.branch("22");
        sect131r2 = aSN1ObjectIdentifier.branch("23");
        sect193r1 = aSN1ObjectIdentifier.branch("24");
        sect193r2 = aSN1ObjectIdentifier.branch("25");
        sect233k1 = aSN1ObjectIdentifier.branch("26");
        sect233r1 = aSN1ObjectIdentifier.branch("27");
        secp128r1 = aSN1ObjectIdentifier.branch("28");
        secp128r2 = aSN1ObjectIdentifier.branch("29");
        secp160r2 = aSN1ObjectIdentifier.branch("30");
        secp192k1 = aSN1ObjectIdentifier.branch("31");
        secp224k1 = aSN1ObjectIdentifier.branch("32");
        secp224r1 = aSN1ObjectIdentifier.branch("33");
        secp384r1 = aSN1ObjectIdentifier.branch("34");
        secp521r1 = aSN1ObjectIdentifier.branch("35");
        sect409k1 = aSN1ObjectIdentifier.branch("36");
        sect409r1 = aSN1ObjectIdentifier.branch("37");
        sect571k1 = aSN1ObjectIdentifier.branch("38");
        sect571r1 = aSN1ObjectIdentifier.branch("39");
    }
}
