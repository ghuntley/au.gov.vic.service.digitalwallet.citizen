package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragmentViewModel.kt */
public final class HoldingListFragmentViewModel$requestAllSecureHoldings$1<T, R> implements Function<List<? extends UnsecuredHolding>, SingleSource<? extends List<? extends SecureHolding>>> {
    final /* synthetic */ HoldingListFragmentViewModel this$0;

    HoldingListFragmentViewModel$requestAllSecureHoldings$1(HoldingListFragmentViewModel holdingListFragmentViewModel) {
        this.this$0 = holdingListFragmentViewModel;
    }

    public final SingleSource<? extends List<SecureHolding>> apply(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return HoldingsService.refreshSecureHoldings$default(this.this$0.holdingService, list, false, 2, null);
    }
}
