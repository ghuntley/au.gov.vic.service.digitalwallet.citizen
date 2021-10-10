package com.digitalwallet.app.di;

import com.digitalwallet.app.view.SetupActivity;
import com.digitalwallet.app.view.harvester.HarvestActivity;
import com.digitalwallet.app.view.login.LoginActivity;
import com.digitalwallet.app.view.onboarding.OnboardingActivity;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.app.view.splash.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0005\u001a\u00020\u0006H'J\b\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\nH'J\b\u0010\u000b\u001a\u00020\fH'J\b\u0010\r\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/digitalwallet/app/di/ActivityModule;", "", "()V", "contributeHarvestJobActivity", "Lcom/digitalwallet/app/view/harvester/HarvestActivity;", "contributeLoginActivity", "Lcom/digitalwallet/app/view/login/LoginActivity;", "contributeOnboardingActivity", "Lcom/digitalwallet/app/view/onboarding/OnboardingActivity;", "contributePinActivity", "Lcom/digitalwallet/app/view/pin/PinActivity;", "contributeSecondSplashActivity", "Lcom/digitalwallet/app/view/splash/SplashActivity;", "contributeSetupActivity", "Lcom/digitalwallet/app/view/SetupActivity;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: ActivityModule.kt */
public abstract class ActivityModule {
    @ContributesAndroidInjector
    public abstract HarvestActivity contributeHarvestJobActivity();

    @ContributesAndroidInjector
    public abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector
    public abstract OnboardingActivity contributeOnboardingActivity();

    @ContributesAndroidInjector
    public abstract PinActivity contributePinActivity();

    @ContributesAndroidInjector
    public abstract SplashActivity contributeSecondSplashActivity();

    @ContributesAndroidInjector
    public abstract SetupActivity contributeSetupActivity();
}
