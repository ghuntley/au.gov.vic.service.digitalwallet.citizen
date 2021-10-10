package com.digitalwallet.view.checkIn.checkInShortcut;

import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseFragment_MembersInjector;
import com.digitalwallet.viewmodel.checkIn.checkInShortcut.CheckInShortcutViewModel;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerFragment_MembersInjector;
import javax.inject.Provider;

public final class CheckInShortcutFragment_MembersInjector implements MembersInjector<CheckInShortcutFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<CheckInShortcutViewModel> viewModelProvider;

    public CheckInShortcutFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInShortcutViewModel> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.viewModelProvider = provider3;
    }

    public static MembersInjector<CheckInShortcutFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<CheckInShortcutViewModel> provider3) {
        return new CheckInShortcutFragment_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CheckInShortcutFragment checkInShortcutFragment) {
        DaggerFragment_MembersInjector.injectAndroidInjector(checkInShortcutFragment, this.androidInjectorProvider.get());
        BaseFragment_MembersInjector.injectViewModelFactory(checkInShortcutFragment, this.viewModelFactoryProvider.get());
        injectViewModel(checkInShortcutFragment, this.viewModelProvider.get());
    }

    public static void injectViewModel(CheckInShortcutFragment checkInShortcutFragment, CheckInShortcutViewModel checkInShortcutViewModel) {
        checkInShortcutFragment.viewModel = checkInShortcutViewModel;
    }
}
