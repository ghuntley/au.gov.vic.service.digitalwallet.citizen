package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$parentsWithSelf$1 extends Lambda implements Function1<DeclarationDescriptor, DeclarationDescriptor> {
    public static final DescriptorUtilsKt$parentsWithSelf$1 INSTANCE = new DescriptorUtilsKt$parentsWithSelf$1();

    DescriptorUtilsKt$parentsWithSelf$1() {
        super(1);
    }

    public final DeclarationDescriptor invoke(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "it");
        return declarationDescriptor.getContainingDeclaration();
    }
}
