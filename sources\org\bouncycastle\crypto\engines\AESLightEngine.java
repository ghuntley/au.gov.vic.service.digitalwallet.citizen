package org.bouncycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.reflect.Array;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import net.minidev.json.parser.JSONParserBase;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.math.ec.Tnaf;
import org.msgpack.core.MessagePack;
import org.objectweb.asm.Opcodes;

public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, MessagePack.Code.BIN16, 48, 1, 103, 43, -2, MessagePack.Code.FIXEXT8, -85, 118, MessagePack.Code.FLOAT32, -126, MessagePack.Code.EXT32, 125, -6, 89, 71, -16, -83, MessagePack.Code.FIXEXT1, -94, -81, -100, -92, 114, MessagePack.Code.NIL, -73, -3, -109, 38, 54, 63, -9, MessagePack.Code.UINT8, 52, -91, -27, -15, 113, MessagePack.Code.FIXEXT16, 49, 21, 4, MessagePack.Code.EXT8, 35, MessagePack.Code.TRUE, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, JSONParserBase.EOI, 27, 110, 90, MessagePack.Code.FIXSTR_PREFIX, 82, 59, MessagePack.Code.FIXEXT4, -77, 41, -29, 47, -124, 83, MessagePack.Code.INT16, 0, -19, 32, -4, -79, 91, 106, MessagePack.Code.FLOAT64, -66, 57, 74, 76, 88, MessagePack.Code.UINT64, MessagePack.Code.INT8, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, MessagePack.Code.STR16, 33, Tnaf.POW_2_WIDTH, -1, -13, MessagePack.Code.INT32, MessagePack.Code.UINT16, 12, 19, -20, 95, -105, 68, 23, MessagePack.Code.BIN8, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, MessagePack.Code.ARRAY16, 34, 42, MessagePack.Code.FIXARRAY_PREFIX, -120, 70, -18, -72, 20, MessagePack.Code.MAP16, 94, 11, MessagePack.Code.STR32, MessagePack.Code.NEGFIXINT_PREFIX, 50, 58, 10, 73, 6, 36, 92, MessagePack.Code.FALSE, MessagePack.Code.INT64, -84, 98, -111, -107, -28, 121, -25, MessagePack.Code.EXT16, 55, 109, -115, MessagePack.Code.FIXEXT2, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, MessagePack.Code.BIN32, -24, MessagePack.Code.ARRAY32, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, MessagePack.Code.NEVER_USED, 29, -98, -31, -8, -104, 17, 105, MessagePack.Code.STR8, -114, -108, -101, 30, -121, -23, MessagePack.Code.UINT32, 85, 40, MessagePack.Code.MAP32, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, MessagePack.Code.FIXEXT2, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, MessagePack.Code.FIXEXT8, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, MessagePack.Code.BIN8, MessagePack.Code.MAP16, -23, MessagePack.Code.FLOAT64, 84, 123, -108, 50, -90, MessagePack.Code.FALSE, 35, 61, -18, 76, -107, 11, 66, -6, MessagePack.Code.TRUE, 78, 8, 46, -95, 102, 40, MessagePack.Code.STR8, 36, -78, 118, 91, -94, 73, 109, -117, MessagePack.Code.INT16, 37, 114, -8, -10, 100, -122, 104, -104, 22, MessagePack.Code.FIXEXT1, -92, 92, MessagePack.Code.UINT8, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, MessagePack.Code.STR16, 94, 21, 70, 87, -89, -115, -99, -124, MessagePack.Code.FIXARRAY_PREFIX, MessagePack.Code.FIXEXT16, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, MessagePack.Code.INT64, 10, -9, -28, 88, 5, -72, -77, 69, 6, MessagePack.Code.INT8, 44, 30, -113, MessagePack.Code.FLOAT32, 63, 15, 2, MessagePack.Code.NEVER_USED, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, MessagePack.Code.ARRAY16, -22, -105, -14, MessagePack.Code.UINT64, MessagePack.Code.UINT32, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, MessagePack.Code.MAP32, 110, 71, -15, JSONParserBase.EOI, 113, 29, 41, MessagePack.Code.BIN16, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, MessagePack.Code.BIN32, MessagePack.Code.INT32, 121, 32, -102, MessagePack.Code.STR32, MessagePack.Code.NIL, -2, 120, MessagePack.Code.UINT16, 90, -12, 31, MessagePack.Code.ARRAY32, -88, 51, -120, 7, MessagePack.Code.EXT8, 49, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, MessagePack.Code.EXT32, -100, -17, MessagePack.Code.FIXSTR_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, 59, 77, -82, 42, -11, -80, MessagePack.Code.EXT16, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, MessagePack.Code.FIXEXT4, 38, -31, 105, 20, 99, 85, 33, 12, 125};
    private static final int m1 = -2139062144;
    private static final int m2 = 2139062143;
    private static final int m3 = 27;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, Opcodes.LOOKUPSWITCH, 77, Opcodes.IFNE, 47, 94, 188, 99, Opcodes.IFNULL, Opcodes.DCMPL, 53, 106, 212, Opcodes.PUTSTATIC, Opcodes.LUSHR, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, Opcodes.MULTIANEWARRAY, 145};
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    private int FFmulX(int i) {
        return (((i & m1) >>> 7) * 27) ^ ((m2 & i) << 1);
    }

    private void decryptBlock(int[][] iArr) {
        int i = this.C0;
        int i2 = this.ROUNDS;
        this.C0 = i ^ iArr[i2][0];
        this.C1 ^= iArr[i2][1];
        this.C2 ^= iArr[i2][2];
        this.C3 ^= iArr[i2][3];
        int i3 = i2 - 1;
        while (true) {
            byte[] bArr = Si;
            int i4 = this.C0 & 255;
            if (i3 > 1) {
                int inv_mcol = inv_mcol((((bArr[i4] & UByte.MAX_VALUE) ^ ((bArr[(this.C3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C1 >> 24) & 255] << 24)) ^ iArr[i3][0];
                int inv_mcol2 = inv_mcol((((bArr[this.C1 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C0 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C2 >> 24) & 255] << 24)) ^ iArr[i3][1];
                int inv_mcol3 = inv_mcol((((bArr[this.C2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C1 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C0 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C3 >> 24) & 255] << 24)) ^ iArr[i3][2];
                int i5 = i3 - 1;
                int inv_mcol4 = iArr[i3][3] ^ inv_mcol((((bArr[this.C3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C1 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C0 >> 24) & 255] << 24));
                this.C0 = inv_mcol((((bArr[inv_mcol & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol2 >> 24) & 255] << 24)) ^ iArr[i5][0];
                this.C1 = inv_mcol((((bArr[inv_mcol2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol4 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol3 >> 24) & 255] << 24)) ^ iArr[i5][1];
                this.C2 = inv_mcol((((bArr[inv_mcol3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol4 >> 24) & 255] << 24)) ^ iArr[i5][2];
                i3 = i5 - 1;
                this.C3 = inv_mcol((bArr[(inv_mcol >> 24) & 255] << 24) ^ (((bArr[inv_mcol4 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol2 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i5][3];
            } else {
                int inv_mcol5 = inv_mcol((((bArr[i4] & UByte.MAX_VALUE) ^ ((bArr[(this.C3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C1 >> 24) & 255] << 24)) ^ iArr[i3][0];
                int inv_mcol6 = inv_mcol((((bArr[this.C1 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C0 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C2 >> 24) & 255] << 24)) ^ iArr[i3][1];
                int inv_mcol7 = inv_mcol((((bArr[this.C2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C1 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C0 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C3 >> 24) & 255] << 24)) ^ iArr[i3][2];
                int inv_mcol8 = iArr[i3][3] ^ inv_mcol((((bArr[this.C3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C1 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C0 >> 24) & 255] << 24));
                this.C0 = ((((bArr[inv_mcol5 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol8 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol7 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol6 >> 24) & 255] << 24)) ^ iArr[0][0];
                this.C1 = iArr[0][1] ^ ((((bArr[inv_mcol6 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol8 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol7 >> 24) & 255] << 24));
                this.C2 = ((((bArr[inv_mcol7 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol6 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol8 >> 24) & 255] << 24)) ^ iArr[0][2];
                this.C3 = iArr[0][3] ^ ((bArr[(inv_mcol5 >> 24) & 255] << 24) ^ (((bArr[inv_mcol8 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol6 >> 16) & 255] & UByte.MAX_VALUE) << 16)));
                return;
            }
        }
    }

    private void encryptBlock(int[][] iArr) {
        this.C0 ^= iArr[0][0];
        this.C1 ^= iArr[0][1];
        this.C2 ^= iArr[0][2];
        this.C3 ^= iArr[0][3];
        int i = 1;
        while (i < this.ROUNDS - 1) {
            byte[] bArr = S;
            int mcol = mcol((((bArr[this.C0 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C1 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C3 >> 24) & 255] << 24)) ^ iArr[i][0];
            int mcol2 = mcol((((bArr[this.C1 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C0 >> 24) & 255] << 24)) ^ iArr[i][1];
            int mcol3 = mcol((((bArr[this.C2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C0 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C1 >> 24) & 255] << 24)) ^ iArr[i][2];
            int i2 = i + 1;
            int mcol4 = iArr[i][3] ^ mcol((((bArr[this.C3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(this.C0 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(this.C1 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(this.C2 >> 24) & 255] << 24));
            this.C0 = mcol((((bArr[mcol & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol4 >> 24) & 255] << 24)) ^ iArr[i2][0];
            this.C1 = mcol((((bArr[mcol2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol4 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol >> 24) & 255] << 24)) ^ iArr[i2][1];
            this.C2 = mcol((((bArr[mcol3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol2 >> 24) & 255] << 24)) ^ iArr[i2][2];
            this.C3 = mcol((((bArr[mcol4 & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol3 >> 24) & 255] << 24)) ^ iArr[i2][3];
            i = i2 + 1;
        }
        byte[] bArr2 = S;
        int mcol5 = mcol((((bArr2[this.C0 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(this.C1 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(this.C2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(this.C3 >> 24) & 255] << 24)) ^ iArr[i][0];
        int mcol6 = mcol((((bArr2[this.C1 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(this.C2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(this.C3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(this.C0 >> 24) & 255] << 24)) ^ iArr[i][1];
        int mcol7 = mcol((((bArr2[this.C2 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(this.C3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(this.C0 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(this.C1 >> 24) & 255] << 24)) ^ iArr[i][2];
        int i3 = i + 1;
        int mcol8 = iArr[i][3] ^ mcol((((bArr2[this.C3 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(this.C0 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(this.C1 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(this.C2 >> 24) & 255] << 24));
        this.C0 = iArr[i3][0] ^ ((((bArr2[mcol5 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol6 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol7 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol8 >> 24) & 255] << 24));
        this.C1 = ((((bArr2[mcol6 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol8 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol5 >> 24) & 255] << 24)) ^ iArr[i3][1];
        this.C2 = ((((bArr2[mcol7 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol8 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol6 >> 24) & 255] << 24)) ^ iArr[i3][2];
        this.C3 = iArr[i3][3] ^ ((((bArr2[mcol8 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol6 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol7 >> 24) & 255] << 24));
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            int i = length + 6;
            this.ROUNDS = i;
            int[] iArr = new int[2];
            iArr[1] = 4;
            iArr[0] = i + 1;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            int i2 = 0;
            int i3 = 0;
            while (i2 < bArr.length) {
                iArr2[i3 >> 2][i3 & 3] = (bArr[i2] & UByte.MAX_VALUE) | ((bArr[i2 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UByte.MAX_VALUE) << 16) | (bArr[i2 + 3] << 24);
                i2 += 4;
                i3++;
            }
            int i4 = (this.ROUNDS + 1) << 2;
            for (int i5 = length; i5 < i4; i5++) {
                int i6 = i5 - 1;
                int i7 = iArr2[i6 >> 2][i6 & 3];
                int i8 = i5 % length;
                if (i8 == 0) {
                    i7 = subWord(shift(i7, 8)) ^ rcon[(i5 / length) - 1];
                } else if (length > 6 && i8 == 4) {
                    i7 = subWord(i7);
                }
                int i9 = i5 - length;
                iArr2[i5 >> 2][i5 & 3] = i7 ^ iArr2[i9 >> 2][i9 & 3];
            }
            if (!z) {
                for (int i10 = 1; i10 < this.ROUNDS; i10++) {
                    for (int i11 = 0; i11 < 4; i11++) {
                        iArr2[i10][i11] = inv_mcol(iArr2[i10][i11]);
                    }
                }
            }
            return iArr2;
        }
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    private int inv_mcol(int i) {
        int FFmulX = FFmulX(i);
        int FFmulX2 = FFmulX(FFmulX);
        int FFmulX3 = FFmulX(FFmulX2);
        int i2 = i ^ FFmulX3;
        int shift = shift(FFmulX ^ i2, 8);
        return shift(i2, 24) ^ ((shift ^ (FFmulX3 ^ (FFmulX ^ FFmulX2))) ^ shift(FFmulX2 ^ i2, 16));
    }

    private int mcol(int i) {
        int FFmulX = FFmulX(i);
        return shift(i, 24) ^ ((FFmulX ^ shift(i ^ FFmulX, 8)) ^ shift(i, 16));
    }

    private void packBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.C0;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.C1;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.C2;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.C3;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    private int shift(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private int subWord(int i) {
        byte[] bArr = S;
        return (bArr[(i >> 24) & 255] << 24) | (bArr[i & 255] & UByte.MAX_VALUE) | ((bArr[(i >> 8) & 255] & UByte.MAX_VALUE) << 8) | ((bArr[(i >> 16) & 255] & UByte.MAX_VALUE) << 16);
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i] & UByte.MAX_VALUE;
        this.C0 = i3;
        int i4 = i2 + 1;
        int i5 = i3 | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        this.C0 = i5;
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & UByte.MAX_VALUE) << 16);
        this.C0 = i7;
        int i8 = i6 + 1;
        this.C0 = i7 | (bArr[i6] << 24);
        int i9 = i8 + 1;
        int i10 = bArr[i8] & UByte.MAX_VALUE;
        this.C1 = i10;
        int i11 = i9 + 1;
        int i12 = ((bArr[i9] & UByte.MAX_VALUE) << 8) | i10;
        this.C1 = i12;
        int i13 = i11 + 1;
        int i14 = i12 | ((bArr[i11] & UByte.MAX_VALUE) << 16);
        this.C1 = i14;
        int i15 = i13 + 1;
        this.C1 = i14 | (bArr[i13] << 24);
        int i16 = i15 + 1;
        int i17 = bArr[i15] & UByte.MAX_VALUE;
        this.C2 = i17;
        int i18 = i16 + 1;
        int i19 = ((bArr[i16] & UByte.MAX_VALUE) << 8) | i17;
        this.C2 = i19;
        int i20 = i18 + 1;
        int i21 = i19 | ((bArr[i18] & UByte.MAX_VALUE) << 16);
        this.C2 = i21;
        int i22 = i20 + 1;
        this.C2 = i21 | (bArr[i20] << 24);
        int i23 = i22 + 1;
        int i24 = bArr[i22] & UByte.MAX_VALUE;
        this.C3 = i24;
        int i25 = i23 + 1;
        int i26 = ((bArr[i23] & UByte.MAX_VALUE) << 8) | i24;
        this.C3 = i26;
        int i27 = i26 | ((bArr[i25] & UByte.MAX_VALUE) << 16);
        this.C3 = i27;
        this.C3 = (bArr[i25 + 1] << 24) | i27;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "AES";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.WorkingKey == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            boolean z = this.forEncryption;
            unpackBlock(bArr, i);
            int[][] iArr = this.WorkingKey;
            if (z) {
                encryptBlock(iArr);
            } else {
                decryptBlock(iArr);
            }
            packBlock(bArr2, i2);
            return 16;
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
