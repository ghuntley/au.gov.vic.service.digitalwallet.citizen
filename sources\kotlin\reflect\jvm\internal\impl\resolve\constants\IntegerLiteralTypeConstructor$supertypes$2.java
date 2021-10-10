package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: IntegerLiteralTypeConstructor.kt */
final class IntegerLiteralTypeConstructor$supertypes$2 extends Lambda implements Function0<List<SimpleType>> {
    final /* synthetic */ IntegerLiteralTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        super(0);
        this.this$0 = integerLiteralTypeConstructor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<SimpleType> invoke() {
        ClassDescriptor comparable = this.this$0.getBuiltIns().getComparable();
        Intrinsics.checkNotNullExpressionValue(comparable, "builtIns.comparable");
        SimpleType defaultType = comparable.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
        List<SimpleType> mutableListOf = CollectionsKt.mutableListOf(TypeSubstitutionKt.replace$default(defaultType, CollectionsKt.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, IntegerLiteralTypeConstructor.access$getType$p(this.this$0))), (Annotations) null, 2, (Object) null));
        if (!IntegerLiteralTypeConstructor.access$isContainsOnlyUnsignedTypes(this.this$0)) {
            mutableListOf.add(this.this$0.getBuiltIns().getNumberType());
        }
        return mutableListOf;
    }
}
