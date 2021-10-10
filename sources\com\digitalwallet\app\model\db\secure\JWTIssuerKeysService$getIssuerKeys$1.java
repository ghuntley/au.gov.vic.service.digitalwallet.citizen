package com.digitalwallet.app.model.db.secure;

import androidx.core.app.NotificationCompat;
import com.nimbusds.jose.jwk.JWKSet;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/nimbusds/jose/jwk/JWKSet;", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: JWTIssuerKeys.kt */
public final class JWTIssuerKeysService$getIssuerKeys$1<V> implements Callable<JWKSet> {
    final /* synthetic */ JWTIssuerKeysService this$0;

    JWTIssuerKeysService$getIssuerKeys$1(JWTIssuerKeysService jWTIssuerKeysService) {
        this.this$0 = jWTIssuerKeysService;
    }

    @Override // java.util.concurrent.Callable
    public final JWKSet call() {
        JWTIssuerKeys jWTIssuerKeys = (JWTIssuerKeys) CollectionsKt.firstOrNull((List) this.this$0.jwtIssuerKeysDao.getAll());
        if (jWTIssuerKeys != null) {
            return jWTIssuerKeys.getIssuerKeys();
        }
        return null;
    }
}
