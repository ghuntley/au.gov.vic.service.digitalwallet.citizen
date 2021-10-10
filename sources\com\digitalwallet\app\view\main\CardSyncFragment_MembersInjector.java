package com.digitalwallet.app.view.main;

import com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CardSyncFragment_MembersInjector implements MembersInjector<CardSyncFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CardSyncViewModel> viewModelProvider;

    public CardSyncFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CardSyncViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CardSyncFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CardSyncViewModel> provider3) {
        return new CardSyncFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CardSyncFragment cardSyncFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(cardSyncFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(cardSyncFragment, this.viewModelFactoryProvider.get());
        injectViewModel(cardSyncFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CardSyncFragment cardSyncFragment, CardSyncViewModel cardSyncViewModel) {
        cardSyncFragment.viewModel = cardSyncViewModel;
    }
}
