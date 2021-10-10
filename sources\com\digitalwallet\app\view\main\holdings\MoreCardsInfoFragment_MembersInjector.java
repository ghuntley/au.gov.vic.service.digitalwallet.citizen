package com.digitalwallet.app.view.main.holdings;

import com.digitalwallet.app.viewmodel.main.holdings.MoreCardsInfoViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class MoreCardsInfoFragment_MembersInjector implements MembersInjector<MoreCardsInfoFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<MoreCardsInfoViewModel> viewModelProvider;

    public MoreCardsInfoFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<MoreCardsInfoViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<MoreCardsInfoFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<MoreCardsInfoViewModel> provider3) {
        return new MoreCardsInfoFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(MoreCardsInfoFragment moreCardsInfoFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(moreCardsInfoFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(moreCardsInfoFragment, this.viewModelFactoryProvider.get());
        injectViewModel(moreCardsInfoFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(MoreCardsInfoFragment moreCardsInfoFragment, MoreCardsInfoViewModel moreCardsInfoViewModel) {
        moreCardsInfoFragment.viewModel = moreCardsInfoViewModel;
    }
}
