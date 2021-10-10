package com.digitalwallet.view.checkIn.checkInInput;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSummaryViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInSummaryFragment_MembersInjector implements MembersInjector<CheckInSummaryFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInSummaryViewModel> viewModelProvider;

    public CheckInSummaryFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInSummaryViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInSummaryFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInSummaryViewModel> provider3) {
        return new CheckInSummaryFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInSummaryFragment checkInSummaryFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInSummaryFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInSummaryFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInSummaryFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInSummaryFragment checkInSummaryFragment, CheckInSummaryViewModel checkInSummaryViewModel) {
        checkInSummaryFragment.viewModel = checkInSummaryViewModel;
    }
}
