package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.checkInInput.CheckInAddDependantInputFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInAddDependantInputFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInAddDependantInputFragment {

    @Subcomponent
    public interface CheckInAddDependantInputFragmentSubcomponent extends AndroidInjector<CheckInAddDependantInputFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInAddDependantInputFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInAddDependantInputFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInAddDependantInputFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInAddDependantInputFragment() {
    }
}
