package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* access modifiers changed from: package-private */
/* compiled from: typeParameterUtils.kt */
public final class TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 extends Lambda implements Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>> {
    public static final TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3 INSTANCE = new TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3();

    TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3() {
        super(1);
    }

    public final Sequence<TypeParameterDescriptor> invoke(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "it");
        List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) declarationDescriptor).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "(it as CallableDescriptor).typeParameters");
        return CollectionsKt.asSequence(typeParameters);
    }
}
