package com.digitalwallet.view.checkIn.checkInInput;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInSubmittingViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInSubmittingFragment_MembersInjector implements MembersInjector<CheckInSubmittingFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInSubmittingViewModel> viewModelProvider;

    public CheckInSubmittingFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInSubmittingViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInSubmittingFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInSubmittingViewModel> provider3) {
        return new CheckInSubmittingFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInSubmittingFragment checkInSubmittingFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInSubmittingFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInSubmittingFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInSubmittingFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInSubmittingFragment checkInSubmittingFragment, CheckInSubmittingViewModel checkInSubmittingViewModel) {
        checkInSubmittingFragment.viewModel = checkInSubmittingViewModel;
    }
}
