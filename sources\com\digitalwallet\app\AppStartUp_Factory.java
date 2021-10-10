package com.digitalwallet.app;

import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AppStartUp_Factory implements Factory<AppStartUp> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<DigitalWalletApplication> applicationProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<HarvestDataService> harvestDataServiceProvider;
    private final Provider<JWTIssuerKeysService> jwtIssuerKeysServiceProvider;
    private final Provider<ScannerDataService> scannerDataServiceProvider;

    public AppStartUp_Factory(Provider<DigitalWalletApplication> provider, Provider<JWTIssuerKeysService> provider2, Provider<ScannerDataService> provider3, Provider<HarvestDataService> provider4, Provider<AuthenticationUtility> provider5, Provider<AnalyticsHelper> provider6, Provider<CheckInRepository> provider7) {
        this.applicationProvider = provider;
        this.jwtIssuerKeysServiceProvider = provider2;
        this.scannerDataServiceProvider = provider3;
        this.harvestDataServiceProvider = provider4;
        this.authenticationUtilityProvider = provider5;
        this.analyticsProvider = provider6;
        this.checkInRepositoryProvider = provider7;
    }

    @Override // javax.inject.Provider
    public AppStartUp get() {
        return new AppStartUp(this.applicationProvider.get(), this.jwtIssuerKeysServiceProvider.get(), this.scannerDataServiceProvider.get(), this.harvestDataServiceProvider.get(), this.authenticationUtilityProvider.get(), this.analyticsProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static AppStartUp_Factory create(Provider<DigitalWalletApplication> provider, Provider<JWTIssuerKeysService> provider2, Provider<ScannerDataService> provider3, Provider<HarvestDataService> provider4, Provider<AuthenticationUtility> provider5, Provider<AnalyticsHelper> provider6, Provider<CheckInRepository> provider7) {
        return new AppStartUp_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AppStartUp newInstance(DigitalWalletApplication digitalWalletApplication, JWTIssuerKeysService jWTIssuerKeysService, ScannerDataService scannerDataService, HarvestDataService harvestDataService, AuthenticationUtility authenticationUtility, AnalyticsHelper analyticsHelper, CheckInRepository checkInRepository) {
        return new AppStartUp(digitalWalletApplication, jWTIssuerKeysService, scannerDataService, harvestDataService, authenticationUtility, analyticsHelper, checkInRepository);
    }
}
