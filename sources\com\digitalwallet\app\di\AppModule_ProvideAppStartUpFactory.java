package com.digitalwallet.app.di;

import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AppModule_ProvideAppStartUpFactory implements Factory<AppStartUp> {
    private final Provider<AnalyticsHelper> analyticsHelperProvider;
    private final Provider<DigitalWalletApplication> applicationProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<HarvestDataService> harvestDataServiceProvider;
    private final Provider<JWTIssuerKeysService> jwtIssuerKeysServiceProvider;
    private final AppModule module;
    private final Provider<ScannerDataService> scannerDataServiceProvider;

    public AppModule_ProvideAppStartUpFactory(AppModule appModule, Provider<DigitalWalletApplication> provider, Provider<JWTIssuerKeysService> provider2, Provider<ScannerDataService> provider3, Provider<HarvestDataService> provider4, Provider<AuthenticationUtility> provider5, Provider<AnalyticsHelper> provider6, Provider<CheckInRepository> provider7) {
        this.module = appModule;
        this.applicationProvider = provider;
        this.jwtIssuerKeysServiceProvider = provider2;
        this.scannerDataServiceProvider = provider3;
        this.harvestDataServiceProvider = provider4;
        this.authenticationUtilityProvider = provider5;
        this.analyticsHelperProvider = provider6;
        this.checkInRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public AppStartUp get() {
        return provideAppStartUp(this.module, this.applicationProvider.get(), this.jwtIssuerKeysServiceProvider.get(), this.scannerDataServiceProvider.get(), this.harvestDataServiceProvider.get(), this.authenticationUtilityProvider.get(), this.analyticsHelperProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static AppModule_ProvideAppStartUpFactory create(AppModule appModule, Provider<DigitalWalletApplication> provider, Provider<JWTIssuerKeysService> provider2, Provider<ScannerDataService> provider3, Provider<HarvestDataService> provider4, Provider<AuthenticationUtility> provider5, Provider<AnalyticsHelper> provider6, Provider<CheckInRepository> provider7) {
        return new AppModule_ProvideAppStartUpFactory(appModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AppStartUp provideAppStartUp(AppModule appModule, DigitalWalletApplication digitalWalletApplication, JWTIssuerKeysService jWTIssuerKeysService, ScannerDataService scannerDataService, HarvestDataService harvestDataService, AuthenticationUtility authenticationUtility, AnalyticsHelper analyticsHelper, CheckInRepository checkInRepository) {
        return (AppStartUp) Preconditions.checkNotNull(appModule.provideAppStartUp(digitalWalletApplication, jWTIssuerKeysService, scannerDataService, harvestDataService, authenticationUtility, analyticsHelper, checkInRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
