package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/digitalwallet/app/view/main/RxCharacteristicWriteRequest;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "preparedWrite", "", "responseNeeded", "offset", "value", "", "(Landroid/bluetooth/BluetoothDevice;ILandroid/bluetooth/BluetoothGattCharacteristic;ZZI[B)V", "getCharacteristic", "()Landroid/bluetooth/BluetoothGattCharacteristic;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getOffset", "()I", "getPreparedWrite", "()Z", "getRequestId", "getResponseNeeded", "getValue", "()[B", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxCharacteristicWriteRequest extends RxGattServerEvent {
    private final BluetoothGattCharacteristic characteristic;
    private final BluetoothDevice device;
    private final int offset;
    private final boolean preparedWrite;
    private final int requestId;
    private final boolean responseNeeded;
    private final byte[] value;

    public static /* synthetic */ RxCharacteristicWriteRequest copy$default(RxCharacteristicWriteRequest rxCharacteristicWriteRequest, BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bluetoothDevice = rxCharacteristicWriteRequest.device;
        }
        if ((i3 & 2) != 0) {
            i = rxCharacteristicWriteRequest.requestId;
        }
        if ((i3 & 4) != 0) {
            bluetoothGattCharacteristic = rxCharacteristicWriteRequest.characteristic;
        }
        if ((i3 & 8) != 0) {
            z = rxCharacteristicWriteRequest.preparedWrite;
        }
        if ((i3 & 16) != 0) {
            z2 = rxCharacteristicWriteRequest.responseNeeded;
        }
        if ((i3 & 32) != 0) {
            i2 = rxCharacteristicWriteRequest.offset;
        }
        if ((i3 & 64) != 0) {
            bArr = rxCharacteristicWriteRequest.value;
        }
        return rxCharacteristicWriteRequest.copy(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
    }

    public final BluetoothDevice component1() {
        return this.device;
    }

    public final int component2() {
        return this.requestId;
    }

    public final BluetoothGattCharacteristic component3() {
        return this.characteristic;
    }

    public final boolean component4() {
        return this.preparedWrite;
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

    public final RxCharacteristicWriteRequest copy(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        return new RxCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxCharacteristicWriteRequest)) {
            return false;
        }
        RxCharacteristicWriteRequest rxCharacteristicWriteRequest = (RxCharacteristicWriteRequest) obj;
        return Intrinsics.areEqual(this.device, rxCharacteristicWriteRequest.device) && this.requestId == rxCharacteristicWriteRequest.requestId && Intrinsics.areEqual(this.characteristic, rxCharacteristicWriteRequest.characteristic) && this.preparedWrite == rxCharacteristicWriteRequest.preparedWrite && this.responseNeeded == rxCharacteristicWriteRequest.responseNeeded && this.offset == rxCharacteristicWriteRequest.offset && Intrinsics.areEqual(this.value, rxCharacteristicWriteRequest.value);
    }

    public int hashCode() {
        BluetoothDevice bluetoothDevice = this.device;
        int i = 0;
        int hashCode = (((bluetoothDevice != null ? bluetoothDevice.hashCode() : 0) * 31) + this.requestId) * 31;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.characteristic;
        int hashCode2 = (hashCode + (bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.hashCode() : 0)) * 31;
        boolean z = this.preparedWrite;
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
        return "RxCharacteristicWriteRequest(device=" + this.device + ", requestId=" + this.requestId + ", characteristic=" + this.characteristic + ", preparedWrite=" + this.preparedWrite + ", responseNeeded=" + this.responseNeeded + ", offset=" + this.offset + ", value=" + Arrays.toString(this.value) + ")";
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final BluetoothGattCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    public final boolean getPreparedWrite() {
        return this.preparedWrite;
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

    public RxCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        super(null);
        this.device = bluetoothDevice;
        this.requestId = i;
        this.characteristic = bluetoothGattCharacteristic;
        this.preparedWrite = z;
        this.responseNeeded = z2;
        this.offset = i2;
        this.value = bArr;
    }
}
