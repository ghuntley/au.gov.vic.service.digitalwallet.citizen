package com.digitalwallet.app.connection;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$handler$1 extends Lambda implements Function0<Handler> {
    public static final BLEClient$handler$1 INSTANCE = new BLEClient$handler$1();

    BLEClient$handler$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Handler invoke() {
        HandlerThread handlerThread = new HandlerThread("BLEClient-Callback");
        if (!handlerThread.isAlive()) {
            handlerThread.start();
        }
        return new Handler(handlerThread.getLooper());
    }
}
