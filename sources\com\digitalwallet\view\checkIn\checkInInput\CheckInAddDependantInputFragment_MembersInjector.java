package com.digitalwallet.view.checkIn.checkInInput;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInAddDependantInputViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInAddDependantInputFragment_MembersInjector implements MembersInjector<CheckInAddDependantInputFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInAddDependantInputViewModel> viewModelProvider;

    public CheckInAddDependantInputFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInAddDependantInputViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInAddDependantInputFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInAddDependantInputViewModel> provider3) {
        return new CheckInAddDependantInputFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInAddDependantInputFragment checkInAddDependantInputFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInAddDependantInputFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInAddDependantInputFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInAddDependantInputFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInAddDependantInputFragment checkInAddDependantInputFragment, CheckInAddDependantInputViewModel checkInAddDependantInputViewModel) {
        checkInAddDependantInputFragment.viewModel = checkInAddDependantInputViewModel;
    }
}
