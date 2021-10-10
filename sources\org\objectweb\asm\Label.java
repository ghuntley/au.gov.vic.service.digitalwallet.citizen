package org.objectweb.asm;

import kotlin.UByte;

public class Label {
    int a;
    int b;
    int c;
    private int d;
    private int[] e;
    int f;
    int g;
    Frame h;
    Label i;
    public Object info;
    Edge j;
    Label k;

    private void a(int i2, int i3) {
        if (this.e == null) {
            this.e = new int[6];
        }
        int i4 = this.d;
        int[] iArr = this.e;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[(iArr.length + 6)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.e = iArr2;
        }
        int[] iArr3 = this.e;
        int i5 = this.d;
        int i6 = i5 + 1;
        this.d = i6;
        iArr3[i5] = i2;
        this.d = i6 + 1;
        iArr3[i6] = i3;
    }

    /* access modifiers changed from: package-private */
    public Label a() {
        Frame frame = this.h;
        return frame == null ? this : frame.b;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2, int i2) {
        int i3 = this.a;
        if ((i3 & 1024) == 0) {
            this.a = i3 | 1024;
            this.e = new int[((i2 / 32) + 1)];
        }
        int[] iArr = this.e;
        int i4 = (int) (j2 >>> 32);
        iArr[i4] = ((int) j2) | iArr[i4];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (r4 != false) goto L_0x001c;
     */
    public void a(MethodWriter methodWriter, ByteVector byteVector, int i2, boolean z) {
        int i3;
        if ((this.a & 2) == 0) {
            i3 = -1;
            if (z) {
                a(-1 - i2, byteVector.b);
            } else {
                a(i2, byteVector.b);
                byteVector.putShort(i3);
                return;
            }
        } else {
            i3 = this.c - i2;
        }
        byteVector.putInt(i3);
    }

    /* access modifiers changed from: package-private */
    public boolean a(long j2) {
        if ((this.a & 1024) == 0) {
            return false;
        }
        return (((int) j2) & this.e[(int) (j2 >>> 32)]) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Label label) {
        if ((this.a & 1024) != 0 && (label.a & 1024) != 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.e;
                if (i2 >= iArr.length) {
                    break;
                } else if ((iArr[i2] & label.e[i2]) != 0) {
                    return true;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(MethodWriter methodWriter, int i2, byte[] bArr) {
        this.a |= 2;
        this.c = i2;
        int i3 = 0;
        boolean z = false;
        while (i3 < this.d) {
            int[] iArr = this.e;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i5 >= 0) {
                int i8 = i2 - i5;
                if (i8 < -32768 || i8 > 32767) {
                    int i9 = i7 - 1;
                    int i10 = bArr[i9] & UByte.MAX_VALUE;
                    if (i10 <= 168) {
                        bArr[i9] = (byte) (i10 + 49);
                    } else {
                        bArr[i9] = (byte) (i10 + 20);
                    }
                    z = true;
                }
                bArr[i7] = (byte) (i8 >>> 8);
                bArr[i7 + 1] = (byte) i8;
            } else {
                int i11 = i5 + i2 + 1;
                int i12 = i7 + 1;
                bArr[i7] = (byte) (i11 >>> 24);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (i11 >>> 16);
                bArr[i13] = (byte) (i11 >>> 8);
                bArr[i13 + 1] = (byte) i11;
            }
            i3 = i6;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    public void b(org.objectweb.asm.Label r5, long r6, int r8) {
        /*
            r4 = this;
            r0 = r4
        L_0x0001:
            if (r0 == 0) goto L_0x005f
            org.objectweb.asm.Label r1 = r0.k
            r2 = 0
            r0.k = r2
            if (r5 == 0) goto L_0x0035
            int r2 = r0.a
            r3 = r2 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x0011
            goto L_0x003b
        L_0x0011:
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r0.a = r2
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0040
            boolean r2 = r0.a(r5)
            if (r2 != 0) goto L_0x0040
            org.objectweb.asm.Edge r2 = new org.objectweb.asm.Edge
            r2.<init>()
            int r3 = r0.f
            r2.a = r3
            org.objectweb.asm.Edge r3 = r5.j
            org.objectweb.asm.Label r3 = r3.b
            r2.b = r3
            org.objectweb.asm.Edge r3 = r0.j
            r2.c = r3
            r0.j = r2
            goto L_0x0040
        L_0x0035:
            boolean r2 = r0.a(r6)
            if (r2 == 0) goto L_0x003d
        L_0x003b:
            r0 = r1
            goto L_0x0001
        L_0x003d:
            r0.a(r6, r8)
        L_0x0040:
            org.objectweb.asm.Edge r2 = r0.j
        L_0x0042:
            if (r2 == 0) goto L_0x003b
            int r3 = r0.a
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0050
            org.objectweb.asm.Edge r3 = r0.j
            org.objectweb.asm.Edge r3 = r3.c
            if (r2 == r3) goto L_0x005c
        L_0x0050:
            org.objectweb.asm.Label r3 = r2.b
            org.objectweb.asm.Label r3 = r3.k
            if (r3 != 0) goto L_0x005c
            org.objectweb.asm.Label r3 = r2.b
            r3.k = r1
            org.objectweb.asm.Label r1 = r2.b
        L_0x005c:
            org.objectweb.asm.Edge r2 = r2.c
            goto L_0x0042
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.Label.b(org.objectweb.asm.Label, long, int):void");
    }

    public int getOffset() {
        if ((this.a & 2) != 0) {
            return this.c;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("L");
        stringBuffer.append(System.identityHashCode(this));
        return stringBuffer.toString();
    }
}
