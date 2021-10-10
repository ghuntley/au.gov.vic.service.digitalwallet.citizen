package com.digitalwallet.di;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Cache;

public final class BaseApiModule_ProvideHttpCacheFactory implements Factory<Cache> {
    private final Provider<Application> applicationProvider;
    private final BaseApiModule module;

    public BaseApiModule_ProvideHttpCacheFactory(BaseApiModule baseApiModule, Provider<Application> provider) {
        this.module = baseApiModule;
        this.applicationProvider = provider;
    }

    @Override // javax.inject.Provider
    public Cache get() {
        return provideHttpCache(this.module, this.applicationProvider.get());
    }

    public static BaseApiModule_ProvideHttpCacheFactory create(BaseApiModule baseApiModule, Provider<Application> provider) {
        return new BaseApiModule_ProvideHttpCacheFactory(baseApiModule, provider);
    }

    public static Cache provideHttpCache(BaseApiModule baseApiModule, Application application) {
        return (Cache) Preconditions.checkNotNull(baseApiModule.provideHttpCache(application), "Cannot return null from a non-@Nullable @Provides method");
    }
}
