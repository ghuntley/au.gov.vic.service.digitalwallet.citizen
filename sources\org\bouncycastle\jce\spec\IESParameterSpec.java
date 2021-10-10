package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class IESParameterSpec implements AlgorithmParameterSpec {
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[bArr.length];
        this.derivation = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        byte[] bArr4 = new byte[bArr2.length];
        this.encoding = bArr4;
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        this.macKeySize = i;
    }

    public byte[] getDerivationV() {
        return this.derivation;
    }

    public byte[] getEncodingV() {
        return this.encoding;
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }
}
