package com.digitalwallet.app.model.db.shares;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/model/db/shares/ShareRecordStore;", "", "shareRecordDao", "Lcom/digitalwallet/app/model/db/shares/ShareRecordDao;", "(Lcom/digitalwallet/app/model/db/shares/ShareRecordDao;)V", "addRecord", "Lio/reactivex/Completable;", "shareRecord", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "delete", "record", "getAll", "Lio/reactivex/Single;", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ShareRecordStore.kt */
public final class ShareRecordStore {
    private final ShareRecordDao shareRecordDao;

    @Inject
    public ShareRecordStore(ShareRecordDao shareRecordDao2) {
        Intrinsics.checkNotNullParameter(shareRecordDao2, "shareRecordDao");
        this.shareRecordDao = shareRecordDao2;
    }

    public final Completable addRecord(ShareRecord shareRecord) {
        Intrinsics.checkNotNullParameter(shareRecord, "shareRecord");
        Completable fromCallable = Completable.fromCallable(new ShareRecordStore$addRecord$1(this, shareRecord));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…serted: $response\")\n    }");
        return fromCallable;
    }

    public final Single<List<ShareRecord>> getAll() {
        Single<List<ShareRecord>> fromCallable = Single.fromCallable(new ShareRecordStore$getAll$1(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable { shareRecordDao.getAll() }");
        return fromCallable;
    }

    public final Completable delete(ShareRecord shareRecord) {
        Intrinsics.checkNotNullParameter(shareRecord, "record");
        Completable fromCallable = Completable.fromCallable(new ShareRecordStore$delete$1(this, shareRecord));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…ecordDao.delete(record) }");
        return fromCallable;
    }
}
