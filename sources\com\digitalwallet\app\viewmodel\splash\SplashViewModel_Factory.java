package com.digitalwallet.app.viewmodel.splash;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SplashViewModel_Factory implements Factory<SplashViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<AuthenticationService> authServiceProvider;
    private final Provider<AuthenticationUtility> authUtilityProvider;
    private final Provider<DigitalWalletDatabase> digitalWalletDbProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;

    public SplashViewModel_Factory(Provider<AuthenticationUtility> provider, Provider<AuthenticationService> provider2, Provider<HoldingsService> provider3, Provider<DigitalWalletDatabase> provider4, Provider<AnalyticsHelper> provider5) {
        this.authUtilityProvider = provider;
        this.authServiceProvider = provider2;
        this.holdingsServiceProvider = provider3;
        this.digitalWalletDbProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider
    public SplashViewModel get() {
        return new SplashViewModel(this.authUtilityProvider.get(), this.authServiceProvider.get(), this.holdingsServiceProvider.get(), this.digitalWalletDbProvider.get(), this.analyticsProvider.get());
    }

    public static SplashViewModel_Factory create(Provider<AuthenticationUtility> provider, Provider<AuthenticationService> provider2, Provider<HoldingsService> provider3, Provider<DigitalWalletDatabase> provider4, Provider<AnalyticsHelper> provider5) {
        return new SplashViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SplashViewModel newInstance(AuthenticationUtility authenticationUtility, AuthenticationService authenticationService, HoldingsService holdingsService, DigitalWalletDatabase digitalWalletDatabase, AnalyticsHelper analyticsHelper) {
        return new SplashViewModel(authenticationUtility, authenticationService, holdingsService, digitalWalletDatabase, analyticsHelper);
    }
}
