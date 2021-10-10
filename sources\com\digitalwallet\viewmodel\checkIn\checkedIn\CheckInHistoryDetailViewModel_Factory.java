package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInHistoryDetailViewModel_Factory implements Factory<CheckInHistoryDetailViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInHistoryDetailViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInHistoryDetailViewModel get() {
        return new CheckInHistoryDetailViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static CheckInHistoryDetailViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        return new CheckInHistoryDetailViewModel_Factory(provider, provider2);
    }

    public static CheckInHistoryDetailViewModel newInstance(Context context, CheckInRepository checkInRepository) {
        return new CheckInHistoryDetailViewModel(context, checkInRepository);
    }
}
