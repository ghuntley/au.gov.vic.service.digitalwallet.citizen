package com.digitalwallet.app.di;

import com.digitalwallet.view.checkIn.CheckInOverviewFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInOverviewFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCheckInOverviewFragment {

    @Subcomponent
    public interface CheckInOverviewFragmentSubcomponent extends AndroidInjector<CheckInOverviewFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInOverviewFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInOverviewFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInOverviewFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCheckInOverviewFragment() {
    }
}
