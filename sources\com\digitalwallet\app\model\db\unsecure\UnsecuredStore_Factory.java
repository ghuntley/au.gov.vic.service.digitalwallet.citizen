package com.digitalwallet.app.model.db.unsecure;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class UnsecuredStore_Factory implements Factory<UnsecuredStore> {
    private final Provider<UnsecuredHoldingDao> holdingDaoProvider;

    public UnsecuredStore_Factory(Provider<UnsecuredHoldingDao> provider) {
        this.holdingDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public UnsecuredStore get() {
        return new UnsecuredStore(this.holdingDaoProvider.get());
    }

    public static UnsecuredStore_Factory create(Provider<UnsecuredHoldingDao> provider) {
        return new UnsecuredStore_Factory(provider);
    }

    public static UnsecuredStore newInstance(UnsecuredHoldingDao unsecuredHoldingDao) {
        return new UnsecuredStore(unsecuredHoldingDao);
    }
}
