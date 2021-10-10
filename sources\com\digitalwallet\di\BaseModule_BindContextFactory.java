package com.digitalwallet.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class BaseModule_BindContextFactory implements Factory<Context> {
    private final Provider<Application> applicationProvider;
    private final BaseModule module;

    public BaseModule_BindContextFactory(BaseModule baseModule, Provider<Application> provider) {
        this.module = baseModule;
        this.applicationProvider = provider;
    }

    @Override // javax.inject.Provider
    public Context get() {
        return bindContext(this.module, this.applicationProvider.get());
    }

    public static BaseModule_BindContextFactory create(BaseModule baseModule, Provider<Application> provider) {
        return new BaseModule_BindContextFactory(baseModule, provider);
    }

    public static Context bindContext(BaseModule baseModule, Application application) {
        return (Context) Preconditions.checkNotNull(baseModule.bindContext(application), "Cannot return null from a non-@Nullable @Provides method");
    }
}
