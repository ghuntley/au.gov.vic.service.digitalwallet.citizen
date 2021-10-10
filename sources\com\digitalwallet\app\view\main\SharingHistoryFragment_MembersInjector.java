package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.history.SharingHistoryFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class SharingHistoryFragment_MembersInjector implements MembersInjector<SharingHistoryFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<SharingHistoryFragmentViewModel> viewModelProvider;

    public SharingHistoryFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<SharingHistoryFragmentViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<SharingHistoryFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<SharingHistoryFragmentViewModel> provider3) {
        return new SharingHistoryFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(SharingHistoryFragment sharingHistoryFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(sharingHistoryFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(sharingHistoryFragment, this.viewModelFactoryProvider.get());
        injectViewModel(sharingHistoryFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(SharingHistoryFragment sharingHistoryFragment, SharingHistoryFragmentViewModel sharingHistoryFragmentViewModel) {
        sharingHistoryFragment.viewModel = sharingHistoryFragmentViewModel;
    }
}
