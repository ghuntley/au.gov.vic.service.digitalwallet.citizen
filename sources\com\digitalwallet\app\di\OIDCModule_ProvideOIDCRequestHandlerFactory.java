package com.digitalwallet.app.di;

import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.OIDCRequestHandler;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OIDCModule_ProvideOIDCRequestHandlerFactory implements Factory<OIDCRequestHandler> {
    private final Provider<AuthenticationService> authenticationServiceProvider;
    private final Provider<AuthenticationUtility> authenticationUtilityProvider;
    private final Provider<ConfigurationDocument> configurationDocumentProvider;
    private final OIDCModule module;

    public OIDCModule_ProvideOIDCRequestHandlerFactory(OIDCModule oIDCModule, Provider<AuthenticationService> provider, Provider<AuthenticationUtility> provider2, Provider<ConfigurationDocument> provider3) {
        this.module = oIDCModule;
        this.authenticationServiceProvider = provider;
        this.authenticationUtilityProvider = provider2;
        this.configurationDocumentProvider = provider3;
    }

    @Override // javax.inject.Provider
    public OIDCRequestHandler get() {
        return provideOIDCRequestHandler(this.module, this.authenticationServiceProvider.get(), this.authenticationUtilityProvider.get(), this.configurationDocumentProvider.get());
    }

    public static OIDCModule_ProvideOIDCRequestHandlerFactory create(OIDCModule oIDCModule, Provider<AuthenticationService> provider, Provider<AuthenticationUtility> provider2, Provider<ConfigurationDocument> provider3) {
        return new OIDCModule_ProvideOIDCRequestHandlerFactory(oIDCModule, provider, provider2, provider3);
    }

    public static OIDCRequestHandler provideOIDCRequestHandler(OIDCModule oIDCModule, AuthenticationService authenticationService, AuthenticationUtility authenticationUtility, ConfigurationDocument configurationDocument) {
        return (OIDCRequestHandler) Preconditions.checkNotNull(oIDCModule.provideOIDCRequestHandler(authenticationService, authenticationUtility, configurationDocument), "Cannot return null from a non-@Nullable @Provides method");
    }
}
