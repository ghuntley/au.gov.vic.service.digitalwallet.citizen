package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.secure.SecureHoldingDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideSecureHoldingDaoFactory implements Factory<SecureHoldingDao> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideSecureHoldingDaoFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public SecureHoldingDao get() {
        return provideSecureHoldingDao(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_ProvideSecureHoldingDaoFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_ProvideSecureHoldingDaoFactory(databaseModule, provider);
    }

    public static SecureHoldingDao provideSecureHoldingDao(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (SecureHoldingDao) Preconditions.checkNotNull(databaseModule.provideSecureHoldingDao(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
