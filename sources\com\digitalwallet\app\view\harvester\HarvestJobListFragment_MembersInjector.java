package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestJobListFragment_MembersInjector implements MembersInjector<HarvestJobListFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestJobListFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestJobListFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestJobListFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestJobListFragment harvestJobListFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestJobListFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestJobListFragment, this.viewModelFactoryProvider.get());
    }
}
