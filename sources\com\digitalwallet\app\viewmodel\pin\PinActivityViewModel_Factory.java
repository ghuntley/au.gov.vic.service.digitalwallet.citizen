package com.digitalwallet.app.viewmodel.pin;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PinActivityViewModel_Factory implements Factory<PinActivityViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<DigitalWalletDatabase> digitalWalletDbProvider;
    private final Provider<HandshakeService> handshakeServiceProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;

    public PinActivityViewModel_Factory(Provider<AuthenticationUtility> provider, Provider<AnalyticsHelper> provider2, Provider<HoldingsService> provider3, Provider<DigitalWalletDatabase> provider4, Provider<HandshakeService> provider5) {
        this.authenticationUtilityProvider = provider;
        this.analyticsProvider = provider2;
        this.holdingsServiceProvider = provider3;
        this.digitalWalletDbProvider = provider4;
        this.handshakeServiceProvider = provider5;
    }

    @Override // javax.inject.Provider
    public PinActivityViewModel get() {
        return new PinActivityViewModel(this.authenticationUtilityProvider.get(), this.analyticsProvider.get(), this.holdingsServiceProvider.get(), this.digitalWalletDbProvider.get(), this.handshakeServiceProvider.get());
    }

    public static PinActivityViewModel_Factory create(Provider<AuthenticationUtility> provider, Provider<AnalyticsHelper> provider2, Provider<HoldingsService> provider3, Provider<DigitalWalletDatabase> provider4, Provider<HandshakeService> provider5) {
        return new PinActivityViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PinActivityViewModel newInstance(AuthenticationUtility authenticationUtility, AnalyticsHelper analyticsHelper, HoldingsService holdingsService, DigitalWalletDatabase digitalWalletDatabase, HandshakeService handshakeService) {
        return new PinActivityViewModel(authenticationUtility, analyticsHelper, holdingsService, digitalWalletDatabase, handshakeService);
    }
}
