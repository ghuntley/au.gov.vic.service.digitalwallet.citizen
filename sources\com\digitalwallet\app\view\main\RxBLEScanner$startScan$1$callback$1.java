package com.digitalwallet.app.view.main;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import io.reactivex.ObservableEmitter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"com/digitalwallet/app/view/main/RxBLEScanner$startScan$1$callback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxBLEScanner$startScan$1$callback$1 extends ScanCallback {
    final /* synthetic */ ObservableEmitter $it;

    RxBLEScanner$startScan$1$callback$1(ObservableEmitter observableEmitter) {
        this.$it = observableEmitter;
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        this.$it.onNext(new RxScanFailed(i));
    }

    public void onScanResult(int i, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "result");
        super.onScanResult(i, scanResult);
        this.$it.onNext(new RxScanResult(i, scanResult));
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        super.onBatchScanResults(list);
        this.$it.onNext(new RxBatchScanResult(list));
    }
}
