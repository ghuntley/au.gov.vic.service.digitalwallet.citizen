package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/digitalwallet/app/view/main/RxDescriptorWriteReques;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "preparedToWrite", "", "responseNeeded", "offset", "value", "", "(Landroid/bluetooth/BluetoothDevice;ILandroid/bluetooth/BluetoothGattDescriptor;ZZI[B)V", "getDescriptor", "()Landroid/bluetooth/BluetoothGattDescriptor;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getOffset", "()I", "getPreparedToWrite", "()Z", "getRequestId", "getResponseNeeded", "getValue", "()[B", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxDescriptorWriteReques extends RxGattServerEvent {
    private final BluetoothGattDescriptor descriptor;
    private final BluetoothDevice device;
    private final int offset;
    private final boolean preparedToWrite;
    private final int requestId;
    private final boolean responseNeeded;
    private final byte[] value;

    public static /* synthetic */ RxDescriptorWriteReques copy$default(RxDescriptorWriteReques rxDescriptorWriteReques, BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bluetoothDevice = rxDescriptorWriteReques.device;
        }
        if ((i3 & 2) != 0) {
            i = rxDescriptorWriteReques.requestId;
        }
        if ((i3 & 4) != 0) {
            bluetoothGattDescriptor = rxDescriptorWriteReques.descriptor;
        }
        if ((i3 & 8) != 0) {
            z = rxDescriptorWriteReques.preparedToWrite;
        }
        if ((i3 & 16) != 0) {
            z2 = rxDescriptorWriteReques.responseNeeded;
        }
        if ((i3 & 32) != 0) {
            i2 = rxDescriptorWriteReques.offset;
        }
        if ((i3 & 64) != 0) {
            bArr = rxDescriptorWriteReques.value;
        }
        return rxDescriptorWriteReques.copy(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final int component2() {
        return this.requestId;
    }

    public final BluetoothGattDescriptor component3() {
        return this.descriptor;
    }

    public final boolean component4() {
        return this.preparedToWrite;
    }

    public final boolean component5() {
        return this.responseNeeded;
    }

    public final int component6() {
        return this.offset;
    }

    public final byte[] component7() {
        return this.value;
    }

    public final RxDescriptorWriteReques copy(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        return new RxDescriptorWriteReques(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxDescriptorWriteReques)) {
            return false;
        }
        RxDescriptorWriteReques rxDescriptorWriteReques = (RxDescriptorWriteReques) obj;
        return Intrinsics.areEqual(this.device, rxDescriptorWriteReques.device) && this.requestId == rxDescriptorWriteReques.requestId && Intrinsics.areEqual(this.descriptor, rxDescriptorWriteReques.descriptor) && this.preparedToWrite == rxDescriptorWriteReques.preparedToWrite && this.responseNeeded == rxDescriptorWriteReques.responseNeeded && this.offset == rxDescriptorWriteReques.offset && Intrinsics.areEqual(this.value, rxDescriptorWriteReques.value);
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        int i = 0;
        int hashCode = (((bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31) + this.requestId) * 31;
        BluetoothGattDescriptor bluetoothGattDescriptor = this.descriptor;
        int hashCode2 = (hashCode + (bluetoothGattDescriptor != null ? bluetoothGattDescriptor.hashCode() : 0)) * 31;
        boolean z = this.preparedToWrite;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode2 + i3) * 31;
        boolean z2 = this.responseNeeded;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i7 = (((i6 + i2) * 31) + this.offset) * 31;
        byte[] bArr = this.value;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        }
        return i7 + i;
    }

    public String toString() {
        return "RxDescriptorWriteReques(device=" + this.device + ", requestId=" + this.requestId + ", descriptor=" + this.descriptor + ", preparedToWrite=" + this.preparedToWrite + ", responseNeeded=" + this.responseNeeded + ", offset=" + this.offset + ", value=" + Arrays.toString(this.value) + ")";
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final BluetoothGattDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final boolean getPreparedToWrite() {
        return this.preparedToWrite;
    }

    public final boolean getResponseNeeded() {
        return this.responseNeeded;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final byte[] getValue() {
        return this.value;
    }

    public RxDescriptorWriteReques(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        super(null);
        this.device = bluetoothDevice;
        this.requestId = i;
        this.descriptor = bluetoothGattDescriptor;
        this.preparedToWrite = z;
        this.responseNeeded = z2;
        this.offset = i2;
        this.value = bArr;
    }
}
