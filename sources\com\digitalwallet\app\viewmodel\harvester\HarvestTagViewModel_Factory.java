package com.digitalwallet.app.viewmodel.harvester;

import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.services.ScannerViewService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HarvestTagViewModel_Factory implements Factory<HarvestTagViewModel> {
    private final Provider<HarvestDataService> harvestDataServiceProvider;
    private final Provider<HarvestModel> modelProvider;
    private final Provider<ScannerViewService> viewServiceProvider;

    public HarvestTagViewModel_Factory(Provider<HarvestModel> provider, Provider<ScannerViewService> provider2, Provider<HarvestDataService> provider3) {
        this.modelProvider = provider;
        this.viewServiceProvider = provider2;
        this.harvestDataServiceProvider = provider3;
    }

    @Override // javax.inject.Provider
    public HarvestTagViewModel get() {
        return new HarvestTagViewModel(this.modelProvider.get(), this.viewServiceProvider.get(), this.harvestDataServiceProvider.get());
    }

    public static HarvestTagViewModel_Factory create(Provider<HarvestModel> provider, Provider<ScannerViewService> provider2, Provider<HarvestDataService> provider3) {
        return new HarvestTagViewModel_Factory(provider, provider2, provider3);
    }

    public static HarvestTagViewModel newInstance(HarvestModel harvestModel, ScannerViewService scannerViewService, HarvestDataService harvestDataService) {
        return new HarvestTagViewModel(harvestModel, scannerViewService, harvestDataService);
    }
}
