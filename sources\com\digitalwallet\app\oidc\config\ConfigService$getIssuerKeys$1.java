package com.digitalwallet.app.oidc.config;

import com.digitalwallet.app.oidc.model.ApiConfig;
import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "Lcom/nimbusds/jose/jwk/JWKSet;", "kotlin.jvm.PlatformType", "it", "", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
final class ConfigService$getIssuerKeys$1<T, R> implements Function<Throwable, SingleSource<? extends JWKSet>> {
    final /* synthetic */ ApiConfig $config;
    final /* synthetic */ ConfigService this$0;

    ConfigService$getIssuerKeys$1(ConfigService configService, ApiConfig apiConfig) {
        this.this$0 = configService;
        this.$config = apiConfig;
    }

    public final SingleSource<? extends JWKSet> apply(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return this.this$0.getIssuerKeysFromRemote(this.$config.getHoldingSigningKeys());
    }
}
