package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.services.TransactionSharesService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SharingHistoryFragmentViewModel_MembersInjector implements MembersInjector<SharingHistoryFragmentViewModel> {
    private final Provider<TransactionSharesService> sharesServiceProvider;

    public SharingHistoryFragmentViewModel_MembersInjector(Provider<TransactionSharesService> provider) {
        this.sharesServiceProvider = provider;
    }

    public static MembersInjector<SharingHistoryFragmentViewModel> create(Provider<TransactionSharesService> provider) {
        return new SharingHistoryFragmentViewModel_MembersInjector(provider);
    }

    public void injectMembers(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel) {
        injectSharesService(sharingHistoryFragmentViewModel, this.sharesServiceProvider.get());
    }

    public static void injectSharesService(SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel, TransactionSharesService transactionSharesService) {
        sharingHistoryFragmentViewModel.sharesService = transactionSharesService;
    }
}
