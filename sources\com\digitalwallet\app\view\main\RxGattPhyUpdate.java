package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGatt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/digitalwallet/app/view/main/RxGattPhyUpdate;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "txPhy", "", "rxPhy", "status", "(Landroid/bluetooth/BluetoothGatt;III)V", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "getRxPhy", "()I", "getStatus", "getTxPhy", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxGattPhyUpdate extends RxGattClientEvent {
    private final BluetoothGatt gatt;
    private final int rxPhy;
    private final int status;
    private final int txPhy;

    public static /* synthetic */ RxGattPhyUpdate copy$default(RxGattPhyUpdate rxGattPhyUpdate, BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bluetoothGatt = rxGattPhyUpdate.gatt;
        }
        if ((i4 & 2) != 0) {
            i = rxGattPhyUpdate.txPhy;
        }
        if ((i4 & 4) != 0) {
            i2 = rxGattPhyUpdate.rxPhy;
        }
        if ((i4 & 8) != 0) {
            i3 = rxGattPhyUpdate.status;
        }
        return rxGattPhyUpdate.copy(bluetoothGatt, i, i2, i3);
    }

    public final BluetoothGatt component1() {
        return this.gatt;
    }

    public final int component2() {
        return this.txPhy;
    }

    public final int component3() {
        return this.rxPhy;
    }

    public final int component4() {
        return this.status;
    }

    public final RxGattPhyUpdate copy(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        return new RxGattPhyUpdate(bluetoothGatt, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxGattPhyUpdate)) {
            return false;
        }
        RxGattPhyUpdate rxGattPhyUpdate = (RxGattPhyUpdate) obj;
        return Intrinsics.areEqual(this.gatt, rxGattPhyUpdate.gatt) && this.txPhy == rxGattPhyUpdate.txPhy && this.rxPhy == rxGattPhyUpdate.rxPhy && this.status == rxGattPhyUpdate.status;
    }

    public int hashCode() {
        BluetoothGatt bluetoothGatt = this.gatt;
        return ((((((bluetoothGatt != null ? bluetoothGatt.hashCode() : 0) * 31) + this.txPhy) * 31) + this.rxPhy) * 31) + this.status;
    }

    public String toString() {
        return "RxGattPhyUpdate(gatt=" + this.gatt + ", txPhy=" + this.txPhy + ", rxPhy=" + this.rxPhy + ", status=" + this.status + ")";
    }

    public final BluetoothGatt getGatt() {
        return this.gatt;
    }

    public final int getRxPhy() {
        return this.rxPhy;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getTxPhy() {
        return this.txPhy;
    }

    public RxGattPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        super(null);
        this.gatt = bluetoothGatt;
        this.txPhy = i;
        this.rxPhy = i2;
        this.status = i3;
    }
}
