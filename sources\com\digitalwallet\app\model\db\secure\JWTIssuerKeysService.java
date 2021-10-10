package com.digitalwallet.app.model.db.secure;

import com.nimbusds.jose.jwk.JWKSet;
import io.reactivex.Completable;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysService;", "", "jwtIssuerKeysDao", "Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysDao;", "(Lcom/digitalwallet/app/model/db/secure/JWTIssuerKeysDao;)V", "getIssuerKeys", "Lio/reactivex/Single;", "Lcom/nimbusds/jose/jwk/JWKSet;", "updateIssuerKeys", "Lio/reactivex/Completable;", "issuerKeys", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: JWTIssuerKeys.kt */
public final class JWTIssuerKeysService {
    private final JWTIssuerKeysDao jwtIssuerKeysDao;

    @Inject
    public JWTIssuerKeysService(JWTIssuerKeysDao jWTIssuerKeysDao) {
        Intrinsics.checkNotNullParameter(jWTIssuerKeysDao, "jwtIssuerKeysDao");
        this.jwtIssuerKeysDao = jWTIssuerKeysDao;
    }

    public final Single<JWKSet> getIssuerKeys() {
        Single<JWKSet> fromCallable = Single.fromCallable(new JWTIssuerKeysService$getIssuerKeys$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { jw…rstOrNull()?.issuerKeys }");
        return fromCallable;
    }

    public final Completable updateIssuerKeys(JWKSet jWKSet) {
        Completable fromCallable = Completable.fromCallable(new JWTIssuerKeysService$updateIssuerKeys$1(this, jWKSet));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable….hashCode(), it)) }\n    }");
        return fromCallable;
    }
}
