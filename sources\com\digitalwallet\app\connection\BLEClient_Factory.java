package com.digitalwallet.app.connection;

import android.app.Application;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.utilities.AnalyticsHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BLEClient_Factory implements Factory<BLEClient> {
    private final Provider<AnalyticsHelper> analyticsProvider;
    private final Provider<Application> applicationProvider;
    private final Provider<BLEUtil> bleUtilProvider;
    private final Provider<HandshakeService> handshakeServiceProvider;
    private final Provider<HoldingsService> holdingsServiceProvider;

    public BLEClient_Factory(Provider<Application> provider, Provider<BLEUtil> provider2, Provider<AnalyticsHelper> provider3, Provider<HoldingsService> provider4, Provider<HandshakeService> provider5) {
        this.applicationProvider = provider;
        this.bleUtilProvider = provider2;
        this.analyticsProvider = provider3;
        this.holdingsServiceProvider = provider4;
        this.handshakeServiceProvider = provider5;
    }

    @Override // javax.inject.Provider
    public BLEClient get() {
        return new BLEClient(this.applicationProvider.get(), this.bleUtilProvider.get(), this.analyticsProvider.get(), this.holdingsServiceProvider.get(), this.handshakeServiceProvider.get());
    }

    public static BLEClient_Factory create(Provider<Application> provider, Provider<BLEUtil> provider2, Provider<AnalyticsHelper> provider3, Provider<HoldingsService> provider4, Provider<HandshakeService> provider5) {
        return new BLEClient_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BLEClient newInstance(Application application, BLEUtil bLEUtil, AnalyticsHelper analyticsHelper, HoldingsService holdingsService, HandshakeService handshakeService) {
        return new BLEClient(application, bLEUtil, analyticsHelper, holdingsService, handshakeService);
    }
}
