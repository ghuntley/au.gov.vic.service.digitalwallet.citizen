package com.digitalwallet.app.view.main;

import com.digitalwallet.app.view.util.CardListScreenState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import org.reactivestreams.Subscription;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lorg/reactivestreams/Subscription;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$refreshHoldings$1<T> implements Consumer<Subscription> {
    final /* synthetic */ HoldingListFragment this$0;

    HoldingListFragment$refreshHoldings$1(HoldingListFragment holdingListFragment) {
        this.this$0 = holdingListFragment;
    }

    public final void accept(Subscription subscription) {
        this.this$0.getViewModel().setScreenState(CardListScreenState.Loading.INSTANCE);
    }
}
