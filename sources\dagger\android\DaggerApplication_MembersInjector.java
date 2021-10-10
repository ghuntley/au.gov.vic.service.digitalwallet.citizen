package dagger.android;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerApplication_MembersInjector implements MembersInjector<DaggerApplication> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerApplication_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerApplication> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerApplication_MembersInjector(provider);
    }

    public void injectMembers(DaggerApplication daggerApplication) {
        injectAndroidInjector(daggerApplication, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DaggerApplication daggerApplication, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerApplication.androidInjector = dispatchingAndroidInjector;
    }
}
