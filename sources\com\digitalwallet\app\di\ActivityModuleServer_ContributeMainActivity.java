package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.MainActivityServer;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityServerSubcomponent.class})
public abstract class ActivityModuleServer_ContributeMainActivity {

    @Subcomponent
    public interface MainActivityServerSubcomponent extends AndroidInjector<MainActivityServer> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MainActivityServer> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(MainActivityServer.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainActivityServerSubcomponent.Factory factory);

    private ActivityModuleServer_ContributeMainActivity() {
    }
}
