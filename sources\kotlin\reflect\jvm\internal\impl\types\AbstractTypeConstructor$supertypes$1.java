package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$1 extends Lambda implements Function0<AbstractTypeConstructor.Supertypes> {
    final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final AbstractTypeConstructor.Supertypes invoke() {
        return new AbstractTypeConstructor.Supertypes(this.this$0.computeSupertypes());
    }
}
