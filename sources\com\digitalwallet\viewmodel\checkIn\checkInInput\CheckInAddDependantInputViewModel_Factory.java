package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInAddDependantInputViewModel_Factory implements Factory<CheckInAddDependantInputViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;

    public CheckInAddDependantInputViewModel_Factory(Provider<CheckInRepository> provider) {
        this.checkInRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public CheckInAddDependantInputViewModel get() {
        return new CheckInAddDependantInputViewModel(this.checkInRepositoryProvider.get());
    }

    public static CheckInAddDependantInputViewModel_Factory create(Provider<CheckInRepository> provider) {
        return new CheckInAddDependantInputViewModel_Factory(provider);
    }

    public static CheckInAddDependantInputViewModel newInstance(CheckInRepository checkInRepository) {
        return new CheckInAddDependantInputViewModel(checkInRepository);
    }
}
