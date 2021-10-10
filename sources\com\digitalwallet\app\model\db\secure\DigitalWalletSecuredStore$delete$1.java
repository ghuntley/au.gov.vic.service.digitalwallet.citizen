package com.digitalwallet.app.model.db.secure;

import androidx.core.app.NotificationCompat;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: SecuredStore.kt */
final class DigitalWalletSecuredStore$delete$1<V> implements Callable<Object> {
    final /* synthetic */ SecuredData $item;
    final /* synthetic */ DigitalWalletSecuredStore this$0;

    DigitalWalletSecuredStore$delete$1(DigitalWalletSecuredStore digitalWalletSecuredStore, SecuredData securedData) {
        this.this$0 = digitalWalletSecuredStore;
        this.$item = securedData;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        SecureHoldingDao securedHoldingDao = this.this$0.database.securedHoldingDao();
        SecuredData securedData = this.$item;
        Objects.requireNonNull(securedData, "null cannot be cast to non-null type com.digitalwallet.app.model.db.secure.EncryptedSecureHoldings");
        securedHoldingDao.delete((EncryptedSecureHoldings) securedData);
    }
}
