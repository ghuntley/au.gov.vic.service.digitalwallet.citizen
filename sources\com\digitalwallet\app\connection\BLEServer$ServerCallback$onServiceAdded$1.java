package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGattService;
import com.digitalwallet.app.connection.BLEServer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
final class BLEServer$ServerCallback$onServiceAdded$1 implements Runnable {
    final /* synthetic */ BluetoothGattService $service;
    final /* synthetic */ int $status;
    final /* synthetic */ BLEServer.ServerCallback this$0;

    BLEServer$ServerCallback$onServiceAdded$1(BLEServer.ServerCallback serverCallback, int i, BluetoothGattService bluetoothGattService) {
        this.this$0 = serverCallback;
        this.$status = i;
        this.$service = bluetoothGattService;
    }

    public final void run() {
        BLEServer$ServerCallback$onServiceAdded$1.super.onServiceAdded(this.$status, this.$service);
        Timber.d("onServiceAdded " + this.$service, new Object[0]);
    }
}
