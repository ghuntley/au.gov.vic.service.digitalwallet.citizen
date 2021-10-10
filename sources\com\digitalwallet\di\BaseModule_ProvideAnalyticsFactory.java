package com.digitalwallet.di;

import android.content.Context;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class BaseModule_ProvideAnalyticsFactory implements Factory<AnalyticsHelper> {
    private final Provider<Context> contextProvider;
    private final BaseModule module;

    public BaseModule_ProvideAnalyticsFactory(BaseModule baseModule, Provider<Context> provider) {
        this.module = baseModule;
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public AnalyticsHelper get() {
        return provideAnalytics(this.module, this.contextProvider.get());
    }

    public static BaseModule_ProvideAnalyticsFactory create(BaseModule baseModule, Provider<Context> provider) {
        return new BaseModule_ProvideAnalyticsFactory(baseModule, provider);
    }

    public static AnalyticsHelper provideAnalytics(BaseModule baseModule, Context context) {
        return (AnalyticsHelper) Preconditions.checkNotNull(baseModule.provideAnalytics(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
