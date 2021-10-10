package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.oidc.AuthenticationUtility;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class NicknameViewModel_Factory implements Factory<NicknameViewModel> {
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;

    public NicknameViewModel_Factory(Provider<AuthenticationUtility> provider) {
        this.authenticationUtilityProvider = provider;
    }

    @Override // javax.inject.Provider
    public NicknameViewModel get() {
        return new NicknameViewModel(this.authenticationUtilityProvider.get());
    }

    public static NicknameViewModel_Factory create(Provider<AuthenticationUtility> provider) {
        return new NicknameViewModel_Factory(provider);
    }

    public static NicknameViewModel newInstance(AuthenticationUtility authenticationUtility) {
        return new NicknameViewModel(authenticationUtility);
    }
}
