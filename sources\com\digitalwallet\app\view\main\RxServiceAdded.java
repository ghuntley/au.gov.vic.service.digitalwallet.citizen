package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGattService;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/main/RxServiceAdded;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "status", "", NotificationCompat.CATEGORY_SERVICE, "Landroid/bluetooth/BluetoothGattService;", "(ILandroid/bluetooth/BluetoothGattService;)V", "getService", "()Landroid/bluetooth/BluetoothGattService;", "getStatus", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxServiceAdded extends RxGattServerEvent {
    private final BluetoothGattService service;
    private final int status;

    public static /* synthetic */ RxServiceAdded copy$default(RxServiceAdded rxServiceAdded, int i, BluetoothGattService bluetoothGattService, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rxServiceAdded.status;
        }
        if ((i2 & 2) != 0) {
            bluetoothGattService = rxServiceAdded.service;
        }
        return rxServiceAdded.copy(i, bluetoothGattService);
    }

    public final int component1() {
        return this.status;
    }

    public final BluetoothGattService component2() {
        return this.service;
    }

    public final RxServiceAdded copy(int i, BluetoothGattService bluetoothGattService) {
        return new RxServiceAdded(i, bluetoothGattService);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxServiceAdded)) {
            return false;
        }
        RxServiceAdded rxServiceAdded = (RxServiceAdded) obj;
        return this.status == rxServiceAdded.status && Intrinsics.areEqual(this.service, rxServiceAdded.service);
    }

    public int hashCode() {
        int i = this.status * 31;
        BluetoothGattService bluetoothGattService = this.service;
        return i + (bluetoothGattService != null ? bluetoothGattService.hashCode() : 0);
    }

    public String toString() {
        return "RxServiceAdded(status=" + this.status + ", service=" + this.service + ")";
    }

    public RxServiceAdded(int i, BluetoothGattService bluetoothGattService) {
        super(null);
        this.status = i;
        this.service = bluetoothGattService;
    }

    public final BluetoothGattService getService() {
        return this.service;
    }

    public final int getStatus() {
        return this.status;
    }
}
