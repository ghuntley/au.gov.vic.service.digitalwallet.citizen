package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.DERObjectIdentifier;

public interface BCObjectIdentifiers {
    public static final DERObjectIdentifier bc;
    public static final DERObjectIdentifier bc_pbe;
    public static final DERObjectIdentifier bc_pbe_sha1;
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12;
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc;
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc;
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc;
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs5;
    public static final DERObjectIdentifier bc_pbe_sha224;
    public static final DERObjectIdentifier bc_pbe_sha256;
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12;
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc;
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc;
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc;
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs5;
    public static final DERObjectIdentifier bc_pbe_sha384;
    public static final DERObjectIdentifier bc_pbe_sha512;

    static {
        DERObjectIdentifier dERObjectIdentifier = new DERObjectIdentifier("1.3.6.1.4.1.22554");
        bc = dERObjectIdentifier;
        DERObjectIdentifier dERObjectIdentifier2 = new DERObjectIdentifier(dERObjectIdentifier.getId() + ".1");
        bc_pbe = dERObjectIdentifier2;
        DERObjectIdentifier dERObjectIdentifier3 = new DERObjectIdentifier(dERObjectIdentifier2.getId() + ".1");
        bc_pbe_sha1 = dERObjectIdentifier3;
        DERObjectIdentifier dERObjectIdentifier4 = new DERObjectIdentifier(dERObjectIdentifier2.getId() + ".2.1");
        bc_pbe_sha256 = dERObjectIdentifier4;
        bc_pbe_sha384 = new DERObjectIdentifier(dERObjectIdentifier2.getId() + ".2.2");
        bc_pbe_sha512 = new DERObjectIdentifier(dERObjectIdentifier2.getId() + ".2.3");
        bc_pbe_sha224 = new DERObjectIdentifier(dERObjectIdentifier2.getId() + ".2.4");
        bc_pbe_sha1_pkcs5 = new DERObjectIdentifier(dERObjectIdentifier3.getId() + ".1");
        DERObjectIdentifier dERObjectIdentifier5 = new DERObjectIdentifier(dERObjectIdentifier3.getId() + ".2");
        bc_pbe_sha1_pkcs12 = dERObjectIdentifier5;
        bc_pbe_sha256_pkcs5 = new DERObjectIdentifier(dERObjectIdentifier4.getId() + ".1");
        DERObjectIdentifier dERObjectIdentifier6 = new DERObjectIdentifier(dERObjectIdentifier4.getId() + ".2");
        bc_pbe_sha256_pkcs12 = dERObjectIdentifier6;
        bc_pbe_sha1_pkcs12_aes128_cbc = new DERObjectIdentifier(dERObjectIdentifier5.getId() + ".1.2");
        bc_pbe_sha1_pkcs12_aes192_cbc = new DERObjectIdentifier(dERObjectIdentifier5.getId() + ".1.22");
        bc_pbe_sha1_pkcs12_aes256_cbc = new DERObjectIdentifier(dERObjectIdentifier5.getId() + ".1.42");
        bc_pbe_sha256_pkcs12_aes128_cbc = new DERObjectIdentifier(dERObjectIdentifier6.getId() + ".1.2");
        bc_pbe_sha256_pkcs12_aes192_cbc = new DERObjectIdentifier(dERObjectIdentifier6.getId() + ".1.22");
        bc_pbe_sha256_pkcs12_aes256_cbc = new DERObjectIdentifier(dERObjectIdentifier6.getId() + ".1.42");
    }
}
