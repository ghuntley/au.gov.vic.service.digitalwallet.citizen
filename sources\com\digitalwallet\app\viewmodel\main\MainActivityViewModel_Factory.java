package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.services.RemoteConfigService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MainActivityViewModel_Factory implements Factory<MainActivityViewModel> {
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<RemoteConfigService> remoteConfigServiceProvider;

    public MainActivityViewModel_Factory(Provider<HoldingsService> provider, Provider<RemoteConfigService> provider2) {
        this.holdingsServiceProvider = provider;
        this.remoteConfigServiceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public MainActivityViewModel get() {
        return new MainActivityViewModel(this.holdingsServiceProvider.get(), this.remoteConfigServiceProvider.get());
    }

    public static MainActivityViewModel_Factory create(Provider<HoldingsService> provider, Provider<RemoteConfigService> provider2) {
        return new MainActivityViewModel_Factory(provider, provider2);
    }

    public static MainActivityViewModel newInstance(HoldingsService holdingsService, RemoteConfigService remoteConfigService) {
        return new MainActivityViewModel(holdingsService, remoteConfigService);
    }
}
