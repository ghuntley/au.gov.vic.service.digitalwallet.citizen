package com.digitalwallet.app.view.login;

import com.digitalwallet.app.viewmodel.login.HomeServicesViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class HomeServicesFragment_MembersInjector implements MembersInjector<HomeServicesFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<RemoteConfigService> remoteConfigServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<HomeServicesViewModel> viewModelProvider;

    public HomeServicesFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<HomeServicesViewModel> provider3, Provider<RemoteConfigService> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
        this.remoteConfigServiceProvider = provider4;
    }

    public static MembersInjector<HomeServicesFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<HomeServicesViewModel> provider3, Provider<RemoteConfigService> provider4) {
        return new HomeServicesFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(HomeServicesFragment homeServicesFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(homeServicesFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(homeServicesFragment, this.viewModelFactoryProvider.get());
        injectViewModel(homeServicesFragment, this.viewModelProvider.get());
        injectRemoteConfigService(homeServicesFragment, this.remoteConfigServiceProvider.get());
    }

    public static void injectViewModel(HomeServicesFragment homeServicesFragment, HomeServicesViewModel homeServicesViewModel) {
        homeServicesFragment.viewModel = homeServicesViewModel;
    }

    public static void injectRemoteConfigService(HomeServicesFragment homeServicesFragment, RemoteConfigService remoteConfigService) {
        homeServicesFragment.remoteConfigService = remoteConfigService;
    }
}
