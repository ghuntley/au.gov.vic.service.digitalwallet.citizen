package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestJobWizardAddressFragment_MembersInjector implements MembersInjector<HarvestJobWizardAddressFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestJobWizardAddressFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestJobWizardAddressFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestJobWizardAddressFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestJobWizardAddressFragment harvestJobWizardAddressFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobWizardAddressFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestJobWizardAddressFragment, this.viewModelFactoryProvider.get());
    }
}
