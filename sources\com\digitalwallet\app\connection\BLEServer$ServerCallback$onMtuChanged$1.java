package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import com.digitalwallet.app.connection.BLEServer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
final class BLEServer$ServerCallback$onMtuChanged$1 implements Runnable {
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ int $mtu;
    final /* synthetic */ BLEServer.ServerCallback this$0;

    BLEServer$ServerCallback$onMtuChanged$1(BLEServer.ServerCallback serverCallback, BluetoothDevice bluetoothDevice, int i) {
        this.this$0 = serverCallback;
        this.$device = bluetoothDevice;
        this.$mtu = i;
    }

    public final void run() {
        BLEServer$ServerCallback$onMtuChanged$1.super.onMtuChanged(this.$device, this.$mtu);
        Timber.d("OnMTUChanged: device:" + this.$device + ", mtu:" + this.$mtu, new Object[0]);
    }
}
