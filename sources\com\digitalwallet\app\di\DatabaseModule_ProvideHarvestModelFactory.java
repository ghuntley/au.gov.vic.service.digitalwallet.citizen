package com.digitalwallet.app.di;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DatabaseModule_ProvideHarvestModelFactory implements Factory<HarvestModel> {
    private final Provider<DigitalWalletDatabase> dbProvider;
    private final DatabaseModule module;

    public DatabaseModule_ProvideHarvestModelFactory(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        this.module = databaseModule;
        this.dbProvider = provider;
    }

    @Override // javax.inject.Provider
    public HarvestModel get() {
        return provideHarvestModel(this.module, this.dbProvider.get());
    }

    public static DatabaseModule_ProvideHarvestModelFactory create(DatabaseModule databaseModule, Provider<DigitalWalletDatabase> provider) {
        return new DatabaseModule_ProvideHarvestModelFactory(databaseModule, provider);
    }

    public static HarvestModel provideHarvestModel(DatabaseModule databaseModule, DigitalWalletDatabase digitalWalletDatabase) {
        return (HarvestModel) Preconditions.checkNotNull(databaseModule.provideHarvestModel(digitalWalletDatabase), "Cannot return null from a non-@Nullable @Provides method");
    }
}
