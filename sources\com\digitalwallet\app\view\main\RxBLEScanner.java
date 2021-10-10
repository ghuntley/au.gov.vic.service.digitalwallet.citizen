package com.digitalwallet.app.view.main;

import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/digitalwallet/app/view/main/RxBLEScanner;", "", "leScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "(Landroid/bluetooth/le/BluetoothLeScanner;)V", "scans", "", "", "Landroid/bluetooth/le/ScanCallback;", "startScan", "Lio/reactivex/Observable;", "Lcom/digitalwallet/app/view/main/RxBLEScanResult;", "scanId", "filters", "", "Landroid/bluetooth/le/ScanFilter;", "settings", "Landroid/bluetooth/le/ScanSettings;", "stopScan", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxBLEScanner {
    private final BluetoothLeScanner leScanner;
    private final Map<Integer, ScanCallback> scans = new LinkedHashMap();

    public RxBLEScanner(BluetoothLeScanner bluetoothLeScanner) {
        Intrinsics.checkNotNullParameter(bluetoothLeScanner, "leScanner");
        this.leScanner = bluetoothLeScanner;
    }

    public final Observable<RxBLEScanResult> startScan(int i, List<ScanFilter> list, ScanSettings scanSettings) {
        Intrinsics.checkNotNullParameter(list, "filters");
        Intrinsics.checkNotNullParameter(scanSettings, "settings");
        Observable<RxBLEScanResult> create = Observable.create(new RxBLEScanner$startScan$1(this, i, list, scanSettings));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<RxBLES…, callback)\n            }");
        return create;
    }

    public final void stopScan(int i) {
        ScanCallback scanCallback = this.scans.get(Integer.valueOf(i));
        if (scanCallback != null) {
            this.leScanner.stopScan(scanCallback);
        }
        this.scans.remove(Integer.valueOf(i));
    }
}
