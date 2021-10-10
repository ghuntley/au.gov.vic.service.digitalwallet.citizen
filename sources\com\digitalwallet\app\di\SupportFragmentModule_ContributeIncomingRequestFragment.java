package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.IncomingRequestFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {IncomingRequestFragmentSubcomponent.class})
public abstract class SupportFragmentModule_ContributeIncomingRequestFragment {

    @Subcomponent
    public interface IncomingRequestFragmentSubcomponent extends AndroidInjector<IncomingRequestFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<IncomingRequestFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(IncomingRequestFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(IncomingRequestFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_ContributeIncomingRequestFragment() {
    }
}
