package com.digitalwallet.app.view.login;

import com.digitalwallet.app.viewmodel.login.CreateAccountViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CreateAccountFragment_MembersInjector implements MembersInjector<CreateAccountFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CreateAccountViewModel> viewModelProvider;

    public CreateAccountFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CreateAccountViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CreateAccountFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CreateAccountViewModel> provider3) {
        return new CreateAccountFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CreateAccountFragment createAccountFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(createAccountFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(createAccountFragment, this.viewModelFactoryProvider.get());
        injectViewModel(createAccountFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CreateAccountFragment createAccountFragment, CreateAccountViewModel createAccountViewModel) {
        createAccountFragment.viewModel = createAccountViewModel;
    }
}
