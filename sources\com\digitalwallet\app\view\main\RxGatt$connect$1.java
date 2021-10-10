package com.digitalwallet.app.view.main;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"callback", "com/digitalwallet/app/view/main/RxGatt$connect$1$1", "emitter", "Lio/reactivex/ObservableEmitter;", "Lcom/digitalwallet/app/view/main/RxGattClientEvent;", "invoke", "(Lio/reactivex/ObservableEmitter;)Lcom/digitalwallet/app/view/main/RxGatt$connect$1$1;"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxGatt$connect$1 extends Lambda implements Function1<ObservableEmitter<RxGattClientEvent>, AnonymousClass1> {
    public static final RxGatt$connect$1 INSTANCE = new RxGatt$connect$1();

    RxGatt$connect$1() {
        super(1);
    }

    public final AnonymousClass1 invoke(final ObservableEmitter<RxGattClientEvent> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        return new BluetoothGattCallback() {
            /* class com.digitalwallet.app.view.main.RxGatt$connect$1.AnonymousClass1 */

            public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onReadRemoteRssi(bluetoothGatt, i, i2);
                observableEmitter.onNext(new RxGattReadRemoteRssi(bluetoothGatt, i, i2));
            }

            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
                observableEmitter.onNext(new RxGattCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i));
            }

            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                observableEmitter.onNext(new RxGattCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i));
            }

            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                super.onServicesDiscovered(bluetoothGatt, i);
                observableEmitter.onNext(new RxGattServicesDiscovered(bluetoothGatt, i));
            }

            public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
                super.onPhyUpdate(bluetoothGatt, i, i2, i3);
                observableEmitter.onNext(new RxGattPhyUpdate(bluetoothGatt, i, i2, i3));
            }

            public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onMtuChanged(bluetoothGatt, i, i2);
                observableEmitter.onNext(new RxGattMtuChanged(bluetoothGatt, i, i2));
            }

            public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
                super.onReliableWriteCompleted(bluetoothGatt, i);
                observableEmitter.onNext(new RxGattReliableWriteCompleted(bluetoothGatt, i));
            }

            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                observableEmitter.onNext(new RxGattDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i));
            }

            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                observableEmitter.onNext(new RxGattCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic));
            }

            public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
                observableEmitter.onNext(new RxGattDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i));
            }

            public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
                super.onPhyRead(bluetoothGatt, i, i2, i3);
                observableEmitter.onNext(new RxGattPhyRead(bluetoothGatt, i, i2, i3));
            }

            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onConnectionStateChange(bluetoothGatt, i, i2);
                observableEmitter.onNext(new RxGattConnectionStateChange(bluetoothGatt, i, i2));
            }
        };
    }
}
