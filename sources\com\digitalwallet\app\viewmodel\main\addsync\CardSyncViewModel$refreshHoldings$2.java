package com.digitalwallet.app.viewmodel.main.addsync;

import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lio/reactivex/SingleSource;", "", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/digitalwallet/app/model/SecureHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
public final class CardSyncViewModel$refreshHoldings$2<T, R> implements Function<Pair<? extends List<? extends UnsecuredHolding>, ? extends List<? extends SecureHolding>>, SingleSource<? extends List<? extends UnsecuredHolding>>> {
    final /* synthetic */ CardSyncViewModel this$0;

    CardSyncViewModel$refreshHoldings$2(CardSyncViewModel cardSyncViewModel) {
        this.this$0 = cardSyncViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ SingleSource<? extends List<? extends UnsecuredHolding>> apply(Pair<? extends List<? extends UnsecuredHolding>, ? extends List<? extends SecureHolding>> pair) {
        return apply((Pair<? extends List<? extends UnsecuredHolding>, ? extends List<SecureHolding>>) pair);
    }

    public final SingleSource<? extends List<UnsecuredHolding>> apply(Pair<? extends List<? extends UnsecuredHolding>, ? extends List<SecureHolding>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        final List list = (List) pair.component1();
        List<SecureHolding> list2 = (List) pair.component2();
        HoldingsService holdingsService = this.this$0.holdingsService;
        List list3 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (Iterator<T> it = list3.iterator(); it.hasNext(); it = it) {
            T next = it.next();
            arrayList.add(new SecureHolding(next.getLink(), next.getAttributes(), "", next.getDisplay(), next.getAssets(), null, 32, null));
        }
        return holdingsService.downloadAssets(arrayList, list2).flatMap(new Function<List<? extends SecureHolding>, SingleSource<? extends List<? extends SecureHolding>>>(this) {
            /* class com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$refreshHoldings$2.AnonymousClass2 */
            final /* synthetic */ CardSyncViewModel$refreshHoldings$2 this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ SingleSource<? extends List<? extends SecureHolding>> apply(List<? extends SecureHolding> list) {
                return apply((List<SecureHolding>) list);
            }

            public final SingleSource<? extends List<SecureHolding>> apply(List<SecureHolding> list) {
                Intrinsics.checkNotNullParameter(list, "secure");
                return this.this$0.this$0.holdingsService.storeAndCleanUp(list, list);
            }
        }).map(new Function<List<? extends SecureHolding>, List<? extends UnsecuredHolding>>() {
            /* class com.digitalwallet.app.viewmodel.main.addsync.CardSyncViewModel$refreshHoldings$2.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public /* bridge */ /* synthetic */ List<? extends UnsecuredHolding> apply(List<? extends SecureHolding> list) {
                return apply((List<SecureHolding>) list);
            }

            public final List<UnsecuredHolding> apply(List<SecureHolding> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                return list;
            }
        });
    }
}
