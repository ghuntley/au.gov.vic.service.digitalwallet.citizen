package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGatt;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
final class GattClientCallback$onMtuChanged$1 implements Runnable {
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ int $mtu;
    final /* synthetic */ int $status;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$onMtuChanged$1(GattClientCallback gattClientCallback, BluetoothGatt bluetoothGatt, int i, int i2) {
        this.this$0 = gattClientCallback;
        this.$gatt = bluetoothGatt;
        this.$mtu = i;
        this.$status = i2;
    }

    public final void run() {
        Timber.Tree tree = this.this$0.getLog();
        tree.d("OnMTUChanged: gatt:" + this.$gatt + ", mtu:" + this.$mtu + ", status:" + this.$status, new Object[0]);
    }
}
