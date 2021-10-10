package com.digitalwallet.app.di;

import com.digitalwallet.app.view.onboarding.OnboardingActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {OnboardingActivitySubcomponent.class})
public abstract class ActivityModule_ContributeOnboardingActivity {

    @Subcomponent
    public interface OnboardingActivitySubcomponent extends AndroidInjector<OnboardingActivity> {

        @Subcomponent.Factory
        public interface Factory extends AndroidInjector.Factory<OnboardingActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @ClassKey(OnboardingActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(OnboardingActivitySubcomponent.Factory factory);

    private ActivityModule_ContributeOnboardingActivity() {
    }
}
