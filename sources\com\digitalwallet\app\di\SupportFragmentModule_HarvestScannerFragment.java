package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestScannerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestScannerFragmentSubcomponent.class})
public abstract class SupportFragmentModule_HarvestScannerFragment {

    @Subcomponent
    public interface HarvestScannerFragmentSubcomponent extends AndroidInjector<HarvestScannerFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestScannerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestScannerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestScannerFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_HarvestScannerFragment() {
    }
}
