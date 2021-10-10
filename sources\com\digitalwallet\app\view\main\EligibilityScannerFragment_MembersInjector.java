package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.EligibilityScannerFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class EligibilityScannerFragment_MembersInjector implements MembersInjector<EligibilityScannerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<EligibilityScannerFragmentViewModel> viewModelProvider;

    public EligibilityScannerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<EligibilityScannerFragmentViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<EligibilityScannerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<EligibilityScannerFragmentViewModel> provider3) {
        return new EligibilityScannerFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(EligibilityScannerFragment eligibilityScannerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(eligibilityScannerFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(eligibilityScannerFragment, this.viewModelFactoryProvider.get());
        injectViewModel(eligibilityScannerFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(EligibilityScannerFragment eligibilityScannerFragment, EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel) {
        eligibilityScannerFragment.viewModel = eligibilityScannerFragmentViewModel;
    }
}
