package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CardAddViewModel_Factory implements Factory<CardAddViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;

    public CardAddViewModel_Factory(Provider<AnalyticsHelper> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider
    public CardAddViewModel get() {
        return new CardAddViewModel(this.analyticsProvider.get());
    }

    public static CardAddViewModel_Factory create(Provider<AnalyticsHelper> provider) {
        return new CardAddViewModel_Factory(provider);
    }

    public static CardAddViewModel newInstance(AnalyticsHelper analyticsHelper) {
        return new CardAddViewModel(analyticsHelper);
    }
}
