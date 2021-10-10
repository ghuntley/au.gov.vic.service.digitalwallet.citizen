package com.digitalwallet.app.services;

import com.digitalwallet.app.model.ServiceVicError;
import com.digitalwallet.app.model.db.scan.Scan;
import com.digitalwallet.app.model.db.scan.ScanDao;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "scan", "Lcom/digitalwallet/app/model/db/scan/Scan;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerDataService.kt */
public final class ScannerDataService$retryCachedScans$3<T, R> implements Function<Scan, CompletableSource> {
    final /* synthetic */ ScannerDataService this$0;

    ScannerDataService$retryCachedScans$3(ScannerDataService scannerDataService) {
        this.this$0 = scannerDataService;
    }

    public final CompletableSource apply(final Scan scan) {
        Intrinsics.checkNotNullParameter(scan, "scan");
        return this.this$0.holdingsApi.postEligibilityScan(scan.getComposite()).onErrorResumeNext(new ScannerDataService$sam$io_reactivex_functions_Function$0(new Function1<Throwable, Completable>(this.this$0) {
            /* class com.digitalwallet.app.services.ScannerDataService$retryCachedScans$3.AnonymousClass1 */

            public final Completable invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "p1");
                return ((ScannerDataService) this.receiver).handleScannerError(th);
            }
        })).doOnError(new Consumer<Throwable>(this) {
            /* class com.digitalwallet.app.services.ScannerDataService$retryCachedScans$3.AnonymousClass2 */
            final /* synthetic */ ScannerDataService$retryCachedScans$3 this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                if (th instanceof ServiceVicError) {
                    ScanDao scanDao = this.this$0.this$0.scanDao;
                    Scan scan = scan;
                    Intrinsics.checkNotNullExpressionValue(scan, "scan");
                    scanDao.delete(scan);
                }
            }
        }).doOnComplete(new Action(this) {
            /* class com.digitalwallet.app.services.ScannerDataService$retryCachedScans$3.AnonymousClass3 */
            final /* synthetic */ ScannerDataService$retryCachedScans$3 this$0;

            {
                this.this$0 = r1;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                ScanDao scanDao = this.this$0.this$0.scanDao;
                Scan scan = scan;
                Intrinsics.checkNotNullExpressionValue(scan, "scan");
                scanDao.delete(scan);
            }
        });
    }
}
