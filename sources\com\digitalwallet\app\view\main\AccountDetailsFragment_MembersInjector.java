package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.AccountDetailsFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class AccountDetailsFragment_MembersInjector implements MembersInjector<AccountDetailsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<AccountDetailsFragmentViewModel> viewModelProvider;

    public AccountDetailsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AccountDetailsFragmentViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<AccountDetailsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AccountDetailsFragmentViewModel> provider3) {
        return new AccountDetailsFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(AccountDetailsFragment accountDetailsFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(accountDetailsFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(accountDetailsFragment, this.viewModelFactoryProvider.get());
        injectViewModel(accountDetailsFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(AccountDetailsFragment accountDetailsFragment, AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        accountDetailsFragment.viewModel = accountDetailsFragmentViewModel;
    }
}
