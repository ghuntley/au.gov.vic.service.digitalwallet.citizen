package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInFeedbackViewModel_Factory implements Factory<CheckInFeedbackViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInFeedbackViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2, Provider<AnalyticsHelper> provider3) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
        this.analyticsProvider = provider3;
    }

    @Override // javax.inject.Provider
    public CheckInFeedbackViewModel get() {
        return new CheckInFeedbackViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get(), this.analyticsProvider.get());
    }

    public static CheckInFeedbackViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2, Provider<AnalyticsHelper> provider3) {
        return new CheckInFeedbackViewModel_Factory(provider, provider2, provider3);
    }

    public static CheckInFeedbackViewModel newInstance(Context context, CheckInRepository checkInRepository, AnalyticsHelper analyticsHelper) {
        return new CheckInFeedbackViewModel(context, checkInRepository, analyticsHelper);
    }
}
