package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.Completable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: MainActivityViewModel.kt */
public final /* synthetic */ class MainActivityViewModel$refreshNotifications$2 extends FunctionReferenceImpl implements Function1<List<? extends UnsecuredHolding>, Completable> {
    MainActivityViewModel$refreshNotifications$2(HoldingsService holdingsService) {
        super(1, holdingsService, HoldingsService.class, "scheduleHoldingExpiryNotifications", "scheduleHoldingExpiryNotifications(Ljava/util/List;)Lio/reactivex/Completable;", 0);
    }

    public final Completable invoke(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "p1");
        return ((HoldingsService) this.receiver).scheduleHoldingExpiryNotifications(list);
    }
}
