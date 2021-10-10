package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/connection/BluetoothConnection;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "(Landroid/bluetooth/BluetoothDevice;Landroid/bluetooth/BluetoothGatt;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BLEClient.kt */
public final class BluetoothConnection {
    private final BluetoothDevice device;
    private final BluetoothGatt gatt;

    public static /* synthetic */ BluetoothConnection copy$default(BluetoothConnection bluetoothConnection, BluetoothDevice bluetoothDevice, BluetoothGatt bluetoothGatt, int i, Object obj) {
        if ((i & 1) != 0) {
            bluetoothDevice = bluetoothConnection.device;
        }
        if ((i & 2) != 0) {
            bluetoothGatt = bluetoothConnection.gatt;
        }
        return bluetoothConnection.copy(bluetoothDevice, bluetoothGatt);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final BluetoothGatt component2() {
        return this.gatt;
    }

    public final BluetoothConnection copy(BluetoothDevice bluetoothDevice, BluetoothGatt bluetoothGatt) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        return new BluetoothConnection(bluetoothDevice, bluetoothGatt);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothConnection)) {
            return false;
        }
        BluetoothConnection bluetoothConnection = (BluetoothConnection) obj;
        return Intrinsics.areEqual(this.device, bluetoothConnection.device) && Intrinsics.areEqual(this.gatt, bluetoothConnection.gatt);
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        int i = 0;
        int hashCode = (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31;
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt != null) {
            i = bluetoothGatt.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "BluetoothConnection(device=" + this.device + ", gatt=" + this.gatt + ")";
    }

    public BluetoothConnection(BluetoothDevice bluetoothDevice, BluetoothGatt bluetoothGatt) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        this.device = bluetoothDevice;
        this.gatt = bluetoothGatt;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }
}
