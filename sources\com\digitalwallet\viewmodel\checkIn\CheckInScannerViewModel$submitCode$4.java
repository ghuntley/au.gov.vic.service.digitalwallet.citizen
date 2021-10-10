package com.digitalwallet.viewmodel.checkIn;

import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.viewmodel.checkIn.CheckInScannerViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "t", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInScannerViewModel.kt */
public final class CheckInScannerViewModel$submitCode$4<T> implements Consumer<Throwable> {
    final /* synthetic */ CheckInScannerViewModel this$0;

    CheckInScannerViewModel$submitCode$4(CheckInScannerViewModel checkInScannerViewModel) {
        this.this$0 = checkInScannerViewModel;
    }

    public final void accept(Throwable th) {
        if (th instanceof CheckInScannerViewModel.InvalidRedirect) {
            ActionEventKt.post(this.this$0.getShowManualCodeInvalidMessage());
            AnalyticsHelper.selectContent$default(this.this$0.analytics, "Check in - Manual entry invalid", null, 2, null);
        } else {
            ActionEventKt.post(this.this$0.getShowManualCodeErrorMessage());
            AnalyticsHelper.selectContent$default(this.this$0.analytics, "Check in - Manual entry failed", null, 2, null);
        }
        this.this$0.resumeScanWithDelay();
        Timber.e(th);
    }
}
