package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends Lambda implements Function1<KotlinType, Unit> {
    final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
        super(1);
        this.this$0 = abstractTypeConstructor$supertypes$3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
        invoke(kotlinType);
        return Unit.INSTANCE;
    }

    public final void invoke(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        this.this$0.this$0.reportSupertypeLoopError(kotlinType);
    }
}
