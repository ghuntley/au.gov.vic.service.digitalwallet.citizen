package com.digitalwallet.app.di;

import android.content.Context;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OIDCModule_ProvideAuthenticationUtilityFactory implements Factory<AuthenticationUtility> {
    private final Provider<Context> contextProvider;
    private final OIDCModule module;
    private final Provider<Moshi> moshiProvider;

    public OIDCModule_ProvideAuthenticationUtilityFactory(OIDCModule oIDCModule, Provider<Context> provider, Provider<Moshi> provider2) {
        this.module = oIDCModule;
        this.contextProvider = provider;
        this.moshiProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AuthenticationUtility get() {
        return provideAuthenticationUtility(this.module, this.contextProvider.get(), this.moshiProvider.get());
    }

    public static OIDCModule_ProvideAuthenticationUtilityFactory create(OIDCModule oIDCModule, Provider<Context> provider, Provider<Moshi> provider2) {
        return new OIDCModule_ProvideAuthenticationUtilityFactory(oIDCModule, provider, provider2);
    }

    public static AuthenticationUtility provideAuthenticationUtility(OIDCModule oIDCModule, Context context, Moshi moshi) {
        return (AuthenticationUtility) Preconditions.checkNotNull(oIDCModule.provideAuthenticationUtility(context, moshi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
