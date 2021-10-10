package com.digitalwallet.app.di;

import com.digitalwallet.app.view.pin.PinActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {PinActivitySubcomponent.class})
public abstract class ActivityModule_ContributePinActivity {

    @Subcomponent
    public interface PinActivitySubcomponent extends AndroidInjector<PinActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<PinActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(PinActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(PinActivitySubcomponent.Factory factory);

    private ActivityModule_ContributePinActivity() {
    }
}
