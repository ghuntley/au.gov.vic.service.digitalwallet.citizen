package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.services.TransactionSharesService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SharingHistoryFragmentViewModel_Factory implements Factory<SharingHistoryFragmentViewModel> {
    private final Provider<TransactionSharesService> sharesServiceProvider;

    public SharingHistoryFragmentViewModel_Factory(Provider<TransactionSharesService> provider) {
        this.sharesServiceProvider = provider;
    }

    @Override // javax.inject.Provider
    public SharingHistoryFragmentViewModel get() {
        SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel = new SharingHistoryFragmentViewModel();
        SharingHistoryFragmentViewModel_MembersInjector.injectSharesService(sharingHistoryFragmentViewModel, this.sharesServiceProvider.get());
        return sharingHistoryFragmentViewModel;
    }

    public static SharingHistoryFragmentViewModel_Factory create(Provider<TransactionSharesService> provider) {
        return new SharingHistoryFragmentViewModel_Factory(provider);
    }

    public static SharingHistoryFragmentViewModel newInstance() {
        return new SharingHistoryFragmentViewModel();
    }
}
