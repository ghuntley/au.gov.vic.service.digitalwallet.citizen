package com.digitalwallet.app.di;

import com.digitalwallet.app.api.UserApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideUserApiFactory implements Factory<UserApi> {
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApiModule_ProvideUserApiFactory(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = apiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public UserApi get() {
        return provideUserApi(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static ApiModule_ProvideUserApiFactory create(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new ApiModule_ProvideUserApiFactory(apiModule, provider, provider2);
    }

    public static UserApi provideUserApi(ApiModule apiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (UserApi) Preconditions.checkNotNull(apiModule.provideUserApi(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
