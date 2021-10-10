package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivitySubcomponent.class})
public abstract class ActivityModuleClient_ContributeMainActivity {

    @Subcomponent
    public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MainActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(MainActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainActivitySubcomponent.Factory factory);

    private ActivityModuleClient_ContributeMainActivity() {
    }
}
