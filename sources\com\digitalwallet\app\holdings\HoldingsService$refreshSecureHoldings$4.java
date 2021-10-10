package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "securedHoldings", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshSecureHoldings$4<T, R> implements Function<List<? extends SecureHolding>, SingleSource<? extends List<? extends SecureHolding>>> {
    final /* synthetic */ List $filteredHoldings;
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$refreshSecureHoldings$4(HoldingsService holdingsService, List list) {
        this.this$0 = holdingsService;
        this.$filteredHoldings = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ SingleSource<? extends List<? extends SecureHolding>> apply(List<? extends SecureHolding> list) {
        return apply((List<SecureHolding>) list);
    }

    public final SingleSource<? extends List<SecureHolding>> apply(List<SecureHolding> list) {
        Intrinsics.checkNotNullParameter(list, "securedHoldings");
        return this.this$0.storeAndCleanUp(list, this.$filteredHoldings);
    }
}
