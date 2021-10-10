package com.digitalwallet.app.services;

import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.db.scan.ScanDao;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ScannerDataService_Factory implements Factory<ScannerDataService> {
    private final Provider<HoldingsApi> holdingsApiProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<ScanDao> scanDaoProvider;

    public ScannerDataService_Factory(Provider<Moshi> provider, Provider<HoldingsApi> provider2, Provider<ScanDao> provider3) {
        this.moshiProvider = provider;
        this.holdingsApiProvider = provider2;
        this.scanDaoProvider = provider3;
    }

    @Override // javax.inject.Provider
    public ScannerDataService get() {
        return new ScannerDataService(this.moshiProvider.get(), this.holdingsApiProvider.get(), this.scanDaoProvider.get());
    }

    public static ScannerDataService_Factory create(Provider<Moshi> provider, Provider<HoldingsApi> provider2, Provider<ScanDao> provider3) {
        return new ScannerDataService_Factory(provider, provider2, provider3);
    }

    public static ScannerDataService newInstance(Moshi moshi, HoldingsApi holdingsApi, ScanDao scanDao) {
        return new ScannerDataService(moshi, holdingsApi, scanDao);
    }
}
