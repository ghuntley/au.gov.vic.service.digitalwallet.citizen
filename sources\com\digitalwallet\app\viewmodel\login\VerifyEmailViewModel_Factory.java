package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import com.digitalwallet.app.api.UserApi;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class VerifyEmailViewModel_Factory implements Factory<VerifyEmailViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<AuthenticationService> authenticationServiceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<UserApi> userApiProvider;

    public VerifyEmailViewModel_Factory(Provider<Context> provider, Provider<UserApi> provider2, Provider<AuthenticationService> provider3, Provider<Moshi> provider4, Provider<AnalyticsHelper> provider5) {
        this.contextProvider = provider;
        this.userApiProvider = provider2;
        this.authenticationServiceProvider = provider3;
        this.moshiProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider
    public VerifyEmailViewModel get() {
        return new VerifyEmailViewModel(this.contextProvider.get(), this.userApiProvider.get(), this.authenticationServiceProvider.get(), this.moshiProvider.get(), this.analyticsProvider.get());
    }

    public static VerifyEmailViewModel_Factory create(Provider<Context> provider, Provider<UserApi> provider2, Provider<AuthenticationService> provider3, Provider<Moshi> provider4, Provider<AnalyticsHelper> provider5) {
        return new VerifyEmailViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static VerifyEmailViewModel newInstance(Context context, UserApi userApi, AuthenticationService authenticationService, Moshi moshi, AnalyticsHelper analyticsHelper) {
        return new VerifyEmailViewModel(context, userApi, authenticationService, moshi, analyticsHelper);
    }
}
