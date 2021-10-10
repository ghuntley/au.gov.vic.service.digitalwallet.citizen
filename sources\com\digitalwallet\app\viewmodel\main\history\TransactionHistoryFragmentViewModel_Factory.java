package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TransactionHistoryFragmentViewModel_Factory implements Factory<TransactionHistoryFragmentViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<TransactionSharesService> transactionSharesServiceProvider;

    public TransactionHistoryFragmentViewModel_Factory(Provider<AnalyticsHelper> provider, Provider<TransactionSharesService> provider2) {
        this.analyticsProvider = provider;
        this.transactionSharesServiceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public TransactionHistoryFragmentViewModel get() {
        TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel = new TransactionHistoryFragmentViewModel(this.analyticsProvider.get());
        TransactionHistoryFragmentViewModel_MembersInjector.injectTransactionSharesService(transactionHistoryFragmentViewModel, this.transactionSharesServiceProvider.get());
        return transactionHistoryFragmentViewModel;
    }

    public static TransactionHistoryFragmentViewModel_Factory create(Provider<AnalyticsHelper> provider, Provider<TransactionSharesService> provider2) {
        return new TransactionHistoryFragmentViewModel_Factory(provider, provider2);
    }

    public static TransactionHistoryFragmentViewModel newInstance(AnalyticsHelper analyticsHelper) {
        return new TransactionHistoryFragmentViewModel(analyticsHelper);
    }
}
