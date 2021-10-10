package org.objectweb.asm;

import androidx.core.internal.view.SupportMenu;

public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    static final byte[] a;
    ByteVector A;
    FieldWriter B;
    FieldWriter C;
    MethodWriter D;
    MethodWriter E;
    private short G;
    Item[] H;
    String I;
    private boolean J;
    private boolean K;
    boolean L;
    ClassReader M;
    private AnnotationWriter N;
    private AnnotationWriter O;
    int b;
    int c;
    final ByteVector d;
    Item[] e;
    int f;
    final Item g;
    final Item h;
    final Item i;
    final Item j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int[] p;
    private int q;
    private ByteVector r;
    private int s;
    private int t;
    private AnnotationWriter u;
    private AnnotationWriter v;
    private Attribute w;
    private int x;
    private ByteVector y;
    int z;

    static {
        _clinit_();
        byte[] bArr = new byte[220];
        for (int i2 = 0; i2 < 220; i2++) {
            bArr[i2] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i2) - 'A');
        }
        a = bArr;
    }

    public ClassWriter(int i2) {
        super(Opcodes.ASM5);
        boolean z2 = true;
        this.c = 1;
        this.d = new ByteVector();
        Item[] itemArr = new Item[256];
        this.e = itemArr;
        this.f = (int) (((double) itemArr.length) * 0.75d);
        this.g = new Item();
        this.h = new Item();
        this.i = new Item();
        this.j = new Item();
        this.K = (i2 & 1) != 0;
        this.J = (i2 & 2) == 0 ? false : z2;
    }

    public ClassWriter(ClassReader classReader, int i2) {
        this(i2);
        classReader.a(this);
        this.M = classReader;
    }

    static /* synthetic */ void _clinit_() {
    }

    private Item a(Item item) {
        Item item2 = this.e[item.j % this.e.length];
        while (item2 != null && (item2.b != item.b || !item.a(item2))) {
            item2 = item2.k;
        }
        return item2;
    }

    private void a(int i2, int i3, int i4) {
        this.d.b(i2, i3).putShort(i4);
    }

    private Item b(String str) {
        this.h.a(8, str, null, null);
        Item a2 = a(this.h);
        if (a2 != null) {
            return a2;
        }
        this.d.b(8, newUTF8(str));
        int i2 = this.c;
        this.c = i2 + 1;
        Item item = new Item(i2, this.h);
        b(item);
        return item;
    }

    private void b(int i2, int i3, int i4) {
        this.d.a(i2, i3).putShort(i4);
    }

    private void b(Item item) {
        if (this.c + this.G > this.f) {
            int length = this.e.length;
            int i2 = (length * 2) + 1;
            Item[] itemArr = new Item[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                Item item2 = this.e[i3];
                while (item2 != null) {
                    int i4 = item2.j % i2;
                    Item item3 = item2.k;
                    item2.k = itemArr[i4];
                    itemArr[i4] = item2;
                    item2 = item3;
                }
            }
            this.e = itemArr;
            this.f = (int) (((double) i2) * 0.75d);
        }
        int i5 = item.j;
        Item[] itemArr2 = this.e;
        int length2 = i5 % itemArr2.length;
        item.k = itemArr2[length2];
        this.e[length2] = item;
    }

    private Item c(Item item) {
        short s2 = (short) (this.G + 1);
        this.G = s2;
        Item item2 = new Item(s2, this.g);
        b(item2);
        if (this.H == null) {
            this.H = new Item[16];
        }
        short s3 = this.G;
        Item[] itemArr = this.H;
        if (s3 == itemArr.length) {
            Item[] itemArr2 = new Item[(itemArr.length * 2)];
            System.arraycopy(itemArr, 0, itemArr2, 0, itemArr.length);
            this.H = itemArr2;
        }
        this.H[this.G] = item2;
        return item2;
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, int i3) {
        this.h.b = 32;
        this.h.d = ((long) i2) | (((long) i3) << 32);
        this.h.j = (i2 + 32 + i3) & Integer.MAX_VALUE;
        Item a2 = a(this.h);
        if (a2 == null) {
            String str = this.H[i2].g;
            String str2 = this.H[i3].g;
            this.h.c = c(getCommonSuperClass(str, str2));
            a2 = new Item(0, this.h);
            b(a2);
        }
        return a2.c;
    }

    /* access modifiers changed from: package-private */
    public int a(String str, int i2) {
        this.g.b = 31;
        this.g.c = i2;
        this.g.g = str;
        this.g.j = (str.hashCode() + 31 + i2) & Integer.MAX_VALUE;
        Item a2 = a(this.g);
        if (a2 == null) {
            a2 = c(this.g);
        }
        return a2.a;
    }

    /* access modifiers changed from: package-private */
    public Item a(double d2) {
        this.g.a(d2);
        Item a2 = a(this.g);
        if (a2 != null) {
            return a2;
        }
        this.d.putByte(6).putLong(this.g.d);
        Item item = new Item(this.c, this.g);
        this.c += 2;
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(float f2) {
        this.g.a(f2);
        Item a2 = a(this.g);
        if (a2 != null) {
            return a2;
        }
        this.d.putByte(4).putInt(this.g.c);
        int i2 = this.c;
        this.c = i2 + 1;
        Item item = new Item(i2, this.g);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(int i2) {
        this.g.a(i2);
        Item a2 = a(this.g);
        if (a2 != null) {
            return a2;
        }
        this.d.putByte(3).putInt(i2);
        int i3 = this.c;
        this.c = i3 + 1;
        Item item = new Item(i3, this.g);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(int i2, String str, String str2, String str3) {
        int newMethod;
        this.j.a(i2 + 20, str, str2, str3);
        Item a2 = a(this.j);
        if (a2 != null) {
            return a2;
        }
        if (i2 <= 4) {
            newMethod = newField(str, str2, str3);
        } else {
            newMethod = newMethod(str, str2, str3, i2 == 9);
        }
        b(15, i2, newMethod);
        int i3 = this.c;
        this.c = i3 + 1;
        Item item = new Item(i3, this.j);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(long j2) {
        this.g.a(j2);
        Item a2 = a(this.g);
        if (a2 != null) {
            return a2;
        }
        this.d.putByte(5).putLong(j2);
        Item item = new Item(this.c, this.g);
        this.c += 2;
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(Object obj) {
        if (obj instanceof Integer) {
            return a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return a(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return a(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return a(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return b((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            int sort = type.getSort();
            if (sort == 10) {
                return a(type.getInternalName());
            }
            String descriptor = type.getDescriptor();
            return sort == 11 ? m1381c(descriptor) : a(descriptor);
        } else if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return a(handle.a, handle.b, handle.c, handle.d);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("value ");
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public Item a(String str) {
        this.h.a(7, str, null, null);
        Item a2 = a(this.h);
        if (a2 != null) {
            return a2;
        }
        this.d.b(7, newUTF8(str));
        int i2 = this.c;
        this.c = i2 + 1;
        Item item = new Item(i2, this.h);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(String str, String str2) {
        this.h.a(12, str, str2, null);
        Item a2 = a(this.h);
        if (a2 != null) {
            return a2;
        }
        a(12, newUTF8(str), newUTF8(str2));
        int i2 = this.c;
        this.c = i2 + 1;
        Item item = new Item(i2, this.h);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(String str, String str2, String str3) {
        this.i.a(9, str, str2, str3);
        Item a2 = a(this.i);
        if (a2 != null) {
            return a2;
        }
        a(9, newClass(str), newNameType(str2, str3));
        int i2 = this.c;
        this.c = i2 + 1;
        Item item = new Item(i2, this.i);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(String str, String str2, String str3, boolean z2) {
        int i2 = z2 ? 11 : 10;
        this.i.a(i2, str, str2, str3);
        Item a2 = a(this.i);
        if (a2 != null) {
            return a2;
        }
        a(i2, newClass(str), newNameType(str2, str3));
        int i3 = this.c;
        this.c = i3 + 1;
        Item item = new Item(i3, this.i);
        b(item);
        return item;
    }

    /* access modifiers changed from: package-private */
    public Item a(String str, String str2, Handle handle, Object... objArr) {
        int i2;
        ByteVector byteVector = this.A;
        if (byteVector == null) {
            byteVector = new ByteVector();
            this.A = byteVector;
        }
        int i3 = byteVector.b;
        int hashCode = handle.hashCode();
        byteVector.putShort(newHandle(handle.a, handle.b, handle.c, handle.d));
        int length = objArr.length;
        byteVector.putShort(length);
        for (Object obj : objArr) {
            hashCode ^= obj.hashCode();
            byteVector.putShort(newConst(obj));
        }
        byte[] bArr = byteVector.a;
        int i4 = (length + 2) << 1;
        int i5 = hashCode & Integer.MAX_VALUE;
        Item[] itemArr = this.e;
        Item item = itemArr[i5 % itemArr.length];
        loop1:
        while (item != null) {
            if (item.b == 33 && item.j == i5) {
                int i6 = item.c;
                for (int i7 = 0; i7 < i4; i7++) {
                    if (bArr[i3 + i7] == bArr[i6 + i7]) {
                    }
                }
                break loop1;
            }
            item = item.k;
        }
        if (item != null) {
            i2 = item.a;
            byteVector.b = i3;
        } else {
            i2 = this.z;
            this.z = i2 + 1;
            Item item2 = new Item(i2);
            item2.a(i3, i5);
            b(item2);
        }
        this.i.a(str, str2, i2);
        Item a2 = a(this.i);
        if (a2 != null) {
            return a2;
        }
        a(18, i2, newNameType(str, str2));
        int i8 = this.c;
        this.c = i8 + 1;
        Item item3 = new Item(i8, this.i);
        b(item3);
        return item3;
    }

    /* access modifiers changed from: package-private */
    public int c(String str) {
        this.g.a(30, str, null, null);
        Item a2 = a(this.g);
        if (a2 == null) {
            a2 = c(this.g);
        }
        return a2.a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c  reason: collision with other method in class */
    public Item m1381c(String str) {
        this.h.a(16, str, null, null);
        Item a2 = a(this.h);
        if (a2 != null) {
            return a2;
        }
        this.d.b(16, newUTF8(str));
        int i2 = this.c;
        this.c = i2 + 1;
        Item item = new Item(i2, this.h);
        b(item);
        return item;
    }

    /* access modifiers changed from: protected */
    public String getCommonSuperClass(String str, String str2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> cls = Class.forName(str.replace('/', '.'), false, classLoader);
            Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return str;
            }
            if (cls2.isAssignableFrom(cls)) {
                return str2;
            }
            if (cls.isInterface() || cls2.isInterface()) {
                return "java/lang/Object";
            }
            do {
                cls = cls.getSuperclass();
            } while (!cls.isAssignableFrom(cls2));
            return cls.getName().replace('.', '/');
        } catch (Exception e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public int newClass(String str) {
        return a(str).a;
    }

    public int newConst(Object obj) {
        return a(obj).a;
    }

    public int newField(String str, String str2, String str3) {
        return a(str, str2, str3).a;
    }

    public int newHandle(int i2, String str, String str2, String str3) {
        return a(i2, str, str2, str3).a;
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return a(str, str2, handle, objArr).a;
    }

    public int newMethod(String str, String str2, String str3, boolean z2) {
        return a(str, str2, str3, z2).a;
    }

    public int newMethodType(String str) {
        return m1381c(str).a;
    }

    public int newNameType(String str, String str2) {
        return a(str, str2).a;
    }

    public int newUTF8(String str) {
        this.g.a(1, str, null, null);
        Item a2 = a(this.g);
        if (a2 == null) {
            this.d.putByte(1).putUTF8(str);
            int i2 = this.c;
            this.c = i2 + 1;
            a2 = new Item(i2, this.g);
            b(a2);
        }
        return a2.a;
    }

    public byte[] toByteArray() {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        ByteVector byteVector;
        if (this.c <= 65535) {
            int i4 = (this.o * 2) + 24;
            int i5 = 0;
            for (FieldWriter fieldWriter = this.B; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.fv) {
                i5++;
                i4 += fieldWriter.a();
            }
            int i6 = 0;
            for (MethodWriter methodWriter = this.D; methodWriter != null; methodWriter = (MethodWriter) methodWriter.mv) {
                i6++;
                i4 += methodWriter.a();
            }
            ByteVector byteVector2 = this.A;
            if (byteVector2 != null) {
                i4 += byteVector2.b + 8;
                newUTF8("BootstrapMethods");
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.m != 0) {
                i2++;
                i4 += 8;
                newUTF8("Signature");
            }
            if (this.q != 0) {
                i2++;
                i4 += 8;
                newUTF8("SourceFile");
            }
            ByteVector byteVector3 = this.r;
            if (byteVector3 != null) {
                i2++;
                i4 += byteVector3.b + 6;
                newUTF8("SourceDebugExtension");
            }
            if (this.s != 0) {
                i2++;
                i4 += 10;
                newUTF8("EnclosingMethod");
            }
            if ((this.k & 131072) != 0) {
                i2++;
                i4 += 6;
                newUTF8("Deprecated");
            }
            int i7 = this.k;
            if ((i7 & 4096) != 0 && ((this.b & SupportMenu.USER_MASK) < 49 || (i7 & 262144) != 0)) {
                i2++;
                i4 += 6;
                newUTF8("Synthetic");
            }
            ByteVector byteVector4 = this.y;
            if (byteVector4 != null) {
                i2++;
                i4 += byteVector4.b + 8;
                newUTF8("InnerClasses");
            }
            AnnotationWriter annotationWriter = this.u;
            if (annotationWriter != null) {
                i2++;
                i4 += annotationWriter.a() + 8;
                newUTF8("RuntimeVisibleAnnotations");
            }
            AnnotationWriter annotationWriter2 = this.v;
            if (annotationWriter2 != null) {
                i2++;
                i4 += annotationWriter2.a() + 8;
                newUTF8("RuntimeInvisibleAnnotations");
            }
            AnnotationWriter annotationWriter3 = this.N;
            if (annotationWriter3 != null) {
                i2++;
                i4 += annotationWriter3.a() + 8;
                newUTF8("RuntimeVisibleTypeAnnotations");
            }
            AnnotationWriter annotationWriter4 = this.O;
            if (annotationWriter4 != null) {
                i2++;
                i4 += annotationWriter4.a() + 8;
                newUTF8("RuntimeInvisibleTypeAnnotations");
            }
            int i8 = i4;
            Attribute attribute = this.w;
            if (attribute != null) {
                int a2 = i2 + attribute.a();
                str3 = "Deprecated";
                str2 = "EnclosingMethod";
                str = "RuntimeVisibleTypeAnnotations";
                str4 = "RuntimeInvisibleAnnotations";
                str5 = "SourceDebugExtension";
                i8 += this.w.a(this, null, 0, -1, -1);
                i2 = a2;
            } else {
                str3 = "Deprecated";
                str2 = "EnclosingMethod";
                str = "RuntimeVisibleTypeAnnotations";
                str4 = "RuntimeInvisibleAnnotations";
                str5 = "SourceDebugExtension";
            }
            ByteVector byteVector5 = new ByteVector(i8 + this.d.b);
            byteVector5.putInt(-889275714).putInt(this.b);
            byteVector5.putShort(this.c).putByteArray(this.d.a, 0, this.d.b);
            int i9 = this.k;
            byteVector5.putShort((~(393216 | ((i9 & 262144) / 64))) & i9).putShort(this.l).putShort(this.n);
            byteVector5.putShort(this.o);
            for (int i10 = 0; i10 < this.o; i10++) {
                byteVector5.putShort(this.p[i10]);
            }
            byteVector5.putShort(i5);
            for (FieldWriter fieldWriter2 = this.B; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.fv) {
                fieldWriter2.a(byteVector5);
            }
            byteVector5.putShort(i6);
            for (MethodWriter methodWriter2 = this.D; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.mv) {
                methodWriter2.a(byteVector5);
            }
            byteVector5.putShort(i2);
            if (this.A != null) {
                byteVector5.putShort(newUTF8("BootstrapMethods"));
                byteVector5.putInt(this.A.b + 2).putShort(this.z);
                byteVector5.putByteArray(this.A.a, 0, this.A.b);
            }
            if (this.m != 0) {
                i3 = 2;
                byteVector5.putShort(newUTF8("Signature")).putInt(2).putShort(this.m);
            } else {
                i3 = 2;
            }
            if (this.q != 0) {
                byteVector5.putShort(newUTF8("SourceFile")).putInt(i3).putShort(this.q);
            }
            ByteVector byteVector6 = this.r;
            if (byteVector6 != null) {
                int i11 = byteVector6.b;
                byteVector5.putShort(newUTF8(str5)).putInt(i11);
                byteVector5.putByteArray(this.r.a, 0, i11);
            }
            if (this.s != 0) {
                byteVector5.putShort(newUTF8(str2)).putInt(4);
                byteVector5.putShort(this.s).putShort(this.t);
            }
            if ((this.k & 131072) != 0) {
                byteVector5.putShort(newUTF8(str3)).putInt(0);
            }
            int i12 = this.k;
            if ((i12 & 4096) != 0 && ((this.b & SupportMenu.USER_MASK) < 49 || (i12 & 262144) != 0)) {
                byteVector5.putShort(newUTF8("Synthetic")).putInt(0);
            }
            if (this.y != null) {
                byteVector5.putShort(newUTF8("InnerClasses"));
                byteVector5.putInt(this.y.b + 2).putShort(this.x);
                byteVector5.putByteArray(this.y.a, 0, this.y.b);
            }
            if (this.u != null) {
                byteVector5.putShort(newUTF8("RuntimeVisibleAnnotations"));
                this.u.a(byteVector5);
            }
            if (this.v != null) {
                byteVector5.putShort(newUTF8(str4));
                this.v.a(byteVector5);
            }
            if (this.N != null) {
                byteVector5.putShort(newUTF8(str));
                this.N.a(byteVector5);
            }
            if (this.O != null) {
                byteVector5.putShort(newUTF8("RuntimeInvisibleTypeAnnotations"));
                this.O.a(byteVector5);
            }
            Attribute attribute2 = this.w;
            if (attribute2 != null) {
                byteVector = byteVector5;
                attribute2.a(this, null, 0, -1, -1, byteVector);
            } else {
                byteVector = byteVector5;
            }
            if (!this.L) {
                return byteVector.a;
            }
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = 0;
            this.y = null;
            this.z = 0;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.K = false;
            this.J = true;
            this.L = false;
            new ClassReader(byteVector.a).accept(this, 4);
            return toByteArray();
        }
        throw new RuntimeException("Class file too large!");
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final void visit(int i2, int i3, String str, String str2, String str3, String[] strArr) {
        this.b = i2;
        this.k = i3;
        this.l = newClass(str);
        this.I = str;
        if (str2 != null) {
            this.m = newUTF8(str2);
        }
        this.n = str3 == null ? 0 : newClass(str3);
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.o = length;
            this.p = new int[length];
            for (int i4 = 0; i4 < this.o; i4++) {
                this.p[i4] = newClass(strArr[i4]);
            }
        }
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final AnnotationVisitor visitAnnotation(String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, 2);
        if (z2) {
            annotationWriter.g = this.u;
            this.u = annotationWriter;
        } else {
            annotationWriter.g = this.v;
            this.v = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final void visitAttribute(Attribute attribute) {
        attribute.a = this.w;
        this.w = attribute;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final void visitEnd() {
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final FieldVisitor visitField(int i2, String str, String str2, String str3, Object obj) {
        return new FieldWriter(this, i2, str, str2, str3, obj);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final void visitInnerClass(String str, String str2, String str3, int i2) {
        if (this.y == null) {
            this.y = new ByteVector();
        }
        Item a2 = a(str);
        if (a2.c == 0) {
            this.x++;
            this.y.putShort(a2.a);
            int i3 = 0;
            this.y.putShort(str2 == null ? 0 : newClass(str2));
            ByteVector byteVector = this.y;
            if (str3 != null) {
                i3 = newUTF8(str3);
            }
            byteVector.putShort(i3);
            this.y.putShort(i2);
            a2.c = this.x;
        }
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final MethodVisitor visitMethod(int i2, String str, String str2, String str3, String[] strArr) {
        return new MethodWriter(this, i2, str, str2, str3, strArr, this.K, this.J);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final void visitOuterClass(String str, String str2, String str3) {
        this.s = newClass(str);
        if (str2 != null && str3 != null) {
            this.t = newNameType(str2, str3);
        }
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final void visitSource(String str, String str2) {
        if (str != null) {
            this.q = newUTF8(str);
        }
        if (str2 != null) {
            this.r = new ByteVector().c(str2, 0, Integer.MAX_VALUE);
        }
    }

    @Override // org.objectweb.asm.ClassVisitor
    public final AnnotationVisitor visitTypeAnnotation(int i2, TypePath typePath, String str, boolean z2) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this, true, byteVector, byteVector, byteVector.b - 2);
        if (z2) {
            annotationWriter.g = this.N;
            this.N = annotationWriter;
        } else {
            annotationWriter.g = this.O;
            this.O = annotationWriter;
        }
        return annotationWriter;
    }
}
