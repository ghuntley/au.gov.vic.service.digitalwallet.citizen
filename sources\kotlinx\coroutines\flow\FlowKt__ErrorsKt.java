package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

public final /* synthetic */ class FlowKt__ErrorsKt {
    public static /* synthetic */ void ExceptionPredicate$annotations() {
    }

    public static /* synthetic */ Flow onErrorCollect$default(Flow flow, Flow flow2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = FlowKt__ErrorsKt$onErrorCollect$1.INSTANCE;
        }
        return FlowKt.onErrorCollect(flow, flow2, function1);
    }

    public static final <T> Flow<T> onErrorCollect(Flow<? extends T> flow, Flow<? extends T> flow2, Function1<? super Throwable, Boolean> function1) {
        return FlowKt.m1354catch(flow, new FlowKt__ErrorsKt$onErrorCollect$2(function1, flow2, null));
    }

    public static /* synthetic */ Flow retry$default(Flow flow, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            function2 = new FlowKt__ErrorsKt$retry$1(null);
        }
        return FlowKt.retry(flow, j, function2);
    }

    public static final <T> Flow<T> retry(Flow<? extends T> flow, long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        if (j > 0) {
            return FlowKt.retryWhen(flow, new FlowKt__ErrorsKt$retry$3(j, function2, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j).toString());
    }

    public static /* synthetic */ Flow retry$default(Flow flow, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i2 & 2) != 0) {
            function1 = FlowKt__ErrorsKt$retry$4.INSTANCE;
        }
        return retry(flow, i, function1);
    }

    public static final /* synthetic */ <T> Flow<T> retry(Flow<? extends T> flow, int i, Function1<? super Throwable, Boolean> function1) {
        if (i > 0) {
            return FlowKt.retryWhen(flow, new FlowKt__ErrorsKt$retry$6(i, function1, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + i).toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    public static final <T> Object catchImpl(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        int i;
        Throwable th;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuation;
            if ((flowKt__ErrorsKt$catchImpl$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ErrorsKt$catchImpl$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ErrorsKt$catchImpl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = (T) null;
                    try {
                        flowKt__ErrorsKt$catchImpl$1.L$0 = flow;
                        flowKt__ErrorsKt$catchImpl$1.L$1 = flowCollector;
                        flowKt__ErrorsKt$catchImpl$1.L$2 = objectRef2;
                        flowKt__ErrorsKt$catchImpl$1.L$3 = flow;
                        flowKt__ErrorsKt$catchImpl$1.label = 1;
                        if (flow.collect(new FlowKt__ErrorsKt$catchImpl$$inlined$collect$1(flowCollector, objectRef2), flowKt__ErrorsKt$catchImpl$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectRef = objectRef2;
                        if (!isSameExceptionAs$FlowKt__ErrorsKt(th, objectRef.element) && !isCancellationCause$FlowKt__ErrorsKt(th, flowKt__ErrorsKt$catchImpl$1.getContext())) {
                            return th;
                        }
                        throw th;
                    }
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__ErrorsKt$catchImpl$1.L$3;
                    objectRef = (Ref.ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$2;
                    FlowCollector flowCollector2 = (FlowCollector) flowKt__ErrorsKt$catchImpl$1.L$1;
                    Flow flow3 = (Flow) flowKt__ErrorsKt$catchImpl$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            }
        }
        flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
        Object obj2 = flowKt__ErrorsKt$catchImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ErrorsKt$catchImpl$1.label;
        if (i != 0) {
        }
        return null;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable th, CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job == null || !job.isCancelled()) {
            return false;
        }
        return isSameExceptionAs$FlowKt__ErrorsKt(th, job.getCancellationException());
    }

    /* renamed from: catch */
    public static final <T> Flow<T> m1359catch(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, function3);
    }

    public static final <T> Flow<T> retryWhen(Flow<? extends T> flow, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, function4);
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable th, Throwable th2) {
        if (th2 != null) {
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                th2 = StackTraceRecoveryKt.unwrapImpl(th2);
            }
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                th = StackTraceRecoveryKt.unwrapImpl(th);
            }
            if (Intrinsics.areEqual(th2, th)) {
                return true;
            }
        }
        return false;
    }
}
