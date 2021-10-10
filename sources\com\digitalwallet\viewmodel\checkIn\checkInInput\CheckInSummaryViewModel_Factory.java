package com.digitalwallet.viewmodel.checkIn.checkInInput;

import android.content.Context;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInSummaryViewModel_Factory implements Factory<CheckInSummaryViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInSummaryViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2, Provider<AnalyticsHelper> provider3) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
        this.analyticsProvider = provider3;
    }

    @Override // javax.inject.Provider
    public CheckInSummaryViewModel get() {
        return new CheckInSummaryViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get(), this.analyticsProvider.get());
    }

    public static CheckInSummaryViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2, Provider<AnalyticsHelper> provider3) {
        return new CheckInSummaryViewModel_Factory(provider, provider2, provider3);
    }

    public static CheckInSummaryViewModel newInstance(Context context, CheckInRepository checkInRepository, AnalyticsHelper analyticsHelper) {
        return new CheckInSummaryViewModel(context, checkInRepository, analyticsHelper);
    }
}
