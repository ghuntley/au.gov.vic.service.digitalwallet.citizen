package dagger.android;

import dagger.android.AndroidInjector;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class DispatchingAndroidInjector_Factory<T> implements Factory<DispatchingAndroidInjector<T>> {
    private final Provider<Map<Class<?>, Provider<AndroidInjector.Factory<?>>>> injectorFactoriesWithClassKeysProvider;
    private final Provider<Map<String, Provider<AndroidInjector.Factory<?>>>> injectorFactoriesWithStringKeysProvider;

    public DispatchingAndroidInjector_Factory(Provider<Map<Class<?>, Provider<AndroidInjector.Factory<?>>>> provider, Provider<Map<String, Provider<AndroidInjector.Factory<?>>>> provider2) {
        this.injectorFactoriesWithClassKeysProvider = provider;
        this.injectorFactoriesWithStringKeysProvider = provider2;
    }

    @Override // javax.inject.Provider
    public DispatchingAndroidInjector<T> get() {
        return new DispatchingAndroidInjector<>(this.injectorFactoriesWithClassKeysProvider.get(), this.injectorFactoriesWithStringKeysProvider.get());
    }

    public static <T> DispatchingAndroidInjector_Factory<T> create(Provider<Map<Class<?>, Provider<AndroidInjector.Factory<?>>>> provider, Provider<Map<String, Provider<AndroidInjector.Factory<?>>>> provider2) {
        return new DispatchingAndroidInjector_Factory<>(provider, provider2);
    }

    public static <T> DispatchingAndroidInjector<T> newInstance(Map<Class<?>, Provider<AndroidInjector.Factory<?>>> map, Map<String, Provider<AndroidInjector.Factory<?>>> map2) {
        return new DispatchingAndroidInjector<>(map, map2);
    }
}
