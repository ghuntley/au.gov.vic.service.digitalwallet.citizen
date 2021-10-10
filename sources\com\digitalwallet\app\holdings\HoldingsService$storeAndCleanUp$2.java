package com.digitalwallet.app.holdings;

import androidx.core.app.NotificationCompat;
import com.digitalwallet.app.model.SecureHolding;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$storeAndCleanUp$2<V> implements Callable<List<? extends SecureHolding>> {
    final /* synthetic */ List $securedHoldings;

    HoldingsService$storeAndCleanUp$2(List list) {
        this.$securedHoldings = list;
    }

    /* Return type fixed from 'java.util.List<com.digitalwallet.app.model.SecureHolding>' to match base method */
    @Override // java.util.concurrent.Callable
    public final List<? extends SecureHolding> call() {
        return this.$securedHoldings;
    }
}
