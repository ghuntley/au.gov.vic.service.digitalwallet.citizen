package org.objectweb.asm;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;

public class TypeReference {
    public static final int CAST = 71;
    public static final int CLASS_EXTENDS = 16;
    public static final int CLASS_TYPE_PARAMETER = 0;
    public static final int CLASS_TYPE_PARAMETER_BOUND = 17;
    public static final int CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT = 72;
    public static final int CONSTRUCTOR_REFERENCE = 69;
    public static final int CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT = 74;
    public static final int EXCEPTION_PARAMETER = 66;
    public static final int FIELD = 19;
    public static final int INSTANCEOF = 67;
    public static final int LOCAL_VARIABLE = 64;
    public static final int METHOD_FORMAL_PARAMETER = 22;
    public static final int METHOD_INVOCATION_TYPE_ARGUMENT = 73;
    public static final int METHOD_RECEIVER = 21;
    public static final int METHOD_REFERENCE = 70;
    public static final int METHOD_REFERENCE_TYPE_ARGUMENT = 75;
    public static final int METHOD_RETURN = 20;
    public static final int METHOD_TYPE_PARAMETER = 1;
    public static final int METHOD_TYPE_PARAMETER_BOUND = 18;
    public static final int NEW = 68;
    public static final int RESOURCE_VARIABLE = 65;
    public static final int THROWS = 23;
    private int a;

    public TypeReference(int i) {
        this.a = i;
    }

    public static TypeReference newExceptionReference(int i) {
        return new TypeReference((i << 8) | 385875968);
    }

    public static TypeReference newFormalParameterReference(int i) {
        return new TypeReference((i << 16) | 369098752);
    }

    public static TypeReference newSuperTypeReference(int i) {
        return new TypeReference(((i & SupportMenu.USER_MASK) << 8) | 268435456);
    }

    public static TypeReference newTryCatchReference(int i) {
        return new TypeReference((i << 8) | 1107296256);
    }

    public static TypeReference newTypeArgumentReference(int i, int i2) {
        return new TypeReference((i << 24) | i2);
    }

    public static TypeReference newTypeParameterBoundReference(int i, int i2, int i3) {
        return new TypeReference((i << 24) | (i2 << 16) | (i3 << 8));
    }

    public static TypeReference newTypeParameterReference(int i, int i2) {
        return new TypeReference((i << 24) | (i2 << 16));
    }

    public static TypeReference newTypeReference(int i) {
        return new TypeReference(i << 24);
    }

    public int getExceptionIndex() {
        return (this.a & 16776960) >> 8;
    }

    public int getFormalParameterIndex() {
        return (this.a & 16711680) >> 16;
    }

    public int getSort() {
        return this.a >>> 24;
    }

    public int getSuperTypeIndex() {
        return (short) ((this.a & 16776960) >> 8);
    }

    public int getTryCatchBlockIndex() {
        return (this.a & 16776960) >> 8;
    }

    public int getTypeArgumentIndex() {
        return this.a & 255;
    }

    public int getTypeParameterBoundIndex() {
        return (this.a & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public int getTypeParameterIndex() {
        return (this.a & 16711680) >> 16;
    }

    public int getValue() {
        return this.a;
    }
}
