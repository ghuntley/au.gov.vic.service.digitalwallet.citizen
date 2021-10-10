package com.digitalwallet.di;

import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackSuccessFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInFeedbackSuccessFragmentSubcomponent.class})
public abstract class BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment {

    @Subcomponent
    public interface CheckInFeedbackSuccessFragmentSubcomponent extends AndroidInjector<CheckInFeedbackSuccessFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInFeedbackSuccessFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInFeedbackSuccessFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInFeedbackSuccessFragmentSubcomponent.Factory factory);

    private BaseSupportFragmentModule_ContributeCheckInFeedbackSuccessFragment() {
    }
}
