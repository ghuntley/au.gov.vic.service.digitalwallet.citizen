package com.digitalwallet.app.view.util;

import android.os.Handler;
import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/view/util/ClickMute;", "", "delayMs", "", "(J)V", "clickMute", "Ljava/util/concurrent/Semaphore;", "getDelayMs", "()J", "setDelayMs", "tryDo", "", "block", "Lkotlin/Function0;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ClickMute.kt */
public final class ClickMute {
    private final Semaphore clickMute;
    private long delayMs;

    public ClickMute() {
        this(0, 1, null);
    }

    public ClickMute(long j) {
        this.delayMs = j;
        this.clickMute = new Semaphore(1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickMute(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1000 : j);
    }

    public final long getDelayMs() {
        return this.delayMs;
    }

    public final void setDelayMs(long j) {
        this.delayMs = j;
    }

    public final void tryDo(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (this.clickMute.tryAcquire()) {
            function0.invoke();
            new Handler().postDelayed(new ClickMute$tryDo$1(this), this.delayMs);
        }
    }
}
