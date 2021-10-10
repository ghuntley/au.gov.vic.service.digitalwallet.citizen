package com.digitalwallet.app.di;

import com.digitalwallet.app.view.SetupActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SetupActivitySubcomponent.class})
public abstract class ActivityModule_ContributeSetupActivity {

    @Subcomponent
    public interface SetupActivitySubcomponent extends AndroidInjector<SetupActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SetupActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(SetupActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SetupActivitySubcomponent.Factory factory);

    private ActivityModule_ContributeSetupActivity() {
    }
}
