package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.model.AuthenticationConfig;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationServiceConfiguration;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/app/oidc/AuthSession;", "kotlin.jvm.PlatformType", "authConfig", "Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$generateAuthSession$2<T, R> implements Function<AuthenticationConfig, SingleSource<? extends AuthSession>> {
    final /* synthetic */ AuthenticationService this$0;

    AuthenticationService$generateAuthSession$2(AuthenticationService authenticationService) {
        this.this$0 = authenticationService;
    }

    public final SingleSource<? extends AuthSession> apply(final AuthenticationConfig authenticationConfig) {
        Intrinsics.checkNotNullParameter(authenticationConfig, "authConfig");
        return this.this$0.retrieveAuthorizationServiceConfiguration(authenticationConfig).map(new Function<AuthorizationServiceConfiguration, AuthSession>() {
            /* class com.digitalwallet.app.oidc.AuthenticationService$generateAuthSession$2.AnonymousClass1 */

            public final AuthSession apply(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
                Intrinsics.checkNotNullParameter(authorizationServiceConfiguration, "it");
                AuthenticationConfig authenticationConfig = authenticationConfig;
                Intrinsics.checkNotNullExpressionValue(authenticationConfig, "authConfig");
                return new AuthSession(authenticationConfig, authorizationServiceConfiguration);
            }
        });
    }
}
