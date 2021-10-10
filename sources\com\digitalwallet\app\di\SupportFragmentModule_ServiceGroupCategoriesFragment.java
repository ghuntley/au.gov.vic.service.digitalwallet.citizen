package com.digitalwallet.app.di;

import com.digitalwallet.app.view.svservices.ServiceGroupCategoriesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ServiceGroupCategoriesFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ServiceGroupCategoriesFragment {

    @Subcomponent
    public interface ServiceGroupCategoriesFragmentSubcomponent extends AndroidInjector<ServiceGroupCategoriesFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ServiceGroupCategoriesFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(ServiceGroupCategoriesFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ServiceGroupCategoriesFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ServiceGroupCategoriesFragment() {
    }
}
