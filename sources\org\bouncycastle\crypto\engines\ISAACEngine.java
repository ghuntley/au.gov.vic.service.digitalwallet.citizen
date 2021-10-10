package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class ISAACEngine implements StreamCipher {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int[] engineState = null;
    private int index = 0;
    private boolean initialised = false;
    private byte[] keyStream = new byte[1024];
    private int[] results = null;
    private final int sizeL = 8;
    private final int stateArraySize = 256;
    private byte[] workingKey = null;

    private int byteToIntLittle(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        return (bArr[i3 + 1] << 24) | i4 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
    }

    private byte[] intToByteLittle(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[1] = (byte) (i >>> 16);
        bArr[0] = (byte) (i >>> 24);
        return bArr;
    }

    private byte[] intToByteLittle(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            System.arraycopy(intToByteLittle(iArr[i]), 0, bArr, i2, 4);
            i++;
            i2 += 4;
        }
        return bArr;
    }

    private void isaac() {
        int i;
        int i2;
        int i3 = this.b;
        int i4 = this.c + 1;
        this.c = i4;
        this.b = i3 + i4;
        for (int i5 = 0; i5 < 256; i5++) {
            int[] iArr = this.engineState;
            int i6 = iArr[i5];
            int i7 = i5 & 3;
            if (i7 == 0) {
                i2 = this.a;
                i = i2 << 13;
            } else if (i7 == 1) {
                i2 = this.a;
                i = i2 >>> 6;
            } else if (i7 == 2) {
                i2 = this.a;
                i = i2 << 2;
            } else if (i7 != 3) {
                int i8 = this.a + iArr[(i5 + 128) & 255];
                this.a = i8;
                int i9 = iArr[(i6 >>> 2) & 255] + i8 + this.b;
                iArr[i5] = i9;
                int[] iArr2 = this.results;
                int i10 = iArr[(i9 >>> 10) & 255] + i6;
                this.b = i10;
                iArr2[i5] = i10;
            } else {
                i2 = this.a;
                i = i2 >>> 16;
            }
            this.a = i2 ^ i;
            int i82 = this.a + iArr[(i5 + 128) & 255];
            this.a = i82;
            int i92 = iArr[(i6 >>> 2) & 255] + i82 + this.b;
            iArr[i5] = i92;
            int[] iArr22 = this.results;
            int i102 = iArr[(i92 >>> 10) & 255] + i6;
            this.b = i102;
            iArr22[i5] = i102;
        }
    }

    private void mix(int[] iArr) {
        iArr[0] = iArr[0] ^ (iArr[1] << 11);
        iArr[3] = iArr[3] + iArr[0];
        iArr[1] = iArr[1] + iArr[2];
        iArr[1] = iArr[1] ^ (iArr[2] >>> 2);
        iArr[4] = iArr[4] + iArr[1];
        iArr[2] = iArr[2] + iArr[3];
        iArr[2] = iArr[2] ^ (iArr[3] << 8);
        iArr[5] = iArr[5] + iArr[2];
        iArr[3] = iArr[3] + iArr[4];
        iArr[3] = iArr[3] ^ (iArr[4] >>> 16);
        iArr[6] = iArr[6] + iArr[3];
        iArr[4] = iArr[4] + iArr[5];
        iArr[4] = iArr[4] ^ (iArr[5] << 10);
        iArr[7] = iArr[7] + iArr[4];
        iArr[5] = iArr[5] + iArr[6];
        iArr[5] = (iArr[6] >>> 4) ^ iArr[5];
        iArr[0] = iArr[0] + iArr[5];
        iArr[6] = iArr[6] + iArr[7];
        iArr[6] = iArr[6] ^ (iArr[7] << 8);
        iArr[1] = iArr[1] + iArr[6];
        iArr[7] = iArr[7] + iArr[0];
        iArr[7] = iArr[7] ^ (iArr[0] >>> 9);
        iArr[2] = iArr[2] + iArr[7];
        iArr[0] = iArr[0] + iArr[1];
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.results == null) {
            this.results = new int[256];
        }
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.engineState;
            this.results[i] = 0;
            iArr[i] = 0;
        }
        this.c = 0;
        this.b = 0;
        this.a = 0;
        this.index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i2 = 0; i2 < length; i2 += 4) {
            this.results[i2 >> 2] = byteToIntLittle(bArr2, i2);
        }
        int[] iArr2 = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            iArr2[i3] = -1640531527;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            mix(iArr2);
        }
        int i5 = 0;
        while (i5 < 2) {
            for (int i6 = 0; i6 < 256; i6 += 8) {
                for (int i7 = 0; i7 < 8; i7++) {
                    iArr2[i7] = iArr2[i7] + (i5 < 1 ? this.results[i6 + i7] : this.engineState[i6 + i7]);
                }
                mix(iArr2);
                for (int i8 = 0; i8 < 8; i8++) {
                    this.engineState[i6 + i8] = iArr2[i8];
                }
            }
            i5++;
        }
        isaac();
        this.initialised = true;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ISAAC init - " + cipherParameters.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (this.index == 0) {
                    isaac();
                    this.keyStream = intToByteLittle(this.results);
                }
                byte[] bArr3 = this.keyStream;
                int i5 = this.index;
                bArr2[i4 + i3] = (byte) (bArr3[i5] ^ bArr[i4 + i]);
                this.index = (i5 + 1) & 1023;
            }
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b2) {
        if (this.index == 0) {
            isaac();
            this.keyStream = intToByteLittle(this.results);
        }
        byte[] bArr = this.keyStream;
        int i = this.index;
        byte b3 = (byte) (b2 ^ bArr[i]);
        this.index = (i + 1) & 1023;
        return b3;
    }
}
