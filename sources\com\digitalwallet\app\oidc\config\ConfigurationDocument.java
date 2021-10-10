package com.digitalwallet.app.oidc.config;

import com.digitalwallet.app.oidc.model.ApiConfig;
import com.digitalwallet.app.oidc.model.BootstrapConfig;
import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.Single;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "", "getBootstrapDocument", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/oidc/model/BootstrapConfig;", "getIssuerKeys", "Lcom/nimbusds/jose/jwk/JWKSet;", "config", "Lcom/digitalwallet/app/oidc/model/ApiConfig;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConfigurationDocument.kt */
public interface ConfigurationDocument {
    Single<BootstrapConfig> getBootstrapDocument();

    Single<JWKSet> getIssuerKeys(ApiConfig apiConfig);
}
