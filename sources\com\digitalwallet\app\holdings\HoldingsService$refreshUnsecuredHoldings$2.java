package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", "allUnsecured", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshUnsecuredHoldings$2<T, R> implements Function<List<? extends UnsecuredHolding>, List<? extends UnsecuredHolding>> {
    public static final HoldingsService$refreshUnsecuredHoldings$2 INSTANCE = new HoldingsService$refreshUnsecuredHoldings$2();

    HoldingsService$refreshUnsecuredHoldings$2() {
    }

    public final List<UnsecuredHolding> apply(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "allUnsecured");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.getHoldingElements().getSupported()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
