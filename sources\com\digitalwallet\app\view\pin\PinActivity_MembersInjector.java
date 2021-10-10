package com.digitalwallet.app.view.pin;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.view.base.BaseAppActivity_MembersInjector;
import com.digitalwallet.app.viewmodel.pin.PinActivityViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class PinActivity_MembersInjector implements MembersInjector<PinActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<PinActivityViewModel> viewModelProvider;

    public PinActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<PinActivityViewModel> provider4) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
        this.viewModelProvider = provider4;
    }

    public static MembersInjector<PinActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<PinActivityViewModel> provider4) {
        return new PinActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(PinActivity pinActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(pinActivity, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(pinActivity, this.viewModelFactoryProvider.get());
        BaseAppActivity_MembersInjector.injectAppStartUp(pinActivity, this.appStartUpProvider.get());
        injectViewModel(pinActivity, this.viewModelProvider.get());
    }

    public static void injectViewModel(PinActivity pinActivity, PinActivityViewModel pinActivityViewModel) {
        pinActivity.viewModel = pinActivityViewModel;
    }
}
