package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.AccountSettingsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AccountSettingsFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeAccountSettingsFragment {

    @Subcomponent
    public interface AccountSettingsFragmentSubcomponent extends AndroidInjector<AccountSettingsFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<AccountSettingsFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(AccountSettingsFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AccountSettingsFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeAccountSettingsFragment() {
    }
}
