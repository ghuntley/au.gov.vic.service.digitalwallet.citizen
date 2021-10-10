package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.scan.Scan;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerDataService.kt */
public final class ScannerDataService$postNewScan$3 implements Action {
    final /* synthetic */ Scan $scan;
    final /* synthetic */ ScannerDataService this$0;

    ScannerDataService$postNewScan$3(ScannerDataService scannerDataService, Scan scan) {
        this.this$0 = scannerDataService;
        this.$scan = scan;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.scanDao.delete(this.$scan);
    }
}
