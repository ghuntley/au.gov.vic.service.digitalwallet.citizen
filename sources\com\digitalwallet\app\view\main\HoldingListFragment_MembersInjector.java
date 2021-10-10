package com.digitalwallet.app.view.main;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.viewmodel.main.HoldingListFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HoldingListFragment_MembersInjector implements MembersInjector<HoldingListFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<HoldingParser> holdingParserProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<HoldingListFragmentViewModel> viewModelProvider;

    public HoldingListFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<HoldingListFragmentViewModel> provider3, Provider<AssetService> provider4, Provider<HoldingParser> provider5, Provider<AppStartUp> provider6) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.assetServiceProvider = provider4;
        this.holdingParserProvider = provider5;
        this.appStartUpProvider = provider6;
    }

    public static MembersInjector<HoldingListFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<HoldingListFragmentViewModel> provider3, Provider<AssetService> provider4, Provider<HoldingParser> provider5, Provider<AppStartUp> provider6) {
        return new HoldingListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(HoldingListFragment holdingListFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(holdingListFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(holdingListFragment, this.viewModelFactoryProvider.get());
        injectViewModel(holdingListFragment, this.viewModelProvider.get());
        injectAssetService(holdingListFragment, this.assetServiceProvider.get());
        injectHoldingParser(holdingListFragment, this.holdingParserProvider.get());
        injectAppStartUp(holdingListFragment, this.appStartUpProvider.get());
    }

    public static void injectViewModel(HoldingListFragment holdingListFragment, HoldingListFragmentViewModel holdingListFragmentViewModel) {
        holdingListFragment.viewModel = holdingListFragmentViewModel;
    }

    public static void injectAssetService(HoldingListFragment holdingListFragment, AssetService assetService) {
        holdingListFragment.assetService = assetService;
    }

    public static void injectHoldingParser(HoldingListFragment holdingListFragment, HoldingParser holdingParser) {
        holdingListFragment.holdingParser = holdingParser;
    }

    public static void injectAppStartUp(HoldingListFragment holdingListFragment, AppStartUp appStartUp) {
        holdingListFragment.appStartUp = appStartUp;
    }
}
