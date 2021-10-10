package com.digitalwallet.app.services;

import android.content.Context;
import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HarvestDataService_Factory implements Factory<HarvestDataService> {
    private final Provider<Context> contextProvider;
    private final Provider<HarvestModel> harvestModelProvider;
    private final Provider<HoldingsApi> holdingsApiProvider;

    public HarvestDataService_Factory(Provider<HoldingsApi> provider, Provider<HarvestModel> provider2, Provider<Context> provider3) {
        this.holdingsApiProvider = provider;
        this.harvestModelProvider = provider2;
        this.contextProvider = provider3;
    }

    @Override // javax.inject.Provider
    public HarvestDataService get() {
        return new HarvestDataService(this.holdingsApiProvider.get(), this.harvestModelProvider.get(), this.contextProvider.get());
    }

    public static HarvestDataService_Factory create(Provider<HoldingsApi> provider, Provider<HarvestModel> provider2, Provider<Context> provider3) {
        return new HarvestDataService_Factory(provider, provider2, provider3);
    }

    public static HarvestDataService newInstance(HoldingsApi holdingsApi, HarvestModel harvestModel, Context context) {
        return new HarvestDataService(holdingsApi, harvestModel, context);
    }
}
