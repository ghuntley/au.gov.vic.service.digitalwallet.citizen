package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.HoldingSet;
import com.digitalwallet.utilities.ServerType;
import com.digitalwallet.utilities.ServerTypeKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/app/model/HoldingSet;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final class HoldingsApiService$fetchSecureHoldings$2<T, R> implements Function<Throwable, SingleSource<? extends HoldingSet>> {
    public static final HoldingsApiService$fetchSecureHoldings$2 INSTANCE = new HoldingsApiService$fetchSecureHoldings$2();

    HoldingsApiService$fetchSecureHoldings$2() {
    }

    public final SingleSource<? extends HoldingSet> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HttpException httpException = (HttpException) (!(th instanceof HttpException) ? null : th);
        if (httpException != null && httpException.code() == 404) {
            if (SetsKt.setOf((Object[]) new ServerType[]{ServerType.QA, ServerType.DEV}).contains(ServerTypeKt.getServerType())) {
                return Single.just(new HoldingSet(0, null, 3, null));
            }
        }
        throw th;
    }
}
