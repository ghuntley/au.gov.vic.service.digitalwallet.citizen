package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.db.secure.DigitalWalletSecuredStore;
import com.digitalwallet.app.model.db.unsecure.UnsecuredStore;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HoldingsDbService_Factory implements Factory<HoldingsDbService> {
    private final Provider<DigitalWalletSecuredStore> securedStoreProvider;
    private final Provider<UnsecuredStore> unsecuredStoreProvider;

    public HoldingsDbService_Factory(Provider<DigitalWalletSecuredStore> provider, Provider<UnsecuredStore> provider2) {
        this.securedStoreProvider = provider;
        this.unsecuredStoreProvider = provider2;
    }

    @Override // javax.inject.Provider
    public HoldingsDbService get() {
        return new HoldingsDbService(this.securedStoreProvider.get(), this.unsecuredStoreProvider.get());
    }

    public static HoldingsDbService_Factory create(Provider<DigitalWalletSecuredStore> provider, Provider<UnsecuredStore> provider2) {
        return new HoldingsDbService_Factory(provider, provider2);
    }

    public static HoldingsDbService newInstance(DigitalWalletSecuredStore digitalWalletSecuredStore, UnsecuredStore unsecuredStore) {
        return new HoldingsDbService(digitalWalletSecuredStore, unsecuredStore);
    }
}
