package com.digitalwallet.app.oidc;

import android.content.Context;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$handleAuthenticationResponse$2 implements Action {
    final /* synthetic */ Context $context;
    final /* synthetic */ AuthenticationService this$0;

    AuthenticationService$handleAuthenticationResponse$2(AuthenticationService authenticationService, Context context) {
        this.this$0 = authenticationService;
        this.$context = context;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.doOnLoginComplete(this.$context);
    }
}
