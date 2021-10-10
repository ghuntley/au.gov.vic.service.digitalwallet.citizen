package org.bouncycastle.asn1.nist;

import androidx.room.RoomMasterTable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface NISTObjectIdentifiers {
    public static final ASN1ObjectIdentifier aes;
    public static final ASN1ObjectIdentifier dsa_with_sha224;
    public static final ASN1ObjectIdentifier dsa_with_sha256;
    public static final ASN1ObjectIdentifier dsa_with_sha384;
    public static final ASN1ObjectIdentifier dsa_with_sha512;
    public static final ASN1ObjectIdentifier id_aes128_CBC;
    public static final ASN1ObjectIdentifier id_aes128_CCM;
    public static final ASN1ObjectIdentifier id_aes128_CFB;
    public static final ASN1ObjectIdentifier id_aes128_ECB;
    public static final ASN1ObjectIdentifier id_aes128_GCM;
    public static final ASN1ObjectIdentifier id_aes128_OFB;
    public static final ASN1ObjectIdentifier id_aes128_wrap;
    public static final ASN1ObjectIdentifier id_aes192_CBC;
    public static final ASN1ObjectIdentifier id_aes192_CCM;
    public static final ASN1ObjectIdentifier id_aes192_CFB;
    public static final ASN1ObjectIdentifier id_aes192_ECB;
    public static final ASN1ObjectIdentifier id_aes192_GCM;
    public static final ASN1ObjectIdentifier id_aes192_OFB;
    public static final ASN1ObjectIdentifier id_aes192_wrap;
    public static final ASN1ObjectIdentifier id_aes256_CBC;
    public static final ASN1ObjectIdentifier id_aes256_CCM;
    public static final ASN1ObjectIdentifier id_aes256_CFB;
    public static final ASN1ObjectIdentifier id_aes256_ECB;
    public static final ASN1ObjectIdentifier id_aes256_GCM;
    public static final ASN1ObjectIdentifier id_aes256_OFB;
    public static final ASN1ObjectIdentifier id_aes256_wrap;
    public static final ASN1ObjectIdentifier id_dsa_with_sha2;
    public static final ASN1ObjectIdentifier id_sha224;
    public static final ASN1ObjectIdentifier id_sha256;
    public static final ASN1ObjectIdentifier id_sha384;
    public static final ASN1ObjectIdentifier id_sha512;
    public static final ASN1ObjectIdentifier nistAlgorithm;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.101.3.4");
        nistAlgorithm = aSN1ObjectIdentifier;
        id_sha256 = aSN1ObjectIdentifier.branch("2.1");
        id_sha384 = aSN1ObjectIdentifier.branch("2.2");
        id_sha512 = aSN1ObjectIdentifier.branch("2.3");
        id_sha224 = aSN1ObjectIdentifier.branch("2.4");
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1");
        aes = branch;
        id_aes128_ECB = branch.branch("1");
        id_aes128_CBC = branch.branch("2");
        id_aes128_OFB = branch.branch("3");
        id_aes128_CFB = branch.branch("4");
        id_aes128_wrap = branch.branch("5");
        id_aes128_GCM = branch.branch("6");
        id_aes128_CCM = branch.branch("7");
        id_aes192_ECB = branch.branch("21");
        id_aes192_CBC = branch.branch("22");
        id_aes192_OFB = branch.branch("23");
        id_aes192_CFB = branch.branch("24");
        id_aes192_wrap = branch.branch("25");
        id_aes192_GCM = branch.branch("26");
        id_aes192_CCM = branch.branch("27");
        id_aes256_ECB = branch.branch("41");
        id_aes256_CBC = branch.branch(RoomMasterTable.DEFAULT_ID);
        id_aes256_OFB = branch.branch("43");
        id_aes256_CFB = branch.branch("44");
        id_aes256_wrap = branch.branch("45");
        id_aes256_GCM = branch.branch("46");
        id_aes256_CCM = branch.branch("47");
        ASN1ObjectIdentifier branch2 = aSN1ObjectIdentifier.branch("3");
        id_dsa_with_sha2 = branch2;
        dsa_with_sha224 = branch2.branch("1");
        dsa_with_sha256 = branch2.branch("2");
        dsa_with_sha384 = branch2.branch("3");
        dsa_with_sha512 = branch2.branch("4");
    }
}
