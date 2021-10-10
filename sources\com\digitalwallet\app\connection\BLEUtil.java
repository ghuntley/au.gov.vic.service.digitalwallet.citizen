package com.digitalwallet.app.connection;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothManager;
import com.digitalwallet.app.services.BluetoothEventsService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002()B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001bJ\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/digitalwallet/app/connection/BLEUtil;", "", "application", "Landroid/app/Application;", "bluetoothEventsService", "Lcom/digitalwallet/app/services/BluetoothEventsService;", "(Landroid/app/Application;Lcom/digitalwallet/app/services/BluetoothEventsService;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter$delegate", "Lkotlin/Lazy;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "bluetoothManager$delegate", "enabled", "", "getEnabled", "()Z", "log", "Ltimber/log/Timber$Tree;", "getLog", "()Ltimber/log/Timber$Tree;", "disable", "Lio/reactivex/Completable;", "enable", "listenForOff", "Lio/reactivex/Observable;", "", "openGattServer", "Lio/reactivex/Single;", "Landroid/bluetooth/BluetoothGattServer;", "callback", "Landroid/bluetooth/BluetoothGattServerCallback;", "waitForEnabled", "waitForOff", "waitForOn", "AlreadyDisabled", "CannotEnable", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BLEUtil.kt */
public final class BLEUtil {
    private final Application application;
    private final Lazy bluetoothAdapter$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BLEUtil$bluetoothAdapter$2(this));
    private final BluetoothEventsService bluetoothEventsService;
    private final Lazy bluetoothManager$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BLEUtil$bluetoothManager$2(this));

    /* access modifiers changed from: private */
    public final BluetoothAdapter getBluetoothAdapter() {
        return (BluetoothAdapter) this.bluetoothAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final BluetoothManager getBluetoothManager() {
        return (BluetoothManager) this.bluetoothManager$delegate.getValue();
    }

    @Inject
    public BLEUtil(Application application2, BluetoothEventsService bluetoothEventsService2) {
        Intrinsics.checkNotNullParameter(application2, "application");
        Intrinsics.checkNotNullParameter(bluetoothEventsService2, "bluetoothEventsService");
        this.application = application2;
        this.bluetoothEventsService = bluetoothEventsService2;
    }

    /* access modifiers changed from: private */
    public final Timber.Tree getLog() {
        Timber.Tree tag = Timber.tag("Bluetooth-BLEUtil");
        Intrinsics.checkNotNullExpressionValue(tag, "Timber.tag(\"Bluetooth-BLEUtil\")");
        return tag;
    }

    public final boolean getEnabled() {
        return getBluetoothAdapter().isEnabled();
    }

    public final Single<BluetoothGattServer> openGattServer(BluetoothGattServerCallback bluetoothGattServerCallback) {
        Intrinsics.checkNotNullParameter(bluetoothGattServerCallback, "callback");
        Single<BluetoothGattServer> retryWhen = Single.create(new BLEUtil$openGattServer$1(this, bluetoothGattServerCallback)).retryWhen(BLEUtil$openGattServer$2.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(retryWhen, "Single\n            .crea…          }\n            }");
        return retryWhen;
    }

    public final Observable<Integer> listenForOff() {
        return this.bluetoothEventsService.listenForState(10);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/digitalwallet/app/connection/BLEUtil$CannotEnable;", "Ljava/lang/Error;", "Lkotlin/Error;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BLEUtil.kt */
    public static final class CannotEnable extends Error {
        public CannotEnable() {
            super("Cannot enable bluetooth - is aeroplane mode on?");
        }
    }

    public final Completable enable() {
        Completable defer = Completable.defer(new BLEUtil$enable$1(this));
        Intrinsics.checkNotNullExpressionValue(defer, "Completable.defer {\n    …}\n            }\n        }");
        return defer;
    }

    /* access modifiers changed from: private */
    public final Completable waitForOn() {
        Completable timeout = this.bluetoothEventsService.waitForState(12).timeout(10, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(timeout, "bluetoothEventsService.w…out(10, TimeUnit.SECONDS)");
        return timeout;
    }

    public final Completable waitForEnabled() {
        return this.bluetoothEventsService.waitForState(12);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/digitalwallet/app/connection/BLEUtil$AlreadyDisabled;", "Ljava/lang/Error;", "Lkotlin/Error;", "()V", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BLEUtil.kt */
    public static final class AlreadyDisabled extends Error {
        public AlreadyDisabled() {
            super("Bluetooth already disabled");
        }
    }

    public final Completable disable() {
        Completable defer = Completable.defer(new BLEUtil$disable$1(this));
        Intrinsics.checkNotNullExpressionValue(defer, "Completable.defer {\n    …}\n            }\n        }");
        return defer;
    }

    /* access modifiers changed from: private */
    public final Completable waitForOff() {
        Completable timeout = this.bluetoothEventsService.waitForState(10).timeout(10, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(timeout, "bluetoothEventsService.w…out(10, TimeUnit.SECONDS)");
        return timeout;
    }
}
