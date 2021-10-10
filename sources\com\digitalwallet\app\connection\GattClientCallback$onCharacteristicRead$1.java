package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
final class GattClientCallback$onCharacteristicRead$1 implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ int $status;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$onCharacteristicRead$1(GattClientCallback gattClientCallback, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        this.this$0 = gattClientCallback;
        this.$status = i;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$gatt = bluetoothGatt;
    }

    public final void run() {
        BluetoothDevice device;
        Timber.Tree tree = this.this$0.getLog();
        StringBuilder sb = new StringBuilder();
        sb.append("onCharacteristicRead status = ");
        sb.append(this.$status);
        sb.append(" characteristicUUID = ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
        String str = null;
        sb.append(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null);
        sb.append(" characteristicValue = ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$characteristic;
        sb.append(bluetoothGattCharacteristic2 != null ? bluetoothGattCharacteristic2.getValue() : null);
        tree.e(sb.toString(), new Object[0]);
        if (this.$status == 0) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic3 = this.$characteristic;
            UUID uuid = bluetoothGattCharacteristic3 != null ? bluetoothGattCharacteristic3.getUuid() : null;
            if (Intrinsics.areEqual(uuid, BLEServer.Companion.getSCAN_DETAILS_CHARACTERISTIC_UUID())) {
                try {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic4 = this.$characteristic;
                    Intrinsics.checkNotNull(bluetoothGattCharacteristic4);
                    byte[] value = bluetoothGattCharacteristic4.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "characteristic!!.value");
                    ScanDetails scanDetails = new ScanDetails(value);
                    BluetoothGatt bluetoothGatt = this.$gatt;
                    Intrinsics.checkNotNull(bluetoothGatt);
                    BluetoothDevice device2 = bluetoothGatt.getDevice();
                    Intrinsics.checkNotNullExpressionValue(device2, "gatt!!.device");
                    this.this$0.getScanReceived().accept(new NamedDevice(scanDetails, device2));
                } catch (Exception e) {
                    Timber.Tree tree2 = this.this$0.getLog();
                    Exception exc = e;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Scan failed for device: ");
                    BluetoothGatt bluetoothGatt2 = this.$gatt;
                    if (!(bluetoothGatt2 == null || (device = bluetoothGatt2.getDevice()) == null)) {
                        str = device.getAddress();
                    }
                    sb2.append(str);
                    tree2.e(exc, sb2.toString(), new Object[0]);
                }
            } else if (Intrinsics.areEqual(uuid, BLEServer.Companion.getPERIF_HALF_CHARACTERISTIC_UUID())) {
                GattClientCallback gattClientCallback = this.this$0;
                BluetoothGattCharacteristic bluetoothGattCharacteristic5 = this.$characteristic;
                Intrinsics.checkNotNull(bluetoothGattCharacteristic5);
                BluetoothGatt bluetoothGatt3 = this.$gatt;
                Intrinsics.checkNotNull(bluetoothGatt3);
                gattClientCallback.readPerifHalfCharacteristic(bluetoothGattCharacteristic5, bluetoothGatt3);
            } else if (Intrinsics.areEqual(uuid, BLEServer.Companion.getHOLDING_CHARACTERISTIC_UUID())) {
                GattClientCallback gattClientCallback2 = this.this$0;
                BluetoothGattCharacteristic bluetoothGattCharacteristic6 = this.$characteristic;
                Intrinsics.checkNotNull(bluetoothGattCharacteristic6);
                BluetoothGatt bluetoothGatt4 = this.$gatt;
                Intrinsics.checkNotNull(bluetoothGatt4);
                gattClientCallback2.readHoldingCharacteristic(bluetoothGattCharacteristic6, bluetoothGatt4);
            }
        }
    }
}
