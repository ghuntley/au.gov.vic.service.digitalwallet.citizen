package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.model.db.shares.ShareRecordStore;
import com.digitalwallet.utilities.AppType;
import com.digitalwallet.utilities.ServerTypeKt;
import io.reactivex.Completable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "records", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionSharesService.kt */
public final class TransactionSharesService$getShares$1<T> implements Consumer<List<? extends ShareRecord>> {
    final /* synthetic */ TransactionSharesService this$0;

    TransactionSharesService$getShares$1(TransactionSharesService transactionSharesService) {
        this.this$0 = transactionSharesService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends ShareRecord> list) {
        accept((List<ShareRecord>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.digitalwallet.app.services.TransactionSharesService$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void accept(List<ShareRecord> list) {
        if (ServerTypeKt.getAppType() == AppType.AUTHORITY) {
            Intrinsics.checkNotNullExpressionValue(list, "records");
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (t.overADayOld()) {
                    arrayList.add(t);
                }
            }
            ArrayList<T> arrayList2 = arrayList;
            ShareRecordStore shareRecordStore = this.this$0.shareStore;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (T t2 : arrayList2) {
                arrayList3.add(shareRecordStore.delete(t2));
            }
            Completable subscribeOn = Completable.mergeDelayError(arrayList3).subscribeOn(Schedulers.io());
            AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
            if (r0 != null) {
                r0 = new TransactionSharesService$sam$io_reactivex_functions_Consumer$0(r0);
            }
            subscribeOn.doOnError((Consumer) r0).subscribe();
        }
    }
}
