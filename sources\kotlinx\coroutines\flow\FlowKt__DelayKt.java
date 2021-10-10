package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

public final /* synthetic */ class FlowKt__DelayKt {
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, long j) {
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounce$2(flow, j, null));
        }
        throw new IllegalArgumentException("Debounce timeout should be positive".toString());
    }

    /* renamed from: debounce-8GFy2Ro */
    public static final <T> Flow<T> m1357debounce8GFy2Ro(Flow<? extends T> flow, double d) {
        return FlowKt.debounce(flow, DelayKt.m1340toDelayMillisLRDsOJo(d));
    }

    public static final <T> Flow<T> sample(Flow<? extends T> flow, long j) {
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$sample$2(flow, j, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope coroutineScope, long j, long j2) {
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce$default(coroutineScope, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j2, j, null), 1, null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* renamed from: sample-8GFy2Ro */
    public static final <T> Flow<T> m1358sample8GFy2Ro(Flow<? extends T> flow, double d) {
        return FlowKt.sample(flow, DelayKt.m1340toDelayMillisLRDsOJo(d));
    }
}
