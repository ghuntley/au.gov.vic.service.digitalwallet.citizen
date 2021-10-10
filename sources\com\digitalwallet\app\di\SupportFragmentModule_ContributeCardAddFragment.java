package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.CardAddFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CardAddFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeCardAddFragment {

    @Subcomponent
    public interface CardAddFragmentSubcomponent extends AndroidInjector<CardAddFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<CardAddFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(CardAddFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(CardAddFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeCardAddFragment() {
    }
}
