package com.digitalwallet.view.checkIn.checkInInput;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInEditPersonInputViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInEditPersonInputFragment_MembersInjector implements MembersInjector<CheckInEditPersonInputFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInEditPersonInputViewModel> viewModelProvider;

    public CheckInEditPersonInputFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInEditPersonInputViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInEditPersonInputFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInEditPersonInputViewModel> provider3) {
        return new CheckInEditPersonInputFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInEditPersonInputFragment checkInEditPersonInputFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInEditPersonInputFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInEditPersonInputFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInEditPersonInputFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInEditPersonInputFragment checkInEditPersonInputFragment, CheckInEditPersonInputViewModel checkInEditPersonInputViewModel) {
        checkInEditPersonInputFragment.viewModel = checkInEditPersonInputViewModel;
    }
}
