package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/view/main/RxExecuteWrite;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "execute", "", "(Landroid/bluetooth/BluetoothDevice;IZ)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getExecute", "()Z", "getRequestId", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxExecuteWrite extends RxGattServerEvent {
    private final BluetoothDevice device;
    private final boolean execute;
    private final int requestId;

    public static /* synthetic */ RxExecuteWrite copy$default(RxExecuteWrite rxExecuteWrite, BluetoothDevice bluetoothDevice, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bluetoothDevice = rxExecuteWrite.device;
        }
        if ((i2 & 2) != 0) {
            i = rxExecuteWrite.requestId;
        }
        if ((i2 & 4) != 0) {
            z = rxExecuteWrite.execute;
        }
        return rxExecuteWrite.copy(bluetoothDevice, i, z);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final int component2() {
        return this.requestId;
    }

    public final boolean component3() {
        return this.execute;
    }

    public final RxExecuteWrite copy(BluetoothDevice bluetoothDevice, int i, boolean z) {
        return new RxExecuteWrite(bluetoothDevice, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxExecuteWrite)) {
            return false;
        }
        RxExecuteWrite rxExecuteWrite = (RxExecuteWrite) obj;
        return Intrinsics.areEqual(this.device, rxExecuteWrite.device) && this.requestId == rxExecuteWrite.requestId && this.execute == rxExecuteWrite.execute;
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        int hashCode = (((bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31) + this.requestId) * 31;
        boolean z = this.execute;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public String toString() {
        return "RxExecuteWrite(device=" + this.device + ", requestId=" + this.requestId + ", execute=" + this.execute + ")";
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final boolean getExecute() {
        return this.execute;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public RxExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
        super(null);
        this.device = bluetoothDevice;
        this.requestId = i;
        this.execute = z;
    }
}
