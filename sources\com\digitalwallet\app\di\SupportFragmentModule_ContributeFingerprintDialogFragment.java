package com.digitalwallet.app.di;

import com.digitalwallet.app.view.pin.FingerprintDialogFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FingerprintDialogFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeFingerprintDialogFragment {

    @Subcomponent
    public interface FingerprintDialogFragmentSubcomponent extends AndroidInjector<FingerprintDialogFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<FingerprintDialogFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(FingerprintDialogFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(FingerprintDialogFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeFingerprintDialogFragment() {
    }
}
