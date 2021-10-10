package com.digitalwallet.view.checkIn.checkedIn;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInHistoryDetailViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInHistoryDetailFragment_MembersInjector implements MembersInjector<CheckInHistoryDetailFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInHistoryDetailViewModel> viewModelProvider;

    public CheckInHistoryDetailFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInHistoryDetailViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInHistoryDetailFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInHistoryDetailViewModel> provider3) {
        return new CheckInHistoryDetailFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInHistoryDetailFragment checkInHistoryDetailFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInHistoryDetailFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInHistoryDetailFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInHistoryDetailFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInHistoryDetailFragment checkInHistoryDetailFragment, CheckInHistoryDetailViewModel checkInHistoryDetailViewModel) {
        checkInHistoryDetailFragment.viewModel = checkInHistoryDetailViewModel;
    }
}
