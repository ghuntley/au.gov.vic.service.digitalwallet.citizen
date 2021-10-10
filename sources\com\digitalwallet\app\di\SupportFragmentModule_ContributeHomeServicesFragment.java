package com.digitalwallet.app.di;

import com.digitalwallet.app.view.login.HomeServicesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HomeServicesFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeHomeServicesFragment {

    @Subcomponent
    public interface HomeServicesFragmentSubcomponent extends AndroidInjector<HomeServicesFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HomeServicesFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HomeServicesFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HomeServicesFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeHomeServicesFragment() {
    }
}
