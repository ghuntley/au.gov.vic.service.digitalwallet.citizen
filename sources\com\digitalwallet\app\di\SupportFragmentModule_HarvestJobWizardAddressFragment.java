package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestJobWizardAddressFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestJobWizardAddressFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestJobWizardAddressFragment {

    @Subcomponent
    public interface HarvestJobWizardAddressFragmentSubcomponent extends AndroidInjector<HarvestJobWizardAddressFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestJobWizardAddressFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestJobWizardAddressFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestJobWizardAddressFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestJobWizardAddressFragment() {
    }
}
