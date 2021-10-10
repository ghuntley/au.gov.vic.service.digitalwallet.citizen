package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class RC2Parameters implements CipherParameters {
    private int bits;
    private byte[] key;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RC2Parameters(byte[] bArr) {
        this(bArr, bArr.length > 128 ? 1024 : bArr.length * 8);
    }

    public RC2Parameters(byte[] bArr, int i) {
        byte[] bArr2 = new byte[bArr.length];
        this.key = bArr2;
        this.bits = i;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public int getEffectiveKeyBits() {
        return this.bits;
    }

    public byte[] getKey() {
        return this.key;
    }
}
