package com.digitalwallet.app.oidc.config;

import com.digitalwallet.app.api.ConfigApi;
import com.digitalwallet.app.oidc.model.ApiConfig;
import com.digitalwallet.app.oidc.model.BootstrapConfig;
import com.digitalwallet.utilities.RetrofitHelper;
import com.google.android.gms.common.internal.ImagesContract;
import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.Flowable;
import io.reactivex.Single;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0012J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0012J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0012J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0012R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/oidc/config/ConfigService;", "Lcom/digitalwallet/app/oidc/config/ConfigurationDocument;", "configApi", "Lcom/digitalwallet/app/api/ConfigApi;", "(Lcom/digitalwallet/app/api/ConfigApi;)V", "cachedConfig", "Lcom/digitalwallet/app/oidc/model/BootstrapConfig;", "cachedKeys", "Lcom/nimbusds/jose/jwk/JWKSet;", "throttle", "", "getBootsrapConfigFromCache", "Lio/reactivex/Single;", "getBootstrapConfigFromRemote", "getBootstrapDocument", "getIssuerKeys", "config", "Lcom/digitalwallet/app/oidc/model/ApiConfig;", "getIssuerKeysFromCache", "getIssuerKeysFromRemote", ImagesContract.URL, "", "onConnectionFailAndThrottle", "Lio/reactivex/Flowable;", "", "errors", "isOverADayOld", "", "Ljava/util/Date;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConfigService.kt */
public class ConfigService implements ConfigurationDocument {
    private BootstrapConfig cachedConfig;
    private JWKSet cachedKeys;
    private final ConfigApi configApi;
    private final long[] throttle = {1, 3, 5, 10, 30};

    @Inject
    public ConfigService(ConfigApi configApi2) {
        Intrinsics.checkNotNullParameter(configApi2, "configApi");
        this.configApi = configApi2;
    }

    @Override // com.digitalwallet.app.oidc.config.ConfigurationDocument
    public Single<BootstrapConfig> getBootstrapDocument() {
        Single<BootstrapConfig> onErrorResumeNext = getBootsrapConfigFromCache().onErrorResumeNext(new ConfigService$getBootstrapDocument$1(this));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "getBootsrapConfigFromCac…strapConfigFromRemote() }");
        return onErrorResumeNext;
    }

    @Override // com.digitalwallet.app.oidc.config.ConfigurationDocument
    public Single<JWKSet> getIssuerKeys(ApiConfig apiConfig) {
        Intrinsics.checkNotNullParameter(apiConfig, "config");
        Single<JWKSet> onErrorResumeNext = getIssuerKeysFromCache().onErrorResumeNext(new ConfigService$getIssuerKeys$1(this, apiConfig));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "getIssuerKeysFromCache()…fig.holdingSigningKeys) }");
        return onErrorResumeNext;
    }

    private Single<JWKSet> getIssuerKeysFromCache() {
        Single<JWKSet> create = Single.create(new ConfigService$getIssuerKeysFromCache$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …MPLEMENT A CACHE\"))\n    }");
        return create;
    }

    /* access modifiers changed from: private */
    public Single<JWKSet> getIssuerKeysFromRemote(String str) {
        Single<JWKSet> doOnError = this.configApi.getKeys(str).doOnSuccess(new ConfigService$getIssuerKeysFromRemote$1(this)).doOnError(new ConfigService$sam$io_reactivex_functions_Consumer$0(new ConfigService$getIssuerKeysFromRemote$2(RetrofitHelper.Companion)));
        Intrinsics.checkNotNullExpressionValue(doOnError, "configApi\n              …per::filterHttpException)");
        return doOnError;
    }

    private Single<BootstrapConfig> getBootsrapConfigFromCache() {
        Single<BootstrapConfig> create = Single.create(new ConfigService$getBootsrapConfigFromCache$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …strap is invalid\"))\n    }");
        return create;
    }

    public Single<BootstrapConfig> getBootstrapConfigFromRemote() {
        Single<BootstrapConfig> cache = this.configApi.getBootstrapDocument().doOnSuccess(new ConfigService$getBootstrapConfigFromRemote$1(this)).doOnError(new ConfigService$sam$io_reactivex_functions_Consumer$0(new ConfigService$getBootstrapConfigFromRemote$2(RetrofitHelper.Companion))).retryWhen(new ConfigService$sam$io_reactivex_functions_Function$0(new ConfigService$getBootstrapConfigFromRemote$3(this))).cache();
        Intrinsics.checkNotNullExpressionValue(cache, "configApi.getBootstrapDo…                 .cache()");
        return cache;
    }

    /* access modifiers changed from: private */
    public Flowable<Throwable> onConnectionFailAndThrottle(Flowable<Throwable> flowable) {
        Flowable<R> flatMap = flowable.takeWhile(ConfigService$onConnectionFailAndThrottle$1.INSTANCE).flatMap(new ConfigService$onConnectionFailAndThrottle$2(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "errors\n                 …DS)\n                    }");
        return flatMap;
    }

    /* access modifiers changed from: private */
    public boolean isOverADayOld(Date date) {
        return (new Date().getTime() - date.getTime()) / ((long) 86400000) >= 1;
    }
}
