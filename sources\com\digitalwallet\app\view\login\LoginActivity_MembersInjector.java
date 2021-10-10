package com.digitalwallet.app.view.login;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.app.view.base.BaseAppActivity_MembersInjector;
import com.digitalwallet.app.viewmodel.login.LoginActivityViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.services.RemoteConfigService;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<RemoteConfigService> remoteConfigServiceProvider;
    private final Provider<RemoteSubscriptionService> remoteSubscriptionServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<LoginActivityViewModel> viewModelProvider;

    public LoginActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<LoginActivityViewModel> provider4, Provider<RemoteConfigService> provider5, Provider<RemoteSubscriptionService> provider6) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
        this.viewModelProvider = provider4;
        this.remoteConfigServiceProvider = provider5;
        this.remoteSubscriptionServiceProvider = provider6;
    }

    public static MembersInjector<LoginActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<LoginActivityViewModel> provider4, Provider<RemoteConfigService> provider5, Provider<RemoteSubscriptionService> provider6) {
        return new LoginActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public void injectMembers(LoginActivity loginActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(loginActivity, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(loginActivity, this.viewModelFactoryProvider.get());
        BaseAppActivity_MembersInjector.injectAppStartUp(loginActivity, this.appStartUpProvider.get());
        injectViewModel(loginActivity, this.viewModelProvider.get());
        injectRemoteConfigService(loginActivity, this.remoteConfigServiceProvider.get());
        injectRemoteSubscriptionService(loginActivity, this.remoteSubscriptionServiceProvider.get());
    }

    public static void injectViewModel(LoginActivity loginActivity, LoginActivityViewModel loginActivityViewModel) {
        loginActivity.viewModel = loginActivityViewModel;
    }

    public static void injectRemoteConfigService(LoginActivity loginActivity, RemoteConfigService remoteConfigService) {
        loginActivity.remoteConfigService = remoteConfigService;
    }

    public static void injectRemoteSubscriptionService(LoginActivity loginActivity, RemoteSubscriptionService remoteSubscriptionService) {
        loginActivity.remoteSubscriptionService = remoteSubscriptionService;
    }
}
