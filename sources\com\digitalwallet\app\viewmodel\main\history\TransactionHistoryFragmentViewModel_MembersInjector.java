package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.services.TransactionSharesService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class TransactionHistoryFragmentViewModel_MembersInjector implements MembersInjector<TransactionHistoryFragmentViewModel> {
    private final Provider<TransactionSharesService> transactionSharesServiceProvider;

    public TransactionHistoryFragmentViewModel_MembersInjector(Provider<TransactionSharesService> provider) {
        this.transactionSharesServiceProvider = provider;
    }

    public static MembersInjector<TransactionHistoryFragmentViewModel> create(Provider<TransactionSharesService> provider) {
        return new TransactionHistoryFragmentViewModel_MembersInjector(provider);
    }

    public void injectMembers(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        injectTransactionSharesService(transactionHistoryFragmentViewModel, this.transactionSharesServiceProvider.get());
    }

    public static void injectTransactionSharesService(TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel, TransactionSharesService transactionSharesService) {
        transactionHistoryFragmentViewModel.transactionSharesService = transactionSharesService;
    }
}
