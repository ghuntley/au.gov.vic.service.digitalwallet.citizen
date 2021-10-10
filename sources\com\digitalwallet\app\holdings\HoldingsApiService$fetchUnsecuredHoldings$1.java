package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.UnsecuredHoldingSet;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", "holdingSet", "Lcom/digitalwallet/app/model/UnsecuredHoldingSet;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final class HoldingsApiService$fetchUnsecuredHoldings$1<T, R> implements Function<UnsecuredHoldingSet, List<? extends UnsecuredHolding>> {
    public static final HoldingsApiService$fetchUnsecuredHoldings$1 INSTANCE = new HoldingsApiService$fetchUnsecuredHoldings$1();

    HoldingsApiService$fetchUnsecuredHoldings$1() {
    }

    public final List<UnsecuredHolding> apply(UnsecuredHoldingSet unsecuredHoldingSet) {
        Intrinsics.checkNotNullParameter(unsecuredHoldingSet, "holdingSet");
        ArrayList arrayList = new ArrayList();
        for (T t : unsecuredHoldingSet.getRecords()) {
            if (t.isValid()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
