package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: ReflectJavaClass.kt */
public final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {
    final /* synthetic */ ReflectJavaClass this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
        return Boolean.valueOf(invoke(method));
    }

    public final boolean invoke(Method method) {
        Intrinsics.checkNotNullExpressionValue(method, FirebaseAnalytics.Param.METHOD);
        return !method.isSynthetic() && (!this.this$0.isEnum() || !(this.this$0.isEnumValuesOrValueOf(method)));
    }
}
