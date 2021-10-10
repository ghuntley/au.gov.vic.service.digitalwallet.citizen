package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestTagSummaryFragment_MembersInjector implements MembersInjector<HarvestTagSummaryFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestTagSummaryFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestTagSummaryFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestTagSummaryFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestTagSummaryFragment harvestTagSummaryFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestTagSummaryFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestTagSummaryFragment, this.viewModelFactoryProvider.get());
    }
}
