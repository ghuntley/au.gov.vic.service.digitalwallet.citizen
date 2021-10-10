package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaAnnotationMapper.kt */
final class JavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaAnnotationDescriptor$type$2(JavaAnnotationDescriptor javaAnnotationDescriptor, LazyJavaResolverContext lazyJavaResolverContext) {
        super(0);
        this.this$0 = javaAnnotationDescriptor;
        this.$c = lazyJavaResolverContext;
    }

    @Override // kotlin.jvm.functions.Function0
    public final SimpleType invoke() {
        ClassDescriptor builtInClassByFqName = this.$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName());
        Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
        SimpleType defaultType = builtInClassByFqName.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBui…qName(fqName).defaultType");
        return defaultType;
    }
}
