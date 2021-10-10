package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGatt;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
final class GattClientCallback$onServicesDiscovered$1 implements Runnable {
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ int $status;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$onServicesDiscovered$1(GattClientCallback gattClientCallback, BluetoothGatt bluetoothGatt, int i) {
        this.this$0 = gattClientCallback;
        this.$gatt = bluetoothGatt;
        this.$status = i;
    }

    public final void run() {
        this.this$0.getLog().e(this.this$0.status("onServicesDiscovered", this.$gatt, this.$status), new Object[0]);
        this.this$0.getUsernameInternal(this.$gatt);
    }
}
