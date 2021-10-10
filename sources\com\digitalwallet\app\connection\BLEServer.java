package com.digitalwallet.app.connection;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.os.Handler;
import android.os.ParcelUuid;
import androidx.core.app.NotificationCompat;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.Body;
import com.digitalwallet.app.model.MPTypeToken;
import com.digitalwallet.app.model.P2PHeader;
import com.digitalwallet.app.model.P2PMessage;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.model.ShareHolding;
import com.digitalwallet.app.model.util.MPUtilsKt;
import com.digitalwallet.app.oidc.AuthenticationUtility;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.di.ActivityScope;
import com.google.firebase.messaging.Constants;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 N2\u00020\u0001:\u0003MNOB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020HH\u0007J\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020JR\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 ¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0AX\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/digitalwallet/app/connection/BLEServer;", "", "application", "Landroid/app/Application;", "bleUtil", "Lcom/digitalwallet/app/connection/BLEUtil;", "authenticationUtility", "Lcom/digitalwallet/app/oidc/AuthenticationUtility;", "handshakeService", "Lcom/digitalwallet/app/services/HandshakeService;", "holdingsService", "Lcom/digitalwallet/app/holdings/HoldingsService;", "(Landroid/app/Application;Lcom/digitalwallet/app/connection/BLEUtil;Lcom/digitalwallet/app/oidc/AuthenticationUtility;Lcom/digitalwallet/app/services/HandshakeService;Lcom/digitalwallet/app/holdings/HoldingsService;)V", "_latestServerReady", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "Landroid/bluetooth/BluetoothGattServer;", "kotlin.jvm.PlatformType", "advertiseData", "Landroid/bluetooth/le/AdvertiseData;", "advertiseSettings", "Landroid/bluetooth/le/AdvertiseSettings;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "bluetoothManager$delegate", "Lkotlin/Lazy;", "bodySubject", "Lio/reactivex/subjects/PublishSubject;", "Lcom/digitalwallet/app/model/P2PMessage;", "Lcom/digitalwallet/app/model/RequestHolding;", "getBodySubject", "()Lio/reactivex/subjects/PublishSubject;", "centralHalfCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "chunkIndex", "", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "gattServerInstance", "gattServers", "Lio/reactivex/Observable;", "Lio/reactivex/Completable;", "getGattServers", "()Lio/reactivex/Observable;", "holdingCharacteristic", "holdingDataChunks", "", "", "latestServerReady", "getLatestServerReady", "()Lio/reactivex/Completable;", "nameService", "Landroid/bluetooth/BluetoothGattService;", "peripheralHalfCharacteristic", "requestCharacteristic", "requester", "Landroid/bluetooth/BluetoothDevice;", "scanDetailsCharacteristic", "server", "sessions", "", "", "Ljava/util/UUID;", "closeServer", "", "sendRequestResponse", "shareHolding", "Lcom/digitalwallet/app/model/ShareHolding;", "startAdvertising", "Lcom/digitalwallet/app/connection/BLEServer$Advertisement;", "stopAdvertising", "advertiseCallback", "Advertisement", "Companion", "ServerCallback", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
@ActivityScope
/* compiled from: BLEServer.kt */
public final class BLEServer {
    private static final UUID CENTRAL_HALF_CHARACTERITIC_UUID = UUID.fromString("B5BAE852-EE1F-430C-BA7B-972C32E0AAE3");
    public static final Companion Companion = new Companion(null);
    private static final UUID HOLDING_CHARACTERISTIC_UUID = UUID.fromString("A1926CA9-7689-4A1D-A573-BE5BBDECDBAC");
    private static final UUID PERIF_HALF_CHARACTERISTIC_UUID = UUID.fromString("F5D25113-C7A5-47E2-8026-63728B5C93DA");
    private static final UUID REQUEST_CHARACTERISTIC_UUID = UUID.fromString("522FCF97-4129-43AD-BAC1-713B509247B1");
    private static final UUID SCAN_DETAILS_CHARACTERISTIC_UUID = UUID.fromString("E051D83E-D732-4FB4-AE68-F7584AC9E5BD");
    private static final UUID USER_ID_SERVICE_UUID = UUID.fromString("E50EC97E-8623-4B07-946C-4C9249425200");
    public static final int chunksize = 180;
    private static final byte[] eodbytes;
    private BehaviorRelay<BluetoothGattServer> _latestServerReady;
    private final AdvertiseData advertiseData;
    private final AdvertiseSettings advertiseSettings;
    private final Application application;
    private AuthenticationUtility authenticationUtility;
    private final BLEUtil bleUtil;
    private final Lazy bluetoothManager$delegate;
    private final PublishSubject<P2PMessage<RequestHolding>> bodySubject;
    private final BluetoothGattCharacteristic centralHalfCharacteristic;
    private int chunkIndex;
    private final CompositeDisposable disposeBag;
    private int gattServerInstance;
    private final Observable<Completable> gattServers;
    private HandshakeService handshakeService;
    private final BluetoothGattCharacteristic holdingCharacteristic;
    private List<byte[]> holdingDataChunks;
    private HoldingsService holdingsService;
    private final BluetoothGattService nameService;
    private final BluetoothGattCharacteristic peripheralHalfCharacteristic;
    private final BluetoothGattCharacteristic requestCharacteristic;
    private BluetoothDevice requester;
    private final BluetoothGattCharacteristic scanDetailsCharacteristic;
    private BluetoothGattServer server;
    private final Map<String, UUID> sessions = new LinkedHashMap();

    private final BluetoothManager getBluetoothManager() {
        return (BluetoothManager) this.bluetoothManager$delegate.getValue();
    }

    @Inject
    public BLEServer(Application application2, BLEUtil bLEUtil, AuthenticationUtility authenticationUtility2, HandshakeService handshakeService2, HoldingsService holdingsService2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        Intrinsics.checkNotNullParameter(bLEUtil, "bleUtil");
        Intrinsics.checkNotNullParameter(authenticationUtility2, "authenticationUtility");
        Intrinsics.checkNotNullParameter(handshakeService2, "handshakeService");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        this.application = application2;
        this.bleUtil = bLEUtil;
        this.authenticationUtility = authenticationUtility2;
        this.handshakeService = handshakeService2;
        this.holdingsService = holdingsService2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.disposeBag = compositeDisposable;
        PublishSubject<P2PMessage<RequestHolding>> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.bodySubject = create;
        this.bluetoothManager$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BLEServer$bluetoothManager$2(this));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SCAN_DETAILS_CHARACTERISTIC_UUID, 10, 17);
        this.scanDetailsCharacteristic = bluetoothGattCharacteristic;
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = new BluetoothGattCharacteristic(CENTRAL_HALF_CHARACTERITIC_UUID, 10, 17);
        this.centralHalfCharacteristic = bluetoothGattCharacteristic2;
        BluetoothGattCharacteristic bluetoothGattCharacteristic3 = new BluetoothGattCharacteristic(PERIF_HALF_CHARACTERISTIC_UUID, 10, 17);
        this.peripheralHalfCharacteristic = bluetoothGattCharacteristic3;
        BluetoothGattCharacteristic bluetoothGattCharacteristic4 = new BluetoothGattCharacteristic(REQUEST_CHARACTERISTIC_UUID, 10, 17);
        this.requestCharacteristic = bluetoothGattCharacteristic4;
        BluetoothGattCharacteristic bluetoothGattCharacteristic5 = new BluetoothGattCharacteristic(HOLDING_CHARACTERISTIC_UUID, 26, 17);
        this.holdingCharacteristic = bluetoothGattCharacteristic5;
        UUID uuid = USER_ID_SERVICE_UUID;
        BluetoothGattService bluetoothGattService = new BluetoothGattService(uuid, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic2);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic3);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic4);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic5);
        Unit unit = Unit.INSTANCE;
        this.nameService = bluetoothGattService;
        AdvertiseSettings build = new AdvertiseSettings.Builder().setAdvertiseMode(1).setConnectable(true).setTxPowerLevel(3).setTimeout(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "AdvertiseSettings.Builde…t(0)\n            .build()");
        this.advertiseSettings = build;
        AdvertiseData build2 = new AdvertiseData.Builder().addServiceUuid(new ParcelUuid(uuid)).build();
        Intrinsics.checkNotNullExpressionValue(build2, "AdvertiseData.Builder()\n…ID))\n            .build()");
        this.advertiseData = build2;
        Observable<R> cache = bLEUtil.listenForOff().doOnNext(BLEServer$gattServers$1.INSTANCE).startWith((Integer) 0).map(new BLEServer$gattServers$2(this)).cache();
        Intrinsics.checkNotNullExpressionValue(cache, "bleUtil\n            .lis…   }\n            .cache()");
        this.gattServers = cache;
        BehaviorRelay<BluetoothGattServer> create2 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "BehaviorRelay.create<BluetoothGattServer>()");
        this._latestServerReady = create2;
        compositeDisposable.add(cache.subscribe());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0019\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0019\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0012\u001a\u00020\u0013XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/digitalwallet/app/connection/BLEServer$Companion;", "", "()V", "CENTRAL_HALF_CHARACTERITIC_UUID", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "getCENTRAL_HALF_CHARACTERITIC_UUID", "()Ljava/util/UUID;", "HOLDING_CHARACTERISTIC_UUID", "getHOLDING_CHARACTERISTIC_UUID", "PERIF_HALF_CHARACTERISTIC_UUID", "getPERIF_HALF_CHARACTERISTIC_UUID", "REQUEST_CHARACTERISTIC_UUID", "getREQUEST_CHARACTERISTIC_UUID", "SCAN_DETAILS_CHARACTERISTIC_UUID", "getSCAN_DETAILS_CHARACTERISTIC_UUID", "USER_ID_SERVICE_UUID", "getUSER_ID_SERVICE_UUID", "chunksize", "", "eodbytes", "", "getEodbytes", "()[B", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BLEServer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID getUSER_ID_SERVICE_UUID() {
            return BLEServer.USER_ID_SERVICE_UUID;
        }

        public final UUID getSCAN_DETAILS_CHARACTERISTIC_UUID() {
            return BLEServer.SCAN_DETAILS_CHARACTERISTIC_UUID;
        }

        public final UUID getCENTRAL_HALF_CHARACTERITIC_UUID() {
            return BLEServer.CENTRAL_HALF_CHARACTERITIC_UUID;
        }

        public final UUID getPERIF_HALF_CHARACTERISTIC_UUID() {
            return BLEServer.PERIF_HALF_CHARACTERISTIC_UUID;
        }

        public final UUID getREQUEST_CHARACTERISTIC_UUID() {
            return BLEServer.REQUEST_CHARACTERISTIC_UUID;
        }

        public final UUID getHOLDING_CHARACTERISTIC_UUID() {
            return BLEServer.HOLDING_CHARACTERISTIC_UUID;
        }

        public final byte[] getEodbytes() {
            return BLEServer.eodbytes;
        }
    }

    static {
        byte[] bytes = "EOD".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        eodbytes = bytes;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/digitalwallet/app/connection/BLEServer$Advertisement;", "Landroid/bluetooth/le/AdvertiseCallback;", "()V", Constants.FirelogAnalytics.PARAM_INSTANCE_ID, "", "getInstanceId", "()I", "onStartFailure", "", "errorCode", "onStartSuccess", "settingsInEffect", "Landroid/bluetooth/le/AdvertiseSettings;", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BLEServer.kt */
    public static final class Advertisement extends AdvertiseCallback {
        public static final Companion Companion = new Companion(null);
        private static int instanceCount;
        private final int instanceId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/connection/BLEServer$Advertisement$Companion;", "", "()V", "instanceCount", "", "getInstanceCount", "()I", "setInstanceCount", "(I)V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
        /* compiled from: BLEServer.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getInstanceCount() {
                return Advertisement.instanceCount;
            }

            public final void setInstanceCount(int i) {
                Advertisement.instanceCount = i;
            }
        }

        public Advertisement() {
            int i = instanceCount;
            instanceCount = i + 1;
            this.instanceId = i;
        }

        public final int getInstanceId() {
            return this.instanceId;
        }

        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            Intrinsics.checkNotNullParameter(advertiseSettings, "settingsInEffect");
            super.onStartSuccess(advertiseSettings);
            Timber.d("Advertising event: " + advertiseSettings, new Object[0]);
        }

        public void onStartFailure(int i) {
            super.onStartFailure(i);
            Timber.d("Advertising error: " + i, new Object[0]);
        }
    }

    public final void closeServer() {
        BluetoothGattServer value = this._latestServerReady.getValue();
        if (value != null) {
            value.clearServices();
            value.close();
        }
    }

    public final void stopAdvertising(Advertisement advertisement) {
        BluetoothLeAdvertiser bluetoothLeAdvertiser;
        Intrinsics.checkNotNullParameter(advertisement, "advertiseCallback");
        Timber.e("Stop advertising " + advertisement.getInstanceId(), new Object[0]);
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (bluetoothAdapter != null && (bluetoothLeAdvertiser = bluetoothAdapter.getBluetoothLeAdvertiser()) != null) {
            bluetoothLeAdvertiser.stopAdvertising(advertisement);
        }
    }

    public final Advertisement startAdvertising() {
        Advertisement advertisement = new Advertisement();
        Timber.e("Start advertising " + advertisement.getInstanceId(), new Object[0]);
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        Intrinsics.checkNotNull(bluetoothAdapter);
        BluetoothLeAdvertiser bluetoothLeAdvertiser = bluetoothAdapter.getBluetoothLeAdvertiser();
        Intrinsics.checkNotNull(bluetoothLeAdvertiser);
        bluetoothLeAdvertiser.startAdvertising(this.advertiseSettings, this.advertiseData, advertisement);
        return advertisement;
    }

    public final void sendRequestResponse(ShareHolding shareHolding) {
        Intrinsics.checkNotNullParameter(shareHolding, "shareHolding");
        String name = MPTypeToken.HOLDING_RESPONSE.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        Body body = new Body(lowerCase, shareHolding);
        UUID sessionId = this.handshakeService.getSessionId();
        Map<String, UUID> map = this.sessions;
        BluetoothDevice bluetoothDevice = this.requester;
        Intrinsics.checkNotNull(bluetoothDevice);
        List<List> chunked = CollectionsKt.chunked(ArraysKt.asIterable(MPUtilsKt.serialize$default(new P2PMessage(new P2PHeader(0, null, null, sessionId, map.get(bluetoothDevice.getAddress()), 7, null), body, true, null, 8, null), this.handshakeService, null, 2, null)), 180);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
        for (List list : chunked) {
            arrayList.add(CollectionsKt.toByteArray(list));
        }
        this.holdingDataChunks = CollectionsKt.plus((Collection) arrayList, (Object) eodbytes);
        StringBuilder sb = new StringBuilder();
        sb.append("ecrypted data: ");
        sb.append(this.holdingDataChunks);
        sb.append(", size: ");
        List<byte[]> list2 = this.holdingDataChunks;
        Intrinsics.checkNotNull(list2);
        sb.append(list2.size());
        Timber.d(sb.toString(), new Object[0]);
        this.chunkIndex = 0;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.holdingCharacteristic;
        List<byte[]> list3 = this.holdingDataChunks;
        Intrinsics.checkNotNull(list3);
        int i = this.chunkIndex;
        this.chunkIndex = i + 1;
        bluetoothGattCharacteristic.setValue(list3.get(i));
        BluetoothGattServer bluetoothGattServer = this.server;
        Intrinsics.checkNotNull(bluetoothGattServer);
        BluetoothDevice bluetoothDevice2 = this.requester;
        Intrinsics.checkNotNull(bluetoothDevice2);
        bluetoothGattServer.notifyCharacteristicChanged(bluetoothDevice2, this.holdingCharacteristic, false);
    }

    /* access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016JF\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0017J\"\u0010\u001d\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J\u001a\u0010 \u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u000fH\u0016J\u001a\u0010\"\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/digitalwallet/app/connection/BLEServer$ServerCallback;", "Landroid/bluetooth/BluetoothGattServerCallback;", "(Lcom/digitalwallet/app/connection/BLEServer;)V", "byteArrayStore", "Lcom/digitalwallet/app/connection/ByteArrayStore;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "perifHandshakeChunks", "", "", "perifHandshakeIndex", "", "onCharacteristicReadRequest", "", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "offset", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicWriteRequest", "preparedWrite", "", "responseNeeded", "value", "onConnectionStateChange", "status", "newState", "onMtuChanged", "mtu", "onNotificationSent", "onServiceAdded", NotificationCompat.CATEGORY_SERVICE, "Landroid/bluetooth/BluetoothGattService;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BLEServer.kt */
    public final class ServerCallback extends BluetoothGattServerCallback {
        private ByteArrayStore byteArrayStore = new ByteArrayStore();
        private Handler handler = ((Handler) BLEServer$ServerCallback$handler$1.INSTANCE.invoke());
        private List<byte[]> perifHandshakeChunks = CollectionsKt.emptyList();
        private int perifHandshakeIndex;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public ServerCallback() {
        }

        public final Handler getHandler() {
            return this.handler;
        }

        public final void setHandler(Handler handler2) {
            Intrinsics.checkNotNullParameter(handler2, "<set-?>");
            this.handler = handler2;
        }

        public void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
            this.handler.post(new BLEServer$ServerCallback$onNotificationSent$1(this, bluetoothDevice, i));
        }

        public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            this.handler.post(new BLEServer$ServerCallback$onCharacteristicReadRequest$1(this, bluetoothDevice, i, i2, bluetoothGattCharacteristic));
        }

        public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
            this.handler.post(new BLEServer$ServerCallback$onCharacteristicWriteRequest$1(this, bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr));
        }

        public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
            this.handler.post(new BLEServer$ServerCallback$onConnectionStateChange$1(this, bluetoothDevice, i, i2));
        }

        public void onMtuChanged(BluetoothDevice bluetoothDevice, int i) {
            this.handler.post(new BLEServer$ServerCallback$onMtuChanged$1(this, bluetoothDevice, i));
        }

        public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
            this.handler.post(new BLEServer$ServerCallback$onServiceAdded$1(this, i, bluetoothGattService));
        }
    }

    public final PublishSubject<P2PMessage<RequestHolding>> getBodySubject() {
        return this.bodySubject;
    }

    private final BluetoothAdapter getBluetoothAdapter() {
        BluetoothManager bluetoothManager = getBluetoothManager();
        if (bluetoothManager != null) {
            return bluetoothManager.getAdapter();
        }
        return null;
    }

    public final Observable<Completable> getGattServers() {
        return this.gattServers;
    }

    public final Completable getLatestServerReady() {
        Completable flatMapCompletable = this._latestServerReady.take(1).flatMapCompletable(BLEServer$latestServerReady$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "_latestServerReady.take(… Completable.complete() }");
        return flatMapCompletable;
    }
}
