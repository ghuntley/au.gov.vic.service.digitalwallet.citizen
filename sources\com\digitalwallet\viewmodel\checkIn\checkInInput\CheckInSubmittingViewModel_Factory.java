package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInSubmittingViewModel_Factory implements Factory<CheckInSubmittingViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;

    public CheckInSubmittingViewModel_Factory(Provider<CheckInRepository> provider) {
        this.checkInRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public CheckInSubmittingViewModel get() {
        return new CheckInSubmittingViewModel(this.checkInRepositoryProvider.get());
    }

    public static CheckInSubmittingViewModel_Factory create(Provider<CheckInRepository> provider) {
        return new CheckInSubmittingViewModel_Factory(provider);
    }

    public static CheckInSubmittingViewModel newInstance(CheckInRepository checkInRepository) {
        return new CheckInSubmittingViewModel(checkInRepository);
    }
}
