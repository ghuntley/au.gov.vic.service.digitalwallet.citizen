package com.digitalwallet.app.di;

import com.digitalwallet.app.api.ConfigApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

public final class ApiModule_ProvideConfigApiFactory implements Factory<ConfigApi> {
    private final Provider<Converter.Factory> converterFactoryProvider;
    private final ApiModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApiModule_ProvideConfigApiFactory(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Converter.Factory> provider2) {
        this.module = apiModule;
        this.okHttpClientProvider = provider;
        this.converterFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ConfigApi get() {
        return provideConfigApi(this.module, this.okHttpClientProvider.get(), this.converterFactoryProvider.get());
    }

    public static ApiModule_ProvideConfigApiFactory create(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Converter.Factory> provider2) {
        return new ApiModule_ProvideConfigApiFactory(apiModule, provider, provider2);
    }

    public static ConfigApi provideConfigApi(ApiModule apiModule, OkHttpClient okHttpClient, Converter.Factory factory) {
        return (ConfigApi) Preconditions.checkNotNull(apiModule.provideConfigApi(okHttpClient, factory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
