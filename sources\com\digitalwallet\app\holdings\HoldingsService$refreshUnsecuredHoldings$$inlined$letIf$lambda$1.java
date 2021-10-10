package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.utilities.AnalyticsHelper;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", "error", "", "apply", "com/digitalwallet/app/holdings/HoldingsService$refreshUnsecuredHoldings$4$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshUnsecuredHoldings$$inlined$letIf$lambda$1<T, R> implements Function<Throwable, SingleSource<? extends List<? extends UnsecuredHolding>>> {
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$refreshUnsecuredHoldings$$inlined$letIf$lambda$1(HoldingsService holdingsService) {
        this.this$0 = holdingsService;
    }

    public final SingleSource<? extends List<UnsecuredHolding>> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        AnalyticsHelper analyticsHelper = this.this$0.analytics;
        String message = th.getMessage();
        if (message == null) {
            message = th.toString();
        }
        analyticsHelper.diagnosisLog("Error fetchUnsecuredHoldings", message);
        return this.this$0.dbService.getUnsecuredHoldings();
    }
}
