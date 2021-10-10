package com.digitalwallet.app.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Handler;
import android.os.Looper;
import com.digitalwallet.app.connection.BLEClient;
import io.reactivex.subjects.CompletableSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/digitalwallet/app/connection/BLEScanCallback;", "Landroid/bluetooth/le/ScanCallback;", "Lcom/digitalwallet/app/connection/BLEScanResult;", "scanInterface", "Lcom/digitalwallet/app/connection/BLEScanInterface;", "(Lcom/digitalwallet/app/connection/BLEScanInterface;)V", "immediateScanCheck", "Lio/reactivex/subjects/CompletableSubject;", "getImmediateScanCheck", "()Lio/reactivex/subjects/CompletableSubject;", "log", "Ltimber/log/Timber$Tree;", "getLog", "()Ltimber/log/Timber$Tree;", "<set-?>", "", "", "Landroid/bluetooth/BluetoothDevice;", "scannedDevices", "getScannedDevices", "()Ljava/util/Map;", "addScanResult", "", "result", "Landroid/bluetooth/le/ScanResult;", "onBatchScanResults", "results", "", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: BLEScanCallback.kt */
public final class BLEScanCallback extends ScanCallback implements BLEScanResult {
    private final CompletableSubject immediateScanCheck;
    private final BLEScanInterface scanInterface;
    private Map<String, BluetoothDevice> scannedDevices = new LinkedHashMap();

    public BLEScanCallback(BLEScanInterface bLEScanInterface) {
        Intrinsics.checkNotNullParameter(bLEScanInterface, "scanInterface");
        this.scanInterface = bLEScanInterface;
        CompletableSubject create = CompletableSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "CompletableSubject.create()");
        this.immediateScanCheck = create;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) {
            /* class com.digitalwallet.app.connection.BLEScanCallback.AnonymousClass1 */
            final /* synthetic */ BLEScanCallback this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                this.this$0.getImmediateScanCheck().onComplete();
            }
        }, 1000);
    }

    private final Timber.Tree getLog() {
        Timber.Tree tag = Timber.tag("Bluetooth-ScanCallback");
        Intrinsics.checkNotNullExpressionValue(tag, "Timber.tag(\"Bluetooth-ScanCallback\")");
        return tag;
    }

    public final Map<String, BluetoothDevice> getScannedDevices() {
        return this.scannedDevices;
    }

    @Override // com.digitalwallet.app.connection.BLEScanResult
    public CompletableSubject getImmediateScanCheck() {
        return this.immediateScanCheck;
    }

    public void onScanResult(int i, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "result");
        addScanResult(scanResult);
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            addScanResult(it.next());
        }
    }

    public void onScanFailed(int i) {
        this.scanInterface.cursed();
        Timber.Tree log = getLog();
        log.e("onScanFailed: " + i, new Object[0]);
        getImmediateScanCheck().onError(new BLEClient.ImmediateScanFail(i));
    }

    private final void addScanResult(ScanResult scanResult) {
        BluetoothDevice device = scanResult.getDevice();
        Map<String, BluetoothDevice> map = this.scannedDevices;
        Intrinsics.checkNotNullExpressionValue(device, "device");
        if (!map.containsKey(device.getAddress())) {
            Timber.Tree log = getLog();
            log.d("Found device: address " + device.getAddress() + " & name " + device.getName() + ' ', new Object[0]);
            Map<String, BluetoothDevice> map2 = this.scannedDevices;
            String address = device.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "device.address");
            map2.put(address, device);
        }
    }
}
