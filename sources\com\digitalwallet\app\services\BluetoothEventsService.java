package com.digitalwallet.app.services;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.databinding.ObservableBoolean;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0005R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/digitalwallet/app/services/BluetoothEventsService;", "", "()V", "adapterStateHistory", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "kotlin.jvm.PlatformType", "bluetoothStateReceiver", "Lcom/digitalwallet/app/services/BluetoothEventsService$BluetoothStateChangeReceiver;", "serviceRunning", "Landroidx/databinding/ObservableBoolean;", "getServiceRunning", "()Landroidx/databinding/ObservableBoolean;", "listenForState", "Lio/reactivex/Observable;", "state", "register", "", "context", "Landroid/content/Context;", "unregister", "waitForState", "Lio/reactivex/Completable;", "BluetoothStateChangeReceiver", "Companion", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BluetoothEventsService.kt */
public final class BluetoothEventsService {
    public static final Companion Companion = new Companion(null);
    private static final Set<Integer> STATES_RUNNING = SetsKt.setOf((Object[]) new Integer[]{12, 1, 2});
    public static final int STATE_UNSET = 0;
    private final BehaviorRelay<Integer> adapterStateHistory;
    private final BluetoothStateChangeReceiver bluetoothStateReceiver = new BluetoothStateChangeReceiver();
    private final ObservableBoolean serviceRunning = new ObservableBoolean();

    @Inject
    public BluetoothEventsService() {
        BehaviorRelay<Integer> createDefault = BehaviorRelay.createDefault(0);
        Intrinsics.checkNotNullExpressionValue(createDefault, "BehaviorRelay.createDefault(STATE_UNSET)");
        this.adapterStateHistory = createDefault;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/services/BluetoothEventsService$Companion;", "", "()V", "STATES_RUNNING", "", "", "getSTATES_RUNNING", "()Ljava/util/Set;", "STATE_UNSET", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BluetoothEventsService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<Integer> getSTATES_RUNNING() {
            return BluetoothEventsService.STATES_RUNNING;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/digitalwallet/app/services/BluetoothEventsService$BluetoothStateChangeReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/digitalwallet/app/services/BluetoothEventsService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BluetoothEventsService.kt */
    public final class BluetoothStateChangeReceiver extends BroadcastReceiver {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public BluetoothStateChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                Timber.e("Bluetooth state change: " + intExtra, new Object[0]);
                BluetoothEventsService.this.adapterStateHistory.accept(Integer.valueOf(intExtra));
                BluetoothEventsService.this.getServiceRunning().set(BluetoothEventsService.Companion.getSTATES_RUNNING().contains(Integer.valueOf(intExtra)));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final ObservableBoolean getServiceRunning() {
        return this.serviceRunning;
    }

    public final void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.registerReceiver(this.bluetoothStateReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        ObservableBoolean observableBoolean = this.serviceRunning;
        Set<Integer> set = STATES_RUNNING;
        Object systemService = context.getSystemService("bluetooth");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        observableBoolean.set(CollectionsKt.contains(set, adapter != null ? Integer.valueOf(adapter.getState()) : null));
    }

    public final void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.unregisterReceiver(this.bluetoothStateReceiver);
    }

    public final Completable waitForState(int i) {
        Completable ignoreElements = this.adapterStateHistory.filter(new BluetoothEventsService$waitForState$1(i)).doOnNext(BluetoothEventsService$waitForState$2.INSTANCE).take(1).ignoreElements();
        Timber.d("Waiting for state: " + i, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "adapterStateHistory\n    …e: $state\")\n            }");
        return ignoreElements;
    }

    public final Observable<Integer> listenForState(int i) {
        Observable<Integer> doOnNext = this.adapterStateHistory.filter(new BluetoothEventsService$listenForState$1(i)).doOnNext(BluetoothEventsService$listenForState$2.INSTANCE);
        Timber.d("Listening for state: " + i, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(doOnNext, "adapterStateHistory\n    …e: $state\")\n            }");
        return doOnNext;
    }
}
