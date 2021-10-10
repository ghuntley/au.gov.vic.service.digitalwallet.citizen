package org.bouncycastle.cms;

import org.bouncycastle.asn1.DERObjectIdentifier;

public class CMSConfig {
    public static void setSigningDigestAlgorithmMapping(String str, String str2) {
        CMSSignedHelper.INSTANCE.setSigningDigestAlgorithmMapping(new DERObjectIdentifier(str), str2);
    }

    public static void setSigningEncryptionAlgorithmMapping(String str, String str2) {
        CMSSignedHelper.INSTANCE.setSigningEncryptionAlgorithmMapping(new DERObjectIdentifier(str), str2);
    }
}
