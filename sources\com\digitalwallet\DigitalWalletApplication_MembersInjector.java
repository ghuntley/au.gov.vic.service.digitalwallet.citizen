package com.digitalwallet;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class DigitalWalletApplication_MembersInjector implements MembersInjector<DigitalWalletApplication> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DigitalWalletApplication_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DigitalWalletApplication> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DigitalWalletApplication_MembersInjector(provider);
    }

    public void injectMembers(DigitalWalletApplication digitalWalletApplication) {
        injectAndroidInjector(digitalWalletApplication, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DigitalWalletApplication digitalWalletApplication, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        digitalWalletApplication.androidInjector = dispatchingAndroidInjector;
    }
}
