package com.digitalwallet.app.view.main;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import com.digitalwallet.app.databinding.FragmentHoldingDetailBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$showRotationMessage$1 implements Runnable {
    final /* synthetic */ HoldingDetailFragment this$0;

    HoldingDetailFragment$showRotationMessage$1(HoldingDetailFragment holdingDetailFragment) {
        this.this$0 = holdingDetailFragment;
    }

    public final void run() {
        TextView textView;
        if (this.this$0.rotateMessageFade == null && (textView = ((FragmentHoldingDetailBinding) this.this$0.getBinding()).rotateMessage) != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(textView, View.ALPHA, 0.0f, 1.0f).setDuration(500L);
            Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator\n         …        .setDuration(500)");
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(textView, View.ALPHA, 1.0f, 0.0f).setDuration(500L);
            Intrinsics.checkNotNullExpressionValue(duration2, "ObjectAnimator\n         …        .setDuration(500)");
            duration2.setStartDelay(1000);
            duration2.addListener(new HoldingDetailFragment$showRotationMessage$1$$special$$inlined$apply$lambda$1(this));
            HoldingDetailFragment holdingDetailFragment = this.this$0;
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(duration, duration2);
            animatorSet.start();
            Unit unit = Unit.INSTANCE;
            holdingDetailFragment.rotateMessageFade = animatorSet;
        }
    }
}
