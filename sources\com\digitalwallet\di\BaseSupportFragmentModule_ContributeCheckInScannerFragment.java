package com.digitalwallet.di;

import com.digitalwallet.view.checkIn.CheckInScannerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInScannerFragmentSubcomponent.class})
public abstract class BaseSupportFragmentModule_ContributeCheckInScannerFragment {

    @Subcomponent
    public interface CheckInScannerFragmentSubcomponent extends AndroidInjector<CheckInScannerFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInScannerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInScannerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInScannerFragmentSubcomponent.Factory factory);

    private BaseSupportFragmentModule_ContributeCheckInScannerFragment() {
    }
}
