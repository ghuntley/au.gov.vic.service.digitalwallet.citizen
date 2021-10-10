package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class DaggerAppCompatActivity_MembersInjector implements MembersInjector<DaggerAppCompatActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerAppCompatActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerAppCompatActivity> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerAppCompatActivity_MembersInjector(provider);
    }

    public void injectMembers(DaggerAppCompatActivity daggerAppCompatActivity) {
        injectAndroidInjector(daggerAppCompatActivity, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DaggerAppCompatActivity daggerAppCompatActivity, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerAppCompatActivity.androidInjector = dispatchingAndroidInjector;
    }
}
