package org.bouncycastle.crypto.prng;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import net.minidev.json.parser.JSONParserBase;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.math.ec.Tnaf;
import org.msgpack.core.MessagePack;

public class VMPCRandomGenerator implements RandomGenerator {
    private byte[] P = {-69, 44, 98, ByteCompanionObject.MAX_VALUE, -75, -86, MessagePack.Code.FIXEXT1, 13, -127, -2, -78, -126, MessagePack.Code.FLOAT64, MessagePack.Code.FIXSTR_PREFIX, -95, 8, 24, 113, 86, -24, 73, 2, Tnaf.POW_2_WIDTH, MessagePack.Code.BIN8, MessagePack.Code.MAP16, 53, -91, -20, Byte.MIN_VALUE, 18, -72, 105, MessagePack.Code.STR16, 47, 117, MessagePack.Code.UINT8, -94, 9, 54, 3, 97, 45, -3, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.ARRAY32, 5, 67, MessagePack.Code.FIXARRAY_PREFIX, -83, MessagePack.Code.EXT16, -31, -81, 87, -101, 76, MessagePack.Code.FIXEXT16, 81, -82, 80, -123, 60, 10, -28, -13, -100, 38, 35, 83, MessagePack.Code.EXT32, -125, -105, 70, -79, -103, 100, 49, 119, MessagePack.Code.FIXEXT2, 29, MessagePack.Code.FIXEXT4, 120, -67, 94, -80, -118, 34, 56, -8, 104, 43, 42, MessagePack.Code.BIN16, MessagePack.Code.INT64, -9, PSSSigner.TRAILER_IMPLICIT, 111, MessagePack.Code.MAP32, 4, -27, -107, 62, 37, -122, -90, 11, -113, -15, 36, 14, MessagePack.Code.FIXEXT8, 64, -77, MessagePack.Code.UINT64, 126, 6, 21, -102, 77, 28, -93, MessagePack.Code.STR32, 50, -110, 88, 17, 39, -12, 89, MessagePack.Code.INT8, 78, 106, 23, 91, -84, -1, 7, MessagePack.Code.NIL, 101, 121, -4, MessagePack.Code.EXT8, MessagePack.Code.UINT16, 118, 66, 93, -25, 58, 52, 122, 48, 40, 15, 115, 1, -7, MessagePack.Code.INT16, MessagePack.Code.INT32, 25, -23, -111, -71, 90, -19, 65, 109, -76, MessagePack.Code.TRUE, -98, -65, 99, -6, 31, 51, 96, 71, -119, -16, -106, JSONParserBase.EOI, 95, -109, 61, 55, 75, MessagePack.Code.STR8, -88, MessagePack.Code.NEVER_USED, 27, -10, 57, -117, -73, 12, 32, MessagePack.Code.UINT32, -120, 110, -74, 116, -114, -115, 22, 41, -14, -121, -11, -21, 112, -29, -5, 85, -97, MessagePack.Code.BIN32, 68, 74, 69, 125, -30, 107, 92, 108, 102, -87, -116, -18, -124, 19, -89, 30, -99, MessagePack.Code.ARRAY16, 103, 72, -70, 46, -26, -92, -85, 124, -108, 0, 33, -17, -22, -66, MessagePack.Code.FLOAT32, 114, 79, 82, -104, 63, MessagePack.Code.FALSE, 20, 123, 59, 84};
    private byte n = 0;
    private byte s = -66;

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long j) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) ((int) (255 & j));
        bArr[2] = (byte) ((int) ((65280 & j) >> 8));
        bArr[1] = (byte) ((int) ((16711680 & j) >> 16));
        bArr[0] = (byte) ((int) ((j & -16777216) >> 24));
        addSeedMaterial(bArr);
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        for (byte b : bArr) {
            byte[] bArr2 = this.P;
            byte b2 = this.s;
            byte b3 = this.n;
            byte b4 = bArr2[(b2 + bArr2[b3 & UByte.MAX_VALUE] + b) & 255];
            this.s = b4;
            byte b5 = bArr2[b3 & UByte.MAX_VALUE];
            bArr2[b3 & UByte.MAX_VALUE] = bArr2[b4 & UByte.MAX_VALUE];
            bArr2[b4 & UByte.MAX_VALUE] = b5;
            this.n = (byte) ((b3 + 1) & 255);
        }
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i, int i2) {
        synchronized (this.P) {
            int i3 = i2 + i;
            while (i != i3) {
                byte[] bArr2 = this.P;
                byte b = this.s;
                byte b2 = this.n;
                byte b3 = bArr2[(b + bArr2[b2 & UByte.MAX_VALUE]) & 255];
                this.s = b3;
                bArr[i] = bArr2[(bArr2[bArr2[b3 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];
                byte b4 = bArr2[b2 & UByte.MAX_VALUE];
                bArr2[b2 & UByte.MAX_VALUE] = bArr2[b3 & UByte.MAX_VALUE];
                bArr2[b3 & UByte.MAX_VALUE] = b4;
                this.n = (byte) ((b2 + 1) & 255);
                i++;
            }
        }
    }
}
