package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

public final class RxBLEGattServer {
    private final BluetoothManager bluetoothManager;
    private BluetoothGattServer server;

    public RxBLEGattServer(BluetoothManager bluetoothManager2) {
        Intrinsics.checkNotNullParameter(bluetoothManager2, "bluetoothManager");
        this.bluetoothManager = bluetoothManager2;
    }

    public final Observable<RxGattServerEvent> openGattServer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RxBLEGattServer$openGattServer$1 rxBLEGattServer$openGattServer$1 = RxBLEGattServer$openGattServer$1.INSTANCE;
        Observable create = Observable.create(new RxBLEGattServer$openGattServer$observable$1(this, context));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<RxGatt…rReady)\n                }");
        Observable<RxGattServerEvent> doOnTerminate = create.doOnTerminate(new RxBLEGattServer$openGattServer$2(this));
        Intrinsics.checkNotNullExpressionValue(doOnTerminate, "observable.doOnTerminate { server?.close() }");
        return doOnTerminate;
    }

    public final void addService(BluetoothGattService bluetoothGattService) {
        Intrinsics.checkNotNullParameter(bluetoothGattService, NotificationCompat.CATEGORY_SERVICE);
        BluetoothGattServer bluetoothGattServer = this.server;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.addService(bluetoothGattService);
            return;
        }
        throw new Throwable("Server Null");
    }

    public final void sendResponse(BluetoothDevice bluetoothDevice, int i, int i2, int i3, byte[] bArr) {
        BluetoothGattServer bluetoothGattServer = this.server;
        if (bluetoothGattServer != null) {
            bluetoothGattServer.sendResponse(bluetoothDevice, i, i2, i3, bArr);
        }
    }

    public final BluetoothGattServer getServer() {
        return this.server;
    }

    public final void setServer(BluetoothGattServer bluetoothGattServer) {
        this.server = bluetoothGattServer;
    }
}
