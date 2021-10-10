package com.digitalwallet.app.di;

import com.digitalwallet.app.view.svservices.ServiceCategoryTransactionsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ServiceCategoryTransactionsFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ServiceCategoryTransactionsFragment {

    @Subcomponent
    public interface ServiceCategoryTransactionsFragmentSubcomponent extends AndroidInjector<ServiceCategoryTransactionsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<ServiceCategoryTransactionsFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(ServiceCategoryTransactionsFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(ServiceCategoryTransactionsFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ServiceCategoryTransactionsFragment() {
    }
}
