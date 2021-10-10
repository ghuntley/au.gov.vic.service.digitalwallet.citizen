package com.digitalwallet.app.connection;

import android.app.Application;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HandshakeService;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BLEServer_Factory implements Factory<BLEServer> {
    private final Provider<Application> applicationProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<BLEUtil> bleUtilProvider;
    private final Provider<HandshakeService> handshakeServiceProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;

    public BLEServer_Factory(Provider<Application> provider, Provider<BLEUtil> provider2, Provider<AuthenticationUtility> provider3, Provider<HandshakeService> provider4, Provider<HoldingsService> provider5) {
        this.applicationProvider = provider;
        this.bleUtilProvider = provider2;
        this.authenticationUtilityProvider = provider3;
        this.handshakeServiceProvider = provider4;
        this.holdingsServiceProvider = provider5;
    }

    @Override // javax.inject.Provider
    public BLEServer get() {
        return new BLEServer(this.applicationProvider.get(), this.bleUtilProvider.get(), this.authenticationUtilityProvider.get(), this.handshakeServiceProvider.get(), this.holdingsServiceProvider.get());
    }

    public static BLEServer_Factory create(Provider<Application> provider, Provider<BLEUtil> provider2, Provider<AuthenticationUtility> provider3, Provider<HandshakeService> provider4, Provider<HoldingsService> provider5) {
        return new BLEServer_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BLEServer newInstance(Application application, BLEUtil bLEUtil, AuthenticationUtility authenticationUtility, HandshakeService handshakeService, HoldingsService holdingsService) {
        return new BLEServer(application, bLEUtil, authenticationUtility, handshakeService, holdingsService);
    }
}
