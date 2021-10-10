package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestTagManualEntryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestTagManualEntryFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestTagManualEntryFragment {

    @Subcomponent
    public interface HarvestTagManualEntryFragmentSubcomponent extends AndroidInjector<HarvestTagManualEntryFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestTagManualEntryFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestTagManualEntryFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestTagManualEntryFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestTagManualEntryFragment() {
    }
}
