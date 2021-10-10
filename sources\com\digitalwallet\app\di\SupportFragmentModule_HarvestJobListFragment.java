package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestJobListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestJobListFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestJobListFragment {

    @Subcomponent
    public interface HarvestJobListFragmentSubcomponent extends AndroidInjector<HarvestJobListFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestJobListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestJobListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestJobListFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestJobListFragment() {
    }
}
