package com.digitalwallet.app.model.db.secure;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/digitalwallet/app/model/db/secure/SecuredData;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
final class DigitalWalletSecuredStore$get$1<V> implements Callable<SecuredData> {
    final /* synthetic */ int $id;
    final /* synthetic */ DigitalWalletSecuredStore this$0;

    DigitalWalletSecuredStore$get$1(DigitalWalletSecuredStore digitalWalletSecuredStore, int i) {
        this.this$0 = digitalWalletSecuredStore;
        this.$id = i;
    }

    @Override // java.util.concurrent.Callable
    public final SecuredData call() {
        return this.this$0.database.securedHoldingDao().findById(this.$id);
    }
}
