package com.digitalwallet.app.viewmodel.pin;

import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FingerprintDialogFragmentViewModel_Factory implements Factory<FingerprintDialogFragmentViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;

    public FingerprintDialogFragmentViewModel_Factory(Provider<AnalyticsHelper> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider
    public FingerprintDialogFragmentViewModel get() {
        return new FingerprintDialogFragmentViewModel(this.analyticsProvider.get());
    }

    public static FingerprintDialogFragmentViewModel_Factory create(Provider<AnalyticsHelper> provider) {
        return new FingerprintDialogFragmentViewModel_Factory(provider);
    }

    public static FingerprintDialogFragmentViewModel newInstance(AnalyticsHelper analyticsHelper) {
        return new FingerprintDialogFragmentViewModel(analyticsHelper);
    }
}
