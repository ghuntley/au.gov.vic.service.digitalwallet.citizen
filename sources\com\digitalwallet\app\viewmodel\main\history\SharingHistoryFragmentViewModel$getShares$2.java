package com.digitalwallet.app.viewmodel.main.history;

import com.digitalwallet.app.model.db.shares.ShareRecord;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/shares/ShareRecord;", "kotlin.jvm.PlatformType", "shares", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: SharingHistoryFragmentViewModel.kt */
public final class SharingHistoryFragmentViewModel$getShares$2<T, R> implements Function<List<? extends ShareRecord>, List<? extends ShareRecord>> {
    public static final SharingHistoryFragmentViewModel$getShares$2 INSTANCE = new SharingHistoryFragmentViewModel$getShares$2();

    SharingHistoryFragmentViewModel$getShares$2() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<? extends ShareRecord> apply(List<? extends ShareRecord> list) {
        return apply((List<ShareRecord>) list);
    }

    public final List<ShareRecord> apply(List<ShareRecord> list) {
        Intrinsics.checkNotNullParameter(list, "shares");
        return CollectionsKt.sortedWith(list, new SharingHistoryFragmentViewModel$getShares$2$$special$$inlined$sortedByDescending$1());
    }
}
