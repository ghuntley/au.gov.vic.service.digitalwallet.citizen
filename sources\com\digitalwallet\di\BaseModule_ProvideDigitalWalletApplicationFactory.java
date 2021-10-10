package com.digitalwallet.di;

import com.digitalwallet.DigitalWalletApplication;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BaseModule_ProvideDigitalWalletApplicationFactory implements Factory<DigitalWalletApplication> {
    private final BaseModule module;

    public BaseModule_ProvideDigitalWalletApplicationFactory(BaseModule baseModule) {
        this.module = baseModule;
    }

    @Override // javax.inject.Provider
    public DigitalWalletApplication get() {
        return provideDigitalWalletApplication(this.module);
    }

    public static BaseModule_ProvideDigitalWalletApplicationFactory create(BaseModule baseModule) {
        return new BaseModule_ProvideDigitalWalletApplicationFactory(baseModule);
    }

    public static DigitalWalletApplication provideDigitalWalletApplication(BaseModule baseModule) {
        return (DigitalWalletApplication) Preconditions.checkNotNull(baseModule.provideDigitalWalletApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
