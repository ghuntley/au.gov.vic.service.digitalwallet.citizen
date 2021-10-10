package com.digitalwallet.app.view.util;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt$slideOut$1 implements Runnable {
    final /* synthetic */ AHBottomNavigation $this_slideOut;

    ViewUtilsKt$slideOut$1(AHBottomNavigation aHBottomNavigation) {
        this.$this_slideOut = aHBottomNavigation;
    }

    public final void run() {
        this.$this_slideOut.setVisibility(8);
    }
}
