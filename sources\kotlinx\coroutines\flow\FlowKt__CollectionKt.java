package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

public final /* synthetic */ class FlowKt__CollectionKt {
    public static final <T> Object toList(Flow<? extends T> flow, List<T> list, Continuation<? super List<? extends T>> continuation) {
        return FlowKt.toCollection(flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow, list, continuation);
    }

    public static final <T> Object toSet(Flow<? extends T> flow, Set<T> set, Continuation<? super Set<? extends T>> continuation) {
        return FlowKt.toCollection(flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, set, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> flow, C c, Continuation<? super C> continuation) {
        FlowKt__CollectionKt$toCollection$1 flowKt__CollectionKt$toCollection$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$toCollection$1) {
            flowKt__CollectionKt$toCollection$1 = (FlowKt__CollectionKt$toCollection$1) continuation;
            if ((flowKt__CollectionKt$toCollection$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$toCollection$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$toCollection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$toCollection$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$toCollection$1.L$0 = flow;
                    flowKt__CollectionKt$toCollection$1.L$1 = c;
                    flowKt__CollectionKt$toCollection$1.L$2 = flow;
                    flowKt__CollectionKt$toCollection$1.label = 1;
                    return flow.collect(new FlowKt__CollectionKt$toCollection$$inlined$collect$1(c), flowKt__CollectionKt$toCollection$1) == coroutine_suspended ? coroutine_suspended : c;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__CollectionKt$toCollection$1.L$2;
                    Collection collection = (Collection) flowKt__CollectionKt$toCollection$1.L$1;
                    Flow flow3 = (Flow) flowKt__CollectionKt$toCollection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return collection;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$toCollection$1 = new FlowKt__CollectionKt$toCollection$1(continuation);
        Object obj2 = flowKt__CollectionKt$toCollection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$toCollection$1.label;
        if (i != 0) {
        }
    }
}
