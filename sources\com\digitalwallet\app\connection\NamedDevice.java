package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/connection/NamedDevice;", "", ErrorBundle.DETAIL_ENTRY, "Lcom/digitalwallet/app/connection/ScanDetails;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/digitalwallet/app/connection/ScanDetails;Landroid/bluetooth/BluetoothDevice;)V", "getDetails", "()Lcom/digitalwallet/app/connection/ScanDetails;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class NamedDevice {
    private final ScanDetails details;
    private final BluetoothDevice device;

    public static /* synthetic */ NamedDevice copy$default(NamedDevice namedDevice, ScanDetails scanDetails, BluetoothDevice bluetoothDevice, int i, Object obj) {
        if ((i & 1) != 0) {
            scanDetails = namedDevice.details;
        }
        if ((i & 2) != 0) {
            bluetoothDevice = namedDevice.device;
        }
        return namedDevice.copy(scanDetails, bluetoothDevice);
    }

    public final ScanDetails component1() {
        return this.details;
    }

    public final BluetoothDevice component2() {
        return this.device;
    }

    public final NamedDevice copy(ScanDetails scanDetails, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(scanDetails, ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        return new NamedDevice(scanDetails, bluetoothDevice);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NamedDevice)) {
            return false;
        }
        NamedDevice namedDevice = (NamedDevice) obj;
        return Intrinsics.areEqual(this.details, namedDevice.details) && Intrinsics.areEqual(this.device, namedDevice.device);
    }

    public int hashCode() {
        ScanDetails scanDetails = this.details;
        int i = 0;
        int hashCode = (scanDetails != null ? scanDetails.hashCode() : 0) * 31;
        BluetoothDevice bluetoothDevice = this.device;
        if (bluetoothDevice != null) {
            i = bluetoothDevice.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "NamedDevice(details=" + this.details + ", device=" + this.device + ")";
    }

    public NamedDevice(ScanDetails scanDetails, BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(scanDetails, ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        this.details = scanDetails;
        this.device = bluetoothDevice;
    }

    public final ScanDetails getDetails() {
        return this.details;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }
}
