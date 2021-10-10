package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.MainPagerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainPagerFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeMainPagerFragment {

    @Subcomponent
    public interface MainPagerFragmentSubcomponent extends AndroidInjector<MainPagerFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MainPagerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(MainPagerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainPagerFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeMainPagerFragment() {
    }
}
