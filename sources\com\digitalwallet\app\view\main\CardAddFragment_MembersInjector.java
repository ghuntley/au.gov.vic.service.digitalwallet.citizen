package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.addsync.CardAddViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CardAddFragment_MembersInjector implements MembersInjector<CardAddFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CardAddViewModel> viewModelProvider;

    public CardAddFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CardAddViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CardAddFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CardAddViewModel> provider3) {
        return new CardAddFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CardAddFragment cardAddFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(cardAddFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(cardAddFragment, this.viewModelFactoryProvider.get());
        injectViewModel(cardAddFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CardAddFragment cardAddFragment, CardAddViewModel cardAddViewModel) {
        cardAddFragment.viewModel = cardAddViewModel;
    }
}
