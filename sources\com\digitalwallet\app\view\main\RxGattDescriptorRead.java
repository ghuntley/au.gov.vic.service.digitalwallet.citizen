package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/app/view/main/RxGattDescriptorRead;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "status", "", "(Landroid/bluetooth/BluetoothGatt;Landroid/bluetooth/BluetoothGattDescriptor;I)V", "getDescriptor", "()Landroid/bluetooth/BluetoothGattDescriptor;", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "getStatus", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxGattDescriptorRead extends RxGattClientEvent {
    private final BluetoothGattDescriptor descriptor;
    private final BluetoothGatt gatt;
    private final int status;

    public static /* synthetic */ RxGattDescriptorRead copy$default(RxGattDescriptorRead rxGattDescriptorRead, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bluetoothGatt = rxGattDescriptorRead.gatt;
        }
        if ((i2 & 2) != 0) {
            bluetoothGattDescriptor = rxGattDescriptorRead.descriptor;
        }
        if ((i2 & 4) != 0) {
            i = rxGattDescriptorRead.status;
        }
        return rxGattDescriptorRead.copy(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public final BluetoothGatt component1() {
        return this.gatt;
    }

    public final BluetoothGattDescriptor component2() {
        return this.descriptor;
    }

    public final int component3() {
        return this.status;
    }

    public final RxGattDescriptorRead copy(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        return new RxGattDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxGattDescriptorRead)) {
            return false;
        }
        RxGattDescriptorRead rxGattDescriptorRead = (RxGattDescriptorRead) obj;
        return Intrinsics.areEqual(this.gatt, rxGattDescriptorRead.gatt) && Intrinsics.areEqual(this.descriptor, rxGattDescriptorRead.descriptor) && this.status == rxGattDescriptorRead.status;
    }

    public int hashCode() {
        BluetoothGatt bluetoothGatt = this.gatt;
        int i = 0;
        int hashCode = (bluetoothGatt != null ? bluetoothGatt.hashCode() : 0) * 31;
        BluetoothGattDescriptor bluetoothGattDescriptor = this.descriptor;
        if (bluetoothGattDescriptor != null) {
            i = bluetoothGattDescriptor.hashCode();
        }
        return ((hashCode + i) * 31) + this.status;
    }

    public String toString() {
        return "RxGattDescriptorRead(gatt=" + this.gatt + ", descriptor=" + this.descriptor + ", status=" + this.status + ")";
    }

    public final BluetoothGattDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    public final int getStatus() {
        return this.status;
    }

    public RxGattDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super(null);
        this.gatt = bluetoothGatt;
        this.descriptor = bluetoothGattDescriptor;
        this.status = i;
    }
}
