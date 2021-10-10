package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.history.TransactionHistoryFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class TransactionHistoryFragment_MembersInjector implements MembersInjector<TransactionHistoryFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<TransactionHistoryFragmentViewModel> viewModelProvider;

    public TransactionHistoryFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<TransactionHistoryFragmentViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<TransactionHistoryFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<TransactionHistoryFragmentViewModel> provider3) {
        return new TransactionHistoryFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(TransactionHistoryFragment transactionHistoryFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(transactionHistoryFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(transactionHistoryFragment, this.viewModelFactoryProvider.get());
        injectViewModel(transactionHistoryFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(TransactionHistoryFragment transactionHistoryFragment, TransactionHistoryFragmentViewModel transactionHistoryFragmentViewModel) {
        transactionHistoryFragment.viewModel = transactionHistoryFragmentViewModel;
    }
}
