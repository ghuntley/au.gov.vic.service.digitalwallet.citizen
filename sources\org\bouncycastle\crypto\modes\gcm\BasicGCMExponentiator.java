package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Arrays;

public class BasicGCMExponentiator implements GCMExponentiator {
    private byte[] x;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        byte[] oneAsBytes = GCMUtil.oneAsBytes();
        if (j > 0) {
            byte[] clone = Arrays.clone(this.x);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(oneAsBytes, clone);
                }
                GCMUtil.multiply(clone, clone);
                j >>>= 1;
            } while (j > 0);
        }
        System.arraycopy(oneAsBytes, 0, bArr, 0, 16);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        this.x = Arrays.clone(bArr);
    }
}
