package com.digitalwallet.app.oidc;

import android.content.Intent;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final class AuthenticationService$validateAuthenticationResponse$1<T> implements SingleOnSubscribe<String> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ int $requestCode;

    AuthenticationService$validateAuthenticationResponse$1(Intent intent, int i) {
        this.$intent = intent;
        this.$requestCode = i;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<String> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        AuthorizationResponse fromIntent = AuthorizationResponse.fromIntent(this.$intent);
        String str = fromIntent != null ? fromIntent.authorizationCode : null;
        AuthorizationException fromIntent2 = AuthorizationException.fromIntent(this.$intent);
        if (this.$requestCode != 47270) {
            throw new Exception("Request Code " + this.$requestCode + " does not match AuthCallbackIntentCode 47270");
        } else if (fromIntent2 != null) {
            throw fromIntent2;
        } else if (str != null) {
            singleEmitter.onSuccess(str);
        } else {
            throw new Exception("Authorization Response requires Authorization");
        }
    }
}
