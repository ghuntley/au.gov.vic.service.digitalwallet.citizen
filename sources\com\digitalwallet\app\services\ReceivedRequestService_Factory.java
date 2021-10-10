package com.digitalwallet.app.services;

import dagger.internal.Factory;

public final class ReceivedRequestService_Factory implements Factory<ReceivedRequestService> {
    private static final ReceivedRequestService_Factory INSTANCE = new ReceivedRequestService_Factory();

    @Override // javax.inject.Provider
    public ReceivedRequestService get() {
        return new ReceivedRequestService();
    }

    public static ReceivedRequestService_Factory create() {
        return INSTANCE;
    }

    public static ReceivedRequestService newInstance() {
        return new ReceivedRequestService();
    }
}
