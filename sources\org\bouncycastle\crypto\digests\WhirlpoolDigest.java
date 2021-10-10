package org.bouncycastle.crypto.digests;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import net.openid.appauth.BuildConfig;
import org.bouncycastle.bcpg.SecretKeyPacket;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.objectweb.asm.Opcodes;

public final class WhirlpoolDigest implements ExtendedDigest {
    private static final int BITCOUNT_ARRAY_SIZE = 32;
    private static final int BYTE_LENGTH = 64;
    private static final long[] C0 = new long[256];
    private static final long[] C1 = new long[256];
    private static final long[] C2 = new long[256];
    private static final long[] C3 = new long[256];
    private static final long[] C4 = new long[256];
    private static final long[] C5 = new long[256];
    private static final long[] C6 = new long[256];
    private static final long[] C7 = new long[256];
    private static final int DIGEST_LENGTH_BYTES = 64;
    private static final short[] EIGHT;
    private static final int REDUCTION_POLYNOMIAL = 285;
    private static final int ROUNDS = 10;
    private static final int[] SBOX = {24, 35, Opcodes.IFNULL, 232, Opcodes.I2D, Opcodes.INVOKESTATIC, 1, 79, 54, Opcodes.IF_ACMPNE, 210, 245, 121, 111, 145, 82, 96, 188, Opcodes.IFLT, 142, Opcodes.IF_ICMPGT, 12, 123, 53, 29, 224, 215, Opcodes.MONITORENTER, 46, 75, SecretKeyPacket.USAGE_SHA1, 87, 21, 119, 55, 229, Opcodes.IF_ICMPEQ, 240, 74, 218, 88, 201, 41, 10, Opcodes.RETURN, Opcodes.IF_ICMPNE, 107, Opcodes.I2L, Opcodes.ANEWARRAY, 93, 16, BuildConfig.VERSION_CODE, 203, 62, 5, 103, 228, 39, 65, 139, Opcodes.GOTO, Opcodes.LUSHR, 149, 216, 251, 238, 124, 102, 221, 23, 71, Opcodes.IFLE, 202, 45, Opcodes.ATHROW, 7, Opcodes.LRETURN, 90, Opcodes.LXOR, 51, 99, 2, Opcodes.TABLESWITCH, 113, 200, 25, 73, 217, 242, 227, 91, Opcodes.L2I, Opcodes.IFNE, 38, 50, Opcodes.ARETURN, 233, 15, 213, 128, Opcodes.ARRAYLENGTH, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, Opcodes.FRETURN, 180, 84, 147, 34, 100, 241, 115, 18, 64, 8, Opcodes.MONITOREXIT, 236, 219, Opcodes.IF_ICMPLT, 141, 61, Opcodes.DCMPL, 0, 207, 43, 118, Opcodes.IXOR, ModuleDescriptor.MODULE_VERSION, 27, Opcodes.PUTFIELD, Opcodes.DRETURN, 106, 80, 69, 243, 48, 239, 63, 85, Opcodes.IF_ICMPGE, 234, 101, Opcodes.INVOKEDYNAMIC, 47, Opcodes.CHECKCAST, 222, 28, 253, 77, 146, 117, 6, 138, Opcodes.GETSTATIC, 230, 14, 31, 98, 212, Opcodes.JSR, Opcodes.FCMPG, 249, Opcodes.MULTIANEWARRAY, 37, 89, Opcodes.IINC, 114, 57, 76, 94, 120, 56, 140, 209, Opcodes.IF_ACMPEQ, 226, 97, Opcodes.PUTSTATIC, 33, Opcodes.IFGE, 30, 67, Opcodes.IFNONNULL, 252, 4, 81, Opcodes.IFEQ, 109, 13, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 223, Opcodes.IAND, 36, 59, Opcodes.LOOKUPSWITCH, 206, 17, 143, 78, Opcodes.INVOKESPECIAL, 235, 60, Opcodes.LOR, 148, 247, Opcodes.INVOKEINTERFACE, 19, 44, 211, 231, 110, 196, 3, 86, 68, 127, Opcodes.RET, 42, Opcodes.NEW, Opcodes.INSTANCEOF, 83, 220, 11, Opcodes.IFGT, 108, 49, 116, 246, 70, Opcodes.IRETURN, Opcodes.L2F, 20, 225, 22, 58, 105, 9, 112, Opcodes.INVOKEVIRTUAL, 208, 237, 204, 66, Opcodes.DCMPG, Opcodes.IF_ICMPLE, 40, 92, 248, Opcodes.I2F};
    private long[] _K;
    private long[] _L;
    private short[] _bitCount;
    private long[] _block;
    private byte[] _buffer;
    private int _bufferPos;
    private long[] _hash;
    private final long[] _rc;
    private long[] _state;

    static {
        short[] sArr = new short[32];
        EIGHT = sArr;
        sArr[31] = 8;
    }

    public WhirlpoolDigest() {
        this._rc = new long[11];
        this._buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this._hash = new long[8];
        this._K = new long[8];
        this._L = new long[8];
        this._block = new long[8];
        this._state = new long[8];
        for (int i = 0; i < 256; i++) {
            int i2 = SBOX[i];
            int maskWithReductionPolynomial = maskWithReductionPolynomial(i2 << 1);
            int maskWithReductionPolynomial2 = maskWithReductionPolynomial(maskWithReductionPolynomial << 1);
            int i3 = maskWithReductionPolynomial2 ^ i2;
            int maskWithReductionPolynomial3 = maskWithReductionPolynomial(maskWithReductionPolynomial2 << 1);
            int i4 = maskWithReductionPolynomial3 ^ i2;
            C0[i] = packIntoLong(i2, i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4);
            C1[i] = packIntoLong(i4, i2, i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial);
            C2[i] = packIntoLong(maskWithReductionPolynomial, i4, i2, i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3);
            C3[i] = packIntoLong(i3, maskWithReductionPolynomial, i4, i2, i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3);
            C4[i] = packIntoLong(maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i2, i2, maskWithReductionPolynomial2, i2);
            C5[i] = packIntoLong(i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i2, i2, maskWithReductionPolynomial2);
            C6[i] = packIntoLong(maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i2, i2);
            C7[i] = packIntoLong(i2, maskWithReductionPolynomial2, i2, maskWithReductionPolynomial3, i3, maskWithReductionPolynomial, i4, i2);
        }
        this._rc[0] = 0;
        for (int i5 = 1; i5 <= 10; i5++) {
            int i6 = (i5 - 1) * 8;
            this._rc[i5] = (((((((C0[i6] & -72057594037927936L) ^ (C1[i6 + 1] & 71776119061217280L)) ^ (C2[i6 + 2] & 280375465082880L)) ^ (C3[i6 + 3] & 1095216660480L)) ^ (C4[i6 + 4] & 4278190080L)) ^ (C5[i6 + 5] & 16711680)) ^ (C6[i6 + 6] & 65280)) ^ (C7[i6 + 7] & 255);
        }
    }

    public WhirlpoolDigest(WhirlpoolDigest whirlpoolDigest) {
        long[] jArr = new long[11];
        this._rc = jArr;
        this._buffer = new byte[64];
        this._bufferPos = 0;
        this._bitCount = new short[32];
        this._hash = new long[8];
        this._K = new long[8];
        this._L = new long[8];
        this._block = new long[8];
        this._state = new long[8];
        System.arraycopy(whirlpoolDigest._rc, 0, jArr, 0, jArr.length);
        byte[] bArr = whirlpoolDigest._buffer;
        byte[] bArr2 = this._buffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this._bufferPos = whirlpoolDigest._bufferPos;
        short[] sArr = whirlpoolDigest._bitCount;
        short[] sArr2 = this._bitCount;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr2 = whirlpoolDigest._hash;
        long[] jArr3 = this._hash;
        System.arraycopy(jArr2, 0, jArr3, 0, jArr3.length);
        long[] jArr4 = whirlpoolDigest._K;
        long[] jArr5 = this._K;
        System.arraycopy(jArr4, 0, jArr5, 0, jArr5.length);
        long[] jArr6 = whirlpoolDigest._L;
        long[] jArr7 = this._L;
        System.arraycopy(jArr6, 0, jArr7, 0, jArr7.length);
        long[] jArr8 = whirlpoolDigest._block;
        long[] jArr9 = this._block;
        System.arraycopy(jArr8, 0, jArr9, 0, jArr9.length);
        long[] jArr10 = whirlpoolDigest._state;
        long[] jArr11 = this._state;
        System.arraycopy(jArr10, 0, jArr11, 0, jArr11.length);
    }

    private long bytesToLongFromBuffer(byte[] bArr, int i) {
        return (((long) bArr[i + 7]) & 255) | ((((long) bArr[i + 0]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    private void convertLongToByteArray(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i + i2] = (byte) ((int) ((j >> (56 - (i2 * 8))) & 255));
        }
    }

    private byte[] copyBitLength() {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 32; i++) {
            bArr[i] = (byte) (this._bitCount[i] & 255);
        }
        return bArr;
    }

    private void finish() {
        byte[] copyBitLength = copyBitLength();
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        int i2 = i + 1;
        this._bufferPos = i2;
        bArr[i] = (byte) (bArr[i] | 128);
        if (i2 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        if (this._bufferPos > 32) {
            while (this._bufferPos != 0) {
                update((byte) 0);
            }
        }
        while (this._bufferPos <= 32) {
            update((byte) 0);
        }
        System.arraycopy(copyBitLength, 0, this._buffer, 32, copyBitLength.length);
        processFilledBuffer(this._buffer, 0);
    }

    private void increment() {
        int i = 0;
        for (int length = this._bitCount.length - 1; length >= 0; length--) {
            short[] sArr = this._bitCount;
            int i2 = (sArr[length] & 255) + EIGHT[length] + i;
            i = i2 >>> 8;
            sArr[length] = (short) (i2 & 255);
        }
    }

    private int maskWithReductionPolynomial(int i) {
        return ((long) i) >= 256 ? i ^ REDUCTION_POLYNOMIAL : i;
    }

    private long packIntoLong(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (((((((((long) i2) << 48) ^ (((long) i) << 56)) ^ (((long) i3) << 40)) ^ (((long) i4) << 32)) ^ (((long) i5) << 24)) ^ (((long) i6) << 16)) ^ (((long) i7) << 8)) ^ ((long) i8);
    }

    private void processFilledBuffer(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this._state.length; i2++) {
            this._block[i2] = bytesToLongFromBuffer(this._buffer, i2 * 8);
        }
        processBlock();
        this._bufferPos = 0;
        Arrays.fill(this._buffer, (byte) 0);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        for (int i2 = 0; i2 < 8; i2++) {
            convertLongToByteArray(this._hash[i2], bArr, (i2 * 8) + i);
        }
        reset();
        return getDigestSize();
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "Whirlpool";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        long[] jArr;
        for (int i = 0; i < 8; i++) {
            long[] jArr2 = this._state;
            long j = this._block[i];
            long[] jArr3 = this._K;
            long j2 = this._hash[i];
            jArr3[i] = j2;
            jArr2[i] = j ^ j2;
        }
        int i2 = 1;
        while (i2 <= 10) {
            int i3 = 0;
            while (i3 < 8) {
                long[] jArr4 = this._L;
                jArr4[i3] = 0;
                long j3 = jArr4[i3];
                long[] jArr5 = C0;
                long[] jArr6 = this._K;
                jArr4[i3] = jArr5[((int) (jArr6[(i3 + 0) & 7] >>> 56)) & 255] ^ j3;
                jArr4[i3] = jArr4[i3] ^ C1[((int) (jArr6[(i3 - 1) & 7] >>> 48)) & 255];
                jArr4[i3] = jArr4[i3] ^ C2[((int) (jArr6[(i3 - 2) & 7] >>> 40)) & 255];
                jArr4[i3] = jArr4[i3] ^ C3[((int) (jArr6[(i3 - 3) & 7] >>> 32)) & 255];
                jArr4[i3] = jArr4[i3] ^ C4[((int) (jArr6[(i3 - 4) & 7] >>> 24)) & 255];
                jArr4[i3] = jArr4[i3] ^ C5[((int) (jArr6[(i3 - 5) & 7] >>> 16)) & 255];
                jArr4[i3] = jArr4[i3] ^ C6[((int) (jArr6[(i3 - 6) & 7] >>> 8)) & 255];
                jArr4[i3] = jArr4[i3] ^ C7[((int) jArr6[(i3 - 7) & 7]) & 255];
                i3++;
                i2 = i2;
            }
            long[] jArr7 = this._L;
            long[] jArr8 = this._K;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
            long[] jArr9 = this._K;
            jArr9[0] = jArr9[0] ^ this._rc[i2];
            int i4 = 0;
            while (true) {
                jArr = this._L;
                if (i4 >= 8) {
                    break;
                }
                jArr[i4] = this._K[i4];
                long j4 = jArr[i4];
                long[] jArr10 = C0;
                long[] jArr11 = this._state;
                jArr[i4] = j4 ^ jArr10[((int) (jArr11[(i4 + 0) & 7] >>> 56)) & 255];
                jArr[i4] = jArr[i4] ^ C1[((int) (jArr11[(i4 - 1) & 7] >>> 48)) & 255];
                jArr[i4] = jArr[i4] ^ C2[((int) (jArr11[(i4 - 2) & 7] >>> 40)) & 255];
                jArr[i4] = jArr[i4] ^ C3[((int) (jArr11[(i4 - 3) & 7] >>> 32)) & 255];
                jArr[i4] = jArr[i4] ^ C4[((int) (jArr11[(i4 - 4) & 7] >>> 24)) & 255];
                jArr[i4] = jArr[i4] ^ C5[((int) (jArr11[(i4 - 5) & 7] >>> 16)) & 255];
                jArr[i4] = jArr[i4] ^ C6[((int) (jArr11[(i4 - 6) & 7] >>> 8)) & 255];
                jArr[i4] = jArr[i4] ^ C7[((int) jArr11[(i4 - 7) & 7]) & 255];
                i4++;
            }
            long[] jArr12 = this._state;
            System.arraycopy(jArr, 0, jArr12, 0, jArr12.length);
            i2++;
        }
        for (int i5 = 0; i5 < 8; i5++) {
            long[] jArr13 = this._hash;
            jArr13[i5] = jArr13[i5] ^ (this._state[i5] ^ this._block[i5]);
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this._bufferPos = 0;
        Arrays.fill(this._bitCount, (short) 0);
        Arrays.fill(this._buffer, (byte) 0);
        Arrays.fill(this._hash, 0);
        Arrays.fill(this._K, 0);
        Arrays.fill(this._L, 0);
        Arrays.fill(this._block, 0);
        Arrays.fill(this._state, 0);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b) {
        byte[] bArr = this._buffer;
        int i = this._bufferPos;
        bArr[i] = b;
        int i2 = i + 1;
        this._bufferPos = i2;
        if (i2 == bArr.length) {
            processFilledBuffer(bArr, 0);
        }
        increment();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}
