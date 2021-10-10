package com.digitalwallet.di;

import android.content.Context;
import com.digitalwallet.services.ScannerViewService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class BaseModule_ProvideScannerViewServiceFactory implements Factory<ScannerViewService> {
    private final Provider<Context> contextProvider;
    private final BaseModule module;

    public BaseModule_ProvideScannerViewServiceFactory(BaseModule baseModule, Provider<Context> provider) {
        this.module = baseModule;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public ScannerViewService get() {
        return provideScannerViewService(this.module, this.contextProvider.get());
    }

    public static BaseModule_ProvideScannerViewServiceFactory create(BaseModule baseModule, Provider<Context> provider) {
        return new BaseModule_ProvideScannerViewServiceFactory(baseModule, provider);
    }

    public static ScannerViewService provideScannerViewService(BaseModule baseModule, Context context) {
        return (ScannerViewService) Preconditions.checkNotNull(baseModule.provideScannerViewService(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
