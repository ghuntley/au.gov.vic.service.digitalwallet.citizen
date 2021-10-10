package com.digitalwallet.app.connection;

import androidx.core.app.NotificationCompat;
import io.reactivex.CompletableSource;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
final class BLEClient$startScanPhase$1<V> implements Callable<CompletableSource> {
    final /* synthetic */ BLEClient this$0;

    BLEClient$startScanPhase$1(BLEClient bLEClient) {
        this.this$0 = bLEClient;
    }

    @Override // java.util.concurrent.Callable
    public final CompletableSource call() {
        return this.this$0.startScan().getImmediateScanCheck();
    }
}
