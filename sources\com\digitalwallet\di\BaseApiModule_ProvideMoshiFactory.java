package com.digitalwallet.di;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BaseApiModule_ProvideMoshiFactory implements Factory<Moshi> {
    private final BaseApiModule module;

    public BaseApiModule_ProvideMoshiFactory(BaseApiModule baseApiModule) {
        this.module = baseApiModule;
    }

    @Override // javax.inject.Provider
    public Moshi get() {
        return provideMoshi(this.module);
    }

    public static BaseApiModule_ProvideMoshiFactory create(BaseApiModule baseApiModule) {
        return new BaseApiModule_ProvideMoshiFactory(baseApiModule);
    }

    public static Moshi provideMoshi(BaseApiModule baseApiModule) {
        return (Moshi) Preconditions.checkNotNull(baseApiModule.provideMoshi(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
