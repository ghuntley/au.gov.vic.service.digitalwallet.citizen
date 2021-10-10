package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestJobWizardZoneFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestJobWizardZoneFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestJobWizardZoneFragment {

    @Subcomponent
    public interface HarvestJobWizardZoneFragmentSubcomponent extends AndroidInjector<HarvestJobWizardZoneFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestJobWizardZoneFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestJobWizardZoneFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestJobWizardZoneFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestJobWizardZoneFragment() {
    }
}
