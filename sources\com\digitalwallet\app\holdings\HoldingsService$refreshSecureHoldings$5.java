package com.digitalwallet.app.holdings;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import retrofit2.HttpException;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshSecureHoldings$5<T> implements Consumer<Throwable> {
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$refreshSecureHoldings$5(HoldingsService holdingsService) {
        this.this$0 = holdingsService;
    }

    public final void accept(Throwable th) {
        HttpException httpException = (HttpException) (!(th instanceof HttpException) ? null : th);
        if (httpException != null) {
            Timber.e(httpException.code() + ' ' + httpException.getMessage() + ' ' + httpException.response(), new Object[0]);
            if (httpException != null) {
                return;
            }
        }
        Timber.e(th);
        Unit unit = Unit.INSTANCE;
    }
}
