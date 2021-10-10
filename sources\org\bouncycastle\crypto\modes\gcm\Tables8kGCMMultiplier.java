package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier {
    private final int[][][] M = ((int[][][]) Array.newInstance(int[].class, 32, 16));

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        int[][][] iArr = this.M;
        iArr[0][0] = new int[4];
        iArr[1][0] = new int[4];
        iArr[1][8] = GCMUtil.asInts(bArr);
        for (int i = 4; i >= 1; i >>= 1) {
            int[] iArr2 = new int[4];
            System.arraycopy(this.M[1][i + i], 0, iArr2, 0, 4);
            GCMUtil.multiplyP(iArr2);
            this.M[1][i] = iArr2;
        }
        int[] iArr3 = new int[4];
        System.arraycopy(this.M[1][1], 0, iArr3, 0, 4);
        GCMUtil.multiplyP(iArr3);
        this.M[0][8] = iArr3;
        for (int i2 = 4; i2 >= 1; i2 >>= 1) {
            int[] iArr4 = new int[4];
            System.arraycopy(this.M[0][i2 + i2], 0, iArr4, 0, 4);
            GCMUtil.multiplyP(iArr4);
            this.M[0][i2] = iArr4;
        }
        int i3 = 0;
        while (true) {
            for (int i4 = 2; i4 < 16; i4 += i4) {
                for (int i5 = 1; i5 < i4; i5++) {
                    int[] iArr5 = new int[4];
                    System.arraycopy(this.M[i3][i4], 0, iArr5, 0, 4);
                    GCMUtil.xor(iArr5, this.M[i3][i5]);
                    this.M[i3][i4 + i5] = iArr5;
                }
            }
            i3++;
            if (i3 == 32) {
                return;
            }
            if (i3 > 1) {
                this.M[i3][0] = new int[4];
                for (int i6 = 8; i6 > 0; i6 >>= 1) {
                    int[] iArr6 = new int[4];
                    System.arraycopy(this.M[i3 - 2][i6], 0, iArr6, 0, 4);
                    GCMUtil.multiplyP8(iArr6);
                    this.M[i3][i6] = iArr6;
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i = 15; i >= 0; i--) {
            int[][][] iArr2 = this.M;
            int i2 = i + i;
            int[] iArr3 = iArr2[i2][bArr[i] & 15];
            iArr[0] = iArr[0] ^ iArr3[0];
            iArr[1] = iArr[1] ^ iArr3[1];
            iArr[2] = iArr[2] ^ iArr3[2];
            iArr[3] = iArr3[3] ^ iArr[3];
            int[] iArr4 = iArr2[i2 + 1][(bArr[i] & 240) >>> 4];
            iArr[0] = iArr[0] ^ iArr4[0];
            iArr[1] = iArr[1] ^ iArr4[1];
            iArr[2] = iArr[2] ^ iArr4[2];
            iArr[3] = iArr[3] ^ iArr4[3];
        }
        Pack.intToBigEndian(iArr[0], bArr, 0);
        Pack.intToBigEndian(iArr[1], bArr, 4);
        Pack.intToBigEndian(iArr[2], bArr, 8);
        Pack.intToBigEndian(iArr[3], bArr, 12);
    }
}
