package com.digitalwallet.app.model.db.secure;

import androidx.core.app.NotificationCompat;
import com.nimbusds.jose.jwk.JWKSet;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: JWTIssuerKeys.kt */
public final class JWTIssuerKeysService$updateIssuerKeys$1<V> implements Callable<Object> {
    final /* synthetic */ JWKSet $issuerKeys;
    final /* synthetic */ JWTIssuerKeysService this$0;

    JWTIssuerKeysService$updateIssuerKeys$1(JWTIssuerKeysService jWTIssuerKeysService, JWKSet jWKSet) {
        this.this$0 = jWTIssuerKeysService;
        this.$issuerKeys = jWKSet;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.this$0.jwtIssuerKeysDao.deleteAll();
        JWKSet jWKSet = this.$issuerKeys;
        if (jWKSet == null) {
            return null;
        }
        this.this$0.jwtIssuerKeysDao.insert(new JWTIssuerKeys(jWKSet.hashCode(), jWKSet));
        return Unit.INSTANCE;
    }
}
