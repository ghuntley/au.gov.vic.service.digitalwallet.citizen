package com.digitalwallet.di;

import com.digitalwallet.view.checkIn.checkedIn.CheckInHistoryDetailFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInHistoryDetailFragmentSubcomponent.class})
public abstract class BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment {

    @Subcomponent
    public interface CheckInHistoryDetailFragmentSubcomponent extends AndroidInjector<CheckInHistoryDetailFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInHistoryDetailFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInHistoryDetailFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInHistoryDetailFragmentSubcomponent.Factory factory);

    private BaseSupportFragmentModule_ContributeCheckInHistoryDetailFragment() {
    }
}
