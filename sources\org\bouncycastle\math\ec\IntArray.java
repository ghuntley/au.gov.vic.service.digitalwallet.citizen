package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* access modifiers changed from: package-private */
public class IntArray {
    private int[] m_ints;

    public IntArray(int i) {
        this.m_ints = new int[i];
    }

    public IntArray(BigInteger bigInteger) {
        this(bigInteger, 0);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0063 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v2, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: int */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: byte */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public IntArray(BigInteger bigInteger, int i) {
        int i2;
        if (bigInteger.signum() == -1) {
            throw new IllegalArgumentException("Only positive Integers allowed");
        } else if (bigInteger.equals(ECConstants.ZERO)) {
            this.m_ints = new int[]{0};
        } else {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (byteArray[0] == 0) {
                length--;
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i3 = (length + 3) / 4;
            if (i3 < i) {
                this.m_ints = new int[i];
            } else {
                this.m_ints = new int[i3];
            }
            int i4 = i3 - 1;
            int i5 = (length % 4) + i2;
            if (i2 < i5) {
                int i6 = 0;
                while (i2 < i5) {
                    int i7 = i6 << 8;
                    byte b = byteArray[i2];
                    if (b < 0) {
                        b += 256;
                    }
                    i6 = i7 | (b == true ? 1 : 0);
                    i2++;
                }
                this.m_ints[i4] = i6;
                i4--;
            }
            while (i4 >= 0) {
                int i8 = 0;
                int i9 = 0;
                while (i8 < 4) {
                    int i10 = i9 << 8;
                    int i11 = i2 + 1;
                    byte b2 = byteArray[i2];
                    if (b2 < 0) {
                        b2 += 256;
                    }
                    i9 = i10 | (b2 == true ? 1 : 0);
                    i8++;
                    i2 = i11;
                }
                this.m_ints[i4] = i9;
                i4--;
            }
        }
    }

    public IntArray(int[] iArr) {
        this.m_ints = iArr;
    }

    private int[] resizedInts(int i) {
        int[] iArr = new int[i];
        int[] iArr2 = this.m_ints;
        int length = iArr2.length;
        if (length < i) {
            i = length;
        }
        System.arraycopy(iArr2, 0, iArr, 0, i);
        return iArr;
    }

    public void addShifted(IntArray intArray, int i) {
        int usedLength = intArray.getUsedLength();
        int i2 = usedLength + i;
        if (i2 > this.m_ints.length) {
            this.m_ints = resizedInts(i2);
        }
        for (int i3 = 0; i3 < usedLength; i3++) {
            int[] iArr = this.m_ints;
            int i4 = i3 + i;
            iArr[i4] = iArr[i4] ^ intArray.m_ints[i3];
        }
    }

    public int bitLength() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return 0;
        }
        int i = usedLength - 1;
        int i2 = this.m_ints[i];
        int i3 = (i << 5) + 1;
        if ((-65536 & i2) != 0) {
            if ((-16777216 & i2) != 0) {
                i3 += 24;
                i2 >>>= 24;
            } else {
                i3 += 16;
                i2 >>>= 16;
            }
        } else if (i2 > 255) {
            i3 += 8;
            i2 >>>= 8;
        }
        while (i2 != 1) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    public Object clone() {
        return new IntArray(Arrays.clone(this.m_ints));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray) obj;
        int usedLength = getUsedLength();
        if (intArray.getUsedLength() != usedLength) {
            return false;
        }
        for (int i = 0; i < usedLength; i++) {
            if (this.m_ints[i] != intArray.m_ints[i]) {
                return false;
            }
        }
        return true;
    }

    public void flipBit(int i) {
        int i2 = i >> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public int getLength() {
        return this.m_ints.length;
    }

    public int getUsedLength() {
        int[] iArr = this.m_ints;
        int length = iArr.length;
        if (length < 1) {
            return 0;
        }
        if (iArr[0] != 0) {
            do {
                length--;
            } while (this.m_ints[length] == 0);
            return length + 1;
        }
        do {
            length--;
            if (this.m_ints[length] != 0) {
                return length + 1;
            }
        } while (length > 0);
        return 0;
    }

    public int hashCode() {
        int usedLength = getUsedLength();
        int i = 1;
        for (int i2 = 0; i2 < usedLength; i2++) {
            i = (i * 31) + this.m_ints[i2];
        }
        return i;
    }

    public boolean isZero() {
        int[] iArr = this.m_ints;
        return iArr.length == 0 || (iArr[0] == 0 && getUsedLength() == 0);
    }

    public IntArray multiply(IntArray intArray, int i) {
        int i2 = (i + 31) >> 5;
        if (this.m_ints.length < i2) {
            this.m_ints = resizedInts(i2);
        }
        int i3 = 1;
        IntArray intArray2 = new IntArray(intArray.resizedInts(intArray.getLength() + 1));
        IntArray intArray3 = new IntArray(((i + i) + 31) >> 5);
        for (int i4 = 0; i4 < 32; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                if ((this.m_ints[i5] & i3) != 0) {
                    intArray3.addShifted(intArray2, i5);
                }
            }
            i3 <<= 1;
            intArray2.shiftLeft();
        }
        return intArray3;
    }

    public void reduce(int i, int[] iArr) {
        for (int i2 = (i + i) - 2; i2 >= i; i2--) {
            if (testBit(i2)) {
                int i3 = i2 - i;
                flipBit(i3);
                flipBit(i2);
                int length = iArr.length;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    flipBit(iArr[length] + i3);
                }
            }
        }
        this.m_ints = resizedInts((i + 31) >> 5);
    }

    public void setBit(int i) {
        int i2 = i >> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public IntArray shiftLeft(int i) {
        int usedLength = getUsedLength();
        if (usedLength == 0 || i == 0) {
            return this;
        }
        if (i <= 31) {
            int[] iArr = new int[(usedLength + 1)];
            int i2 = 32 - i;
            iArr[0] = this.m_ints[0] << i;
            for (int i3 = 1; i3 < usedLength; i3++) {
                int[] iArr2 = this.m_ints;
                iArr[i3] = (iArr2[i3 - 1] >>> i2) | (iArr2[i3] << i);
            }
            iArr[usedLength] = this.m_ints[usedLength - 1] >>> i2;
            return new IntArray(iArr);
        }
        throw new IllegalArgumentException("shiftLeft() for max 31 bits , " + i + "bit shift is not possible");
    }

    public void shiftLeft() {
        int usedLength = getUsedLength();
        if (usedLength != 0) {
            int[] iArr = this.m_ints;
            if (iArr[usedLength - 1] < 0 && (usedLength = usedLength + 1) > iArr.length) {
                this.m_ints = resizedInts(iArr.length + 1);
            }
            int i = 0;
            boolean z = false;
            while (i < usedLength) {
                int[] iArr2 = this.m_ints;
                boolean z2 = iArr2[i] < 0;
                iArr2[i] = iArr2[i] << 1;
                if (z) {
                    iArr2[i] = iArr2[i] | 1;
                }
                i++;
                z = z2;
            }
        }
    }

    public IntArray square(int i) {
        int[] iArr = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85};
        int i2 = (i + 31) >> 5;
        if (this.m_ints.length < i2) {
            this.m_ints = resizedInts(i2);
        }
        IntArray intArray = new IntArray(i2 + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < 4; i5++) {
                i4 = (i4 >>> 8) | (iArr[(this.m_ints[i3] >>> (i5 * 4)) & 15] << 24);
            }
            int i6 = i3 + i3;
            intArray.m_ints[i6] = i4;
            int i7 = this.m_ints[i3] >>> 16;
            int i8 = 0;
            for (int i9 = 0; i9 < 4; i9++) {
                i8 = (i8 >>> 8) | (iArr[(i7 >>> (i9 * 4)) & 15] << 24);
            }
            intArray.m_ints[i6 + 1] = i8;
        }
        return intArray;
    }

    public boolean testBit(int i) {
        return ((1 << (i & 31)) & this.m_ints[i >> 5]) != 0;
    }

    public BigInteger toBigInteger() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return ECConstants.ZERO;
        }
        int i = usedLength - 1;
        int i2 = this.m_ints[i];
        byte[] bArr = new byte[4];
        int i3 = 0;
        boolean z = false;
        for (int i4 = 3; i4 >= 0; i4--) {
            byte b = (byte) (i2 >>> (i4 * 8));
            if (z || b != 0) {
                bArr[i3] = b;
                i3++;
                z = true;
            }
        }
        byte[] bArr2 = new byte[((i * 4) + i3)];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i5] = bArr[i5];
        }
        for (int i6 = usedLength - 2; i6 >= 0; i6--) {
            int i7 = 3;
            while (i7 >= 0) {
                bArr2[i3] = (byte) (this.m_ints[i6] >>> (i7 * 8));
                i7--;
                i3++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    public String toString() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer(Integer.toBinaryString(this.m_ints[usedLength - 1]));
        for (int i = usedLength - 2; i >= 0; i--) {
            String binaryString = Integer.toBinaryString(this.m_ints[i]);
            for (int length = binaryString.length(); length < 8; length++) {
                binaryString = "0" + binaryString;
            }
            stringBuffer.append(binaryString);
        }
        return stringBuffer.toString();
    }
}
