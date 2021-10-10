package com.digitalwallet.app.holdings;

import com.squareup.moshi.Moshi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "list", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: TestHoldingTemlates.kt */
public final class TestHoldingTemlatesKt$mockAllTestTemplatesIf$1 extends Lambda implements Function1<List<? extends T>, List<? extends T>> {
    final /* synthetic */ boolean $flag;
    final /* synthetic */ Moshi $moshi;
    final /* synthetic */ List $templates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestHoldingTemlatesKt$mockAllTestTemplatesIf$1(List list, boolean z, Moshi moshi) {
        super(1);
        this.$templates = list;
        this.$flag = z;
        this.$moshi = moshi;
    }

    public final List<T> invoke(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        for (TestHolding testHolding : this.$templates) {
            list = (List<T>) ((List) testHolding.mockIf(this.$flag, this.$moshi).invoke(list));
        }
        return (List<T>) list;
    }
}
