package com.digitalwallet.app.view.main.adapter;

import android.view.View;
import com.digitalwallet.app.view.main.adapter.HoldingListAdapter;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingListAdapter.kt */
public final class HoldingListAdapter$CardItemViewHolder$bind$3 implements View.OnClickListener {
    final /* synthetic */ int $index;
    final /* synthetic */ HoldingListAdapter.CardItemViewHolder this$0;

    HoldingListAdapter$CardItemViewHolder$bind$3(HoldingListAdapter.CardItemViewHolder cardItemViewHolder, int i) {
        this.this$0 = cardItemViewHolder;
        this.$index = i;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getSelectedHolding().onNext(((CardListItem) this.this$0.this$0.cardsList.get(this.$index)).getHolding());
    }
}
