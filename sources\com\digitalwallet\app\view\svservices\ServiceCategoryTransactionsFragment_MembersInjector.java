package com.digitalwallet.app.view.svservices;

import com.digitalwallet.app.viewmodel.svservices.ServiceCategoryTransactionsViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class ServiceCategoryTransactionsFragment_MembersInjector implements MembersInjector<ServiceCategoryTransactionsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<ServiceCategoryTransactionsViewModel> viewModelProvider;

    public ServiceCategoryTransactionsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<ServiceCategoryTransactionsViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<ServiceCategoryTransactionsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<ServiceCategoryTransactionsViewModel> provider3) {
        return new ServiceCategoryTransactionsFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(serviceCategoryTransactionsFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(serviceCategoryTransactionsFragment, this.viewModelFactoryProvider.get());
        injectViewModel(serviceCategoryTransactionsFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(ServiceCategoryTransactionsFragment serviceCategoryTransactionsFragment, ServiceCategoryTransactionsViewModel serviceCategoryTransactionsViewModel) {
        serviceCategoryTransactionsFragment.viewModel = serviceCategoryTransactionsViewModel;
    }
}
