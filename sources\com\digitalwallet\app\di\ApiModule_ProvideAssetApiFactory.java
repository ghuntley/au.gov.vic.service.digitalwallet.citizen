package com.digitalwallet.app.di;

import com.digitalwallet.app.api.AssetApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ApiModule_ProvideAssetApiFactory implements Factory<AssetApi> {
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public ApiModule_ProvideAssetApiFactory(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.module = apiModule;
        this.okHttpClientProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AssetApi get() {
        return provideAssetApi(this.module, this.okHttpClientProvider.get(), this.moshiProvider.get());
    }

    public static ApiModule_ProvideAssetApiFactory create(ApiModule apiModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new ApiModule_ProvideAssetApiFactory(apiModule, provider, provider2);
    }

    public static AssetApi provideAssetApi(ApiModule apiModule, OkHttpClient okHttpClient, Moshi moshi) {
        return (AssetApi) Preconditions.checkNotNull(apiModule.provideAssetApi(okHttpClient, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
