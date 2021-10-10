package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ LazyJavaClassDescriptor.LazyJavaClassTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(LazyJavaClassDescriptor.LazyJavaClassTypeConstructor lazyJavaClassTypeConstructor) {
        super(0);
        this.this$0 = lazyJavaClassTypeConstructor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends TypeParameterDescriptor> invoke() {
        return TypeParameterUtilsKt.computeConstructorTypeParameters(LazyJavaClassDescriptor.this);
    }
}
