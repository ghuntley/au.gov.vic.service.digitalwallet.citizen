package com.digitalwallet.app.view.login;

import com.digitalwallet.app.oidc.AuthenticationService;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationService;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lnet/openid/appauth/AuthorizationRequest;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: LoginActivity.kt */
public final class LoginActivity$login$1<T> implements Consumer<AuthorizationRequest> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$login$1(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void accept(AuthorizationRequest authorizationRequest) {
        this.this$0.startActivityForResult(new AuthorizationService(this.this$0).getAuthorizationRequestIntent(authorizationRequest), AuthenticationService.AuthCallbackIntentCode);
    }
}
