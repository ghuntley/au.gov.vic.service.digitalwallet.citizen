package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    static final /* synthetic */ <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        Object coroutine_suspended;
        int i;
        ReceiveChannel<? extends T> receiveChannel2;
        boolean z2;
        Throwable th;
        Throwable th2;
        FlowCollector flowCollector2;
        Object r11;
        Throwable r112;
        Throwable th3;
        Object receiveOrClosed;
        FlowCollector<? super T> flowCollector3;
        if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
            flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
            if ((flowKt__ChannelsKt$emitAllImpl$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ChannelsKt$emitAllImpl$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ChannelsKt$emitAllImpl$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ChannelsKt$emitAllImpl$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th3 = null;
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                    flowKt__ChannelsKt$emitAllImpl$1.L$2 = th3;
                    flowKt__ChannelsKt$emitAllImpl$1.L$3 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                    receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAllImpl$1);
                    if (receiveOrClosed == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowCollector2 = flowCollector;
                    th2 = th3;
                    obj = receiveOrClosed;
                    receiveChannel2 = receiveChannel;
                    z2 = z;
                    r11 = ((ValueOrClosed) obj).m1353unboximpl();
                    if (!ValueOrClosed.m1351isClosedimpl(r11)) {
                    }
                    r112 = ValueOrClosed.m1347getCloseCauseimpl(r11);
                    if (r112 != null) {
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    FlowCollector flowCollector4 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$3;
                    th2 = (Throwable) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                    z2 = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                    receiveChannel2 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                    r11 = ((ValueOrClosed) obj).m1353unboximpl();
                    if (!ValueOrClosed.m1351isClosedimpl(r11)) {
                        r112 = ValueOrClosed.m1347getCloseCauseimpl(r11);
                    } else {
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector2;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel2;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z2;
                        flowKt__ChannelsKt$emitAllImpl$1.L$2 = th2;
                        flowKt__ChannelsKt$emitAllImpl$1.L$3 = r11;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                        Object emit = flowCollector2.emit((Object) ValueOrClosed.m1348getValueimpl(r11), flowKt__ChannelsKt$emitAllImpl$1);
                        flowCollector3 = flowCollector2;
                        if (emit == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    r112 = ValueOrClosed.m1347getCloseCauseimpl(r11);
                    if (r112 != null) {
                        if (z2) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        }
                        return Unit.INSTANCE;
                    }
                    throw r112;
                } else if (i == 2) {
                    Object obj2 = flowKt__ChannelsKt$emitAllImpl$1.L$3;
                    th2 = (Throwable) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                    z2 = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                    receiveChannel2 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                    FlowCollector<? super T> flowCollector5 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        flowCollector3 = flowCollector5;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            if (z2) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                            }
                            throw th5;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th3 = th2;
                flowCollector = flowCollector3;
                z = z2;
                receiveChannel = receiveChannel2;
                flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                flowKt__ChannelsKt$emitAllImpl$1.L$2 = th3;
                flowKt__ChannelsKt$emitAllImpl$1.L$3 = flowCollector;
                flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAllImpl$1);
                if (receiveOrClosed == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        Object obj3 = flowKt__ChannelsKt$emitAllImpl$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ChannelsKt$emitAllImpl$1.label;
        if (i != 0) {
        }
        th3 = th2;
        flowCollector = flowCollector3;
        z = z2;
        receiveChannel = receiveChannel2;
        try {
            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
            flowKt__ChannelsKt$emitAllImpl$1.L$2 = th3;
            flowKt__ChannelsKt$emitAllImpl$1.L$3 = flowCollector;
            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
            receiveOrClosed = receiveChannel.receiveOrClosed(flowKt__ChannelsKt$emitAllImpl$1);
            if (receiveOrClosed == coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th6) {
            th = th6;
            receiveChannel2 = receiveChannel;
            z2 = z;
            throw th;
        }
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, 12, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, 12, null);
    }

    public static /* synthetic */ BroadcastChannel broadcastIn$default(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    public static final <T> BroadcastChannel<T> broadcastIn(Flow<? extends T> flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart) {
        return ChannelFlowKt.asChannelFlow(flow).broadcastImpl(coroutineScope, coroutineStart);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    public static final <T> Flow<T> asFlow(BroadcastChannel<T> broadcastChannel) {
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(broadcastChannel);
    }
}
