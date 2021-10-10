package dagger.android.support;

import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class DaggerDialogFragment_MembersInjector implements MembersInjector<DaggerDialogFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public DaggerDialogFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider) {
        this.androidInjectorProvider = provider;
    }

    public static MembersInjector<DaggerDialogFragment> create(Provider<DispatchingAndroidInjector<Object>> provider) {
        return new DaggerDialogFragment_MembersInjector(provider);
    }

    public void injectMembers(DaggerDialogFragment daggerDialogFragment) {
        injectAndroidInjector(daggerDialogFragment, this.androidInjectorProvider.get());
    }

    public static void injectAndroidInjector(DaggerDialogFragment daggerDialogFragment, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        daggerDialogFragment.androidInjector = dispatchingAndroidInjector;
    }
}
