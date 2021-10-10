package com.digitalwallet.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;

public final class BaseModule_ProvideMainThreadFactory implements Factory<Scheduler> {
    private final BaseModule module;

    public BaseModule_ProvideMainThreadFactory(BaseModule baseModule) {
        this.module = baseModule;
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return provideMainThread(this.module);
    }

    public static BaseModule_ProvideMainThreadFactory create(BaseModule baseModule) {
        return new BaseModule_ProvideMainThreadFactory(baseModule);
    }

    public static Scheduler provideMainThread(BaseModule baseModule) {
        return (Scheduler) Preconditions.checkNotNull(baseModule.provideMainThread(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
