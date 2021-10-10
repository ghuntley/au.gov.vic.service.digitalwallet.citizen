package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.SecureHolding;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "holdings", "Lcom/digitalwallet/app/model/SecureHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$refreshHoldings$3<T, R> implements Function<List<? extends SecureHolding>, List<? extends String>> {
    public static final HoldingListFragment$refreshHoldings$3 INSTANCE = new HoldingListFragment$refreshHoldings$3();

    HoldingListFragment$refreshHoldings$3() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ List<? extends String> apply(List<? extends SecureHolding> list) {
        return apply((List<SecureHolding>) list);
    }

    public final List<String> apply(List<SecureHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.getHoldingElements().getSupported()) {
                arrayList.add(t);
            }
        }
        ArrayList<T> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (T t2 : arrayList2) {
            arrayList3.add(t2.getLink());
        }
        return arrayList3;
    }
}
