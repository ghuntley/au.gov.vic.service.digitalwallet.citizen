package com.digitalwallet.app.di;

import com.digitalwallet.app.services.BluetoothEventsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiModule_ProvideBluetoothEventsServiceFactory implements Factory<BluetoothEventsService> {
    private final ApiModule module;

    public ApiModule_ProvideBluetoothEventsServiceFactory(ApiModule apiModule) {
        this.module = apiModule;
    }

    @Override // javax.inject.Provider
    public BluetoothEventsService get() {
        return provideBluetoothEventsService(this.module);
    }

    public static ApiModule_ProvideBluetoothEventsServiceFactory create(ApiModule apiModule) {
        return new ApiModule_ProvideBluetoothEventsServiceFactory(apiModule);
    }

    public static BluetoothEventsService provideBluetoothEventsService(ApiModule apiModule) {
        return (BluetoothEventsService) Preconditions.checkNotNull(apiModule.provideBluetoothEventsService(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
