package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginActivityViewModel_Factory implements Factory<LoginActivityViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<AuthenticationService> authenticationServiceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;

    public LoginActivityViewModel_Factory(Provider<AuthenticationService> provider, Provider<Moshi> provider2, Provider<AnalyticsHelper> provider3, Provider<Context> provider4) {
        this.authenticationServiceProvider = provider;
        this.moshiProvider = provider2;
        this.analyticsProvider = provider3;
        this.contextProvider = provider4;
    }

    @Override // javax.inject.Provider
    public LoginActivityViewModel get() {
        return new LoginActivityViewModel(this.authenticationServiceProvider.get(), this.moshiProvider.get(), this.analyticsProvider.get(), this.contextProvider.get());
    }

    public static LoginActivityViewModel_Factory create(Provider<AuthenticationService> provider, Provider<Moshi> provider2, Provider<AnalyticsHelper> provider3, Provider<Context> provider4) {
        return new LoginActivityViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static LoginActivityViewModel newInstance(AuthenticationService authenticationService, Moshi moshi, AnalyticsHelper analyticsHelper, Context context) {
        return new LoginActivityViewModel(authenticationService, moshi, analyticsHelper, context);
    }
}
