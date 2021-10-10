package com.digitalwallet.app.model.db.shares;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ShareRecordStore_Factory implements Factory<ShareRecordStore> {
    private final Provider<ShareRecordDao> shareRecordDaoProvider;

    public ShareRecordStore_Factory(Provider<ShareRecordDao> provider) {
        this.shareRecordDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public ShareRecordStore get() {
        return new ShareRecordStore(this.shareRecordDaoProvider.get());
    }

    public static ShareRecordStore_Factory create(Provider<ShareRecordDao> provider) {
        return new ShareRecordStore_Factory(provider);
    }

    public static ShareRecordStore newInstance(ShareRecordDao shareRecordDao) {
        return new ShareRecordStore(shareRecordDao);
    }
}
