package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\r\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/digitalwallet/app/view/main/RxGatt;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "(Landroid/bluetooth/BluetoothDevice;)V", "gatt", "Landroid/bluetooth/BluetoothGatt;", "close", "", "()Lkotlin/Unit;", "connect", "Lio/reactivex/Observable;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "context", "Landroid/content/Context;", "autoConnect", "", "disconnect", "discoverServices", "readCharacteristic", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "writeCharacteristic", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxGatt {
    private final BluetoothDevice device;
    private BluetoothGatt gatt;

    public RxGatt(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        this.device = bluetoothDevice;
    }

    public final Observable<RxGattClientEvent> connect(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        RxGatt$connect$1 rxGatt$connect$1 = RxGatt$connect$1.INSTANCE;
        Observable create = Observable.create(new RxGatt$connect$observable$1(this, context, z));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<RxGatt…oConnect, callback(it)) }");
        Observable<RxGattClientEvent> doOnTerminate = create.doOnTerminate(new RxGatt$connect$2(this));
        Intrinsics.checkNotNullExpressionValue(doOnTerminate, "observable.doOnTerminate { gatt?.close() }");
        return doOnTerminate;
    }

    public final void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
            return;
        }
        throw RxBLEScannerKt.getGattNotConnected();
    }

    public final boolean writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intrinsics.checkNotNullParameter(bluetoothGattCharacteristic, "characteristic");
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt != null) {
            return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        throw RxBLEScannerKt.getGattNotConnected();
    }

    public final boolean discoverServices() {
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt != null) {
            return bluetoothGatt.discoverServices();
        }
        throw RxBLEScannerKt.getGattNotConnected();
    }

    public final Unit close() {
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt == null) {
            return null;
        }
        bluetoothGatt.close();
        return Unit.INSTANCE;
    }

    public final Unit disconnect() {
        BluetoothGatt bluetoothGatt = this.gatt;
        if (bluetoothGatt == null) {
            return null;
        }
        bluetoothGatt.disconnect();
        return Unit.INSTANCE;
    }
}
