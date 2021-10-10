package com.digitalwallet.app.view.main;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "accept", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: CardAddFragment.kt */
final class CardAddFragment$onStart$2<T> implements Consumer<Unit> {
    final /* synthetic */ CardAddFragment this$0;

    CardAddFragment$onStart$2(CardAddFragment cardAddFragment) {
        this.this$0 = cardAddFragment;
    }

    public final void accept(Unit unit) {
        this.this$0.getParentFragmentManager().popBackStack();
    }
}
