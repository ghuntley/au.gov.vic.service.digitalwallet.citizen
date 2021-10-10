package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "it", "", "apply", "(Ljava/lang/Integer;)Ljava/util/List;"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$downloadAssets$5<T, R> implements Function<Integer, List<? extends SecureHolding>> {
    final /* synthetic */ List $synced;

    HoldingsService$downloadAssets$5(List list) {
        this.$synced = list;
    }

    public final List<SecureHolding> apply(Integer num) {
        Intrinsics.checkNotNullParameter(num, "it");
        return this.$synced;
    }
}
