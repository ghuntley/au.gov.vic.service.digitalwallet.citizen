package dagger.android;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerFragment_MembersInjector implements MembersInjector<DaggerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerFragment_MembersInjector(provider);
    }

    public void injectMembers(DaggerFragment daggerFragment) {
        injectAndroidInjector(daggerFragment, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DaggerFragment daggerFragment, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerFragment.androidInjector = dispatchingAndroidInjector;
    }
}
