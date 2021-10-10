package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestTagManualEntryFragment_MembersInjector implements MembersInjector<HarvestTagManualEntryFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestTagManualEntryFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestTagManualEntryFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestTagManualEntryFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestTagManualEntryFragment harvestTagManualEntryFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestTagManualEntryFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestTagManualEntryFragment, this.viewModelFactoryProvider.get());
    }
}
