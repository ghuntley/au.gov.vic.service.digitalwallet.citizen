package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.NicknameEditFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {NicknameEditFragmentSubcomponent.class})
public abstract class SupportFragmentModule_NicknameEditFragment {

    @Subcomponent
    public interface NicknameEditFragmentSubcomponent extends AndroidInjector<NicknameEditFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<NicknameEditFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(NicknameEditFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(NicknameEditFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_NicknameEditFragment() {
    }
}
