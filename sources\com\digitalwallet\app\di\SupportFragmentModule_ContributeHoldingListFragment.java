package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.HoldingListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HoldingListFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeHoldingListFragment {

    @Subcomponent
    public interface HoldingListFragmentSubcomponent extends AndroidInjector<HoldingListFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HoldingListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HoldingListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HoldingListFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeHoldingListFragment() {
    }
}
