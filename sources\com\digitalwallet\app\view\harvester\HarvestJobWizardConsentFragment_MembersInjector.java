package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestJobWizardConsentFragment_MembersInjector implements MembersInjector<HarvestJobWizardConsentFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestJobWizardConsentFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestJobWizardConsentFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestJobWizardConsentFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestJobWizardConsentFragment harvestJobWizardConsentFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobWizardConsentFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestJobWizardConsentFragment, this.viewModelFactoryProvider.get());
    }
}
