package com.digitalwallet.app.view.main;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class ServiceTypeFragment_MembersInjector implements MembersInjector<ServiceTypeFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public ServiceTypeFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<ServiceTypeFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new ServiceTypeFragment_MembersInjector(provider);
    }

    public void injectMembers(ServiceTypeFragment serviceTypeFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(serviceTypeFragment, this.androidInjectorProvider.get());
    }
}
