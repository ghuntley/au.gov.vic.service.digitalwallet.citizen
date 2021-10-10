package com.digitalwallet.app.services;

import com.digitalwallet.app.api.HoldingsApi;
import com.digitalwallet.app.model.ServiceVicError;
import com.digitalwallet.app.model.db.scan.Scan;
import com.digitalwallet.app.model.db.scan.ScanDao;
import com.squareup.moshi.Moshi;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/digitalwallet/app/services/ScannerDataService;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "holdingsApi", "Lcom/digitalwallet/app/api/HoldingsApi;", "scanDao", "Lcom/digitalwallet/app/model/db/scan/ScanDao;", "(Lcom/squareup/moshi/Moshi;Lcom/digitalwallet/app/api/HoldingsApi;Lcom/digitalwallet/app/model/db/scan/ScanDao;)V", "handleScannerError", "Lio/reactivex/Completable;", "exception", "", "postNewScan", "scan", "Lcom/digitalwallet/app/model/db/scan/Scan;", "retryCachedScans", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScannerDataService.kt */
public final class ScannerDataService {
    private final HoldingsApi holdingsApi;
    private final Moshi moshi;
    private final ScanDao scanDao;

    @Inject
    public ScannerDataService(Moshi moshi2, HoldingsApi holdingsApi2, ScanDao scanDao2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(holdingsApi2, "holdingsApi");
        Intrinsics.checkNotNullParameter(scanDao2, "scanDao");
        this.moshi = moshi2;
        this.holdingsApi = holdingsApi2;
        this.scanDao = scanDao2;
    }

    public final Completable postNewScan(Scan scan) {
        Intrinsics.checkNotNullParameter(scan, "scan");
        this.scanDao.insert(scan);
        Completable doOnComplete = this.holdingsApi.postEligibilityScan(scan.getComposite()).subscribeOn(Schedulers.io()).onErrorResumeNext(new ScannerDataService$sam$io_reactivex_functions_Function$0(new ScannerDataService$postNewScan$1(this))).observeOn(Schedulers.io()).doOnError(new ScannerDataService$postNewScan$2(this, scan)).doOnComplete(new ScannerDataService$postNewScan$3(this, scan));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "holdingsApi.postEligibil… { scanDao.delete(scan) }");
        return doOnComplete;
    }

    public final Completable retryCachedScans() {
        Completable concatMapCompletableDelayError = Single.fromCallable(new ScannerDataService$retryCachedScans$1(this)).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).flatMapObservable(ScannerDataService$retryCachedScans$2.INSTANCE).concatMapCompletableDelayError(new ScannerDataService$retryCachedScans$3(this));
        Intrinsics.checkNotNullExpressionValue(concatMapCompletableDelayError, "Single.fromCallable { sc…ete(scan) }\n            }");
        return concatMapCompletableDelayError;
    }

    /* access modifiers changed from: private */
    public final Completable handleScannerError(Throwable th) {
        HttpException httpException;
        HttpException httpException2 = null;
        HttpException httpException3 = (HttpException) (!(th instanceof HttpException) ? null : th);
        if (httpException3 != null) {
            int code = httpException3.code();
            if (300 <= code && 499 >= code) {
                httpException2 = httpException3;
            }
            if (httpException2 != null) {
                try {
                    httpException = ServiceVicError.Companion.attemptConversion(this.moshi, httpException2);
                } catch (Exception unused) {
                    httpException = httpException2;
                }
                if (httpException != null) {
                    th = httpException;
                }
            }
        }
        Completable error = Completable.error(th);
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(errorToReturn)");
        return error;
    }
}
