package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.AutoSyncFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AutoSyncFragmentSubcomponent.class})
public abstract class SupportFragmentModule_AutoSyncFragment {

    @Subcomponent
    public interface AutoSyncFragmentSubcomponent extends AndroidInjector<AutoSyncFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AutoSyncFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(AutoSyncFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AutoSyncFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_AutoSyncFragment() {
    }
}
