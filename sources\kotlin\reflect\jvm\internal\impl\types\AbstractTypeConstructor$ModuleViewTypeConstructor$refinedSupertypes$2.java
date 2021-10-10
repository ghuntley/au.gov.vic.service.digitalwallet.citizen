package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;

/* access modifiers changed from: package-private */
/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 extends Lambda implements Function0<List<? extends KotlinType>> {
    final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor) {
        super(0);
        this.this$0 = moduleViewTypeConstructor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KotlinType> invoke() {
        return KotlinTypeRefinerKt.refineTypes(this.this$0.kotlinTypeRefiner, this.this$0.this$0.getSupertypes());
    }
}
