package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HoldingDetailFragmentViewModel_Factory implements Factory<HoldingDetailFragmentViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;

    public HoldingDetailFragmentViewModel_Factory(Provider<AnalyticsHelper> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider
    public HoldingDetailFragmentViewModel get() {
        return new HoldingDetailFragmentViewModel(this.analyticsProvider.get());
    }

    public static HoldingDetailFragmentViewModel_Factory create(Provider<AnalyticsHelper> provider) {
        return new HoldingDetailFragmentViewModel_Factory(provider);
    }

    public static HoldingDetailFragmentViewModel newInstance(AnalyticsHelper analyticsHelper) {
        return new HoldingDetailFragmentViewModel(analyticsHelper);
    }
}
