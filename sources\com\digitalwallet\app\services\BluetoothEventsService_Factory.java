package com.digitalwallet.app.services;

import dagger.internal.Factory;

public final class BluetoothEventsService_Factory implements Factory<BluetoothEventsService> {
    private static final BluetoothEventsService_Factory INSTANCE = new BluetoothEventsService_Factory();

    @Override // javax.inject.Provider
    public BluetoothEventsService get() {
        return new BluetoothEventsService();
    }

    public static BluetoothEventsService_Factory create() {
        return INSTANCE;
    }

    public static BluetoothEventsService newInstance() {
        return new BluetoothEventsService();
    }
}
