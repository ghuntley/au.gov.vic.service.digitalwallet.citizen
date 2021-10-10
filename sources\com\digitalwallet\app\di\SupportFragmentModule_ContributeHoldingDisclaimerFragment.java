package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.HoldingDisclaimerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HoldingDisclaimerFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeHoldingDisclaimerFragment {

    @Subcomponent
    public interface HoldingDisclaimerFragmentSubcomponent extends AndroidInjector<HoldingDisclaimerFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HoldingDisclaimerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HoldingDisclaimerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HoldingDisclaimerFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeHoldingDisclaimerFragment() {
    }
}
