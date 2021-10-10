package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class OIDCRequestHandler_Factory implements Factory<OIDCRequestHandler> {
    private final Provider<AuthenticationService> authenticationServiceProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<ConfigurationDocument> configurationDocumentProvider;

    public OIDCRequestHandler_Factory(Provider<AuthenticationService> provider, Provider<AuthenticationUtility> provider2, Provider<ConfigurationDocument> provider3) {
        this.authenticationServiceProvider = provider;
        this.authenticationUtilityProvider = provider2;
        this.configurationDocumentProvider = provider3;
    }

    @Override // javax.inject.Provider
    public OIDCRequestHandler get() {
        return new OIDCRequestHandler(this.authenticationServiceProvider.get(), this.authenticationUtilityProvider.get(), this.configurationDocumentProvider.get());
    }

    public static OIDCRequestHandler_Factory create(Provider<AuthenticationService> provider, Provider<AuthenticationUtility> provider2, Provider<ConfigurationDocument> provider3) {
        return new OIDCRequestHandler_Factory(provider, provider2, provider3);
    }

    public static OIDCRequestHandler newInstance(AuthenticationService authenticationService, AuthenticationUtility authenticationUtility, ConfigurationDocument configurationDocument) {
        return new OIDCRequestHandler(authenticationService, authenticationUtility, configurationDocument);
    }
}
