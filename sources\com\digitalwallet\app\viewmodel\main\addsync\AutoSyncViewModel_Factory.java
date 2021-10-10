package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.app.oidc.AuthenticationUtility;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AutoSyncViewModel_Factory implements Factory<AutoSyncViewModel> {
    private final Provider<AuthenticationUtility> authUtilityProvider;

    public AutoSyncViewModel_Factory(Provider<AuthenticationUtility> provider) {
        this.authUtilityProvider = provider;
    }

    @Override // javax.inject.Provider
    public AutoSyncViewModel get() {
        return new AutoSyncViewModel(this.authUtilityProvider.get());
    }

    public static AutoSyncViewModel_Factory create(Provider<AuthenticationUtility> provider) {
        return new AutoSyncViewModel_Factory(provider);
    }

    public static AutoSyncViewModel newInstance(AuthenticationUtility authenticationUtility) {
        return new AutoSyncViewModel(authenticationUtility);
    }
}
