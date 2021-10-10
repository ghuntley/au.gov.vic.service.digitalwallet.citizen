package org.objectweb.asm;

import androidx.core.internal.view.SupportMenu;

public class ByteVector {
    byte[] a;
    int b;

    public ByteVector() {
        this.a = new byte[64];
    }

    public ByteVector(int i) {
        this.a = new byte[i];
    }

    private void a(int i) {
        byte[] bArr = this.a;
        int length = bArr.length * 2;
        int i2 = this.b;
        int i3 = i + i2;
        if (length <= i3) {
            length = i3;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.a = bArr2;
    }

    /* access modifiers changed from: package-private */
    public ByteVector a(int i, int i2) {
        int i3 = this.b;
        if (i3 + 2 > this.a.length) {
            a(2);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.b = i4 + 1;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ByteVector b(int i, int i2) {
        int i3 = this.b;
        if (i3 + 3 > this.a.length) {
            a(3);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.b = i5 + 1;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ByteVector c(String str, int i, int i2) {
        int i3;
        int length = str.length();
        int i4 = i;
        int i5 = i4;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            i5 = (charAt < 1 || charAt > 127) ? charAt > 2047 ? i5 + 3 : i5 + 2 : i5 + 1;
            i4++;
        }
        if (i5 <= i2) {
            int i6 = this.b;
            int i7 = (i6 - i) - 2;
            if (i7 >= 0) {
                byte[] bArr = this.a;
                bArr[i7] = (byte) (i5 >>> 8);
                bArr[i7 + 1] = (byte) i5;
            }
            if ((i6 + i5) - i > this.a.length) {
                a(i5 - i);
            }
            int i8 = this.b;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 1 || charAt2 > 127) {
                    byte[] bArr2 = this.a;
                    int i9 = i8 + 1;
                    if (charAt2 > 2047) {
                        bArr2[i8] = (byte) (((charAt2 >> '\f') & 15) | 224);
                        int i10 = i9 + 1;
                        bArr2[i9] = (byte) (((charAt2 >> 6) & 63) | 128);
                        i3 = i10 + 1;
                        bArr2[i10] = (byte) ((charAt2 & '?') | 128);
                    } else {
                        bArr2[i8] = (byte) (((charAt2 >> 6) & 31) | Opcodes.CHECKCAST);
                        i8 = i9 + 1;
                        bArr2[i9] = (byte) ((charAt2 & '?') | 128);
                        i++;
                    }
                } else {
                    i3 = i8 + 1;
                    this.a[i8] = (byte) charAt2;
                }
                i8 = i3;
                i++;
            }
            this.b = i8;
            return this;
        }
        throw new IllegalArgumentException();
    }

    public ByteVector putByte(int i) {
        int i2 = this.b;
        int i3 = i2 + 1;
        if (i3 > this.a.length) {
            a(1);
        }
        this.a[i2] = (byte) i;
        this.b = i3;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i, int i2) {
        if (this.b + i2 > this.a.length) {
            a(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.a, this.b, i2);
        }
        this.b += i2;
        return this;
    }

    public ByteVector putInt(int i) {
        int i2 = this.b;
        if (i2 + 4 > this.a.length) {
            a(4);
        }
        byte[] bArr = this.a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.b = i5 + 1;
        return this;
    }

    public ByteVector putLong(long j) {
        int i = this.b;
        if (i + 8 > this.a.length) {
            a(8);
        }
        byte[] bArr = this.a;
        int i2 = (int) (j >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        bArr[i10] = (byte) i7;
        this.b = i10 + 1;
        return this;
    }

    public ByteVector putShort(int i) {
        int i2 = this.b;
        if (i2 + 2 > this.a.length) {
            a(2);
        }
        byte[] bArr = this.a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.b = i3 + 1;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int length = str.length();
        if (length <= 65535) {
            int i = this.b;
            if (i + 2 + length > this.a.length) {
                a(length + 2);
            }
            byte[] bArr = this.a;
            int i2 = i + 1;
            bArr[i] = (byte) (length >>> 8);
            int i3 = i2 + 1;
            bArr[i2] = (byte) length;
            int i4 = 0;
            while (i4 < length) {
                char charAt = str.charAt(i4);
                if (charAt < 1 || charAt > 127) {
                    this.b = i3;
                    return c(str, i4, SupportMenu.USER_MASK);
                }
                bArr[i3] = (byte) charAt;
                i4++;
                i3++;
            }
            this.b = i3;
            return this;
        }
        throw new IllegalArgumentException();
    }
}
