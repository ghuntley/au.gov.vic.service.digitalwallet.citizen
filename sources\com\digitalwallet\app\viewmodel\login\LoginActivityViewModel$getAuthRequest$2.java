package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.oidc.AuthSession;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lnet/openid/appauth/AuthorizationRequest;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/oidc/AuthSession;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: LoginActivityViewModel.kt */
public final class LoginActivityViewModel$getAuthRequest$2<T, R> implements Function<AuthSession, AuthorizationRequest> {
    final /* synthetic */ LoginActivityViewModel this$0;

    LoginActivityViewModel$getAuthRequest$2(LoginActivityViewModel loginActivityViewModel) {
        this.this$0 = loginActivityViewModel;
    }

    public final AuthorizationRequest apply(AuthSession authSession) {
        Intrinsics.checkNotNullParameter(authSession, "it");
        return authSession.generateAuthorizationRequest(this.this$0.moshi);
    }
}
