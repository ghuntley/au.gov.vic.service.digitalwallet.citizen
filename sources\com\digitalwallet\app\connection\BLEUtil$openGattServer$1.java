package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/SingleEmitter;", "Landroid/bluetooth/BluetoothGattServer;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEUtil.kt */
public final class BLEUtil$openGattServer$1<T> implements SingleOnSubscribe<BluetoothGattServer> {
    final /* synthetic */ BluetoothGattServerCallback $callback;
    final /* synthetic */ BLEUtil this$0;

    BLEUtil$openGattServer$1(BLEUtil bLEUtil, BluetoothGattServerCallback bluetoothGattServerCallback) {
        this.this$0 = bLEUtil;
        this.$callback = bluetoothGattServerCallback;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<BluetoothGattServer> singleEmitter) {
        Intrinsics.checkNotNullParameter(singleEmitter, "it");
        BluetoothGattServer openGattServer = this.this$0.getBluetoothManager().openGattServer(this.this$0.application.getApplicationContext(), this.$callback);
        if (openGattServer == null) {
            singleEmitter.onError(new NullPointerException());
        } else {
            singleEmitter.onSuccess(openGattServer);
        }
    }
}
