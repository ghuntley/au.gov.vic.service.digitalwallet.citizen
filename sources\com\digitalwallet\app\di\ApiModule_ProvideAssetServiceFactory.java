package com.digitalwallet.app.di;

import android.content.Context;
import com.digitalwallet.app.api.AssetApi;
import com.digitalwallet.app.services.AssetService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiModule_ProvideAssetServiceFactory implements Factory<AssetService> {
    private final Provider<AssetApi> assetApiProvider;
    private final Provider<Context> contextProvider;
    private final ApiModule module;

    public ApiModule_ProvideAssetServiceFactory(ApiModule apiModule, Provider<Context> provider, Provider<AssetApi> provider2) {
        this.module = apiModule;
        this.contextProvider = provider;
        this.assetApiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AssetService get() {
        return provideAssetService(this.module, this.contextProvider.get(), this.assetApiProvider.get());
    }

    public static ApiModule_ProvideAssetServiceFactory create(ApiModule apiModule, Provider<Context> provider, Provider<AssetApi> provider2) {
        return new ApiModule_ProvideAssetServiceFactory(apiModule, provider, provider2);
    }

    public static AssetService provideAssetService(ApiModule apiModule, Context context, AssetApi assetApi) {
        return (AssetService) Preconditions.checkNotNull(apiModule.provideAssetService(context, assetApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
