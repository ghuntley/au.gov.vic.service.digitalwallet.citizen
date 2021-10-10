package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.SharingDetailsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SharingDetailsFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeSharingDetailsFragment {

    @Subcomponent
    public interface SharingDetailsFragmentSubcomponent extends AndroidInjector<SharingDetailsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SharingDetailsFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(SharingDetailsFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SharingDetailsFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeSharingDetailsFragment() {
    }
}
