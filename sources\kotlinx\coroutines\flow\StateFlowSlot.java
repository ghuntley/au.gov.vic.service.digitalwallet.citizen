package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0002\u0018\u00002\u00020\rB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0002J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0002J\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "", "allocate", "()Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "free", "makePending", "takePending", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 1, 16})
/* compiled from: StateFlow.kt */
public final class StateFlowSlot {
    static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    volatile Object _state = null;

    public final boolean allocate() {
        if (this._state != null) {
            return false;
        }
        this._state = StateFlowKt.access$getNONE$p();
        return true;
    }

    public final void free() {
        this._state = null;
    }

    public final boolean takePending() {
        Object andSet = _state$FU.getAndSet(this, StateFlowKt.access$getNONE$p());
        if (andSet == null) {
            Intrinsics.throwNpe();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(andSet instanceof CancellableContinuationImpl))) {
            throw new AssertionError();
        } else if (andSet == StateFlowKt.access$getPENDING$p()) {
            return true;
        } else {
            return false;
        }
    }

    public final void makePending() {
        while (true) {
            Object obj = this._state;
            if (obj != null && obj != StateFlowKt.access$getPENDING$p()) {
                if (obj == StateFlowKt.access$getNONE$p()) {
                    if (_state$FU.compareAndSet(this, obj, StateFlowKt.access$getPENDING$p())) {
                        return;
                    }
                } else if (_state$FU.compareAndSet(this, obj, StateFlowKt.access$getNONE$p())) {
                    Unit unit = Unit.INSTANCE;
                    Result.Companion companion = Result.Companion;
                    ((CancellableContinuationImpl) obj).resumeWith(Result.m12constructorimpl(unit));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Object awaitPending(Continuation<? super Unit> continuation) {
        boolean z = true;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (!DebugKt.getASSERTIONS_ENABLED() || Boxing.boxBoolean(!(this._state instanceof CancellableContinuationImpl)).booleanValue()) {
            if (!_state$FU.compareAndSet(this, StateFlowKt.access$getNONE$p(), cancellableContinuationImpl2)) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (this._state != StateFlowKt.access$getPENDING$p()) {
                        z = false;
                    }
                    if (!Boxing.boxBoolean(z).booleanValue()) {
                        throw new AssertionError();
                    }
                }
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m12constructorimpl(unit));
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        throw new AssertionError();
    }
}
