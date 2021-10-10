package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.MainPagerFragmentViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class MainPagerFragment_MembersInjector implements MembersInjector<MainPagerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<MainPagerFragmentViewModel> viewModelProvider;

    public MainPagerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<MainPagerFragmentViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<MainPagerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<MainPagerFragmentViewModel> provider3) {
        return new MainPagerFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(MainPagerFragment mainPagerFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(mainPagerFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(mainPagerFragment, this.viewModelFactoryProvider.get());
        injectViewModel(mainPagerFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(MainPagerFragment mainPagerFragment, MainPagerFragmentViewModel mainPagerFragmentViewModel) {
        mainPagerFragment.viewModel = mainPagerFragmentViewModel;
    }
}
