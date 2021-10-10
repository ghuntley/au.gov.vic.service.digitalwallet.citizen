package com.digitalwallet.app.view.splash;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.view.base.BaseAppActivity_MembersInjector;
import com.digitalwallet.app.viewmodel.splash.SplashViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<SplashViewModel> viewModelProvider;

    public SplashActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<SplashViewModel> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
        this.viewModelProvider = provider4;
    }

    public static MembersInjector<SplashActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<SplashViewModel> provider4) {
        return new SplashActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(SplashActivity splashActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(splashActivity, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(splashActivity, this.viewModelFactoryProvider.get());
        BaseAppActivity_MembersInjector.injectAppStartUp(splashActivity, this.appStartUpProvider.get());
        injectViewModel(splashActivity, this.viewModelProvider.get());
    }

    public static void injectViewModel(SplashActivity splashActivity, SplashViewModel splashViewModel) {
        splashActivity.viewModel = splashViewModel;
    }
}
