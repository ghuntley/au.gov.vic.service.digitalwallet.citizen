package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectionTypes.kt */
public final class ReflectionTypesKt {
    private static final FqName KOTLIN_REFLECT_FQ_NAME = new FqName("kotlin.reflect");
    private static final String K_FUNCTION_PREFIX = "KFunction";
    private static final String K_MUTABLE_PROPERTY_PREFIX = "KMutableProperty";
    private static final String K_PROPERTY_PREFIX = "KProperty";
    private static final String K_SUSPEND_FUNCTION_PREFIX = "KSuspendFunction";
    private static final List<String> PREFIXES = CollectionsKt.listOf((Object[]) new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});

    public static final FqName getKOTLIN_REFLECT_FQ_NAME() {
        return KOTLIN_REFLECT_FQ_NAME;
    }
}
