package org.objectweb.asm;

import androidx.core.internal.view.SupportMenu;

/* access modifiers changed from: package-private */
public final class FieldWriter extends FieldVisitor {
    private final ClassWriter b;
    private final int c;
    private final int d;
    private final int e;
    private int f;
    private int g;
    private AnnotationWriter h;
    private AnnotationWriter i;
    private Attribute j;
    private AnnotationWriter k;
    private AnnotationWriter l;

    FieldWriter(ClassWriter classWriter, int i2, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM5);
        if (classWriter.B == null) {
            classWriter.B = this;
        } else {
            classWriter.C.fv = this;
        }
        classWriter.C = this;
        this.b = classWriter;
        this.c = i2;
        this.d = classWriter.newUTF8(str);
        this.e = classWriter.newUTF8(str2);
        if (str3 != null) {
            this.f = classWriter.newUTF8(str3);
        }
        if (obj != null) {
            this.g = classWriter.a(obj).a;
        }
    }

    /* access modifiers changed from: package-private */
    public int a() {
        int i2;
        if (this.g != 0) {
            this.b.newUTF8("ConstantValue");
            i2 = 16;
        } else {
            i2 = 8;
        }
        if ((this.c & 4096) != 0 && ((this.b.b & SupportMenu.USER_MASK) < 49 || (this.c & 262144) != 0)) {
            this.b.newUTF8("Synthetic");
            i2 += 6;
        }
        if ((this.c & 131072) != 0) {
            this.b.newUTF8("Deprecated");
            i2 += 6;
        }
        if (this.f != 0) {
            this.b.newUTF8("Signature");
            i2 += 8;
        }
        if (this.h != null) {
            this.b.newUTF8("RuntimeVisibleAnnotations");
            i2 += this.h.a() + 8;
        }
        if (this.i != null) {
            this.b.newUTF8("RuntimeInvisibleAnnotations");
            i2 += this.i.a() + 8;
        }
        if (this.k != null) {
            this.b.newUTF8("RuntimeVisibleTypeAnnotations");
            i2 += this.k.a() + 8;
        }
        if (this.l != null) {
            this.b.newUTF8("RuntimeInvisibleTypeAnnotations");
            i2 += this.l.a() + 8;
        }
        Attribute attribute = this.j;
        return attribute != null ? i2 + attribute.a(this.b, null, 0, -1, -1) : i2;
    }

    /* access modifiers changed from: package-private */
    public void a(ByteVector byteVector) {
        int i2 = this.c;
        byteVector.putShort(i2 & (~(((i2 & 262144) / 64) | 393216))).putShort(this.d).putShort(this.e);
        int i3 = this.g != 0 ? 1 : 0;
        if ((this.c & 4096) != 0 && ((this.b.b & SupportMenu.USER_MASK) < 49 || (this.c & 262144) != 0)) {
            i3++;
        }
        if ((this.c & 131072) != 0) {
            i3++;
        }
        if (this.f != 0) {
            i3++;
        }
        if (this.h != null) {
            i3++;
        }
        if (this.i != null) {
            i3++;
        }
        if (this.k != null) {
            i3++;
        }
        if (this.l != null) {
            i3++;
        }
        Attribute attribute = this.j;
        if (attribute != null) {
            i3 += attribute.a();
        }
        byteVector.putShort(i3);
        if (this.g != 0) {
            byteVector.putShort(this.b.newUTF8("ConstantValue"));
            byteVector.putInt(2).putShort(this.g);
        }
        if ((this.c & 4096) != 0 && ((this.b.b & SupportMenu.USER_MASK) < 49 || (this.c & 262144) != 0)) {
            byteVector.putShort(this.b.newUTF8("Synthetic")).putInt(0);
        }
        if ((this.c & 131072) != 0) {
            byteVector.putShort(this.b.newUTF8("Deprecated")).putInt(0);
        }
        if (this.f != 0) {
            byteVector.putShort(this.b.newUTF8("Signature"));
            byteVector.putInt(2).putShort(this.f);
        }
        if (this.h != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleAnnotations"));
            this.h.a(byteVector);
        }
        if (this.i != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleAnnotations"));
            this.i.a(byteVector);
        }
        if (this.k != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeVisibleTypeAnnotations"));
            this.k.a(byteVector);
        }
        if (this.l != null) {
            byteVector.putShort(this.b.newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.l.a(byteVector);
        }
        Attribute attribute2 = this.j;
        if (attribute2 != null) {
            attribute2.a(this.b, null, 0, -1, -1, byteVector);
        }
    }

    @Override // org.objectweb.asm.FieldVisitor
    public AnnotationVisitor visitAnnotation(String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, 2);
        if (z) {
            annotationWriter.g = this.h;
            this.h = annotationWriter;
        } else {
            annotationWriter.g = this.i;
            this.i = annotationWriter;
        }
        return annotationWriter;
    }

    @Override // org.objectweb.asm.FieldVisitor
    public void visitAttribute(Attribute attribute) {
        attribute.a = this.j;
        this.j = attribute;
    }

    @Override // org.objectweb.asm.FieldVisitor
    public void visitEnd() {
    }

    @Override // org.objectweb.asm.FieldVisitor
    public AnnotationVisitor visitTypeAnnotation(int i2, TypePath typePath, String str, boolean z) {
        ByteVector byteVector = new ByteVector();
        AnnotationWriter.a(i2, typePath, byteVector);
        byteVector.putShort(this.b.newUTF8(str)).putShort(0);
        AnnotationWriter annotationWriter = new AnnotationWriter(this.b, true, byteVector, byteVector, byteVector.b - 2);
        if (z) {
            annotationWriter.g = this.k;
            this.k = annotationWriter;
        } else {
            annotationWriter.g = this.l;
            this.l = annotationWriter;
        }
        return annotationWriter;
    }
}
