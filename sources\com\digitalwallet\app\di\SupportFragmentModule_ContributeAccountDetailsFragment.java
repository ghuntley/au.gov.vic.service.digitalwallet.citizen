package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.AccountDetailsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AccountDetailsFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeAccountDetailsFragment {

    @Subcomponent
    public interface AccountDetailsFragmentSubcomponent extends AndroidInjector<AccountDetailsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AccountDetailsFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(AccountDetailsFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AccountDetailsFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeAccountDetailsFragment() {
    }
}
