package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.shares.ShareRecord;
import com.digitalwallet.app.services.TransactionSharesService;
import com.digitalwallet.utilities.ServerTypeKt;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "kotlin.jvm.PlatformType", "records", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: TransactionSharesService.kt */
public final class TransactionSharesService$getShares$2<T, R> implements Function<List<? extends ShareRecord>, List<? extends ShareRecord>> {
    public static final TransactionSharesService$getShares$2 INSTANCE = new TransactionSharesService$getShares$2();

    TransactionSharesService$getShares$2() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<? extends ShareRecord> apply(List<? extends ShareRecord> list) {
        return apply((List<ShareRecord>) list);
    }

    public final List<ShareRecord> apply(List<ShareRecord> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        int i = TransactionSharesService.WhenMappings.$EnumSwitchMapping$1[ServerTypeKt.getAppType().ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (!t.overADayOld()) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        } else if (i == 2) {
            return list;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
