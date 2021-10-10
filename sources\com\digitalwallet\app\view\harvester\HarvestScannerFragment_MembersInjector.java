package com.digitalwallet.app.view.harvester;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HarvestScannerFragment_MembersInjector implements MembersInjector<HarvestScannerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public HarvestScannerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<HarvestScannerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new HarvestScannerFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(HarvestScannerFragment harvestScannerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(harvestScannerFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(harvestScannerFragment, this.viewModelFactoryProvider.get());
    }
}
