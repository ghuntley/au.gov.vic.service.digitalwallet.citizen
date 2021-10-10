package com.digitalwallet.app.viewmodel.main.sharing;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.services.TransactionSharesService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class IncomingRequestFragmentViewModel_MembersInjector implements MembersInjector<IncomingRequestFragmentViewModel> {
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<TransactionSharesService> transactionHistoryServiceProvider;

    public IncomingRequestFragmentViewModel_MembersInjector(Provider<HoldingsService> provider, Provider<TransactionSharesService> provider2) {
        this.holdingsServiceProvider = provider;
        this.transactionHistoryServiceProvider = provider2;
    }

    public static MembersInjector<IncomingRequestFragmentViewModel> create(Provider<HoldingsService> provider, Provider<TransactionSharesService> provider2) {
        return new IncomingRequestFragmentViewModel_MembersInjector(provider, provider2);
    }

    public void injectMembers(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        injectHoldingsService(incomingRequestFragmentViewModel, this.holdingsServiceProvider.get());
        injectTransactionHistoryService(incomingRequestFragmentViewModel, this.transactionHistoryServiceProvider.get());
    }

    public static void injectHoldingsService(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel, HoldingsService holdingsService) {
        incomingRequestFragmentViewModel.holdingsService = holdingsService;
    }

    public static void injectTransactionHistoryService(IncomingRequestFragmentViewModel incomingRequestFragmentViewModel, TransactionSharesService transactionSharesService) {
        incomingRequestFragmentViewModel.transactionHistoryService = transactionSharesService;
    }
}
