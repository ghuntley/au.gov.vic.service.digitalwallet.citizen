package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
final class GattClientCallback$onCharacteristicChanged$1 implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$onCharacteristicChanged$1(GattClientCallback gattClientCallback, BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        this.this$0 = gattClientCallback;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$gatt = bluetoothGatt;
    }

    public final void run() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
        Intrinsics.checkNotNull(bluetoothGattCharacteristic);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        byte[] value = this.$characteristic.getValue();
        if (value == null) {
            value = "null".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(value, "(this as java.lang.String).getBytes(charset)");
        }
        String str = new String(value, Charsets.UTF_8);
        Timber.Tree tree = this.this$0.getLog();
        tree.e("onCharacteristicChanged " + uuid + ' ' + str, new Object[0]);
        if (Intrinsics.areEqual(uuid, BLEServer.Companion.getHOLDING_CHARACTERISTIC_UUID())) {
            this.this$0.byteArrayStore.reset(this.$characteristic);
            GattClientCallback gattClientCallback = this.this$0;
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$characteristic;
            BluetoothGatt bluetoothGatt = this.$gatt;
            Intrinsics.checkNotNull(bluetoothGatt);
            gattClientCallback.readHoldingCharacteristic(bluetoothGattCharacteristic2, bluetoothGatt);
        }
    }
}
