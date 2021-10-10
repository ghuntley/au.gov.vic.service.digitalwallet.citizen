package org.bouncycastle.apache.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class CBZip2InputStream extends InputStream implements BZip2Constants {
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private int[][] base = ((int[][]) Array.newInstance(int.class, 6, BZip2Constants.MAX_ALPHA_SIZE));
    private boolean blockRandomised;
    private int blockSize100k;
    private int bsBuff;
    private int bsLive;
    private InputStream bsStream;
    int ch2;
    int chPrev;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    int count;
    private int currentChar = -1;
    private int currentState = 1;
    int i;
    int i2;
    private boolean[] inUse = new boolean[256];
    int j2;
    private int last;
    private int[][] limit = ((int[][]) Array.newInstance(int.class, 6, BZip2Constants.MAX_ALPHA_SIZE));
    private char[] ll8 = null;
    private CRC mCrc = new CRC();
    private int[] minLens = new int[6];
    private int nInUse;
    private int origPtr;
    private int[][] perm = ((int[][]) Array.newInstance(int.class, 6, BZip2Constants.MAX_ALPHA_SIZE));
    int rNToGo = 0;
    int rTPos = 0;
    private char[] selector = new char[BZip2Constants.MAX_SELECTORS];
    private char[] selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
    private char[] seqToUnseq = new char[256];
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private boolean streamEnd = false;
    int tPos;
    private int[] tt = null;
    private char[] unseqToSeq = new char[256];
    private int[] unzftab = new int[256];
    char z;

    public CBZip2InputStream(InputStream inputStream) throws IOException {
        bsSetStream(inputStream);
        initialize();
        initBlock();
        setupBlock();
    }

    private static void badBlockHeader() {
        cadvise();
    }

    private static void blockOverrun() {
        cadvise();
    }

    private void bsFinishedWithStream() {
        try {
            InputStream inputStream = this.bsStream;
            if (inputStream != null && inputStream != System.in) {
                this.bsStream.close();
                this.bsStream = null;
            }
        } catch (IOException unused) {
        }
    }

    private int bsGetInt32() {
        return bsGetint();
    }

    private int bsGetIntVS(int i3) {
        return bsR(i3);
    }

    private char bsGetUChar() {
        return (char) bsR(8);
    }

    private int bsGetint() {
        return bsR(8) | ((((((bsR(8) | 0) << 8) | bsR(8)) << 8) | bsR(8)) << 8);
    }

    private int bsR(int i3) {
        while (true) {
            int i4 = this.bsLive;
            if (i4 < i3) {
                char c = 0;
                try {
                    c = (char) this.bsStream.read();
                } catch (IOException unused) {
                    compressedStreamEOF();
                }
                if (c == 65535) {
                    compressedStreamEOF();
                }
                this.bsBuff = (c & 255) | (this.bsBuff << 8);
                this.bsLive += 8;
            } else {
                int i5 = (this.bsBuff >> (i4 - i3)) & ((1 << i3) - 1);
                this.bsLive = i4 - i3;
                return i5;
            }
        }
    }

    private void bsSetStream(InputStream inputStream) {
        this.bsStream = inputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
    }

    private static void cadvise() {
        System.out.println("CRC Error");
    }

    private void complete() {
        int bsGetInt32 = bsGetInt32();
        this.storedCombinedCRC = bsGetInt32;
        if (bsGetInt32 != this.computedCombinedCRC) {
            crcError();
        }
        bsFinishedWithStream();
        this.streamEnd = true;
    }

    private static void compressedStreamEOF() {
        cadvise();
    }

    private static void crcError() {
        cadvise();
    }

    private void endBlock() {
        int finalCRC = this.mCrc.getFinalCRC();
        this.computedBlockCRC = finalCRC;
        if (this.storedBlockCRC != finalCRC) {
            crcError();
        }
        int i3 = this.computedCombinedCRC;
        int i4 = (i3 >>> 31) | (i3 << 1);
        this.computedCombinedCRC = i4;
        this.computedCombinedCRC = i4 ^ this.computedBlockCRC;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0166  */
    private void getAndMoveToFrontDecode() {
        char c;
        char c2;
        int i3;
        int bsR;
        int i4;
        char c3;
        int i5;
        int i6;
        char c4;
        int i7;
        char c5;
        char[] cArr = new char[256];
        int i8 = this.blockSize100k * BZip2Constants.baseBlockSize;
        this.origPtr = bsGetIntVS(24);
        recvDecodingTables();
        int i9 = this.nInUse + 1;
        int i10 = 0;
        while (true) {
            c = 255;
            if (i10 > 255) {
                break;
            }
            this.unzftab[i10] = 0;
            i10++;
        }
        for (int i11 = 0; i11 <= 255; i11++) {
            cArr[i11] = (char) i11;
        }
        char c6 = 65535;
        this.last = -1;
        int i12 = 49;
        char c7 = this.selector[0];
        int i13 = this.minLens[c7];
        int bsR2 = bsR(i13);
        while (bsR2 > this.limit[c7][i13]) {
            i13++;
            while (true) {
                i7 = this.bsLive;
                if (i7 >= 1) {
                    break;
                }
                try {
                    c5 = (char) this.bsStream.read();
                } catch (IOException unused) {
                    compressedStreamEOF();
                    c5 = 0;
                }
                if (c5 == 65535) {
                    compressedStreamEOF();
                }
                this.bsBuff = (c5 & 255) | (this.bsBuff << 8);
                this.bsLive += 8;
            }
            this.bsLive = i7 - 1;
            bsR2 = (bsR2 << 1) | ((this.bsBuff >> (i7 - 1)) & 1);
        }
        int i14 = this.perm[c7][bsR2 - this.base[c7][i13]];
        int i15 = 0;
        while (i14 != i9) {
            if (i14 == 0 || i14 == 1) {
                int i16 = 1;
                char c8 = c6;
                while (true) {
                    if (i14 != 0) {
                        if (i14 == 1) {
                            i5 = i16 * 2;
                        }
                        i16 *= 2;
                        if (i12 == 0) {
                            i15++;
                            i12 = 50;
                        }
                        i12 += c6;
                        c2 = this.selector[i15];
                        i3 = this.minLens[c2];
                        bsR = bsR(i3);
                        while (bsR > this.limit[c2][i3]) {
                            i3++;
                            while (true) {
                                i4 = this.bsLive;
                                if (i4 >= 1) {
                                    break;
                                }
                                try {
                                    c3 = (char) this.bsStream.read();
                                } catch (IOException unused2) {
                                    compressedStreamEOF();
                                    c3 = 0;
                                }
                                if (c3 == c6) {
                                    compressedStreamEOF();
                                }
                                this.bsBuff = (this.bsBuff << 8) | (c3 & 255);
                                this.bsLive += 8;
                                c6 = 65535;
                            }
                            this.bsLive = i4 - 1;
                            bsR = (bsR << 1) | ((this.bsBuff >> (i4 - 1)) & 1);
                            c6 = 65535;
                        }
                        i14 = this.perm[c2][bsR - this.base[c2][i3]];
                        if (i14 == 0 && i14 != 1) {
                            break;
                        }
                        c6 = 65535;
                    } else {
                        i5 = i16 * 1;
                    }
                    c8 += i5;
                    i16 *= 2;
                    if (i12 == 0) {
                    }
                    i12 += c6;
                    c2 = this.selector[i15];
                    i3 = this.minLens[c2];
                    bsR = bsR(i3);
                    while (bsR > this.limit[c2][i3]) {
                    }
                    i14 = this.perm[c2][bsR - this.base[c2][i3]];
                    if (i14 == 0) {
                    }
                    c6 = 65535;
                }
                int i17 = c8 + 1;
                char c9 = this.seqToUnseq[cArr[0]];
                int[] iArr = this.unzftab;
                iArr[c9] = iArr[c9] + i17;
                while (i17 > 0) {
                    int i18 = this.last + 1;
                    this.last = i18;
                    this.ll8[i18] = c9;
                    i17--;
                }
                if (this.last >= i8) {
                    blockOverrun();
                }
                c6 = 65535;
                c = 255;
            } else {
                int i19 = this.last + 1;
                this.last = i19;
                if (i19 >= i8) {
                    blockOverrun();
                }
                int i20 = i14 - 1;
                char c10 = cArr[i20];
                int[] iArr2 = this.unzftab;
                char[] cArr2 = this.seqToUnseq;
                char c11 = cArr2[c10];
                iArr2[c11] = iArr2[c11] + 1;
                this.ll8[this.last] = cArr2[c10];
                while (i20 > 3) {
                    int i21 = i20 - 1;
                    cArr[i20] = cArr[i21];
                    int i22 = i20 - 2;
                    cArr[i21] = cArr[i22];
                    int i23 = i20 - 3;
                    cArr[i22] = cArr[i23];
                    cArr[i23] = cArr[i20 - 4];
                    i20 -= 4;
                }
                while (i20 > 0) {
                    cArr[i20] = cArr[i20 - 1];
                    i20--;
                }
                cArr[0] = c10;
                if (i12 == 0) {
                    i15++;
                    i12 = 50;
                }
                i12 += c6;
                char c12 = this.selector[i15];
                int i24 = this.minLens[c12];
                int bsR3 = bsR(i24);
                while (bsR3 > this.limit[c12][i24]) {
                    i24++;
                    while (true) {
                        i6 = this.bsLive;
                        if (i6 >= 1) {
                            break;
                        }
                        try {
                            c4 = (char) this.bsStream.read();
                        } catch (IOException unused3) {
                            compressedStreamEOF();
                            c4 = 0;
                        }
                        this.bsBuff = (c4 & c) | (this.bsBuff << 8);
                        this.bsLive += 8;
                    }
                    this.bsLive = i6 - 1;
                    bsR3 = (bsR3 << 1) | ((this.bsBuff >> (i6 - 1)) & 1);
                }
                i14 = this.perm[c12][bsR3 - this.base[c12][i24]];
            }
        }
    }

    private void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i3, int i4, int i5) {
        int i6 = 0;
        int i7 = 0;
        for (int i8 = i3; i8 <= i4; i8++) {
            for (int i9 = 0; i9 < i5; i9++) {
                if (cArr[i9] == i8) {
                    iArr3[i7] = i9;
                    i7++;
                }
            }
        }
        for (int i10 = 0; i10 < 23; i10++) {
            iArr2[i10] = 0;
        }
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = cArr[i11] + 1;
            iArr2[i12] = iArr2[i12] + 1;
        }
        for (int i13 = 1; i13 < 23; i13++) {
            iArr2[i13] = iArr2[i13] + iArr2[i13 - 1];
        }
        for (int i14 = 0; i14 < 23; i14++) {
            iArr[i14] = 0;
        }
        int i15 = i3;
        while (i15 <= i4) {
            int i16 = i15 + 1;
            int i17 = i6 + (iArr2[i16] - iArr2[i15]);
            iArr[i15] = i17 - 1;
            i6 = i17 << 1;
            i15 = i16;
        }
        for (int i18 = i3 + 1; i18 <= i4; i18++) {
            iArr2[i18] = ((iArr[i18 - 1] + 1) << 1) - iArr2[i18];
        }
    }

    private void initBlock() {
        char bsGetUChar = bsGetUChar();
        char bsGetUChar2 = bsGetUChar();
        char bsGetUChar3 = bsGetUChar();
        char bsGetUChar4 = bsGetUChar();
        char bsGetUChar5 = bsGetUChar();
        char bsGetUChar6 = bsGetUChar();
        if (bsGetUChar == 23 && bsGetUChar2 == 'r' && bsGetUChar3 == 'E' && bsGetUChar4 == '8' && bsGetUChar5 == 'P' && bsGetUChar6 == 144) {
            complete();
        } else if (bsGetUChar == '1' && bsGetUChar2 == 'A' && bsGetUChar3 == 'Y' && bsGetUChar4 == '&' && bsGetUChar5 == 'S' && bsGetUChar6 == 'Y') {
            this.storedBlockCRC = bsGetInt32();
            if (bsR(1) == 1) {
                this.blockRandomised = true;
            } else {
                this.blockRandomised = false;
            }
            getAndMoveToFrontDecode();
            this.mCrc.initialiseCRC();
            this.currentState = 1;
        } else {
            badBlockHeader();
            this.streamEnd = true;
        }
    }

    private void initialize() throws IOException {
        char bsGetUChar = bsGetUChar();
        char bsGetUChar2 = bsGetUChar();
        if (bsGetUChar == 'B' || bsGetUChar2 == 'Z') {
            char bsGetUChar3 = bsGetUChar();
            char bsGetUChar4 = bsGetUChar();
            if (bsGetUChar3 != 'h' || bsGetUChar4 < '1' || bsGetUChar4 > '9') {
                bsFinishedWithStream();
                this.streamEnd = true;
                return;
            }
            setDecompressStructureSizes(bsGetUChar4 - '0');
            this.computedCombinedCRC = 0;
            return;
        }
        throw new IOException("Not a BZIP2 marked stream");
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (this.inUse[i3]) {
                char[] cArr = this.seqToUnseq;
                int i4 = this.nInUse;
                cArr[i4] = (char) i3;
                this.unseqToSeq[i3] = (char) i4;
                this.nInUse = i4 + 1;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x00e1 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    private void recvDecodingTables() {
        char[][] cArr = (char[][]) Array.newInstance(char.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
        boolean[] zArr = new boolean[16];
        for (int i3 = 0; i3 < 16; i3++) {
            if (bsR(1) == 1) {
                zArr[i3] = true;
            } else {
                zArr[i3] = false;
            }
        }
        for (int i4 = 0; i4 < 256; i4++) {
            this.inUse[i4] = false;
        }
        for (int i5 = 0; i5 < 16; i5++) {
            if (zArr[i5]) {
                for (int i6 = 0; i6 < 16; i6++) {
                    if (bsR(1) == 1) {
                        this.inUse[(i5 * 16) + i6] = true;
                    }
                }
            }
        }
        makeMaps();
        int i7 = this.nInUse + 2;
        int bsR = bsR(3);
        int bsR2 = bsR(15);
        for (int i8 = 0; i8 < bsR2; i8++) {
            int i9 = 0;
            while (bsR(1) == 1) {
                i9++;
            }
            this.selectorMtf[i8] = (char) i9;
        }
        char[] cArr2 = new char[6];
        for (char c = 0; c < bsR; c = (char) (c + 1)) {
            cArr2[c] = c;
        }
        for (int i10 = 0; i10 < bsR2; i10++) {
            char c2 = this.selectorMtf[i10];
            char c3 = cArr2[c2];
            while (c2 > 0) {
                int i11 = c2 - 1;
                cArr2[c2] = cArr2[i11];
                c2 = (char) i11;
            }
            cArr2[0] = c3;
            this.selector[i10] = c3;
        }
        for (int i12 = 0; i12 < bsR; i12++) {
            int bsR3 = bsR(5);
            for (int i13 = 0; i13 < i7; i13++) {
                while (bsR(1) == 1) {
                    bsR3 = bsR(1) == 0 ? bsR3 + 1 : bsR3 - 1;
                }
                cArr[i12][i13] = (char) bsR3;
            }
        }
        for (int i14 = 0; i14 < bsR; i14++) {
            char c4 = 32;
            int i15 = 0;
            char c5 = 0;
            while (i15 < i7) {
                if (cArr[i14][i15] > c5) {
                    c5 = cArr[i14][i15];
                }
                if (cArr[i14][i15] < c4) {
                    c4 = cArr[i14][i15];
                }
                i15++;
                c4 = c4;
            }
            hbCreateDecodeTables(this.limit[i14], this.base[i14], this.perm[i14], cArr[i14], c4, c5, i7);
            this.minLens[i14] = c4;
        }
    }

    private void setDecompressStructureSizes(int i3) {
        if (i3 >= 0 && i3 <= 9) {
            int i4 = this.blockSize100k;
        }
        this.blockSize100k = i3;
        if (i3 != 0) {
            int i5 = i3 * BZip2Constants.baseBlockSize;
            this.ll8 = new char[i5];
            this.tt = new int[i5];
        }
    }

    private void setupBlock() {
        int[] iArr = new int[257];
        iArr[0] = 0;
        this.i = 1;
        while (true) {
            int i3 = this.i;
            if (i3 > 256) {
                break;
            }
            iArr[i3] = this.unzftab[i3 - 1];
            this.i = i3 + 1;
        }
        this.i = 1;
        while (true) {
            int i4 = this.i;
            if (i4 > 256) {
                break;
            }
            iArr[i4] = iArr[i4] + iArr[i4 - 1];
            this.i = i4 + 1;
        }
        this.i = 0;
        while (true) {
            int i5 = this.i;
            if (i5 > this.last) {
                break;
            }
            char c = this.ll8[i5];
            this.tt[iArr[c]] = i5;
            iArr[c] = iArr[c] + 1;
            this.i = i5 + 1;
        }
        this.tPos = this.tt[this.origPtr];
        this.count = 0;
        this.i2 = 0;
        this.ch2 = 256;
        if (this.blockRandomised) {
            this.rNToGo = 0;
            this.rTPos = 0;
            setupRandPartA();
            return;
        }
        setupNoRandPartA();
    }

    private void setupNoRandPartA() {
        int i3 = this.i2;
        if (i3 <= this.last) {
            this.chPrev = this.ch2;
            char[] cArr = this.ll8;
            int i4 = this.tPos;
            char c = cArr[i4];
            this.ch2 = c;
            this.tPos = this.tt[i4];
            this.i2 = i3 + 1;
            this.currentChar = c;
            this.currentState = 6;
            this.mCrc.updateCRC(c);
            return;
        }
        endBlock();
        initBlock();
        setupBlock();
    }

    private void setupNoRandPartB() {
        if (this.ch2 != this.chPrev) {
            this.currentState = 5;
            this.count = 1;
        } else {
            int i3 = this.count + 1;
            this.count = i3;
            if (i3 >= 4) {
                char[] cArr = this.ll8;
                int i4 = this.tPos;
                this.z = cArr[i4];
                this.tPos = this.tt[i4];
                this.currentState = 7;
                this.j2 = 0;
                setupNoRandPartC();
                return;
            }
            this.currentState = 5;
        }
        setupNoRandPartA();
    }

    private void setupNoRandPartC() {
        if (this.j2 < this.z) {
            int i3 = this.ch2;
            this.currentChar = i3;
            this.mCrc.updateCRC(i3);
            this.j2++;
            return;
        }
        this.currentState = 5;
        this.i2++;
        this.count = 0;
        setupNoRandPartA();
    }

    private void setupRandPartA() {
        if (this.i2 <= this.last) {
            this.chPrev = this.ch2;
            char[] cArr = this.ll8;
            int i3 = this.tPos;
            this.ch2 = cArr[i3];
            this.tPos = this.tt[i3];
            int i4 = 0;
            if (this.rNToGo == 0) {
                int[] iArr = rNums;
                int i5 = this.rTPos;
                this.rNToGo = iArr[i5];
                int i6 = i5 + 1;
                this.rTPos = i6;
                if (i6 == 512) {
                    this.rTPos = 0;
                }
            }
            int i7 = this.rNToGo - 1;
            this.rNToGo = i7;
            int i8 = this.ch2;
            if (i7 == 1) {
                i4 = 1;
            }
            int i9 = i8 ^ i4;
            this.ch2 = i9;
            this.i2++;
            this.currentChar = i9;
            this.currentState = 3;
            this.mCrc.updateCRC(i9);
            return;
        }
        endBlock();
        initBlock();
        setupBlock();
    }

    private void setupRandPartB() {
        char c = 1;
        if (this.ch2 != this.chPrev) {
            this.currentState = 2;
            this.count = 1;
        } else {
            int i3 = this.count + 1;
            this.count = i3;
            if (i3 >= 4) {
                char[] cArr = this.ll8;
                int i4 = this.tPos;
                this.z = cArr[i4];
                this.tPos = this.tt[i4];
                if (this.rNToGo == 0) {
                    int[] iArr = rNums;
                    int i5 = this.rTPos;
                    this.rNToGo = iArr[i5];
                    int i6 = i5 + 1;
                    this.rTPos = i6;
                    if (i6 == 512) {
                        this.rTPos = 0;
                    }
                }
                int i7 = this.rNToGo - 1;
                this.rNToGo = i7;
                char c2 = this.z;
                if (i7 != 1) {
                    c = 0;
                }
                this.z = (char) (c2 ^ c);
                this.j2 = 0;
                this.currentState = 4;
                setupRandPartC();
                return;
            }
            this.currentState = 2;
        }
        setupRandPartA();
    }

    private void setupRandPartC() {
        if (this.j2 < this.z) {
            int i3 = this.ch2;
            this.currentChar = i3;
            this.mCrc.updateCRC(i3);
            this.j2++;
            return;
        }
        this.currentState = 2;
        this.i2++;
        this.count = 0;
        setupRandPartA();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.streamEnd) {
            return -1;
        }
        int i3 = this.currentChar;
        int i4 = this.currentState;
        if (i4 == 3) {
            setupRandPartB();
        } else if (i4 == 4) {
            setupRandPartC();
        } else if (i4 == 6) {
            setupNoRandPartB();
        } else if (i4 == 7) {
            setupNoRandPartC();
        }
        return i3;
    }
}
