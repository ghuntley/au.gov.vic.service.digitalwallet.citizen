package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.CardSyncFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CardSyncFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCardSyncFragment {

    @Subcomponent
    public interface CardSyncFragmentSubcomponent extends AndroidInjector<CardSyncFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CardSyncFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CardSyncFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CardSyncFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCardSyncFragment() {
    }
}
