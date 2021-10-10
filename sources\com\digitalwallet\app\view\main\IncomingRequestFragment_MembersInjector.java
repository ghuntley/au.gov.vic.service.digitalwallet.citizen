package com.digitalwallet.app.view.main;

import com.digitalwallet.app.connection.BLEServer;
import com.digitalwallet.app.services.AssetService;
import com.digitalwallet.app.viewmodel.main.sharing.IncomingRequestFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class IncomingRequestFragment_MembersInjector implements MembersInjector<IncomingRequestFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<BLEServer> bleServerProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<IncomingRequestFragmentViewModel> viewModelProvider;

    public IncomingRequestFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<IncomingRequestFragmentViewModel> provider3, Provider<BLEServer> provider4, Provider<AssetService> provider5) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.bleServerProvider = provider4;
        this.assetServiceProvider = provider5;
    }

    public static MembersInjector<IncomingRequestFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<IncomingRequestFragmentViewModel> provider3, Provider<BLEServer> provider4, Provider<AssetService> provider5) {
        return new IncomingRequestFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public void injectMembers(IncomingRequestFragment incomingRequestFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(incomingRequestFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(incomingRequestFragment, this.viewModelFactoryProvider.get());
        injectViewModel(incomingRequestFragment, this.viewModelProvider.get());
        injectBleServer(incomingRequestFragment, this.bleServerProvider.get());
        injectAssetService(incomingRequestFragment, this.assetServiceProvider.get());
    }

    public static void injectViewModel(IncomingRequestFragment incomingRequestFragment, IncomingRequestFragmentViewModel incomingRequestFragmentViewModel) {
        incomingRequestFragment.viewModel = incomingRequestFragmentViewModel;
    }

    public static void injectBleServer(IncomingRequestFragment incomingRequestFragment, BLEServer bLEServer) {
        incomingRequestFragment.bleServer = bLEServer;
    }

    public static void injectAssetService(IncomingRequestFragment incomingRequestFragment, AssetService assetService) {
        incomingRequestFragment.assetService = assetService;
    }
}
