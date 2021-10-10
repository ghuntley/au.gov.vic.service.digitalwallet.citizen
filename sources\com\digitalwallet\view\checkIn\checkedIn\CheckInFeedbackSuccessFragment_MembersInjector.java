package com.digitalwallet.view.checkIn.checkedIn;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkedIn.CheckInFeedbackSuccessViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInFeedbackSuccessFragment_MembersInjector implements MembersInjector<CheckInFeedbackSuccessFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInFeedbackSuccessViewModel> viewModelProvider;

    public CheckInFeedbackSuccessFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInFeedbackSuccessViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInFeedbackSuccessFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInFeedbackSuccessViewModel> provider3) {
        return new CheckInFeedbackSuccessFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInFeedbackSuccessFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInFeedbackSuccessFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInFeedbackSuccessFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInFeedbackSuccessFragment checkInFeedbackSuccessFragment, CheckInFeedbackSuccessViewModel checkInFeedbackSuccessViewModel) {
        checkInFeedbackSuccessFragment.viewModel = checkInFeedbackSuccessViewModel;
    }
}
