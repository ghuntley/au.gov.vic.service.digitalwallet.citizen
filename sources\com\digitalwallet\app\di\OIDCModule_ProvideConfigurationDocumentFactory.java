package com.digitalwallet.app.di;

import com.digitalwallet.app.api.ConfigApi;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OIDCModule_ProvideConfigurationDocumentFactory implements Factory<ConfigurationDocument> {
    private final Provider<ConfigApi> configApiProvider;
    private final OIDCModule module;

    public OIDCModule_ProvideConfigurationDocumentFactory(OIDCModule oIDCModule, Provider<ConfigApi> provider) {
        this.module = oIDCModule;
        this.configApiProvider = provider;
    }

    @Override // javax.inject.Provider
    public ConfigurationDocument get() {
        return provideConfigurationDocument(this.module, this.configApiProvider.get());
    }

    public static OIDCModule_ProvideConfigurationDocumentFactory create(OIDCModule oIDCModule, Provider<ConfigApi> provider) {
        return new OIDCModule_ProvideConfigurationDocumentFactory(oIDCModule, provider);
    }

    public static ConfigurationDocument provideConfigurationDocument(OIDCModule oIDCModule, ConfigApi configApi) {
        return (ConfigurationDocument) Preconditions.checkNotNull(oIDCModule.provideConfigurationDocument(configApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
