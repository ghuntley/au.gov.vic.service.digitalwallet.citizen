package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.EligibilityScannerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {EligibilityScannerFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributesEligibilityScannerFragment {

    @Subcomponent
    public interface EligibilityScannerFragmentSubcomponent extends AndroidInjector<EligibilityScannerFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<EligibilityScannerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(EligibilityScannerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(EligibilityScannerFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributesEligibilityScannerFragment() {
    }
}
