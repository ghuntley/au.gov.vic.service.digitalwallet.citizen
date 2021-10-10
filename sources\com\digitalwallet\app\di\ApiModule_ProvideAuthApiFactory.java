package com.digitalwallet.app.di;

import com.digitalwallet.app.api.AuthApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideAuthApiFactory implements Factory<AuthApi> {
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApiModule_ProvideAuthApiFactory(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = apiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AuthApi get() {
        return provideAuthApi(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static ApiModule_ProvideAuthApiFactory create(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new ApiModule_ProvideAuthApiFactory(apiModule, provider, provider2);
    }

    public static AuthApi provideAuthApi(ApiModule apiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (AuthApi) Preconditions.checkNotNull(apiModule.provideAuthApi(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
