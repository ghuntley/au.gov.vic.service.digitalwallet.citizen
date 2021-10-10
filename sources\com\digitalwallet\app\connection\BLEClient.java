package com.digitalwallet.app.connection;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.util.LruCache;
import com.digitalwallet.app.holdings.HoldingsService;
import com.digitalwallet.app.model.RequestHolding;
import com.digitalwallet.app.services.HandshakeService;
import com.digitalwallet.app.utilities.WrapNull;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

public final class BLEClient implements GattClientInterface, BLEScanInterface {
    private final AnalyticsHelper analytics;
    private final Application application;
    private final BLEUtil bleUtil;
    private final BluetoothAdapter bluetoothAdapter;
    private final BluetoothManager bluetoothManager;
    private boolean cursed;
    private CompositeDisposable disposables = new CompositeDisposable();
    private LruCache<String, GattClientCallback> gattCallbacks;
    private LruCache<String, BluetoothConnection> gattConnections;
    private Handler handler;
    private final HandshakeService handshakeService;
    private final HoldingsService holdingsService;
    private BLEScanCallback scanCallback;
    private final Map<String, UUID> sessions;
    public String sharingCode;

    public static final class HandshakeConnectionError extends Error {
    }

    public static final class HandshakeServiceError extends Error {
    }

    public BLEClient(Application application2, BLEUtil bLEUtil, AnalyticsHelper analyticsHelper, HoldingsService holdingsService2, HandshakeService handshakeService2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        Intrinsics.checkNotNullParameter(bLEUtil, "bleUtil");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        Intrinsics.checkNotNullParameter(holdingsService2, "holdingsService");
        Intrinsics.checkNotNullParameter(handshakeService2, "handshakeService");
        this.application = application2;
        this.bleUtil = bLEUtil;
        this.analytics = analyticsHelper;
        this.holdingsService = holdingsService2;
        this.handshakeService = handshakeService2;
        Object systemService = application2.getSystemService("bluetooth");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager2 = (BluetoothManager) systemService;
        this.bluetoothManager = bluetoothManager2;
        BluetoothAdapter adapter = bluetoothManager2.getAdapter();
        Intrinsics.checkNotNullExpressionValue(adapter, "bluetoothManager.adapter");
        this.bluetoothAdapter = adapter;
        this.gattCallbacks = new LruCache<>(1024);
        this.gattConnections = new LruCache<>(1024);
        this.sessions = new LinkedHashMap();
        this.handler = (Handler) BLEClient$handler$1.INSTANCE.invoke();
    }

    public static final /* synthetic */ Map access$getSessions$p(BLEClient bLEClient) {
        return bLEClient.sessions;
    }

    private final Timber.Tree getLog() {
        Timber.Tree tag = Timber.tag("Bluetooth-BLEClient");
        Intrinsics.checkNotNullExpressionValue(tag, "Timber.tag(\"Bluetooth-BLEClient\")");
        return tag;
    }

    private final BluetoothLeScanner getBluetoothLeScanner() {
        return this.bluetoothAdapter.getBluetoothLeScanner();
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final void setHandler(Handler handler2) {
        Intrinsics.checkNotNullParameter(handler2, "<set-?>");
        this.handler = handler2;
    }

    public final String getSharingCode() {
        String str = this.sharingCode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RequestHolding.sharingCodeKey);
        }
        return str;
    }

    public final void setSharingCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sharingCode = str;
    }

    public static final class ImmediateScanFail extends Error {
        private final int errorCode;

        public ImmediateScanFail(int i) {
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public final Single<List<NamedDevice>> scan() {
        Completable completable;
        getLog().d("start scan hit", new Object[0]);
        if (this.cursed) {
            new Handler(Looper.getMainLooper()).post(new BLEClient$scan$1(this));
        }
        boolean z = this.cursed;
        long j = z ? 4 : 2;
        long j2 = z ? 15 : 10;
        if (z) {
            getLog().e("Mitigate scan fail", new Object[0]);
            completable = disconnectPeersAndDisable().andThen(this.bleUtil.enable());
        } else {
            completable = this.bleUtil.enable();
        }
        this.cursed = false;
        Single<List<NamedDevice>> doOnError = completable.andThen(startScanPhase()).delay(j, TimeUnit.SECONDS).toSingle(new BLEClient$scan$2(this)).flatMap(new BLEClient$scan$3(this, j2)).doOnError(new BLEClient$scan$4(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "enable\n            .andT… stopScan()\n            }");
        return doOnError;
    }

    private final Completable disconnectPeersAndDisable() {
        disconnectFromAllPeers$default(this, null, 1, null);
        return this.bleUtil.disable();
    }

    private final Completable startScanPhase() {
        Completable defer = Completable.defer(new BLEClient$startScanPhase$1(this));
        Intrinsics.checkNotNullExpressionValue(defer, "Completable.defer { star…an().immediateScanCheck }");
        return defer;
    }

    private final BLEScanResult startScan() {
        BLEScanCallback bLEScanCallback;
        if (this.scanCallback != null) {
            stopScan();
        }
        BluetoothLeScanner bluetoothLeScanner = getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            try {
                List<ScanFilter> listOf = CollectionsKt.listOf(new ScanFilter.Builder().setServiceUuid(new ParcelUuid(BLEServer.Companion.getUSER_ID_SERVICE_UUID())).build());
                ScanSettings build = new ScanSettings.Builder().setScanMode(2).build();
                if (this.scanCallback == null) {
                    bLEScanCallback = new BLEScanCallback(this);
                    bluetoothLeScanner.startScan(listOf, build, bLEScanCallback);
                    this.scanCallback = bLEScanCallback;
                    if (bLEScanCallback != null) {
                        return bLEScanCallback;
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } catch (Exception unused) {
                bLEScanCallback = null;
            }
        }
        getLog().e("BLE scanner not available", new Object[0]);
        return new BLEScanDisabled();
    }

    private final Map<String, BluetoothDevice> takeResults() {
        Map<String, BluetoothDevice> scannedDevices;
        if (this.bluetoothAdapter.isEnabled()) {
            BLEScanCallback bLEScanCallback = this.scanCallback;
            if (bLEScanCallback == null || (scannedDevices = bLEScanCallback.getScannedDevices()) == null) {
                return MapsKt.emptyMap();
            }
            HashMap hashMap = new HashMap(scannedDevices);
            stopScan();
            return hashMap;
        }
        stopScan();
        return MapsKt.emptyMap();
    }

    public final void stopScan() {
        BluetoothLeScanner bluetoothLeScanner;
        getLog().d("Stop scan hit", new Object[0]);
        if (!(this.scanCallback == null || (bluetoothLeScanner = getBluetoothLeScanner()) == null)) {
            bluetoothLeScanner.stopScan(this.scanCallback);
        }
        this.scanCallback = null;
    }

    private final void disconnectFromPeer(BluetoothGatt bluetoothGatt) {
        BluetoothDevice device = bluetoothGatt.getDevice();
        Intrinsics.checkNotNullExpressionValue(device, "gatt.device");
        String address = device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "gatt.device.address");
        disconnected(address);
        bluetoothGatt.disconnect();
    }

    public static /* synthetic */ void disconnectFromAllPeers$default(BLEClient bLEClient, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        bLEClient.disconnectFromAllPeers(str);
    }

    public final void disconnectFromAllPeers(String str) {
        getLog().d("Disconnect from all peers", new Object[0]);
        this.disposables = new CompositeDisposable();
        ArrayList<BluetoothConnection> arrayList = new ArrayList();
        for (T t : this.gattConnections.snapshot().values()) {
            if (!Intrinsics.areEqual(t.getDevice().getAddress(), str)) {
                arrayList.add(t);
            }
        }
        for (BluetoothConnection bluetoothConnection : arrayList) {
            disconnectFromPeer(bluetoothConnection.getGatt());
        }
        this.handshakeService.reset();
    }

    public final Pair<Completable, PublishRelay<HoldingRequestState>> requestHolding(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
        String address = bluetoothDevice.getAddress();
        disconnectFromAllPeers(address);
        this.handshakeService.reset();
        Pair<Single<CallbackConnection>, GattClientCallback> connect = connect(bluetoothDevice);
        return new Pair<>(connect.getFirst().flatMap(new BLEClient$requestHolding$request$1(this, address)).retry(3).ignoreElement(), connect.getSecond().getHoldingRequestEvents());
    }

    private final Single<GattClientCallback> handshake(String str, CallbackConnection callbackConnection) {
        BluetoothConnection bluetoothConnection = this.gattConnections.get(str);
        GattClientCallback callback = callbackConnection.getCallback();
        boolean connected = callbackConnection.getConnected();
        if (!connected) {
            Single<GattClientCallback> error = Single.error(new HandshakeConnectionError());
            Intrinsics.checkNotNullExpressionValue(error, "Single.error(HandshakeConnectionError())");
            return error;
        } else if (connected) {
            Single<R> flatMap = discoverName(callbackConnection).flatMap(new BLEClient$handshake$1(this, str, callback, bluetoothConnection));
            Intrinsics.checkNotNullExpressionValue(flatMap, "discoverName(callbackCon…  }\n                    }");
            return flatMap;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final Single<List<NamedDevice>> connectToAllPeers(Map<String, BluetoothDevice> map, long j) {
        if (map.isEmpty()) {
            getLog().e("No devices found!", new Object[0]);
            Single<List<NamedDevice>> just = Single.just(CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(listOf())");
            return just;
        }
        getLog().d("Devices found.  Connecting to:", new Object[0]);
        for (Map.Entry<String, BluetoothDevice> entry : map.entrySet()) {
            getLog().d(entry.getKey(), new Object[0]);
        }
        Single<List<NamedDevice>> collectInto = Observable.fromIterable(map.entrySet()).concatMap(new BLEClient$connectToAllPeers$2(this)).take((long) map.size()).take(j, TimeUnit.SECONDS).collectInto(new ArrayList(), new BLEClient$connectToAllPeers$3(this));
        Intrinsics.checkNotNullExpressionValue(collectInto, "Observable.fromIterable(…          }\n            )");
        return collectInto;
    }

    /* access modifiers changed from: public */
    private final Single<WrapNull<NamedDevice>> discoverName(CallbackConnection callbackConnection) {
        Single<WrapNull<NamedDevice>> just = Single.just(new WrapNull(null, 1, null));
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(WrapNull<NamedDevice>())");
        boolean connected = callbackConnection.getConnected();
        if (!connected) {
            return just;
        }
        if (connected) {
            Timber.Tree log = getLog();
            log.d("Device connected. Discovering name: " + callbackConnection.getCallback().getDebugAddress(), new Object[0]);
            Single<R> map = callbackConnection.getCallback().getScanReceived().take(1).singleOrError().map(BLEClient$discoverName$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(map, "callbackConnection.callb…vent -> WrapNull(event) }");
            return map;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final class GattCallbackReturn {
        private final GattClientCallback callback;
        private final boolean reused;

        public static /* synthetic */ GattCallbackReturn copy$default(GattCallbackReturn gattCallbackReturn, boolean z, GattClientCallback gattClientCallback, int i, Object obj) {
            if ((i & 1) != 0) {
                z = gattCallbackReturn.reused;
            }
            if ((i & 2) != 0) {
                gattClientCallback = gattCallbackReturn.callback;
            }
            return gattCallbackReturn.copy(z, gattClientCallback);
        }

        public final boolean component1() {
            return this.reused;
        }

        public final GattClientCallback component2() {
            return this.callback;
        }

        public final GattCallbackReturn copy(boolean z, GattClientCallback gattClientCallback) {
            Intrinsics.checkNotNullParameter(gattClientCallback, "callback");
            return new GattCallbackReturn(z, gattClientCallback);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GattCallbackReturn)) {
                return false;
            }
            GattCallbackReturn gattCallbackReturn = (GattCallbackReturn) obj;
            return this.reused == gattCallbackReturn.reused && Intrinsics.areEqual(this.callback, gattCallbackReturn.callback);
        }

        public int hashCode() {
            boolean z = this.reused;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = i * 31;
            GattClientCallback gattClientCallback = this.callback;
            return i4 + (gattClientCallback != null ? gattClientCallback.hashCode() : 0);
        }

        public String toString() {
            return "GattCallbackReturn(reused=" + this.reused + ", callback=" + this.callback + ")";
        }

        public GattCallbackReturn(boolean z, GattClientCallback gattClientCallback) {
            Intrinsics.checkNotNullParameter(gattClientCallback, "callback");
            this.reused = z;
            this.callback = gattClientCallback;
        }

        public final GattClientCallback getCallback() {
            return this.callback;
        }

        public final boolean getReused() {
            return this.reused;
        }
    }

    private final GattCallbackReturn getGattCallback(String str) {
        GattCallbackReturn gattCallbackReturn;
        synchronized (this.gattCallbacks) {
            GattClientCallback gattClientCallback = this.gattCallbacks.get(str);
            if (gattClientCallback != null) {
                gattCallbackReturn = new GattCallbackReturn(true, gattClientCallback);
            } else {
                BLEClient bLEClient = this;
                BLEClient bLEClient2 = bLEClient;
                HandshakeService handshakeService2 = bLEClient.handshakeService;
                HoldingsService holdingsService2 = bLEClient.holdingsService;
                String str2 = bLEClient.sharingCode;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(RequestHolding.sharingCodeKey);
                }
                GattClientCallback gattClientCallback2 = new GattClientCallback(bLEClient2, handshakeService2, holdingsService2, str2, bLEClient.handler, str);
                bLEClient.gattCallbacks.put(str, gattClientCallback2);
                gattClientCallback2.setOnDisconnectSubscriber(new BLEClient$getGattCallback$$inlined$synchronized$lambda$1(gattClientCallback2, bLEClient, this, str));
                gattCallbackReturn = new GattCallbackReturn(false, gattClientCallback2);
            }
        }
        return gattCallbackReturn;
    }

    /* access modifiers changed from: public */
    private final Pair<Single<CallbackConnection>, GattClientCallback> connect(BluetoothDevice bluetoothDevice) {
        Pair<Single<CallbackConnection>, GattClientCallback> pair;
        synchronized (this.gattCallbacks) {
            String address = bluetoothDevice.getAddress();
            BluetoothConnection bluetoothConnection = this.gattConnections.get(address);
            String address2 = bluetoothDevice.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "device.address");
            GattCallbackReturn gattCallback = getGattCallback(address2);
            if (!(gattCallback.getReused() == (bluetoothConnection != null))) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (bluetoothConnection != null) {
                GattClientCallback callback = gattCallback.getCallback();
                callback.getUsername(bluetoothConnection.getGatt());
                Single just = Single.just(new CallbackConnection(true, callback));
                Intrinsics.checkNotNullExpressionValue(just, "Single.just(CallbackConnection(true, it))");
                pair = new Pair<>(just, callback);
            } else {
                GattClientCallback callback2 = gattCallback.getCallback();
                Single<R> map = callback2.getConnectionEvents().take(1).firstOrError().map(new BLEClient$connect$1$nextEvent$1(callback2));
                Intrinsics.checkNotNullExpressionValue(map, "callback.connectionEvent…it.connected, callback) }");
                BluetoothGatt connectGatt = bluetoothDevice.connectGatt(this.application, false, callback2, 2);
                if (connectGatt != null) {
                    this.gattConnections.put(address, new BluetoothConnection(bluetoothDevice, connectGatt));
                    if (connectGatt != null) {
                        pair = new Pair<>(map, callback2);
                    }
                }
                throw new IllegalStateException(("Null connection!! " + bluetoothDevice).toString());
            }
        }
        return pair;
    }

    /* access modifiers changed from: public */
    private final void disconnected(String str) {
        synchronized (this.gattCallbacks) {
            boolean z = this.gattConnections.remove(str) == null;
            if (z) {
                Timber.Tree log = getLog();
                log.e("Device disconnected but not registered: " + str, new Object[0]);
            } else if (!z) {
                Timber.Tree log2 = getLog();
                log2.e("Device disconnected: " + str, new Object[0]);
            }
            boolean z2 = this.gattCallbacks.remove(str) == null;
            if (z2) {
                Timber.Tree log3 = getLog();
                log3.e("Callback removed but not registered: " + str, new Object[0]);
            } else if (!z2) {
                Timber.Tree log4 = getLog();
                log4.e("Callback removed: " + str, new Object[0]);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.digitalwallet.app.connection.GattClientInterface
    public UUID getSession(BluetoothGatt bluetoothGatt) {
        Intrinsics.checkNotNullParameter(bluetoothGatt, "gatt");
        Map<String, UUID> map = this.sessions;
        BluetoothDevice device = bluetoothGatt.getDevice();
        Intrinsics.checkNotNull(device);
        UUID uuid = map.get(device.getAddress());
        Intrinsics.checkNotNull(uuid);
        return uuid;
    }

    @Override // com.digitalwallet.app.connection.GattClientInterface, com.digitalwallet.app.connection.BLEScanInterface
    public void cursed() {
        this.cursed = true;
    }
}
