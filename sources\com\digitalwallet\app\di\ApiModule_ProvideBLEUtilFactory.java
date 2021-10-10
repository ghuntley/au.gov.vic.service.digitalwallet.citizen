package com.digitalwallet.app.di;

import android.app.Application;
import com.digitalwallet.app.connection.BLEUtil;
import com.digitalwallet.app.services.BluetoothEventsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ApiModule_ProvideBLEUtilFactory implements Factory<BLEUtil> {
    private final Provider<Application> applicationProvider;
    private final Provider<BluetoothEventsService> bluetoothEventsServiceProvider;
    private final ApiModule module;

    public ApiModule_ProvideBLEUtilFactory(ApiModule apiModule, Provider<Application> provider, Provider<BluetoothEventsService> provider2) {
        this.module = apiModule;
        this.applicationProvider = provider;
        this.bluetoothEventsServiceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public BLEUtil get() {
        return provideBLEUtil(this.module, this.applicationProvider.get(), this.bluetoothEventsServiceProvider.get());
    }

    public static ApiModule_ProvideBLEUtilFactory create(ApiModule apiModule, Provider<Application> provider, Provider<BluetoothEventsService> provider2) {
        return new ApiModule_ProvideBLEUtilFactory(apiModule, provider, provider2);
    }

    public static BLEUtil provideBLEUtil(ApiModule apiModule, Application application, BluetoothEventsService bluetoothEventsService) {
        return (BLEUtil) Preconditions.checkNotNull(apiModule.provideBLEUtil(application, bluetoothEventsService), "Cannot return null from a non-@Nullable @Provides method");
    }
}
