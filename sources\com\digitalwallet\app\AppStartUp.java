package com.digitalwallet.app;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.di.ActivityScope;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.RetrofitHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@ActivityScope
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u00109\u001a\u0004\u0018\u00010\u0016J\n\u0010:\u001a\u0004\u0018\u00010;H\u0002J\b\u0010<\u001a\u00020=H\u0007J\b\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020=H\u0002J\u000e\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020\u0016R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006B"}, d2 = {"Lcom/digitalwallet/app/AppStartUp;", "Landroidx/lifecycle/LifecycleObserver;", "application", "Lcom/digitalwallet/DigitalWalletApplication;", "jwtIssuerKeysService", "Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysService;", "scannerDataService", "Lcom/digitalwallet/app/services/ScannerDataService;", "harvestDataService", "Lcom/digitalwallet/app/services/HarvestDataService;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "(Lcom/digitalwallet/DigitalWalletApplication;Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysService;Lcom/digitalwallet/app/services/ScannerDataService;Lcom/digitalwallet/app/services/HarvestDataService;Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/utilities/AnalyticsHelper;Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "getAnalytics", "()Lcom/digitalwallet/utilities/AnalyticsHelper;", "setAnalytics", "(Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "appIssuerKeys", "Lcom/nimbusds/jose/jwk/JWKSet;", "getApplication", "()Lcom/digitalwallet/DigitalWalletApplication;", "setApplication", "(Lcom/digitalwallet/DigitalWalletApplication;)V", "getAuthenticationUtility", "()Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "setAuthenticationUtility", "(Lcom/digitalwallet/app/oidc/AuthenticationUtility;)V", "getCheckInRepository", "()Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "setCheckInRepository", "(Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getHarvestDataService", "()Lcom/digitalwallet/app/services/HarvestDataService;", "setHarvestDataService", "(Lcom/digitalwallet/app/services/HarvestDataService;)V", "getJwtIssuerKeysService", "()Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysService;", "setJwtIssuerKeysService", "(Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysService;)V", "pendingCheckInRetry", "getPendingCheckInRetry", "()Lio/reactivex/disposables/CompositeDisposable;", "setPendingCheckInRetry", "(Lio/reactivex/disposables/CompositeDisposable;)V", "scanRetry", "getScanRetry", "setScanRetry", "getScannerDataService", "()Lcom/digitalwallet/app/services/ScannerDataService;", "setScannerDataService", "(Lcom/digitalwallet/app/services/ScannerDataService;)V", "getIssuerKeys", "getLoginSession", "", "onAppForegrounded", "", "retryPendingCheckIns", "retryScans", "updateIssuerKeys", "keys", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AppStartUp.kt */
public final class AppStartUp implements LifecycleObserver {
    private AnalyticsHelper analytics;
    private JWKSet appIssuerKeys;
    private DigitalWalletApplication application;
    private AuthenticationUtility authenticationUtility;
    private CheckInRepository checkInRepository;
    private final CompositeDisposable compositeDisposable;
    private HarvestDataService harvestDataService;
    private JWTIssuerKeysService jwtIssuerKeysService;
    private CompositeDisposable pendingCheckInRetry;
    private CompositeDisposable scanRetry;
    private ScannerDataService scannerDataService;

    @Inject
    public AppStartUp(DigitalWalletApplication digitalWalletApplication, JWTIssuerKeysService jWTIssuerKeysService, ScannerDataService scannerDataService2, HarvestDataService harvestDataService2, AuthenticationUtility authenticationUtility2, AnalyticsHelper analyticsHelper, CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(digitalWalletApplication, "application");
        Intrinsics.checkNotNullParameter(jWTIssuerKeysService, "jwtIssuerKeysService");
        Intrinsics.checkNotNullParameter(scannerDataService2, "scannerDataService");
        Intrinsics.checkNotNullParameter(harvestDataService2, "harvestDataService");
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        Intrinsics.checkNotNullParameter(checkInRepository2, "checkInRepository");
        this.application = digitalWalletApplication;
        this.jwtIssuerKeysService = jWTIssuerKeysService;
        this.scannerDataService = scannerDataService2;
        this.harvestDataService = harvestDataService2;
        this.authenticationUtility = authenticationUtility2;
        this.analytics = analyticsHelper;
        this.checkInRepository = checkInRepository2;
        CompositeDisposable compositeDisposable2 = new CompositeDisposable();
        this.compositeDisposable = compositeDisposable2;
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
        lifecycleOwner.getLifecycle().addObserver(this);
        String loginSession = getLoginSession();
        if (loginSession != null) {
            this.analytics.setUserId(loginSession);
        }
        this.analytics.setInstantApp(false);
        Disposable subscribe = this.jwtIssuerKeysService.getIssuerKeys().subscribeOn(Schedulers.io()).map(new Function<JWKSet, Unit>(this) {
            /* class com.digitalwallet.app.AppStartUp.AnonymousClass2 */
            final /* synthetic */ AppStartUp this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ Unit apply(JWKSet jWKSet) {
                apply(jWKSet);
                return Unit.INSTANCE;
            }

            public final void apply(JWKSet jWKSet) {
                Intrinsics.checkNotNullParameter(jWKSet, "it");
                this.this$0.appIssuerKeys = jWKSet;
            }
        }).subscribe(AnonymousClass3.INSTANCE, new AppStartUp$sam$io_reactivex_functions_Consumer$0(new Function1<Throwable, Unit>(RetrofitHelper.Companion) {
            /* class com.digitalwallet.app.AppStartUp.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke(th);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "p1");
                ((RetrofitHelper.Companion) this.receiver).filterHttpException(th);
            }
        }));
        if (subscribe != null) {
            compositeDisposable2.add(subscribe);
        }
    }

    public final DigitalWalletApplication getApplication() {
        return this.application;
    }

    public final void setApplication(DigitalWalletApplication digitalWalletApplication) {
        Intrinsics.checkNotNullParameter(digitalWalletApplication, "<set-?>");
        this.application = digitalWalletApplication;
    }

    public final JWTIssuerKeysService getJwtIssuerKeysService() {
        return this.jwtIssuerKeysService;
    }

    public final void setJwtIssuerKeysService(JWTIssuerKeysService jWTIssuerKeysService) {
        Intrinsics.checkNotNullParameter(jWTIssuerKeysService, "<set-?>");
        this.jwtIssuerKeysService = jWTIssuerKeysService;
    }

    public final ScannerDataService getScannerDataService() {
        return this.scannerDataService;
    }

    public final void setScannerDataService(ScannerDataService scannerDataService2) {
        Intrinsics.checkNotNullParameter(scannerDataService2, "<set-?>");
        this.scannerDataService = scannerDataService2;
    }

    public final HarvestDataService getHarvestDataService() {
        return this.harvestDataService;
    }

    public final void setHarvestDataService(HarvestDataService harvestDataService2) {
        Intrinsics.checkNotNullParameter(harvestDataService2, "<set-?>");
        this.harvestDataService = harvestDataService2;
    }

    public final AuthenticationUtility getAuthenticationUtility() {
        return this.authenticationUtility;
    }

    public final void setAuthenticationUtility(AuthenticationUtility authenticationUtility2) {
        Intrinsics.checkNotNullParameter(authenticationUtility2, "<set-?>");
        this.authenticationUtility = authenticationUtility2;
    }

    public final AnalyticsHelper getAnalytics() {
        return this.analytics;
    }

    public final void setAnalytics(AnalyticsHelper analyticsHelper) {
        Intrinsics.checkNotNullParameter(analyticsHelper, "<set-?>");
        this.analytics = analyticsHelper;
    }

    public final CheckInRepository getCheckInRepository() {
        return this.checkInRepository;
    }

    public final void setCheckInRepository(CheckInRepository checkInRepository2) {
        Intrinsics.checkNotNullParameter(checkInRepository2, "<set-?>");
        this.checkInRepository = checkInRepository2;
    }

    public final CompositeDisposable getScanRetry() {
        return this.scanRetry;
    }

    public final void setScanRetry(CompositeDisposable compositeDisposable2) {
        this.scanRetry = compositeDisposable2;
    }

    public final CompositeDisposable getPendingCheckInRetry() {
        return this.pendingCheckInRetry;
    }

    public final void setPendingCheckInRetry(CompositeDisposable compositeDisposable2) {
        this.pendingCheckInRetry = compositeDisposable2;
    }

    private final String getLoginSession() {
        return this.authenticationUtility.getLoginSession();
    }

    private final void retryScans() {
        CompositeDisposable compositeDisposable2 = this.scanRetry;
        if (compositeDisposable2 != null) {
            compositeDisposable2.dispose();
        }
        this.scanRetry = new CompositeDisposable();
        Disposable subscribe = this.scannerDataService.retryCachedScans().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).doOnError(new AppStartUp$sam$io_reactivex_functions_Consumer$0(new AppStartUp$retryScans$1(RetrofitHelper.Companion))).onErrorComplete().subscribe();
        CompositeDisposable compositeDisposable3 = this.scanRetry;
        Intrinsics.checkNotNull(compositeDisposable3);
        compositeDisposable3.add(subscribe);
        Disposable subscribe2 = this.harvestDataService.sendOtherHarvests().doOnError(new AppStartUp$sam$io_reactivex_functions_Consumer$0(new AppStartUp$retryScans$3(RetrofitHelper.Companion))).onErrorComplete().subscribe();
        CompositeDisposable compositeDisposable4 = this.scanRetry;
        Intrinsics.checkNotNull(compositeDisposable4);
        compositeDisposable4.add(subscribe2);
    }

    private final void retryPendingCheckIns() {
        CompositeDisposable compositeDisposable2 = this.pendingCheckInRetry;
        if (compositeDisposable2 != null) {
            compositeDisposable2.dispose();
        }
        this.pendingCheckInRetry = new CompositeDisposable();
        Disposable subscribe = this.checkInRepository.uploadCheckIns().doOnError(new AppStartUp$sam$io_reactivex_functions_Consumer$0(new AppStartUp$retryPendingCheckIns$1(RetrofitHelper.Companion))).onErrorComplete().subscribe();
        CompositeDisposable compositeDisposable3 = this.pendingCheckInRetry;
        Intrinsics.checkNotNull(compositeDisposable3);
        compositeDisposable3.add(subscribe);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onAppForegrounded() {
        retryScans();
        retryPendingCheckIns();
    }

    public final JWKSet getIssuerKeys() {
        return this.appIssuerKeys;
    }

    public final void updateIssuerKeys(JWKSet jWKSet) {
        Intrinsics.checkNotNullParameter(jWKSet, "keys");
        this.appIssuerKeys = jWKSet;
        this.compositeDisposable.add(this.jwtIssuerKeysService.updateIssuerKeys(jWKSet).subscribeOn(Schedulers.io()).subscribe());
    }
}
