package com.digitalwallet.app.viewmodel.harvester;

import com.digitalwallet.app.model.db.harvester.HarvestModel;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HarvestJobWizardViewModel_Factory implements Factory<HarvestJobWizardViewModel> {
    private final Provider<HarvestModel> modelProvider;

    public HarvestJobWizardViewModel_Factory(Provider<HarvestModel> provider) {
        this.modelProvider = provider;
    }

    @Override // javax.inject.Provider
    public HarvestJobWizardViewModel get() {
        return new HarvestJobWizardViewModel(this.modelProvider.get());
    }

    public static HarvestJobWizardViewModel_Factory create(Provider<HarvestModel> provider) {
        return new HarvestJobWizardViewModel_Factory(provider);
    }

    public static HarvestJobWizardViewModel newInstance(HarvestModel harvestModel) {
        return new HarvestJobWizardViewModel(harvestModel);
    }
}
