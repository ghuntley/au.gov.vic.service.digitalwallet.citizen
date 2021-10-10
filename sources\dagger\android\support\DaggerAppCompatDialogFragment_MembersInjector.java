package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class DaggerAppCompatDialogFragment_MembersInjector implements MembersInjector<DaggerAppCompatDialogFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerAppCompatDialogFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerAppCompatDialogFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerAppCompatDialogFragment_MembersInjector(provider);
    }

    public void injectMembers(DaggerAppCompatDialogFragment daggerAppCompatDialogFragment) {
        injectAndroidInjector(daggerAppCompatDialogFragment, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DaggerAppCompatDialogFragment daggerAppCompatDialogFragment, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerAppCompatDialogFragment.androidInjector = dispatchingAndroidInjector;
    }
}
