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
final class GattClientCallback$onCharacteristicWrite$1 implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ BluetoothGatt $gatt;
    final /* synthetic */ int $status;
    final /* synthetic */ GattClientCallback this$0;

    GattClientCallback$onCharacteristicWrite$1(GattClientCallback gattClientCallback, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        this.this$0 = gattClientCallback;
        this.$status = i;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$gatt = bluetoothGatt;
    }

    public final void run() {
        byte[] bArr;
        Timber.Tree tree = this.this$0.getLog();
        StringBuilder sb = new StringBuilder();
        sb.append("onCharacteristicWrite: ");
        sb.append(this.$status);
        sb.append(" (i.e Bluetooth_Gatt_Success = 0), value= ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
        if (bluetoothGattCharacteristic == null || (bArr = bluetoothGattCharacteristic.getValue()) == null) {
            bArr = "Value was empty".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr, "(this as java.lang.String).getBytes(charset)");
        }
        sb.append(new String(bArr, Charsets.UTF_8));
        tree.e(sb.toString(), new Object[0]);
        if (this.$status == 0) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$characteristic;
            UUID uuid = bluetoothGattCharacteristic2 != null ? bluetoothGattCharacteristic2.getUuid() : null;
            if (Intrinsics.areEqual(uuid, BLEServer.Companion.getREQUEST_CHARACTERISTIC_UUID())) {
                this.this$0.writeRequestCharacteristic(this.$gatt);
            } else if (Intrinsics.areEqual(uuid, BLEServer.Companion.getCENTRAL_HALF_CHARACTERITIC_UUID())) {
                this.this$0.writeCentralHalfCharacteristic(this.$gatt);
            }
        }
    }
}
