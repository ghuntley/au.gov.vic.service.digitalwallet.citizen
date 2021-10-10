package com.digitalwallet.app.di;

import com.digitalwallet.app.view.splash.SplashActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SplashActivitySubcomponent.class})
public abstract class ActivityModule_ContributeSecondSplashActivity {

    @Subcomponent
    public interface SplashActivitySubcomponent extends AndroidInjector<SplashActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<SplashActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(SplashActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(SplashActivitySubcomponent.Factory factory);

    private ActivityModule_ContributeSecondSplashActivity() {
    }
}
