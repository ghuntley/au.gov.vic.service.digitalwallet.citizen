package com.digitalwallet.app.holdings;

import com.digitalwallet.app.oidc.config.ConfigurationDocument;
import com.digitalwallet.app.oidc.model.ApiConfig;
import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/nimbusds/jose/jwk/JWKSet;", "p1", "Lcom/digitalwallet/app/oidc/model/ApiConfig;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final /* synthetic */ class HoldingsApiService$fetchSecureHoldings$4 extends FunctionReferenceImpl implements Function1<ApiConfig, Single<JWKSet>> {
    HoldingsApiService$fetchSecureHoldings$4(ConfigurationDocument configurationDocument) {
        super(1, configurationDocument, ConfigurationDocument.class, "getIssuerKeys", "getIssuerKeys(Lcom/digitalwallet/app/oidc/model/ApiConfig;)Lio/reactivex/Single;", 0);
    }

    public final Single<JWKSet> invoke(ApiConfig apiConfig) {
        Intrinsics.checkNotNullParameter(apiConfig, "p1");
        return ((ConfigurationDocument) this.receiver).getIssuerKeys(apiConfig);
    }
}
