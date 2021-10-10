package com.digitalwallet.services;

import com.google.android.gms.vision.CameraSource;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "onPictureTaken"}, k = 3, mv = {1, 4, 0})
/* compiled from: ScannerViewService.kt */
final class ScannerViewService$receiveDetections$1 implements CameraSource.PictureCallback {
    final /* synthetic */ boolean $stop;
    final /* synthetic */ ScannerViewService this$0;

    ScannerViewService$receiveDetections$1(ScannerViewService scannerViewService, boolean z) {
        this.this$0 = scannerViewService;
        this.$stop = z;
    }

    @Override // com.google.android.gms.vision.CameraSource.PictureCallback
    public final void onPictureTaken(byte[] bArr) {
        CameraSource cameraSource;
        if (this.$stop && (cameraSource = this.this$0.currentCamera) != null) {
            cameraSource.stop();
        }
    }
}
