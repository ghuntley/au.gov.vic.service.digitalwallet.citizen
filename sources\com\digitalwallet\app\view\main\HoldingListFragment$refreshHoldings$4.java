package com.digitalwallet.app.view.main;

import android.content.Intent;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.util.CardListScreenState;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "holdings", "", "Lcom/digitalwallet/app/model/SecureHolding;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$refreshHoldings$4<T> implements Consumer<List<? extends SecureHolding>> {
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$refreshHoldings$4(HoldingListFragment holdingListFragment) {
        this.this$0 = holdingListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(List<? extends SecureHolding> list) {
        accept((List<SecureHolding>) list);
    }

    public final void accept(List<SecureHolding> list) {
        HoldingListFragment holdingListFragment = this.this$0;
        Intrinsics.checkNotNullExpressionValue(list, "holdings");
        Intent unused = holdingListFragment.checkForExpiringHolding(list);
        List<SecureHolding> list2 = list;
        boolean z = true;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!it.next().getHoldingElements().getSupported()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            this.this$0.getViewModel().setScreenState(CardListScreenState.ShowCardList.INSTANCE);
        }
    }
}
