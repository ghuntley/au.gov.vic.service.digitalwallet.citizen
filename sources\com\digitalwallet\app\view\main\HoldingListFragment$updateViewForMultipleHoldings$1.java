package com.digitalwallet.app.view.main;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/digitalwallet/app/view/main/HoldingListFragment$updateViewForMultipleHoldings$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingListFragment.kt */
public final class HoldingListFragment$updateViewForMultipleHoldings$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ RecyclerView $rv;

    HoldingListFragment$updateViewForMultipleHoldings$1(RecyclerView recyclerView) {
        this.$rv = recyclerView;
    }

    public void onGlobalLayout() {
        Pair pair;
        RecyclerView.LayoutManager layoutManager = this.$rv.getLayoutManager();
        if (layoutManager != null) {
            View childAt = layoutManager.getChildAt(0);
            if (childAt != null) {
                Intrinsics.checkNotNullExpressionValue(childAt, "it");
                pair = new Pair(Integer.valueOf(childAt.getWidth()), Integer.valueOf(childAt.getLeft()));
            } else {
                pair = new Pair(0, 0);
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            Intrinsics.checkNotNullExpressionValue(layoutManager, "manager");
            layoutManager.offsetChildrenHorizontal(-(intValue2 - ((layoutManager.getWidth() - intValue) / 2)));
        }
        this.$rv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
