package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.crypto.DerivationParameters;

public class DHKDFParameters implements DerivationParameters {
    private final DERObjectIdentifier algorithm;
    private final byte[] extraInfo;
    private final int keySize;
    private final byte[] z;

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int i, byte[] bArr) {
        this.algorithm = dERObjectIdentifier;
        this.keySize = i;
        this.z = bArr;
        this.extraInfo = null;
    }

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.algorithm = dERObjectIdentifier;
        this.keySize = i;
        this.z = bArr;
        this.extraInfo = bArr2;
    }

    public DERObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public byte[] getZ() {
        return this.z;
    }
}
