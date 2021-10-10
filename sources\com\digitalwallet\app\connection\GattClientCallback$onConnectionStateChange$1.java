package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.digitalwallet.app.connection.HoldingRequestState;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
final class GattClientCallback$onConnectionStateChange$1 implements Runnable {
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ int $newState;
    final /* synthetic */ int $status;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$onConnectionStateChange$1(GattClientCallback gattClientCallback, int i, BluetoothGatt bluetoothGatt, int i2) {
        this.this$0 = gattClientCallback;
        this.$newState = i;
        this.$gatt = bluetoothGatt;
        this.$status = i2;
    }

    public final void run() {
        int i = this.$newState;
        if (i == 0) {
            Timber.Tree tree = this.this$0.getLog();
            tree.e(this.this$0.status("onConnectionStateChange", this.$gatt, this.$status) + " - disconnected " + this.this$0.getDebugAddress() + ' ' + this.this$0.instance$1, new Object[0]);
            this.this$0.connected = false;
            this.this$0.getHoldingRequestEvents().accept(new HoldingRequestState.Disconnected());
            PublishRelay<GattConnection> connectionEvents = this.this$0.getConnectionEvents();
            BluetoothGatt bluetoothGatt = this.$gatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            BluetoothDevice device = bluetoothGatt.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "gatt!!.device");
            String address = device.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "gatt!!.device.address");
            connectionEvents.accept(new GattConnection(address, false));
        } else if (i != 2) {
            this.this$0.getLog().e(this.this$0.status("onConnectionStateChange", this.$gatt, this.$status), new Object[0]);
        } else {
            Timber.Tree tree2 = this.this$0.getLog();
            tree2.e(this.this$0.status("onConnectionStateChange", this.$gatt, this.$status) + " - connected " + this.this$0.getDebugAddress() + ' ' + this.this$0.instance$1, new Object[0]);
            this.this$0.connected = true;
            PublishRelay<GattConnection> connectionEvents2 = this.this$0.getConnectionEvents();
            BluetoothGatt bluetoothGatt2 = this.$gatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            BluetoothDevice device2 = bluetoothGatt2.getDevice();
            Intrinsics.checkNotNullExpressionValue(device2, "gatt!!.device");
            String address2 = device2.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "gatt!!.device.address");
            connectionEvents2.accept(new GattConnection(address2, true));
            this.$gatt.discoverServices();
        }
        if (this.$status == 133) {
            this.this$0.gattClientInterface.cursed();
        }
    }
}
