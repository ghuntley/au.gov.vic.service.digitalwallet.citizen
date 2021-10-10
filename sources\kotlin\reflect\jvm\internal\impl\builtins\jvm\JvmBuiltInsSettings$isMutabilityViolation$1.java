package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* access modifiers changed from: package-private */
/* compiled from: JvmBuiltInsSettings.kt */
public final class JvmBuiltInsSettings$isMutabilityViolation$1<N> implements DFS.Neighbors<CallableMemberDescriptor> {
    public static final JvmBuiltInsSettings$isMutabilityViolation$1 INSTANCE = new JvmBuiltInsSettings$isMutabilityViolation$1();

    JvmBuiltInsSettings$isMutabilityViolation$1() {
    }

    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor, "it");
        CallableMemberDescriptor original = callableMemberDescriptor.getOriginal();
        Intrinsics.checkNotNullExpressionValue(original, "it.original");
        return original.getOverriddenDescriptors();
    }
}
