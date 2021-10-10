package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RegisterSuccessViewModel_Factory implements Factory<RegisterSuccessViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;

    public RegisterSuccessViewModel_Factory(Provider<AnalyticsHelper> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider
    public RegisterSuccessViewModel get() {
        return new RegisterSuccessViewModel(this.analyticsProvider.get());
    }

    public static RegisterSuccessViewModel_Factory create(Provider<AnalyticsHelper> provider) {
        return new RegisterSuccessViewModel_Factory(provider);
    }

    public static RegisterSuccessViewModel newInstance(AnalyticsHelper analyticsHelper) {
        return new RegisterSuccessViewModel(analyticsHelper);
    }
}
