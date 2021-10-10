package com.digitalwallet.app.view.main;

import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.view.util.CardListScreenState;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$refreshHoldings$2 implements Action {
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$refreshHoldings$2(HoldingListFragment holdingListFragment) {
        this.this$0 = holdingListFragment;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        SecureHolding secureHolding = this.this$0.expiringHolding;
        if (secureHolding != null) {
            this.this$0.startCardDetailFragment(secureHolding);
        }
        this.this$0.expiringHolding = null;
        this.this$0.getViewModel().setScreenState(CardListScreenState.ShowCardList.INSTANCE);
    }
}
