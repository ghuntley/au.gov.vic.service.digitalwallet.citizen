package com.digitalwallet.app.di;

import com.digitalwallet.app.view.harvester.HarvestActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {HarvestActivitySubcomponent.class})
public abstract class ActivityModule_ContributeHarvestJobActivity {

    @Subcomponent
    public interface HarvestActivitySubcomponent extends AndroidInjector<HarvestActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<HarvestActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(HarvestActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(HarvestActivitySubcomponent.Factory factory);

    private ActivityModule_ContributeHarvestJobActivity() {
    }
}
