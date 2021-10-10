package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.ServiceTypeFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ServiceTypeFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeServiceTypeFragment {

    @Subcomponent
    public interface ServiceTypeFragmentSubcomponent extends AndroidInjector<ServiceTypeFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ServiceTypeFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(ServiceTypeFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ServiceTypeFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeServiceTypeFragment() {
    }
}
