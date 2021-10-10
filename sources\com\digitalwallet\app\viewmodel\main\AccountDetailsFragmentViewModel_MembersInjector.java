package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.oidc.AuthenticationUtility;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AccountDetailsFragmentViewModel_MembersInjector implements MembersInjector<AccountDetailsFragmentViewModel> {
    private final Provider<AuthenticationUtility> authUtilityProvider;

    public AccountDetailsFragmentViewModel_MembersInjector(Provider<AuthenticationUtility> provider) {
        this.authUtilityProvider = provider;
    }

    public static MembersInjector<AccountDetailsFragmentViewModel> create(Provider<AuthenticationUtility> provider) {
        return new AccountDetailsFragmentViewModel_MembersInjector(provider);
    }

    public void injectMembers(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel) {
        injectAuthUtility(accountDetailsFragmentViewModel, this.authUtilityProvider.get());
    }

    public static void injectAuthUtility(AccountDetailsFragmentViewModel accountDetailsFragmentViewModel, AuthenticationUtility authenticationUtility) {
        accountDetailsFragmentViewModel.authUtility = authenticationUtility;
    }
}
