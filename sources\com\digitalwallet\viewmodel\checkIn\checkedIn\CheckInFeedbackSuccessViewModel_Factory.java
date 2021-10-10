package com.digitalwallet.viewmodel.checkIn.checkedIn;

import android.content.Context;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInFeedbackSuccessViewModel_Factory implements Factory<CheckInFeedbackSuccessViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInFeedbackSuccessViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInFeedbackSuccessViewModel get() {
        return new CheckInFeedbackSuccessViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static CheckInFeedbackSuccessViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        return new CheckInFeedbackSuccessViewModel_Factory(provider, provider2);
    }

    public static CheckInFeedbackSuccessViewModel newInstance(Context context, CheckInRepository checkInRepository) {
        return new CheckInFeedbackSuccessViewModel(context, checkInRepository);
    }
}
