package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`&2\b\u0012\u0004\u0012\u00028\u00000'2\b\u0012\u0004\u0012\u00028\u00000\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b#\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/StateFlowSlot;", "allocateSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "slot", "freeSlot", "(Lkotlinx/coroutines/flow/StateFlowSlot;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;I)Lkotlinx/coroutines/flow/internal/FusibleFlow;", "nSlots", "I", "nextIndex", "sequence", "", "slots", "[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "value$annotations", "()V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/flow/MutableStateFlow;"}, k = 1, mv = {1, 1, 16})
/* compiled from: StateFlow.kt */
public final class StateFlowImpl<T> implements MutableStateFlow<T>, FusibleFlow<T> {
    private volatile Object _state;
    private int nSlots;
    private int nextIndex;
    private int sequence;
    private StateFlowSlot[] slots = new StateFlowSlot[2];

    public static /* synthetic */ void value$annotations() {
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        r1 = r0.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r2 >= r1) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r3 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r3 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r3.makePending();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = r5.sequence;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r0 != r6) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r5.sequence = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        r6 = r5.slots;
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r0 = r6;
        r6 = r0;
     */
    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        synchronized (this) {
            if (!Intrinsics.areEqual(this._state, t)) {
                this._state = t;
                int i = this.sequence;
                if ((i & 1) == 0) {
                    int i2 = i + 1;
                    this.sequence = i2;
                    StateFlowSlot[] stateFlowSlotArr = this.slots;
                    Unit unit = Unit.INSTANCE;
                } else {
                    this.sequence = i + 2;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object coroutine_suspended;
        int i;
        Object obj;
        StateFlowImpl<T> stateFlowImpl;
        Object obj2;
        StateFlowSlot stateFlowSlot;
        Object obj3;
        FlowCollector<? super T> flowCollector2;
        Object obj4;
        if (continuation instanceof StateFlowImpl$collect$1) {
            stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
            if ((stateFlowImpl$collect$1.label & Integer.MIN_VALUE) != 0) {
                stateFlowImpl$collect$1.label -= Integer.MIN_VALUE;
                Object obj5 = stateFlowImpl$collect$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = stateFlowImpl$collect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj5);
                    stateFlowImpl = this;
                    stateFlowSlot = allocateSlot();
                    obj = null;
                } else if (i == 1) {
                    obj3 = stateFlowImpl$collect$1.L$4;
                    Object obj6 = stateFlowImpl$collect$1.L$3;
                    stateFlowSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                    flowCollector2 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    ResultKt.throwOnFailure(obj5);
                    obj = obj3;
                    flowCollector = flowCollector2;
                    obj2 = obj;
                    if (!stateFlowSlot.takePending()) {
                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$1.L$1 = flowCollector;
                        stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                        stateFlowImpl$collect$1.L$3 = obj;
                        stateFlowImpl$collect$1.L$4 = obj2;
                        stateFlowImpl$collect$1.label = 2;
                        if (stateFlowSlot.awaitPending(stateFlowImpl$collect$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 2) {
                    Object obj7 = stateFlowImpl$collect$1.L$4;
                    Object obj8 = stateFlowImpl$collect$1.L$3;
                    stateFlowSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                    FlowCollector<? super T> flowCollector3 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj5);
                        obj = obj8;
                        flowCollector = flowCollector3;
                    } catch (Throwable th) {
                        stateFlowImpl.freeSlot(stateFlowSlot);
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = stateFlowImpl._state;
                if (obj == null || (!Intrinsics.areEqual(obj2, obj))) {
                    obj4 = obj2 == NullSurrogateKt.NULL ? null : obj2;
                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$1.L$1 = flowCollector;
                    stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                    stateFlowImpl$collect$1.L$3 = obj;
                    stateFlowImpl$collect$1.L$4 = obj2;
                    stateFlowImpl$collect$1.label = 1;
                    if (flowCollector.emit(obj4, stateFlowImpl$collect$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector;
                    obj3 = obj2;
                    obj = obj3;
                    flowCollector = flowCollector2;
                    obj2 = obj;
                    return coroutine_suspended;
                }
                if (!stateFlowSlot.takePending()) {
                }
                obj2 = stateFlowImpl._state;
                if (obj2 == NullSurrogateKt.NULL) {
                }
                stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                stateFlowImpl$collect$1.L$1 = flowCollector;
                stateFlowImpl$collect$1.L$2 = stateFlowSlot;
                stateFlowImpl$collect$1.L$3 = obj;
                stateFlowImpl$collect$1.L$4 = obj2;
                stateFlowImpl$collect$1.label = 1;
                if (flowCollector.emit(obj4, stateFlowImpl$collect$1) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj52 = stateFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = stateFlowImpl$collect$1.label;
        if (i != 0) {
        }
        obj2 = stateFlowImpl._state;
        if (obj2 == NullSurrogateKt.NULL) {
        }
        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
        stateFlowImpl$collect$1.L$1 = flowCollector;
        stateFlowImpl$collect$1.L$2 = stateFlowSlot;
        stateFlowImpl$collect$1.L$3 = obj;
        stateFlowImpl$collect$1.L$4 = obj2;
        stateFlowImpl$collect$1.label = 1;
        if (flowCollector.emit(obj4, stateFlowImpl$collect$1) == coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public FusibleFlow<T> fuse(CoroutineContext coroutineContext, int i) {
        if (i == -1 || i == 0) {
            return this;
        }
        return new ChannelFlowOperatorImpl(this, coroutineContext, i);
    }

    private final StateFlowSlot allocateSlot() {
        StateFlowSlot stateFlowSlot;
        synchronized (this) {
            StateFlowSlot[] stateFlowSlotArr = this.slots;
            int length = stateFlowSlotArr.length;
            if (this.nSlots >= length) {
                Object[] copyOf = Arrays.copyOf(stateFlowSlotArr, length * 2);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.slots = (StateFlowSlot[]) copyOf;
            }
            int i = this.nextIndex;
            do {
                stateFlowSlot = this.slots[i];
                if (stateFlowSlot == null) {
                    stateFlowSlot = new StateFlowSlot();
                    this.slots[i] = stateFlowSlot;
                }
                i++;
                if (i >= this.slots.length) {
                    i = 0;
                }
            } while (!stateFlowSlot.allocate());
            this.nextIndex = i;
            this.nSlots++;
        }
        return stateFlowSlot;
    }

    private final void freeSlot(StateFlowSlot stateFlowSlot) {
        synchronized (this) {
            stateFlowSlot.free();
            this.nSlots--;
            Unit unit = Unit.INSTANCE;
        }
    }
}
