package com.digitalwallet.app.model.db.shares;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: ShareRecordStore.kt */
public final class ShareRecordStore$addRecord$1<V> implements Callable<Object> {
    final /* synthetic */ ShareRecord $shareRecord;
    final /* synthetic */ ShareRecordStore this$0;

    ShareRecordStore$addRecord$1(ShareRecordStore shareRecordStore, ShareRecord shareRecord) {
        this.this$0 = shareRecordStore;
        this.$shareRecord = shareRecord;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        long insert = this.this$0.shareRecordDao.insert(this.$shareRecord);
        Timber.d("Inserted: " + insert, new Object[0]);
    }
}
