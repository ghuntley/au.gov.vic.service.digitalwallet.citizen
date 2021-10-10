package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;

public class Base64Encoder implements Encoder {
    protected final byte[] decodingTable = new byte[128];
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected byte padding = 61;

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c, char c2, char c3, char c4) throws IOException {
        byte b = this.padding;
        if (c3 == b) {
            byte[] bArr = this.decodingTable;
            outputStream.write((bArr[c] << 2) | (bArr[c2] >> 4));
            return 1;
        } else if (c4 == b) {
            byte[] bArr2 = this.decodingTable;
            byte b2 = bArr2[c];
            byte b3 = bArr2[c2];
            byte b4 = bArr2[c3];
            outputStream.write((b2 << 2) | (b3 >> 4));
            outputStream.write((b3 << 4) | (b4 >> 2));
            return 2;
        } else {
            byte[] bArr3 = this.decodingTable;
            byte b5 = bArr3[c];
            byte b6 = bArr3[c2];
            byte b7 = bArr3[c3];
            byte b8 = bArr3[c4];
            outputStream.write((b5 << 2) | (b6 >> 4));
            outputStream.write((b6 << 4) | (b7 >> 2));
            outputStream.write((b7 << 6) | b8);
            return 3;
        }
    }

    private boolean ignore(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    private int nextI(String str, int i, int i2) {
        while (i < i2 && ignore(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private int nextI(byte[] bArr, int i, int i2) {
        while (i < i2 && ignore((char) bArr[i])) {
            i++;
        }
        return i;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i = length - 4;
        int i2 = 0;
        int nextI = nextI(str, 0, i);
        while (nextI < i) {
            int i3 = nextI + 1;
            byte b = this.decodingTable[str.charAt(nextI)];
            int nextI2 = nextI(str, i3, i);
            int i4 = nextI2 + 1;
            byte b2 = this.decodingTable[str.charAt(nextI2)];
            int nextI3 = nextI(str, i4, i);
            int i5 = nextI3 + 1;
            byte b3 = this.decodingTable[str.charAt(nextI3)];
            int nextI4 = nextI(str, i5, i);
            int i6 = nextI4 + 1;
            byte b4 = this.decodingTable[str.charAt(nextI4)];
            outputStream.write((b << 2) | (b2 >> 4));
            outputStream.write((b2 << 4) | (b3 >> 2));
            outputStream.write((b3 << 6) | b4);
            i2 += 3;
            nextI = nextI(str, i6, i);
        }
        return i2 + decodeLastBlock(outputStream, str.charAt(i), str.charAt(length - 3), str.charAt(length - 2), str.charAt(length - 1));
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3 = i2 + i;
        while (i3 > i && ignore((char) bArr[i3 - 1])) {
            i3--;
        }
        int i4 = i3 - 4;
        int nextI = nextI(bArr, i, i4);
        int i5 = 0;
        while (nextI < i4) {
            int i6 = nextI + 1;
            byte b = this.decodingTable[bArr[nextI]];
            int nextI2 = nextI(bArr, i6, i4);
            int i7 = nextI2 + 1;
            byte b2 = this.decodingTable[bArr[nextI2]];
            int nextI3 = nextI(bArr, i7, i4);
            int i8 = nextI3 + 1;
            byte b3 = this.decodingTable[bArr[nextI3]];
            int nextI4 = nextI(bArr, i8, i4);
            int i9 = nextI4 + 1;
            byte b4 = this.decodingTable[bArr[nextI4]];
            outputStream.write((b << 2) | (b2 >> 4));
            outputStream.write((b2 << 4) | (b3 >> 2));
            outputStream.write((b3 << 6) | b4);
            i5 += 3;
            nextI = nextI(bArr, i9, i4);
        }
        return i5 + decodeLastBlock(outputStream, (char) bArr[i4], (char) bArr[i3 - 3], (char) bArr[i3 - 2], (char) bArr[i3 - 1]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00a3  */
    @Override // org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3;
        int i4;
        byte b;
        int i5 = i2 % 3;
        int i6 = i2 - i5;
        int i7 = i;
        while (true) {
            i3 = i + i6;
            i4 = 4;
            if (i7 >= i3) {
                break;
            }
            int i8 = bArr[i7] & UByte.MAX_VALUE;
            int i9 = bArr[i7 + 1] & UByte.MAX_VALUE;
            int i10 = bArr[i7 + 2] & UByte.MAX_VALUE;
            outputStream.write(this.encodingTable[(i8 >>> 2) & 63]);
            outputStream.write(this.encodingTable[((i8 << 4) | (i9 >>> 4)) & 63]);
            outputStream.write(this.encodingTable[((i9 << 2) | (i10 >>> 6)) & 63]);
            outputStream.write(this.encodingTable[i10 & 63]);
            i7 += 3;
        }
        if (i5 != 1) {
            if (i5 == 2) {
                int i11 = bArr[i3] & UByte.MAX_VALUE;
                int i12 = bArr[i3 + 1] & UByte.MAX_VALUE;
                outputStream.write(this.encodingTable[(i11 >>> 2) & 63]);
                outputStream.write(this.encodingTable[((i11 << 4) | (i12 >>> 4)) & 63]);
                b = this.encodingTable[(i12 << 2) & 63];
            }
            int i13 = (i6 / 3) * 4;
            if (i5 == 0) {
                i4 = 0;
            }
            return i13 + i4;
        }
        int i14 = bArr[i3] & UByte.MAX_VALUE;
        outputStream.write(this.encodingTable[(i14 >>> 2) & 63]);
        outputStream.write(this.encodingTable[(i14 << 4) & 63]);
        b = this.padding;
        outputStream.write(b);
        outputStream.write(this.padding);
        int i132 = (i6 / 3) * 4;
        if (i5 == 0) {
        }
        return i132 + i4;
    }

    /* access modifiers changed from: protected */
    public void initialiseDecodingTable() {
        int i = 0;
        while (true) {
            byte[] bArr = this.encodingTable;
            if (i < bArr.length) {
                this.decodingTable[bArr[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }
}
