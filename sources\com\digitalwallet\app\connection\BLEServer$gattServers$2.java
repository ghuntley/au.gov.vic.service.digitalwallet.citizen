package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGattServer;
import com.digitalwallet.app.connection.BLEServer;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "kotlin.jvm.PlatformType", "it", "", "apply", "(Ljava/lang/Integer;)Lio/reactivex/Completable;"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
public final class BLEServer$gattServers$2<T, R> implements Function<Integer, Completable> {
    final /* synthetic */ BLEServer this$0;

    BLEServer$gattServers$2(BLEServer bLEServer) {
        this.this$0 = bLEServer;
    }

    public final Completable apply(Integer num) {
        Intrinsics.checkNotNullParameter(num, "it");
        synchronized (this.this$0._latestServerReady) {
            this.this$0.closeServer();
            BLEServer bLEServer = this.this$0;
            BehaviorRelay create = BehaviorRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create<BluetoothGattServer>()");
            bLEServer._latestServerReady = create;
            Unit unit = Unit.INSTANCE;
        }
        return this.this$0.bleUtil.openGattServer(new BLEServer.ServerCallback()).toObservable().flatMapCompletable(new Function<BluetoothGattServer, CompletableSource>(this) {
            /* class com.digitalwallet.app.connection.BLEServer$gattServers$2.AnonymousClass2 */
            final /* synthetic */ BLEServer$gattServers$2 this$0;

            {
                this.this$0 = r1;
            }

            public final CompletableSource apply(BluetoothGattServer bluetoothGattServer) {
                Intrinsics.checkNotNullParameter(bluetoothGattServer, "newServer");
                this.this$0.this$0.server = bluetoothGattServer;
                if (bluetoothGattServer.addService(this.this$0.this$0.nameService)) {
                    this.this$0.this$0._latestServerReady.accept(bluetoothGattServer);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Start gatt server (");
                    BLEServer bLEServer = this.this$0.this$0;
                    int i = bLEServer.gattServerInstance;
                    bLEServer.gattServerInstance = i + 1;
                    sb.append(i);
                    sb.append(") ready!");
                    Timber.e(sb.toString(), new Object[0]);
                    return Completable.complete();
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        });
    }
}
