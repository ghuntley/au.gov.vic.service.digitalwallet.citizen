package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.scan.ScanDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideScanDaoFactory implements Factory<ScanDao> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideScanDaoFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public ScanDao get() {
        return provideScanDao(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_ProvideScanDaoFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_ProvideScanDaoFactory(databaseModule, provider);
    }

    public static ScanDao provideScanDao(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (ScanDao) Preconditions.checkNotNull(databaseModule.provideScanDao(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
