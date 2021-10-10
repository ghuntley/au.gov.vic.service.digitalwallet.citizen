package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.unsecure.UnsecuredStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideUnSecureHoldingStoreFactory implements Factory<UnsecuredStore> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideUnSecureHoldingStoreFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public UnsecuredStore get() {
        return provideUnSecureHoldingStore(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_ProvideUnSecureHoldingStoreFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_ProvideUnSecureHoldingStoreFactory(databaseModule, provider);
    }

    public static UnsecuredStore provideUnSecureHoldingStore(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (UnsecuredStore) Preconditions.checkNotNull(databaseModule.provideUnSecureHoldingStore(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
