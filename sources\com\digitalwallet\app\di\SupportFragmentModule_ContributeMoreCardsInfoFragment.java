package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.holdings.MoreCardsInfoFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MoreCardsInfoFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeMoreCardsInfoFragment {

    @Subcomponent
    public interface MoreCardsInfoFragmentSubcomponent extends AndroidInjector<MoreCardsInfoFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<MoreCardsInfoFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(MoreCardsInfoFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MoreCardsInfoFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeMoreCardsInfoFragment() {
    }
}
