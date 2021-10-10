package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
/* compiled from: KotlinTypeFactory.kt */
public final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotNullSimpleType(SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new NotNullSimpleType(simpleType);
    }
}
