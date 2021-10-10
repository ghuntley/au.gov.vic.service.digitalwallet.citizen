package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.Asset;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "Lcom/digitalwallet/app/model/Asset;", "apply", "(Ljava/lang/Integer;Lcom/digitalwallet/app/model/Asset;)Ljava/lang/Integer;"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$downloadAssets$4<T1, T2, R> implements BiFunction<Integer, Asset, Integer> {
    public static final HoldingsService$downloadAssets$4 INSTANCE = new HoldingsService$downloadAssets$4();

    HoldingsService$downloadAssets$4() {
    }

    public final Integer apply(Integer num, Asset asset) {
        Intrinsics.checkNotNullParameter(num, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(asset, "<anonymous parameter 1>");
        return 0;
    }
}
