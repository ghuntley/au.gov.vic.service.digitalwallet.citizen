package org.objectweb.asm;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

public class ClassReader {
    public static final int EXPAND_FRAMES = 8;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    private final int[] a;
    public final byte[] b;
    private final String[] c;
    private final int d;
    public final int header;

    public ClassReader(InputStream inputStream) throws IOException {
        this(a(inputStream, false));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ClassReader(String str) throws IOException {
        this(a(ClassLoader.getSystemResourceAsStream(r0.toString()), true));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append(".class");
    }

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        this.b = bArr;
        if (readShort(i + 6) <= 52) {
            int[] iArr = new int[readUnsignedShort(i + 8)];
            this.a = iArr;
            int length = iArr.length;
            this.c = new String[length];
            int i3 = 0;
            int i4 = i + 10;
            int i5 = 1;
            while (i5 < length) {
                int i6 = i4 + 1;
                this.a[i5] = i6;
                byte b2 = bArr[i4];
                int i7 = 5;
                if (b2 == 1) {
                    i7 = readUnsignedShort(i6) + 3;
                    if (i7 > i3) {
                        i3 = i7;
                    }
                } else if (b2 == 15) {
                    i7 = 4;
                } else if (!(b2 == 18 || b2 == 3 || b2 == 4)) {
                    if (b2 == 5 || b2 == 6) {
                        i7 = 9;
                        i5++;
                    } else {
                        switch (b2) {
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                break;
                            default:
                                i7 = 3;
                                continue;
                        }
                    }
                }
                i4 += i7;
                i5++;
            }
            this.d = i3;
            this.header = i4;
            return;
        }
        throw new IllegalArgumentException();
    }

    private int a() {
        int i = this.header;
        int readUnsignedShort = i + 8 + (readUnsignedShort(i + 6) * 2);
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                readUnsignedShort += readInt(readUnsignedShort + 12) + 6;
            }
            readUnsignedShort += 8;
        }
        int i2 = readUnsignedShort + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i2); readUnsignedShort4 > 0; readUnsignedShort4--) {
            for (int readUnsignedShort5 = readUnsignedShort(i2 + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i2 += readInt(i2 + 12) + 6;
            }
            i2 += 8;
        }
        return i2 + 2;
    }

    private int a(int i, boolean z, boolean z2, Context context) {
        int i2;
        int i3;
        char[] cArr = context.c;
        Label[] labelArr = context.h;
        if (z) {
            int i4 = i + 1;
            i2 = this.b[i] & UByte.MAX_VALUE;
            i3 = i4;
        } else {
            context.o = -1;
            i3 = i;
            i2 = 255;
        }
        int i5 = 0;
        context.r = 0;
        if (i2 < 64) {
            context.p = 3;
            context.t = 0;
        } else if (i2 < 128) {
            i2 -= 64;
            i3 = a(context.u, 0, i3, cArr, labelArr);
            context.p = 4;
            context.t = 1;
        } else {
            int readUnsignedShort = readUnsignedShort(i3);
            i3 += 2;
            if (i2 == 247) {
                i3 = a(context.u, 0, i3, cArr, labelArr);
                context.p = 4;
                context.t = 1;
            } else {
                if (i2 >= 248 && i2 < 251) {
                    context.p = 2;
                    context.r = 251 - i2;
                    context.q -= context.r;
                } else if (i2 == 251) {
                    context.p = 3;
                } else if (i2 < 255) {
                    int i6 = i2 - 251;
                    int i7 = z2 ? context.q : 0;
                    int i8 = i6;
                    while (i8 > 0) {
                        i3 = a(context.s, i7, i3, cArr, labelArr);
                        i8--;
                        i7++;
                    }
                    context.p = 1;
                    context.r = i6;
                    context.q += context.r;
                } else {
                    context.p = 0;
                    int readUnsignedShort2 = readUnsignedShort(i3);
                    int i9 = i3 + 2;
                    context.r = readUnsignedShort2;
                    context.q = readUnsignedShort2;
                    int i10 = 0;
                    while (readUnsignedShort2 > 0) {
                        i9 = a(context.s, i10, i9, cArr, labelArr);
                        readUnsignedShort2--;
                        i10++;
                    }
                    int readUnsignedShort3 = readUnsignedShort(i9);
                    i3 = i9 + 2;
                    context.t = readUnsignedShort3;
                    while (readUnsignedShort3 > 0) {
                        i5++;
                        i3 = a(context.u, i5, i3, cArr, labelArr);
                        readUnsignedShort3--;
                    }
                }
                context.t = 0;
            }
            i2 = readUnsignedShort;
        }
        context.o += i2 + 1;
        readLabel(context.o, labelArr);
        return i3;
    }

    private int a(int i, char[] cArr, String str, AnnotationVisitor annotationVisitor) {
        Object obj;
        Object sh;
        int i2 = 0;
        if (annotationVisitor == null) {
            int i3 = this.b[i] & UByte.MAX_VALUE;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : a(i + 1, cArr, false, (AnnotationVisitor) null) : a(i + 3, cArr, true, (AnnotationVisitor) null);
        }
        int i4 = i + 1;
        int i5 = this.b[i] & UByte.MAX_VALUE;
        if (i5 == 64) {
            return a(i4 + 2, cArr, true, annotationVisitor.visitAnnotation(str, readUTF8(i4, cArr)));
        }
        if (i5 != 70) {
            if (i5 != 83) {
                if (i5 == 99) {
                    obj = Type.getType(readUTF8(i4, cArr));
                } else if (i5 == 101) {
                    annotationVisitor.visitEnum(str, readUTF8(i4, cArr), readUTF8(i4 + 2, cArr));
                    return i4 + 4;
                } else if (i5 == 115) {
                    obj = readUTF8(i4, cArr);
                } else if (!(i5 == 73 || i5 == 74)) {
                    if (i5 == 90) {
                        obj = readInt(this.a[readUnsignedShort(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE;
                    } else if (i5 != 91) {
                        switch (i5) {
                            case 66:
                                sh = new Byte((byte) readInt(this.a[readUnsignedShort(i4)]));
                                break;
                            case 67:
                                sh = new Character((char) readInt(this.a[readUnsignedShort(i4)]));
                                break;
                            case 68:
                                break;
                            default:
                                return i4;
                        }
                    } else {
                        int readUnsignedShort = readUnsignedShort(i4);
                        int i6 = i4 + 2;
                        if (readUnsignedShort == 0) {
                            return a(i6 - 2, cArr, false, annotationVisitor.visitArray(str));
                        }
                        int i7 = i6 + 1;
                        int i8 = this.b[i6] & UByte.MAX_VALUE;
                        if (i8 == 70) {
                            float[] fArr = new float[readUnsignedShort];
                            while (i2 < readUnsignedShort) {
                                fArr[i2] = Float.intBitsToFloat(readInt(this.a[readUnsignedShort(i7)]));
                                i7 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, fArr);
                        } else if (i8 == 83) {
                            short[] sArr = new short[readUnsignedShort];
                            while (i2 < readUnsignedShort) {
                                sArr[i2] = (short) readInt(this.a[readUnsignedShort(i7)]);
                                i7 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, sArr);
                        } else if (i8 == 90) {
                            boolean[] zArr = new boolean[readUnsignedShort];
                            for (int i9 = 0; i9 < readUnsignedShort; i9++) {
                                zArr[i9] = readInt(this.a[readUnsignedShort(i7)]) != 0;
                                i7 += 3;
                            }
                            annotationVisitor.visit(str, zArr);
                        } else if (i8 == 73) {
                            int[] iArr = new int[readUnsignedShort];
                            while (i2 < readUnsignedShort) {
                                iArr[i2] = readInt(this.a[readUnsignedShort(i7)]);
                                i7 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, iArr);
                        } else if (i8 != 74) {
                            switch (i8) {
                                case 66:
                                    byte[] bArr = new byte[readUnsignedShort];
                                    while (i2 < readUnsignedShort) {
                                        bArr[i2] = (byte) readInt(this.a[readUnsignedShort(i7)]);
                                        i7 += 3;
                                        i2++;
                                    }
                                    annotationVisitor.visit(str, bArr);
                                    break;
                                case 67:
                                    char[] cArr2 = new char[readUnsignedShort];
                                    while (i2 < readUnsignedShort) {
                                        cArr2[i2] = (char) readInt(this.a[readUnsignedShort(i7)]);
                                        i7 += 3;
                                        i2++;
                                    }
                                    annotationVisitor.visit(str, cArr2);
                                    break;
                                case 68:
                                    double[] dArr = new double[readUnsignedShort];
                                    while (i2 < readUnsignedShort) {
                                        dArr[i2] = Double.longBitsToDouble(readLong(this.a[readUnsignedShort(i7)]));
                                        i7 += 3;
                                        i2++;
                                    }
                                    annotationVisitor.visit(str, dArr);
                                    break;
                                default:
                                    return a(i7 - 3, cArr, false, annotationVisitor.visitArray(str));
                            }
                        } else {
                            long[] jArr = new long[readUnsignedShort];
                            while (i2 < readUnsignedShort) {
                                jArr[i2] = readLong(this.a[readUnsignedShort(i7)]);
                                i7 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, jArr);
                        }
                        return i7 - 1;
                    }
                }
                annotationVisitor.visit(str, obj);
                return i4 + 2;
            }
            sh = new Short((short) readInt(this.a[readUnsignedShort(i4)]));
            annotationVisitor.visit(str, sh);
            return i4 + 2;
        }
        obj = readConst(readUnsignedShort(i4), cArr);
        annotationVisitor.visit(str, obj);
        return i4 + 2;
    }

    private int a(int i, char[] cArr, boolean z, AnnotationVisitor annotationVisitor) {
        int readUnsignedShort = readUnsignedShort(i);
        int i2 = i + 2;
        if (z) {
            while (readUnsignedShort > 0) {
                i2 = a(i2 + 2, cArr, readUTF8(i2, cArr), annotationVisitor);
                readUnsignedShort--;
            }
        } else {
            while (readUnsignedShort > 0) {
                i2 = a(i2, cArr, (String) null, annotationVisitor);
                readUnsignedShort--;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return i2;
    }

    private int a(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        Context context2 = context;
        char[] cArr = context2.c;
        int readUnsignedShort = readUnsignedShort(i);
        String readUTF8 = readUTF8(i + 2, cArr);
        String readUTF82 = readUTF8(i + 4, cArr);
        int i3 = i + 6;
        int i4 = i3;
        int i5 = readUnsignedShort;
        int readUnsignedShort2 = readUnsignedShort(i3);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Attribute attribute = null;
        String str = null;
        Object obj = null;
        while (readUnsignedShort2 > 0) {
            String readUTF83 = readUTF8(i4 + 2, cArr);
            if ("ConstantValue".equals(readUTF83)) {
                int readUnsignedShort3 = readUnsignedShort(i4 + 8);
                obj = readUnsignedShort3 == 0 ? null : readConst(readUnsignedShort3, cArr);
            } else if ("Signature".equals(readUTF83)) {
                str = readUTF8(i4 + 8, cArr);
            } else {
                if ("Deprecated".equals(readUTF83)) {
                    i2 = 131072;
                } else if ("Synthetic".equals(readUTF83)) {
                    i2 = 266240;
                } else if ("RuntimeVisibleAnnotations".equals(readUTF83)) {
                    i9 = i4 + 8;
                } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF83)) {
                    i7 = i4 + 8;
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF83)) {
                    i8 = i4 + 8;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF83)) {
                    i6 = i4 + 8;
                } else {
                    attribute = a(context2.a, readUTF83, i4 + 8, readInt(i4 + 4), cArr, -1, null);
                    if (attribute != null) {
                        attribute.a = attribute;
                        i8 = i8;
                    } else {
                        i8 = i8;
                        attribute = attribute;
                    }
                    i9 = i9;
                    i6 = i6;
                    i7 = i7;
                }
                i5 |= i2;
            }
            i4 += readInt(i4 + 4) + 6;
            readUnsignedShort2--;
            context2 = context;
        }
        Attribute attribute2 = attribute;
        int i10 = i4 + 2;
        FieldVisitor visitField = classVisitor.visitField(i5, readUTF8, readUTF82, str, obj);
        if (visitField == null) {
            return i10;
        }
        if (i9 != 0) {
            int i11 = i9 + 2;
            for (int readUnsignedShort4 = readUnsignedShort(i9); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i11 = a(i11 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i11, cArr), true));
            }
        }
        if (i8 != 0) {
            int i12 = i8 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i12 = a(i12 + 2, cArr, true, visitField.visitAnnotation(readUTF8(i12, cArr), false));
            }
        }
        if (i7 != 0) {
            int i13 = i7 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i7); readUnsignedShort6 > 0; readUnsignedShort6--) {
                int a2 = a(context, i13);
                i13 = a(a2 + 2, cArr, true, visitField.visitTypeAnnotation(context.i, context.j, readUTF8(a2, cArr), true));
            }
        }
        if (i6 != 0) {
            int i14 = i6 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i6); readUnsignedShort7 > 0; readUnsignedShort7--) {
                int a3 = a(context, i14);
                i14 = a(a3 + 2, cArr, true, visitField.visitTypeAnnotation(context.i, context.j, readUTF8(a3, cArr), false));
            }
        }
        while (attribute2 != null) {
            Attribute attribute3 = attribute2.a;
            attribute2.a = null;
            visitField.visitAttribute(attribute2);
            attribute2 = attribute3;
        }
        visitField.visitEnd();
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    private int a(Context context, int i) {
        int i2;
        int i3;
        int readInt = readInt(i);
        int i4 = readInt >>> 24;
        if (!(i4 == 0 || i4 == 1)) {
            int i5 = ViewCompat.MEASURED_STATE_MASK;
            if (i4 == 64 || i4 == 65) {
                i3 = readInt & ViewCompat.MEASURED_STATE_MASK;
                int readUnsignedShort = readUnsignedShort(i + 1);
                context.l = new Label[readUnsignedShort];
                context.m = new Label[readUnsignedShort];
                context.n = new int[readUnsignedShort];
                i2 = i + 3;
                for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                    int readUnsignedShort2 = readUnsignedShort(i2);
                    int readUnsignedShort3 = readUnsignedShort(i2 + 2);
                    context.l[i6] = readLabel(readUnsignedShort2, context.h);
                    context.m[i6] = readLabel(readUnsignedShort2 + readUnsignedShort3, context.h);
                    context.n[i6] = readUnsignedShort(i2 + 4);
                    i2 += 6;
                }
                int readByte = readByte(i2);
                context.i = i3;
                context.j = readByte == 0 ? null : new TypePath(this.b, i2);
                return i2 + 1 + (readByte * 2);
            }
            switch (i4) {
                case 19:
                case 20:
                case 21:
                    i3 = readInt & ViewCompat.MEASURED_STATE_MASK;
                    i2 = i + 1;
                    break;
                case 22:
                    break;
                default:
                    switch (i4) {
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i3 = readInt & -16776961;
                            i2 = i + 4;
                            break;
                        default:
                            if (i4 < 67) {
                                i5 = InputDeviceCompat.SOURCE_ANY;
                            }
                            i3 = readInt & i5;
                            i2 = i + 3;
                            break;
                    }
            }
            int readByte2 = readByte(i2);
            context.i = i3;
            context.j = readByte2 == 0 ? null : new TypePath(this.b, i2);
            return i2 + 1 + (readByte2 * 2);
        }
        i3 = readInt & SupportMenu.CATEGORY_MASK;
        i2 = i + 2;
        int readByte22 = readByte(i2);
        context.i = i3;
        context.j = readByte22 == 0 ? null : new TypePath(this.b, i2);
        return i2 + 1 + (readByte22 * 2);
    }

    private int a(Object[] objArr, int i, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i2 + 1;
        switch (this.b[i2] & UByte.MAX_VALUE) {
            case 0:
                objArr[i] = Opcodes.TOP;
                return i3;
            case 1:
                objArr[i] = Opcodes.INTEGER;
                return i3;
            case 2:
                objArr[i] = Opcodes.FLOAT;
                return i3;
            case 3:
                objArr[i] = Opcodes.DOUBLE;
                return i3;
            case 4:
                objArr[i] = Opcodes.LONG;
                return i3;
            case 5:
                objArr[i] = Opcodes.NULL;
                return i3;
            case 6:
                objArr[i] = Opcodes.UNINITIALIZED_THIS;
                return i3;
            case 7:
                objArr[i] = readClass(i3, cArr);
                break;
            default:
                objArr[i] = readLabel(readUnsignedShort(i3), labelArr);
                break;
        }
        return i3 + 2;
    }

    private String a(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.b;
        int i5 = 0;
        boolean z = false;
        char c2 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (z) {
                if (z) {
                    cArr[i5] = (char) ((b2 & 63) | (c2 << 6));
                    i5++;
                    z = false;
                } else if (z) {
                    i3 = (b2 & 63) | (c2 << 6);
                }
                i = i6;
            } else {
                int i7 = b2 & UByte.MAX_VALUE;
                if (i7 < 128) {
                    cArr[i5] = (char) i7;
                    i5++;
                } else if (i7 >= 224 || i7 <= 191) {
                    c2 = (char) (i7 & 15);
                    z = true;
                } else {
                    i3 = i7 & 31;
                }
                i = i6;
            }
            c2 = (char) i3;
            z = true;
            i = i6;
        }
        return new String(cArr, 0, i5);
    }

    private Attribute a(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        for (int i4 = 0; i4 < attributeArr.length; i4++) {
            if (attributeArr[i4].type.equals(str)) {
                return attributeArr[i4].read(this, i, i2, cArr, i3, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i2, null, -1, null);
    }

    private void a(ClassWriter classWriter, Item[] itemArr, char[] cArr) {
        int i;
        boolean z;
        int a2 = a();
        int readUnsignedShort = readUnsignedShort(a2);
        while (true) {
            if (readUnsignedShort <= 0) {
                z = false;
                break;
            } else if ("BootstrapMethods".equals(readUTF8(a2 + 2, cArr))) {
                z = true;
                break;
            } else {
                a2 += readInt(a2 + 4) + 6;
                readUnsignedShort--;
            }
        }
        if (z) {
            int readUnsignedShort2 = readUnsignedShort(a2 + 8);
            int i2 = a2 + 10;
            int i3 = i2;
            for (i = 0; i < readUnsignedShort2; i++) {
                int i4 = (i3 - a2) - 10;
                int hashCode = readConst(readUnsignedShort(i3), cArr).hashCode();
                for (int readUnsignedShort3 = readUnsignedShort(i3 + 2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                    hashCode ^= readConst(readUnsignedShort(i3 + 4), cArr).hashCode();
                    i3 += 2;
                }
                i3 += 4;
                Item item = new Item(i);
                item.a(i4, hashCode & Integer.MAX_VALUE);
                int length = item.j % itemArr.length;
                item.k = itemArr[length];
                itemArr[length] = item;
            }
            int readInt = readInt(a2 + 4);
            ByteVector byteVector = new ByteVector(readInt + 62);
            byteVector.putByteArray(this.b, i2, readInt - 2);
            classWriter.z = readUnsignedShort2;
            classWriter.A = byteVector;
        }
    }

    private void a(Context context) {
        int i;
        String str = context.g;
        Object[] objArr = context.s;
        int i2 = 0;
        if ((context.e & 8) == 0) {
            if ("<init>".equals(context.f)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.c);
            }
            i2 = 1;
        }
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == 'F') {
                i = i2 + 1;
                objArr[i2] = Opcodes.FLOAT;
            } else if (charAt != 'L') {
                if (!(charAt == 'S' || charAt == 'I')) {
                    if (charAt == 'J') {
                        i = i2 + 1;
                        objArr[i2] = Opcodes.LONG;
                    } else if (charAt != 'Z') {
                        if (charAt != '[') {
                            switch (charAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i = i2 + 1;
                                    objArr[i2] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.q = i2;
                                    return;
                            }
                        } else {
                            while (str.charAt(i4) == '[') {
                                i4++;
                            }
                            if (str.charAt(i4) == 'L') {
                                do {
                                    i4++;
                                } while (str.charAt(i4) != ';');
                            }
                            int i5 = i4 + 1;
                            objArr[i2] = str.substring(i3, i5);
                            i3 = i5;
                            i2++;
                        }
                    }
                }
                i = i2 + 1;
                objArr[i2] = Opcodes.INTEGER;
            } else {
                int i6 = i4;
                while (str.charAt(i6) != ';') {
                    i6++;
                }
                objArr[i2] = str.substring(i4, i6);
                i2++;
                i3 = i6 + 1;
            }
            i2 = i;
            i3 = i4;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04ab  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x04fe  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x053f  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x057c  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x05a0  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x05cb  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0641  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0693  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x06a6  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x06ca  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06dd  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x06f2  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0705  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0722  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0765  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0785  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0791  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x07a8  */
    private void a(MethodVisitor methodVisitor, Context context, int i) {
        boolean z;
        Label[] labelArr;
        Context context2;
        int i2;
        int[] iArr;
        Context context3;
        int i3;
        boolean z2;
        char[] cArr;
        int[] iArr2;
        String str;
        MethodVisitor methodVisitor2;
        int i4;
        boolean z3;
        int i5;
        int[] iArr3;
        int i6;
        int i7;
        int i8;
        int i9;
        Context context4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Label[] labelArr2;
        int i18;
        int i19;
        boolean z4;
        int i20;
        int i21;
        Label[] labelArr3;
        int readUnsignedShort;
        Label[] labelArr4;
        int i22;
        boolean z5;
        int[] iArr4;
        int[] iArr5;
        Label[] labelArr5;
        int i23;
        boolean z6;
        int[] iArr6;
        int[] iArr7;
        int i24;
        String str2;
        int i25;
        int i26;
        MethodVisitor methodVisitor3 = methodVisitor;
        Context context5 = context;
        byte[] bArr = this.b;
        char[] cArr2 = context5.c;
        int readUnsignedShort2 = readUnsignedShort(i);
        int readUnsignedShort3 = readUnsignedShort(i + 2);
        int readInt = readInt(i + 4);
        int i27 = i + 8;
        int i28 = i27 + readInt;
        Label[] labelArr6 = new Label[(readInt + 2)];
        context5.h = labelArr6;
        readLabel(readInt + 1, labelArr6);
        int i29 = i27;
        while (i29 < i28) {
            int i30 = i29 - i27;
            switch (ClassWriter.a[bArr[i29] & UByte.MAX_VALUE]) {
                case 0:
                case 4:
                    i29++;
                    break;
                case 1:
                case 3:
                case 11:
                    i29 += 2;
                    break;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    i29 += 3;
                    break;
                case 7:
                case 8:
                    i29 += 5;
                    break;
                case 9:
                    readLabel(i30 + readShort(i29 + 1), labelArr6);
                    i29 += 3;
                    break;
                case 10:
                    readLabel(i30 + readInt(i29 + 1), labelArr6);
                    i29 += 5;
                    break;
                case 14:
                    int i31 = (i29 + 4) - (i30 & 3);
                    readLabel(readInt(i31) + i30, labelArr6);
                    for (int readInt2 = (readInt(i31 + 8) - readInt(i31 + 4)) + 1; readInt2 > 0; readInt2--) {
                        readLabel(readInt(i31 + 12) + i30, labelArr6);
                        i31 += 4;
                    }
                    i29 = i31 + 12;
                    break;
                case 15:
                    int i32 = (i29 + 4) - (i30 & 3);
                    readLabel(readInt(i32) + i30, labelArr6);
                    for (int readInt3 = readInt(i32 + 4); readInt3 > 0; readInt3--) {
                        readLabel(readInt(i32 + 12) + i30, labelArr6);
                        i32 += 8;
                    }
                    i29 = i32 + 8;
                    break;
                case 16:
                default:
                    i29 += 4;
                    break;
                case 17:
                    if ((bArr[i29 + 1] & UByte.MAX_VALUE) == 132) {
                        i29 += 6;
                        break;
                    }
                    i29 += 4;
                    break;
            }
        }
        for (int readUnsignedShort4 = readUnsignedShort(i29); readUnsignedShort4 > 0; readUnsignedShort4--) {
            i29 += 8;
            methodVisitor3.visitTryCatchBlock(readLabel(readUnsignedShort(i29 + 2), labelArr6), readLabel(readUnsignedShort(i29 + 4), labelArr6), readLabel(readUnsignedShort(i29 + 6), labelArr6), readUTF8(this.a[readUnsignedShort(i29)], cArr2));
        }
        int i33 = i29 + 2;
        boolean z7 = (context5.b & 8) != 0;
        int i34 = i33;
        int readUnsignedShort5 = readUnsignedShort(i33);
        int[] iArr8 = null;
        int[] iArr9 = null;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        boolean z8 = true;
        Attribute attribute = null;
        int i39 = 0;
        int i40 = -1;
        int i41 = -1;
        while (readUnsignedShort5 > 0) {
            String readUTF8 = readUTF8(i34 + 2, cArr2);
            if (!"LocalVariableTable".equals(readUTF8)) {
                iArr5 = iArr8;
                iArr4 = iArr9;
                if ("LocalVariableTypeTable".equals(readUTF8)) {
                    i38 = i34 + 8;
                } else if (!"LineNumberTable".equals(readUTF8)) {
                    if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                        int[] a2 = a(methodVisitor3, context5, i34 + 8, true);
                        i40 = (a2.length == 0 || readByte(a2[0]) < 67) ? -1 : readUnsignedShort(a2[0] + 1);
                        z5 = z7;
                        labelArr4 = labelArr6;
                        i22 = i28;
                        iArr9 = a2;
                        iArr8 = iArr5;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                        iArr8 = a(methodVisitor3, context5, i34 + 8, false);
                        i41 = (iArr8.length == 0 || readByte(iArr8[0]) < 67) ? -1 : readUnsignedShort(iArr8[0] + 1);
                        z5 = z7;
                        labelArr4 = labelArr6;
                        i22 = i28;
                        iArr9 = iArr4;
                    } else if ("StackMapTable".equals(readUTF8)) {
                        if ((context5.b & 4) == 0) {
                            i35 = i34 + 10;
                            i36 = readInt(i34 + 4);
                            i39 = readUnsignedShort(i34 + 8);
                        }
                    } else if (!"StackMap".equals(readUTF8)) {
                        Attribute attribute2 = attribute;
                        int i42 = 0;
                        while (i42 < context5.a.length) {
                            if (context5.a[i42].type.equals(readUTF8)) {
                                iArr7 = iArr5;
                                i24 = i42;
                                iArr6 = iArr4;
                                str2 = readUTF8;
                                z6 = z7;
                                labelArr5 = labelArr6;
                                i23 = i28;
                                Attribute read = context5.a[i42].read(this, i34 + 8, readInt(i34 + 4), cArr2, i27 - 8, labelArr5);
                                if (read != null) {
                                    read.a = attribute2;
                                    attribute2 = read;
                                }
                            } else {
                                str2 = readUTF8;
                                z6 = z7;
                                labelArr5 = labelArr6;
                                i23 = i28;
                                iArr7 = iArr5;
                                iArr6 = iArr4;
                                i24 = i42;
                            }
                            i42 = i24 + 1;
                            labelArr6 = labelArr5;
                            readUTF8 = str2;
                            iArr5 = iArr7;
                            iArr4 = iArr6;
                            z7 = z6;
                            i28 = i23;
                        }
                        z5 = z7;
                        labelArr4 = labelArr6;
                        i22 = i28;
                        attribute = attribute2;
                        iArr8 = iArr5;
                        iArr9 = iArr4;
                    } else if ((context5.b & 4) == 0) {
                        i35 = i34 + 10;
                        i36 = readInt(i34 + 4);
                        i39 = readUnsignedShort(i34 + 8);
                        z5 = z7;
                        labelArr4 = labelArr6;
                        i22 = i28;
                        iArr8 = iArr5;
                        iArr9 = iArr4;
                        z8 = false;
                    }
                    i34 += readInt(i34 + 4) + 6;
                    readUnsignedShort5--;
                    methodVisitor3 = methodVisitor;
                    labelArr6 = labelArr4;
                    z7 = z5;
                    i28 = i22;
                } else if ((context5.b & 2) == 0) {
                    int i43 = i34;
                    for (int readUnsignedShort6 = readUnsignedShort(i34 + 8); readUnsignedShort6 > 0; readUnsignedShort6--) {
                        int readUnsignedShort7 = readUnsignedShort(i43 + 10);
                        if (labelArr6[readUnsignedShort7] == null) {
                            readLabel(readUnsignedShort7, labelArr6).a |= 1;
                        }
                        Label label = labelArr6[readUnsignedShort7];
                        while (label.b > 0) {
                            if (label.k == null) {
                                label.k = new Label();
                            }
                            label = label.k;
                        }
                        label.b = readUnsignedShort(i43 + 12);
                        i43 += 4;
                    }
                }
                z5 = z7;
                labelArr4 = labelArr6;
                i22 = i28;
                iArr8 = iArr5;
                iArr9 = iArr4;
                i34 += readInt(i34 + 4) + 6;
                readUnsignedShort5--;
                methodVisitor3 = methodVisitor;
                labelArr6 = labelArr4;
                z7 = z5;
                i28 = i22;
            } else if ((context5.b & 2) == 0) {
                int i44 = i34 + 8;
                int readUnsignedShort8 = readUnsignedShort(i44);
                int i45 = i34;
                while (readUnsignedShort8 > 0) {
                    int i46 = i45 + 10;
                    int readUnsignedShort9 = readUnsignedShort(i46);
                    if (labelArr6[readUnsignedShort9] == null) {
                        i26 = i46;
                        i25 = i44;
                        readLabel(readUnsignedShort9, labelArr6).a |= 1;
                    } else {
                        i26 = i46;
                        i25 = i44;
                    }
                    int readUnsignedShort10 = readUnsignedShort9 + readUnsignedShort(i45 + 12);
                    if (labelArr6[readUnsignedShort10] == null) {
                        readLabel(readUnsignedShort10, labelArr6).a |= 1;
                    }
                    readUnsignedShort8--;
                    i45 = i26;
                    iArr8 = iArr8;
                    iArr9 = iArr9;
                    i44 = i25;
                }
                z5 = z7;
                labelArr4 = labelArr6;
                i22 = i28;
                i37 = i44;
                i34 += readInt(i34 + 4) + 6;
                readUnsignedShort5--;
                methodVisitor3 = methodVisitor;
                labelArr6 = labelArr4;
                z7 = z5;
                i28 = i22;
            } else {
                iArr5 = iArr8;
                iArr4 = iArr9;
            }
            z5 = z7;
            labelArr4 = labelArr6;
            i22 = i28;
            iArr8 = iArr5;
            iArr9 = iArr4;
            i34 += readInt(i34 + 4) + 6;
            readUnsignedShort5--;
            methodVisitor3 = methodVisitor;
            labelArr6 = labelArr4;
            z7 = z5;
            i28 = i22;
        }
        int[] iArr10 = iArr8;
        int[] iArr11 = iArr9;
        Label[] labelArr7 = labelArr6;
        int i47 = i28;
        if (i35 != 0) {
            context5.o = -1;
            context5.p = 0;
            context5.q = 0;
            context5.r = 0;
            context5.t = 0;
            context5.s = new Object[readUnsignedShort3];
            context5.u = new Object[readUnsignedShort2];
            z = z7;
            if (z) {
                a(context5);
            }
            int i48 = i35;
            while (i48 < (i35 + i36) - 2) {
                if (bArr[i48] != 8 || (readUnsignedShort = readUnsignedShort(i48 + 1)) < 0 || readUnsignedShort >= readInt || (bArr[i27 + readUnsignedShort] & UByte.MAX_VALUE) != 187) {
                    labelArr3 = labelArr7;
                } else {
                    labelArr3 = labelArr7;
                    readLabel(readUnsignedShort, labelArr3);
                }
                i48++;
                labelArr7 = labelArr3;
            }
            labelArr = labelArr7;
            context2 = context5;
        } else {
            labelArr = labelArr7;
            z = z7;
            context2 = null;
        }
        int i49 = i27;
        int i50 = 0;
        int i51 = 0;
        while (true) {
            int i52 = i47;
            if (i49 < i52) {
                int i53 = i49 - i27;
                Label label2 = labelArr[i53];
                if (label2 != null) {
                    Label label3 = label2.k;
                    label2.k = null;
                    methodVisitor2 = methodVisitor;
                    methodVisitor2.visitLabel(label2);
                    if ((context5.b & 2) == 0 && label2.b > 0) {
                        methodVisitor2.visitLineNumber(label2.b, label2);
                        Label label4 = label3;
                        while (label4 != null) {
                            methodVisitor2.visitLineNumber(label4.b, label2);
                            label4 = label4.k;
                            i52 = i52;
                        }
                    }
                } else {
                    methodVisitor2 = methodVisitor;
                }
                int i54 = i52;
                Context context6 = context2;
                int i55 = i35;
                while (context6 != null) {
                    if (context6.o != i53) {
                        i14 = -1;
                        if (context6.o != -1) {
                            i4 = bArr[i49] & UByte.MAX_VALUE;
                            switch (ClassWriter.a[i4]) {
                                case 0:
                                    z3 = z;
                                    i5 = i55;
                                    methodVisitor2.visitInsn(i4);
                                    i49++;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 1:
                                    z3 = z;
                                    i5 = i55;
                                    methodVisitor2.visitIntInsn(i4, bArr[i49 + 1]);
                                    i49 += 2;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 2:
                                    z3 = z;
                                    i5 = i55;
                                    methodVisitor2.visitIntInsn(i4, readShort(i49 + 1));
                                    i49 += 3;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 3:
                                    z3 = z;
                                    i5 = i55;
                                    methodVisitor2.visitVarInsn(i4, bArr[i49 + 1] & UByte.MAX_VALUE);
                                    i49 += 2;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 4:
                                    z3 = z;
                                    i5 = i55;
                                    if (i4 > 54) {
                                        int i56 = i4 - 59;
                                        methodVisitor2.visitVarInsn((i56 >> 2) + 54, i56 & 3);
                                    } else {
                                        int i57 = i4 - 26;
                                        methodVisitor2.visitVarInsn((i57 >> 2) + 21, i57 & 3);
                                    }
                                    i49++;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 5:
                                    z3 = z;
                                    i5 = i55;
                                    methodVisitor2.visitTypeInsn(i4, readClass(i49 + 1, cArr2));
                                    i49 += 3;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 6:
                                case 7:
                                    z3 = z;
                                    int i58 = this.a[readUnsignedShort(i49 + 1)];
                                    boolean z9 = bArr[i58 + -1] == 11;
                                    String readClass = readClass(i58, cArr2);
                                    int i59 = this.a[readUnsignedShort(i58 + 2)];
                                    String readUTF82 = readUTF8(i59, cArr2);
                                    String readUTF83 = readUTF8(i59 + 2, cArr2);
                                    if (i4 < 182) {
                                        methodVisitor2.visitFieldInsn(i4, readClass, readUTF82, readUTF83);
                                        i5 = i55;
                                        i12 = i4;
                                    } else {
                                        i5 = i55;
                                        i12 = i4;
                                        methodVisitor.visitMethodInsn(i4, readClass, readUTF82, readUTF83, z9);
                                    }
                                    if (i12 == 185) {
                                        i49 += 5;
                                        i7 = i50;
                                        i6 = i40;
                                        iArr3 = iArr11;
                                        break;
                                    }
                                    i49 += 3;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                case 8:
                                    z3 = z;
                                    int i60 = this.a[readUnsignedShort(i49 + 1)];
                                    int i61 = context5.d[readUnsignedShort(i60)];
                                    Handle handle = (Handle) readConst(readUnsignedShort(i61), cArr2);
                                    int readUnsignedShort11 = readUnsignedShort(i61 + 2);
                                    Object[] objArr = new Object[readUnsignedShort11];
                                    int i62 = i61 + 4;
                                    for (int i63 = 0; i63 < readUnsignedShort11; i63++) {
                                        objArr[i63] = readConst(readUnsignedShort(i62), cArr2);
                                        i62 += 2;
                                    }
                                    int i64 = this.a[readUnsignedShort(i60 + 2)];
                                    methodVisitor2.visitInvokeDynamicInsn(readUTF8(i64, cArr2), readUTF8(i64 + 2, cArr2), handle, objArr);
                                    i49 += 5;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 9:
                                    z3 = z;
                                    methodVisitor2.visitJumpInsn(i4, labelArr[i53 + readShort(i49 + 1)]);
                                    i49 += 3;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 10:
                                    z3 = z;
                                    methodVisitor2.visitJumpInsn(i4 - 33, labelArr[i53 + readInt(i49 + 1)]);
                                    i49 += 5;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 11:
                                    z3 = z;
                                    methodVisitor2.visitLdcInsn(readConst(bArr[i49 + 1] & UByte.MAX_VALUE, cArr2));
                                    i49 += 2;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 12:
                                    z3 = z;
                                    methodVisitor2.visitLdcInsn(readConst(readUnsignedShort(i49 + 1), cArr2));
                                    i49 += 3;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 13:
                                    z3 = z;
                                    methodVisitor2.visitIincInsn(bArr[i49 + 1] & UByte.MAX_VALUE, bArr[i49 + 2]);
                                    i49 += 3;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 14:
                                    int i65 = (i49 + 4) - (i53 & 3);
                                    int readInt4 = i53 + readInt(i65);
                                    int readInt5 = readInt(i65 + 4);
                                    int readInt6 = readInt(i65 + 8);
                                    int i66 = (readInt6 - readInt5) + 1;
                                    Label[] labelArr8 = new Label[i66];
                                    z3 = z;
                                    int i67 = i65 + 12;
                                    for (int i68 = 0; i68 < i66; i68++) {
                                        labelArr8[i68] = labelArr[i53 + readInt(i67)];
                                        i67 += 4;
                                    }
                                    methodVisitor2.visitTableSwitchInsn(readInt5, readInt6, labelArr[readInt4], labelArr8);
                                    i49 = i67;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 15:
                                    int i69 = (i49 + 4) - (i53 & 3);
                                    int readInt7 = readInt(i69) + i53;
                                    int readInt8 = readInt(i69 + 4);
                                    int[] iArr12 = new int[readInt8];
                                    Label[] labelArr9 = new Label[readInt8];
                                    int i70 = i69 + 8;
                                    int i71 = 0;
                                    while (i71 < readInt8) {
                                        iArr12[i71] = readInt(i70);
                                        labelArr9[i71] = labelArr[readInt(i70 + 4) + i53];
                                        i70 += 8;
                                        i71++;
                                        readInt8 = readInt8;
                                    }
                                    methodVisitor2.visitLookupSwitchInsn(labelArr[readInt7], iArr12, labelArr9);
                                    i49 = i70;
                                    z3 = z;
                                    i5 = i55;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 16:
                                default:
                                    z3 = z;
                                    i5 = i55;
                                    methodVisitor2.visitMultiANewArrayInsn(readClass(i49 + 1, cArr2), bArr[i49 + 3] & UByte.MAX_VALUE);
                                    i49 += 4;
                                    i7 = i50;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    break;
                                case 17:
                                    int i72 = bArr[i49 + 1] & UByte.MAX_VALUE;
                                    if (i72 == 132) {
                                        methodVisitor2.visitIincInsn(readUnsignedShort(i49 + 2), readShort(i49 + 4));
                                        i13 = i49 + 6;
                                    } else {
                                        methodVisitor2.visitVarInsn(i72, readUnsignedShort(i49 + 2));
                                        i13 = i49 + 4;
                                    }
                                    z3 = z;
                                    i5 = i55;
                                    i6 = i40;
                                    iArr3 = iArr11;
                                    i49 = i13;
                                    i7 = i50;
                                    break;
                            }
                            while (iArr3 != null && i7 < iArr3.length && i6 <= i53) {
                                if (i6 == i53) {
                                    int a3 = a(context5, iArr3[i7]);
                                    a(a3 + 2, cArr2, true, methodVisitor2.visitInsnAnnotation(context5.i, context5.j, readUTF8(a3, cArr2), true));
                                }
                                i7++;
                                i6 = (i7 < iArr3.length || readByte(iArr3[i7]) < 67) ? -1 : readUnsignedShort(iArr3[i7] + 1);
                            }
                            i8 = i51;
                            i9 = i41;
                            while (iArr10 != null && i8 < iArr10.length && i9 <= i53) {
                                if (i9 != i53) {
                                    int a4 = a(context5, iArr10[i8]);
                                    i11 = i7;
                                    i10 = i6;
                                    context4 = context6;
                                    a(a4 + 2, cArr2, true, methodVisitor2.visitInsnAnnotation(context5.i, context5.j, readUTF8(a4, cArr2), false));
                                } else {
                                    i11 = i7;
                                    i10 = i6;
                                    context4 = context6;
                                }
                                i8++;
                                if (i8 >= iArr10.length) {
                                    if (readByte(iArr10[i8]) >= 67) {
                                        i9 = readUnsignedShort(iArr10[i8] + 1);
                                        i7 = i11;
                                        i6 = i10;
                                        context6 = context4;
                                    }
                                }
                                i9 = -1;
                                i7 = i11;
                                i6 = i10;
                                context6 = context4;
                            }
                            i50 = i7;
                            i41 = i9;
                            iArr10 = iArr10;
                            iArr11 = iArr3;
                            z8 = z8;
                            i40 = i6;
                            i47 = i54;
                            context2 = context6;
                            labelArr = labelArr;
                            readUnsignedShort2 = readUnsignedShort2;
                            readUnsignedShort3 = readUnsignedShort3;
                            readInt = readInt;
                            i35 = i5;
                            z = z3;
                            i51 = i8;
                        }
                    } else {
                        i14 = -1;
                    }
                    if (context6.o == i14) {
                        i18 = i49;
                        labelArr2 = labelArr;
                        i15 = readInt;
                        i16 = readUnsignedShort3;
                        i17 = readUnsignedShort2;
                        z4 = z8;
                        i19 = i54;
                        i20 = i53;
                        i21 = i55;
                    } else if (!z8 || z) {
                        i18 = i49;
                        labelArr2 = labelArr;
                        i15 = readInt;
                        i16 = readUnsignedShort3;
                        i17 = readUnsignedShort2;
                        i19 = i54;
                        i20 = i53;
                        z4 = z8;
                        i21 = i55;
                        methodVisitor.visitFrame(-1, context6.q, context6.s, context6.t, context6.u);
                    } else {
                        i16 = readUnsignedShort3;
                        i20 = i53;
                        i17 = readUnsignedShort2;
                        z4 = z8;
                        i19 = i54;
                        i15 = readInt;
                        i21 = i55;
                        i18 = i49;
                        labelArr2 = labelArr;
                        methodVisitor.visitFrame(context6.p, context6.r, context6.s, context6.t, context6.u);
                    }
                    if (i39 > 0) {
                        i55 = a(i21, z4, z, context6);
                        i39--;
                        i53 = i20;
                        z8 = z4;
                        i54 = i19;
                        i49 = i18;
                        labelArr = labelArr2;
                        readUnsignedShort2 = i17;
                        readUnsignedShort3 = i16;
                        readInt = i15;
                    } else {
                        i55 = i21;
                        i53 = i20;
                        z8 = z4;
                        i54 = i19;
                        i49 = i18;
                        labelArr = labelArr2;
                        readUnsignedShort2 = i17;
                        readUnsignedShort3 = i16;
                        readInt = i15;
                        context6 = null;
                    }
                }
                i4 = bArr[i49] & UByte.MAX_VALUE;
                switch (ClassWriter.a[i4]) {
                }
                while (iArr3 != null) {
                    if (i6 == i53) {
                    }
                    i7++;
                    if (i7 < iArr3.length) {
                    }
                }
                i8 = i51;
                i9 = i41;
                while (iArr10 != null) {
                    if (i9 != i53) {
                    }
                    i8++;
                    if (i8 >= iArr10.length) {
                    }
                    i9 = -1;
                    i7 = i11;
                    i6 = i10;
                    context6 = context4;
                }
                i50 = i7;
                i41 = i9;
                iArr10 = iArr10;
                iArr11 = iArr3;
                z8 = z8;
                i40 = i6;
                i47 = i54;
                context2 = context6;
                labelArr = labelArr;
                readUnsignedShort2 = readUnsignedShort2;
                readUnsignedShort3 = readUnsignedShort3;
                readInt = readInt;
                i35 = i5;
                z = z3;
                i51 = i8;
            } else {
                int i73 = readUnsignedShort3;
                int[] iArr13 = iArr10;
                int[] iArr14 = iArr11;
                boolean z10 = false;
                if (labelArr[readInt] != null) {
                    methodVisitor.visitLabel(labelArr[readInt]);
                }
                if ((context5.b & 2) == 0 && i37 != 0) {
                    if (i38 != 0) {
                        int readUnsignedShort12 = readUnsignedShort(i38) * 3;
                        int[] iArr15 = new int[readUnsignedShort12];
                        int i74 = i38 + 2;
                        while (readUnsignedShort12 > 0) {
                            int i75 = readUnsignedShort12 - 1;
                            iArr15[i75] = i74 + 6;
                            int i76 = i75 - 1;
                            iArr15[i76] = readUnsignedShort(i74 + 8);
                            readUnsignedShort12 = i76 - 1;
                            iArr15[readUnsignedShort12] = readUnsignedShort(i74);
                            i74 += 10;
                        }
                        iArr2 = iArr15;
                    } else {
                        iArr2 = null;
                    }
                    int readUnsignedShort13 = readUnsignedShort(i37);
                    int i77 = i37 + 2;
                    while (readUnsignedShort13 > 0) {
                        int readUnsignedShort14 = readUnsignedShort(i77);
                        int readUnsignedShort15 = readUnsignedShort(i77 + 2);
                        int readUnsignedShort16 = readUnsignedShort(i77 + 8);
                        if (iArr2 != null) {
                            int i78 = 0;
                            while (true) {
                                if (i78 < iArr2.length) {
                                    if (iArr2[i78] == readUnsignedShort14 && iArr2[i78 + 1] == readUnsignedShort16) {
                                        str = readUTF8(iArr2[i78 + 2], cArr2);
                                    } else {
                                        i78 += 3;
                                    }
                                }
                            }
                            methodVisitor.visitLocalVariable(readUTF8(i77 + 4, cArr2), readUTF8(i77 + 6, cArr2), str, labelArr[readUnsignedShort14], labelArr[readUnsignedShort14 + readUnsignedShort15], readUnsignedShort16);
                            i77 += 10;
                            readUnsignedShort13--;
                            iArr13 = iArr13;
                        }
                        str = null;
                        methodVisitor.visitLocalVariable(readUTF8(i77 + 4, cArr2), readUTF8(i77 + 6, cArr2), str, labelArr[readUnsignedShort14], labelArr[readUnsignedShort14 + readUnsignedShort15], readUnsignedShort16);
                        i77 += 10;
                        readUnsignedShort13--;
                        iArr13 = iArr13;
                    }
                }
                int i79 = 1;
                int i80 = 32;
                if (iArr14 != null) {
                    int i81 = 0;
                    while (i81 < iArr14.length) {
                        if ((readByte(iArr14[i81]) >> i79) == i80) {
                            int a5 = a(context5, iArr14[i81]);
                            iArr = iArr14;
                            i3 = i73;
                            cArr = cArr2;
                            context3 = context5;
                            z2 = i79;
                            a(a5 + 2, cArr, z2, methodVisitor.visitLocalVariableAnnotation(context5.i, context5.j, context5.l, context5.m, context5.n, readUTF8(a5, cArr2), true));
                        } else {
                            iArr = iArr14;
                            cArr = cArr2;
                            context3 = context5;
                            z2 = i79;
                            i3 = i73;
                        }
                        i81++;
                        cArr2 = cArr;
                        i79 = z2;
                        i73 = i3;
                        context5 = context3;
                        iArr14 = iArr;
                        i80 = 32;
                        z10 = false;
                    }
                }
                int i82 = i79;
                if (iArr13 != null) {
                    int i83 = 0;
                    while (i83 < iArr13.length) {
                        if ((readByte(iArr13[i83]) >> i82) == 32) {
                            int a6 = a(context5, iArr13[i83]);
                            i2 = 1;
                            a(a6 + 2, cArr2, true, methodVisitor.visitLocalVariableAnnotation(context5.i, context5.j, context5.l, context5.m, context5.n, readUTF8(a6, cArr2), false));
                        } else {
                            i2 = i82;
                        }
                        i83++;
                        i82 = i2;
                    }
                }
                Attribute attribute3 = attribute;
                while (attribute3 != null) {
                    Attribute attribute4 = attribute3.a;
                    attribute3.a = null;
                    methodVisitor.visitAttribute(attribute3);
                    attribute3 = attribute4;
                }
                methodVisitor.visitMaxs(readUnsignedShort2, i73);
                return;
            }
        }
    }

    private static byte[] a(InputStream inputStream, boolean z) throws IOException {
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[inputStream.available()];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr, i, bArr.length - i);
                    if (read == -1) {
                        if (i < bArr.length) {
                            byte[] bArr2 = new byte[i];
                            System.arraycopy(bArr, 0, bArr2, 0, i);
                            bArr = bArr2;
                        }
                        if (z) {
                            inputStream.close();
                        }
                        return bArr;
                    }
                    i += read;
                    if (i == bArr.length) {
                        int read2 = inputStream.read();
                        if (read2 < 0) {
                            return bArr;
                        }
                        byte[] bArr3 = new byte[(bArr.length + 1000)];
                        System.arraycopy(bArr, 0, bArr3, 0, i);
                        bArr3[i] = (byte) read2;
                        i++;
                        bArr = bArr3;
                    }
                }
            } finally {
                if (z) {
                    inputStream.close();
                }
            }
        } else {
            throw new IOException("Class not found");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    private int[] a(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2;
        char[] cArr = context.c;
        int readUnsignedShort = readUnsignedShort(i);
        int[] iArr = new int[readUnsignedShort];
        int i3 = i + 2;
        for (int i4 = 0; i4 < readUnsignedShort; i4++) {
            iArr[i4] = i3;
            int readInt = readInt(i3);
            int i5 = readInt >>> 24;
            if (!(i5 == 0 || i5 == 1)) {
                if (i5 == 64 || i5 == 65) {
                    for (int readUnsignedShort2 = readUnsignedShort(i3 + 1); readUnsignedShort2 > 0; readUnsignedShort2--) {
                        int readUnsignedShort3 = readUnsignedShort(i3 + 3);
                        int readUnsignedShort4 = readUnsignedShort(i3 + 5);
                        readLabel(readUnsignedShort3, context.h);
                        readLabel(readUnsignedShort3 + readUnsignedShort4, context.h);
                        i3 += 6;
                    }
                } else {
                    switch (i5) {
                        case 19:
                        case 20:
                        case 21:
                            i2 = i3 + 1;
                            break;
                        case 22:
                            break;
                        default:
                            switch (i5) {
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                    i2 = i3 + 4;
                                    break;
                            }
                    }
                    int readByte = readByte(i2);
                    TypePath typePath = null;
                    if (i5 == 66) {
                        if (readByte != 0) {
                            typePath = new TypePath(this.b, i2);
                        }
                        int i6 = i2 + (readByte * 2) + 1;
                        i3 = a(i6 + 2, cArr, true, methodVisitor.visitTryCatchAnnotation(readInt, typePath, readUTF8(i6, cArr), z));
                    } else {
                        i3 = a(i2 + 3 + (readByte * 2), cArr, true, (AnnotationVisitor) null);
                    }
                }
                i2 = i3 + 3;
                int readByte2 = readByte(i2);
                TypePath typePath2 = null;
                if (i5 == 66) {
                }
            }
            i2 = i3 + 2;
            int readByte22 = readByte(i2);
            TypePath typePath22 = null;
            if (i5 == 66) {
            }
        }
        return iArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b1, code lost:
        if (r1.j == 0) goto L_0x01d0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01d5  */
    private int b(ClassVisitor classVisitor, Context context, int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        String[] strArr;
        int i7;
        int i8;
        int i9;
        int i10;
        char[] cArr = context.c;
        context.e = readUnsignedShort(i);
        context.f = readUTF8(i + 2, cArr);
        context.g = readUTF8(i + 4, cArr);
        int i11 = i + 6;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        String[] strArr2 = null;
        String str2 = null;
        Attribute attribute = null;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        for (int readUnsignedShort = readUnsignedShort(i11); readUnsignedShort > 0; readUnsignedShort--) {
            String readUTF8 = readUTF8(i12 + 2, cArr);
            if (!"Code".equals(readUTF8)) {
                if ("Exceptions".equals(readUTF8)) {
                    int readUnsignedShort2 = readUnsignedShort(i12 + 8);
                    strArr2 = new String[readUnsignedShort2];
                    i8 = i14;
                    int i23 = i12 + 10;
                    for (int i24 = 0; i24 < readUnsignedShort2; i24++) {
                        strArr2[i24] = readClass(i23, cArr);
                        i23 += 2;
                    }
                    i20 = i23;
                } else {
                    i8 = i14;
                    if ("Signature".equals(readUTF8)) {
                        str2 = readUTF8(i12 + 8, cArr);
                    } else {
                        if ("Deprecated".equals(readUTF8)) {
                            i9 = context.e;
                            i10 = 131072;
                        } else if ("RuntimeVisibleAnnotations".equals(readUTF8)) {
                            i18 = i12 + 8;
                        } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                            i15 = i12 + 8;
                        } else if ("AnnotationDefault".equals(readUTF8)) {
                            i16 = i12 + 8;
                        } else if ("Synthetic".equals(readUTF8)) {
                            i9 = context.e;
                            i10 = 266240;
                        } else if ("RuntimeInvisibleAnnotations".equals(readUTF8)) {
                            i17 = i12 + 8;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                            i14 = i12 + 8;
                        } else if ("RuntimeVisibleParameterAnnotations".equals(readUTF8)) {
                            i21 = i12 + 8;
                        } else if ("RuntimeInvisibleParameterAnnotations".equals(readUTF8)) {
                            i13 = i12 + 8;
                            i14 = i8;
                            i12 += readInt(i12 + 4) + 6;
                        } else if ("MethodParameters".equals(readUTF8)) {
                            i19 = i12 + 8;
                        } else {
                            i6 = i13;
                            i5 = i8;
                            i4 = i15;
                            i7 = i16;
                            i3 = i17;
                            i2 = i18;
                            strArr = strArr2;
                            str = str2;
                            Attribute a2 = a(context.a, readUTF8, i12 + 8, readInt(i12 + 4), cArr, -1, null);
                            if (a2 != null) {
                                a2.a = attribute;
                                attribute = a2;
                            }
                            i16 = i7;
                            strArr2 = strArr;
                            str2 = str;
                            i13 = i6;
                            i14 = i5;
                            i15 = i4;
                            i17 = i3;
                            i18 = i2;
                            i12 += readInt(i12 + 4) + 6;
                        }
                        context.e = i9 | i10;
                        i4 = i15;
                        i7 = i16;
                        i3 = i17;
                        i2 = i18;
                        str = str2;
                        i5 = i8;
                        i6 = i13;
                        strArr = strArr2;
                        i16 = i7;
                        strArr2 = strArr;
                        str2 = str;
                        i13 = i6;
                        i14 = i5;
                        i15 = i4;
                        i17 = i3;
                        i18 = i2;
                        i12 += readInt(i12 + 4) + 6;
                    }
                }
                i14 = i8;
            } else if ((context.b & 1) == 0) {
                i22 = i12 + 8;
            } else {
                i5 = i14;
                i4 = i15;
                i7 = i16;
                i3 = i17;
                i2 = i18;
                str = str2;
                i6 = i13;
                strArr = strArr2;
                i16 = i7;
                strArr2 = strArr;
                str2 = str;
                i13 = i6;
                i14 = i5;
                i15 = i4;
                i17 = i3;
                i18 = i2;
                i12 += readInt(i12 + 4) + 6;
            }
            i13 = i13;
            i12 += readInt(i12 + 4) + 6;
        }
        int i25 = i12 + 2;
        MethodVisitor visitMethod = classVisitor.visitMethod(context.e, context.f, context.g, str2, strArr2);
        if (visitMethod == null) {
            return i25;
        }
        if (visitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) visitMethod;
            if (methodWriter.b.M == this && str2 == methodWriter.g) {
                if (strArr2 != null) {
                    if (strArr2.length == methodWriter.j) {
                        int length = strArr2.length - 1;
                        while (true) {
                            if (length < 0) {
                                break;
                            }
                            int i26 = i20 - 2;
                            if (methodWriter.k[length] != readUnsignedShort(i26)) {
                                break;
                            }
                            length--;
                            i20 = i26;
                        }
                    }
                    z = false;
                    if (z) {
                        methodWriter.h = i11;
                        methodWriter.i = i25 - i11;
                        return i25;
                    }
                }
                z = true;
                if (z) {
                }
            }
        }
        if (i19 != 0) {
            int i27 = this.b[i19] & UByte.MAX_VALUE;
            int i28 = i19 + 1;
            while (i27 > 0) {
                visitMethod.visitParameter(readUTF8(i28, cArr), readUnsignedShort(i28 + 2));
                i27--;
                i28 += 4;
            }
        }
        if (i16 != 0) {
            AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
            a(i16, cArr, (String) null, visitAnnotationDefault);
            if (visitAnnotationDefault != null) {
                visitAnnotationDefault.visitEnd();
            }
        }
        if (i18 != 0) {
            int i29 = i18 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(i18); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i29 = a(i29 + 2, cArr, true, visitMethod.visitAnnotation(readUTF8(i29, cArr), true));
            }
        }
        if (i17 != 0) {
            int readUnsignedShort4 = readUnsignedShort(i17);
            int i30 = i17 + 2;
            while (readUnsignedShort4 > 0) {
                readUnsignedShort4--;
                i30 = a(i30 + 2, cArr, true, visitMethod.visitAnnotation(readUTF8(i30, cArr), false));
            }
        }
        if (i15 != 0) {
            int i31 = i15 + 2;
            for (int readUnsignedShort5 = readUnsignedShort(i15); readUnsignedShort5 > 0; readUnsignedShort5--) {
                int a3 = a(context, i31);
                i31 = a(a3 + 2, cArr, true, visitMethod.visitTypeAnnotation(context.i, context.j, readUTF8(a3, cArr), true));
            }
        }
        if (i14 != 0) {
            int i32 = i14 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i14); readUnsignedShort6 > 0; readUnsignedShort6--) {
                int a4 = a(context, i32);
                i32 = a(a4 + 2, cArr, true, visitMethod.visitTypeAnnotation(context.i, context.j, readUTF8(a4, cArr), false));
            }
        }
        if (i21 != 0) {
            b(visitMethod, context, i21, true);
        }
        if (i13 != 0) {
            b(visitMethod, context, i13, false);
        }
        while (attribute != null) {
            Attribute attribute2 = attribute.a;
            attribute.a = null;
            visitMethod.visitAttribute(attribute);
            attribute = attribute2;
        }
        if (i22 != 0) {
            visitMethod.visitCode();
            a(visitMethod, context, i22);
        }
        visitMethod.visitEnd();
        return i25;
    }

    private void b(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2 = i + 1;
        int i3 = this.b[i] & UByte.MAX_VALUE;
        int length = Type.getArgumentTypes(context.g).length - i3;
        int i4 = 0;
        while (i4 < length) {
            AnnotationVisitor visitParameterAnnotation = methodVisitor.visitParameterAnnotation(i4, "Ljava/lang/Synthetic;", false);
            if (visitParameterAnnotation != null) {
                visitParameterAnnotation.visitEnd();
            }
            i4++;
        }
        char[] cArr = context.c;
        while (i4 < i3 + length) {
            i2 += 2;
            for (int readUnsignedShort = readUnsignedShort(i2); readUnsignedShort > 0; readUnsignedShort--) {
                i2 = a(i2 + 2, cArr, true, methodVisitor.visitParameterAnnotation(i4, readUTF8(i2, cArr), z));
            }
            i4++;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ClassWriter classWriter) {
        char[] cArr = new char[this.d];
        int length = this.a.length;
        Item[] itemArr = new Item[length];
        int i = 1;
        while (i < length) {
            int i2 = this.a[i];
            byte b2 = this.b[i2 - 1];
            Item item = new Item(i);
            if (b2 == 1) {
                String[] strArr = this.c;
                String str = strArr[i];
                if (str == null) {
                    int i3 = this.a[i];
                    str = a(i3 + 2, readUnsignedShort(i3), cArr);
                    strArr[i] = str;
                }
                item.a(b2, str, null, null);
            } else if (b2 == 15) {
                int i4 = this.a[readUnsignedShort(i2 + 1)];
                int i5 = this.a[readUnsignedShort(i4 + 2)];
                item.a(readByte(i2) + 20, readClass(i4, cArr), readUTF8(i5, cArr), readUTF8(i5 + 2, cArr));
            } else if (b2 == 18) {
                if (classWriter.A == null) {
                    a(classWriter, itemArr, cArr);
                }
                int i6 = this.a[readUnsignedShort(i2 + 2)];
                item.a(readUTF8(i6, cArr), readUTF8(i6 + 2, cArr), readUnsignedShort(i2));
            } else if (b2 == 3) {
                item.a(readInt(i2));
            } else if (b2 != 4) {
                if (b2 == 5) {
                    item.a(readLong(i2));
                } else if (b2 != 6) {
                    switch (b2) {
                        case 9:
                        case 10:
                        case 11:
                            int i7 = this.a[readUnsignedShort(i2 + 2)];
                            item.a(b2, readClass(i2, cArr), readUTF8(i7, cArr), readUTF8(i7 + 2, cArr));
                            continue;
                        case 12:
                            item.a(b2, readUTF8(i2, cArr), readUTF8(i2 + 2, cArr), null);
                            continue;
                        default:
                            item.a(b2, readUTF8(i2, cArr), null, null);
                            continue;
                    }
                } else {
                    item.a(Double.longBitsToDouble(readLong(i2)));
                }
                i++;
            } else {
                item.a(Float.intBitsToFloat(readInt(i2)));
            }
            int i8 = item.j % length;
            item.k = itemArr[i8];
            itemArr[i8] = item;
            i++;
        }
        int i9 = this.a[1] - 1;
        classWriter.d.putByteArray(this.b, i9, this.header - i9);
        classWriter.e = itemArr;
        classWriter.f = (int) (((double) length) * 0.75d);
        classWriter.c = length;
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        String[] strArr;
        String str;
        String str2;
        int i2;
        String str3;
        Attribute attribute;
        int i3;
        int i4 = this.header;
        char[] cArr = new char[this.d];
        Context context = new Context();
        context.a = attributeArr;
        context.b = i;
        context.c = cArr;
        int readUnsignedShort = readUnsignedShort(i4);
        String readClass = readClass(i4 + 2, cArr);
        String readClass2 = readClass(i4 + 4, cArr);
        int readUnsignedShort2 = readUnsignedShort(i4 + 6);
        String[] strArr2 = new String[readUnsignedShort2];
        int i5 = i4 + 8;
        for (int i6 = 0; i6 < readUnsignedShort2; i6++) {
            strArr2[i6] = readClass(i5, cArr);
            i5 += 2;
        }
        int a2 = a();
        int i7 = a2;
        int i8 = readUnsignedShort;
        int readUnsignedShort3 = readUnsignedShort(a2);
        int i9 = 0;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        Attribute attribute2 = null;
        while (readUnsignedShort3 > 0) {
            String readUTF8 = readUTF8(i7 + 2, cArr);
            if ("SourceFile".equals(readUTF8)) {
                str6 = readUTF8(i7 + 8, cArr);
            } else if ("InnerClasses".equals(readUTF8)) {
                i13 = i7 + 8;
            } else if ("EnclosingMethod".equals(readUTF8)) {
                String readClass3 = readClass(i7 + 8, cArr);
                int readUnsignedShort4 = readUnsignedShort(i7 + 10);
                if (readUnsignedShort4 != 0) {
                    str9 = readUTF8(this.a[readUnsignedShort4], cArr);
                    str4 = readUTF8(this.a[readUnsignedShort4] + 2, cArr);
                }
                str8 = readClass3;
            } else if ("Signature".equals(readUTF8)) {
                str7 = readUTF8(i7 + 8, cArr);
            } else if ("RuntimeVisibleAnnotations".equals(readUTF8)) {
                i9 = i7 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(readUTF8)) {
                i11 = i7 + 8;
            } else {
                if ("Deprecated".equals(readUTF8)) {
                    i3 = 131072;
                } else if ("Synthetic".equals(readUTF8)) {
                    i3 = 266240;
                } else if ("SourceDebugExtension".equals(readUTF8)) {
                    int readInt = readInt(i7 + 4);
                    str5 = a(i7 + 8, readInt, new char[readInt]);
                } else if ("RuntimeInvisibleAnnotations".equals(readUTF8)) {
                    i10 = i7 + 8;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(readUTF8)) {
                    i12 = i7 + 8;
                } else {
                    if ("BootstrapMethods".equals(readUTF8)) {
                        int readUnsignedShort5 = readUnsignedShort(i7 + 8);
                        int[] iArr = new int[readUnsignedShort5];
                        int i14 = i7 + 10;
                        int i15 = 0;
                        while (i15 < readUnsignedShort5) {
                            iArr[i15] = i14;
                            i14 += (readUnsignedShort(i14 + 2) + 2) << 1;
                            i15++;
                            i9 = i9;
                        }
                        context.d = iArr;
                        str2 = str4;
                        str = str5;
                        str3 = str6;
                        strArr = strArr2;
                        attribute = attribute2;
                        i2 = i9;
                    } else {
                        i2 = i9;
                        str2 = str4;
                        str = str5;
                        strArr = strArr2;
                        str3 = str6;
                        Attribute a3 = a(attributeArr, readUTF8, i7 + 8, readInt(i7 + 4), cArr, -1, null);
                        attribute = attribute2;
                        if (a3 != null) {
                            a3.a = attribute;
                            attribute2 = a3;
                            str6 = str3;
                            i9 = i2;
                            str4 = str2;
                            str5 = str;
                            i7 += readInt(i7 + 4) + 6;
                            readUnsignedShort3--;
                            strArr2 = strArr;
                        }
                    }
                    attribute2 = attribute;
                    str6 = str3;
                    i9 = i2;
                    str4 = str2;
                    str5 = str;
                    i7 += readInt(i7 + 4) + 6;
                    readUnsignedShort3--;
                    strArr2 = strArr;
                }
                i8 |= i3;
            }
            strArr = strArr2;
            i7 += readInt(i7 + 4) + 6;
            readUnsignedShort3--;
            strArr2 = strArr;
        }
        Attribute attribute3 = attribute2;
        classVisitor.visit(readInt(this.a[1] - 7), i8, readClass, str7, readClass2, strArr2);
        if ((i & 2) == 0 && !(str6 == null && str5 == null)) {
            classVisitor.visitSource(str6, str5);
        }
        if (str8 != null) {
            classVisitor.visitOuterClass(str8, str9, str4);
        }
        if (i9 != 0) {
            int i16 = i9 + 2;
            for (int readUnsignedShort6 = readUnsignedShort(i9); readUnsignedShort6 > 0; readUnsignedShort6--) {
                i16 = a(i16 + 2, cArr, true, classVisitor.visitAnnotation(readUTF8(i16, cArr), true));
            }
        }
        if (i10 != 0) {
            int i17 = i10 + 2;
            for (int readUnsignedShort7 = readUnsignedShort(i10); readUnsignedShort7 > 0; readUnsignedShort7--) {
                i17 = a(i17 + 2, cArr, true, classVisitor.visitAnnotation(readUTF8(i17, cArr), false));
            }
        }
        if (i11 != 0) {
            int i18 = i11 + 2;
            for (int readUnsignedShort8 = readUnsignedShort(i11); readUnsignedShort8 > 0; readUnsignedShort8--) {
                int a4 = a(context, i18);
                i18 = a(a4 + 2, cArr, true, classVisitor.visitTypeAnnotation(context.i, context.j, readUTF8(a4, cArr), true));
            }
        }
        if (i12 != 0) {
            int i19 = i12 + 2;
            for (int readUnsignedShort9 = readUnsignedShort(i12); readUnsignedShort9 > 0; readUnsignedShort9--) {
                int a5 = a(context, i19);
                i19 = a(a5 + 2, cArr, true, classVisitor.visitTypeAnnotation(context.i, context.j, readUTF8(a5, cArr), false));
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.a;
            attribute3.a = null;
            classVisitor.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        if (i13 != 0) {
            int i20 = i13 + 2;
            for (int readUnsignedShort10 = readUnsignedShort(i13); readUnsignedShort10 > 0; readUnsignedShort10--) {
                classVisitor.visitInnerClass(readClass(i20, cArr), readClass(i20 + 2, cArr), readUTF8(i20 + 4, cArr), readUnsignedShort(i20 + 6));
                i20 += 8;
            }
        }
        int i21 = this.header + 10 + (readUnsignedShort2 * 2);
        for (int readUnsignedShort11 = readUnsignedShort(i21 - 2); readUnsignedShort11 > 0; readUnsignedShort11--) {
            i21 = a(classVisitor, context, i21);
        }
        int i22 = i21 + 2;
        for (int readUnsignedShort12 = readUnsignedShort(i22 - 2); readUnsignedShort12 > 0; readUnsignedShort12--) {
            i22 = b(classVisitor, context, i22);
        }
        classVisitor.visitEnd();
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.d]);
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = new String[readUnsignedShort];
        if (readUnsignedShort > 0) {
            char[] cArr = new char[this.d];
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i) {
        return this.a[i];
    }

    public int getItemCount() {
        return this.a.length;
    }

    public int getMaxStringLength() {
        return this.d;
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.d]);
    }

    public int readByte(int i) {
        return this.b[i] & UByte.MAX_VALUE;
    }

    public String readClass(int i, char[] cArr) {
        return readUTF8(this.a[readUnsignedShort(i)], cArr);
    }

    public Object readConst(int i, char[] cArr) {
        int i2 = this.a[i];
        byte b2 = this.b[i2 - 1];
        if (b2 == 16) {
            return Type.getMethodType(readUTF8(i2, cArr));
        }
        switch (b2) {
            case 3:
                return new Integer(readInt(i2));
            case 4:
                return new Float(Float.intBitsToFloat(readInt(i2)));
            case 5:
                return new Long(readLong(i2));
            case 6:
                return new Double(Double.longBitsToDouble(readLong(i2)));
            case 7:
                return Type.getObjectType(readUTF8(i2, cArr));
            case 8:
                return readUTF8(i2, cArr);
            default:
                int readByte = readByte(i2);
                int[] iArr = this.a;
                int i3 = iArr[readUnsignedShort(i2 + 1)];
                String readClass = readClass(i3, cArr);
                int i4 = iArr[readUnsignedShort(i3 + 2)];
                return new Handle(readByte, readClass, readUTF8(i4, cArr), readUTF8(i4 + 2, cArr));
        }
    }

    public int readInt(int i) {
        byte[] bArr = this.b;
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    /* access modifiers changed from: protected */
    public Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    public long readLong(int i) {
        return (((long) readInt(i)) << 32) | (((long) readInt(i + 4)) & 4294967295L);
    }

    public short readShort(int i) {
        byte[] bArr = this.b;
        return (short) ((bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8));
    }

    public String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        if (i == 0 || readUnsignedShort == 0) {
            return null;
        }
        String[] strArr = this.c;
        String str = strArr[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.a[readUnsignedShort];
        String a2 = a(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = a2;
        return a2;
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.b;
        return (bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
    }
}
