package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.TransactionHistoryFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {TransactionHistoryFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeTransactionHistoryFragment {

    @Subcomponent
    public interface TransactionHistoryFragmentSubcomponent extends AndroidInjector<TransactionHistoryFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<TransactionHistoryFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(TransactionHistoryFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(TransactionHistoryFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeTransactionHistoryFragment() {
    }
}
