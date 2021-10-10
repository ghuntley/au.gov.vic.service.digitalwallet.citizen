package com.digitalwallet.app.view.login;

import com.digitalwallet.app.viewmodel.login.RegisterSuccessViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class RegisterSuccessFragment_MembersInjector implements MembersInjector<RegisterSuccessFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<RegisterSuccessViewModel> viewModelProvider;

    public RegisterSuccessFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<RegisterSuccessViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<RegisterSuccessFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<RegisterSuccessViewModel> provider3) {
        return new RegisterSuccessFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(RegisterSuccessFragment registerSuccessFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(registerSuccessFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(registerSuccessFragment, this.viewModelFactoryProvider.get());
        injectViewModel(registerSuccessFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(RegisterSuccessFragment registerSuccessFragment, RegisterSuccessViewModel registerSuccessViewModel) {
        registerSuccessFragment.viewModel = registerSuccessViewModel;
    }
}
