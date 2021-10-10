package com.digitalwallet.app.view.main;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.digitalwallet.app.databinding.FragmentHoldingDetailBinding;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$animateBanner$1 implements Action {
    final /* synthetic */ HoldingDetailFragment this$0;

    HoldingDetailFragment$animateBanner$1(HoldingDetailFragment holdingDetailFragment) {
        this.this$0 = holdingDetailFragment;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        FrameLayout frameLayout = ((FragmentHoldingDetailBinding) this.this$0.getBinding()).notificationBannerView;
        if (frameLayout != null && (animate = frameLayout.animate()) != null && (translationY = animate.translationY((float) 0)) != null) {
            translationY.withEndAction(new Runnable(this) {
                /* class com.digitalwallet.app.view.main.HoldingDetailFragment$animateBanner$1.AnonymousClass1 */
                final /* synthetic */ HoldingDetailFragment$animateBanner$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    this.this$0.this$0.applyLayoutConstraintForBanner(true);
                }
            });
        }
    }
}
