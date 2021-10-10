package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import com.digitalwallet.app.connection.HoldingRequestState;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.Body;
import com.digitalwallet.app.model.InitHandshakeData;
import com.digitalwallet.app.model.MPTypeToken;
import com.digitalwallet.app.model.P2PHeader;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.SecureHolding;
import com.digitalwallet.app.model.util.MPUtilsKt;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.app.services.Order;
import com.jakewharton.rxrelay2.PublishRelay;
import com.nimbusds.jwt.SignedJWT;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 [2\u00020\u0001:\u0001[B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\u001c\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u0002082\b\u00103\u001a\u0004\u0018\u000104J\u0012\u00109\u001a\u0002082\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002J\u001c\u0010=\u001a\u0002082\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000102H\u0016J$\u0010>\u001a\u0002082\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001022\u0006\u0010?\u001a\u00020\u0015H\u0016J$\u0010@\u001a\u0002082\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001022\u0006\u0010?\u001a\u00020\u0015H\u0016J\"\u0010A\u001a\u0002082\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010?\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0016J\"\u0010C\u001a\u0002082\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010D\u001a\u00020\u00152\u0006\u0010?\u001a\u00020\u0015H\u0016J\u001a\u0010E\u001a\u0002082\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010?\u001a\u00020\u0015H\u0016J\u0006\u0010F\u001a\u000208J\u0018\u0010G\u001a\u0002082\u0006\u00105\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0018\u0010H\u001a\u0002082\u0006\u00105\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u001e\u0010I\u001a\u0002082\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u00103\u001a\u000204H\u0002J\u0012\u0010M\u001a\u0002082\b\u00103\u001a\u0004\u0018\u000104H\u0002J&\u0010N\u001a\u0002082\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u00122\u0006\u00103\u001a\u0002042\u0006\u0010Q\u001a\u000202H\u0002J\u001a\u0010R\u001a\u0002082\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002080TJ\u0016\u0010U\u001a\u0002082\u0006\u0010V\u001a\u0002062\u0006\u00103\u001a\u000204J\"\u0010?\u001a\u00020\t2\u0006\u0010W\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010?\u001a\u00020\u0015H\u0002J\u0012\u0010X\u001a\u0002082\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u001a\u0010Y\u001a\u0002082\u0006\u0010Q\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u0012\u0010Z\u001a\u0002082\b\u00103\u001a\u0004\u0018\u000104H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\f\u0012\u0004\u0012\u00020#0\u0019j\u0002`$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\b)R\u0014\u0010*\u001a\u00020+8BX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010/0/0\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/digitalwallet/app/connection/GattClientCallback;", "Landroid/bluetooth/BluetoothGattCallback;", "gattClientInterface", "Lcom/digitalwallet/app/connection/GattClientInterface;", "handshakeService", "Lcom/digitalwallet/app/services/HandshakeService;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", RequestHolding.sharingCodeKey, "", "Lcom/digitalwallet/app/model/SharingCode;", "handler", "Landroid/os/Handler;", "debugAddress", "(Lcom/digitalwallet/app/connection/GattClientInterface;Lcom/digitalwallet/app/services/HandshakeService;Lcom/digitalwallet/app/holdings/HoldingsService;Ljava/lang/String;Landroid/os/Handler;Ljava/lang/String;)V", "byteArrayStore", "Lcom/digitalwallet/app/connection/ByteArrayStore;", "centralHalfChunks", "", "", "centralHalfIndex", "", "connected", "", "connectionEvents", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/digitalwallet/app/connection/GattConnection;", "kotlin.jvm.PlatformType", "getConnectionEvents", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "getDebugAddress", "()Ljava/lang/String;", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "holdingRequestEvents", "Lcom/digitalwallet/app/connection/HoldingRequestState;", "Lcom/digitalwallet/app/connection/HoldingRequestListener;", "getHoldingRequestEvents", "idChunkIndex", "idChunks", "instance", "instance$1", "log", "Ltimber/log/Timber$Tree;", "getLog", "()Ltimber/log/Timber$Tree;", "scanReceived", "Lcom/digitalwallet/app/connection/NamedDevice;", "getScanReceived", "getCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Ljava/util/UUID;", "getUsername", "", "getUsernameInternal", "holdingError", "error", "", "onCharacteristicChanged", "onCharacteristicRead", "status", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onMtuChanged", "mtu", "onServicesDiscovered", "purge", "readHoldingCharacteristic", "readPerifHalfCharacteristic", "requestHolding", "message", "Lcom/digitalwallet/app/model/P2PMessage;", "Lcom/digitalwallet/app/model/InitHandshakeData;", "requestUpdateNotification", "sendHoldingRequest", "authorityHolding", "Lcom/digitalwallet/app/model/SecureHolding;", "char", "setOnDisconnectSubscriber", "subscriber", "Lkotlin/Function1;", "startHandshake", "sessionUuid", "func", "writeCentralHalfCharacteristic", "writeNextRequestBytes", "writeRequestCharacteristic", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: GattClientCallback.kt */
public final class GattClientCallback extends BluetoothGattCallback {
    public static final Companion Companion = new Companion(null);
    public static final String clientCharacteristicConfigurationUUID = "00002902-0000-1000-8000-00805f9b34fb";
    private static int instance;
    private ByteArrayStore byteArrayStore = new ByteArrayStore();
    private List<byte[]> centralHalfChunks = CollectionsKt.emptyList();
    private int centralHalfIndex;
    private boolean connected;
    private final PublishRelay<GattConnection> connectionEvents;
    private final String debugAddress;
    private CompositeDisposable disposeBag = new CompositeDisposable();
    private final GattClientInterface gattClientInterface;
    private final Handler handler;
    private final HandshakeService handshakeService;
    private final PublishRelay<HoldingRequestState> holdingRequestEvents;
    private final HoldingsService holdingsService;
    private int idChunkIndex;
    private List<byte[]> idChunks = CollectionsKt.emptyList();
    private final int instance$1;
    private final PublishRelay<NamedDevice> scanReceived;
    private final String sharingCode;

    public final String getDebugAddress() {
        return this.debugAddress;
    }

    public GattClientCallback(GattClientInterface gattClientInterface2, HandshakeService handshakeService2, HoldingsService holdingsService2, String str, Handler handler2, String str2) {
        Intrinsics.checkNotNullParameter(gattClientInterface2, "gattClientInterface");
        Intrinsics.checkNotNullParameter(handshakeService2, "handshakeService");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(str, RequestHolding.sharingCodeKey);
        Intrinsics.checkNotNullParameter(handler2, "handler");
        Intrinsics.checkNotNullParameter(str2, "debugAddress");
        this.gattClientInterface = gattClientInterface2;
        this.handshakeService = handshakeService2;
        this.holdingsService = holdingsService2;
        this.sharingCode = str;
        this.handler = handler2;
        this.debugAddress = str2;
        PublishRelay<GattConnection> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<GattConnection>()");
        this.connectionEvents = create;
        PublishRelay<NamedDevice> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create<NamedDevice>()");
        this.scanReceived = create2;
        PublishRelay<HoldingRequestState> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create<HoldingRequestState>()");
        this.holdingRequestEvents = create3;
        int i = instance;
        instance = i + 1;
        this.instance$1 = i;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/digitalwallet/app/connection/GattClientCallback$Companion;", "", "()V", "clientCharacteristicConfigurationUUID", "", "instance", "", "getInstance", "()I", "setInstance", "(I)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: GattClientCallback.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getInstance() {
            return GattClientCallback.instance;
        }

        public final void setInstance(int i) {
            GattClientCallback.instance = i;
        }
    }

    /* access modifiers changed from: private */
    public final Timber.Tree getLog() {
        Timber.Tree tag = Timber.tag("Bluetooth-ClientCb");
        Intrinsics.checkNotNullExpressionValue(tag, "Timber.tag(\"Bluetooth-ClientCb\")");
        return tag;
    }

    public final PublishRelay<GattConnection> getConnectionEvents() {
        return this.connectionEvents;
    }

    public final PublishRelay<NamedDevice> getScanReceived() {
        return this.scanReceived;
    }

    public final PublishRelay<HoldingRequestState> getHoldingRequestEvents() {
        return this.holdingRequestEvents;
    }

    public final void setOnDisconnectSubscriber(Function1<? super GattConnection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "subscriber");
        this.disposeBag.add(this.connectionEvents.filter(GattClientCallback$setOnDisconnectSubscriber$1.INSTANCE).subscribe(new GattClientCallbackKt$sam$io_reactivex_functions_Consumer$0(function1)));
    }

    public final void startHandshake(UUID uuid, BluetoothGatt bluetoothGatt) {
        Intrinsics.checkNotNullParameter(uuid, "sessionUuid");
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        InitHandshakeData generateDataForHandshake = this.handshakeService.generateDataForHandshake(uuid);
        this.holdingRequestEvents.accept(new HoldingRequestState.Handshaking());
        bluetoothGatt.requestMtu(512);
        Thread.sleep(200);
        UUID central_half_characteritic_uuid = BLEServer.Companion.getCENTRAL_HALF_CHARACTERITIC_UUID();
        Intrinsics.checkNotNullExpressionValue(central_half_characteritic_uuid, "BLEServer.CENTRAL_HALF_CHARACTERITIC_UUID");
        BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, central_half_characteritic_uuid);
        if (characteristic != null) {
            P2PHeader p2PHeader = new P2PHeader(0, null, null, this.handshakeService.getSessionId(), null, 23, null);
            Body body = new Body("handshake", generateDataForHandshake);
            this.centralHalfIndex = 0;
            List<List> chunked = CollectionsKt.chunked(ArraysKt.asIterable(MPUtilsKt.serialize$default(new P2PMessage(p2PHeader, body, false, null, 8, null), this.handshakeService, null, 2, null)), 180);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
            for (List list : chunked) {
                arrayList.add(CollectionsKt.toByteArray(list));
            }
            List<byte[]> plus = CollectionsKt.plus((Collection) arrayList, (Object) BLEServer.Companion.getEodbytes());
            this.centralHalfChunks = plus;
            int i = this.centralHalfIndex;
            this.centralHalfIndex = i + 1;
            characteristic.setValue(plus.get(i));
            bluetoothGatt.writeCharacteristic(characteristic);
        }
    }

    public final void purge() {
        this.byteArrayStore.purge();
        this.centralHalfIndex = 0;
        this.centralHalfChunks = CollectionsKt.emptyList();
        this.idChunkIndex = 0;
        this.idChunks = CollectionsKt.emptyList();
        this.disposeBag = new CompositeDisposable();
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.handler.post(new GattClientCallback$onCharacteristicRead$1(this, i, bluetoothGattCharacteristic, bluetoothGatt));
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        this.handler.post(new GattClientCallback$onCharacteristicWrite$1(this, i, bluetoothGattCharacteristic, bluetoothGatt));
    }

    /* access modifiers changed from: private */
    public final void readPerifHalfCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        ByteArrayStore byteArrayStore2 = this.byteArrayStore;
        HandshakeService handshakeService2 = this.handshakeService;
        byte[] value = bluetoothGattCharacteristic.getValue();
        Intrinsics.checkNotNull(value);
        Maybe accumulateAndTryBuild$default = ByteArrayStore.accumulateAndTryBuild$default(byteArrayStore2, bluetoothGattCharacteristic, handshakeService2, value, 0, null, 24, null);
        if (accumulateAndTryBuild$default == null || accumulateAndTryBuild$default.subscribe(new GattClientCallback$readPerifHalfCharacteristic$1(this, bluetoothGatt), new GattClientCallback$readPerifHalfCharacteristic$2(this)) == null) {
            GattClientCallback gattClientCallback = this;
            UUID perif_half_characteristic_uuid = BLEServer.Companion.getPERIF_HALF_CHARACTERISTIC_UUID();
            Intrinsics.checkNotNullExpressionValue(perif_half_characteristic_uuid, "BLEServer.PERIF_HALF_CHARACTERISTIC_UUID");
            BluetoothGattCharacteristic characteristic = gattClientCallback.getCharacteristic(bluetoothGatt, perif_half_characteristic_uuid);
            if (characteristic != null) {
                Boolean.valueOf(bluetoothGatt.readCharacteristic(characteristic));
                return;
            }
            gattClientCallback.holdingRequestEvents.accept(new HoldingRequestState.Disconnected());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void requestHolding(P2PMessage<InitHandshakeData> p2PMessage, BluetoothGatt bluetoothGatt) {
        this.holdingRequestEvents.accept(new HoldingRequestState.Requesting());
        this.handshakeService.generateSharedEncryptionKey(p2PMessage, Order.First);
        UUID request_characteristic_uuid = BLEServer.Companion.getREQUEST_CHARACTERISTIC_UUID();
        Intrinsics.checkNotNullExpressionValue(request_characteristic_uuid, "characteristic");
        BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, request_characteristic_uuid);
        if (characteristic != null) {
            Disposable subscribe = this.holdingsService.getLocalSecureHoldings().subscribe(new GattClientCallback$requestHolding$$inlined$let$lambda$1(characteristic, this, bluetoothGatt), new GattClientCallback$requestHolding$$inlined$let$lambda$2(this, bluetoothGatt));
            this.disposeBag.add(subscribe);
            if (subscribe != null) {
                return;
            }
        }
        this.holdingRequestEvents.accept(new HoldingRequestState.Disconnected());
        Unit unit = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void sendHoldingRequest(List<SecureHolding> list, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        UUID session = this.gattClientInterface.getSession(bluetoothGatt);
        P2PHeader p2PHeader = new P2PHeader(0, null, null, this.handshakeService.getSessionId(), session, 7, null);
        String name = MPTypeToken.HOLDING_REQUEST.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        for (T t : list) {
            if (Intrinsics.areEqual(t.getAttributes().getSharingCode(), this.sharingCode)) {
                SignedJWT parse = SignedJWT.parse(t.getJws());
                if (t.getAttributes().getSharingCode() != null) {
                    byte[] serialize = MPUtilsKt.serialize(new P2PMessage(p2PHeader, new Body(lowerCase, new RequestHolding(t.getAttributes().getSharingCode(), parse)), true, null, 8, null), this.handshakeService, session);
                    Timber.Tree log = getLog();
                    log.d("hash: " + Arrays.hashCode(serialize), new Object[0]);
                    List<List> chunked = CollectionsKt.chunked(ArraysKt.asIterable(serialize), 180);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
                    for (List list2 : chunked) {
                        arrayList.add(CollectionsKt.toByteArray(list2));
                    }
                    this.idChunks = CollectionsKt.plus((Collection) arrayList, (Object) BLEServer.Companion.getEodbytes());
                    this.idChunkIndex = 0;
                    writeNextRequestBytes(bluetoothGattCharacteristic, bluetoothGatt);
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* access modifiers changed from: private */
    public final void readHoldingCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        Timber.Tree log = getLog();
        StringBuilder sb = new StringBuilder();
        sb.append("Encrypted data chunk received: ");
        sb.append(bluetoothGattCharacteristic.getValue());
        sb.append(", size: ");
        byte[] value = bluetoothGattCharacteristic.getValue();
        sb.append(value != null ? Integer.valueOf(value.length) : null);
        sb.append(", instance: ");
        sb.append(bluetoothGattCharacteristic.getInstanceId());
        log.d(sb.toString(), new Object[0]);
        this.holdingRequestEvents.accept(new HoldingRequestState.Receiving());
        UUID session = this.gattClientInterface.getSession(bluetoothGatt);
        byte[] value2 = bluetoothGattCharacteristic.getValue();
        Intrinsics.checkNotNull(value2);
        Maybe accumulateAndTryBuild$default = ByteArrayStore.accumulateAndTryBuild$default(this.byteArrayStore, bluetoothGattCharacteristic, this.handshakeService, value2, 0, session, 8, null);
        if (accumulateAndTryBuild$default != null) {
            accumulateAndTryBuild$default.subscribe(new GattClientCallback$readHoldingCharacteristic$$inlined$also$lambda$1(this), new GattClientCallback$readHoldingCharacteristic$$inlined$also$lambda$2(this));
            if (accumulateAndTryBuild$default != null) {
                return;
            }
        }
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "characteristic.uuid");
        BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, uuid);
        if (characteristic != null) {
            Boolean.valueOf(bluetoothGatt.readCharacteristic(characteristic));
        }
    }

    /* access modifiers changed from: private */
    public final void writeCentralHalfCharacteristic(BluetoothGatt bluetoothGatt) {
        if (this.centralHalfIndex < this.centralHalfChunks.size()) {
            UUID central_half_characteritic_uuid = BLEServer.Companion.getCENTRAL_HALF_CHARACTERITIC_UUID();
            Intrinsics.checkNotNullExpressionValue(central_half_characteritic_uuid, "BLEServer.CENTRAL_HALF_CHARACTERITIC_UUID");
            BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, central_half_characteritic_uuid);
            if (characteristic != null) {
                List<byte[]> list = this.centralHalfChunks;
                int i = this.centralHalfIndex;
                this.centralHalfIndex = i + 1;
                characteristic.setValue(list.get(i));
                Intrinsics.checkNotNull(bluetoothGatt);
                bluetoothGatt.writeCharacteristic(characteristic);
                return;
            }
            return;
        }
        UUID perif_half_characteristic_uuid = BLEServer.Companion.getPERIF_HALF_CHARACTERISTIC_UUID();
        Intrinsics.checkNotNullExpressionValue(perif_half_characteristic_uuid, "BLEServer.PERIF_HALF_CHARACTERISTIC_UUID");
        BluetoothGattCharacteristic characteristic2 = getCharacteristic(bluetoothGatt, perif_half_characteristic_uuid);
        if (characteristic2 != null) {
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.readCharacteristic(characteristic2);
        }
    }

    /* access modifiers changed from: private */
    public final void writeRequestCharacteristic(BluetoothGatt bluetoothGatt) {
        if (this.idChunkIndex < this.idChunks.size()) {
            UUID request_characteristic_uuid = BLEServer.Companion.getREQUEST_CHARACTERISTIC_UUID();
            Intrinsics.checkNotNullExpressionValue(request_characteristic_uuid, "BLEServer.REQUEST_CHARACTERISTIC_UUID");
            BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, request_characteristic_uuid);
            if (characteristic != null) {
                writeNextRequestBytes(characteristic, bluetoothGatt);
                return;
            }
            return;
        }
        requestUpdateNotification(bluetoothGatt);
    }

    private final void requestUpdateNotification(BluetoothGatt bluetoothGatt) {
        this.holdingRequestEvents.accept(new HoldingRequestState.WaitingForResponse());
        getLog().d("setting notify", new Object[0]);
        UUID holding_characteristic_uuid = BLEServer.Companion.getHOLDING_CHARACTERISTIC_UUID();
        Intrinsics.checkNotNullExpressionValue(holding_characteristic_uuid, "BLEServer.HOLDING_CHARACTERISTIC_UUID");
        BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, holding_characteristic_uuid);
        if (characteristic != null) {
            characteristic.setWriteType(2);
            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString(clientCharacteristicConfigurationUUID));
            if (descriptor != null) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                Intrinsics.checkNotNull(bluetoothGatt);
                bluetoothGatt.writeDescriptor(descriptor);
            }
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.setCharacteristicNotification(characteristic, true);
            if (characteristic != null) {
                return;
            }
        }
        holdingError(new Error("Notification descriptor could not be set"));
        Unit unit = Unit.INSTANCE;
    }

    private final void writeNextRequestBytes(BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        Timber.Tree log = getLog();
        StringBuilder sb = new StringBuilder();
        sb.append("Sending sending ID chunk ");
        String arrays = Arrays.toString(this.idChunks.get(this.idChunkIndex));
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        log.d(sb.toString(), new Object[0]);
        Timber.Tree log2 = getLog();
        log2.d("index " + this.idChunkIndex, new Object[0]);
        List<byte[]> list = this.idChunks;
        int i = this.idChunkIndex;
        this.idChunkIndex = i + 1;
        bluetoothGattCharacteristic.setValue(list.get(i));
        Intrinsics.checkNotNull(bluetoothGatt);
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.handler.post(new GattClientCallback$onCharacteristicChanged$1(this, bluetoothGattCharacteristic, bluetoothGatt));
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        this.handler.post(new GattClientCallback$onServicesDiscovered$1(this, bluetoothGatt, i));
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.handler.post(new GattClientCallback$onMtuChanged$1(this, bluetoothGatt, i, i2));
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        this.handler.post(new GattClientCallback$onConnectionStateChange$1(this, i2, bluetoothGatt, i));
    }

    public final void getUsername(BluetoothGatt bluetoothGatt) {
        this.handler.post(new GattClientCallback$getUsername$1(this, bluetoothGatt));
    }

    /* access modifiers changed from: private */
    public final void getUsernameInternal(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            bluetoothGatt.requestMtu(512);
        }
        Thread.sleep(200);
        UUID scan_details_characteristic_uuid = BLEServer.Companion.getSCAN_DETAILS_CHARACTERISTIC_UUID();
        Intrinsics.checkNotNullExpressionValue(scan_details_characteristic_uuid, "BLEServer.SCAN_DETAILS_CHARACTERISTIC_UUID");
        BluetoothGattCharacteristic characteristic = getCharacteristic(bluetoothGatt, scan_details_characteristic_uuid);
        if (characteristic != null) {
            Intrinsics.checkNotNull(bluetoothGatt);
            bluetoothGatt.readCharacteristic(characteristic);
        }
    }

    /* access modifiers changed from: private */
    public final void holdingError(Throwable th) {
        this.holdingRequestEvents.accept(new HoldingRequestState.Terminated(th));
    }

    private final BluetoothGattCharacteristic getCharacteristic(BluetoothGatt bluetoothGatt, UUID uuid) {
        BluetoothGattService service;
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(BLEServer.Companion.getUSER_ID_SERVICE_UUID())) == null) {
            return null;
        }
        return service.getCharacteristic(uuid);
    }

    /* access modifiers changed from: private */
    public final String status(String str, BluetoothGatt bluetoothGatt, int i) {
        BluetoothDevice device;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": gatt_address:");
        sb.append((bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null) ? null : device.getAddress());
        sb.append(" status:");
        sb.append(i);
        return sb.toString();
    }
}
