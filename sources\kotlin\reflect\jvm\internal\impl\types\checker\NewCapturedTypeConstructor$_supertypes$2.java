package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* access modifiers changed from: package-private */
/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeConstructor$_supertypes$2 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
    }

    /* Return type fixed from 'java.util.List<kotlin.reflect.jvm.internal.impl.types.UnwrappedType>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends UnwrappedType> invoke() {
        Function0 function0 = this.this$0.supertypesComputation;
        if (function0 != null) {
            return (List) function0.invoke();
        }
        return null;
    }
}
