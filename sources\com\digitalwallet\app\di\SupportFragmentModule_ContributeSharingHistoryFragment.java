package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.SharingHistoryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SharingHistoryFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeSharingHistoryFragment {

    @Subcomponent
    public interface SharingHistoryFragmentSubcomponent extends AndroidInjector<SharingHistoryFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SharingHistoryFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(SharingHistoryFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SharingHistoryFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeSharingHistoryFragment() {
    }
}
