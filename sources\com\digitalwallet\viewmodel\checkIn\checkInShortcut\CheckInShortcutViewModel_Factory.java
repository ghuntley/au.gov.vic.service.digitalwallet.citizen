package com.digitalwallet.viewmodel.checkIn.checkInShortcut;

import android.content.Context;
import com.digitalwallet.viewmodel.checkIn.checkInRepository.CheckInRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CheckInShortcutViewModel_Factory implements Factory<CheckInShortcutViewModel> {
    private final Provider<CheckInRepository> checkInRepositoryProvider;
    private final Provider<Context> contextProvider;

    public CheckInShortcutViewModel_Factory(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        this.contextProvider = provider;
        this.checkInRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CheckInShortcutViewModel get() {
        return new CheckInShortcutViewModel(this.contextProvider.get(), this.checkInRepositoryProvider.get());
    }

    public static CheckInShortcutViewModel_Factory create(Provider<Context> provider, Provider<CheckInRepository> provider2) {
        return new CheckInShortcutViewModel_Factory(provider, provider2);
    }

    public static CheckInShortcutViewModel newInstance(Context context, CheckInRepository checkInRepository) {
        return new CheckInShortcutViewModel(context, checkInRepository);
    }
}
