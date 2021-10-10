package com.digitalwallet.app.di;

import com.digitalwallet.DigitalWalletApplication;
import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.di.ActivityScope;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, d2 = {"Lcom/digitalwallet/app/di/AppModule;", "", "()V", "provideAppStartUp", "Lcom/digitalwallet/app/AppStartUp;", "application", "Lcom/digitalwallet/DigitalWalletApplication;", "jwtIssuerKeysService", "Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysService;", "scannerDataService", "Lcom/digitalwallet/app/services/ScannerDataService;", "harvestDataService", "Lcom/digitalwallet/app/services/HarvestDataService;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "analyticsHelper", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "checkInRepository", "Lcom/digitalwallet/viewmodel/checkIn/checkInRepository/CheckInRepository;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module(includes = {OIDCModule.class, ViewModelModule.class, SupportFragmentModule.class, DatabaseModule.class, ApiModule.class})
/* compiled from: AppModule.kt */
public class AppModule {
    @Provides
    @ActivityScope
    public final AppStartUp provideAppStartUp(DigitalWalletApplication digitalWalletApplication, JWTIssuerKeysService jWTIssuerKeysService, ScannerDataService scannerDataService, HarvestDataService harvestDataService, AuthenticationUtility authenticationUtility, AnalyticsHelper analyticsHelper, CheckInRepository checkInRepository) {
        Intrinsics.checkNotNullParameter(digitalWalletApplication, "application");
        Intrinsics.checkNotNullParameter(jWTIssuerKeysService, "jwtIssuerKeysService");
        Intrinsics.checkNotNullParameter(scannerDataService, "scannerDataService");
        Intrinsics.checkNotNullParameter(harvestDataService, "harvestDataService");
        Intrinsics.checkNotNullParameter(authenticationUtility, "authenticationUtility");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analyticsHelper");
        Intrinsics.checkNotNullParameter(checkInRepository, "checkInRepository");
        return new AppStartUp(digitalWalletApplication, jWTIssuerKeysService, scannerDataService, harvestDataService, authenticationUtility, analyticsHelper, checkInRepository);
    }
}
