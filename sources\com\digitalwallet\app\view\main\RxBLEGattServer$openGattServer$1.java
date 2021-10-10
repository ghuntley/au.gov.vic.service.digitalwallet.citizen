package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"callback", "com/digitalwallet/app/view/main/RxBLEGattServer$openGattServer$1$1", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/digitalwallet/app/view/main/RxGattServerEvent;", "invoke", "(Lio/reactivex/ObservableEmitter;)Lcom/digitalwallet/app/view/main/RxBLEGattServer$openGattServer$1$1;"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxBLEGattServer$openGattServer$1 extends Lambda implements Function1<ObservableEmitter<RxGattServerEvent>, AnonymousClass1> {
    public static final RxBLEGattServer$openGattServer$1 INSTANCE = new RxBLEGattServer$openGattServer$1();

    RxBLEGattServer$openGattServer$1() {
        super(1);
    }

    public final AnonymousClass1 invoke(final ObservableEmitter<RxGattServerEvent> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        return new BluetoothGattServerCallback() {
            /* class com.digitalwallet.app.view.main.RxBLEGattServer$openGattServer$1.AnonymousClass1 */

            public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor) {
                super.onDescriptorReadRequest(bluetoothDevice, i, i2, bluetoothGattDescriptor);
                observableEmitter.onNext(new RxDescriptorReadRequest(bluetoothDevice, i, i2, bluetoothGattDescriptor));
            }

            public void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
                super.onNotificationSent(bluetoothDevice, i);
                observableEmitter.onNext(new RxNotificationSent(bluetoothDevice, i));
            }

            public void onMtuChanged(BluetoothDevice bluetoothDevice, int i) {
                super.onMtuChanged(bluetoothDevice, i);
                observableEmitter.onNext(new RxMtuChanged(bluetoothDevice, i));
            }

            public void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
                super.onPhyUpdate(bluetoothDevice, i, i2, i3);
                observableEmitter.onNext(new RxPhyUpdate(bluetoothDevice, i, i2, i3));
            }

            public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
                super.onExecuteWrite(bluetoothDevice, i, z);
                observableEmitter.onNext(new RxExecuteWrite(bluetoothDevice, i, z));
            }

            public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
                super.onCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
                observableEmitter.onNext(new RxCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr));
            }

            public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                super.onCharacteristicReadRequest(bluetoothDevice, i, i2, bluetoothGattCharacteristic);
                observableEmitter.onNext(new RxCharacteristicReadRequest(bluetoothDevice, i, i2, bluetoothGattCharacteristic));
            }

            public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
                super.onConnectionStateChange(bluetoothDevice, i, i2);
                observableEmitter.onNext(new RxConnectionStateChange(bluetoothDevice, i, i2));
            }

            public void onPhyRead(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
                super.onPhyRead(bluetoothDevice, i, i2, i3);
                observableEmitter.onNext(new RxPhyRead(bluetoothDevice, i, i2, i3));
            }

            public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
                super.onDescriptorWriteRequest(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr);
                observableEmitter.onNext(new RxDescriptorWriteReques(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr));
            }

            public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
                super.onServiceAdded(i, bluetoothGattService);
                observableEmitter.onNext(new RxServiceAdded(i, bluetoothGattService));
            }
        };
    }
}
