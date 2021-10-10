package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.ocsp.CertificateID;

public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier commonName = new ASN1ObjectIdentifier("2.5.4.3");
    public static final ASN1ObjectIdentifier countryName = new ASN1ObjectIdentifier("2.5.4.6");
    public static final ASN1ObjectIdentifier crlAccessMethod;
    public static final String id = "2.5.4";
    public static final ASN1ObjectIdentifier id_SHA1 = new ASN1ObjectIdentifier(CertificateID.HASH_SHA1);
    public static final ASN1ObjectIdentifier id_ad;
    public static final ASN1ObjectIdentifier id_ad_caIssuers;
    public static final ASN1ObjectIdentifier id_ad_ocsp;
    public static final ASN1ObjectIdentifier id_at_name = new ASN1ObjectIdentifier("2.5.4.41");
    public static final ASN1ObjectIdentifier id_at_telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20");
    public static final ASN1ObjectIdentifier id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1");
    public static final ASN1ObjectIdentifier id_pe;
    public static final ASN1ObjectIdentifier id_pkix;
    public static final ASN1ObjectIdentifier localityName = new ASN1ObjectIdentifier("2.5.4.7");
    public static final ASN1ObjectIdentifier ocspAccessMethod;
    public static final ASN1ObjectIdentifier organization = new ASN1ObjectIdentifier("2.5.4.10");
    public static final ASN1ObjectIdentifier organizationalUnitName = new ASN1ObjectIdentifier("2.5.4.11");
    public static final ASN1ObjectIdentifier ripemd160 = new ASN1ObjectIdentifier("1.3.36.3.2.1");
    public static final ASN1ObjectIdentifier ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2");
    public static final ASN1ObjectIdentifier stateOrProvinceName = new ASN1ObjectIdentifier("2.5.4.8");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = aSN1ObjectIdentifier;
        id_pe = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".48");
        id_ad = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2 + ".2");
        id_ad_caIssuers = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2 + ".1");
        id_ad_ocsp = aSN1ObjectIdentifier4;
        ocspAccessMethod = aSN1ObjectIdentifier4;
        crlAccessMethod = aSN1ObjectIdentifier3;
    }
}
