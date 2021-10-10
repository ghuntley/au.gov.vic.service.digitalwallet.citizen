package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.services.AssetService;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CardSyncViewModel_Factory implements Factory<CardSyncViewModel> {
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<AuthenticationService> authenticationServiceProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<Moshi> moshiProvider;

    public CardSyncViewModel_Factory(Provider<HoldingsService> provider, Provider<Moshi> provider2, Provider<AssetService> provider3, Provider<AuthenticationService> provider4) {
        this.holdingsServiceProvider = provider;
        this.moshiProvider = provider2;
        this.assetServiceProvider = provider3;
        this.authenticationServiceProvider = provider4;
    }

    @Override // javax.inject.Provider
    public CardSyncViewModel get() {
        return new CardSyncViewModel(this.holdingsServiceProvider.get(), this.moshiProvider.get(), this.assetServiceProvider.get(), this.authenticationServiceProvider.get());
    }

    public static CardSyncViewModel_Factory create(Provider<HoldingsService> provider, Provider<Moshi> provider2, Provider<AssetService> provider3, Provider<AuthenticationService> provider4) {
        return new CardSyncViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static CardSyncViewModel newInstance(HoldingsService holdingsService, Moshi moshi, AssetService assetService, AuthenticationService authenticationService) {
        return new CardSyncViewModel(holdingsService, moshi, assetService, authenticationService);
    }
}
