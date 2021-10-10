package com.digitalwallet.di;

import com.digitalwallet.api.CheckInApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class BaseApiModule_ProvideCheckInApiFactory implements Factory<CheckInApi> {
    private final BaseApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public BaseApiModule_ProvideCheckInApiFactory(BaseApiModule baseApiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = baseApiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInApi get() {
        return provideCheckInApi(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static BaseApiModule_ProvideCheckInApiFactory create(BaseApiModule baseApiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new BaseApiModule_ProvideCheckInApiFactory(baseApiModule, provider, provider2);
    }

    public static CheckInApi provideCheckInApi(BaseApiModule baseApiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (CheckInApi) Preconditions.checkNotNull(baseApiModule.provideCheckInApi(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
