package com.digitalwallet.app.di;

import com.digitalwallet.app.view.login.CreateAccountFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CreateAccountFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCreateAccountFragment {

    @Subcomponent
    public interface CreateAccountFragmentSubcomponent extends AndroidInjector<CreateAccountFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CreateAccountFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CreateAccountFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CreateAccountFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCreateAccountFragment() {
    }
}
