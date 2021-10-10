package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX WARN: Init of enum UBYTE can be incorrect */
/* JADX WARN: Init of enum USHORT can be incorrect */
/* JADX WARN: Init of enum UINT can be incorrect */
/* JADX WARN: Init of enum ULONG can be incorrect */
/* compiled from: UnsignedType.kt */
public enum UnsignedType {
    UBYTE(r2),
    USHORT(r2),
    UINT(r2),
    ULONG(r2);
    
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private UnsignedType(ClassId classId2) {
        this.classId = classId2;
        Name shortClassName = classId2.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        FqName packageFqName = classId2.getPackageFqName();
        this.arrayClassId = new ClassId(packageFqName, Name.identifier(shortClassName.asString() + "Array"));
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    static {
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UByte"), "ClassId.fromString(\"kotlin/UByte\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UShort"), "ClassId.fromString(\"kotlin/UShort\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/UInt"), "ClassId.fromString(\"kotlin/UInt\")");
        Intrinsics.checkNotNullExpressionValue(ClassId.fromString("kotlin/ULong"), "ClassId.fromString(\"kotlin/ULong\")");
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}
