package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.ServiceVicError;
import com.digitalwallet.app.view.util.ScannerViewState;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragmentViewModel.kt */
final class EligibilityScannerFragmentViewModel$initializeScanner$5<T> implements Consumer<Throwable> {
    final /* synthetic */ EligibilityScannerFragmentViewModel this$0;

    EligibilityScannerFragmentViewModel$initializeScanner$5(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel) {
        this.this$0 = eligibilityScannerFragmentViewModel;
    }

    public final void accept(Throwable th) {
        if (th instanceof ServiceVicError) {
            this.this$0.getCustomErrorText().setValue(((ServiceVicError) th).getMessage());
            this.this$0.getViewState().set(ScannerViewState.INVALID);
            return;
        }
        Timber.e(th);
        this.this$0.getViewState().set(ScannerViewState.ERROR);
    }
}
