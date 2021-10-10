package com.digitalwallet.services;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ScannerViewService_Factory implements Factory<ScannerViewService> {
    private final Provider<Context> contextProvider;

    public ScannerViewService_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public ScannerViewService get() {
        return new ScannerViewService(this.contextProvider.get());
    }

    public static ScannerViewService_Factory create(Provider<Context> provider) {
        return new ScannerViewService_Factory(provider);
    }

    public static ScannerViewService newInstance(Context context) {
        return new ScannerViewService(context);
    }
}
