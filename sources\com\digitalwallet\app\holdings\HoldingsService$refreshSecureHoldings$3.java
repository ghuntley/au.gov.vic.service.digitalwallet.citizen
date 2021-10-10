package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshSecureHoldings$3<T, R> implements Function<Pair<? extends List<? extends SecureHolding>, ? extends List<? extends SecureHolding>>, SingleSource<? extends List<? extends SecureHolding>>> {
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$refreshSecureHoldings$3(HoldingsService holdingsService) {
        this.this$0 = holdingsService;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ SingleSource<? extends List<? extends SecureHolding>> apply(Pair<? extends List<? extends SecureHolding>, ? extends List<? extends SecureHolding>> pair) {
        return apply((Pair<? extends List<SecureHolding>, ? extends List<SecureHolding>>) pair);
    }

    public final SingleSource<? extends List<SecureHolding>> apply(Pair<? extends List<SecureHolding>, ? extends List<SecureHolding>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return this.this$0.downloadAssets((List) pair.component1(), (List) pair.component2());
    }
}
