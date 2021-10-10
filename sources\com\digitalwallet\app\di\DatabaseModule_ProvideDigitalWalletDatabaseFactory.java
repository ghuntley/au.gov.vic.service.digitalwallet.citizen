package com.digitalwallet.app.di;

import android.content.Context;
import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideDigitalWalletDatabaseFactory implements Factory<DigitalWalletDatabase> {
    private final Provider<Context> contextProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideDigitalWalletDatabaseFactory(DatabaseModule databaseModule, Provider<Context> provider) {
        this.module = databaseModule;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public DigitalWalletDatabase get() {
        return provideDigitalWalletDatabase(this.module, this.contextProvider.get());
    }

    public static DatabaseModule_ProvideDigitalWalletDatabaseFactory create(DatabaseModule databaseModule, Provider<Context> provider) {
        return new DatabaseModule_ProvideDigitalWalletDatabaseFactory(databaseModule, provider);
    }

    public static DigitalWalletDatabase provideDigitalWalletDatabase(DatabaseModule databaseModule, Context context) {
        return (DigitalWalletDatabase) Preconditions.checkNotNull(databaseModule.provideDigitalWalletDatabase(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
