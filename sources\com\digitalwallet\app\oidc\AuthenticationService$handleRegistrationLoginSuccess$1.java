package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/oidc/AuthSession;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$handleRegistrationLoginSuccess$1<T> implements Consumer<AuthSession> {
    final /* synthetic */ Tokens $tokens;
    final /* synthetic */ AuthenticationService this$0;

    AuthenticationService$handleRegistrationLoginSuccess$1(AuthenticationService authenticationService, Tokens tokens) {
        this.this$0 = authenticationService;
        this.$tokens = tokens;
    }

    public final void accept(AuthSession authSession) {
        this.this$0.getAuthenticationUtility().setTokens(this.$tokens);
        this.this$0.getAuthenticationUtility().generateSecureKey$app_citizenProdRelease();
    }
}
