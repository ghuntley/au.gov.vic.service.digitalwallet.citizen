package org.objectweb.asm;

import androidx.core.internal.view.SupportMenu;
import kotlin.UByte;

/* access modifiers changed from: package-private */
public class MethodWriter extends MethodVisitor {
    private ByteVector $;
    private int A;
    private Handler B;
    private Handler C;
    private int D;
    private ByteVector E;
    private int F;
    private ByteVector G;
    private int H;
    private ByteVector I;
    private Attribute J;
    private boolean K;
    private int L;
    private final int M;
    private Label N;
    private Label O;
    private Label P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private AnnotationWriter U;
    private AnnotationWriter V;
    private AnnotationWriter W;
    private AnnotationWriter X;
    private int Y;
    private int Z;
    final ClassWriter b;
    private int c;
    private final int d;
    private final int e;
    private final String f;
    String g;
    int h;
    int i;
    int j;
    int[] k;
    private ByteVector l;
    private AnnotationWriter m;
    private AnnotationWriter n;
    private AnnotationWriter[] o;
    private AnnotationWriter[] p;
    private Attribute q;
    private ByteVector r = new ByteVector();
    private int s;
    private int t;
    private int u;
    private ByteVector v;
    private int w;
    private int[] x;
    private int[] z;

    MethodWriter(ClassWriter classWriter, int i2, String str, String str2, String str3, String[] strArr, boolean z2, boolean z3) {
        super(Opcodes.ASM5);
        if (classWriter.D == null) {
            classWriter.D = this;
        } else {
            classWriter.E.mv = this;
        }
        classWriter.E = this;
        this.b = classWriter;
        this.c = i2;
        if ("<init>".equals(str)) {
            this.c |= 524288;
        }
        this.d = classWriter.newUTF8(str);
        this.e = classWriter.newUTF8(str2);
        this.f = str2;
        this.g = str3;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.j = length;
            this.k = new int[length];
            for (int i4 = 0; i4 < this.j; i4++) {
                this.k[i4] = classWriter.newClass(strArr[i4]);
            }
        }
        this.M = !z3 ? z2 ? 1 : 2 : i3;
        if (z2 || z3) {
            int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(this.f) >> 2;
            argumentsAndReturnSizes = (i2 & 8) != 0 ? argumentsAndReturnSizes - 1 : argumentsAndReturnSizes;
            this.t = argumentsAndReturnSizes;
            this.T = argumentsAndReturnSizes;
            Label label = new Label();
            this.N = label;
            label.a |= 8;
            visitLabel(this.N);
        }
    }

    private int a(int i2, int i3, int i4) {
        int i5 = i3 + 3 + i4;
        int[] iArr = this.z;
        if (iArr == null || iArr.length < i5) {
            this.z = new int[i5];
        }
        int[] iArr2 = this.z;
        iArr2[0] = i2;
        iArr2[1] = i3;
        iArr2[2] = i4;
        return 3;
    }

    static int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 24) | ((bArr[i2 + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i2 + 2] & UByte.MAX_VALUE) << 8);
    }

    static int a(int[] iArr, int[] iArr2, int i2, int i3) {
        int i4 = i3 - i2;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (i2 < iArr[i5] && iArr[i5] <= i3) {
                i4 += iArr2[i5];
            } else if (i3 < iArr[i5] && iArr[i5] <= i2) {
                i4 -= iArr2[i5];
            }
        }
        return i4;
    }

    private void a(int i2, int i3) {
        int i4;
        ByteVector byteVector;
        char c2;
        while (i2 < i3) {
            int i5 = this.z[i2];
            int i6 = -268435456 & i5;
            if (i6 == 0) {
                int i7 = i5 & 1048575;
                int i8 = i5 & 267386880;
                if (i8 == 24117248) {
                    byteVector = this.v.putByte(7);
                    ClassWriter classWriter = this.b;
                    i4 = classWriter.newClass(classWriter.H[i7].g);
                } else if (i8 != 25165824) {
                    this.v.putByte(i7);
                    i2++;
                } else {
                    byteVector = this.v.putByte(8);
                    i4 = this.b.H[i7].c;
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                int i9 = i6 >> 28;
                while (true) {
                    int i10 = i9 - 1;
                    if (i9 > 0) {
                        stringBuffer.append('[');
                        i9 = i10;
                    } else {
                        if ((i5 & 267386880) == 24117248) {
                            stringBuffer.append('L');
                            stringBuffer.append(this.b.H[i5 & 1048575].g);
                            c2 = ';';
                        } else {
                            int i11 = i5 & 15;
                            if (i11 == 1) {
                                c2 = 'I';
                            } else if (i11 == 2) {
                                c2 = 'F';
                            } else if (i11 != 3) {
                                switch (i11) {
                                    case 9:
                                        c2 = 'Z';
                                        break;
                                    case 10:
                                        c2 = 'B';
                                        break;
                                    case 11:
                                        c2 = 'C';
                                        break;
                                    case 12:
                                        c2 = 'S';
                                        break;
                                    default:
                                        c2 = 'J';
                                        break;
                                }
                            } else {
                                c2 = 'D';
                            }
                        }
                        stringBuffer.append(c2);
                        byteVector = this.v.putByte(7);
                        i4 = this.b.newClass(stringBuffer.toString());
                    }
                }
            }
            byteVector.putShort(i4);
            i2++;
        }
    }

    private void a(int i2, Label label) {
        Edge edge = new Edge();
        edge.a = i2;
        edge.b = label;
        edge.c = this.P.j;
        this.P.j = edge;
    }

    private void a(Object obj) {
        ByteVector putByte;
        int i2;
        if (obj instanceof String) {
            putByte = this.v.putByte(7);
            i2 = this.b.newClass((String) obj);
        } else if (obj instanceof Integer) {
            this.v.putByte(((Integer) obj).intValue());
            return;
        } else {
            putByte = this.v.putByte(8);
            i2 = ((Label) obj).c;
        }
        putByte.putShort(i2);
    }

    private void a(Label label, Label[] labelArr) {
        Label label2 = this.P;
        if (label2 != null) {
            if (this.M == 0) {
                label2.h.a(Opcodes.LOOKUPSWITCH, 0, (ClassWriter) null, (Item) null);
                a(0, label);
                label.a().a |= 16;
                for (int i2 = 0; i2 < labelArr.length; i2++) {
                    a(0, labelArr[i2]);
                    labelArr[i2].a().a |= 16;
                }
            } else {
                int i3 = this.Q - 1;
                this.Q = i3;
                a(i3, label);
                for (Label label3 : labelArr) {
                    a(this.Q, label3);
                }
            }
            e();
        }
    }

    static void a(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >>> 8);
        bArr[i2 + 1] = (byte) i3;
    }

    static void a(int[] iArr, int[] iArr2, Label label) {
        if ((label.a & 4) == 0) {
            label.c = a(iArr, iArr2, 0, label.c);
            label.a |= 4;
        }
    }

    static short b(byte[] bArr, int i2) {
        return (short) ((bArr[i2 + 1] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8));
    }

    private void b() {
        if (this.x != null) {
            if (this.v == null) {
                this.v = new ByteVector();
            }
            c();
            this.u++;
        }
        this.x = this.z;
        this.z = null;
    }

    private void b(Frame frame) {
        int[] iArr = frame.c;
        int[] iArr2 = frame.d;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < iArr.length) {
            int i6 = iArr[i3];
            i5++;
            if (i6 != 16777216) {
                i4 += i5;
                i5 = 0;
            }
            if (i6 == 16777220 || i6 == 16777219) {
                i3++;
            }
            i3++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i8++;
            if (i9 == 16777220 || i9 == 16777219) {
                i7++;
            }
            i7++;
        }
        int a = a(frame.b.c, i4, i8);
        int i10 = 0;
        while (i4 > 0) {
            int i11 = iArr[i10];
            int i12 = a + 1;
            this.z[a] = i11;
            if (i11 == 16777220 || i11 == 16777219) {
                i10++;
            }
            i10++;
            i4--;
            a = i12;
        }
        while (i2 < iArr2.length) {
            int i13 = iArr2[i2];
            int i14 = a + 1;
            this.z[a] = i13;
            if (i13 == 16777220 || i13 == 16777219) {
                i2++;
            }
            i2++;
            a = i14;
        }
        b();
    }

    static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f6  */
    private void c() {
        char c2;
        int i2;
        ByteVector byteVector;
        int[] iArr = this.z;
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = 0;
        if ((this.b.b & SupportMenu.USER_MASK) < 50) {
            this.v.putShort(this.z[0]).putShort(i3);
            int i6 = i3 + 3;
            a(3, i6);
            this.v.putShort(i4);
            a(i6, i4 + i6);
            return;
        }
        int[] iArr2 = this.x;
        int i7 = iArr2[1];
        int i8 = this.u == 0 ? this.z[0] : (this.z[0] - iArr2[0]) - 1;
        if (i4 == 0) {
            i2 = i3 - i7;
            switch (i2) {
                case -3:
                case -2:
                case -1:
                    i7 = i3;
                    c2 = 248;
                    break;
                case 0:
                    if (i8 >= 64) {
                        c2 = 251;
                        break;
                    } else {
                        c2 = 0;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    c2 = 252;
                    break;
            }
            if (c2 != 255) {
                int i9 = 3;
                while (true) {
                    if (i5 < i7) {
                        if (this.z[i9] != this.x[i9]) {
                            c2 = 255;
                        } else {
                            i9++;
                            i5++;
                        }
                    }
                }
            }
            if (c2 != 0) {
                if (c2 == '@') {
                    this.v.putByte(i8 + 64);
                } else if (c2 != 247) {
                    if (c2 == 248) {
                        byteVector = this.v.putByte(i2 + 251);
                    } else if (c2 == 251) {
                        byteVector = this.v.putByte(251);
                    } else if (c2 != 252) {
                        this.v.putByte(255).putShort(i8).putShort(i3);
                        int i10 = i3 + 3;
                        a(3, i10);
                        this.v.putShort(i4);
                        a(i10, i4 + i10);
                        return;
                    } else {
                        this.v.putByte(i2 + 251).putShort(i8);
                        a(i7 + 3, i3 + 3);
                        return;
                    }
                    byteVector.putShort(i8);
                    return;
                } else {
                    this.v.putByte(247).putShort(i8);
                }
                a(i3 + 3, i3 + 4);
                return;
            }
            this.v.putByte(i8);
            return;
        } else if (i3 == i7 && i4 == 1) {
            c2 = i8 < 63 ? '@' : 247;
            i2 = 0;
            if (c2 != 255) {
            }
            if (c2 != 0) {
            }
        } else {
            i2 = 0;
        }
        c2 = 255;
        if (c2 != 255) {
        }
        if (c2 != 0) {
        }
    }

    private void d() {
        int i2;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bArr = this.r.a;
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        boolean[] zArr = new boolean[this.r.b];
        int i8 = 3;
        do {
            if (i8 == 3) {
                i8 = 2;
            }
            int i9 = 0;
            while (true) {
                i2 = 218;
                c2 = 132;
                if (i9 < bArr.length) {
                    int i10 = bArr[i9] & UByte.MAX_VALUE;
                    switch (ClassWriter.a[i10]) {
                        case 0:
                        case 4:
                            i9++;
                            i5 = 0;
                            break;
                        case 1:
                        case 3:
                        case 11:
                            i9 += 2;
                            i5 = 0;
                            break;
                        case 2:
                        case 5:
                        case 6:
                        case 12:
                        case 13:
                            i9 += 3;
                            i5 = 0;
                            break;
                        case 7:
                        case 8:
                        case 10:
                            i9 += 5;
                            i5 = 0;
                            break;
                        case 9:
                            if (i10 > 201) {
                                i10 = i10 < 218 ? i10 - 49 : i10 - 20;
                                i6 = c(bArr, i9 + 1);
                            } else {
                                i6 = b(bArr, i9 + 1);
                            }
                            int a = a(iArr, iArr2, i9, i6 + i9);
                            if ((a < -32768 || a > 32767) && !zArr[i9]) {
                                int i11 = (i10 == 167 || i10 == 168) ? 2 : 5;
                                zArr[i9] = true;
                                i5 = i11;
                            } else {
                                i5 = 0;
                            }
                            i9 += 3;
                            break;
                        case 14:
                            if (i8 == 1) {
                                i7 = -(a(iArr, iArr2, 0, i9) & 3);
                            } else if (zArr[i9]) {
                                i5 = 0;
                                int i12 = (i9 + 4) - (i9 & 3);
                                i9 = i12 + (((a(bArr, i12 + 8) - a(bArr, i12 + 4)) + 1) * 4) + 12;
                                break;
                            } else {
                                i7 = i9 & 3;
                                zArr[i9] = true;
                            }
                            i5 = i7;
                            int i122 = (i9 + 4) - (i9 & 3);
                            i9 = i122 + (((a(bArr, i122 + 8) - a(bArr, i122 + 4)) + 1) * 4) + 12;
                        case 15:
                            if (i8 == 1) {
                                i5 = -(a(iArr, iArr2, 0, i9) & 3);
                            } else if (!zArr[i9]) {
                                i5 = i9 & 3;
                                zArr[i9] = true;
                            } else {
                                i5 = 0;
                            }
                            int i13 = (i9 + 4) - (i9 & 3);
                            i9 = i13 + (a(bArr, i13 + 4) * 8) + 8;
                            break;
                        case 17:
                            if ((bArr[i9 + 1] & UByte.MAX_VALUE) == 132) {
                                i9 += 6;
                                i5 = 0;
                                break;
                            }
                        case 16:
                        default:
                            i9 += 4;
                            i5 = 0;
                            break;
                    }
                    if (i5 != 0) {
                        int[] iArr3 = new int[(iArr.length + 1)];
                        int[] iArr4 = new int[(iArr2.length + 1)];
                        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                        System.arraycopy(iArr2, 0, iArr4, 0, iArr2.length);
                        iArr3[iArr.length] = i9;
                        iArr4[iArr2.length] = i5;
                        if (i5 > 0) {
                            i8 = 3;
                        }
                        iArr = iArr3;
                        iArr2 = iArr4;
                    }
                } else if (i8 < 3) {
                    i8--;
                    continue;
                }
            }
        } while (i8 != 0);
        ByteVector byteVector = new ByteVector(this.r.b);
        int i14 = 0;
        while (i14 < this.r.b) {
            int i15 = bArr[i14] & UByte.MAX_VALUE;
            switch (ClassWriter.a[i15]) {
                case 0:
                case 4:
                    byteVector.putByte(i15);
                    i14++;
                    continue;
                    i2 = 218;
                    c2 = 132;
                case 1:
                case 3:
                case 11:
                    byteVector.putByteArray(bArr, i14, 2);
                    i14 += 2;
                    continue;
                    i2 = 218;
                    c2 = 132;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    byteVector.putByteArray(bArr, i14, 3);
                    i14 += 3;
                    continue;
                    i2 = 218;
                    c2 = 132;
                case 7:
                case 8:
                    byteVector.putByteArray(bArr, i14, 5);
                    i14 += 5;
                    continue;
                    i2 = 218;
                    c2 = 132;
                case 9:
                    if (i15 > 201) {
                        i15 = i15 < i2 ? i15 - 49 : i15 - 20;
                        i3 = c(bArr, i14 + 1);
                    } else {
                        i3 = b(bArr, i14 + 1);
                    }
                    int a2 = a(iArr, iArr2, i14, i3 + i14);
                    if (zArr[i14]) {
                        if (i15 == 167) {
                            byteVector.putByte(200);
                        } else if (i15 == 168) {
                            byteVector.putByte(201);
                        } else {
                            byteVector.putByte(i15 <= 166 ? ((i15 + 1) ^ 1) - 1 : i15 ^ 1);
                            byteVector.putShort(8);
                            byteVector.putByte(200);
                            a2 -= 3;
                        }
                        byteVector.putInt(a2);
                    } else {
                        byteVector.putByte(i15);
                        byteVector.putShort(a2);
                    }
                    i14 += 3;
                    break;
                case 10:
                    int a3 = a(iArr, iArr2, i14, a(bArr, i14 + 1) + i14);
                    byteVector.putByte(i15);
                    byteVector.putInt(a3);
                    i14 += 5;
                    break;
                case 14:
                    int i16 = (i14 + 4) - (i14 & 3);
                    byteVector.putByte(Opcodes.TABLESWITCH);
                    byteVector.putByteArray(null, 0, (4 - (byteVector.b % 4)) % 4);
                    int i17 = i16 + 4;
                    byteVector.putInt(a(iArr, iArr2, i14, a(bArr, i16) + i14));
                    int a4 = a(bArr, i17);
                    int i18 = i17 + 4;
                    byteVector.putInt(a4);
                    i4 = i18 + 4;
                    byteVector.putInt(a(bArr, i4 - 4));
                    for (int a5 = (a(bArr, i18) - a4) + 1; a5 > 0; a5--) {
                        i4 += 4;
                        byteVector.putInt(a(iArr, iArr2, i14, a(bArr, i4) + i14));
                    }
                    i14 = i4;
                    break;
                case 15:
                    int i19 = (i14 + 4) - (i14 & 3);
                    byteVector.putByte(Opcodes.LOOKUPSWITCH);
                    byteVector.putByteArray(null, 0, (4 - (byteVector.b % 4)) % 4);
                    int i20 = i19 + 4;
                    byteVector.putInt(a(iArr, iArr2, i14, a(bArr, i19) + i14));
                    int a6 = a(bArr, i20);
                    i4 = i20 + 4;
                    byteVector.putInt(a6);
                    while (a6 > 0) {
                        byteVector.putInt(a(bArr, i4));
                        int i21 = i4 + 4;
                        i4 = i21 + 4;
                        byteVector.putInt(a(iArr, iArr2, i14, a(bArr, i21) + i14));
                        a6--;
                    }
                    i14 = i4;
                    break;
                case 16:
                default:
                    byteVector.putByteArray(bArr, i14, 4);
                    i14 += 4;
                    continue;
                    i2 = 218;
                    c2 = 132;
                case 17:
                    if ((bArr[i14 + 1] & UByte.MAX_VALUE) == c2) {
                        byteVector.putByteArray(bArr, i14, 6);
                        i14 += 6;
                        break;
                    } else {
                        byteVector.putByteArray(bArr, i14, 4);
                        i14 += 4;
                        break;
                    }
            }
            i2 = 218;
            c2 = 132;
        }
        if (this.M == 0) {
            for (Label label = this.N; label != null; label = label.i) {
                int i22 = label.c - 3;
                if (i22 >= 0 && zArr[i22]) {
                    label.a |= 16;
                }
                a(iArr, iArr2, label);
            }
            if (this.b.H != null) {
                for (int i23 = 0; i23 < this.b.H.length; i23++) {
                    Item item = this.b.H[i23];
                    if (item != null && item.b == 31) {
                        item.c = a(iArr, iArr2, 0, item.c);
                    }
                }
            }
        } else if (this.u > 0) {
            this.b.L = true;
        }
        for (Handler handler = this.B; handler != null; handler = handler.f) {
            a(iArr, iArr2, handler.a);
            a(iArr, iArr2, handler.b);
            a(iArr, iArr2, handler.c);
        }
        int i24 = 0;
        while (i24 < 2) {
            ByteVector byteVector2 = i24 == 0 ? this.E : this.G;
            if (byteVector2 != null) {
                byte[] bArr2 = byteVector2.a;
                for (int i25 = 0; i25 < byteVector2.b; i25 += 10) {
                    int c3 = c(bArr2, i25);
                    int a7 = a(iArr, iArr2, 0, c3);
                    a(bArr2, i25, a7);
                    int i26 = i25 + 2;
                    a(bArr2, i26, a(iArr, iArr2, 0, c3 + c(bArr2, i26)) - a7);
                }
            }
            i24++;
        }
        ByteVector byteVector3 = this.I;
        if (byteVector3 != null) {
            byte[] bArr3 = byteVector3.a;
            for (int i27 = 0; i27 < this.I.b; i27 += 4) {
                a(bArr3, i27, a(iArr, iArr2, 0, c(bArr3, i27)));
            }
        }
        for (Attribute attribute = this.J; attribute != null; attribute = attribute.a) {
            Label[] labels = attribute.getLabels();
            if (labels != null) {
                for (int length = labels.length - 1; length >= 0; length--) {
                    a(iArr, iArr2, labels[length]);
                }
            }
        }
        this.r = byteVector;
    }

    private void e() {
        if (this.M == 0) {
            Label label = new Label();
            label.h = new Frame();
            label.h.b = label;
            label.a(this, this.r.b, this.r.a);
            this.O.i = label;
            this.O = label;
        } else {
            this.P.g = this.R;
        }
        this.P = null;
    }

    private void f() {
        int i2;
        int i3;
        int i4;
        int a = a(0, this.f.length() + 1, 0);
        int i5 = this.c;
        if ((i5 & 8) == 0) {
            if ((i5 & 524288) == 0) {
                int[] iArr = this.z;
                i4 = a + 1;
                ClassWriter classWriter = this.b;
                iArr[a] = classWriter.c(classWriter.I) | 24117248;
            } else {
                i4 = a + 1;
                this.z[a] = 6;
            }
            a = i4;
        }
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char charAt = this.f.charAt(i6);
            if (charAt == 'F') {
                i2 = a + 1;
                this.z[a] = 2;
            } else if (charAt != 'L') {
                if (!(charAt == 'S' || charAt == 'I')) {
                    if (charAt == 'J') {
                        i2 = a + 1;
                        this.z[a] = 4;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i3 = a + 1;
                                    this.z[a] = 3;
                                    break;
                                default:
                                    this.z[1] = a - 3;
                                    b();
                                    return;
                            }
                        } else {
                            while (this.f.charAt(i7) == '[') {
                                i7++;
                            }
                            if (this.f.charAt(i7) == 'L') {
                                do {
                                    i7++;
                                } while (this.f.charAt(i7) != ';');
                            }
                            i3 = a + 1;
                            i7++;
                            this.z[a] = this.b.c(this.f.substring(i6, i7)) | 24117248;
                        }
                        i6 = i7;
                        a = i3;
                    }
                }
                i2 = a + 1;
                this.z[a] = 1;
            } else {
                int i8 = i7;
                while (this.f.charAt(i8) != ';') {
                    i8++;
                }
                this.z[a] = this.b.c(this.f.substring(i7, i8)) | 24117248;
                a++;
                i6 = i8 + 1;
            }
            a = i2;
            i6 = i7;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        int i2;
        if (this.h != 0) {
            return this.i + 6;
        }
        if (this.r.b <= 0) {
            i2 = 8;
        } else if (this.r.b <= 65536) {
            this.b.newUTF8("Code");
            i2 = this.r.b + 18 + (this.A * 8) + 8;
            if (this.E != null) {
                this.b.newUTF8("LocalVariableTable");
                i2 += this.E.b + 8;
            }
            if (this.G != null) {
                this.b.newUTF8("LocalVariableTypeTable");
                i2 += this.G.b + 8;
            }
            if (this.I != null) {
                this.b.newUTF8("LineNumberTable");
                i2 += this.I.b + 8;
            }
            if (this.v != null) {
                this.b.newUTF8((this.b.b & SupportMenu.USER_MASK) >= 50 ? "StackMapTable" : "StackMap");
                i2 += this.v.b + 8;
            }
            if (this.W != null) {
                this.b.newUTF8("RuntimeVisibleTypeAnnotations");
                i2 += this.W.a() + 8;
            }
            if (this.X != null) {
                this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
                i2 += this.X.a() + 8;
            }
            Attribute attribute = this.J;
            if (attribute != null) {
                i2 += attribute.a(this.b, this.r.a, this.r.b, this.s, this.t);
            }
        } else {
            throw new RuntimeException("Method code too large!");
        }
        if (this.j > 0) {
            this.b.newUTF8("Exceptions");
            i2 += (this.j * 2) + 8;
        }
        if ((this.c & 4096) != 0 && ((65535 & this.b.b) < 49 || (this.c & 262144) != 0)) {
            this.b.newUTF8("Synthetic");
            i2 += 6;
        }
        if ((this.c & 131072) != 0) {
            this.b.newUTF8("Deprecated");
            i2 += 6;
        }
        if (this.g != null) {
            this.b.newUTF8("Signature");
            this.b.newUTF8(this.g);
            i2 += 8;
        }
        if (this.$ != null) {
            this.b.newUTF8("MethodParameters");
            i2 += this.$.b + 7;
        }
        if (this.l != null) {
            this.b.newUTF8("AnnotationDefault");
            i2 += this.l.b + 6;
        }
        if (this.m != null) {
            this.b.newUTF8("RuntimeVisibleAnnotations");
            i2 += this.m.a() + 8;
        }
        if (this.n != null) {
            this.b.newUTF8("RuntimeInvisibleAnnotations");
            i2 += this.n.a() + 8;
        }
        if (this.U != null) {
            this.b.newUTF8("RuntimeVisibleTypeAnnotations");
            i2 += this.U.a() + 8;
        }
        if (this.V != null) {
            this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
            i2 += this.V.a() + 8;
        }
        if (this.o != null) {
            this.b.newUTF8("RuntimeVisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr = this.o;
            i2 += ((annotationWriterArr.length - this.S) * 2) + 7;
            for (int length = annotationWriterArr.length - 1; length >= this.S; length--) {
                AnnotationWriter[] annotationWriterArr2 = this.o;
                i2 += annotationWriterArr2[length] == null ? 0 : annotationWriterArr2[length].a();
            }
        }
        if (this.p != null) {
            this.b.newUTF8("RuntimeInvisibleParameterAnnotations");
            AnnotationWriter[] annotationWriterArr3 = this.p;
            i2 += ((annotationWriterArr3.length - this.S) * 2) + 7;
            for (int length2 = annotationWriterArr3.length - 1; length2 >= this.S; length2--) {
                AnnotationWriter[] annotationWriterArr4 = this.p;
                i2 += annotationWriterArr4[length2] == null ? 0 : annotationWriterArr4[length2].a();
            }
        }
        Attribute attribute2 = this.q;
        return attribute2 != null ? i2 + attribute2.a(this.b, null, 0, -1, -1) : i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0379  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    public final void a(ByteVector byteVector) {
        int i2;
        String str;
        Attribute attribute;
        int i3 = this.c;
        byteVector.putShort(i3 & (~(((i3 & 262144) / 64) | 917504))).putShort(this.d).putShort(this.e);
        if (this.h != 0) {
            byteVector.putByteArray(this.b.M.b, this.h, this.i);
            return;
        }
        int i4 = this.r.b > 0 ? 1 : 0;
        if (this.j > 0) {
            i4++;
        }
        if ((this.c & 4096) != 0 && ((this.b.b & SupportMenu.USER_MASK) < 49 || (this.c & 262144) != 0)) {
            i4++;
        }
        if ((this.c & 131072) != 0) {
            i4++;
        }
        if (this.g != null) {
            i4++;
        }
        if (this.$ != null) {
            i4++;
        }
        if (this.l != null) {
            i4++;
        }
        if (this.m != null) {
            i4++;
        }
        if (this.n != null) {
            i4++;
        }
        if (this.U != null) {
            i4++;
        }
        if (this.V != null) {
            i4++;
        }
        if (this.o != null) {
            i4++;
        }
        if (this.p != null) {
            i4++;
        }
        Attribute attribute2 = this.q;
        if (attribute2 != null) {
            i4 += attribute2.a();
        }
        byteVector.putShort(i4);
        if (this.r.b > 0) {
            int i5 = this.r.b + 12 + (this.A * 8);
            ByteVector byteVector2 = this.E;
            if (byteVector2 != null) {
                i5 += byteVector2.b + 8;
            }
            ByteVector byteVector3 = this.G;
            if (byteVector3 != null) {
                i5 += byteVector3.b + 8;
            }
            ByteVector byteVector4 = this.I;
            if (byteVector4 != null) {
                i5 += byteVector4.b + 8;
            }
            ByteVector byteVector5 = this.v;
            if (byteVector5 != null) {
                i5 += byteVector5.b + 8;
            }
            AnnotationWriter annotationWriter = this.W;
            if (annotationWriter != null) {
                i5 += annotationWriter.a() + 8;
            }
            AnnotationWriter annotationWriter2 = this.X;
            if (annotationWriter2 != null) {
                i5 += annotationWriter2.a() + 8;
            }
            Attribute attribute3 = this.J;
            if (attribute3 != null) {
                i5 += attribute3.a(this.b, this.r.a, this.r.b, this.s, this.t);
            }
            byteVector.putShort(this.b.newUTF8("Code")).putInt(i5);
            byteVector.putShort(this.s).putShort(this.t);
            byteVector.putInt(this.r.b).putByteArray(this.r.a, 0, this.r.b);
            byteVector.putShort(this.A);
            if (this.A > 0) {
                for (Handler handler = this.B; handler != null; handler = handler.f) {
                    byteVector.putShort(handler.a.c).putShort(handler.b.c).putShort(handler.c.c).putShort(handler.e);
                }
            }
            int i6 = this.E != null ? 1 : 0;
            if (this.G != null) {
                i6++;
            }
            if (this.I != null) {
                i6++;
            }
            if (this.v != null) {
                i6++;
            }
            if (this.W != null) {
                i6++;
            }
            if (this.X != null) {
                i6++;
            }
            Attribute attribute4 = this.J;
            if (attribute4 != null) {
                i6 += attribute4.a();
            }
            byteVector.putShort(i6);
            if (this.E != null) {
                byteVector.putShort(this.b.newUTF8("LocalVariableTable"));
                byteVector.putInt(this.E.b + 2).putShort(this.D);
                byteVector.putByteArray(this.E.a, 0, this.E.b);
            }
            if (this.G != null) {
                byteVector.putShort(this.b.newUTF8("LocalVariableTypeTable"));
                byteVector.putInt(this.G.b + 2).putShort(this.F);
                byteVector.putByteArray(this.G.a, 0, this.G.b);
            }
            if (this.I != null) {
                byteVector.putShort(this.b.newUTF8("LineNumberTable"));
                byteVector.putInt(this.I.b + 2).putShort(this.H);
                byteVector.putByteArray(this.I.a, 0, this.I.b);
            }
            if (this.v != null) {
                byteVector.putShort(this.b.newUTF8((this.b.b & SupportMenu.USER_MASK) >= 50 ? "StackMapTable" : "StackMap"));
                byteVector.putInt(this.v.b + 2).putShort(this.u);
                byteVector.putByteArray(this.v.a, 0, this.v.b);
            }
            if (this.W != null) {
                byteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
                this.W.a(byteVector);
            }
            if (this.X != null) {
                byteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
                this.X.a(byteVector);
            }
            Attribute attribute5 = this.J;
            if (attribute5 != null) {
                i2 = 2;
                str = "RuntimeVisibleTypeAnnotations";
                attribute5.a(this.b, this.r.a, this.r.b, this.t, this.s, byteVector);
                if (this.j > 0) {
                    byteVector.putShort(this.b.newUTF8("Exceptions")).putInt((this.j * i2) + i2);
                    byteVector.putShort(this.j);
                    for (int i7 = 0; i7 < this.j; i7++) {
                        byteVector.putShort(this.k[i7]);
                    }
                }
                if ((this.c & 4096) != 0 && ((this.b.b & SupportMenu.USER_MASK) < 49 || (this.c & 262144) != 0)) {
                    byteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
                }
                if ((this.c & 131072) != 0) {
                    byteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0);
                }
                if (this.g != null) {
                    byteVector.putShort(this.b.newUTF8("Signature")).putInt(i2).putShort(this.b.newUTF8(this.g));
                }
                if (this.$ != null) {
                    byteVector.putShort(this.b.newUTF8("MethodParameters"));
                    byteVector.putInt(this.$.b + 1).putByte(this.Z);
                    byteVector.putByteArray(this.$.a, 0, this.$.b);
                }
                if (this.l != null) {
                    byteVector.putShort(this.b.newUTF8("AnnotationDefault"));
                    byteVector.putInt(this.l.b);
                    byteVector.putByteArray(this.l.a, 0, this.l.b);
                }
                if (this.m != null) {
                    byteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
                    this.m.a(byteVector);
                }
                if (this.n != null) {
                    byteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
                    this.n.a(byteVector);
                }
                if (this.U != null) {
                    byteVector.putShort(this.b.newUTF8(str));
                    this.U.a(byteVector);
                }
                if (this.V != null) {
                    byteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
                    this.V.a(byteVector);
                }
                if (this.o != null) {
                    byteVector.putShort(this.b.newUTF8("RuntimeVisibleParameterAnnotations"));
                    AnnotationWriter.a(this.o, this.S, byteVector);
                }
                if (this.p != null) {
                    byteVector.putShort(this.b.newUTF8("RuntimeInvisibleParameterAnnotations"));
                    AnnotationWriter.a(this.p, this.S, byteVector);
                }
                attribute = this.q;
                if (attribute == null) {
                    attribute.a(this.b, null, 0, -1, -1, byteVector);
                    return;
                }
                return;
            }
        }
        i2 = 2;
        str = "RuntimeVisibleTypeAnnotations";
        if (this.j > 0) {
        }
        byteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
        if ((this.c & 131072) != 0) {
        }
        if (this.g != null) {
        }
        if (this.$ != null) {
        }
        if (this.l != null) {
        }
        if (this.m != null) {
        }
        if (this.n != null) {
        }
        if (this.U != null) {
        }
        if (this.V != null) {
        }
        if (this.o != null) {
        }
        if (this.p != null) {
        }
        attribute = this.q;
        if (attribute == null) {
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
        if (z2) {
            annotationWriter.g = this.m;
            this.m = annotationWriter;
        } else {
            annotationWriter.g = this.n;
            this.n = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        ByteVector byteVector = new ByteVector();
        this.l = byteVector;
        return new AnnotationWriter(this.b, false, byteVector, null, 0);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitAttribute(Attribute attribute) {
        if (attribute.isCodeAttribute()) {
            attribute.a = this.J;
            this.J = attribute;
            return;
        }
        attribute.a = this.q;
        this.q = attribute;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitCode() {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitEnd() {
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFieldInsn(int i2, String str, String str2, String str3) {
        int i3;
        int i4;
        this.Y = this.r.b;
        Item a = this.b.a(str, str2, str3);
        Label label = this.P;
        if (label != null) {
            int i5 = 0;
            if (this.M == 0) {
                label.h.a(i2, 0, this.b, a);
            } else {
                char charAt = str3.charAt(0);
                int i6 = 1;
                int i7 = -2;
                switch (i2) {
                    case Opcodes.GETSTATIC:
                        int i8 = this.Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i6 = 2;
                        }
                        i3 = i8 + i6;
                        break;
                    case Opcodes.PUTSTATIC:
                        i4 = this.Q;
                        if (!(charAt == 'D' || charAt == 'J')) {
                            i7 = -1;
                        }
                        i3 = i7 + i4;
                        break;
                    case 180:
                        int i9 = this.Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i5 = 1;
                        }
                        i3 = i9 + i5;
                        break;
                    default:
                        i4 = this.Q;
                        if (charAt == 'D' || charAt == 'J') {
                            i7 = -3;
                        }
                        i3 = i7 + i4;
                        break;
                }
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
        }
        this.r.b(i2, a.a);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFrame(int i2, int i3, Object[] objArr, int i4, Object[] objArr2) {
        int i5;
        ByteVector byteVector;
        int i6;
        int i7;
        if (this.M != 0) {
            int i8 = 0;
            if (i2 == -1) {
                if (this.x == null) {
                    f();
                }
                this.T = i3;
                int a = a(this.r.b, i3, i4);
                for (int i9 = 0; i9 < i3; i9++) {
                    if (objArr[i9] instanceof String) {
                        i7 = a + 1;
                        this.z[a] = 24117248 | this.b.c((String) objArr[i9]);
                    } else if (objArr[i9] instanceof Integer) {
                        i7 = a + 1;
                        this.z[a] = ((Integer) objArr[i9]).intValue();
                    } else {
                        this.z[a] = this.b.a("", ((Label) objArr[i9]).c) | 25165824;
                        a++;
                    }
                    a = i7;
                }
                while (i8 < i4) {
                    if (objArr2[i8] instanceof String) {
                        i6 = a + 1;
                        this.z[a] = this.b.c((String) objArr2[i8]) | 24117248;
                    } else if (objArr2[i8] instanceof Integer) {
                        i6 = a + 1;
                        this.z[a] = ((Integer) objArr2[i8]).intValue();
                    } else {
                        i6 = a + 1;
                        this.z[a] = this.b.a("", ((Label) objArr2[i8]).c) | 25165824;
                    }
                    a = i6;
                    i8++;
                }
                b();
            } else {
                if (this.v == null) {
                    this.v = new ByteVector();
                    i5 = this.r.b;
                } else {
                    i5 = (this.r.b - this.w) - 1;
                    if (i5 < 0) {
                        if (i2 != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                if (i2 == 0) {
                    this.T = i3;
                    this.v.putByte(255).putShort(i5).putShort(i3);
                    for (int i10 = 0; i10 < i3; i10++) {
                        a(objArr[i10]);
                    }
                    this.v.putShort(i4);
                    while (i8 < i4) {
                        a(objArr2[i8]);
                        i8++;
                    }
                } else if (i2 != 1) {
                    int i11 = 251;
                    if (i2 == 2) {
                        this.T -= i3;
                        byteVector = this.v;
                        i11 = 251 - i3;
                    } else if (i2 == 3) {
                        byteVector = this.v;
                        if (i5 < 64) {
                            byteVector.putByte(i5);
                        }
                    } else if (i2 == 4) {
                        ByteVector byteVector2 = this.v;
                        if (i5 < 64) {
                            byteVector2.putByte(i5 + 64);
                        } else {
                            byteVector2.putByte(247).putShort(i5);
                        }
                        a(objArr2[0]);
                    }
                    byteVector.putByte(i11).putShort(i5);
                } else {
                    this.T += i3;
                    this.v.putByte(i3 + 251).putShort(i5);
                    while (i8 < i3) {
                        a(objArr[i8]);
                        i8++;
                    }
                }
                this.w = this.r.b;
                this.u++;
            }
            this.s = Math.max(this.s, i4);
            this.t = Math.max(this.t, this.T);
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIincInsn(int i2, int i3) {
        int i4;
        this.Y = this.r.b;
        Label label = this.P;
        if (label != null && this.M == 0) {
            label.h.a(Opcodes.IINC, i2, (ClassWriter) null, (Item) null);
        }
        if (this.M != 2 && (i4 = i2 + 1) > this.t) {
            this.t = i4;
        }
        if (i2 > 255 || i3 > 127 || i3 < -128) {
            this.r.putByte(196).b(Opcodes.IINC, i2).putShort(i3);
        } else {
            this.r.putByte(Opcodes.IINC).a(i2, i3);
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInsn(int i2) {
        this.Y = this.r.b;
        this.r.putByte(i2);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, 0, (ClassWriter) null, (Item) null);
            } else {
                int i3 = this.Q + Frame.a[i2];
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
            if ((i2 >= 172 && i2 <= 177) || i2 == 191) {
                e();
            }
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitInsnAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a((i2 & -16776961) | (this.Y << 8), typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (z2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIntInsn(int i2, int i3) {
        this.Y = this.r.b;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, i3, (ClassWriter) null, (Item) null);
            } else if (i2 != 188) {
                int i4 = this.Q + 1;
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        if (i2 == 17) {
            this.r.b(i2, i3);
        } else {
            this.r.a(i2, i3);
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        this.Y = this.r.b;
        Item a = this.b.a(str, str2, handle, objArr);
        int i2 = a.c;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(Opcodes.INVOKEDYNAMIC, 0, this.b, a);
            } else {
                if (i2 == 0) {
                    i2 = Type.getArgumentsAndReturnSizes(str2);
                    a.c = i2;
                }
                int i3 = (this.Q - (i2 >> 2)) + (i2 & 3) + 1;
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
        }
        this.r.b(Opcodes.INVOKEDYNAMIC, a.a);
        this.r.putShort(0);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitJumpInsn(int i2, Label label) {
        this.Y = this.r.b;
        Label label2 = this.P;
        Label label3 = null;
        if (label2 != null) {
            if (this.M == 0) {
                label2.h.a(i2, 0, (ClassWriter) null, (Item) null);
                label.a().a |= 16;
                a(0, label);
                if (i2 != 167) {
                    label3 = new Label();
                }
            } else if (i2 == 168) {
                if ((label.a & 512) == 0) {
                    label.a |= 512;
                    this.L++;
                }
                this.P.a |= 128;
                a(this.Q + 1, label);
                label3 = new Label();
            } else {
                int i3 = this.Q + Frame.a[i2];
                this.Q = i3;
                a(i3, label);
            }
        }
        if ((label.a & 2) == 0 || label.c - this.r.b >= -32768) {
            this.r.putByte(i2);
            ByteVector byteVector = this.r;
            label.a(this, byteVector, byteVector.b - 1, false);
        } else {
            if (i2 != 167) {
                if (i2 == 168) {
                    this.r.putByte(201);
                    ByteVector byteVector2 = this.r;
                    label.a(this, byteVector2, byteVector2.b - 1, true);
                } else {
                    if (label3 != null) {
                        label3.a |= 16;
                    }
                    this.r.putByte(i2 <= 166 ? ((i2 + 1) ^ 1) - 1 : i2 ^ 1);
                    this.r.putShort(8);
                }
            }
            this.r.putByte(200);
            ByteVector byteVector22 = this.r;
            label.a(this, byteVector22, byteVector22.b - 1, true);
        }
        if (this.P != null) {
            if (label3 != null) {
                visitLabel(label3);
            }
            if (i2 == 167) {
                e();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        if (r0 != null) goto L_0x008d;
     */
    @Override // org.objectweb.asm.MethodVisitor
    public void visitLabel(Label label) {
        Label label2;
        this.K |= label.a(this, this.r.b, this.r.a);
        if ((label.a & 1) == 0) {
            int i2 = this.M;
            if (i2 == 0) {
                if (this.P != null) {
                    if (label.c == this.P.c) {
                        this.P.a |= label.a & 16;
                        label.h = this.P.h;
                        return;
                    }
                    a(0, label);
                }
                this.P = label;
                if (label.h == null) {
                    label.h = new Frame();
                    label.h.b = label;
                }
                if (this.O != null) {
                    if (label.c == this.O.c) {
                        this.O.a |= label.a & 16;
                        label.h = this.O.h;
                        this.P = this.O;
                        return;
                    }
                    label2 = this.O;
                }
                this.O = label;
            } else if (i2 == 1) {
                Label label3 = this.P;
                if (label3 != null) {
                    label3.g = this.R;
                    a(this.Q, label);
                }
                this.P = label;
                this.Q = 0;
                this.R = 0;
                label2 = this.O;
            } else {
                return;
            }
            label2.i = label;
            this.O = label;
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        ByteVector byteVector;
        int i2;
        this.Y = this.r.b;
        Item a = this.b.a(obj);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(18, 0, this.b, a);
            } else {
                int i3 = (a.b == 5 || a.b == 6) ? this.Q + 2 : this.Q + 1;
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
        }
        int i4 = a.a;
        if (a.b == 5 || a.b == 6) {
            byteVector = this.r;
            i2 = 20;
        } else if (i4 >= 256) {
            byteVector = this.r;
            i2 = 19;
        } else {
            this.r.a(18, i4);
            return;
        }
        byteVector.b(i2, i4);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLineNumber(int i2, Label label) {
        if (this.I == null) {
            this.I = new ByteVector();
        }
        this.H++;
        this.I.putShort(label.c);
        this.I.putShort(i2);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i2) {
        int i3 = 1;
        if (str3 != null) {
            if (this.G == null) {
                this.G = new ByteVector();
            }
            this.F++;
            this.G.putShort(label.c).putShort(label2.c - label.c).putShort(this.b.newUTF8(str)).putShort(this.b.newUTF8(str3)).putShort(i2);
        }
        if (this.E == null) {
            this.E = new ByteVector();
        }
        this.D++;
        this.E.putShort(label.c).putShort(label2.c - label.c).putShort(this.b.newUTF8(str)).putShort(this.b.newUTF8(str2)).putShort(i2);
        if (this.M != 2) {
            char charAt = str2.charAt(0);
            if (charAt == 'J' || charAt == 'D') {
                i3 = 2;
            }
            int i4 = i2 + i3;
            if (i4 > this.t) {
                this.t = i4;
            }
        }
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitLocalVariableAnnotation(int i2, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putByte(i2 >>> 24).putShort(labelArr.length);
        for (int i3 = 0; i3 < labelArr.length; i3++) {
            byteVector.putShort(labelArr[i3].c).putShort(labelArr2[i3].c - labelArr[i3].c).putShort(iArr[i3]);
        }
        if (typePath == null) {
            byteVector.putByte(0);
        } else {
            byteVector.putByteArray(typePath.a, typePath.b, (typePath.a[typePath.b] * 2) + 1);
        }
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (z2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        this.Y = this.r.b;
        int i2 = this.r.b;
        this.r.putByte(Opcodes.LOOKUPSWITCH);
        ByteVector byteVector = this.r;
        byteVector.putByteArray(null, 0, (4 - (byteVector.b % 4)) % 4);
        label.a(this, this.r, i2, true);
        this.r.putInt(labelArr.length);
        for (int i3 = 0; i3 < labelArr.length; i3++) {
            this.r.putInt(iArr[i3]);
            labelArr[i3].a(this, this.r, i2, true);
        }
        a(label, labelArr);
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    @Override // org.objectweb.asm.MethodVisitor
    public void visitMaxs(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 507
        */
        throw new UnsupportedOperationException("Method not decompiled: org.objectweb.asm.MethodWriter.visitMaxs(int, int):void");
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int i2, String str, String str2, String str3, boolean z2) {
        this.Y = this.r.b;
        Item a = this.b.a(str, str2, str3, z2);
        int i3 = a.c;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, 0, this.b, a);
            } else {
                if (i3 == 0) {
                    i3 = Type.getArgumentsAndReturnSizes(str3);
                    a.c = i3;
                }
                int i4 = i2 == 184 ? (this.Q - (i3 >> 2)) + (i3 & 3) + 1 : (this.Q - (i3 >> 2)) + (i3 & 3);
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        if (i2 == 185) {
            if (i3 == 0) {
                i3 = Type.getArgumentsAndReturnSizes(str3);
                a.c = i3;
            }
            this.r.b(Opcodes.INVOKEINTERFACE, a.a).a(i3 >> 2, 0);
            return;
        }
        this.r.b(i2, a.a);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String str, int i2) {
        this.Y = this.r.b;
        Item a = this.b.a(str);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(Opcodes.MULTIANEWARRAY, i2, this.b, a);
            } else {
                this.Q += 1 - i2;
            }
        }
        this.r.b(Opcodes.MULTIANEWARRAY, a.a).putByte(i2);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitParameter(String str, int i2) {
        if (this.$ == null) {
            this.$ = new ByteVector();
        }
        this.Z++;
        this.$.putShort(str == null ? 0 : this.b.newUTF8(str)).putShort(i2);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int i2, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.S = Math.max(this.S, i2 + 1);
            return new AnnotationWriter(this.b, false, byteVector, null, 0);
        }
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
        if (z2) {
            if (this.o == null) {
                this.o = new AnnotationWriter[Type.getArgumentTypes(this.f).length];
            }
            annotationWriter.g = this.o[i2];
            this.o[i2] = annotationWriter;
        } else {
            if (this.p == null) {
                this.p = new AnnotationWriter[Type.getArgumentTypes(this.f).length];
            }
            annotationWriter.g = this.p[i2];
            this.p[i2] = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTableSwitchInsn(int i2, int i3, Label label, Label... labelArr) {
        this.Y = this.r.b;
        int i4 = this.r.b;
        this.r.putByte(Opcodes.TABLESWITCH);
        ByteVector byteVector = this.r;
        byteVector.putByteArray(null, 0, (4 - (byteVector.b % 4)) % 4);
        label.a(this, this.r, i4, true);
        this.r.putInt(i2).putInt(i3);
        for (Label label2 : labelArr) {
            label2.a(this, this.r, i4, true);
        }
        a(label, labelArr);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitTryCatchAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (z2) {
            annotationWriter.g = this.W;
            this.W = annotationWriter;
        } else {
            annotationWriter.g = this.X;
            this.X = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        this.A++;
        Handler handler = new Handler();
        handler.a = label;
        handler.b = label2;
        handler.c = label3;
        handler.d = str;
        handler.e = str != null ? this.b.newClass(str) : 0;
        Handler handler2 = this.C;
        if (handler2 == null) {
            this.B = handler;
        } else {
            handler2.f = handler;
        }
        this.C = handler;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitTypeAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (z2) {
            annotationWriter.g = this.U;
            this.U = annotationWriter;
        } else {
            annotationWriter.g = this.V;
            this.V = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitTypeInsn(int i2, String str) {
        this.Y = this.r.b;
        Item a = this.b.a(str);
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, this.r.b, this.b, a);
            } else if (i2 == 187) {
                int i3 = this.Q + 1;
                if (i3 > this.R) {
                    this.R = i3;
                }
                this.Q = i3;
            }
        }
        this.r.b(i2, a.a);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitVarInsn(int i2, int i3) {
        this.Y = this.r.b;
        Label label = this.P;
        if (label != null) {
            if (this.M == 0) {
                label.h.a(i2, i3, (ClassWriter) null, (Item) null);
            } else if (i2 == 169) {
                label.a |= 256;
                this.P.f = this.Q;
                e();
            } else {
                int i4 = this.Q + Frame.a[i2];
                if (i4 > this.R) {
                    this.R = i4;
                }
                this.Q = i4;
            }
        }
        if (this.M != 2) {
            int i5 = (i2 == 22 || i2 == 24 || i2 == 55 || i2 == 57) ? i3 + 2 : i3 + 1;
            if (i5 > this.t) {
                this.t = i5;
            }
        }
        if (i3 >= 4 || i2 == 169) {
            ByteVector byteVector = this.r;
            if (i3 >= 256) {
                byteVector.putByte(196).b(i2, i3);
            } else {
                byteVector.a(i2, i3);
            }
        } else {
            this.r.putByte((i2 < 54 ? ((i2 - 21) << 2) + 26 : ((i2 - 54) << 2) + 59) + i3);
        }
        if (i2 >= 54 && this.M == 0 && this.A > 0) {
            visitLabel(new Label());
        }
    }
}
