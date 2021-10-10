package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.LobbyFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LobbyFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeLobbyFragment {

    @Subcomponent
    public interface LobbyFragmentSubcomponent extends AndroidInjector<LobbyFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LobbyFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(LobbyFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LobbyFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeLobbyFragment() {
    }
}
