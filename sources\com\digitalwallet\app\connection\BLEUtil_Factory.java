package com.digitalwallet.app.connection;

import android.app.Application;
import com.digitalwallet.app.services.BluetoothEventsService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BLEUtil_Factory implements Factory<BLEUtil> {
    private final Provider<Application> applicationProvider;
    private final Provider<BluetoothEventsService> bluetoothEventsServiceProvider;

    public BLEUtil_Factory(Provider<Application> provider, Provider<BluetoothEventsService> provider2) {
        this.applicationProvider = provider;
        this.bluetoothEventsServiceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public BLEUtil get() {
        return new BLEUtil(this.applicationProvider.get(), this.bluetoothEventsServiceProvider.get());
    }

    public static BLEUtil_Factory create(Provider<Application> provider, Provider<BluetoothEventsService> provider2) {
        return new BLEUtil_Factory(provider, provider2);
    }

    public static BLEUtil newInstance(Application application, BluetoothEventsService bluetoothEventsService) {
        return new BLEUtil(application, bluetoothEventsService);
    }
}
