package org.bouncycastle.tsp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

public interface TSPAlgorithms {
    public static final Set ALLOWED;
    public static final String GOST3411;
    public static final String MD5;
    public static final String RIPEMD128;
    public static final String RIPEMD160;
    public static final String RIPEMD256;
    public static final String SHA1;
    public static final String SHA224;
    public static final String SHA256;
    public static final String SHA384;
    public static final String SHA512;

    static {
        String id = PKCSObjectIdentifiers.md5.getId();
        MD5 = id;
        String id2 = OIWObjectIdentifiers.idSHA1.getId();
        SHA1 = id2;
        String id3 = NISTObjectIdentifiers.id_sha224.getId();
        SHA224 = id3;
        String id4 = NISTObjectIdentifiers.id_sha256.getId();
        SHA256 = id4;
        String id5 = NISTObjectIdentifiers.id_sha384.getId();
        SHA384 = id5;
        String id6 = NISTObjectIdentifiers.id_sha512.getId();
        SHA512 = id6;
        String id7 = TeleTrusTObjectIdentifiers.ripemd128.getId();
        RIPEMD128 = id7;
        String id8 = TeleTrusTObjectIdentifiers.ripemd160.getId();
        RIPEMD160 = id8;
        String id9 = TeleTrusTObjectIdentifiers.ripemd256.getId();
        RIPEMD256 = id9;
        String id10 = CryptoProObjectIdentifiers.gostR3411.getId();
        GOST3411 = id10;
        ALLOWED = new HashSet(Arrays.asList(id10, id, id2, id3, id4, id5, id6, id7, id8, id9));
    }
}
