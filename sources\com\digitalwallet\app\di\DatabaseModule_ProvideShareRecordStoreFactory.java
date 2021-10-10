package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideShareRecordStoreFactory implements Factory<ShareRecordStore> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideShareRecordStoreFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public ShareRecordStore get() {
        return provideShareRecordStore(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_ProvideShareRecordStoreFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_ProvideShareRecordStoreFactory(databaseModule, provider);
    }

    public static ShareRecordStore provideShareRecordStore(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (ShareRecordStore) Preconditions.checkNotNull(databaseModule.provideShareRecordStore(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
