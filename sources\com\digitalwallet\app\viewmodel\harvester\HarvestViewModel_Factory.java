package com.digitalwallet.app.viewmodel.harvester;

import com.digitalwallet.app.model.db.DigitalWalletDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HarvestViewModel_Factory implements Factory<HarvestViewModel> {
    private final Provider<DigitalWalletDatabase> databaseProvider;

    public HarvestViewModel_Factory(Provider<DigitalWalletDatabase> provider) {
        this.databaseProvider = provider;
    }

    @Override // javax.inject.Provider
    public HarvestViewModel get() {
        return new HarvestViewModel(this.databaseProvider.get());
    }

    public static HarvestViewModel_Factory create(Provider<DigitalWalletDatabase> provider) {
        return new HarvestViewModel_Factory(provider);
    }

    public static HarvestViewModel newInstance(DigitalWalletDatabase digitalWalletDatabase) {
        return new HarvestViewModel(digitalWalletDatabase);
    }
}
