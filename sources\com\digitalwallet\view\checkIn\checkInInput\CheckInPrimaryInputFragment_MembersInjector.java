package com.digitalwallet.view.checkIn.checkInInput;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInPrimaryInputViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInPrimaryInputFragment_MembersInjector implements MembersInjector<CheckInPrimaryInputFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInPrimaryInputViewModel> viewModelProvider;

    public CheckInPrimaryInputFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInPrimaryInputViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInPrimaryInputFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInPrimaryInputViewModel> provider3) {
        return new CheckInPrimaryInputFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInPrimaryInputFragment checkInPrimaryInputFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInPrimaryInputFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInPrimaryInputFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInPrimaryInputFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInPrimaryInputFragment checkInPrimaryInputFragment, CheckInPrimaryInputViewModel checkInPrimaryInputViewModel) {
        checkInPrimaryInputFragment.viewModel = checkInPrimaryInputViewModel;
    }
}
