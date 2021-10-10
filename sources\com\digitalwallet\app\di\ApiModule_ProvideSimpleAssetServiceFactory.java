package com.digitalwallet.app.di;

import android.content.Context;
import com.digitalwallet.app.api.AssetApi;
import com.digitalwallet.app.services.SimpleAssetService;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiModule_ProvideSimpleAssetServiceFactory implements Factory<SimpleAssetService> {
    private final Provider<AssetApi> assetApiProvider;
    private final Provider<Context> contextProvider;
    private final ApiModule module;
    private final Provider<Moshi> moshiProvider;

    public ApiModule_ProvideSimpleAssetServiceFactory(ApiModule apiModule, Provider<Context> provider, Provider<AssetApi> provider2, Provider<Moshi> provider3) {
        this.module = apiModule;
        this.contextProvider = provider;
        this.assetApiProvider = provider2;
        this.moshiProvider = provider3;
    }

    @Override // javax.inject.Provider
    public SimpleAssetService get() {
        return provideSimpleAssetService(this.module, this.contextProvider.get(), this.assetApiProvider.get(), this.moshiProvider.get());
    }

    public static ApiModule_ProvideSimpleAssetServiceFactory create(ApiModule apiModule, Provider<Context> provider, Provider<AssetApi> provider2, Provider<Moshi> provider3) {
        return new ApiModule_ProvideSimpleAssetServiceFactory(apiModule, provider, provider2, provider3);
    }

    public static SimpleAssetService provideSimpleAssetService(ApiModule apiModule, Context context, AssetApi assetApi, Moshi moshi) {
        return (SimpleAssetService) Preconditions.checkNotNull(apiModule.provideSimpleAssetService(context, assetApi, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
