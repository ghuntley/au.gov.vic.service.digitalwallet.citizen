package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Arrays;

public class Tables1kGCMExponentiator implements GCMExponentiator {
    byte[][] lookupPowX2 = new byte[64][];

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        byte[] oneAsBytes = GCMUtil.oneAsBytes();
        int i = 1;
        while (j > 0) {
            if ((1 & j) != 0) {
                GCMUtil.multiply(oneAsBytes, this.lookupPowX2[i]);
            }
            i++;
            j >>>= 1;
        }
        System.arraycopy(oneAsBytes, 0, bArr, 0, 16);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        byte[][] bArr2 = this.lookupPowX2;
        bArr2[0] = new byte[16];
        bArr2[0][0] = Byte.MIN_VALUE;
        bArr2[1] = Arrays.clone(bArr);
        for (int i = 2; i != 64; i++) {
            byte[] clone = Arrays.clone(this.lookupPowX2[i - 1]);
            GCMUtil.multiply(clone, clone);
            this.lookupPowX2[i] = clone;
        }
    }
}
