package com.digitalwallet.app.di;

import com.digitalwallet.app.view.main.NicknameCreateFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {NicknameCreateFragmentSubcomponent.class})
public abstract class SupportFragmentModule_NicknameCreateFragment {

    @Subcomponent
    public interface NicknameCreateFragmentSubcomponent extends AndroidInjector<NicknameCreateFragment> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<NicknameCreateFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(NicknameCreateFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(NicknameCreateFragmentSubcomponent.Factory factory);

    private SupportFragmentModule_NicknameCreateFragment() {
    }
}
