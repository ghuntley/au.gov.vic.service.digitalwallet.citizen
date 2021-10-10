package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import com.digitalwallet.app.services.SimpleAssetService;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HomeServicesViewModel_Factory implements Factory<HomeServicesViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<SimpleAssetService> simpleAssetServiceProvider;

    public HomeServicesViewModel_Factory(Provider<Moshi> provider, Provider<Context> provider2, Provider<SimpleAssetService> provider3, Provider<CheckInRepository> provider4) {
        this.moshiProvider = provider;
        this.contextProvider = provider2;
        this.simpleAssetServiceProvider = provider3;
        this.checkInRepositoryProvider = provider4;
    }

    @Override // javax.inject.Provider
    public HomeServicesViewModel get() {
        return new HomeServicesViewModel(this.moshiProvider.get(), this.contextProvider.get(), this.simpleAssetServiceProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static HomeServicesViewModel_Factory create(Provider<Moshi> provider, Provider<Context> provider2, Provider<SimpleAssetService> provider3, Provider<CheckInRepository> provider4) {
        return new HomeServicesViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static HomeServicesViewModel newInstance(Moshi moshi, Context context, SimpleAssetService simpleAssetService, CheckInRepository checkInRepository) {
        return new HomeServicesViewModel(moshi, context, simpleAssetService, checkInRepository);
    }
}
