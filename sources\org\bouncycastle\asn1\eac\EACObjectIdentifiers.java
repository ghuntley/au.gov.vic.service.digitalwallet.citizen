package org.bouncycastle.asn1.eac;

import org.bouncycastle.asn1.DERObjectIdentifier;

public interface EACObjectIdentifiers {
    public static final DERObjectIdentifier bsi_de;
    public static final DERObjectIdentifier id_CA;
    public static final DERObjectIdentifier id_CA_DH;
    public static final DERObjectIdentifier id_CA_DH_3DES_CBC_CBC;
    public static final DERObjectIdentifier id_CA_ECDH;
    public static final DERObjectIdentifier id_CA_ECDH_3DES_CBC_CBC;
    public static final DERObjectIdentifier id_EAC_ePassport;
    public static final DERObjectIdentifier id_PK;
    public static final DERObjectIdentifier id_PK_DH;
    public static final DERObjectIdentifier id_PK_ECDH;
    public static final DERObjectIdentifier id_TA;
    public static final DERObjectIdentifier id_TA_ECDSA;
    public static final DERObjectIdentifier id_TA_ECDSA_SHA_1;
    public static final DERObjectIdentifier id_TA_ECDSA_SHA_224;
    public static final DERObjectIdentifier id_TA_ECDSA_SHA_256;
    public static final DERObjectIdentifier id_TA_ECDSA_SHA_384;
    public static final DERObjectIdentifier id_TA_ECDSA_SHA_512;
    public static final DERObjectIdentifier id_TA_RSA;
    public static final DERObjectIdentifier id_TA_RSA_PSS_SHA_1;
    public static final DERObjectIdentifier id_TA_RSA_PSS_SHA_256;
    public static final DERObjectIdentifier id_TA_RSA_v1_5_SHA_1;
    public static final DERObjectIdentifier id_TA_RSA_v1_5_SHA_256;

    static {
        DERObjectIdentifier dERObjectIdentifier = new DERObjectIdentifier("0.4.0.127.0.7");
        bsi_de = dERObjectIdentifier;
        DERObjectIdentifier dERObjectIdentifier2 = new DERObjectIdentifier(dERObjectIdentifier + ".2.2.1");
        id_PK = dERObjectIdentifier2;
        id_PK_DH = new DERObjectIdentifier(dERObjectIdentifier2 + ".1");
        id_PK_ECDH = new DERObjectIdentifier(dERObjectIdentifier2 + ".2");
        DERObjectIdentifier dERObjectIdentifier3 = new DERObjectIdentifier(dERObjectIdentifier + ".2.2.3");
        id_CA = dERObjectIdentifier3;
        DERObjectIdentifier dERObjectIdentifier4 = new DERObjectIdentifier(dERObjectIdentifier3 + ".1");
        id_CA_DH = dERObjectIdentifier4;
        id_CA_DH_3DES_CBC_CBC = new DERObjectIdentifier(dERObjectIdentifier4 + ".1");
        DERObjectIdentifier dERObjectIdentifier5 = new DERObjectIdentifier(dERObjectIdentifier3 + ".2");
        id_CA_ECDH = dERObjectIdentifier5;
        id_CA_ECDH_3DES_CBC_CBC = new DERObjectIdentifier(dERObjectIdentifier5 + ".1");
        DERObjectIdentifier dERObjectIdentifier6 = new DERObjectIdentifier(dERObjectIdentifier + ".2.2.2");
        id_TA = dERObjectIdentifier6;
        DERObjectIdentifier dERObjectIdentifier7 = new DERObjectIdentifier(dERObjectIdentifier6 + ".1");
        id_TA_RSA = dERObjectIdentifier7;
        id_TA_RSA_v1_5_SHA_1 = new DERObjectIdentifier(dERObjectIdentifier7 + ".1");
        id_TA_RSA_v1_5_SHA_256 = new DERObjectIdentifier(dERObjectIdentifier7 + ".2");
        id_TA_RSA_PSS_SHA_1 = new DERObjectIdentifier(dERObjectIdentifier7 + ".3");
        id_TA_RSA_PSS_SHA_256 = new DERObjectIdentifier(dERObjectIdentifier7 + ".4");
        DERObjectIdentifier dERObjectIdentifier8 = new DERObjectIdentifier(dERObjectIdentifier6 + ".2");
        id_TA_ECDSA = dERObjectIdentifier8;
        id_TA_ECDSA_SHA_1 = new DERObjectIdentifier(dERObjectIdentifier8 + ".1");
        id_TA_ECDSA_SHA_224 = new DERObjectIdentifier(dERObjectIdentifier8 + ".2");
        id_TA_ECDSA_SHA_256 = new DERObjectIdentifier(dERObjectIdentifier8 + ".3");
        id_TA_ECDSA_SHA_384 = new DERObjectIdentifier(dERObjectIdentifier8 + ".4");
        id_TA_ECDSA_SHA_512 = new DERObjectIdentifier(dERObjectIdentifier8 + ".5");
        id_EAC_ePassport = new DERObjectIdentifier(dERObjectIdentifier + ".3.1.2.1");
    }
}
