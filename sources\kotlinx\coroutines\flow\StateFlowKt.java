package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u0002H\nH\u0007¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00038\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0005¨\u0006\r"}, d2 = {"INITIAL_SIZE", "", "NONE", "Lkotlinx/coroutines/internal/Symbol;", "NONE$annotations", "()V", "PENDING", "PENDING$annotations", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 16})
/* compiled from: StateFlow.kt */
public final class StateFlowKt {
    private static final int INITIAL_SIZE = 2;
    private static final Symbol NONE = new Symbol("NONE");
    private static final Symbol PENDING = new Symbol("PENDING");

    private static /* synthetic */ void NONE$annotations() {
    }

    private static /* synthetic */ void PENDING$annotations() {
    }

    public static final <T> MutableStateFlow<T> MutableStateFlow(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(t);
    }
}
