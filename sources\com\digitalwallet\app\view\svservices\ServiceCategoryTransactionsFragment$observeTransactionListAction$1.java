package com.digitalwallet.app.view.svservices;

import com.digitalwallet.app.model.login.SVTransaction;
import com.digitalwallet.app.view.login.HomeServicesFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/SVTransaction;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: ServiceCategoryTransactionsFragment.kt */
public final class ServiceCategoryTransactionsFragment$observeTransactionListAction$1 extends Lambda implements Function1<SVTransaction, Unit> {
    final /* synthetic */ HomeServicesFragment $homeServicesFragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceCategoryTransactionsFragment$observeTransactionListAction$1(HomeServicesFragment homeServicesFragment) {
        super(1);
        this.$homeServicesFragment = homeServicesFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SVTransaction sVTransaction) {
        invoke(sVTransaction);
        return Unit.INSTANCE;
    }

    public final void invoke(SVTransaction sVTransaction) {
        Intrinsics.checkNotNullParameter(sVTransaction, "it");
        HomeServicesFragment homeServicesFragment = this.$homeServicesFragment;
        if (homeServicesFragment != null) {
            homeServicesFragment.startChrome(sVTransaction.getUrl(), sVTransaction.getId());
        }
    }
}
