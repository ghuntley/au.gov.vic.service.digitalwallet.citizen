package com.digitalwallet.app.view.main;

import com.digitalwallet.app.AppStartUp;
import com.digitalwallet.app.connection.BLEServer;
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

public final class MainActivityServer_MembersInjector implements MembersInjector<MainActivityServer> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AppStartUp> appStartUpProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<BLEServer> bleServerProvider;
    private final Provider<BluetoothEventsService> bluetoothEventsProvider;
    private final Provider<HoldingParser> holdingParserProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;
    private final Provider<RemoteSubscriptionService> remoteSubscriptionServiceProvider;
    private final Provider<ViewModelFactory> viewModelFactoryProvider;
    private final Provider<MainActivityViewModel> viewModelProvider;

    public MainActivityServer_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<MainActivityViewModel> provider4, Provider<HoldingParser> provider5, Provider<HoldingsService> provider6, Provider<AuthenticationUtility> provider7, Provider<BluetoothEventsService> provider8, Provider<RemoteSubscriptionService> provider9, Provider<BLEServer> provider10) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.appStartUpProvider = provider3;
        this.viewModelProvider = provider4;
        this.holdingParserProvider = provider5;
        this.holdingsServiceProvider = provider6;
        this.authenticationUtilityProvider = provider7;
        this.bluetoothEventsProvider = provider8;
        this.remoteSubscriptionServiceProvider = provider9;
        this.bleServerProvider = provider10;
    }

    public static MembersInjector<MainActivityServer> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<ViewModelFactory> provider2, Provider<AppStartUp> provider3, Provider<MainActivityViewModel> provider4, Provider<HoldingParser> provider5, Provider<HoldingsService> provider6, Provider<AuthenticationUtility> provider7, Provider<BluetoothEventsService> provider8, Provider<RemoteSubscriptionService> provider9, Provider<BLEServer> provider10) {
        return new MainActivityServer_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public void injectMembers(MainActivityServer mainActivityServer) {
        BaseActivity_MembersInjector.injectAndroidInjector(mainActivityServer, this.androidInjectorProvider.get());
        BaseActivity_MembersInjector.injectViewModelFactory(mainActivityServer, this.viewModelFactoryProvider.get());
        BaseAppActivity_MembersInjector.injectAppStartUp(mainActivityServer, this.appStartUpProvider.get());
        MainActivity_MembersInjector.injectViewModel(mainActivityServer, this.viewModelProvider.get());
        MainActivity_MembersInjector.injectHoldingParser(mainActivityServer, this.holdingParserProvider.get());
        MainActivity_MembersInjector.injectHoldingsService(mainActivityServer, this.holdingsServiceProvider.get());
        MainActivity_MembersInjector.injectAuthenticationUtility(mainActivityServer, this.authenticationUtilityProvider.get());
        MainActivity_MembersInjector.injectBluetoothEvents(mainActivityServer, this.bluetoothEventsProvider.get());
        MainActivity_MembersInjector.injectRemoteSubscriptionService(mainActivityServer, this.remoteSubscriptionServiceProvider.get());
        injectBleServer(mainActivityServer, this.bleServerProvider.get());
    }

    public static void injectBleServer(MainActivityServer mainActivityServer, BLEServer bLEServer) {
        mainActivityServer.bleServer = bLEServer;
    }
}
