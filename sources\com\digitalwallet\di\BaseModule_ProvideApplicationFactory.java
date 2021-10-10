package com.digitalwallet.di;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BaseModule_ProvideApplicationFactory implements Factory<Application> {
    private final BaseModule module;

    public BaseModule_ProvideApplicationFactory(BaseModule baseModule) {
        this.module = baseModule;
    }

    @Override // javax.inject.Provider
    public Application get() {
        return provideApplication(this.module);
    }

    public static BaseModule_ProvideApplicationFactory create(BaseModule baseModule) {
        return new BaseModule_ProvideApplicationFactory(baseModule);
    }

    public static Application provideApplication(BaseModule baseModule) {
        return (Application) Preconditions.checkNotNull(baseModule.provideApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
