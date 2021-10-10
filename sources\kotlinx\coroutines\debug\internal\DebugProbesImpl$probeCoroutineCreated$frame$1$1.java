package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/debug/internal/DebugProbesImpl$probeCoroutineCreated$frame$1$1", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl$probeCoroutineCreated$frame$1$1 implements CoroutineStackFrame {
    final /* synthetic */ CoroutineStackFrame $acc;
    final /* synthetic */ StackTraceElement $frame;
    private final CoroutineStackFrame callerFrame;

    DebugProbesImpl$probeCoroutineCreated$frame$1$1(StackTraceElement stackTraceElement, CoroutineStackFrame coroutineStackFrame) {
        this.$frame = stackTraceElement;
        this.$acc = coroutineStackFrame;
        this.callerFrame = coroutineStackFrame;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        return this.callerFrame;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return this.$frame;
    }
}
