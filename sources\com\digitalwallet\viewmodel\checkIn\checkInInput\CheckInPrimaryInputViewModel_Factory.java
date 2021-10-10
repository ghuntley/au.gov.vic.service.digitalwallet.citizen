package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInPrimaryInputViewModel_Factory implements Factory<CheckInPrimaryInputViewModel> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;

    public CheckInPrimaryInputViewModel_Factory(Provider<CheckInRepository> provider, Provider<AnalyticsHelper> provider2) {
        this.checkInRepositoryProvider = provider;
        this.analyticsProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInPrimaryInputViewModel get() {
        return new CheckInPrimaryInputViewModel(this.checkInRepositoryProvider.get(), this.analyticsProvider.get());
    }

    public static CheckInPrimaryInputViewModel_Factory create(Provider<CheckInRepository> provider, Provider<AnalyticsHelper> provider2) {
        return new CheckInPrimaryInputViewModel_Factory(provider, provider2);
    }

    public static CheckInPrimaryInputViewModel newInstance(CheckInRepository checkInRepository, AnalyticsHelper analyticsHelper) {
        return new CheckInPrimaryInputViewModel(checkInRepository, analyticsHelper);
    }
}
