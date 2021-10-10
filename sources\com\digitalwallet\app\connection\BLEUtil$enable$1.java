package com.digitalwallet.app.connection;

import androidx.core.app.NotificationCompat;
import com.digitalwallet.app.connection.BLEUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEUtil.kt */
public final class BLEUtil$enable$1<V> implements Callable<CompletableSource> {
    final /* synthetic */ BLEUtil this$0;

    BLEUtil$enable$1(BLEUtil bLEUtil) {
        this.this$0 = bLEUtil;
    }

    @Override // java.util.concurrent.Callable
    public final CompletableSource call() {
        if (this.this$0.getBluetoothAdapter().getState() == 13) {
            this.this$0.getLog().d("enable - waiting for off first", new Object[0]);
            return this.this$0.waitForOff().andThen(this.this$0.enable());
        } else if (this.this$0.getBluetoothAdapter().isEnabled()) {
            this.this$0.getLog().d("enable - already enabled", new Object[0]);
            return Completable.complete();
        } else if (!this.this$0.getBluetoothAdapter().enable()) {
            this.this$0.getLog().d("enable - failed", new Object[0]);
            return Completable.error(new BLEUtil.CannotEnable());
        } else {
            this.this$0.getLog().d("enabled - waiting for on", new Object[0]);
            return this.this$0.waitForOn();
        }
    }
}
