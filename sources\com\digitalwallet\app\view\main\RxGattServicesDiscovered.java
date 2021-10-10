package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGatt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/main/RxGattServicesDiscovered;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "status", "", "(Landroid/bluetooth/BluetoothGatt;I)V", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxGattServicesDiscovered extends RxGattClientEvent {
    private final BluetoothGatt gatt;
    private final int status;

    public static /* synthetic */ RxGattServicesDiscovered copy$default(RxGattServicesDiscovered rxGattServicesDiscovered, BluetoothGatt bluetoothGatt, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bluetoothGatt = rxGattServicesDiscovered.gatt;
        }
        if ((i2 & 2) != 0) {
            i = rxGattServicesDiscovered.status;
        }
        return rxGattServicesDiscovered.copy(bluetoothGatt, i);
    }

    public final BluetoothGatt component1() {
        return this.gatt;
    }

    public final int component2() {
        return this.status;
    }

    public final RxGattServicesDiscovered copy(BluetoothGatt bluetoothGatt, int i) {
        return new RxGattServicesDiscovered(bluetoothGatt, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxGattServicesDiscovered)) {
            return false;
        }
        RxGattServicesDiscovered rxGattServicesDiscovered = (RxGattServicesDiscovered) obj;
        return Intrinsics.areEqual(this.gatt, rxGattServicesDiscovered.gatt) && this.status == rxGattServicesDiscovered.status;
    }

    public int hashCode() {
        BluetoothGatt bluetoothGatt = this.gatt;
        return ((bluetoothGatt != null ? bluetoothGatt.hashCode() : 0) * 31) + this.status;
    }

    public String toString() {
        return "RxGattServicesDiscovered(gatt=" + this.gatt + ", status=" + this.status + ")";
    }

    public RxGattServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        super(null);
        this.gatt = bluetoothGatt;
        this.status = i;
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    public final int getStatus() {
        return this.status;
    }
}
