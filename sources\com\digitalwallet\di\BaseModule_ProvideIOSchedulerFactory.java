package com.digitalwallet.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;

public final class BaseModule_ProvideIOSchedulerFactory implements Factory<Scheduler> {
    private final BaseModule module;

    public BaseModule_ProvideIOSchedulerFactory(BaseModule baseModule) {
        this.module = baseModule;
    }

    @Override // javax.inject.Provider
    public Scheduler get() {
        return provideIOScheduler(this.module);
    }

    public static BaseModule_ProvideIOSchedulerFactory create(BaseModule baseModule) {
        return new BaseModule_ProvideIOSchedulerFactory(baseModule);
    }

    public static Scheduler provideIOScheduler(BaseModule baseModule) {
        return (Scheduler) Preconditions.checkNotNull(baseModule.provideIOScheduler(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
