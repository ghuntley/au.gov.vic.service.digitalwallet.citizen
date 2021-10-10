package com.digitalwallet.app.services;

import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TransactionSharesService_Factory implements Factory<TransactionSharesService> {
    private final Provider<HoldingsApi> apiProvider;
    private final Provider<ShareRecordStore> shareStoreProvider;

    public TransactionSharesService_Factory(Provider<HoldingsApi> provider, Provider<ShareRecordStore> provider2) {
        this.apiProvider = provider;
        this.shareStoreProvider = provider2;
    }

    @Override // javax.inject.Provider
    public TransactionSharesService get() {
        return new TransactionSharesService(this.apiProvider.get(), this.shareStoreProvider.get());
    }

    public static TransactionSharesService_Factory create(Provider<HoldingsApi> provider, Provider<ShareRecordStore> provider2) {
        return new TransactionSharesService_Factory(provider, provider2);
    }

    public static TransactionSharesService newInstance(HoldingsApi holdingsApi, ShareRecordStore shareRecordStore) {
        return new TransactionSharesService(holdingsApi, shareRecordStore);
    }
}
