package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public final class JavaTypeResolverKt {
    private static final FqName JAVA_LANG_CLASS_FQ_NAME = new FqName("java.lang.Class");

    public static final TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes) {
        StarProjectionImpl starProjectionImpl;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        if (javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            starProjectionImpl = new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameterDescriptor));
        } else {
            starProjectionImpl = new StarProjectionImpl(typeParameterDescriptor);
        }
        return starProjectionImpl;
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z, typeParameterDescriptor);
    }

    public static final JavaTypeAttributes toAttributes(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeUsage, "$this$toAttributes");
        return new JavaTypeAttributes(typeUsage, null, z, typeParameterDescriptor, 2, null);
    }

    public static /* synthetic */ KotlinType getErasedUpperBound$default(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            typeParameterDescriptor2 = null;
        }
        if ((i & 2) != 0) {
            function0 = new JavaTypeResolverKt$getErasedUpperBound$1(typeParameterDescriptor);
        }
        return getErasedUpperBound(typeParameterDescriptor, typeParameterDescriptor2, function0);
    }

    public static final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "$this$getErasedUpperBound");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        if (typeParameterDescriptor == typeParameterDescriptor2) {
            return (KotlinType) function0.invoke();
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
        KotlinType kotlinType = (KotlinType) CollectionsKt.first((List) upperBounds);
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics.checkNotNullExpressionValue(kotlinType, "firstUpperBound");
            return TypeUtilsKt.replaceArgumentsWithStarProjections(kotlinType);
        }
        if (typeParameterDescriptor2 != null) {
            typeParameterDescriptor = typeParameterDescriptor2;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
            if (!(!Intrinsics.areEqual(typeParameterDescriptor3, typeParameterDescriptor))) {
                return (KotlinType) function0.invoke();
            }
            List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
            KotlinType kotlinType2 = (KotlinType) CollectionsKt.first((List) upperBounds2);
            if (kotlinType2.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "nextUpperBound");
                return TypeUtilsKt.replaceArgumentsWithStarProjections(kotlinType2);
            }
            declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }
}
