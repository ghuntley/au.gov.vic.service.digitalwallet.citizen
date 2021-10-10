package com.digitalwallet.app.viewmodel.main;

import androidx.databinding.ObservableField;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/MainPagerFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "authUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "digitalWalletDb", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "handshakeService", "Lcom/digitalwallet/app/services/HandshakeService;", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;Lcom/digitalwallet/app/services/HandshakeService;)V", MessageBundle.TITLE_ENTRY, "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getTitle", "()Landroidx/databinding/ObservableField;", "logout", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: MainPagerFragmentViewModel.kt */
public final class MainPagerFragmentViewModel extends BaseViewModel {
    private final AuthenticationUtility authUtility;
    private final DigitalWalletDatabase digitalWalletDb;
    private final HandshakeService handshakeService;
    private final HoldingsService holdingsService;
    private final ObservableField<String> title = new ObservableField<>("");

    @Inject
    public MainPagerFragmentViewModel(AuthenticationUtility authenticationUtility, HoldingsService holdingsService2, DigitalWalletDatabase digitalWalletDatabase, HandshakeService handshakeService2) {
        Intrinsics.checkNotNullParameter(authenticationUtility, "authUtility");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "digitalWalletDb");
        Intrinsics.checkNotNullParameter(handshakeService2, "handshakeService");
        this.authUtility = authenticationUtility;
        this.holdingsService = holdingsService2;
        this.digitalWalletDb = digitalWalletDatabase;
        this.handshakeService = handshakeService2;
    }

    public final ObservableField<String> getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void logout() {
        CompositeDisposable compositeDisposable = getCompositeDisposable();
        Completable subscribeOn = Completable.fromCallable(new MainPagerFragmentViewModel$logout$1(this)).subscribeOn(Schedulers.io());
        MainPagerFragmentViewModel$logout$2 mainPagerFragmentViewModel$logout$2 = MainPagerFragmentViewModel$logout$2.INSTANCE;
        if (mainPagerFragmentViewModel$logout$2 != null) {
            mainPagerFragmentViewModel$logout$2 = new MainPagerFragmentViewModel$sam$io_reactivex_functions_Consumer$0(mainPagerFragmentViewModel$logout$2);
        }
        compositeDisposable.add(subscribeOn.doOnError((Consumer) mainPagerFragmentViewModel$logout$2).andThen(this.holdingsService.deleteHoldingExpiryNotifications()).andThen(Completable.fromCallable(new MainPagerFragmentViewModel$sam$java_util_concurrent_Callable$0(new MainPagerFragmentViewModel$logout$3(this.digitalWalletDb)))).andThen(Completable.fromCallable(new MainPagerFragmentViewModel$logout$4(this))).subscribe());
    }
}
