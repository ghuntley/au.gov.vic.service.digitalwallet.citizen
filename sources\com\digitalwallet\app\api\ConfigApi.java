package com.digitalwallet.app.api;

import com.digitalwallet.app.oidc.model.BootstrapConfig;
import com.google.android.gms.common.internal.ImagesContract;
import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Url;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/digitalwallet/app/api/ConfigApi;", "", "getBootstrapDocument", "Lio/reactivex/Single;", "Lcom/digitalwallet/app/oidc/model/BootstrapConfig;", "getKeys", "Lcom/nimbusds/jose/jwk/JWKSet;", ImagesContract.URL, "", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConfigApi.kt */
public interface ConfigApi {
    public static final String CONFIGURATION_DOCUMENT_PATH = "application-config.json";
    public static final Companion Companion = Companion.$$INSTANCE;

    @GET("application-config.json")
    Single<BootstrapConfig> getBootstrapDocument();

    @GET
    Single<JWKSet> getKeys(@Url String str);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/digitalwallet/app/api/ConfigApi$Companion;", "", "()V", "CONFIGURATION_DOCUMENT_PATH", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ConfigApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CONFIGURATION_DOCUMENT_PATH = "application-config.json";

        private Companion() {
        }
    }
}
