package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: AbstractTypeAliasDescriptor.kt */
final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        Intrinsics.checkNotNullExpressionValue(unwrappedType, "type");
        boolean z = false;
        if (!KotlinTypeKt.isError(unwrappedType)) {
            ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
            if ((declarationDescriptor instanceof TypeParameterDescriptor) && (Intrinsics.areEqual(((TypeParameterDescriptor) declarationDescriptor).getContainingDeclaration(), this.this$0) ^ true)) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}
