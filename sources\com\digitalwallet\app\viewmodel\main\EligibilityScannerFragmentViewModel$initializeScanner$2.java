package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.db.scan.Scan;
import com.digitalwallet.app.services.ScannerDataService;
import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "p1", "Lcom/digitalwallet/app/model/db/scan/Scan;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragmentViewModel.kt */
final /* synthetic */ class EligibilityScannerFragmentViewModel$initializeScanner$2 extends FunctionReferenceImpl implements Function1<Scan, Completable> {
    EligibilityScannerFragmentViewModel$initializeScanner$2(ScannerDataService scannerDataService) {
        super(1, scannerDataService, ScannerDataService.class, "postNewScan", "postNewScan(Lcom/digitalwallet/app/model/db/scan/Scan;)Lio/reactivex/Completable;", 0);
    }

    public final Completable invoke(Scan scan) {
        Intrinsics.checkNotNullParameter(scan, "p1");
        return ((ScannerDataService) this.receiver).postNewScan(scan);
    }
}
