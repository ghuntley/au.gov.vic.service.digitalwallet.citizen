package com.digitalwallet.app.viewmodel.main;

import android.content.Context;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.services.BluetoothEventsService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HoldingListFragmentViewModel_Factory implements Factory<HoldingListFragmentViewModel> {
    private final Provider<BluetoothEventsService> bluetoothEventsServiceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<HoldingsService> holdingServiceProvider;

    public HoldingListFragmentViewModel_Factory(Provider<Context> provider, Provider<HoldingsService> provider2, Provider<BluetoothEventsService> provider3) {
        this.contextProvider = provider;
        this.holdingServiceProvider = provider2;
        this.bluetoothEventsServiceProvider = provider3;
    }

    @Override // javax.inject.Provider
    public HoldingListFragmentViewModel get() {
        return new HoldingListFragmentViewModel(this.contextProvider.get(), this.holdingServiceProvider.get(), this.bluetoothEventsServiceProvider.get());
    }

    public static HoldingListFragmentViewModel_Factory create(Provider<Context> provider, Provider<HoldingsService> provider2, Provider<BluetoothEventsService> provider3) {
        return new HoldingListFragmentViewModel_Factory(provider, provider2, provider3);
    }

    public static HoldingListFragmentViewModel newInstance(Context context, HoldingsService holdingsService, BluetoothEventsService bluetoothEventsService) {
        return new HoldingListFragmentViewModel(context, holdingsService, bluetoothEventsService);
    }
}
