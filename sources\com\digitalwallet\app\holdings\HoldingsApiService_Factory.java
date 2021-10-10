package com.digitalwallet.app.holdings;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HoldingsApiService_Factory implements Factory<HoldingsApiService> {
    private final Provider<HoldingsApi> apiProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<ConfigurationDocument> configurationDocumentProvider;
    private final Provider<HoldingParser> holdingParserProvider;

    public HoldingsApiService_Factory(Provider<ConfigurationDocument> provider, Provider<HoldingsApi> provider2, Provider<HoldingParser> provider3, Provider<AppStartUp> provider4) {
        this.configurationDocumentProvider = provider;
        this.apiProvider = provider2;
        this.holdingParserProvider = provider3;
        this.appStartUpProvider = provider4;
    }

    @Override // javax.inject.Provider
    public HoldingsApiService get() {
        return new HoldingsApiService(this.configurationDocumentProvider.get(), this.apiProvider.get(), this.holdingParserProvider.get(), this.appStartUpProvider.get());
    }

    public static HoldingsApiService_Factory create(Provider<ConfigurationDocument> provider, Provider<HoldingsApi> provider2, Provider<HoldingParser> provider3, Provider<AppStartUp> provider4) {
        return new HoldingsApiService_Factory(provider, provider2, provider3, provider4);
    }

    public static HoldingsApiService newInstance(ConfigurationDocument configurationDocument, HoldingsApi holdingsApi, HoldingParser holdingParser, AppStartUp appStartUp) {
        return new HoldingsApiService(configurationDocument, holdingsApi, holdingParser, appStartUp);
    }
}
