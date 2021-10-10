package com.digitalwallet.app.model.db.unsecure;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: UnsecuredStore.kt */
public final class UnsecuredStore$getAll$1<V> implements Callable<List<? extends UnsecuredHolding>> {
    final /* synthetic */ UnsecuredStore this$0;

    UnsecuredStore$getAll$1(UnsecuredStore unsecuredStore) {
        this.this$0 = unsecuredStore;
    }

    /* Return type fixed from 'java.util.List<com.digitalwallet.app.model.db.unsecure.UnsecuredHolding>' to match base method */
    @Override // java.util.concurrent.Callable
    public final List<? extends UnsecuredHolding> call() {
        return this.this$0.holdingDao.getAll();
    }
}
