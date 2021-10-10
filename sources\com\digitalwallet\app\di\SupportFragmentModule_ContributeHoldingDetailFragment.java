package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.HoldingDetailFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HoldingDetailFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeHoldingDetailFragment {

    @Subcomponent
    public interface HoldingDetailFragmentSubcomponent extends AndroidInjector<HoldingDetailFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HoldingDetailFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HoldingDetailFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HoldingDetailFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeHoldingDetailFragment() {
    }
}
