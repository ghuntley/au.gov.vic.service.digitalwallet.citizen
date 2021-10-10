package com.digitalwallet.view.main;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/digitalwallet/view/main/ScannerFragment$initializeCamera$1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScannerFragment.kt */
public final class ScannerFragment$initializeCamera$$inlined$let$lambda$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ScannerFragment this$0;

    ScannerFragment$initializeCamera$$inlined$let$lambda$1(ScannerFragment scannerFragment) {
        this.this$0 = scannerFragment;
    }

    public void onGlobalLayout() {
        this.this$0.getCameraGuide().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        Rect rect = new Rect();
        this.this$0.getCameraGuide().getDrawingRect(rect);
        this.this$0.getOuterFrame().offsetDescendantRectToMyCoords(this.this$0.getCameraGuide(), rect);
        this.this$0.getScannerViewModel().setScannerArea(rect);
    }
}
