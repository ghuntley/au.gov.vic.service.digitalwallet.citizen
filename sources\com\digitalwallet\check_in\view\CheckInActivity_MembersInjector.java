package com.digitalwallet.check_in.view;

import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.squareup.moshi.Moshi;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CheckInActivity_MembersInjector implements MembersInjector<CheckInActivity> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Moshi> moshiProvider;

    public CheckInActivity_MembersInjector(Provider<Moshi> provider, Provider<AnalyticsHelper> provider2, Provider<CheckInRepository> provider3) {
        this.moshiProvider = provider;
        this.analyticsProvider = provider2;
        this.checkInRepositoryProvider = provider3;
    }

    public static MembersInjector<CheckInActivity> create(Provider<Moshi> provider, Provider<AnalyticsHelper> provider2, Provider<CheckInRepository> provider3) {
        return new CheckInActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInActivity checkInActivity) {
        injectMoshi(checkInActivity, this.moshiProvider.get());
        injectAnalytics(checkInActivity, this.analyticsProvider.get());
        injectCheckInRepository(checkInActivity, this.checkInRepositoryProvider.get());
    }

    public static void injectMoshi(CheckInActivity checkInActivity, Moshi moshi) {
        checkInActivity.moshi = moshi;
    }

    public static void injectAnalytics(CheckInActivity checkInActivity, AnalyticsHelper analyticsHelper) {
        checkInActivity.analytics = analyticsHelper;
    }

    public static void injectCheckInRepository(CheckInActivity checkInActivity, CheckInRepository checkInRepository) {
        checkInActivity.checkInRepository = checkInRepository;
    }
}
