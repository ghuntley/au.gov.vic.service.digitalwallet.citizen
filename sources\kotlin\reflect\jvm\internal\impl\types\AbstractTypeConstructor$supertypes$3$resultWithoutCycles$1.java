package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements Function1<TypeConstructor, Iterable<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor$supertypes$3 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor$supertypes$3 abstractTypeConstructor$supertypes$3) {
        super(1);
        this.this$0 = abstractTypeConstructor$supertypes$3;
    }

    public final Iterable<KotlinType> invoke(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "it");
        return this.this$0.this$0.computeNeighbours(typeConstructor, false);
    }
}
