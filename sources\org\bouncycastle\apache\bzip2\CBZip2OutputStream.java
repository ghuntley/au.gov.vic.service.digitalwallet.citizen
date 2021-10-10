package org.bouncycastle.apache.bzip2;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;

public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
    protected static final int CLEARMASK = -2097153;
    protected static final int DEPTH_THRESH = 10;
    protected static final int GREATER_ICOST = 15;
    protected static final int LESSER_ICOST = 0;
    protected static final int QSORT_STACK_SIZE = 1000;
    protected static final int SETMASK = 2097152;
    protected static final int SMALL_THRESH = 20;
    private int allowableBlockSize;
    private char[] block;
    private int blockCRC;
    boolean blockRandomised;
    int blockSize100k;
    int bsBuff;
    int bsLive;
    private OutputStream bsStream;
    int bytesOut;
    boolean closed;
    private int combinedCRC;
    private int currentChar;
    private boolean finished;
    private boolean firstAttempt;
    private int[] ftab;
    private boolean[] inUse;
    private int[] incs;
    int last;
    CRC mCrc;
    private int[] mtfFreq;
    private int nBlocksRandomised;
    private int nInUse;
    private int nMTF;
    int origPtr;
    private int[] quadrant;
    private int runLength;
    private char[] selector;
    private char[] selectorMtf;
    private char[] seqToUnseq;
    private short[] szptr;
    private char[] unseqToSeq;
    private int workDone;
    private int workFactor;
    private int workLimit;
    private int[] zptr;

    /* access modifiers changed from: private */
    public static class StackElem {
        int dd;
        int hh;
        int ll;

        private StackElem() {
        }
    }

    public CBZip2OutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    public CBZip2OutputStream(OutputStream outputStream, int i) throws IOException {
        this.mCrc = new CRC();
        this.inUse = new boolean[256];
        this.seqToUnseq = new char[256];
        this.unseqToSeq = new char[256];
        this.selector = new char[BZip2Constants.MAX_SELECTORS];
        this.selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
        this.mtfFreq = new int[BZip2Constants.MAX_ALPHA_SIZE];
        this.currentChar = -1;
        this.runLength = 0;
        this.closed = false;
        this.incs = new int[]{1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
        this.block = null;
        this.quadrant = null;
        this.zptr = null;
        this.ftab = null;
        outputStream.write(66);
        outputStream.write(90);
        bsSetStream(outputStream);
        this.workFactor = 50;
        i = i > 9 ? 9 : i;
        this.blockSize100k = i < 1 ? 1 : i;
        allocateCompressStructures();
        initialize();
        initBlock();
    }

    private void allocateCompressStructures() {
        int i = this.blockSize100k * BZip2Constants.baseBlockSize;
        this.block = new char[(i + 1 + 20)];
        this.quadrant = new int[(i + 20)];
        this.zptr = new int[i];
        this.ftab = new int[65537];
        this.szptr = new short[(i * 2)];
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            try {
                this.bsStream.write(this.bsBuff >> 24);
                this.bsBuff <<= 8;
                this.bsLive -= 8;
                this.bytesOut++;
            } catch (IOException e) {
                throw e;
            }
        }
    }

    private void bsPutIntVS(int i, int i2) throws IOException {
        bsW(i, i2);
    }

    private void bsPutUChar(int i) throws IOException {
        bsW(8, i);
    }

    private void bsPutint(int i) throws IOException {
        bsW(8, (i >> 24) & 255);
        bsW(8, (i >> 16) & 255);
        bsW(8, (i >> 8) & 255);
        bsW(8, i & 255);
    }

    private void bsSetStream(OutputStream outputStream) {
        this.bsStream = outputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
        this.bytesOut = 0;
    }

    private void bsW(int i, int i2) throws IOException {
        while (true) {
            int i3 = this.bsLive;
            if (i3 >= 8) {
                try {
                    this.bsStream.write(this.bsBuff >> 24);
                    this.bsBuff <<= 8;
                    this.bsLive -= 8;
                    this.bytesOut++;
                } catch (IOException e) {
                    throw e;
                }
            } else {
                this.bsBuff = (i2 << ((32 - i3) - i)) | this.bsBuff;
                this.bsLive = i3 + i;
                return;
            }
        }
    }

    private void doReversibleTransformation() {
        this.workLimit = this.workFactor * this.last;
        int i = 0;
        this.workDone = 0;
        this.blockRandomised = false;
        this.firstAttempt = true;
        mainSort();
        if (this.workDone > this.workLimit && this.firstAttempt) {
            randomiseBlock();
            this.workDone = 0;
            this.workLimit = 0;
            this.blockRandomised = true;
            this.firstAttempt = false;
            mainSort();
        }
        this.origPtr = -1;
        while (true) {
            if (i > this.last) {
                break;
            } else if (this.zptr[i] == 0) {
                this.origPtr = i;
                break;
            } else {
                i++;
            }
        }
        if (this.origPtr == -1) {
            panic();
        }
    }

    private void endBlock() throws IOException {
        int finalCRC = this.mCrc.getFinalCRC();
        this.blockCRC = finalCRC;
        int i = this.combinedCRC;
        int i2 = (i >>> 31) | (i << 1);
        this.combinedCRC = i2;
        this.combinedCRC = finalCRC ^ i2;
        doReversibleTransformation();
        bsPutUChar(49);
        bsPutUChar(65);
        bsPutUChar(89);
        bsPutUChar(38);
        bsPutUChar(83);
        bsPutUChar(89);
        bsPutint(this.blockCRC);
        if (this.blockRandomised) {
            bsW(1, 1);
            this.nBlocksRandomised++;
        } else {
            bsW(1, 0);
        }
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUChar(23);
        bsPutUChar(114);
        bsPutUChar(69);
        bsPutUChar(56);
        bsPutUChar(80);
        bsPutUChar(144);
        bsPutint(this.combinedCRC);
        bsFinishedWithStream();
    }

    private boolean fullGtU(int i, int i2) {
        char[] cArr = this.block;
        int i3 = i + 1;
        char c = cArr[i3];
        int i4 = i2 + 1;
        char c2 = cArr[i4];
        if (c != c2) {
            return c > c2;
        }
        int i5 = i3 + 1;
        char c3 = cArr[i5];
        int i6 = i4 + 1;
        char c4 = cArr[i6];
        if (c3 != c4) {
            return c3 > c4;
        }
        int i7 = i5 + 1;
        char c5 = cArr[i7];
        int i8 = i6 + 1;
        char c6 = cArr[i8];
        if (c5 != c6) {
            return c5 > c6;
        }
        int i9 = i7 + 1;
        char c7 = cArr[i9];
        int i10 = i8 + 1;
        char c8 = cArr[i10];
        if (c7 != c8) {
            return c7 > c8;
        }
        int i11 = i9 + 1;
        char c9 = cArr[i11];
        int i12 = i10 + 1;
        char c10 = cArr[i12];
        if (c9 != c10) {
            return c9 > c10;
        }
        int i13 = i11 + 1;
        char c11 = cArr[i13];
        int i14 = i12 + 1;
        char c12 = cArr[i14];
        if (c11 != c12) {
            return c11 > c12;
        }
        int i15 = this.last + 1;
        do {
            char[] cArr2 = this.block;
            int i16 = i13 + 1;
            char c13 = cArr2[i16];
            int i17 = i14 + 1;
            char c14 = cArr2[i17];
            if (c13 != c14) {
                return c13 > c14;
            }
            int[] iArr = this.quadrant;
            int i18 = iArr[i13];
            int i19 = iArr[i14];
            if (i18 != i19) {
                return i18 > i19;
            }
            int i20 = i16 + 1;
            char c15 = cArr2[i20];
            int i21 = i17 + 1;
            char c16 = cArr2[i21];
            if (c15 != c16) {
                return c15 > c16;
            }
            int i22 = iArr[i16];
            int i23 = iArr[i17];
            if (i22 != i23) {
                return i22 > i23;
            }
            int i24 = i20 + 1;
            char c17 = cArr2[i24];
            int i25 = i21 + 1;
            char c18 = cArr2[i25];
            if (c17 != c18) {
                return c17 > c18;
            }
            int i26 = iArr[i20];
            int i27 = iArr[i21];
            if (i26 != i27) {
                return i26 > i27;
            }
            i13 = i24 + 1;
            char c19 = cArr2[i13];
            int i28 = i25 + 1;
            char c20 = cArr2[i28];
            if (c19 != c20) {
                return c19 > c20;
            }
            int i29 = iArr[i24];
            int i30 = iArr[i25];
            if (i29 != i30) {
                return i29 > i30;
            }
            int i31 = this.last;
            if (i13 > i31) {
                i13 = (i13 - i31) - 1;
            }
            if (i28 > i31) {
                i28 = (i28 - i31) - 1;
            }
            i14 = i28;
            i15 -= 4;
            this.workDone++;
        } while (i15 >= 0);
        return false;
    }

    private void generateMTFValues() {
        char[] cArr = new char[256];
        makeMaps();
        int i = this.nInUse + 1;
        for (int i2 = 0; i2 <= i; i2++) {
            this.mtfFreq[i2] = 0;
        }
        for (int i3 = 0; i3 < this.nInUse; i3++) {
            cArr[i3] = (char) i3;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 <= this.last; i6++) {
            char c = this.unseqToSeq[this.block[this.zptr[i6]]];
            char c2 = cArr[0];
            int i7 = 0;
            while (c != c2) {
                i7++;
                char c3 = cArr[i7];
                cArr[i7] = c2;
                c2 = c3;
            }
            cArr[0] = c2;
            if (i7 == 0) {
                i4++;
            } else {
                if (i4 > 0) {
                    int i8 = i4 - 1;
                    while (true) {
                        int i9 = i8 % 2;
                        if (i9 == 0) {
                            this.szptr[i5] = 0;
                            i5++;
                            int[] iArr = this.mtfFreq;
                            iArr[0] = iArr[0] + 1;
                        } else if (i9 == 1) {
                            this.szptr[i5] = 1;
                            i5++;
                            int[] iArr2 = this.mtfFreq;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i8 < 2) {
                            break;
                        }
                        i8 = (i8 - 2) / 2;
                    }
                    i4 = 0;
                }
                int i10 = i7 + 1;
                this.szptr[i5] = (short) i10;
                i5++;
                int[] iArr3 = this.mtfFreq;
                iArr3[i10] = iArr3[i10] + 1;
            }
        }
        if (i4 > 0) {
            int i11 = i4 - 1;
            while (true) {
                int i12 = i11 % 2;
                if (i12 == 0) {
                    this.szptr[i5] = 0;
                    i5++;
                    int[] iArr4 = this.mtfFreq;
                    iArr4[0] = iArr4[0] + 1;
                } else if (i12 == 1) {
                    this.szptr[i5] = 1;
                    i5++;
                    int[] iArr5 = this.mtfFreq;
                    iArr5[1] = iArr5[1] + 1;
                }
                if (i11 < 2) {
                    break;
                }
                i11 = (i11 - 2) / 2;
            }
        }
        this.szptr[i5] = (short) i;
        int[] iArr6 = this.mtfFreq;
        iArr6[i] = iArr6[i] + 1;
        this.nMTF = i5 + 1;
    }

    private void hbAssignCodes(int[] iArr, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        while (i <= i2) {
            for (int i5 = 0; i5 < i3; i5++) {
                if (cArr[i5] == i) {
                    iArr[i5] = i4;
                    i4++;
                }
            }
            i4 <<= 1;
            i++;
        }
    }

    protected static void hbMakeCodeLengths(char[] cArr, int[] iArr, int i, int i2) {
        int i3 = 260;
        int[] iArr2 = new int[260];
        int i4 = 516;
        int[] iArr3 = new int[516];
        int[] iArr4 = new int[516];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 1;
            if (i6 >= i) {
                break;
            }
            int i8 = i6 + 1;
            if (iArr[i6] != 0) {
                i7 = iArr[i6];
            }
            iArr3[i8] = i7 << 8;
            i6 = i8;
        }
        while (true) {
            iArr2[i5] = i5;
            iArr3[i5] = i5;
            iArr4[i5] = -2;
            int i9 = i5;
            for (int i10 = 1; i10 <= i; i10++) {
                iArr4[i10] = -1;
                i9++;
                iArr2[i9] = i10;
                int i11 = iArr2[i9];
                int i12 = i9;
                while (true) {
                    int i13 = i12 >> 1;
                    if (iArr3[i11] >= iArr3[iArr2[i13]]) {
                        break;
                    }
                    iArr2[i12] = iArr2[i13];
                    i12 = i13;
                }
                iArr2[i12] = i11;
            }
            if (i9 >= i3) {
                panic();
            }
            int i14 = i;
            while (i9 > 1) {
                int i15 = iArr2[1];
                iArr2[1] = iArr2[i9];
                int i16 = i9 - 1;
                int i17 = iArr2[1];
                int i18 = 1;
                while (true) {
                    int i19 = i18 << 1;
                    if (i19 > i16) {
                        break;
                    }
                    if (i19 < i16) {
                        int i20 = i19 + 1;
                        if (iArr3[iArr2[i20]] < iArr3[iArr2[i19]]) {
                            i19 = i20;
                        }
                    }
                    if (iArr3[i17] < iArr3[iArr2[i19]]) {
                        break;
                    }
                    iArr2[i18] = iArr2[i19];
                    i18 = i19;
                }
                iArr2[i18] = i17;
                int i21 = iArr2[1];
                iArr2[1] = iArr2[i16];
                int i22 = i16 - 1;
                int i23 = iArr2[1];
                int i24 = 1;
                while (true) {
                    int i25 = i24 << 1;
                    if (i25 > i22) {
                        break;
                    }
                    if (i25 < i22) {
                        int i26 = i25 + 1;
                        if (iArr3[iArr2[i26]] < iArr3[iArr2[i25]]) {
                            i25 = i26;
                        }
                    }
                    if (iArr3[i23] < iArr3[iArr2[i25]]) {
                        break;
                    }
                    iArr2[i24] = iArr2[i25];
                    i24 = i25;
                }
                iArr2[i24] = i23;
                i14++;
                iArr4[i21] = i14;
                iArr4[i15] = i14;
                iArr3[i14] = ((((iArr3[i15] & 255) > (iArr3[i21] & 255) ? iArr3[i15] : iArr3[i21]) & 255) + 1) | ((iArr3[i15] & InputDeviceCompat.SOURCE_ANY) + (iArr3[i21] & InputDeviceCompat.SOURCE_ANY));
                iArr4[i14] = -1;
                i9 = i22 + 1;
                iArr2[i9] = i14;
                int i27 = iArr2[i9];
                int i28 = i9;
                while (true) {
                    int i29 = i28 >> 1;
                    if (iArr3[i27] >= iArr3[iArr2[i29]]) {
                        break;
                    }
                    iArr2[i28] = iArr2[i29];
                    i28 = i29;
                }
                iArr2[i28] = i27;
                i4 = 516;
            }
            if (i14 >= i4) {
                panic();
            }
            boolean z = false;
            for (int i30 = 1; i30 <= i; i30++) {
                int i31 = i30;
                int i32 = 0;
                while (iArr4[i31] >= 0) {
                    i31 = iArr4[i31];
                    i32++;
                }
                cArr[i30 - 1] = (char) i32;
                if (i32 > i2) {
                    z = true;
                }
            }
            if (z) {
                for (int i33 = 1; i33 < i; i33++) {
                    iArr3[i33] = (((iArr3[i33] >> 8) / 2) + 1) << 8;
                }
                i4 = i4;
                i3 = 260;
                i5 = 0;
            } else {
                return;
            }
        }
    }

    private void initBlock() {
        this.mCrc.initialiseCRC();
        this.last = -1;
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        this.allowableBlockSize = (this.blockSize100k * BZip2Constants.baseBlockSize) - 20;
    }

    private void initialize() throws IOException {
        this.bytesOut = 0;
        this.nBlocksRandomised = 0;
        bsPutUChar(104);
        bsPutUChar(this.blockSize100k + 48);
        this.combinedCRC = 0;
    }

    private void mainSort() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        boolean[] zArr = new boolean[256];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            i2 = 20;
            if (i6 >= 20) {
                break;
            }
            char[] cArr = this.block;
            int i7 = this.last;
            cArr[i7 + i6 + 2] = cArr[(i6 % (i7 + 1)) + 1];
            i6++;
        }
        int i8 = 0;
        while (true) {
            i3 = this.last;
            if (i8 > i3 + 20) {
                break;
            }
            this.quadrant[i8] = 0;
            i8++;
        }
        char[] cArr2 = this.block;
        cArr2[0] = cArr2[i3 + 1];
        if (i3 < 4000) {
            int i9 = 0;
            while (true) {
                int i10 = this.last;
                if (i9 <= i10) {
                    this.zptr[i9] = i9;
                    i9++;
                } else {
                    this.firstAttempt = false;
                    this.workLimit = 0;
                    this.workDone = 0;
                    simpleSort(0, i10, 0);
                    return;
                }
            }
        } else {
            for (int i11 = 0; i11 <= 255; i11++) {
                zArr[i11] = false;
            }
            for (int i12 = 0; i12 <= 65536; i12++) {
                this.ftab[i12] = 0;
            }
            char c = this.block[0];
            int i13 = 0;
            while (i13 <= this.last) {
                i13++;
                char c2 = this.block[i13];
                int[] iArr3 = this.ftab;
                int i14 = (c << '\b') + c2;
                iArr3[i14] = iArr3[i14] + 1;
                c = c2;
            }
            for (int i15 = 1; i15 <= 65536; i15++) {
                int[] iArr4 = this.ftab;
                iArr4[i15] = iArr4[i15] + iArr4[i15 - 1];
            }
            char c3 = this.block[1];
            int i16 = 0;
            while (true) {
                i4 = this.last;
                if (i16 >= i4) {
                    break;
                }
                char c4 = this.block[i16 + 2];
                int i17 = (c3 << '\b') + c4;
                int[] iArr5 = this.ftab;
                iArr5[i17] = iArr5[i17] - 1;
                this.zptr[iArr5[i17]] = i16;
                i16++;
                c3 = c4;
            }
            char[] cArr3 = this.block;
            int i18 = (cArr3[i4 + 1] << '\b') + cArr3[1];
            int[] iArr6 = this.ftab;
            iArr6[i18] = iArr6[i18] - 1;
            this.zptr[iArr6[i18]] = i4;
            for (int i19 = 0; i19 <= 255; i19++) {
                iArr[i19] = i19;
            }
            int i20 = 1;
            do {
                i20 = (i20 * 3) + 1;
            } while (i20 <= 256);
            do {
                i20 /= 3;
                for (int i21 = i20; i21 <= 255; i21++) {
                    int i22 = iArr[i21];
                    int i23 = i21;
                    while (true) {
                        int[] iArr7 = this.ftab;
                        int i24 = i23 - i20;
                        if (iArr7[(iArr[i24] + 1) << 8] - iArr7[iArr[i24] << 8] <= iArr7[(i22 + 1) << 8] - iArr7[i22 << 8]) {
                            break;
                        }
                        iArr[i23] = iArr[i24];
                        if (i24 <= i20 - 1) {
                            i23 = i24;
                            break;
                        }
                        i23 = i24;
                    }
                    iArr[i23] = i22;
                }
            } while (i20 != 1);
            int i25 = 0;
            while (i25 <= 255) {
                int i26 = iArr[i25];
                for (int i27 = i5; i27 <= 255; i27++) {
                    int i28 = (i26 << 8) + i27;
                    int[] iArr8 = this.ftab;
                    if ((iArr8[i28] & 2097152) != 2097152) {
                        int i29 = iArr8[i28] & CLEARMASK;
                        int i30 = (CLEARMASK & iArr8[i28 + 1]) - 1;
                        if (i30 > i29) {
                            qSort3(i29, i30, i);
                            if (this.workDone > this.workLimit && this.firstAttempt) {
                                return;
                            }
                        }
                        int[] iArr9 = this.ftab;
                        iArr9[i28] = 2097152 | iArr9[i28];
                    }
                }
                zArr[i26] = true;
                if (i25 < 255) {
                    int[] iArr10 = this.ftab;
                    int i31 = iArr10[i26 << 8] & CLEARMASK;
                    int i32 = (iArr10[(i26 + 1) << 8] & CLEARMASK) - i31;
                    int i33 = 0;
                    while ((i32 >> i33) > 65534) {
                        i33++;
                    }
                    int i34 = 0;
                    while (i34 < i32) {
                        int i35 = this.zptr[i31 + i34];
                        int i36 = i34 >> i33;
                        int[] iArr11 = this.quadrant;
                        iArr11[i35] = i36;
                        if (i35 < i2) {
                            iArr11[i35 + this.last + 1] = i36;
                        }
                        i34++;
                        i2 = 20;
                    }
                    if (((i32 - 1) >> i33) > 65535) {
                        panic();
                    }
                }
                for (int i37 = 0; i37 <= 255; i37++) {
                    iArr2[i37] = this.ftab[(i37 << 8) + i26] & CLEARMASK;
                }
                for (int i38 = this.ftab[i26 << 8] & CLEARMASK; i38 < (this.ftab[(i26 + 1) << 8] & CLEARMASK); i38++) {
                    char[] cArr4 = this.block;
                    int[] iArr12 = this.zptr;
                    char c5 = cArr4[iArr12[i38]];
                    if (!zArr[c5]) {
                        iArr12[iArr2[c5]] = iArr12[i38] == 0 ? this.last : iArr12[i38] - 1;
                        iArr2[c5] = iArr2[c5] + 1;
                    }
                }
                for (int i39 = 0; i39 <= 255; i39++) {
                    int[] iArr13 = this.ftab;
                    int i40 = (i39 << 8) + i26;
                    iArr13[i40] = iArr13[i40] | 2097152;
                }
                i25++;
                i5 = 0;
                i = 2;
                i2 = 20;
            }
        }
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i = 0; i < 256; i++) {
            if (this.inUse[i]) {
                char[] cArr = this.seqToUnseq;
                int i2 = this.nInUse;
                cArr[i2] = (char) i;
                this.unseqToSeq[i] = (char) i2;
                this.nInUse = i2 + 1;
            }
        }
    }

    private char med3(char c, char c2, char c3) {
        if (c <= c2) {
            c2 = c;
            c = c2;
        }
        if (c <= c3) {
            c3 = c;
        }
        return c2 > c3 ? c2 : c3;
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsPutIntVS(24, this.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private static void panic() {
        System.out.println("panic");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        if (r9 > 0) goto L_0x0082;
     */
    private void qSort3(int i, int i2, int i3) {
        StackElem[] stackElemArr = new StackElem[1000];
        for (int i4 = 0; i4 < 1000; i4++) {
            stackElemArr[i4] = new StackElem();
        }
        stackElemArr[0].ll = i;
        stackElemArr[0].hh = i2;
        stackElemArr[0].dd = i3;
        int i5 = 1;
        while (i5 > 0) {
            if (i5 >= 1000) {
                panic();
            }
            i5--;
            int i6 = stackElemArr[i5].ll;
            int i7 = stackElemArr[i5].hh;
            int i8 = stackElemArr[i5].dd;
            if (i7 - i6 < 20 || i8 > 10) {
                simpleSort(i6, i7, i8);
                if (this.workDone > this.workLimit && this.firstAttempt) {
                    return;
                }
            } else {
                char[] cArr = this.block;
                int[] iArr = this.zptr;
                char med3 = med3(cArr[iArr[i6] + i8 + 1], cArr[iArr[i7] + i8 + 1], cArr[iArr[(i6 + i7) >> 1] + i8 + 1]);
                int i9 = i6;
                int i10 = i9;
                int i11 = i7;
                int i12 = i11;
                while (true) {
                    if (i9 <= i11) {
                        char[] cArr2 = this.block;
                        int[] iArr2 = this.zptr;
                        int i13 = cArr2[(iArr2[i9] + i8) + 1] - med3;
                        if (i13 == 0) {
                            int i14 = iArr2[i9];
                            iArr2[i9] = iArr2[i10];
                            iArr2[i10] = i14;
                            i10++;
                        }
                        i9++;
                    }
                    while (i9 <= i11) {
                        char[] cArr3 = this.block;
                        int[] iArr3 = this.zptr;
                        int i15 = cArr3[(iArr3[i11] + i8) + 1] - med3;
                        if (i15 == 0) {
                            int i16 = iArr3[i11];
                            iArr3[i11] = iArr3[i12];
                            iArr3[i12] = i16;
                            i12--;
                        } else if (i15 < 0) {
                            break;
                        }
                        i11--;
                    }
                    if (i9 > i11) {
                        break;
                    }
                    int[] iArr4 = this.zptr;
                    int i17 = iArr4[i9];
                    iArr4[i9] = iArr4[i11];
                    iArr4[i11] = i17;
                    i9++;
                    i11--;
                }
                if (i12 < i10) {
                    stackElemArr[i5].ll = i6;
                    stackElemArr[i5].hh = i7;
                    stackElemArr[i5].dd = i8 + 1;
                    i5++;
                } else {
                    int i18 = i10 - i6;
                    int i19 = i9 - i10;
                    if (i18 >= i19) {
                        i18 = i19;
                    }
                    vswap(i6, i9 - i18, i18);
                    int i20 = i7 - i12;
                    int i21 = i12 - i11;
                    if (i20 >= i21) {
                        i20 = i21;
                    }
                    vswap(i9, (i7 - i20) + 1, i20);
                    int i22 = ((i9 + i6) - i10) - 1;
                    int i23 = (i7 - i21) + 1;
                    stackElemArr[i5].ll = i6;
                    stackElemArr[i5].hh = i22;
                    stackElemArr[i5].dd = i8;
                    int i24 = i5 + 1;
                    stackElemArr[i24].ll = i22 + 1;
                    stackElemArr[i24].hh = i23 - 1;
                    stackElemArr[i24].dd = i8 + 1;
                    int i25 = i24 + 1;
                    stackElemArr[i25].ll = i23;
                    stackElemArr[i25].hh = i7;
                    stackElemArr[i25].dd = i8;
                    i5 = i25 + 1;
                }
            }
        }
    }

    private void randomiseBlock() {
        for (int i = 0; i < 256; i++) {
            this.inUse[i] = false;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 <= this.last) {
            if (i3 == 0) {
                i3 = (char) rNums[i4];
                i4++;
                if (i4 == 512) {
                    i4 = 0;
                }
            }
            i3--;
            char[] cArr = this.block;
            i2++;
            cArr[i2] = (char) (cArr[i2] ^ (i3 == 1 ? (char) 1 : 0));
            cArr[i2] = (char) (cArr[i2] & 255);
            this.inUse[cArr[i2]] = true;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:206:0x0194 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:165:0x02d1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r10v12, types: [short] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r15v7, types: [int, short] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void sendMTFValues() throws IOException {
        int i;
        int i2;
        int i3;
        char[][] cArr = (char[][]) Array.newInstance(char.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
        int i4 = this.nInUse + 2;
        int i5 = 0;
        for (int i6 = 0; i6 < 6; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                cArr[i6][i7] = 15;
            }
        }
        if (this.nMTF <= 0) {
            panic();
        }
        int i8 = this.nMTF;
        int i9 = i8 < 200 ? 2 : i8 < 600 ? 3 : i8 < 1200 ? 4 : i8 < 2400 ? 5 : 6;
        int i10 = 0;
        int i11 = i9;
        while (true) {
            i = 1;
            if (i11 <= 0) {
                break;
            }
            int i12 = i8 / i11;
            int i13 = 0;
            int i14 = i10 - 1;
            while (i13 < i12 && i14 < i4 - 1) {
                i14++;
                i13 += this.mtfFreq[i14];
            }
            if (i14 > i10 && i11 != i9 && i11 != 1 && (i9 - i11) % 2 == 1) {
                i13 -= this.mtfFreq[i14];
                i14--;
            }
            for (int i15 = 0; i15 < i4; i15++) {
                if (i15 < i10 || i15 > i14) {
                    cArr[i11 - 1][i15] = 15;
                } else {
                    cArr[i11 - 1][i15] = 0;
                }
            }
            i11--;
            i10 = i14 + 1;
            i8 -= i13;
        }
        int[][] iArr = (int[][]) Array.newInstance(int.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
        int[] iArr2 = new int[6];
        short[] sArr = new short[6];
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = 20;
            if (i16 >= 4) {
                break;
            }
            for (int i19 = i5; i19 < i9; i19++) {
                iArr2[i19] = i5;
            }
            for (int i20 = i5; i20 < i9; i20++) {
                for (int i21 = i5; i21 < i4; i21++) {
                    iArr[i20][i21] = i5;
                }
            }
            int i22 = i5;
            i17 = i22;
            short s = i5;
            while (true) {
                int i23 = this.nMTF;
                if (i22 >= i23) {
                    break;
                }
                int i24 = (i22 + 50) - i;
                if (i24 >= i23) {
                    i24 = i23 - 1;
                }
                for (int i25 = s; i25 < i9; i25++) {
                    sArr[i25] = s;
                }
                if (i9 == 6) {
                    int i26 = i22;
                    short s2 = s;
                    short s3 = s2;
                    short s4 = s3;
                    short s5 = s4;
                    short s6 = s5;
                    short s7 = s6;
                    char c = s;
                    while (i26 <= i24) {
                        short s8 = this.szptr[i26];
                        short s9 = (short) (s4 + cArr[2][s8]);
                        short s10 = (short) (s5 + cArr[3][s8]);
                        i26++;
                        s6 = (short) (s6 + cArr[4][s8]);
                        s2 = (short) (s2 + cArr[c == 1 ? 1 : 0][s8]);
                        s7 = (short) (s7 + cArr[5][s8]);
                        s5 = s10;
                        i16 = i16;
                        c = 0;
                        s4 = s9;
                        s3 = (short) (s3 + cArr[i][s8]);
                        i = 1;
                    }
                    i3 = i16;
                    sArr[c] = s2;
                    sArr[1] = s3;
                    sArr[2] = s4;
                    sArr[3] = s5;
                    sArr[4] = s6;
                    sArr[5] = s7;
                } else {
                    i3 = i16;
                    for (int i27 = i22; i27 <= i24; i27++) {
                        short s11 = this.szptr[i27];
                        for (int i28 = 0; i28 < i9; i28++) {
                            sArr[i28] = (short) (sArr[i28] + cArr[i28][s11]);
                        }
                    }
                }
                short s12 = 999999999;
                int i29 = -1;
                int i30 = 0;
                while (i30 < i9) {
                    if (sArr[i30] < s12) {
                        s12 = sArr[i30];
                        i29 = i30;
                    }
                    i30++;
                    s12 = s12;
                }
                iArr2[i29] = iArr2[i29] + 1;
                this.selector[i17] = (char) i29;
                i17++;
                while (i22 <= i24) {
                    int[] iArr3 = iArr[i29];
                    short s13 = this.szptr[i22];
                    iArr3[s13] = iArr3[s13] + 1;
                    i22++;
                }
                i22 = i24 + 1;
                i16 = i3;
                s = 0;
                i18 = 20;
                i = 1;
            }
            for (int i31 = s; i31 < i9; i31++) {
                hbMakeCodeLengths(cArr[i31], iArr[i31], i4, i18);
            }
            i16++;
            i5 = s;
        }
        if (i9 >= 8) {
            panic();
        }
        if (i17 >= 32768 || i17 > 18002) {
            panic();
        }
        char[] cArr2 = new char[6];
        for (int i32 = 0; i32 < i9; i32++) {
            cArr2[i32] = (char) i32;
        }
        for (int i33 = 0; i33 < i17; i33++) {
            char c2 = this.selector[i33];
            char c3 = cArr2[0];
            int i34 = 0;
            while (c2 != c3) {
                i34++;
                char c4 = cArr2[i34];
                cArr2[i34] = c3;
                c3 = c4;
            }
            cArr2[0] = c3;
            this.selectorMtf[i33] = (char) i34;
        }
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
        for (int i35 = 0; i35 < i9; i35++) {
            char c5 = ' ';
            char c6 = 0;
            for (int i36 = 0; i36 < i4; i36++) {
                if (cArr[i35][i36] > c6) {
                    c6 = cArr[i35][i36];
                }
                if (cArr[i35][i36] < c5) {
                    c5 = cArr[i35][i36];
                }
            }
            if (c6 > 20) {
                panic();
            }
            if (c5 < 1) {
                panic();
            }
            hbAssignCodes(iArr4[i35], cArr[i35], c5, c6, i4);
        }
        boolean[] zArr = new boolean[16];
        for (int i37 = 0; i37 < 16; i37++) {
            zArr[i37] = false;
            for (int i38 = 0; i38 < 16; i38++) {
                if (this.inUse[(i37 * 16) + i38]) {
                    zArr[i37] = true;
                }
            }
        }
        for (int i39 = 0; i39 < 16; i39++) {
            if (zArr[i39]) {
                bsW(1, 1);
            } else {
                bsW(1, 0);
            }
        }
        for (int i40 = 0; i40 < 16; i40++) {
            if (zArr[i40]) {
                for (int i41 = 0; i41 < 16; i41++) {
                    if (this.inUse[(i40 * 16) + i41]) {
                        bsW(1, 1);
                    } else {
                        bsW(1, 0);
                    }
                }
            }
        }
        bsW(3, i9);
        bsW(15, i17);
        int i42 = 0;
        while (true) {
            i2 = 0;
            if (i42 >= i17) {
                break;
            }
            while (i2 < this.selectorMtf[i42]) {
                bsW(1, 1);
                i2++;
            }
            bsW(1, 0);
            i42++;
        }
        int i43 = 0;
        while (i43 < i9) {
            char c7 = cArr[i43][i2];
            bsW(5, c7);
            int i44 = 0;
            ?? r0 = c7;
            while (i44 < i4) {
                while (r0 < cArr[i43][i44]) {
                    bsW(2, 2);
                    r0++;
                }
                char c8 = r0;
                while (c8 > cArr[i43][i44]) {
                    bsW(2, 3);
                    c8--;
                }
                bsW(1, 0);
                i44++;
                r0 = c8;
            }
            i43++;
            i2 = 0;
        }
        int i45 = i2;
        int i46 = i45;
        while (true) {
            int i47 = this.nMTF;
            if (i45 >= i47) {
                break;
            }
            int i48 = (i45 + 50) - 1;
            if (i48 >= i47) {
                i48 = i47 - 1;
            }
            while (i45 <= i48) {
                char[] cArr3 = this.selector;
                char[] cArr4 = cArr[cArr3[i46]];
                short[] sArr2 = this.szptr;
                bsW(cArr4[sArr2[i45]], iArr4[cArr3[i46]][sArr2[i45]]);
                i45++;
            }
            i45 = i48 + 1;
            i46++;
        }
        if (i46 != i17) {
            panic();
        }
    }

    private void simpleSort(int i, int i2, int i3) {
        int i4 = (i2 - i) + 1;
        if (i4 >= 2) {
            int i5 = 0;
            while (this.incs[i5] < i4) {
                i5++;
            }
            while (true) {
                i5--;
                if (i5 >= 0) {
                    int i6 = this.incs[i5];
                    int i7 = i + i6;
                    int i8 = i7;
                    while (i8 <= i2) {
                        int i9 = this.zptr[i8];
                        int i10 = i8;
                        while (true) {
                            int i11 = i10 - i6;
                            if (!fullGtU(this.zptr[i11] + i3, i9 + i3)) {
                                break;
                            }
                            int[] iArr = this.zptr;
                            iArr[i10] = iArr[i11];
                            if (i11 <= i7 - 1) {
                                i10 = i11;
                                break;
                            }
                            i10 = i11;
                        }
                        int[] iArr2 = this.zptr;
                        iArr2[i10] = i9;
                        int i12 = i8 + 1;
                        if (i12 > i2) {
                            continue;
                            break;
                        }
                        int i13 = iArr2[i12];
                        int i14 = i12;
                        while (true) {
                            int i15 = i14 - i6;
                            if (!fullGtU(this.zptr[i15] + i3, i13 + i3)) {
                                break;
                            }
                            int[] iArr3 = this.zptr;
                            iArr3[i14] = iArr3[i15];
                            if (i15 <= i7 - 1) {
                                i14 = i15;
                                break;
                            }
                            i14 = i15;
                        }
                        int[] iArr4 = this.zptr;
                        iArr4[i14] = i13;
                        int i16 = i12 + 1;
                        if (i16 > i2) {
                            continue;
                            break;
                        }
                        int i17 = iArr4[i16];
                        int i18 = i16;
                        while (true) {
                            int i19 = i18 - i6;
                            if (!fullGtU(this.zptr[i19] + i3, i17 + i3)) {
                                break;
                            }
                            int[] iArr5 = this.zptr;
                            iArr5[i18] = iArr5[i19];
                            if (i19 <= i7 - 1) {
                                i18 = i19;
                                break;
                            }
                            i18 = i19;
                        }
                        this.zptr[i18] = i17;
                        i8 = i16 + 1;
                        if (this.workDone > this.workLimit && this.firstAttempt) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void vswap(int i, int i2, int i3) {
        while (i3 > 0) {
            int[] iArr = this.zptr;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            i++;
            i2++;
            i3--;
        }
    }

    private void writeRun() throws IOException {
        int i;
        if (this.last < this.allowableBlockSize) {
            this.inUse[this.currentChar] = true;
            int i2 = 0;
            while (true) {
                i = this.runLength;
                if (i2 >= i) {
                    break;
                }
                this.mCrc.updateCRC((char) this.currentChar);
                i2++;
            }
            if (i == 1) {
                int i3 = this.last + 1;
                this.last = i3;
                this.block[i3 + 1] = (char) this.currentChar;
            } else if (i == 2) {
                int i4 = this.last + 1;
                this.last = i4;
                char[] cArr = this.block;
                int i5 = this.currentChar;
                cArr[i4 + 1] = (char) i5;
                int i6 = i4 + 1;
                this.last = i6;
                cArr[i6 + 1] = (char) i5;
            } else if (i != 3) {
                this.inUse[i - 4] = true;
                int i7 = this.last + 1;
                this.last = i7;
                char[] cArr2 = this.block;
                int i8 = this.currentChar;
                cArr2[i7 + 1] = (char) i8;
                int i9 = i7 + 1;
                this.last = i9;
                cArr2[i9 + 1] = (char) i8;
                int i10 = i9 + 1;
                this.last = i10;
                cArr2[i10 + 1] = (char) i8;
                int i11 = i10 + 1;
                this.last = i11;
                cArr2[i11 + 1] = (char) i8;
                int i12 = i11 + 1;
                this.last = i12;
                cArr2[i12 + 1] = (char) (i - 4);
            } else {
                int i13 = this.last + 1;
                this.last = i13;
                char[] cArr3 = this.block;
                int i14 = this.currentChar;
                cArr3[i13 + 1] = (char) i14;
                int i15 = i13 + 1;
                this.last = i15;
                cArr3[i15 + 1] = (char) i14;
                int i16 = i15 + 1;
                this.last = i16;
                cArr3[i16 + 1] = (char) i14;
            }
        } else {
            endBlock();
            initBlock();
            writeRun();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            finish();
            this.closed = true;
            super.close();
            this.bsStream.close();
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void finish() throws IOException {
        if (!this.finished) {
            if (this.runLength > 0) {
                writeRun();
            }
            this.currentChar = -1;
            endBlock();
            endCompression();
            this.finished = true;
            flush();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        super.flush();
        this.bsStream.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        int i2;
        int i3 = (i + 256) % 256;
        int i4 = this.currentChar;
        if (i4 == -1) {
            this.currentChar = i3;
            i2 = this.runLength + 1;
        } else if (i4 == i3) {
            int i5 = this.runLength + 1;
            this.runLength = i5;
            if (i5 > 254) {
                writeRun();
                this.currentChar = -1;
                i2 = 0;
            } else {
                return;
            }
        } else {
            writeRun();
            this.runLength = 1;
            this.currentChar = i3;
            return;
        }
        this.runLength = i2;
    }
}
