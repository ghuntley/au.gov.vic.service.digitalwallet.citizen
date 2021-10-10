package com.digitalwallet.di;

import com.digitalwallet.view.checkIn.checkInInput.CheckInSubmittingFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInSubmittingFragmentSubcomponent.class})
public abstract class BaseSupportFragmentModule_ContributeCheckInSubmittingFragment {

    @Subcomponent
    public interface CheckInSubmittingFragmentSubcomponent extends AndroidInjector<CheckInSubmittingFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInSubmittingFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInSubmittingFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInSubmittingFragmentSubcomponent.Factory factory);

    private BaseSupportFragmentModule_ContributeCheckInSubmittingFragment() {
    }
}
