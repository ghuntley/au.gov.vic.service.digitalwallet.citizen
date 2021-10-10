package com.digitalwallet.view.checkIn;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.CheckInOverviewViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInOverviewFragment_MembersInjector implements MembersInjector<CheckInOverviewFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInOverviewViewModel> viewModelProvider;

    public CheckInOverviewFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInOverviewViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInOverviewFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInOverviewViewModel> provider3) {
        return new CheckInOverviewFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInOverviewFragment checkInOverviewFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInOverviewFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInOverviewFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInOverviewFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInOverviewFragment checkInOverviewFragment, CheckInOverviewViewModel checkInOverviewViewModel) {
        checkInOverviewFragment.viewModel = checkInOverviewViewModel;
    }
}
