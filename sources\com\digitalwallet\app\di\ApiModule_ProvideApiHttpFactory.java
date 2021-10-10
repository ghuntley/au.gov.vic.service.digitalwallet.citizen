package com.digitalwallet.app.di;

import com.digitalwallet.app.oidc.OIDCRequestHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideApiHttpFactory implements Factory<OkHttpClient> {
    private final Provider<Cache> cacheProvider;
    private final ApiModule module;
    private final Provider<OIDCRequestHandler> oidcRequestHandlerProvider;

    public ApiModule_ProvideApiHttpFactory(ApiModule apiModule, Provider<Cache> provider, Provider<OIDCRequestHandler> provider2) {
        this.module = apiModule;
        this.cacheProvider = provider;
        this.oidcRequestHandlerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideApiHttp(this.module, this.cacheProvider.get(), this.oidcRequestHandlerProvider.get());
    }

    public static ApiModule_ProvideApiHttpFactory create(ApiModule apiModule, Provider<Cache> provider, Provider<OIDCRequestHandler> provider2) {
        return new ApiModule_ProvideApiHttpFactory(apiModule, provider, provider2);
    }

    public static OkHttpClient provideApiHttp(ApiModule apiModule, Cache cache, OIDCRequestHandler oIDCRequestHandler) {
        return (OkHttpClient) Preconditions.checkNotNull(apiModule.provideApiHttp(cache, oIDCRequestHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
