package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestTagSummaryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestTagSummaryFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestTagSummaryFragment {

    @Subcomponent
    public interface HarvestTagSummaryFragmentSubcomponent extends AndroidInjector<HarvestTagSummaryFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestTagSummaryFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestTagSummaryFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestTagSummaryFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestTagSummaryFragment() {
    }
}
