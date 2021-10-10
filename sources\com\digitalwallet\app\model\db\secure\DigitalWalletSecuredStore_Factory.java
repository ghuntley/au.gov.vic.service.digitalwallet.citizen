package com.digitalwallet.app.model.db.secure;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DigitalWalletSecuredStore_Factory implements Factory<DigitalWalletSecuredStore> {
    private final Provider<DigitalWalletDatabase> databaseProvider;

    public DigitalWalletSecuredStore_Factory(Provider<DigitalWalletDatabase> provider) {
        this.databaseProvider = provider;
    }

    @Override // javax.inject.Provider
    public DigitalWalletSecuredStore get() {
        return new DigitalWalletSecuredStore(this.databaseProvider.get());
    }

    public static DigitalWalletSecuredStore_Factory create(Provider<DigitalWalletDatabase> provider) {
        return new DigitalWalletSecuredStore_Factory(provider);
    }

    public static DigitalWalletSecuredStore newInstance(DigitalWalletDatabase digitalWalletDatabase) {
        return new DigitalWalletSecuredStore(digitalWalletDatabase);
    }
}
