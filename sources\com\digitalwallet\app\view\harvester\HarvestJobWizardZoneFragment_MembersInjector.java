package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestJobWizardZoneFragment_MembersInjector implements MembersInjector<HarvestJobWizardZoneFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestJobWizardZoneFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestJobWizardZoneFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestJobWizardZoneFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestJobWizardZoneFragment harvestJobWizardZoneFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobWizardZoneFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestJobWizardZoneFragment, this.viewModelFactoryProvider.get());
    }
}
