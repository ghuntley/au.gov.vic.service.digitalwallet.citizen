package com.digitalwallet.app.holdings;

import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredStore;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "localHoldings", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsDbService.kt */
public final class HoldingsDbService$storeUnsecuredHoldings$1<T, R> implements Function<List<? extends UnsecuredHolding>, CompletableSource> {
    final /* synthetic */ List $remoteHoldings;
    final /* synthetic */ HoldingsDbService this$0;

    HoldingsDbService$storeUnsecuredHoldings$1(HoldingsDbService holdingsDbService, List list) {
        this.this$0 = holdingsDbService;
        this.$remoteHoldings = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v4, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.List */
    /* JADX WARN: Multi-variable type inference failed */
    public final CompletableSource apply(List<? extends UnsecuredHolding> list) {
        Completable completable;
        Completable completable2;
        Intrinsics.checkNotNullParameter(list, "localHoldings");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : this.$remoteHoldings) {
            T t2 = t;
            List<? extends UnsecuredHolding> list2 = list;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList3.add(it.next().getLink());
            }
            if (arrayList3.contains(t2.getLink())) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list3 = (List) pair.component1();
        List list4 = (List) pair.component2();
        if (!list4.isEmpty()) {
            UnsecuredStore unsecuredStore = this.this$0.unsecuredStore;
            Object[] array = list4.toArray(new UnsecuredHolding[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            UnsecuredHolding[] unsecuredHoldingArr = (UnsecuredHolding[]) array;
            completable = unsecuredStore.addAll((UnsecuredHolding[]) Arrays.copyOf(unsecuredHoldingArr, unsecuredHoldingArr.length));
        } else {
            completable = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completable, "Completable.complete()");
        }
        List list5 = list3;
        if (!list5.isEmpty()) {
            UnsecuredStore unsecuredStore2 = this.this$0.unsecuredStore;
            Object[] array2 = list5.toArray(new UnsecuredHolding[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            UnsecuredHolding[] unsecuredHoldingArr2 = (UnsecuredHolding[]) array2;
            completable2 = unsecuredStore2.updateAll((UnsecuredHolding[]) Arrays.copyOf(unsecuredHoldingArr2, unsecuredHoldingArr2.length));
        } else {
            completable2 = Completable.complete();
            Intrinsics.checkNotNullExpressionValue(completable2, "Completable.complete()");
        }
        return Completable.concat(CollectionsKt.listOf((Object[]) new Completable[]{completable, completable2}));
    }
}
