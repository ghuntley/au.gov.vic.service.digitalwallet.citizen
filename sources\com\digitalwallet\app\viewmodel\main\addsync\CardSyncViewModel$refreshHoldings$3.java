package com.digitalwallet.app.viewmodel.main.addsync;

import android.content.Context;
import com.digitalwallet.app.model.HoldingAssets;
import com.digitalwallet.app.model.db.unsecure.UnsecuredHolding;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/digitalwallet/app/viewmodel/main/addsync/CardDetailItem;", "kotlin.jvm.PlatformType", "holdings", "Lcom/digitalwallet/app/model/db/unsecure/UnsecuredHolding;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardSyncViewModel.kt */
public final class CardSyncViewModel$refreshHoldings$3<T, R> implements Function<List<? extends UnsecuredHolding>, List<? extends CardDetailItem>> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CardSyncViewModel this$0;

    CardSyncViewModel$refreshHoldings$3(CardSyncViewModel cardSyncViewModel, Context context) {
        this.this$0 = cardSyncViewModel;
        this.$context = context;
    }

    public final List<CardDetailItem> apply(List<? extends UnsecuredHolding> list) {
        Intrinsics.checkNotNullParameter(list, "holdings");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t.getHoldingElements().getSupported()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (T t2 : arrayList2) {
            arrayList3.add(new CardDetailItem(t2, this.$context, new HoldingAssets(this.$context, this.this$0.assetService, t2.getAssets(), 300, 200), new CardSyncViewModel$refreshHoldings$3$2$1(this.this$0)));
        }
        return arrayList3;
    }
}
