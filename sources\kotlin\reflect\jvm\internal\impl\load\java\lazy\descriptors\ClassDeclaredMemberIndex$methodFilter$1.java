package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;

/* compiled from: DeclaredMemberIndex.kt */
final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {
    final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.this$0 = classDeclaredMemberIndex;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(JavaMethod javaMethod) {
        return Boolean.valueOf(invoke(javaMethod));
    }

    public final boolean invoke(JavaMethod javaMethod) {
        Intrinsics.checkNotNullParameter(javaMethod, "m");
        return ((Boolean) ClassDeclaredMemberIndex.access$getMemberFilter$p(this.this$0).invoke(javaMethod)).booleanValue() && !DescriptorResolverUtils.isObjectMethodInInterface(javaMethod);
    }
}
