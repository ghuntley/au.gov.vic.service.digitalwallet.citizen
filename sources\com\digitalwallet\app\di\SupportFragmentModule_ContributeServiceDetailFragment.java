package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.ServiceDetailFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ServiceDetailFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeServiceDetailFragment {

    @Subcomponent
    public interface ServiceDetailFragmentSubcomponent extends AndroidInjector<ServiceDetailFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ServiceDetailFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(ServiceDetailFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ServiceDetailFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeServiceDetailFragment() {
    }
}
