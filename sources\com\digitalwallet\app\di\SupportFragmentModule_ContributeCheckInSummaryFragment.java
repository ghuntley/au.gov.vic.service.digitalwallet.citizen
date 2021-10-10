package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.checkInInput.CheckInSummaryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInSummaryFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInSummaryFragment {

    @Subcomponent
    public interface CheckInSummaryFragmentSubcomponent extends AndroidInjector<CheckInSummaryFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInSummaryFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInSummaryFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInSummaryFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInSummaryFragment() {
    }
}
