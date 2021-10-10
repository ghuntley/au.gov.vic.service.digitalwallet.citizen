package com.digitalwallet.app.view.main;

import android.bluetooth.le.ScanResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/digitalwallet/app/view/main/RxBatchScanResult;", "Lcom/digitalwallet/app/view/main/RxBLEScanResult;", "results", "", "Landroid/bluetooth/le/ScanResult;", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: RxBLEScanner.kt */
public final class RxBatchScanResult extends RxBLEScanResult {
    private final List<ScanResult> results;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.digitalwallet.app.view.main.RxBatchScanResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RxBatchScanResult copy$default(RxBatchScanResult rxBatchScanResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rxBatchScanResult.results;
        }
        return rxBatchScanResult.copy(list);
    }

    public final List<ScanResult> component1() {
        return this.results;
    }

    public final RxBatchScanResult copy(List<ScanResult> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        return new RxBatchScanResult(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RxBatchScanResult) && Intrinsics.areEqual(this.results, ((RxBatchScanResult) obj).results);
        }
        return true;
    }

    public int hashCode() {
        List<ScanResult> list = this.results;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RxBatchScanResult(results=" + this.results + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxBatchScanResult(List<ScanResult> list) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "results");
        this.results = list;
    }

    public final List<ScanResult> getResults() {
        return this.results;
    }
}
