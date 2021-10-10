package dagger.android;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class DaggerActivity_MembersInjector implements MembersInjector<DaggerActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerActivity> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerActivity_MembersInjector(provider);
    }

    public void injectMembers(DaggerActivity daggerActivity) {
        injectAndroidInjector(daggerActivity, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DaggerActivity daggerActivity, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerActivity.androidInjector = dispatchingAndroidInjector;
    }
}
