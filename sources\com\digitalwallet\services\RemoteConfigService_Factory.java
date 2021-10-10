package com.digitalwallet.services;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class RemoteConfigService_Factory implements Factory<RemoteConfigService> {
    private final Provider<OkHttpClient> httpClientProvider;
    private final Provider<Moshi> moshiProvider;

    public RemoteConfigService_Factory(Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.httpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public RemoteConfigService get() {
        return new RemoteConfigService(this.httpClientProvider.get(), this.moshiProvider.get());
    }

    public static RemoteConfigService_Factory create(Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new RemoteConfigService_Factory(provider, provider2);
    }

    public static RemoteConfigService newInstance(OkHttpClient okHttpClient, Moshi moshi) {
        return new RemoteConfigService(okHttpClient, moshi);
    }
}
