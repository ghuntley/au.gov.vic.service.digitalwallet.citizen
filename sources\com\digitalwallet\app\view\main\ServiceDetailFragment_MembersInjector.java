package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.ServiceDetailFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class ServiceDetailFragment_MembersInjector implements MembersInjector<ServiceDetailFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<ServiceDetailFragmentViewModel> viewModelProvider;

    public ServiceDetailFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<ServiceDetailFragmentViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<ServiceDetailFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<ServiceDetailFragmentViewModel> provider3) {
        return new ServiceDetailFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ServiceDetailFragment serviceDetailFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(serviceDetailFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(serviceDetailFragment, this.viewModelFactoryProvider.get());
        injectViewModel(serviceDetailFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(ServiceDetailFragment serviceDetailFragment, ServiceDetailFragmentViewModel serviceDetailFragmentViewModel) {
        serviceDetailFragment.viewModel = serviceDetailFragmentViewModel;
    }
}
