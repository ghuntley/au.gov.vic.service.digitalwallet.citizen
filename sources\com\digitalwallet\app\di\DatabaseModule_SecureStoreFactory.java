package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.secure.SecureStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_SecureStoreFactory implements Factory<SecureStore> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_SecureStoreFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public SecureStore get() {
        return secureStore(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_SecureStoreFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_SecureStoreFactory(databaseModule, provider);
    }

    public static SecureStore secureStore(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (SecureStore) Preconditions.checkNotNull(databaseModule.secureStore(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
