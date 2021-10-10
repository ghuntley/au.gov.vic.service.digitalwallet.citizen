package com.digitalwallet.app.di;

import com.digitalwallet.app.api.HoldingsApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideHoldingsApiFactory implements Factory<HoldingsApi> {
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApiModule_ProvideHoldingsApiFactory(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = apiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public HoldingsApi get() {
        return provideHoldingsApi(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static ApiModule_ProvideHoldingsApiFactory create(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new ApiModule_ProvideHoldingsApiFactory(apiModule, provider, provider2);
    }

    public static HoldingsApi provideHoldingsApi(ApiModule apiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (HoldingsApi) Preconditions.checkNotNull(apiModule.provideHoldingsApi(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
