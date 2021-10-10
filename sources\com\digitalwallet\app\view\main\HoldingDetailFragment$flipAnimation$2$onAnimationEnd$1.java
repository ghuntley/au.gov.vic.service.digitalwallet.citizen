package com.digitalwallet.app.view.main;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/digitalwallet/app/view/main/HoldingDetailFragment$flipAnimation$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HoldingDetailFragment.kt */
public final class HoldingDetailFragment$flipAnimation$2$onAnimationEnd$1 extends AnimatorListenerAdapter {
    final /* synthetic */ HoldingDetailFragment$flipAnimation$2 this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    HoldingDetailFragment$flipAnimation$2$onAnimationEnd$1(HoldingDetailFragment$flipAnimation$2 holdingDetailFragment$flipAnimation$2) {
        this.this$0 = holdingDetailFragment$flipAnimation$2;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        this.this$0.this$0.setCanFlip(true);
    }
}
