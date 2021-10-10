package com.digitalwallet.app.view.main;

import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$flipAnimation$1 implements Runnable {
    final /* synthetic */ float $rotationAngle;
    final /* synthetic */ boolean $showFrontHoldingView;
    final /* synthetic */ HoldingDetailFragment this$0;

    HoldingDetailFragment$flipAnimation$1(HoldingDetailFragment holdingDetailFragment, boolean z, float f) {
        this.this$0 = holdingDetailFragment;
        this.$showFrontHoldingView = z;
        this.$rotationAngle = f;
    }

    public final void run() {
        this.this$0.showSide(this.$showFrontHoldingView);
        HoldingDetailFragment.access$getCardView$p(this.this$0).setRotationY(-this.$rotationAngle);
        HoldingDetailFragment.access$getCardView$p(this.this$0).animate().withLayer().rotationY(0.0f).setDuration(300).withEndAction(new Runnable(this) {
            /* class com.digitalwallet.app.view.main.HoldingDetailFragment$flipAnimation$1.AnonymousClass1 */
            final /* synthetic */ HoldingDetailFragment$flipAnimation$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.this$0.setCanFlip(true);
            }
        }).start();
    }
}
