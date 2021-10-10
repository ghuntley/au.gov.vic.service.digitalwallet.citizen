package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.Asset;
import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "holdings", "", "Lcom/digitalwallet/app/model/SecureHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$cleanUpAssets$1<T, R> implements Function<List<? extends SecureHolding>, Unit> {
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$cleanUpAssets$1(HoldingsService holdingsService) {
        this.this$0 = holdingsService;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Unit apply(List<? extends SecureHolding> list) {
        apply((List<SecureHolding>) list);
        return Unit.INSTANCE;
    }

    public final void apply(List<SecureHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<Asset> assets = it.next().getAssets();
            if (assets != null) {
                arrayList.addAll(assets);
            }
        }
        this.this$0.assetService.cleanUp(arrayList);
    }
}
