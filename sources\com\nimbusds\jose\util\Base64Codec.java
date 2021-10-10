package com.nimbusds.jose.util;

import java.util.Arrays;
import kotlin.UByte;
import org.msgpack.core.MessagePack;

/* access modifiers changed from: package-private */
public final class Base64Codec {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static int tpEq(int i, int i2) {
        int i3 = i ^ i2;
        return ((~i3) & (i3 - 1)) >>> 63;
    }

    static int tpGT(int i, int i2) {
        return (int) ((((long) i2) - ((long) i)) >>> 63);
    }

    static int tpLT(int i, int i2) {
        return (int) ((((long) i) - ((long) i2)) >>> 63);
    }

    static int tpSelect(int i, int i2, int i3) {
        return ((i - 1) & (i3 ^ i2)) ^ i2;
    }

    Base64Codec() {
    }

    static int computeEncodedLength(int i, boolean z) {
        if (i == 0) {
            return 0;
        }
        if (!z) {
            return (((i - 1) / 3) + 1) << 2;
        }
        int i2 = (i / 3) << 2;
        int i3 = i % 3;
        return i3 == 0 ? i2 : i2 + i3 + 1;
    }

    static byte encodeDigitBase64(int i) {
        int tpLT = tpLT(i, 26);
        int tpGT = tpGT(i, 25) & tpLT(i, 52);
        int tpGT2 = tpGT(i, 51) & tpLT(i, 62);
        int tpEq = tpEq(i, 62);
        int tpEq2 = tpEq(i, 63);
        return (byte) (tpSelect(tpGT2, (i - 52) + 48, 0) | tpSelect(tpLT, i + 0 + 65, 0) | tpSelect(tpGT, (i - 26) + 97, 0) | tpSelect(tpEq, 43, 0) | tpSelect(tpEq2, 47, 0));
    }

    static byte encodeDigitBase64URL(int i) {
        int tpLT = tpLT(i, 26);
        int tpGT = tpGT(i, 25) & tpLT(i, 52);
        int tpGT2 = tpGT(i, 51) & tpLT(i, 62);
        int tpEq = tpEq(i, 62);
        int tpEq2 = tpEq(i, 63);
        return (byte) (tpSelect(tpGT2, (i - 52) + 48, 0) | tpSelect(tpLT, i + 0 + 65, 0) | tpSelect(tpGT, (i - 26) + 97, 0) | tpSelect(tpEq, 45, 0) | tpSelect(tpEq2, 95, 0));
    }

    static int decodeDigit(byte b) {
        int tpGT = tpGT(b, 64) & tpLT(b, 91);
        int tpGT2 = tpGT(b, 96) & tpLT(b, 123);
        int tpGT3 = tpGT(b, 47) & tpLT(b, 58);
        int tpEq = tpEq(b, 45) | tpEq(b, 43);
        int tpEq2 = tpEq(b, 47) | tpEq(b, 95);
        return tpSelect(tpGT3, b + MessagePack.Code.INT8 + 52, 0) | tpSelect(tpGT, (b - 65) + 0, 0) | tpSelect(tpGT2, (b - 97) + 26, 0) | tpSelect(tpEq, 62, 0) | tpSelect(tpEq2, 63, 0) | tpSelect(tpGT | tpGT2 | tpGT3 | tpEq | tpEq2, 0, -1);
    }

    public static String encodeToString(byte[] bArr, boolean z) {
        int i = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return "";
        }
        int i2 = (length / 3) * 3;
        int computeEncodedLength = computeEncodedLength(length, z);
        byte[] bArr2 = new byte[computeEncodedLength];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            int i7 = ((bArr[i3] & UByte.MAX_VALUE) << 16) | ((bArr[i5] & UByte.MAX_VALUE) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & UByte.MAX_VALUE);
            if (z) {
                int i10 = i4 + 1;
                bArr2[i4] = encodeDigitBase64URL((i9 >>> 18) & 63);
                int i11 = i10 + 1;
                bArr2[i10] = encodeDigitBase64URL((i9 >>> 12) & 63);
                int i12 = i11 + 1;
                bArr2[i11] = encodeDigitBase64URL((i9 >>> 6) & 63);
                i4 = i12 + 1;
                bArr2[i12] = encodeDigitBase64URL(i9 & 63);
            } else {
                int i13 = i4 + 1;
                bArr2[i4] = encodeDigitBase64((i9 >>> 18) & 63);
                int i14 = i13 + 1;
                bArr2[i13] = encodeDigitBase64((i9 >>> 12) & 63);
                int i15 = i14 + 1;
                bArr2[i14] = encodeDigitBase64((i9 >>> 6) & 63);
                i4 = i15 + 1;
                bArr2[i15] = encodeDigitBase64(i9 & 63);
            }
            i3 = i8;
        }
        int i16 = length - i2;
        if (i16 > 0) {
            int i17 = (bArr[i2] & UByte.MAX_VALUE) << 10;
            if (i16 == 2) {
                i = (bArr[length - 1] & UByte.MAX_VALUE) << 2;
            }
            int i18 = i17 | i;
            if (!z) {
                bArr2[computeEncodedLength - 4] = encodeDigitBase64(i18 >> 12);
                bArr2[computeEncodedLength - 3] = encodeDigitBase64((i18 >>> 6) & 63);
                bArr2[computeEncodedLength - 2] = i16 == 2 ? encodeDigitBase64(i18 & 63) : 61;
                bArr2[computeEncodedLength - 1] = 61;
            } else if (i16 == 2) {
                bArr2[computeEncodedLength - 3] = encodeDigitBase64URL(i18 >> 12);
                bArr2[computeEncodedLength - 2] = encodeDigitBase64URL((i18 >>> 6) & 63);
                bArr2[computeEncodedLength - 1] = encodeDigitBase64URL(i18 & 63);
            } else {
                bArr2[computeEncodedLength - 2] = encodeDigitBase64URL(i18 >> 12);
                bArr2[computeEncodedLength - 1] = encodeDigitBase64URL((i18 >>> 6) & 63);
            }
        }
        return new String(bArr2, StandardCharset.UTF_8);
    }

    public static byte[] decode(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes(StandardCharset.UTF_8);
        int length = bytes.length;
        byte[] bArr = new byte[((length * 6) >> 3)];
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < 4 && i < length) {
                int i5 = i + 1;
                int decodeDigit = decodeDigit(bytes[i]);
                if (decodeDigit >= 0) {
                    i4 |= decodeDigit << (18 - (i3 * 6));
                    i3++;
                }
                i = i5;
            }
            if (i3 >= 2) {
                int i6 = i2 + 1;
                bArr[i2] = (byte) (i4 >> 16);
                if (i3 >= 3) {
                    i2 = i6 + 1;
                    bArr[i6] = (byte) (i4 >> 8);
                    if (i3 >= 4) {
                        bArr[i2] = (byte) i4;
                        i2++;
                    }
                } else {
                    i2 = i6;
                }
            }
        }
        return Arrays.copyOf(bArr, i2);
    }
}
