package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.checkedIn.CheckInSuccessFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInSuccessFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInSuccessFragment {

    @Subcomponent
    public interface CheckInSuccessFragmentSubcomponent extends AndroidInjector<CheckInSuccessFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInSuccessFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInSuccessFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInSuccessFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInSuccessFragment() {
    }
}
