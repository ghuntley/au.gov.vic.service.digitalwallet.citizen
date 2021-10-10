package com.digitalwallet.app.model.db.unsecure;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: UnsecuredStore.kt */
public final class UnsecuredStore$addAll$1<V> implements Callable<Object> {
    final /* synthetic */ UnsecuredHoldingRoom[] $roomHoldings;
    final /* synthetic */ UnsecuredStore this$0;

    UnsecuredStore$addAll$1(UnsecuredStore unsecuredStore, UnsecuredHoldingRoom[] unsecuredHoldingRoomArr) {
        this.this$0 = unsecuredStore;
        this.$roomHoldings = unsecuredHoldingRoomArr;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        UnsecuredHoldingDao unsecuredHoldingDao = this.this$0.holdingDao;
        UnsecuredHoldingRoom[] unsecuredHoldingRoomArr = this.$roomHoldings;
        unsecuredHoldingDao.insertAll((UnsecuredHoldingRoom[]) Arrays.copyOf(unsecuredHoldingRoomArr, unsecuredHoldingRoomArr.length));
    }
}
