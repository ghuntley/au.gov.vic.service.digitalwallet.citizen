package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

public final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> Flow<T> filter(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(flow, function2);
    }

    public static final <T> Flow<T> filterNot(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(flow, function2);
    }

    public static final <T> Flow<T> filterNotNull(Flow<? extends T> flow) {
        return new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(flow);
    }

    public static final <T, R> Flow<R> map(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(flow, function2);
    }

    public static final <T, R> Flow<R> mapNotNull(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(flow, function2);
    }

    public static final <T> Flow<IndexedValue<T>> withIndex(Flow<? extends T> flow) {
        return new FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1(flow);
    }

    public static final <T> Flow<T> onEach(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(flow, function2);
    }

    public static final <T, R> Flow<R> scan(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(flow, r, function3);
    }

    public static final <T> Flow<T> scanReduce(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return new FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1(flow, function3);
    }
}
