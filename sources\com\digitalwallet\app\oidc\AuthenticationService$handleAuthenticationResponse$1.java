package com.digitalwallet.app.oidc;

import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$handleAuthenticationResponse$1<T, R> implements Function<String, CompletableSource> {
    final /* synthetic */ AuthSession $authSession;
    final /* synthetic */ AuthenticationService this$0;

    AuthenticationService$handleAuthenticationResponse$1(AuthenticationService authenticationService, AuthSession authSession) {
        this.this$0 = authenticationService;
        this.$authSession = authSession;
    }

    public final CompletableSource apply(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return this.this$0.handleAuthenticationResponseInternal(str, this.$authSession);
    }
}
