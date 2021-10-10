package com.digitalwallet.app.viewmodel.main;

import com.digitalwallet.app.model.db.scan.Scan;
import com.google.android.gms.vision.barcode.Barcode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/vision/barcode/Barcode;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragmentViewModel.kt */
public final class EligibilityScannerFragmentViewModel$barcodeValidator$1 extends Lambda implements Function1<Barcode, Boolean> {
    final /* synthetic */ EligibilityScannerFragmentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EligibilityScannerFragmentViewModel$barcodeValidator$1(EligibilityScannerFragmentViewModel eligibilityScannerFragmentViewModel) {
        super(1);
        this.this$0 = eligibilityScannerFragmentViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Barcode barcode) {
        return Boolean.valueOf(invoke(barcode));
    }

    public final boolean invoke(Barcode barcode) {
        Intrinsics.checkNotNullParameter(barcode, "it");
        this.this$0.getScanEmitter().onNext(Scan.Companion.from(barcode));
        return true;
    }
}
