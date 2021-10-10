package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "remoteHoldings", "localHoldings", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsService.kt */
public final class HoldingsService$refreshUnsecuredHoldings$1<T1, T2, R> implements BiFunction<List<? extends UnsecuredHolding>, List<? extends UnsecuredHolding>, List<? extends UnsecuredHolding>> {
    final /* synthetic */ HoldingsService this$0;

    HoldingsService$refreshUnsecuredHoldings$1(HoldingsService holdingsService) {
        this.this$0 = holdingsService;
    }

    public final List<UnsecuredHolding> apply(List<? extends UnsecuredHolding> list, List<? extends UnsecuredHolding> list2) {
        boolean z;
        T t;
        UnsecuredHolding mergeWithLocalHolding;
        Intrinsics.checkNotNullParameter(list, "remoteHoldings");
        Intrinsics.checkNotNullParameter(list2, "localHoldings");
        List<? extends UnsecuredHolding> list3 = list2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : list3) {
            if (t2.getShouldUpdate()) {
                arrayList.add(t2);
            } else {
                arrayList2.add(t2);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list4 = (List) pair.component2();
        List<UnsecuredHolding> list5 = (List) pair.component1();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        for (UnsecuredHolding unsecuredHolding : list5) {
            arrayList3.add(unsecuredHolding.getLink());
        }
        ArrayList arrayList4 = arrayList3;
        List<UnsecuredHolding> list6 = list4;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
        for (UnsecuredHolding unsecuredHolding2 : list6) {
            arrayList5.add(unsecuredHolding2.getLink());
        }
        ArrayList arrayList6 = arrayList5;
        boolean shouldAutoUpdate = this.this$0.authUtility.shouldAutoUpdate();
        List<? extends UnsecuredHolding> list7 = list;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
        for (T t3 : list7) {
            String link = t3.getLink();
            if (shouldAutoUpdate) {
                z = !arrayList6.contains(link);
            } else {
                z = arrayList4.contains(link);
            }
            t3.setShouldUpdate(z);
            Iterator<T> it = list3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual(t.getLink(), t3.getLink())) {
                    break;
                }
            }
            T t4 = t;
            if (!(t4 == null || (mergeWithLocalHolding = t3.mergeWithLocalHolding(t4)) == null)) {
                t3 = mergeWithLocalHolding;
            }
            arrayList7.add(t3);
        }
        return arrayList7;
    }
}
