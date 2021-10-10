package com.digitalwallet.view.checkIn.checkedIn;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInFeedbackFragment_MembersInjector implements MembersInjector<CheckInFeedbackFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInFeedbackViewModel> viewModelProvider;

    public CheckInFeedbackFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInFeedbackViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInFeedbackFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInFeedbackViewModel> provider3) {
        return new CheckInFeedbackFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInFeedbackFragment checkInFeedbackFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInFeedbackFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInFeedbackFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInFeedbackFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInFeedbackFragment checkInFeedbackFragment, CheckInFeedbackViewModel checkInFeedbackViewModel) {
        checkInFeedbackFragment.viewModel = checkInFeedbackViewModel;
    }
}
