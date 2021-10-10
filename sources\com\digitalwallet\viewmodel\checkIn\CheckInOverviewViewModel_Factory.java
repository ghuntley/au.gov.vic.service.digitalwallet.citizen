package com.digitalwallet.viewmodel.checkIn;

import android.content.Context;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInOverviewViewModel_Factory implements Factory<CheckInOverviewViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInOverviewViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInOverviewViewModel get() {
        return new CheckInOverviewViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static CheckInOverviewViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        return new CheckInOverviewViewModel_Factory(provider, provider2);
    }

    public static CheckInOverviewViewModel newInstance(Context context, CheckInRepository checkInRepository) {
        return new CheckInOverviewViewModel(context, checkInRepository);
    }
}
