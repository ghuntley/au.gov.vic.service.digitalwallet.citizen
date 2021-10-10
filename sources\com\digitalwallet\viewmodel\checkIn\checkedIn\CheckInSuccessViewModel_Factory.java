package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInSuccessViewModel_Factory implements Factory<CheckInSuccessViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInSuccessViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2, Provider<AnalyticsHelper> provider3) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
        this.analyticsProvider = provider3;
    }

    @Override // javax.inject.Provider
    public CheckInSuccessViewModel get() {
        return new CheckInSuccessViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get(), this.analyticsProvider.get());
    }

    public static CheckInSuccessViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2, Provider<AnalyticsHelper> provider3) {
        return new CheckInSuccessViewModel_Factory(provider, provider2, provider3);
    }

    public static CheckInSuccessViewModel newInstance(Context context, CheckInRepository checkInRepository, AnalyticsHelper analyticsHelper) {
        return new CheckInSuccessViewModel(context, checkInRepository, analyticsHelper);
    }
}
