package com.digitalwallet.app.di;

import com.digitalwallet.app.view.login.VerifyEmailFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {VerifyEmailFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeVerifyEmailFragment {

    @Subcomponent
    public interface VerifyEmailFragmentSubcomponent extends AndroidInjector<VerifyEmailFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<VerifyEmailFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(VerifyEmailFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(VerifyEmailFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeVerifyEmailFragment() {
    }
}
