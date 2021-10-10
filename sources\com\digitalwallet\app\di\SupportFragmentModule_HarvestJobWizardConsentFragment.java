package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestJobWizardConsentFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestJobWizardConsentFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestJobWizardConsentFragment {

    @Subcomponent
    public interface HarvestJobWizardConsentFragmentSubcomponent extends AndroidInjector<HarvestJobWizardConsentFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestJobWizardConsentFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestJobWizardConsentFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestJobWizardConsentFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestJobWizardConsentFragment() {
    }
}
