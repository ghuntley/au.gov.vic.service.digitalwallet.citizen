package com.digitalwallet.app.services;

import android.content.Context;
import com.digitalwallet.app.api.AssetApi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AssetService_Factory implements Factory<AssetService> {
    private final Provider<AssetApi> assetApiProvider;
    private final Provider<Context> contextProvider;

    public AssetService_Factory(Provider<Context> provider, Provider<AssetApi> provider2) {
        this.contextProvider = provider;
        this.assetApiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AssetService get() {
        return new AssetService(this.contextProvider.get(), this.assetApiProvider.get());
    }

    public static AssetService_Factory create(Provider<Context> provider, Provider<AssetApi> provider2) {
        return new AssetService_Factory(provider, provider2);
    }

    public static AssetService newInstance(Context context, AssetApi assetApi) {
        return new AssetService(context, assetApi);
    }
}
