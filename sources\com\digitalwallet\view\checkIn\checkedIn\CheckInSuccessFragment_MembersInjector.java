package com.digitalwallet.view.checkIn.checkedIn;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInSuccessViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInSuccessFragment_MembersInjector implements MembersInjector<CheckInSuccessFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInSuccessViewModel> viewModelProvider;

    public CheckInSuccessFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInSuccessViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInSuccessFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInSuccessViewModel> provider3) {
        return new CheckInSuccessFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInSuccessFragment checkInSuccessFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInSuccessFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInSuccessFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInSuccessFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInSuccessFragment checkInSuccessFragment, CheckInSuccessViewModel checkInSuccessViewModel) {
        checkInSuccessFragment.viewModel = checkInSuccessViewModel;
    }
}
