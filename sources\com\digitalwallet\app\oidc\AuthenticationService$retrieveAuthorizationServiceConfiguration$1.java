package com.digitalwallet.app.oidc;

import android.net.Uri;
import com.digitalwallet.app.oidc.model.AuthenticationConfig;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationServiceConfiguration;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/SingleEmitter;", "Lnet/openid/appauth/AuthorizationServiceConfiguration;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$retrieveAuthorizationServiceConfiguration$1<T> implements SingleOnSubscribe<AuthorizationServiceConfiguration> {
    final /* synthetic */ AuthenticationConfig $authenticationData;

    AuthenticationService$retrieveAuthorizationServiceConfiguration$1(AuthenticationConfig authenticationConfig) {
        this.$authenticationData = authenticationConfig;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(final SingleEmitter<AuthorizationServiceConfiguration> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        AuthorizationServiceConfiguration.fetchFromUrl(Uri.parse(this.$authenticationData.getDiscoveryUrl()), new AuthorizationServiceConfiguration.RetrieveConfigurationCallback() {
            /* class com.digitalwallet.app.oidc.AuthenticationService$retrieveAuthorizationServiceConfiguration$1.AnonymousClass1 */

            @Override // net.openid.appauth.AuthorizationServiceConfiguration.RetrieveConfigurationCallback
            public final void onFetchConfigurationCompleted(AuthorizationServiceConfiguration authorizationServiceConfiguration, AuthorizationException authorizationException) {
                if (authorizationException != null) {
                    singleEmitter.onError(authorizationException);
                } else if (authorizationServiceConfiguration == null) {
                    singleEmitter.onError(new Exception("Service Configuration is null"));
                } else {
                    singleEmitter.onSuccess(authorizationServiceConfiguration);
                }
            }
        });
    }
}
