package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
/* compiled from: Distinct.kt */
public final class FlowKt__DistinctKt$distinctUntilChanged$1 extends Lambda implements Function1<T, T> {
    public static final FlowKt__DistinctKt$distinctUntilChanged$1 INSTANCE = new FlowKt__DistinctKt$distinctUntilChanged$1();

    FlowKt__DistinctKt$distinctUntilChanged$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        return t;
    }
}
