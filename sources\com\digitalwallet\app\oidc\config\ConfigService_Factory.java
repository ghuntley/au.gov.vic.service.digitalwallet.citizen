package com.digitalwallet.app.oidc.config;

import com.digitalwallet.app.api.ConfigApi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConfigService_Factory implements Factory<ConfigService> {
    private final Provider<ConfigApi> configApiProvider;

    public ConfigService_Factory(Provider<ConfigApi> provider) {
        this.configApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public ConfigService get() {
        return new ConfigService(this.configApiProvider.get());
    }

    public static ConfigService_Factory create(Provider<ConfigApi> provider) {
        return new ConfigService_Factory(provider);
    }

    public static ConfigService newInstance(ConfigApi configApi) {
        return new ConfigService(configApi);
    }
}
