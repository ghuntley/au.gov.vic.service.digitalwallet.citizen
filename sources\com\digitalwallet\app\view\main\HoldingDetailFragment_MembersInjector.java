package com.digitalwallet.app.view.main;

import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.viewmodel.main.HoldingDetailFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HoldingDetailFragment_MembersInjector implements MembersInjector<HoldingDetailFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<HoldingDetailFragmentViewModel> viewModelProvider;

    public HoldingDetailFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<HoldingDetailFragmentViewModel> provider3, Provider<AssetService> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.assetServiceProvider = provider4;
    }

    public static MembersInjector<HoldingDetailFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<HoldingDetailFragmentViewModel> provider3, Provider<AssetService> provider4) {
        return new HoldingDetailFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(HoldingDetailFragment holdingDetailFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(holdingDetailFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(holdingDetailFragment, this.viewModelFactoryProvider.get());
        injectViewModel(holdingDetailFragment, this.viewModelProvider.get());
        injectAssetService(holdingDetailFragment, this.assetServiceProvider.get());
    }

    public static void injectViewModel(HoldingDetailFragment holdingDetailFragment, HoldingDetailFragmentViewModel holdingDetailFragmentViewModel) {
        holdingDetailFragment.viewModel = holdingDetailFragmentViewModel;
    }

    public static void injectAssetService(HoldingDetailFragment holdingDetailFragment, AssetService assetService) {
        holdingDetailFragment.assetService = assetService;
    }
}
