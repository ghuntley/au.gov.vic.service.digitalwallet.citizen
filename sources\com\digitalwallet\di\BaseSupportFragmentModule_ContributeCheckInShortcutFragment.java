package com.digitalwallet.di;

import com.digitalwallet.view.checkIn.checkInShortcut.CheckInShortcutFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CheckInShortcutFragmentSubcomponent.class})
public abstract class BaseSupportFragmentModule_ContributeCheckInShortcutFragment {

    @Subcomponent
    public interface CheckInShortcutFragmentSubcomponent extends AndroidInjector<CheckInShortcutFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CheckInShortcutFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CheckInShortcutFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CheckInShortcutFragmentSubcomponent.Factory factory);

    private BaseSupportFragmentModule_ContributeCheckInShortcutFragment() {
    }
}
