package com.digitalwallet.app.di;

import com.digitalwallet.app.api.AuthApi;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OIDCModule_ProvideAuthenticationEndpointsFactory implements Factory<AuthenticationService> {
    private final Provider<AuthApi> authApiProvider;
    private final Provider<AuthenticationUtility> authUtilProvider;
    private final Provider<ConfigurationDocument> configDocProvider;
    private final OIDCModule module;
    private final Provider<Moshi> moshiProvider;

    public OIDCModule_ProvideAuthenticationEndpointsFactory(OIDCModule oIDCModule, Provider<ConfigurationDocument> provider, Provider<AuthenticationUtility> provider2, Provider<Moshi> provider3, Provider<AuthApi> provider4) {
        this.module = oIDCModule;
        this.configDocProvider = provider;
        this.authUtilProvider = provider2;
        this.moshiProvider = provider3;
        this.authApiProvider = provider4;
    }

    @Override // javax.inject.Provider
    public AuthenticationService get() {
        return provideAuthenticationEndpoints(this.module, this.configDocProvider.get(), this.authUtilProvider.get(), this.moshiProvider.get(), this.authApiProvider.get());
    }

    public static OIDCModule_ProvideAuthenticationEndpointsFactory create(OIDCModule oIDCModule, Provider<ConfigurationDocument> provider, Provider<AuthenticationUtility> provider2, Provider<Moshi> provider3, Provider<AuthApi> provider4) {
        return new OIDCModule_ProvideAuthenticationEndpointsFactory(oIDCModule, provider, provider2, provider3, provider4);
    }

    public static AuthenticationService provideAuthenticationEndpoints(OIDCModule oIDCModule, ConfigurationDocument configurationDocument, AuthenticationUtility authenticationUtility, Moshi moshi, AuthApi authApi) {
        return (AuthenticationService) Preconditions.checkNotNull(oIDCModule.provideAuthenticationEndpoints(configurationDocument, authenticationUtility, moshi, authApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
