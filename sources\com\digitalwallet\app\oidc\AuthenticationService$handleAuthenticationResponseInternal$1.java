package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.model.Tokens;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/digitalwallet/app/oidc/model/Tokens;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final /* synthetic */ class AuthenticationService$handleAuthenticationResponseInternal$1 extends FunctionReferenceImpl implements Function1<Tokens, Unit> {
    AuthenticationService$handleAuthenticationResponseInternal$1(AuthenticationUtility authenticationUtility) {
        super(1, authenticationUtility, AuthenticationUtility.class, "setTokens", "setTokens(Lcom/digitalwallet/app/oidc/model/Tokens;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tokens tokens) {
        invoke(tokens);
        return Unit.INSTANCE;
    }

    public final void invoke(Tokens tokens) {
        Intrinsics.checkNotNullParameter(tokens, "p1");
        ((AuthenticationUtility) this.receiver).setTokens(tokens);
    }
}
