package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* access modifiers changed from: package-private */
/* compiled from: LazyJavaScope.kt */
public final class LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1 extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1 INSTANCE = new LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1();

    LazyJavaScope$retainMostSpecificMethods$mostSpecificMethods$1() {
        super(1);
    }

    public final CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "$receiver");
        return simpleFunctionDescriptor;
    }
}
