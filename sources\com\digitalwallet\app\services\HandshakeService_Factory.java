package com.digitalwallet.app.services;

import dagger.internal.Factory;

public final class HandshakeService_Factory implements Factory<HandshakeService> {
    private static final HandshakeService_Factory INSTANCE = new HandshakeService_Factory();

    @Override // javax.inject.Provider
    public HandshakeService get() {
        return new HandshakeService();
    }

    public static HandshakeService_Factory create() {
        return INSTANCE;
    }

    public static HandshakeService newInstance() {
        return new HandshakeService();
    }
}
