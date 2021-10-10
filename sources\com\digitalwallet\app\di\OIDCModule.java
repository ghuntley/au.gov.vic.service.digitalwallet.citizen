package com.digitalwallet.app.di;

import android.content.Context;
import com.digitalwallet.app.api.AuthApi;
import com.digitalwallet.app.api.ConfigApi;
import com.digitalwallet.app.oidc.AuthenticationService;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.OIDCRequestHandler;
import com.digitalwallet.app.oidc.config.ConfigService;
import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.digitalwallet.di.ActivityScope;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0007¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/di/OIDCModule;", "", "()V", "provideAuthenticationEndpoints", "Lcom/digitalwallet/app/oidc/AuthenticationService;", "configDoc", "Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "authUtil", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "moshi", "Lcom/squareup/moshi/Moshi;", "authApi", "Lcom/digitalwallet/app/api/AuthApi;", "provideAuthenticationUtility", "context", "Landroid/content/Context;", "provideConfigurationDocument", "configApi", "Lcom/digitalwallet/app/api/ConfigApi;", "provideOIDCRequestHandler", "Lcom/digitalwallet/app/oidc/OIDCRequestHandler;", "authenticationService", "authenticationUtility", "configurationDocument", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@Module
/* compiled from: OIDCModule.kt */
public final class OIDCModule {
    @Provides
    @ActivityScope
    public final AuthenticationService provideAuthenticationEndpoints(ConfigurationDocument configurationDocument, AuthenticationUtility authenticationUtility, Moshi moshi, AuthApi authApi) {
        Intrinsics.checkNotNullParameter(configurationDocument, "configDoc");
        Intrinsics.checkNotNullParameter(authenticationUtility, "authUtil");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(authApi, "authApi");
        return new AuthenticationService(configurationDocument, authenticationUtility, moshi, authApi);
    }

    @Provides
    @ActivityScope
    public final ConfigurationDocument provideConfigurationDocument(ConfigApi configApi) {
        Intrinsics.checkNotNullParameter(configApi, "configApi");
        return new ConfigService(configApi);
    }

    @Provides
    @ActivityScope
    public final AuthenticationUtility provideAuthenticationUtility(Context context, Moshi moshi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        return new AuthenticationUtility(context, moshi);
    }

    @Provides
    @ActivityScope
    public final OIDCRequestHandler provideOIDCRequestHandler(AuthenticationService authenticationService, AuthenticationUtility authenticationUtility, ConfigurationDocument configurationDocument) {
        Intrinsics.checkNotNullParameter(authenticationService, "authenticationService");
        Intrinsics.checkNotNullParameter(authenticationUtility, "authenticationUtility");
        Intrinsics.checkNotNullParameter(configurationDocument, "configurationDocument");
        return new OIDCRequestHandler(authenticationService, authenticationUtility, configurationDocument);
    }
}
