package com.digitalwallet.di;

import android.content.Context;
import com.digitalwallet.api.CheckInApi;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInSharedPreferences;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class BaseModule_ProvideCheckInRepositoryFactory implements Factory<CheckInRepository> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<CheckInApi> checkInApiProvider;
    private final Provider<Context> contextProvider;
    private final BaseModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<CheckInSharedPreferences> sharedPreferencesProvider;

    public BaseModule_ProvideCheckInRepositoryFactory(BaseModule baseModule, Provider<Context> provider, Provider<Moshi> provider2, Provider<CheckInApi> provider3, Provider<CheckInSharedPreferences> provider4, Provider<AnalyticsHelper> provider5) {
        this.module = baseModule;
        this.contextProvider = provider;
        this.moshiProvider = provider2;
        this.checkInApiProvider = provider3;
        this.sharedPreferencesProvider = provider4;
        this.analyticsProvider = provider5;
    }

    @Override // javax.inject.Provider
    public CheckInRepository get() {
        return provideCheckInRepository(this.module, this.contextProvider.get(), this.moshiProvider.get(), this.checkInApiProvider.get(), this.sharedPreferencesProvider.get(), this.analyticsProvider.get());
    }

    public static BaseModule_ProvideCheckInRepositoryFactory create(BaseModule baseModule, Provider<Context> provider, Provider<Moshi> provider2, Provider<CheckInApi> provider3, Provider<CheckInSharedPreferences> provider4, Provider<AnalyticsHelper> provider5) {
        return new BaseModule_ProvideCheckInRepositoryFactory(baseModule, provider, provider2, provider3, provider4, provider5);
    }

    public static CheckInRepository provideCheckInRepository(BaseModule baseModule, Context context, Moshi moshi, CheckInApi checkInApi, CheckInSharedPreferences checkInSharedPreferences, AnalyticsHelper analyticsHelper) {
        return (CheckInRepository) Preconditions.checkNotNull(baseModule.provideCheckInRepository(context, moshi, checkInApi, checkInSharedPreferences, analyticsHelper), "Cannot return null from a non-@Nullable @Provides method");
    }
}
