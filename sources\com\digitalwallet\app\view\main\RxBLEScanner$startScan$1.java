package com.digitalwallet.app.view.main;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lio/reactivex/ObservableEmitter;", "Lcom/digitalwallet/app/view/main/RxBLEScanResult;", "kotlin.jvm.PlatformType", "subscribe"}, k = 3, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
final class RxBLEScanner$startScan$1<T> implements ObservableOnSubscribe<RxBLEScanResult> {
    final /* synthetic */ List $filters;
    final /* synthetic */ int $scanId;
    final /* synthetic */ ScanSettings $settings;
    final /* synthetic */ RxBLEScanner this$0;

    RxBLEScanner$startScan$1(RxBLEScanner rxBLEScanner, int i, List list, ScanSettings scanSettings) {
        this.this$0 = rxBLEScanner;
        this.$scanId = i;
        this.$filters = list;
        this.$settings = scanSettings;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<RxBLEScanResult> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "it");
        RxBLEScanner$startScan$1$callback$1 rxBLEScanner$startScan$1$callback$1 = new RxBLEScanner$startScan$1$callback$1(observableEmitter);
        ScanCallback scanCallback = (ScanCallback) RxBLEScanner.access$getScans$p(this.this$0).get(Integer.valueOf(this.$scanId));
        if (scanCallback != null) {
            RxBLEScanner.access$getLeScanner$p(this.this$0).stopScan(scanCallback);
        }
        TuplesKt.to(RxBLEScanner.access$getScans$p(this.this$0).get(Integer.valueOf(this.$scanId)), rxBLEScanner$startScan$1$callback$1);
        RxBLEScanner.access$getLeScanner$p(this.this$0).startScan(this.$filters, this.$settings, rxBLEScanner$startScan$1$callback$1);
    }
}
