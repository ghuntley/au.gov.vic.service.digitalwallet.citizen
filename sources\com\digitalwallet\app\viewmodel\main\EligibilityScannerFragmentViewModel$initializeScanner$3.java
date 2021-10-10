package com.digitalwallet.app.viewmodel.main;

import android.view.SurfaceView;
import io.reactivex.functions.Action;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragmentViewModel.kt */
final class EligibilityScannerFragmentViewModel$initializeScanner$3 implements Action {
    final /* synthetic */ SurfaceView $cameraView;
    final /* synthetic */ EligibilityScannerFragmentViewModel this$0;

    EligibilityScannerFragmentViewModel$initializeScanner$3(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel, SurfaceView surfaceView) {
        this.this$0 = eligibilityScannerFragmentViewModel;
        this.$cameraView = surfaceView;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.releaseResources(this.$cameraView);
    }
}
