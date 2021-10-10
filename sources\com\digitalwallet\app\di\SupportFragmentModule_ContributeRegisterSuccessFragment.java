package com.digitalwallet.app.di;

import com.digitalwallet.app.view.login.RegisterSuccessFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RegisterSuccessFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeRegisterSuccessFragment {

    @Subcomponent
    public interface RegisterSuccessFragmentSubcomponent extends AndroidInjector<RegisterSuccessFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<RegisterSuccessFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(RegisterSuccessFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RegisterSuccessFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeRegisterSuccessFragment() {
    }
}
