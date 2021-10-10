package com.digitalwallet.app.viewmodel.splash;

import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.model.Tokens;
import com.digitalwallet.app.view.splash.SplashView;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000eJ\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\n  *\u0004\u0018\u00010\u001e0\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/viewmodel/splash/SplashViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "authUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "authService", "Lcom/digitalwallet/app/oidc/AuthenticationService;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "digitalWalletDb", "Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/app/oidc/AuthenticationService;Lcom/digitalwallet/app/holdings/HoldingsService;Lcom/digitalwallet/app/model/db/DigitalWalletDatabase;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "splashView", "Lcom/digitalwallet/app/view/splash/SplashView;", "tokensExpired", "Landroidx/lifecycle/MutableLiveData;", "", "getTokensExpired", "()Landroidx/lifecycle/MutableLiveData;", "handleError", "", "error", "", "inject", Promotion.ACTION_VIEW, "logout", "printError", "it", "refresh", "Lio/reactivex/Completable;", "viewOnDelay", "kotlin.jvm.PlatformType", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: SplashViewModel.kt */
public final class SplashViewModel extends BaseViewModel {
    private final AnalyticsHelper analytics;
    private final AuthenticationService authService;
    private final AuthenticationUtility authUtility;
    private final DigitalWalletDatabase digitalWalletDb;
    private final HoldingsService holdingsService;
    private SplashView splashView;
    private final MutableLiveData<Boolean> tokensExpired = new MutableLiveData<>();

    public static final /* synthetic */ SplashView access$getSplashView$p(SplashViewModel splashViewModel) {
        SplashView splashView2 = splashViewModel.splashView;
        if (splashView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashView");
        }
        return splashView2;
    }

    @Inject
    public SplashViewModel(AuthenticationUtility authenticationUtility, AuthenticationService authenticationService, HoldingsService holdingsService2, DigitalWalletDatabase digitalWalletDatabase, AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(authenticationUtility, "authUtility");
        Intrinsics.checkNotNullParameter(authenticationService, "authService");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(digitalWalletDatabase, "digitalWalletDb");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.authUtility = authenticationUtility;
        this.authService = authenticationService;
        this.holdingsService = holdingsService2;
        this.digitalWalletDb = digitalWalletDatabase;
        this.analytics = analyticsHelper;
    }

    public final MutableLiveData<Boolean> getTokensExpired() {
        return this.tokensExpired;
    }

    public final void inject(SplashView splashView2) {
        Intrinsics.checkNotNullParameter(splashView2, Promotion.ACTION_VIEW);
        this.splashView = splashView2;
        SplashViewModel splashViewModel = this;
        getCompositeDisposable().add(Completable.mergeDelayError(CollectionsKt.listOf((Object[]) new Completable[]{refresh(), viewOnDelay()})).observeOn(AndroidSchedulers.mainThread()).doOnError(new SplashViewModel$sam$io_reactivex_functions_Consumer$0(new SplashViewModel$inject$1(splashViewModel))).subscribe(new SplashViewModel$inject$2(this), new SplashViewModel$sam$io_reactivex_functions_Consumer$0(new SplashViewModel$inject$3(splashViewModel))));
    }

    private final Completable viewOnDelay() {
        return Completable.timer(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).andThen(SplashViewModel$viewOnDelay$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void handleError(Throwable th) {
        int code;
        boolean z = false;
        boolean z2 = ServerTypeKt.getAppType() == AppType.CITIZEN && this.authUtility.getFirstTime();
        if (th instanceof HttpException) {
            HttpException httpException = (HttpException) th;
            if (httpException.code() == 400 || (500 <= (code = httpException.code()) && 599 >= code)) {
                if (httpException.code() != 400) {
                    AnalyticsHelper analyticsHelper = this.analytics;
                    String message = th.getMessage();
                    if (message == null) {
                        message = th.toString();
                    }
                    analyticsHelper.diagnosisLog("SplashViewModel refresh error", message);
                }
                logout();
                this.tokensExpired.setValue(true);
                return;
            }
        }
        if (th instanceof PinNotSetException) {
            SplashView splashView2 = this.splashView;
            if (splashView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashView");
            }
            splashView2.navigateToPin();
        } else if (this.authUtility.getUserPin() != null) {
            SplashView splashView3 = this.splashView;
            if (splashView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashView");
            }
            splashView3.navigateToPin();
        } else if (z2) {
            SplashView splashView4 = this.splashView;
            if (splashView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("splashView");
            }
            splashView4.navigateToOnboarding();
        } else {
            MutableLiveData<Boolean> mutableLiveData = this.tokensExpired;
            Tokens tokens = this.authUtility.getTokens();
            if (tokens != null) {
                z = tokens.haveExpired();
            }
            mutableLiveData.setValue(Boolean.valueOf(z));
        }
    }

    private final Completable refresh() {
        Completable doOnError;
        Tokens tokens = this.authUtility.getTokens();
        if (tokens != null && (doOnError = this.authService.generateAuthSession().flatMap(new SplashViewModel$refresh$$inlined$let$lambda$1(tokens, this)).ignoreElement().andThen(new SplashViewModel$refresh$$inlined$let$lambda$2(this)).doOnError(SplashViewModel$refresh$1$3.INSTANCE)) != null) {
            return doOnError;
        }
        Completable error = Completable.error(new TokensNotSetException());
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(TokensNotSetException())");
        return error;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.digitalwallet.app.viewmodel.splash.SplashViewModel$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void logout() {
        CompositeDisposable compositeDisposable = getCompositeDisposable();
        Completable subscribeOn = Completable.fromCallable(new SplashViewModel$logout$1(this)).subscribeOn(Schedulers.io());
        SplashViewModel$logout$2 splashViewModel$logout$2 = SplashViewModel$logout$2.INSTANCE;
        if (splashViewModel$logout$2 != null) {
            splashViewModel$logout$2 = new SplashViewModel$sam$io_reactivex_functions_Consumer$0(splashViewModel$logout$2);
        }
        compositeDisposable.add(subscribeOn.doOnError((Consumer) splashViewModel$logout$2).andThen(Completable.fromCallable(new SplashViewModel$sam$java_util_concurrent_Callable$0(new SplashViewModel$logout$3(this.digitalWalletDb)))).andThen(this.holdingsService.deleteHoldingExpiryNotifications()).subscribe());
    }

    /* access modifiers changed from: private */
    public final void printError(Throwable th) {
        if (th instanceof PinNotSetException) {
            Timber.e("Pin was not set", new Object[0]);
        } else if (th instanceof TokensNotSetException) {
            Timber.e("Tokens were not set", new Object[0]);
        } else {
            Timber.e(th);
        }
    }
}
