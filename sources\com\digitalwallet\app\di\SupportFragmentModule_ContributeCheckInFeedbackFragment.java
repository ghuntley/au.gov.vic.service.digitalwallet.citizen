package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.checkedIn.CheckInFeedbackFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInFeedbackFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInFeedbackFragment {

    @Subcomponent
    public interface CheckInFeedbackFragmentSubcomponent extends AndroidInjector<CheckInFeedbackFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInFeedbackFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInFeedbackFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInFeedbackFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInFeedbackFragment() {
    }
}
