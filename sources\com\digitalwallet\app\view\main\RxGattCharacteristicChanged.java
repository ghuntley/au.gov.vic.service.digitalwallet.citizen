package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/digitalwallet/app/view/main/RxGattCharacteristicChanged;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattCharacteristic;)V", "getCharacteristic", "()Landroid/bluetooth/BluetoothGattCharacteristic;", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxGattCharacteristicChanged extends RxGattClientEvent {
    private final BluetoothGattCharacteristic characteristic;
    private final BluetoothGatt gatt;

    public static /* synthetic */ RxGattCharacteristicChanged copy$default(RxGattCharacteristicChanged rxGattCharacteristicChanged, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, Object obj) {
        if ((i & 1) != 0) {
            bluetoothGatt = rxGattCharacteristicChanged.gatt;
        }
        if ((i & 2) != 0) {
            bluetoothGattCharacteristic = rxGattCharacteristicChanged.characteristic;
        }
        return rxGattCharacteristicChanged.copy(bluetoothGatt, bluetoothGattCharacteristic);
    }

    public final BluetoothGatt component1() {
        return this.gatt;
    }

    public final BluetoothGattCharacteristic component2() {
        return this.characteristic;
    }

    public final RxGattCharacteristicChanged copy(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new RxGattCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxGattCharacteristicChanged)) {
            return false;
        }
        RxGattCharacteristicChanged rxGattCharacteristicChanged = (RxGattCharacteristicChanged) obj;
        return Intrinsics.areEqual(this.gatt, rxGattCharacteristicChanged.gatt) && Intrinsics.areEqual(this.characteristic, rxGattCharacteristicChanged.characteristic);
    }

    public int hashCode() {
        BluetoothGatt bluetoothGatt = this.gatt;
        int i = 0;
        int hashCode = (bluetoothGatt != null ? bluetoothGatt.hashCode() : 0) * 31;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.characteristic;
        if (bluetoothGattCharacteristic != null) {
            i = bluetoothGattCharacteristic.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RxGattCharacteristicChanged(gatt=" + this.gatt + ", characteristic=" + this.characteristic + ")";
    }

    public final BluetoothGattCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    public RxGattCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(null);
        this.gatt = bluetoothGatt;
        this.characteristic = bluetoothGattCharacteristic;
    }
}
