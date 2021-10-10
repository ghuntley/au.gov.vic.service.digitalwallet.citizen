package com.digitalwallet.app.view.main;

import android.view.animation.Animation;
import com.digitalwallet.app.view.hologram.HologramView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
final class HoldingDetailFragment$onSensorChanged$1 implements Runnable {
    final /* synthetic */ float $lerpedAngle;
    final /* synthetic */ HoldingDetailFragment this$0;

    HoldingDetailFragment$onSensorChanged$1(HoldingDetailFragment holdingDetailFragment, float f) {
        this.this$0 = holdingDetailFragment;
        this.$lerpedAngle = f;
    }

    public final void run() {
        Animation animation = HoldingDetailFragment.access$getCardView$p(this.this$0).getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        HoldingDetailFragment.access$getCardView$p(this.this$0).setRotationY(this.$lerpedAngle);
        HologramView hologramView = this.this$0.hologram;
        if (hologramView != null) {
            hologramView.rotate(this.$lerpedAngle * 1.8f);
            float abs = Math.abs(this.$lerpedAngle) / 7.5f;
            float cos = (1.0f - ((float) Math.cos((double) ((((float) 3.141592653589793d) * abs) * 1.5f)))) * 0.5f;
            if (!(this.this$0.getViewModel().getShowHoldingFrontView() && this.this$0.isUserFocus() && abs < 1.0f && (this.this$0.canFlip))) {
                cos = 0.0f;
            }
            hologramView.fade(cos);
        }
        this.this$0.lastAngle = this.$lerpedAngle;
    }
}
