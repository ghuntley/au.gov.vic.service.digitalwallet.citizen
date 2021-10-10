package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/main/RxNotificationSent;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "device", "Landroid/bluetooth/BluetoothDevice;", "status", "", "(Landroid/bluetooth/BluetoothDevice;I)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxNotificationSent extends RxGattServerEvent {
    private final BluetoothDevice device;
    private final int status;

    public static /* synthetic */ RxNotificationSent copy$default(RxNotificationSent rxNotificationSent, BluetoothDevice bluetoothDevice, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bluetoothDevice = rxNotificationSent.device;
        }
        if ((i2 & 2) != 0) {
            i = rxNotificationSent.status;
        }
        return rxNotificationSent.copy(bluetoothDevice, i);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final int component2() {
        return this.status;
    }

    public final RxNotificationSent copy(BluetoothDevice bluetoothDevice, int i) {
        return new RxNotificationSent(bluetoothDevice, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxNotificationSent)) {
            return false;
        }
        RxNotificationSent rxNotificationSent = (RxNotificationSent) obj;
        return Intrinsics.areEqual(this.device, rxNotificationSent.device) && this.status == rxNotificationSent.status;
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        return ((bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31) + this.status;
    }

    public String toString() {
        return "RxNotificationSent(device=" + this.device + ", status=" + this.status + ")";
    }

    public RxNotificationSent(BluetoothDevice bluetoothDevice, int i) {
        super(null);
        this.device = bluetoothDevice;
        this.status = i;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final int getStatus() {
        return this.status;
    }
}
