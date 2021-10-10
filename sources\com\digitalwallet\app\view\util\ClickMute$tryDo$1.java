package com.digitalwallet.app.view.util;

import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ClickMute.kt */
public final class ClickMute$tryDo$1 implements Runnable {
    final /* synthetic */ ClickMute this$0;

    ClickMute$tryDo$1(ClickMute clickMute) {
        this.this$0 = clickMute;
    }

    public final void run() {
        this.this$0.clickMute.release();
    }
}
