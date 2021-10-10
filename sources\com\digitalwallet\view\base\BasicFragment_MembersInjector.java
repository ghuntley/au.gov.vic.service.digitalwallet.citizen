package com.digitalwallet.view.base;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class BasicFragment_MembersInjector implements MembersInjector<BasicFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public BasicFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<BasicFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new BasicFragment_MembersInjector(provider);
    }

    public void injectMembers(BasicFragment basicFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(basicFragment, this.androidInjectorProvider.get());
    }
}
