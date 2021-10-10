package com.digitalwallet.di;

import android.content.Context;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInSharedPreferences;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class BaseModule_ProvideCheckInSharedPreferencesFactory implements Factory<CheckInSharedPreferences> {
    private final Provider<Context> contextProvider;
    private final BaseModule module;
    private final Provider<Moshi> moshiProvider;

    public BaseModule_ProvideCheckInSharedPreferencesFactory(BaseModule baseModule, Provider<Context> provider, Provider<Moshi> provider2) {
        this.module = baseModule;
        this.contextProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInSharedPreferences get() {
        return provideCheckInSharedPreferences(this.module, this.contextProvider.get(), this.moshiProvider.get());
    }

    public static BaseModule_ProvideCheckInSharedPreferencesFactory create(BaseModule baseModule, Provider<Context> provider, Provider<Moshi> provider2) {
        return new BaseModule_ProvideCheckInSharedPreferencesFactory(baseModule, provider, provider2);
    }

    public static CheckInSharedPreferences provideCheckInSharedPreferences(BaseModule baseModule, Context context, Moshi moshi) {
        return (CheckInSharedPreferences) Preconditions.checkNotNull(baseModule.provideCheckInSharedPreferences(context, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
