package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class NicknameEditFragment_MembersInjector implements MembersInjector<NicknameEditFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<NicknameViewModel> viewModelProvider;

    public NicknameEditFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<NicknameViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<NicknameEditFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<NicknameViewModel> provider3) {
        return new NicknameEditFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(NicknameEditFragment nicknameEditFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(nicknameEditFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(nicknameEditFragment, this.viewModelFactoryProvider.get());
        injectViewModel(nicknameEditFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(NicknameEditFragment nicknameEditFragment, NicknameViewModel nicknameViewModel) {
        nicknameEditFragment.viewModel = nicknameViewModel;
    }
}
