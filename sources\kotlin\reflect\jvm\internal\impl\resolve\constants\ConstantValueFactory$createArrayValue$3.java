package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* access modifiers changed from: package-private */
/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory$createArrayValue$3 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    final /* synthetic */ PrimitiveType $componentType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstantValueFactory$createArrayValue$3(PrimitiveType primitiveType) {
        super(1);
        this.$componentType = primitiveType;
    }

    public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType primitiveArrayKotlinType = moduleDescriptor.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
        Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimi…KotlinType(componentType)");
        return primitiveArrayKotlinType;
    }
}
