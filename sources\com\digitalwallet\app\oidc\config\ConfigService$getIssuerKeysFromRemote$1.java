package com.digitalwallet.app.oidc.config;

import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/nimbusds/jose/jwk/JWKSet;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public final class ConfigService$getIssuerKeysFromRemote$1<T> implements Consumer<JWKSet> {
    final /* synthetic */ ConfigService this$0;

    ConfigService$getIssuerKeysFromRemote$1(ConfigService configService) {
        this.this$0 = configService;
    }

    public final void accept(JWKSet jWKSet) {
        this.this$0.cachedKeys = jWKSet;
    }
}
