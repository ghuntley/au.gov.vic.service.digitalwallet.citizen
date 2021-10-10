package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class IncomingRequestFragmentViewModel_Factory implements Factory<IncomingRequestFragmentViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<TransactionSharesService> transactionHistoryServiceProvider;

    public IncomingRequestFragmentViewModel_Factory(Provider<AnalyticsHelper> provider, Provider<HoldingsService> provider2, Provider<TransactionSharesService> provider3) {
        this.analyticsProvider = provider;
        this.holdingsServiceProvider = provider2;
        this.transactionHistoryServiceProvider = provider3;
    }

    @Override // javax.inject.Provider
    public IncomingRequestFragmentViewModel get() {
        IncomingRequestFragmentViewModel incomingRequestFragmentViewModel = new IncomingRequestFragmentViewModel(this.analyticsProvider.get());
        IncomingRequestFragmentViewModel_MembersInjector.injectHoldingsService(incomingRequestFragmentViewModel, this.holdingsServiceProvider.get());
        IncomingRequestFragmentViewModel_MembersInjector.injectTransactionHistoryService(incomingRequestFragmentViewModel, this.transactionHistoryServiceProvider.get());
        return incomingRequestFragmentViewModel;
    }

    public static IncomingRequestFragmentViewModel_Factory create(Provider<AnalyticsHelper> provider, Provider<HoldingsService> provider2, Provider<TransactionSharesService> provider3) {
        return new IncomingRequestFragmentViewModel_Factory(provider, provider2, provider3);
    }

    public static IncomingRequestFragmentViewModel newInstance(AnalyticsHelper analyticsHelper) {
        return new IncomingRequestFragmentViewModel(analyticsHelper);
    }
}
