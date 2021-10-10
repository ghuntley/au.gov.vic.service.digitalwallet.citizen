package com.digitalwallet.app.oidc.config;

import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lcom/nimbusds/jose/jwk/JWKSet;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public final class ConfigService$getIssuerKeysFromCache$1<T> implements SingleOnSubscribe<JWKSet> {
    final /* synthetic */ ConfigService this$0;

    ConfigService$getIssuerKeysFromCache$1(ConfigService configService) {
        this.this$0 = configService;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<JWKSet> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        JWKSet jWKSet = this.this$0.cachedKeys;
        if (jWKSet != null) {
            singleEmitter.onSuccess(jWKSet);
        } else {
            singleEmitter.onError(new Exception("IMPLEMENT A CACHE"));
        }
    }
}
