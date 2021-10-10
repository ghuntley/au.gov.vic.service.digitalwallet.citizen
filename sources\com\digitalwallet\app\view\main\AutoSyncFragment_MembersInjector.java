package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.addsync.AutoSyncViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class AutoSyncFragment_MembersInjector implements MembersInjector<AutoSyncFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<AutoSyncViewModel> viewModelProvider;

    public AutoSyncFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AutoSyncViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<AutoSyncFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AutoSyncViewModel> provider3) {
        return new AutoSyncFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(AutoSyncFragment autoSyncFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(autoSyncFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(autoSyncFragment, this.viewModelFactoryProvider.get());
        injectViewModel(autoSyncFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(AutoSyncFragment autoSyncFragment, AutoSyncViewModel autoSyncViewModel) {
        autoSyncFragment.viewModel = autoSyncViewModel;
    }
}
