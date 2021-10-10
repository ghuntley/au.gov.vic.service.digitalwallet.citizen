package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import com.digitalwallet.app.connection.BLEServer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
final class BLEServer$ServerCallback$onNotificationSent$1 implements Runnable {
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ int $status;
    final /* synthetic */ BLEServer.ServerCallback this$0;

    BLEServer$ServerCallback$onNotificationSent$1(BLEServer.ServerCallback serverCallback, BluetoothDevice bluetoothDevice, int i) {
        this.this$0 = serverCallback;
        this.$device = bluetoothDevice;
        this.$status = i;
    }

    public final void run() {
        BLEServer$ServerCallback$onNotificationSent$1.super.onNotificationSent(this.$device, this.$status);
        Timber.d("on notification sent", new Object[0]);
    }
}
