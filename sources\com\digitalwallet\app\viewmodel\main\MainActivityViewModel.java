package com.digitalwallet.app.viewmodel.main;

import androidx.databinding.ObservableField;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.model.RemoteConfig;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/MainActivityViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "remoteConfigService", "Lcom/digitalwallet/services/RemoteConfigService;", "(Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/digitalwallet/services/RemoteConfigService;)V", "remoteConfig", "Landroidx/databinding/ObservableField;", "Lcom/digitalwallet/model/RemoteConfig;", "getRemoteConfig", "()Landroidx/databinding/ObservableField;", "refreshData", "", "activeNotifiedLink", "", "refreshNotifications", "Lio/reactivex/Completable;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MainActivityViewModel.kt */
public final class MainActivityViewModel extends BaseViewModel {
    private final HoldingsService holdingsService;
    private final ObservableField<RemoteConfig> remoteConfig = new ObservableField<>();
    private final RemoteConfigService remoteConfigService;

    @Inject
    public MainActivityViewModel(HoldingsService holdingsService2, RemoteConfigService remoteConfigService2) {
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(remoteConfigService2, "remoteConfigService");
        this.holdingsService = holdingsService2;
        this.remoteConfigService = remoteConfigService2;
    }

    public final ObservableField<RemoteConfig> getRemoteConfig() {
        return this.remoteConfig;
    }

    public static /* synthetic */ void refreshData$default(MainActivityViewModel mainActivityViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        mainActivityViewModel.refreshData(str);
    }

    public final void refreshData(String str) {
        getCompositeDisposable().add(refreshNotifications(str).subscribe());
        if (ServerTypeKt.getAppType() == AppType.CITIZEN) {
            getCompositeDisposable().add(this.remoteConfigService.getRemoteConfig().subscribe(new MainActivityViewModel$refreshData$2(this)));
        }
    }

    private final Completable refreshNotifications(String str) {
        Completable flatMapCompletable = HoldingsService.refreshUnsecuredHoldings$default(this.holdingsService, false, false, 3, null).subscribeOn(Schedulers.io()).map(new MainActivityViewModel$refreshNotifications$1(str)).flatMapCompletable(new MainActivityViewModel$sam$io_reactivex_functions_Function$0(new MainActivityViewModel$refreshNotifications$2(this.holdingsService)));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "holdingsService.refreshU…ldingExpiryNotifications)");
        return flatMapCompletable;
    }
}
