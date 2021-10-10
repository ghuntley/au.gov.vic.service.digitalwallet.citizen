package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import net.minidev.json.parser.JSONParserBase;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.math.ec.Tnaf;
import org.msgpack.core.MessagePack;

public class MD2Digest implements ExtendedDigest {
    private static final int DIGEST_LENGTH = 16;
    private static final byte[] S = {41, 46, 67, MessagePack.Code.EXT32, -94, MessagePack.Code.FIXEXT16, 124, 1, 61, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, MessagePack.Code.NIL, MessagePack.Code.EXT8, 115, -116, -104, -109, 43, MessagePack.Code.STR8, PSSSigner.TRAILER_IMPLICIT, 76, -126, MessagePack.Code.FLOAT32, 30, -101, 87, 60, -3, MessagePack.Code.FIXEXT1, MessagePack.Code.NEGFIXINT_PREFIX, 22, 103, 66, 111, 24, -118, 23, -27, 18, -66, 78, MessagePack.Code.BIN8, MessagePack.Code.FIXEXT4, MessagePack.Code.STR16, -98, MessagePack.Code.MAP16, 73, MessagePack.Code.FIXSTR_PREFIX, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, 63, -108, MessagePack.Code.FALSE, Tnaf.POW_2_WIDTH, -119, 11, 34, 95, 33, Byte.MIN_VALUE, ByteCompanionObject.MAX_VALUE, 93, -102, 90, MessagePack.Code.FIXARRAY_PREFIX, 50, 39, 53, 62, MessagePack.Code.UINT8, -25, -65, -9, -105, 3, -1, 25, 48, -77, 72, -91, -75, MessagePack.Code.INT16, MessagePack.Code.FIXEXT8, 94, -110, 42, -84, 86, -86, MessagePack.Code.BIN32, 79, -72, 56, MessagePack.Code.INT32, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, MessagePack.Code.UINT64, 101, -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, MessagePack.Code.ARRAY32, 81, -81, 58, MessagePack.Code.TRUE, 92, -7, MessagePack.Code.UINT32, -70, MessagePack.Code.BIN16, -22, 38, 44, 83, 13, 110, -123, 40, -124, 9, MessagePack.Code.INT64, MessagePack.Code.MAP32, MessagePack.Code.UINT16, -12, 65, -127, 77, 82, 106, MessagePack.Code.ARRAY16, 55, MessagePack.Code.EXT16, 108, MessagePack.Code.NEVER_USED, -85, -6, 36, -31, 123, 8, 12, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, MessagePack.Code.FLOAT64, MessagePack.Code.FIXEXT2, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, MessagePack.Code.INT8, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, 31, JSONParserBase.EOI, MessagePack.Code.STR32, -103, -115, 51, -97, 17, -125, 20};
    private byte[] C;
    private int COff;
    private byte[] M;
    private byte[] X;
    private int mOff;
    private int xOff;

    public MD2Digest() {
        this.X = new byte[48];
        this.M = new byte[16];
        this.C = new byte[16];
        reset();
    }

    public MD2Digest(MD2Digest mD2Digest) {
        byte[] bArr = new byte[48];
        this.X = bArr;
        this.M = new byte[16];
        this.C = new byte[16];
        byte[] bArr2 = mD2Digest.X;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.xOff = mD2Digest.xOff;
        byte[] bArr3 = mD2Digest.M;
        System.arraycopy(bArr3, 0, this.M, 0, bArr3.length);
        this.mOff = mD2Digest.mOff;
        byte[] bArr4 = mD2Digest.C;
        System.arraycopy(bArr4, 0, this.C, 0, bArr4.length);
        this.COff = mD2Digest.COff;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        int length = this.M.length;
        int i2 = this.mOff;
        byte b = (byte) (length - i2);
        while (true) {
            byte[] bArr2 = this.M;
            if (i2 < bArr2.length) {
                bArr2[i2] = b;
                i2++;
            } else {
                processCheckSum(bArr2);
                processBlock(this.M);
                processBlock(this.C);
                System.arraycopy(this.X, this.xOff, bArr, i, 16);
                reset();
                return 16;
            }
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD2";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    /* access modifiers changed from: protected */
    public void processBlock(byte[] bArr) {
        for (int i = 0; i < 16; i++) {
            byte[] bArr2 = this.X;
            bArr2[i + 16] = bArr[i];
            bArr2[i + 32] = (byte) (bArr[i] ^ bArr2[i]);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 18; i3++) {
            for (int i4 = 0; i4 < 48; i4++) {
                byte[] bArr3 = this.X;
                byte b = (byte) (S[i2] ^ bArr3[i4]);
                bArr3[i4] = b;
                i2 = b & UByte.MAX_VALUE;
            }
            i2 = (i2 + i3) % 256;
        }
    }

    /* access modifiers changed from: protected */
    public void processCheckSum(byte[] bArr) {
        byte b = this.C[15];
        for (int i = 0; i < 16; i++) {
            byte[] bArr2 = this.C;
            bArr2[i] = (byte) (S[(b ^ bArr[i]) & 255] ^ bArr2[i]);
            b = bArr2[i];
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.xOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.X;
            if (i == bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        this.mOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.M;
            if (i2 == bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        this.COff = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.C;
            if (i3 != bArr3.length) {
                bArr3[i3] = 0;
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b) {
        byte[] bArr = this.M;
        int i = this.mOff;
        int i2 = i + 1;
        this.mOff = i2;
        bArr[i] = b;
        if (i2 == 16) {
            processCheckSum(bArr);
            processBlock(this.M);
            this.mOff = 0;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        while (this.mOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > 16) {
            System.arraycopy(bArr, i, this.M, 0, 16);
            processCheckSum(this.M);
            processBlock(this.M);
            i2 -= 16;
            i += 16;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}
