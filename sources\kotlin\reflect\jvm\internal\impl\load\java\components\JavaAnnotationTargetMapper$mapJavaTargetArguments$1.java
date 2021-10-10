package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaAnnotationTargetMapper$mapJavaTargetArguments$1 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    public static final JavaAnnotationTargetMapper$mapJavaTargetArguments$1 INSTANCE = new JavaAnnotationTargetMapper$mapJavaTargetArguments$1();

    JavaAnnotationTargetMapper$mapJavaTargetArguments$1() {
        super(1);
    }

    public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
        KotlinType type;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), moduleDescriptor.getBuiltIns().getBuiltInClassByFqName(KotlinBuiltIns.FQ_NAMES.target));
        if (annotationParameterByName != null && (type = annotationParameterByName.getType()) != null) {
            return type;
        }
        SimpleType createErrorType = ErrorUtils.createErrorType("Error: AnnotationTarget[]");
        Intrinsics.checkNotNullExpressionValue(createErrorType, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
        return createErrorType;
    }
}
