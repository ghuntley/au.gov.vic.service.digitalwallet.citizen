package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

public final /* synthetic */ class FlowKt__MigrationKt {
    public static final Void noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    public static final <T> Flow<T> observeOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> publishOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> subscribeOn(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> onErrorResume(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> onErrorResumeNext(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> void subscribe(Flow<? extends T> flow) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> void subscribe(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> void subscribe(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function22) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T, R> Flow<R> flatMap(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T, R> Flow<R> concatMap(Flow<? extends T> flow, Function1<? super T, ? extends Flow<? extends R>> function1) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> merge(Flow<? extends Flow<? extends T>> flow) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> flatten(Flow<? extends Flow<? extends T>> flow) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T, R> Flow<R> compose(Flow<? extends T> flow, Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> skip(Flow<? extends T> flow, int i) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> void forEach(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T, R> Flow<R> scanFold(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t) {
        FlowKt.noImpl();
        throw null;
    }

    public static /* synthetic */ Flow onErrorReturn$default(Flow flow, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = FlowKt__MigrationKt$onErrorReturn$1.INSTANCE;
        }
        return FlowKt.onErrorReturn(flow, obj, function1);
    }

    public static final <T> Flow<T> onErrorReturn(Flow<? extends T> flow, T t, Function1<? super Throwable, Boolean> function1) {
        return FlowKt.m1354catch(flow, new FlowKt__MigrationKt$onErrorReturn$2(function1, t, null));
    }

    public static final <T> Flow<T> startWith(Flow<? extends T> flow, T t) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> startWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, T t) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T> Flow<T> concatWith(Flow<? extends T> flow, Flow<? extends T> flow2) {
        FlowKt.noImpl();
        throw null;
    }

    public static final <T1, T2, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt.combine(flow, flow2, function3);
    }

    public static final <T> Flow<T> delayFlow(Flow<? extends T> flow, long j) {
        return FlowKt.onStart(flow, new FlowKt__MigrationKt$delayFlow$1(j, null));
    }

    public static final <T> Flow<T> delayEach(Flow<? extends T> flow, long j) {
        return FlowKt.onEach(flow, new FlowKt__MigrationKt$delayEach$1(j, null));
    }

    public static final <T1, T2, T3, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$1(new Flow[]{flow, flow2, flow3}, function4);
    }

    public static final <T1, T2, T3, T4, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$2(new Flow[]{flow, flow2, flow3, flow4}, function5);
    }

    public static final <T1, T2, T3, T4, T5, R> Flow<R> combineLatest(Flow<? extends T1> flow, Flow<? extends T2> flow2, Flow<? extends T3> flow3, Flow<? extends T4> flow4, Flow<? extends T5> flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return new FlowKt__MigrationKt$combineLatest$$inlined$combine$3(new Flow[]{flow, flow2, flow3, flow4, flow5}, function6);
    }

    public static final <T, R> Flow<R> switchMap(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }
}
