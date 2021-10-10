package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import com.digitalwallet.app.connection.BLEServer;
import com.digitalwallet.app.model.Body;
import com.digitalwallet.app.model.P2PHeader;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.util.MPUtilsKt;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.oidc.model.Profile;
import com.digitalwallet.app.services.HandshakeService;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: BLEServer.kt */
public final class BLEServer$ServerCallback$onCharacteristicReadRequest$1 implements Runnable {
    final /* synthetic */ BluetoothGattCharacteristic $characteristic;
    final /* synthetic */ BluetoothDevice $device;
    final /* synthetic */ int $offset;
    final /* synthetic */ int $requestId;
    final /* synthetic */ BLEServer.ServerCallback this$0;

    BLEServer$ServerCallback$onCharacteristicReadRequest$1(BLEServer.ServerCallback serverCallback, BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.this$0 = serverCallback;
        this.$device = bluetoothDevice;
        this.$requestId = i;
        this.$offset = i2;
        this.$characteristic = bluetoothGattCharacteristic;
    }

    public final void run() {
        String str;
        BLEServer$ServerCallback$onCharacteristicReadRequest$1.super.onCharacteristicReadRequest(this.$device, this.$requestId, this.$offset, this.$characteristic);
        StringBuilder sb = new StringBuilder();
        sb.append("OnCharacteristicReadRequest(device: ");
        sb.append(this.$device);
        sb.append(", requestId: ");
        sb.append(this.$requestId);
        sb.append(", offset: ");
        sb.append(this.$offset);
        sb.append(", characteristic: ");
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$characteristic;
        sb.append(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null);
        sb.append(')');
        boolean z = false;
        Timber.d(sb.toString(), new Object[0]);
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$characteristic;
        UUID uuid = bluetoothGattCharacteristic2 != null ? bluetoothGattCharacteristic2.getUuid() : null;
        if (Intrinsics.areEqual(uuid, BLEServer.Companion.getSCAN_DETAILS_CHARACTERISTIC_UUID())) {
            AuthenticationUtility authenticationUtility = BLEServer.this.authenticationUtility;
            Profile profile = authenticationUtility.getProfile();
            if (profile == null || (str = profile.getName()) == null) {
                str = "Unknown";
            }
            String nickname = authenticationUtility.getNickname();
            if (nickname.length() == 0) {
                z = true;
            }
            if (!z) {
                str = nickname;
            }
            final String take = StringsKt.take(str, 64);
            BLEServer.this.disposeBag.add(BLEServer.this.holdingsService.getLocalSecureHoldings().subscribe(new Consumer<List<? extends SecureHolding>>(this) {
                /* class com.digitalwallet.app.connection.BLEServer$ServerCallback$onCharacteristicReadRequest$1.AnonymousClass1 */
                final /* synthetic */ BLEServer$ServerCallback$onCharacteristicReadRequest$1 this$0;

                {
                    this.this$0 = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // io.reactivex.functions.Consumer
                public /* bridge */ /* synthetic */ void accept(List<? extends SecureHolding> list) {
                    accept((List<SecureHolding>) list);
                }

                public final void accept(List<SecureHolding> list) {
                    String str = take;
                    Intrinsics.checkNotNullExpressionValue(list, "holdings");
                    byte[] bytes = new ScanDetails(str, list).toBytes();
                    if (bytes.length < 180) {
                        BluetoothGattServer bluetoothGattServer = BLEServer.this.server;
                        Intrinsics.checkNotNull(bluetoothGattServer);
                        bluetoothGattServer.sendResponse(this.this$0.$device, this.this$0.$requestId, 0, this.this$0.$offset, bytes);
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
            }));
        } else if (Intrinsics.areEqual(uuid, BLEServer.Companion.getPERIF_HALF_CHARACTERISTIC_UUID())) {
            if (this.this$0.perifHandshakeChunks.isEmpty()) {
                HandshakeService handshakeService = BLEServer.this.handshakeService;
                Map map = BLEServer.this.sessions;
                BluetoothDevice bluetoothDevice = this.$device;
                Intrinsics.checkNotNull(bluetoothDevice);
                Object obj = map.get(bluetoothDevice.getAddress());
                Intrinsics.checkNotNull(obj);
                Body body = new Body("handshake", handshakeService.generateDataForHandshake((UUID) obj));
                Timber.d("hsdata: " + body, new Object[0]);
                UUID sessionId = BLEServer.this.handshakeService.getSessionId();
                Object obj2 = BLEServer.this.sessions.get(this.$device.getAddress());
                Intrinsics.checkNotNull(obj2);
                byte[] serialize$default = MPUtilsKt.serialize$default(new P2PMessage(new P2PHeader(0, null, null, sessionId, (UUID) obj2, 7, null), body, false, null, 8, null), BLEServer.this.handshakeService, null, 2, null);
                BLEServer.ServerCallback serverCallback = this.this$0;
                List<List> chunked = CollectionsKt.chunked(ArraysKt.asIterable(serialize$default), 180);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
                for (List list : chunked) {
                    arrayList.add(CollectionsKt.toByteArray(list));
                }
                serverCallback.perifHandshakeChunks = CollectionsKt.plus((Collection) arrayList, (Object) BLEServer.Companion.getEodbytes());
            }
            List list2 = this.this$0.perifHandshakeChunks;
            BLEServer.ServerCallback serverCallback2 = this.this$0;
            int i = serverCallback2.perifHandshakeIndex;
            serverCallback2.perifHandshakeIndex = i + 1;
            byte[] bArr = (byte[]) list2.get(i);
            if (Arrays.equals(bArr, BLEServer.Companion.getEodbytes())) {
                this.this$0.perifHandshakeChunks = CollectionsKt.emptyList();
                this.this$0.perifHandshakeIndex = 0;
            }
            BluetoothGattServer bluetoothGattServer = BLEServer.this.server;
            Intrinsics.checkNotNull(bluetoothGattServer);
            bluetoothGattServer.sendResponse(this.$device, this.$requestId, 0, this.$offset, bArr);
        } else if (Intrinsics.areEqual(uuid, BLEServer.Companion.getHOLDING_CHARACTERISTIC_UUID())) {
            int i2 = BLEServer.this.chunkIndex;
            List list3 = BLEServer.this.holdingDataChunks;
            Intrinsics.checkNotNull(list3);
            if (i2 < list3.size()) {
                List list4 = BLEServer.this.holdingDataChunks;
                Intrinsics.checkNotNull(list4);
                BLEServer bLEServer = BLEServer.this;
                int i3 = bLEServer.chunkIndex;
                bLEServer.chunkIndex = i3 + 1;
                byte[] bArr2 = (byte[]) list4.get(i3);
                if (Arrays.equals(bArr2, BLEServer.Companion.getEodbytes())) {
                    BLEServer.this.handshakeService.reset();
                }
                BluetoothGattServer bluetoothGattServer2 = BLEServer.this.server;
                Intrinsics.checkNotNull(bluetoothGattServer2);
                bluetoothGattServer2.sendResponse(this.$device, this.$requestId, 0, this.$offset, bArr2);
            }
        } else {
            byte[] bytes = "CHAR-READ-NO-SUPP".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            BluetoothGattServer bluetoothGattServer3 = BLEServer.this.server;
            Intrinsics.checkNotNull(bluetoothGattServer3);
            bluetoothGattServer3.sendResponse(this.$device, this.$requestId, 0, this.$offset, bytes);
        }
    }
}
