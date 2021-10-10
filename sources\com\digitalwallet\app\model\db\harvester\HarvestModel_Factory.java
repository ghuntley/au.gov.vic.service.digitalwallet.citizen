package com.digitalwallet.app.model.db.harvester;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HarvestModel_Factory implements Factory<HarvestModel> {
    private final Provider<DigitalWalletDatabase> databaseProvider;

    public HarvestModel_Factory(Provider<DigitalWalletDatabase> provider) {
        this.databaseProvider = provider;
    }

    @Override // javax.inject.Provider
    public HarvestModel get() {
        return new HarvestModel(this.databaseProvider.get());
    }

    public static HarvestModel_Factory create(Provider<DigitalWalletDatabase> provider) {
        return new HarvestModel_Factory(provider);
    }

    public static HarvestModel newInstance(DigitalWalletDatabase digitalWalletDatabase) {
        return new HarvestModel(digitalWalletDatabase);
    }
}
