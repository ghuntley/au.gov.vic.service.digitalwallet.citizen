package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import com.digitalwallet.app.connection.BLEServer;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.app.services.Order;
import io.reactivex.Maybe;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
public final class BLEServer$ServerCallback$onCharacteristicWriteRequest$1 implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ int $offset;
    final /* synthetic */ boolean $preparedWrite;
    final /* synthetic */ int $requestId;
    final /* synthetic */ boolean $responseNeeded;
    final /* synthetic */ byte[] $value;
    final /* synthetic */ BLEServer.ServerCallback this$0;

    BLEServer$ServerCallback$onCharacteristicWriteRequest$1(BLEServer.ServerCallback serverCallback, BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        this.this$0 = serverCallback;
        this.$device = bluetoothDevice;
        this.$requestId = i;
        this.$characteristic = bluetoothGattCharacteristic;
        this.$preparedWrite = z;
        this.$responseNeeded = z2;
        this.$offset = i2;
        this.$value = bArr;
    }

    public final void run() {
        byte[] bArr;
        BLEServer$ServerCallback$onCharacteristicWriteRequest$1.super.onCharacteristicWriteRequest(this.$device, this.$requestId, this.$characteristic, this.$preparedWrite, this.$responseNeeded, this.$offset, this.$value);
        StringBuilder sb = new StringBuilder();
        sb.append("WRITEREQUEST: ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
        if (bluetoothGattCharacteristic == null || (bArr = bluetoothGattCharacteristic.getValue()) == null) {
            bArr = new byte[0];
        }
        sb.append(new String(bArr, Charsets.UTF_8));
        Timber.d(sb.toString(), new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Char value is ");
        byte[] bArr2 = this.$value;
        Intrinsics.checkNotNull(bArr2);
        sb2.append(new String(bArr2, Charsets.UTF_8));
        sb2.append(" & size: ");
        sb2.append(this.$value.length);
        Timber.d(sb2.toString(), new Object[0]);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.$device);
        sb3.append(", ");
        sb3.append(this.$requestId);
        sb3.append(", ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$characteristic;
        UUID uuid = null;
        sb3.append(bluetoothGattCharacteristic2 != null ? bluetoothGattCharacteristic2.getUuid() : null);
        sb3.append(", ");
        sb3.append(this.$preparedWrite);
        sb3.append(", ");
        sb3.append(this.$responseNeeded);
        sb3.append(", ");
        sb3.append(this.$offset);
        sb3.append(", ");
        sb3.append(this.$value);
        sb3.append(' ');
        Timber.d(sb3.toString(), new Object[0]);
        BluetoothGattCharacteristic bluetoothGattCharacteristic3 = this.$characteristic;
        if (bluetoothGattCharacteristic3 != null) {
            uuid = bluetoothGattCharacteristic3.getUuid();
        }
        if (Intrinsics.areEqual(uuid, BLEServer.Companion.getCENTRAL_HALF_CHARACTERITIC_UUID())) {
            Timber.d("central half write", new Object[0]);
            ByteArrayStore byteArrayStore = this.this$0.byteArrayStore;
            BluetoothGattCharacteristic bluetoothGattCharacteristic4 = this.$characteristic;
            Intrinsics.checkNotNull(bluetoothGattCharacteristic4);
            Maybe accumulateAndTryBuild$default = ByteArrayStore.accumulateAndTryBuild$default(byteArrayStore, bluetoothGattCharacteristic4, BLEServer.this.handshakeService, this.$value, this.$requestId, null, 16, null);
            if (accumulateAndTryBuild$default != null) {
                accumulateAndTryBuild$default.subscribe(new Consumer<P2PMessage<?>>(this) {
                    /* class com.digitalwallet.app.connection.BLEServer$ServerCallback$onCharacteristicWriteRequest$1.AnonymousClass1 */
                    final /* synthetic */ BLEServer$ServerCallback$onCharacteristicWriteRequest$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(P2PMessage<?> p2PMessage) {
                        Timber.d("central half: " + p2PMessage + ' ', new Object[0]);
                        Map map = BLEServer.this.sessions;
                        BluetoothDevice bluetoothDevice = this.this$0.$device;
                        Intrinsics.checkNotNull(bluetoothDevice);
                        String address = bluetoothDevice.getAddress();
                        Intrinsics.checkNotNullExpressionValue(address, "device!!.address");
                        map.put(address, p2PMessage.getHeader().getSourceID());
                        HandshakeService handshakeService = BLEServer.this.handshakeService;
                        Objects.requireNonNull(p2PMessage, "null cannot be cast to non-null type com.digitalwallet.app.model.P2PMessage<com.digitalwallet.app.model.InitHandshakeData>");
                        handshakeService.generateSharedEncryptionKey(p2PMessage, Order.Second);
                    }
                }, new Consumer<Throwable>(this) {
                    /* class com.digitalwallet.app.connection.BLEServer$ServerCallback$onCharacteristicWriteRequest$1.AnonymousClass2 */
                    final /* synthetic */ BLEServer$ServerCallback$onCharacteristicWriteRequest$1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(Throwable th) {
                        Timber.e(th);
                        BLEServer.this.handshakeService.reset();
                    }
                });
            }
            BluetoothGattServer bluetoothGattServer = BLEServer.this.server;
            Intrinsics.checkNotNull(bluetoothGattServer);
            bluetoothGattServer.sendResponse(this.$device, this.$requestId, 0, this.$offset, null);
        } else if (Intrinsics.areEqual(uuid, BLEServer.Companion.getREQUEST_CHARACTERISTIC_UUID())) {
            Timber.d("holding request line", new Object[0]);
            ByteArrayStore byteArrayStore2 = this.this$0.byteArrayStore;
            BluetoothGattCharacteristic bluetoothGattCharacteristic5 = this.$characteristic;
            Intrinsics.checkNotNull(bluetoothGattCharacteristic5);
            Maybe accumulateAndTryBuild$default2 = ByteArrayStore.accumulateAndTryBuild$default(byteArrayStore2, bluetoothGattCharacteristic5, BLEServer.this.handshakeService, this.$value, this.$requestId, null, 16, null);
            if (accumulateAndTryBuild$default2 != null) {
                accumulateAndTryBuild$default2.subscribe(new BLEServer$ServerCallback$onCharacteristicWriteRequest$1$$special$$inlined$let$lambda$1(this), new BLEServer$ServerCallback$onCharacteristicWriteRequest$1$$special$$inlined$let$lambda$2(this));
            }
            BluetoothGattServer bluetoothGattServer2 = BLEServer.this.server;
            Intrinsics.checkNotNull(bluetoothGattServer2);
            bluetoothGattServer2.sendResponse(this.$device, this.$requestId, 0, this.$offset, null);
        } else {
            BluetoothGattServer bluetoothGattServer3 = BLEServer.this.server;
            Intrinsics.checkNotNull(bluetoothGattServer3);
            BluetoothDevice bluetoothDevice = this.$device;
            int i = this.$requestId;
            int i2 = this.$offset;
            byte[] bytes = "Test".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            bluetoothGattServer3.sendResponse(bluetoothDevice, i, 0, i2, bytes);
        }
    }
}
