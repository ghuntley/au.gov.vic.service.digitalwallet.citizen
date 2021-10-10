package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/view/main/RxConnectionStateChange;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "device", "Landroid/bluetooth/BluetoothDevice;", "status", "", "newState", "(Landroid/bluetooth/BluetoothDevice;II)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getNewState", "()I", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxConnectionStateChange extends RxGattServerEvent {
    private final BluetoothDevice device;
    private final int newState;
    private final int status;

    public static /* synthetic */ RxConnectionStateChange copy$default(RxConnectionStateChange rxConnectionStateChange, BluetoothDevice bluetoothDevice, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bluetoothDevice = rxConnectionStateChange.device;
        }
        if ((i3 & 2) != 0) {
            i = rxConnectionStateChange.status;
        }
        if ((i3 & 4) != 0) {
            i2 = rxConnectionStateChange.newState;
        }
        return rxConnectionStateChange.copy(bluetoothDevice, i, i2);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final int component2() {
        return this.status;
    }

    public final int component3() {
        return this.newState;
    }

    public final RxConnectionStateChange copy(BluetoothDevice bluetoothDevice, int i, int i2) {
        return new RxConnectionStateChange(bluetoothDevice, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxConnectionStateChange)) {
            return false;
        }
        RxConnectionStateChange rxConnectionStateChange = (RxConnectionStateChange) obj;
        return Intrinsics.areEqual(this.device, rxConnectionStateChange.device) && this.status == rxConnectionStateChange.status && this.newState == rxConnectionStateChange.newState;
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        return ((((bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31) + this.status) * 31) + this.newState;
    }

    public String toString() {
        return "RxConnectionStateChange(device=" + this.device + ", status=" + this.status + ", newState=" + this.newState + ")";
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final int getNewState() {
        return this.newState;
    }

    public final int getStatus() {
        return this.status;
    }

    public RxConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        super(null);
        this.device = bluetoothDevice;
        this.status = i;
        this.newState = i2;
    }
}
