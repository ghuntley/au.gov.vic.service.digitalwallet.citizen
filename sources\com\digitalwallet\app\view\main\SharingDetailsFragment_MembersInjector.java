package com.digitalwallet.app.view.main;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class SharingDetailsFragment_MembersInjector implements MembersInjector<SharingDetailsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public SharingDetailsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<SharingDetailsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new SharingDetailsFragment_MembersInjector(provider);
    }

    public void injectMembers(SharingDetailsFragment sharingDetailsFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(sharingDetailsFragment, this.androidInjectorProvider.get());
    }
}
