package com.digitalwallet.viewmodel.checkIn;

import com.google.android.gms.vision.barcode.Barcode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "barcode", "Lcom/google/android/gms/vision/barcode/Barcode;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInScannerViewModel.kt */
public final class CheckInScannerViewModel$barcodeValidator$1 extends Lambda implements Function1<Barcode, Boolean> {
    final /* synthetic */ CheckInScannerViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInScannerViewModel$barcodeValidator$1(CheckInScannerViewModel checkInScannerViewModel) {
        super(1);
        this.this$0 = checkInScannerViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Barcode barcode) {
        return Boolean.valueOf(invoke(barcode));
    }

    public final boolean invoke(Barcode barcode) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        CheckInScannerViewModel checkInScannerViewModel = this.this$0;
        String str = barcode.rawValue;
        Intrinsics.checkNotNullExpressionValue(str, "barcode.rawValue");
        CheckInScannerViewModel.validateBarcode$default(checkInScannerViewModel, str, false, 2, null);
        return false;
    }
}
