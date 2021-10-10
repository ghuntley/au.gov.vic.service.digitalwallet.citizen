package com.digitalwallet.services;

import com.digitalwallet.model.RemoteConfig;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rR\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/services/RemoteConfigService;", "", "httpClient", "Lokhttp3/OkHttpClient;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lokhttp3/OkHttpClient;Lcom/squareup/moshi/Moshi;)V", "<set-?>", "Lcom/digitalwallet/model/RemoteConfig;", "cached", "getCached", "()Lcom/digitalwallet/model/RemoteConfig;", "getRemoteConfig", "Lio/reactivex/Single;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RemoteConfigService.kt */
public final class RemoteConfigService {
    private RemoteConfig cached;
    private final OkHttpClient httpClient;
    private final Moshi moshi;

    @Inject
    public RemoteConfigService(@Named("NoInterceptor") OkHttpClient okHttpClient, Moshi moshi2) {
        Intrinsics.checkNotNullParameter(okHttpClient, "httpClient");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.httpClient = okHttpClient;
        this.moshi = moshi2;
    }

    public final RemoteConfig getCached() {
        return this.cached;
    }

    public final Single<RemoteConfig> getRemoteConfig() {
        Single<RemoteConfig> create = Single.create(new RemoteConfigService$getRemoteConfig$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Single.create { emitter …       }\n        })\n    }");
        return create;
    }
}
