package com.digitalwallet.app.view.main;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.holdings.HoldingParser;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.BluetoothEventsService;
import com.digitalwallet.app.services.remotenotification.RemoteSubscriptionService;
import com.digitalwallet.app.view.base.BaseAppActivity_MembersInjector;
import com.digitalwallet.app.viewmodel.main.MainActivityViewModel;
import com.digitalwallet.di.ViewModelFactory;
import com.digitalwallet.view.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<BluetoothEventsService> bluetoothEventsProvider;
    private final Provider<HoldingParser> holdingParserProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<RemoteSubscriptionService> remoteSubscriptionServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<MainActivityViewModel> viewModelProvider;

    public MainActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<MainActivityViewModel> provider4, Provider<HoldingParser> provider5, Provider<HoldingsService> provider6, Provider<AuthenticationUtility> provider7, Provider<BluetoothEventsService> provider8, Provider<RemoteSubscriptionService> provider9) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
        this.viewModelProvider = provider4;
        this.holdingParserProvider = provider5;
        this.holdingsServiceProvider = provider6;
        this.authenticationUtilityProvider = provider7;
        this.bluetoothEventsProvider = provider8;
        this.remoteSubscriptionServiceProvider = provider9;
    }

    public static MembersInjector<MainActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<MainActivityViewModel> provider4, Provider<HoldingParser> provider5, Provider<HoldingsService> provider6, Provider<AuthenticationUtility> provider7, Provider<BluetoothEventsService> provider8, Provider<RemoteSubscriptionService> provider9) {
        return new MainActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public void injectMembers(MainActivity mainActivity) {
        BaseActivity_MembersInjector.injectAndroidInjector(mainActivity, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(mainActivity, this.viewModelFactoryProvider.get());
        BaseAppActivity_MembersInjector.injectAppStartUp(mainActivity, this.appStartUpProvider.get());
        injectViewModel(mainActivity, this.viewModelProvider.get());
        injectHoldingParser(mainActivity, this.holdingParserProvider.get());
        injectHoldingsService(mainActivity, this.holdingsServiceProvider.get());
        injectAuthenticationUtility(mainActivity, this.authenticationUtilityProvider.get());
        injectBluetoothEvents(mainActivity, this.bluetoothEventsProvider.get());
        injectRemoteSubscriptionService(mainActivity, this.remoteSubscriptionServiceProvider.get());
    }

    public static void injectViewModel(MainActivity mainActivity, MainActivityViewModel mainActivityViewModel) {
        mainActivity.viewModel = mainActivityViewModel;
    }

    public static void injectHoldingParser(MainActivity mainActivity, HoldingParser holdingParser) {
        mainActivity.holdingParser = holdingParser;
    }

    public static void injectHoldingsService(MainActivity mainActivity, HoldingsService holdingsService) {
        mainActivity.holdingsService = holdingsService;
    }

    public static void injectAuthenticationUtility(MainActivity mainActivity, AuthenticationUtility authenticationUtility) {
        mainActivity.authenticationUtility = authenticationUtility;
    }

    public static void injectBluetoothEvents(MainActivity mainActivity, BluetoothEventsService bluetoothEventsService) {
        mainActivity.bluetoothEvents = bluetoothEventsService;
    }

    public static void injectRemoteSubscriptionService(MainActivity mainActivity, RemoteSubscriptionService remoteSubscriptionService) {
        mainActivity.remoteSubscriptionService = remoteSubscriptionService;
    }
}
