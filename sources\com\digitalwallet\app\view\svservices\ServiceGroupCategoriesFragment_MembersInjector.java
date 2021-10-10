package com.digitalwallet.app.view.svservices;

import com.digitalwallet.app.viewmodel.svservices.ServiceGroupCategoriesViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class ServiceGroupCategoriesFragment_MembersInjector implements MembersInjector<ServiceGroupCategoriesFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<ServiceGroupCategoriesViewModel> viewModelProvider;

    public ServiceGroupCategoriesFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<ServiceGroupCategoriesViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<ServiceGroupCategoriesFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<ServiceGroupCategoriesViewModel> provider3) {
        return new ServiceGroupCategoriesFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(serviceGroupCategoriesFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(serviceGroupCategoriesFragment, this.viewModelFactoryProvider.get());
        injectViewModel(serviceGroupCategoriesFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(ServiceGroupCategoriesFragment serviceGroupCategoriesFragment, ServiceGroupCategoriesViewModel serviceGroupCategoriesViewModel) {
        serviceGroupCategoriesFragment.viewModel = serviceGroupCategoriesViewModel;
    }
}
