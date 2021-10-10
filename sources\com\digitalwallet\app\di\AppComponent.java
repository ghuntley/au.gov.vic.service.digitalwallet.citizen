package com.digitalwallet.app.di;

import com.digitalwallet.app.view.SetupActivity;
import com.digitalwallet.app.view.harvester.HarvestActivity;
import com.digitalwallet.app.view.login.LoginActivity;
import com.digitalwallet.app.view.main.MainActivity;
import com.digitalwallet.app.view.main.MainActivityServer;
import com.digitalwallet.app.view.onboarding.OnboardingActivity;
import com.digitalwallet.app.view.pin.PinActivity;
import com.digitalwallet.app.view.splash.SplashActivity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/di/AppComponent;", "", "inject", "", "activity", "Lcom/digitalwallet/app/view/SetupActivity;", "harvestActivity", "Lcom/digitalwallet/app/view/harvester/HarvestActivity;", "loginActivity", "Lcom/digitalwallet/app/view/login/LoginActivity;", "mainActivity", "Lcom/digitalwallet/app/view/main/MainActivity;", "Lcom/digitalwallet/app/view/main/MainActivityServer;", "Lcom/digitalwallet/app/view/onboarding/OnboardingActivity;", "pinActivity", "Lcom/digitalwallet/app/view/pin/PinActivity;", "splashActivity", "Lcom/digitalwallet/app/view/splash/SplashActivity;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: AppComponent.kt */
public interface AppComponent {
    void inject(SetupActivity setupActivity);

    void inject(HarvestActivity harvestActivity);

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

    void inject(MainActivityServer mainActivityServer);

    void inject(OnboardingActivity onboardingActivity);

    void inject(PinActivity pinActivity);

    void inject(SplashActivity splashActivity);
}
