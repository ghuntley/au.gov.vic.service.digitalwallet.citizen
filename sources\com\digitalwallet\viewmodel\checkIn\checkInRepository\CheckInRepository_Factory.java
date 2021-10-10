package com.digitalwallet.viewmodel.checkIn.checkInRepository;

import android.content.Context;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInRepository_Factory implements Factory<CheckInRepository> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInApi> checkInApiProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<CheckInSharedPreferences> sharedPreferencesProvider;

    public CheckInRepository_Factory(Provider<Context> provider, Provider<Moshi> provider2, Provider<CheckInApi> provider3, Provider<CheckInSharedPreferences> provider4, Provider<AnalyticsHelper> provider5) {
        this.contextProvider = provider;
        this.moshiProvider = provider2;
        this.checkInApiProvider = provider3;
        this.sharedPreferencesProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider
    public CheckInRepository get() {
        return new CheckInRepository(this.contextProvider.get(), this.moshiProvider.get(), this.checkInApiProvider.get(), this.sharedPreferencesProvider.get(), this.analyticsProvider.get());
    }

    public static CheckInRepository_Factory create(Provider<Context> provider, Provider<Moshi> provider2, Provider<CheckInApi> provider3, Provider<CheckInSharedPreferences> provider4, Provider<AnalyticsHelper> provider5) {
        return new CheckInRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CheckInRepository newInstance(Context context, Moshi moshi, CheckInApi checkInApi, CheckInSharedPreferences checkInSharedPreferences, AnalyticsHelper analyticsHelper) {
        return new CheckInRepository(context, moshi, checkInApi, checkInSharedPreferences, analyticsHelper);
    }
}
