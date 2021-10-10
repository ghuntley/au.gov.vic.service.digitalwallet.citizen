package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInEditPersonInputViewModel_Factory implements Factory<CheckInEditPersonInputViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;

    public CheckInEditPersonInputViewModel_Factory(Provider<CheckInRepository> provider) {
        this.checkInRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public CheckInEditPersonInputViewModel get() {
        return new CheckInEditPersonInputViewModel(this.checkInRepositoryProvider.get());
    }

    public static CheckInEditPersonInputViewModel_Factory create(Provider<CheckInRepository> provider) {
        return new CheckInEditPersonInputViewModel_Factory(provider);
    }

    public static CheckInEditPersonInputViewModel newInstance(CheckInRepository checkInRepository) {
        return new CheckInEditPersonInputViewModel(checkInRepository);
    }
}
