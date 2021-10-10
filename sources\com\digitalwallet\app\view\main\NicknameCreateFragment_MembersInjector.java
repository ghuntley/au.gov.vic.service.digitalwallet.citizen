package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.NicknameViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class NicknameCreateFragment_MembersInjector implements MembersInjector<NicknameCreateFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<NicknameViewModel> viewModelProvider;

    public NicknameCreateFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<NicknameViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<NicknameCreateFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<NicknameViewModel> provider3) {
        return new NicknameCreateFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(NicknameCreateFragment nicknameCreateFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(nicknameCreateFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(nicknameCreateFragment, this.viewModelFactoryProvider.get());
        injectViewModel(nicknameCreateFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(NicknameCreateFragment nicknameCreateFragment, NicknameViewModel nicknameViewModel) {
        nicknameCreateFragment.viewModel = nicknameViewModel;
    }
}
