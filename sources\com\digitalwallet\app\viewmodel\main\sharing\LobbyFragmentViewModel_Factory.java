package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.connection.BLEClient;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LobbyFragmentViewModel_Factory implements Factory<LobbyFragmentViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<BLEClient> bleClientProvider;
    private final Provider<HoldingParser> holdingParserProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<TransactionSharesService> transactionHistoryServiceProvider;

    public LobbyFragmentViewModel_Factory(Provider<AnalyticsHelper> provider, Provider<HoldingsService> provider2, Provider<HoldingParser> provider3, Provider<AssetService> provider4, Provider<TransactionSharesService> provider5, Provider<AppStartUp> provider6, Provider<BLEClient> provider7) {
        this.analyticsProvider = provider;
        this.holdingsServiceProvider = provider2;
        this.holdingParserProvider = provider3;
        this.assetServiceProvider = provider4;
        this.transactionHistoryServiceProvider = provider5;
        this.appStartUpProvider = provider6;
        this.bleClientProvider = provider7;
    }

    @Override // javax.inject.Provider
    public LobbyFragmentViewModel get() {
        return new LobbyFragmentViewModel(this.analyticsProvider.get(), this.holdingsServiceProvider.get(), this.holdingParserProvider.get(), this.assetServiceProvider.get(), this.transactionHistoryServiceProvider.get(), this.appStartUpProvider.get(), this.bleClientProvider.get());
    }

    public static LobbyFragmentViewModel_Factory create(Provider<AnalyticsHelper> provider, Provider<HoldingsService> provider2, Provider<HoldingParser> provider3, Provider<AssetService> provider4, Provider<TransactionSharesService> provider5, Provider<AppStartUp> provider6, Provider<BLEClient> provider7) {
        return new LobbyFragmentViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static LobbyFragmentViewModel newInstance(AnalyticsHelper analyticsHelper, HoldingsService holdingsService, HoldingParser holdingParser, AssetService assetService, TransactionSharesService transactionSharesService, AppStartUp appStartUp, BLEClient bLEClient) {
        return new LobbyFragmentViewModel(analyticsHelper, holdingsService, holdingParser, assetService, transactionSharesService, appStartUp, bLEClient);
    }
}
