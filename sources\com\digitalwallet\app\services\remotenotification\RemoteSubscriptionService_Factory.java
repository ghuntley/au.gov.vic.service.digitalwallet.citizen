package com.digitalwallet.app.services.remotenotification;

import android.content.Context;
import com.digitalwallet.app.api.DeviceRegisterApi;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RemoteSubscriptionService_Factory implements Factory<RemoteSubscriptionService> {
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DeviceRegisterApi> deviceRegisterApiProvider;

    public RemoteSubscriptionService_Factory(Provider<Context> provider, Provider<DeviceRegisterApi> provider2, Provider<AuthenticationUtility> provider3) {
        this.contextProvider = provider;
        this.deviceRegisterApiProvider = provider2;
        this.authenticationUtilityProvider = provider3;
    }

    @Override // javax.inject.Provider
    public RemoteSubscriptionService get() {
        return new RemoteSubscriptionService(this.contextProvider.get(), this.deviceRegisterApiProvider.get(), this.authenticationUtilityProvider.get());
    }

    public static RemoteSubscriptionService_Factory create(Provider<Context> provider, Provider<DeviceRegisterApi> provider2, Provider<AuthenticationUtility> provider3) {
        return new RemoteSubscriptionService_Factory(provider, provider2, provider3);
    }

    public static RemoteSubscriptionService newInstance(Context context, DeviceRegisterApi deviceRegisterApi, AuthenticationUtility authenticationUtility) {
        return new RemoteSubscriptionService(context, deviceRegisterApi, authenticationUtility);
    }
}
