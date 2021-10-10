package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.checkInInput.CheckInEditPersonInputFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInEditPersonInputFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInEditPersonInputFragment {

    @Subcomponent
    public interface CheckInEditPersonInputFragmentSubcomponent extends AndroidInjector<CheckInEditPersonInputFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInEditPersonInputFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInEditPersonInputFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInEditPersonInputFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInEditPersonInputFragment() {
    }
}
