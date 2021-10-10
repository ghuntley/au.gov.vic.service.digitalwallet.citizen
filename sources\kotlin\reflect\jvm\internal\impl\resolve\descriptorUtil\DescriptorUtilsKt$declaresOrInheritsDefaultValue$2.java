package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: DescriptorUtils.kt */
public final /* synthetic */ class DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$2();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "declaresDefaultValue";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ValueParameterDescriptor.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ValueParameterDescriptor valueParameterDescriptor) {
        return Boolean.valueOf(invoke(valueParameterDescriptor));
    }

    public final boolean invoke(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkNotNullParameter(valueParameterDescriptor, "p1");
        return valueParameterDescriptor.declaresDefaultValue();
    }
}
