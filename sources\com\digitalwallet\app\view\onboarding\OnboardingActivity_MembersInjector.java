package com.digitalwallet.app.view.onboarding;

import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.view.base.AppDaggerAppCompatActivity_MembersInjector;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class OnboardingActivity_MembersInjector implements MembersInjector<OnboardingActivity> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<RemoteConfigService> remoteConfigServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public OnboardingActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AuthenticationUtility> provider3, Provider<RemoteConfigService> provider4, Provider<AnalyticsHelper> provider5) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.authenticationUtilityProvider = provider3;
        this.remoteConfigServiceProvider = provider4;
        this.analyticsProvider = provider5;
    }

    public static MembersInjector<OnboardingActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AuthenticationUtility> provider3, Provider<RemoteConfigService> provider4, Provider<AnalyticsHelper> provider5) {
        return new OnboardingActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public void injectMembers(OnboardingActivity onboardingActivity) {
        AppDaggerAppCompatActivity_MembersInjector.injectAndroidInjector(onboardingActivity, this.androidInjectorProvider.get());
        AppDaggerAppCompatActivity_MembersInjector.injectViewModelFactory(onboardingActivity, this.viewModelFactoryProvider.get());
        injectAuthenticationUtility(onboardingActivity, this.authenticationUtilityProvider.get());
        injectRemoteConfigService(onboardingActivity, this.remoteConfigServiceProvider.get());
        injectAnalytics(onboardingActivity, this.analyticsProvider.get());
    }

    public static void injectAuthenticationUtility(OnboardingActivity onboardingActivity, AuthenticationUtility authenticationUtility) {
        onboardingActivity.authenticationUtility = authenticationUtility;
    }

    public static void injectRemoteConfigService(OnboardingActivity onboardingActivity, RemoteConfigService remoteConfigService) {
        onboardingActivity.remoteConfigService = remoteConfigService;
    }

    public static void injectAnalytics(OnboardingActivity onboardingActivity, AnalyticsHelper analyticsHelper) {
        onboardingActivity.analytics = analyticsHelper;
    }
}
