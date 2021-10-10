package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.oidc.AuthSession;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/oidc/AuthSession;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: LoginActivityViewModel.kt */
public final class LoginActivityViewModel$getAuthRequest$1<T> implements Consumer<AuthSession> {
    final /* synthetic */ LoginActivityViewModel this$0;

    LoginActivityViewModel$getAuthRequest$1(LoginActivityViewModel loginActivityViewModel) {
        this.this$0 = loginActivityViewModel;
    }

    public final void accept(AuthSession authSession) {
        this.this$0.setAuthSession(authSession);
    }
}
