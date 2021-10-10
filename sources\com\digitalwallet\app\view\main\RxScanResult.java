package com.digitalwallet.app.view.main;

import android.bluetooth.le.ScanResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/digitalwallet/app/view/main/RxScanResult;", "Lcom/digitalwallet/app/view/main/RxBLEScanResult;", "callbackType", "", "result", "Landroid/bluetooth/le/ScanResult;", "(ILandroid/bluetooth/le/ScanResult;)V", "getCallbackType", "()I", "getResult", "()Landroid/bluetooth/le/ScanResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxScanResult extends RxBLEScanResult {
    private final int callbackType;
    private final ScanResult result;

    public static /* synthetic */ RxScanResult copy$default(RxScanResult rxScanResult, int i, ScanResult scanResult, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rxScanResult.callbackType;
        }
        if ((i2 & 2) != 0) {
            scanResult = rxScanResult.result;
        }
        return rxScanResult.copy(i, scanResult);
    }

    public final int component1() {
        return this.callbackType;
    }

    public final ScanResult component2() {
        return this.result;
    }

    public final RxScanResult copy(int i, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "result");
        return new RxScanResult(i, scanResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxScanResult)) {
            return false;
        }
        RxScanResult rxScanResult = (RxScanResult) obj;
        return this.callbackType == rxScanResult.callbackType && Intrinsics.areEqual(this.result, rxScanResult.result);
    }

    public int hashCode() {
        int i = this.callbackType * 31;
        ScanResult scanResult = this.result;
        return i + (scanResult != null ? scanResult.hashCode() : 0);
    }

    public String toString() {
        return "RxScanResult(callbackType=" + this.callbackType + ", result=" + this.result + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxScanResult(int i, ScanResult scanResult) {
        super(null);
        Intrinsics.checkNotNullParameter(scanResult, "result");
        this.callbackType = i;
        this.result = scanResult;
    }

    public final int getCallbackType() {
        return this.callbackType;
    }

    public final ScanResult getResult() {
        return this.result;
    }
}
