package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.model.AuthenticationConfig;
import com.digitalwallet.app.oidc.model.Tokens;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Request;
import okhttp3.Response;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/digitalwallet/app/oidc/model/Tokens;", "kotlin.jvm.PlatformType", "it", "Lcom/digitalwallet/app/oidc/AuthSession;", "apply", "com/digitalwallet/app/oidc/OIDCRequestHandler$refreshAndRetry$1$newTokens$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: OIDCRequestHandler.kt */
public final class OIDCRequestHandler$refreshAndRetry$$inlined$synchronized$lambda$1<T, R> implements Function<AuthSession, SingleSource<? extends Tokens>> {
    final /* synthetic */ String $apiUrl$inlined;
    final /* synthetic */ AuthenticationConfig $authenticationConfig$inlined;
    final /* synthetic */ Request $originalRequest$inlined;
    final /* synthetic */ Ref.ObjectRef $request$inlined;
    final /* synthetic */ Response $response$inlined;
    final /* synthetic */ Tokens $tokens$inlined;
    final /* synthetic */ OIDCRequestHandler this$0;

    OIDCRequestHandler$refreshAndRetry$$inlined$synchronized$lambda$1(OIDCRequestHandler oIDCRequestHandler, Response response, Tokens tokens, Ref.ObjectRef objectRef, Request request, AuthenticationConfig authenticationConfig, String str) {
        this.this$0 = oIDCRequestHandler;
        this.$response$inlined = response;
        this.$tokens$inlined = tokens;
        this.$request$inlined = objectRef;
        this.$originalRequest$inlined = request;
        this.$authenticationConfig$inlined = authenticationConfig;
        this.$apiUrl$inlined = str;
    }

    public final SingleSource<? extends Tokens> apply(AuthSession authSession) {
        Intrinsics.checkNotNullParameter(authSession, "it");
        return this.this$0.getAuthenticationService().refreshAuthorization(authSession, this.$tokens$inlined);
    }
}
