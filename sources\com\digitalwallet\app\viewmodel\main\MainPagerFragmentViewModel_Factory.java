package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HandshakeService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MainPagerFragmentViewModel_Factory implements Factory<MainPagerFragmentViewModel> {
    private final Provider<AuthenticationUtility> authUtilityProvider;
    private final Provider<DigitalWalletDatabase> digitalWalletDbProvider;
    private final Provider<HandshakeService> handshakeServiceProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;

    public MainPagerFragmentViewModel_Factory(Provider<AuthenticationUtility> provider, Provider<HoldingsService> provider2, Provider<DigitalWalletDatabase> provider3, Provider<HandshakeService> provider4) {
        this.authUtilityProvider = provider;
        this.holdingsServiceProvider = provider2;
        this.digitalWalletDbProvider = provider3;
        this.handshakeServiceProvider = provider4;
    }

    @Override // javax.inject.Provider
    public MainPagerFragmentViewModel get() {
        return new MainPagerFragmentViewModel(this.authUtilityProvider.get(), this.holdingsServiceProvider.get(), this.digitalWalletDbProvider.get(), this.handshakeServiceProvider.get());
    }

    public static MainPagerFragmentViewModel_Factory create(Provider<AuthenticationUtility> provider, Provider<HoldingsService> provider2, Provider<DigitalWalletDatabase> provider3, Provider<HandshakeService> provider4) {
        return new MainPagerFragmentViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static MainPagerFragmentViewModel newInstance(AuthenticationUtility authenticationUtility, HoldingsService holdingsService, DigitalWalletDatabase digitalWalletDatabase, HandshakeService handshakeService) {
        return new MainPagerFragmentViewModel(authenticationUtility, holdingsService, digitalWalletDatabase, handshakeService);
    }
}
