package com.digitalwallet.app.view.base;

import com.digitalwallet.di.ViewModelFactory;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class AppDaggerAppCompatActivity_MembersInjector implements MembersInjector<AppDaggerAppCompatActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;

    public AppDaggerAppCompatActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<AppDaggerAppCompatActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2) {
        return new AppDaggerAppCompatActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(AppDaggerAppCompatActivity appDaggerAppCompatActivity) {
        injectAndroidInjector(appDaggerAppCompatActivity, this.androidInjectorProvider.get());
        injectViewModelFactory(appDaggerAppCompatActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectAndroidInjector(AppDaggerAppCompatActivity appDaggerAppCompatActivity, DispatchingAndroidInjector<Object> dispatchingAndroidInjector) {
        appDaggerAppCompatActivity.androidInjector = dispatchingAndroidInjector;
    }

    public static void injectViewModelFactory(AppDaggerAppCompatActivity appDaggerAppCompatActivity, ViewModelFactory viewModelFactory) {
        appDaggerAppCompatActivity.viewModelFactory = viewModelFactory;
    }
}
