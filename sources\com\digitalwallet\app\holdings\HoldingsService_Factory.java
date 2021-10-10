package com.digitalwallet.app.holdings;

import android.content.Context;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HoldingsService_Factory implements Factory<HoldingsService> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<HoldingsApiService> apiServiceProvider;
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<AuthenticationUtility> authUtilityProvider;
    private final Provider<Context> contextProvider;
    private final Provider<HoldingsDbService> dbServiceProvider;
    private final Provider<Moshi> moshiProvider;

    public HoldingsService_Factory(Provider<Context> provider, Provider<HoldingsApiService> provider2, Provider<HoldingsDbService> provider3, Provider<AuthenticationUtility> provider4, Provider<AssetService> provider5, Provider<Moshi> provider6, Provider<AnalyticsHelper> provider7) {
        this.contextProvider = provider;
        this.apiServiceProvider = provider2;
        this.dbServiceProvider = provider3;
        this.authUtilityProvider = provider4;
        this.assetServiceProvider = provider5;
        this.moshiProvider = provider6;
        this.analyticsProvider = provider7;
    }

    @Override // javax.inject.Provider
    public HoldingsService get() {
        return new HoldingsService(this.contextProvider.get(), this.apiServiceProvider.get(), this.dbServiceProvider.get(), this.authUtilityProvider.get(), this.assetServiceProvider.get(), this.moshiProvider.get(), this.analyticsProvider.get());
    }

    public static HoldingsService_Factory create(Provider<Context> provider, Provider<HoldingsApiService> provider2, Provider<HoldingsDbService> provider3, Provider<AuthenticationUtility> provider4, Provider<AssetService> provider5, Provider<Moshi> provider6, Provider<AnalyticsHelper> provider7) {
        return new HoldingsService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static HoldingsService newInstance(Context context, HoldingsApiService holdingsApiService, HoldingsDbService holdingsDbService, AuthenticationUtility authenticationUtility, AssetService assetService, Moshi moshi, AnalyticsHelper analyticsHelper) {
        return new HoldingsService(context, holdingsApiService, holdingsDbService, authenticationUtility, assetService, moshi, analyticsHelper);
    }
}
