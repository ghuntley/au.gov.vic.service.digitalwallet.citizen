package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.checkInInput.CheckInPrimaryInputFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInPrimaryInputFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInPrimaryInputFragment {

    @Subcomponent
    public interface CheckInPrimaryInputFragmentSubcomponent extends AndroidInjector<CheckInPrimaryInputFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInPrimaryInputFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInPrimaryInputFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInPrimaryInputFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInPrimaryInputFragment() {
    }
}
