package com.digitalwallet.app.viewmodel.pin;

import com.digitalwallet.app.viewmodel.pin.FingerprintState;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: FingerprintDialogFragmentViewModel.kt */
public final class FingerprintDialogFragmentViewModel$triggerMessageReset$1 implements Runnable {
    final /* synthetic */ FingerprintDialogFragmentViewModel this$0;

    FingerprintDialogFragmentViewModel$triggerMessageReset$1(FingerprintDialogFragmentViewModel fingerprintDialogFragmentViewModel) {
        this.this$0 = fingerprintDialogFragmentViewModel;
    }

    public final void run() {
        this.this$0.getViewState().set(FingerprintState.Default.INSTANCE);
    }
}
