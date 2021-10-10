package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* access modifiers changed from: package-private */
/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory$createArrayValue$1 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    final /* synthetic */ KotlinType $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstantValueFactory$createArrayValue$1(KotlinType kotlinType) {
        super(1);
        this.$type = kotlinType;
    }

    public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "it");
        return this.$type;
    }
}
