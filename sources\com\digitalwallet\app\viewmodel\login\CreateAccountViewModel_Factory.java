package com.digitalwallet.app.viewmodel.login;

import android.content.Context;
import com.digitalwallet.app.api.UserApi;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CreateAccountViewModel_Factory implements Factory<CreateAccountViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<RemoteSubscriptionService> remoteSubscriptionServiceProvider;
    private final Provider<UserApi> userApiProvider;

    public CreateAccountViewModel_Factory(Provider<Context> provider, Provider<UserApi> provider2, Provider<RemoteSubscriptionService> provider3, Provider<Moshi> provider4, Provider<AnalyticsHelper> provider5) {
        this.contextProvider = provider;
        this.userApiProvider = provider2;
        this.remoteSubscriptionServiceProvider = provider3;
        this.moshiProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider
    public CreateAccountViewModel get() {
        return new CreateAccountViewModel(this.contextProvider.get(), this.userApiProvider.get(), this.remoteSubscriptionServiceProvider.get(), this.moshiProvider.get(), this.analyticsProvider.get());
    }

    public static CreateAccountViewModel_Factory create(Provider<Context> provider, Provider<UserApi> provider2, Provider<RemoteSubscriptionService> provider3, Provider<Moshi> provider4, Provider<AnalyticsHelper> provider5) {
        return new CreateAccountViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CreateAccountViewModel newInstance(Context context, UserApi userApi, RemoteSubscriptionService remoteSubscriptionService, Moshi moshi, AnalyticsHelper analyticsHelper) {
        return new CreateAccountViewModel(context, userApi, remoteSubscriptionService, moshi, analyticsHelper);
    }
}
