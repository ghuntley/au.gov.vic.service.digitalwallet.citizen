package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattDescriptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/digitalwallet/app/view/main/RxDescriptorReadRequest;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "offset", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "(Landroid/bluetooth/BluetoothDevice;IILandroid/bluetooth/BluetoothGattDescriptor;)V", "getDescriptor", "()Landroid/bluetooth/BluetoothGattDescriptor;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getOffset", "()I", "getRequestId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxDescriptorReadRequest extends RxGattServerEvent {
    private final BluetoothGattDescriptor descriptor;
    private final BluetoothDevice device;
    private final int offset;
    private final int requestId;

    public static /* synthetic */ RxDescriptorReadRequest copy$default(RxDescriptorReadRequest rxDescriptorReadRequest, BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bluetoothDevice = rxDescriptorReadRequest.device;
        }
        if ((i3 & 2) != 0) {
            i = rxDescriptorReadRequest.requestId;
        }
        if ((i3 & 4) != 0) {
            i2 = rxDescriptorReadRequest.offset;
        }
        if ((i3 & 8) != 0) {
            bluetoothGattDescriptor = rxDescriptorReadRequest.descriptor;
        }
        return rxDescriptorReadRequest.copy(bluetoothDevice, i, i2, bluetoothGattDescriptor);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final int component2() {
        return this.requestId;
    }

    public final int component3() {
        return this.offset;
    }

    public final BluetoothGattDescriptor component4() {
        return this.descriptor;
    }

    public final RxDescriptorReadRequest copy(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new RxDescriptorReadRequest(bluetoothDevice, i, i2, bluetoothGattDescriptor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxDescriptorReadRequest)) {
            return false;
        }
        RxDescriptorReadRequest rxDescriptorReadRequest = (RxDescriptorReadRequest) obj;
        return Intrinsics.areEqual(this.device, rxDescriptorReadRequest.device) && this.requestId == rxDescriptorReadRequest.requestId && this.offset == rxDescriptorReadRequest.offset && Intrinsics.areEqual(this.descriptor, rxDescriptorReadRequest.descriptor);
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        int i = 0;
        int hashCode = (((((bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31) + this.requestId) * 31) + this.offset) * 31;
        BluetoothGattDescriptor bluetoothGattDescriptor = this.descriptor;
        if (bluetoothGattDescriptor != null) {
            i = bluetoothGattDescriptor.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RxDescriptorReadRequest(device=" + this.device + ", requestId=" + this.requestId + ", offset=" + this.offset + ", descriptor=" + this.descriptor + ")";
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final BluetoothGattDescriptor getDescriptor() {
        return this.descriptor;
    }

    public RxDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor) {
        super(null);
        this.device = bluetoothDevice;
        this.requestId = i;
        this.offset = i2;
        this.descriptor = bluetoothGattDescriptor;
    }
}
