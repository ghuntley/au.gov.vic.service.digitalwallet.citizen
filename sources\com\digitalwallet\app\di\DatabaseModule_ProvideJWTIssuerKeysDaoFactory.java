package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.secure.JWTIssuerKeysDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideJWTIssuerKeysDaoFactory implements Factory<JWTIssuerKeysDao> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideJWTIssuerKeysDaoFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public JWTIssuerKeysDao get() {
        return provideJWTIssuerKeysDao(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_ProvideJWTIssuerKeysDaoFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_ProvideJWTIssuerKeysDaoFactory(databaseModule, provider);
    }

    public static JWTIssuerKeysDao provideJWTIssuerKeysDao(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (JWTIssuerKeysDao) Preconditions.checkNotNull(databaseModule.provideJWTIssuerKeysDao(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
