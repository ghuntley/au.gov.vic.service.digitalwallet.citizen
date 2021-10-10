package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionSharesService.kt */
public final /* synthetic */ class TransactionSharesService$storeNewShare$1 extends FunctionReferenceImpl implements Function1<ShareRecord, Completable> {
    TransactionSharesService$storeNewShare$1(ShareRecordStore shareRecordStore) {
        super(1, shareRecordStore, ShareRecordStore.class, "addRecord", "addRecord(Lcom/digitalwallet/app/model/db/shares/ShareRecord;)Lio/reactivex/Completable;", 0);
    }

    public final Completable invoke(ShareRecord shareRecord) {
        Intrinsics.checkNotNullParameter(shareRecord, "p1");
        return ((ShareRecordStore) this.receiver).addRecord(shareRecord);
    }
}
