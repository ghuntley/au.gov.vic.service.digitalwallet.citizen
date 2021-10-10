package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

public final /* synthetic */ class FlowKt__ContextKt {
    public static /* synthetic */ Flow buffer$default(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        return FlowKt.buffer(flow, i);
    }

    public static final <T> Flow<T> buffer(Flow<? extends T> flow, int i) {
        if (!(i >= 0 || i == -2 || i == -1)) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        } else if (flow instanceof FusibleFlow) {
            return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, null, i, 1, null);
        } else {
            return new ChannelFlowOperatorImpl(flow, null, i, 2, null);
        }
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> flow) {
        return FlowKt.buffer(flow, -1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> flowOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        if (Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            return flow;
        }
        if (flow instanceof FusibleFlow) {
            return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, coroutineContext, 0, 2, null);
        }
        return new ChannelFlowOperatorImpl(flow, coroutineContext, 0, 4, null);
    }

    public static /* synthetic */ Flow flowWith$default(Flow flow, CoroutineContext coroutineContext, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -2;
        }
        return FlowKt.flowWith(flow, coroutineContext, i, function1);
    }

    public static final <T, R> Flow<R> flowWith(Flow<? extends T> flow, CoroutineContext coroutineContext, int i, Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        return new FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1(flow, i, function1, coroutineContext);
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        if (!(coroutineContext.get(Job.Key) == null)) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + coroutineContext).toString());
        }
    }
}
