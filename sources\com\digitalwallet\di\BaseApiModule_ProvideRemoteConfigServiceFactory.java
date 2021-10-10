package com.digitalwallet.di;

import com.digitalwallet.services.RemoteConfigService;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class BaseApiModule_ProvideRemoteConfigServiceFactory implements Factory<RemoteConfigService> {
    private final BaseApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public BaseApiModule_ProvideRemoteConfigServiceFactory(BaseApiModule baseApiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = baseApiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public RemoteConfigService get() {
        return provideRemoteConfigService(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static BaseApiModule_ProvideRemoteConfigServiceFactory create(BaseApiModule baseApiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new BaseApiModule_ProvideRemoteConfigServiceFactory(baseApiModule, provider, provider2);
    }

    public static RemoteConfigService provideRemoteConfigService(BaseApiModule baseApiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (RemoteConfigService) Preconditions.checkNotNull(baseApiModule.provideRemoteConfigService(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
