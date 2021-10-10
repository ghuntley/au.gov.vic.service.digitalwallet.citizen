package com.digitalwallet.viewmodel.main;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceView;
import androidx.core.content.ContextCompat;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.vision.barcode.Barcode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0004J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/digitalwallet/viewmodel/main/ScannerFragmentViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "viewService", "Lcom/digitalwallet/services/ScannerViewService;", "(Lcom/digitalwallet/services/ScannerViewService;)V", "barcodeFormats", "", "getBarcodeFormats", "()I", "barcodeValidator", "Lkotlin/Function1;", "Lcom/google/android/gms/vision/barcode/Barcode;", "", "getBarcodeValidator", "()Lkotlin/jvm/functions/Function1;", "cameraPermissionGranted", "context", "Landroid/content/Context;", "initializeScanner", "", "cameraView", "Landroid/view/SurfaceView;", "releaseResources", "setScannerArea", "frame", "Landroid/graphics/Rect;", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: ScannerFragmentViewModel.kt */
public abstract class ScannerFragmentViewModel extends BaseViewModel {
    private final ScannerViewService viewService;

    public abstract int getBarcodeFormats();

    public abstract Function1<Barcode, Boolean> getBarcodeValidator();

    public ScannerFragmentViewModel(ScannerViewService scannerViewService) {
        Intrinsics.checkNotNullParameter(scannerViewService, "viewService");
        this.viewService = scannerViewService;
    }

    public void initializeScanner(SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(surfaceView, "cameraView");
        this.viewService.setup(getBarcodeValidator(), getBarcodeFormats());
        surfaceView.getHolder().addCallback(this.viewService);
    }

    public final void setScannerArea(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "frame");
        this.viewService.setScannerArea(rect);
    }

    public final boolean cameraPermissionGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    /* access modifiers changed from: protected */
    public final void releaseResources(SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(surfaceView, "cameraView");
        surfaceView.getHolder().removeCallback(this.viewService);
        this.viewService.stop();
        getCompositeDisposable().clear();
    }
}
