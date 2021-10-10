package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: PlatformDependentTypeTransformer.kt */
public interface PlatformDependentTypeTransformer {
    SimpleType transformPlatformType(ClassId classId, SimpleType simpleType);

    /* compiled from: PlatformDependentTypeTransformer.kt */
    public static final class None implements PlatformDependentTypeTransformer {
        public static final None INSTANCE = new None();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        public SimpleType transformPlatformType(ClassId classId, SimpleType simpleType) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(simpleType, "computedType");
            return simpleType;
        }

        private None() {
        }
    }
}
