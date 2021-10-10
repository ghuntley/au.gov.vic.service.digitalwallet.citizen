package com.digitalwallet.app.di;

import com.digitalwallet.app.api.DeviceRegisterApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideDeviceRegisterApiFactory implements Factory<DeviceRegisterApi> {
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApiModule_ProvideDeviceRegisterApiFactory(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = apiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public DeviceRegisterApi get() {
        return provideDeviceRegisterApi(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static ApiModule_ProvideDeviceRegisterApiFactory create(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new ApiModule_ProvideDeviceRegisterApiFactory(apiModule, provider, provider2);
    }

    public static DeviceRegisterApi provideDeviceRegisterApi(ApiModule apiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (DeviceRegisterApi) Preconditions.checkNotNull(apiModule.provideDeviceRegisterApi(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
