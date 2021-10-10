package com.digitalwallet.app.services;

import android.content.Context;
import com.digitalwallet.app.api.AssetApi;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SimpleAssetService_Factory implements Factory<SimpleAssetService> {
    private final Provider<AssetApi> assetApiProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Moshi> moshiProvider;

    public SimpleAssetService_Factory(Provider<Context> provider, Provider<AssetApi> provider2, Provider<Moshi> provider3) {
        this.contextProvider = provider;
        this.assetApiProvider = provider2;
        this.moshiProvider = provider3;
    }

    @Override // javax.inject.Provider
    public SimpleAssetService get() {
        return new SimpleAssetService(this.contextProvider.get(), this.assetApiProvider.get(), this.moshiProvider.get());
    }

    public static SimpleAssetService_Factory create(Provider<Context> provider, Provider<AssetApi> provider2, Provider<Moshi> provider3) {
        return new SimpleAssetService_Factory(provider, provider2, provider3);
    }

    public static SimpleAssetService newInstance(Context context, AssetApi assetApi, Moshi moshi) {
        return new SimpleAssetService(context, assetApi, moshi);
    }
}
