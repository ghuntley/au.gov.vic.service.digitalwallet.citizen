package com.digitalwallet.app.holdings;

import com.squareup.moshi.Moshi;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "list", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: TestHoldings.kt */
public final class TestHolding$mockIf$1 extends Lambda implements Function1<List<? extends T>, List<? extends T>> {
    final /* synthetic */ boolean $filter;
    final /* synthetic */ Moshi $moshi;
    final /* synthetic */ TestHolding this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestHolding$mockIf$1(TestHolding testHolding, boolean z, Moshi moshi) {
        super(1);
        this.this$0 = testHolding;
        this.$filter = z;
        this.$moshi = moshi;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<T> invoke(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (!this.$filter) {
            return list;
        }
        Object fromJson = this.$moshi.adapter(this.this$0.getClazz()).fromJson(this.this$0.getJson());
        Intrinsics.checkNotNull(fromJson);
        return CollectionsKt.plus((Collection) list, fromJson);
    }
}
