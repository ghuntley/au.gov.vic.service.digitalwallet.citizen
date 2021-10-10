package com.digitalwallet.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public final class BaseApiModule_ProvideOkHttpFactory implements Factory<OkHttpClient> {
    private final Provider<Cache> cacheProvider;
    private final BaseApiModule module;

    public BaseApiModule_ProvideOkHttpFactory(BaseApiModule baseApiModule, Provider<Cache> provider) {
        this.module = baseApiModule;
        this.cacheProvider = provider;
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideOkHttp(this.module, this.cacheProvider.get());
    }

    public static BaseApiModule_ProvideOkHttpFactory create(BaseApiModule baseApiModule, Provider<Cache> provider) {
        return new BaseApiModule_ProvideOkHttpFactory(baseApiModule, provider);
    }

    public static OkHttpClient provideOkHttp(BaseApiModule baseApiModule, Cache cache) {
        return (OkHttpClient) Preconditions.checkNotNull(baseApiModule.provideOkHttp(cache), "Cannot return null from a non-@Nullable @Provides method");
    }
}
