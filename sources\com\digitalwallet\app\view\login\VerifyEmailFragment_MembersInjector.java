package com.digitalwallet.app.view.login;

import com.digitalwallet.app.viewmodel.login.VerifyEmailViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class VerifyEmailFragment_MembersInjector implements MembersInjector<VerifyEmailFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<VerifyEmailViewModel> viewModelProvider;

    public VerifyEmailFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<VerifyEmailViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<VerifyEmailFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<VerifyEmailViewModel> provider3) {
        return new VerifyEmailFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(VerifyEmailFragment verifyEmailFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(verifyEmailFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(verifyEmailFragment, this.viewModelFactoryProvider.get());
        injectViewModel(verifyEmailFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(VerifyEmailFragment verifyEmailFragment, VerifyEmailViewModel verifyEmailViewModel) {
        verifyEmailFragment.viewModel = verifyEmailViewModel;
    }
}
