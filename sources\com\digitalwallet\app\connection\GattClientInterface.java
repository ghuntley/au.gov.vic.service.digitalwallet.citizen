package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothGatt;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/digitalwallet/app/connection/GattClientInterface;", "", "cursed", "", "getSession", "Ljava/util/UUID;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public interface GattClientInterface {
    void cursed();

    UUID getSession(BluetoothGatt bluetoothGatt);
}
