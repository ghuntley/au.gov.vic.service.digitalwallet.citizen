package com.digitalwallet.app.di;

import com.digitalwallet.app.view.login.LoginActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LoginActivitySubcomponent.class})
public abstract class ActivityModule_ContributeLoginActivity {

    @Subcomponent
    public interface LoginActivitySubcomponent extends AndroidInjector<LoginActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<LoginActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(LoginActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(LoginActivitySubcomponent.Factory factory);

    private ActivityModule_ContributeLoginActivity() {
    }
}
