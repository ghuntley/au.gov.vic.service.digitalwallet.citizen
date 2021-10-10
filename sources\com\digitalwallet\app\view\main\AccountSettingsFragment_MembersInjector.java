package com.digitalwallet.app.view.main;

import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.viewmodel.main.AccountSettingsFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class AccountSettingsFragment_MembersInjector implements MembersInjector<AccountSettingsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<AccountSettingsFragmentViewModel> viewModelProvider;

    public AccountSettingsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AccountSettingsFragmentViewModel> provider3, Provider<AuthenticationUtility> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.authenticationUtilityProvider = provider4;
    }

    public static MembersInjector<AccountSettingsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AccountSettingsFragmentViewModel> provider3, Provider<AuthenticationUtility> provider4) {
        return new AccountSettingsFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(AccountSettingsFragment accountSettingsFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(accountSettingsFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(accountSettingsFragment, this.viewModelFactoryProvider.get());
        injectViewModel(accountSettingsFragment, this.viewModelProvider.get());
        injectAuthenticationUtility(accountSettingsFragment, this.authenticationUtilityProvider.get());
    }

    public static void injectViewModel(AccountSettingsFragment accountSettingsFragment, AccountSettingsFragmentViewModel accountSettingsFragmentViewModel) {
        accountSettingsFragment.viewModel = accountSettingsFragmentViewModel;
    }

    public static void injectAuthenticationUtility(AccountSettingsFragment accountSettingsFragment, AuthenticationUtility authenticationUtility) {
        accountSettingsFragment.authenticationUtility = authenticationUtility;
    }
}
