package com.digitalwallet.app.viewmodel.main;

import android.view.SurfaceView;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.digitalwallet.app.model.db.scan.Scan;
import com.digitalwallet.app.services.ScannerDataService;
import com.digitalwallet.app.view.util.ScannerViewState;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.viewmodel.main.ScannerFragmentViewModel;
import com.google.android.gms.vision.barcode.Barcode;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020$R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u001d0\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001f\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/digitalwallet/app/viewmodel/main/EligibilityScannerFragmentViewModel;", "Lcom/digitalwallet/viewmodel/main/ScannerFragmentViewModel;", "viewService", "Lcom/digitalwallet/services/ScannerViewService;", "dataService", "Lcom/digitalwallet/app/services/ScannerDataService;", "(Lcom/digitalwallet/services/ScannerViewService;Lcom/digitalwallet/app/services/ScannerDataService;)V", "barcodeFormats", "", "getBarcodeFormats", "()I", "barcodeValidator", "Lkotlin/Function1;", "Lcom/google/android/gms/vision/barcode/Barcode;", "", "getBarcodeValidator", "()Lkotlin/jvm/functions/Function1;", "clickEmitter", "Lio/reactivex/subjects/PublishSubject;", "Lcom/digitalwallet/app/view/util/ScannerViewState;", "kotlin.jvm.PlatformType", "getClickEmitter", "()Lio/reactivex/subjects/PublishSubject;", "customErrorText", "Landroidx/lifecycle/MutableLiveData;", "", "getCustomErrorText", "()Landroidx/lifecycle/MutableLiveData;", "scanEmitter", "Lcom/digitalwallet/app/model/db/scan/Scan;", "getScanEmitter", "viewState", "Landroidx/databinding/ObservableField;", "getViewState", "()Landroidx/databinding/ObservableField;", "initializeScanner", "", "cameraView", "Landroid/view/SurfaceView;", "performAction", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: EligibilityScannerFragmentViewModel.kt */
public final class EligibilityScannerFragmentViewModel extends ScannerFragmentViewModel {
    private final int barcodeFormats = 256;
    private final Function1<Barcode, Boolean> barcodeValidator;
    private final PublishSubject<ScannerViewState> clickEmitter;
    private final MutableLiveData<String> customErrorText;
    private final ScannerDataService dataService;
    private final PublishSubject<Scan> scanEmitter;
    private final ObservableField<ScannerViewState> viewState = new ObservableField<>(ScannerViewState.SCANNING);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public EligibilityScannerFragmentViewModel(ScannerViewService scannerViewService, ScannerDataService scannerDataService) {
        super(scannerViewService);
        Intrinsics.checkNotNullParameter(scannerViewService, "viewService");
        Intrinsics.checkNotNullParameter(scannerDataService, "dataService");
        this.dataService = scannerDataService;
        PublishSubject<ScannerViewState> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create<ScannerViewState>()");
        this.clickEmitter = create;
        this.customErrorText = new MutableLiveData<>();
        PublishSubject<Scan> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishSubject.create<Scan>()");
        this.scanEmitter = create2;
        this.barcodeValidator = new EligibilityScannerFragmentViewModel$barcodeValidator$1(this);
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public int getBarcodeFormats() {
        return this.barcodeFormats;
    }

    public final ObservableField<ScannerViewState> getViewState() {
        return this.viewState;
    }

    public final PublishSubject<ScannerViewState> getClickEmitter() {
        return this.clickEmitter;
    }

    public final MutableLiveData<String> getCustomErrorText() {
        return this.customErrorText;
    }

    public final PublishSubject<Scan> getScanEmitter() {
        return this.scanEmitter;
    }

    public final void performAction() {
        PublishSubject<ScannerViewState> publishSubject = this.clickEmitter;
        ScannerViewState scannerViewState = this.viewState.get();
        Objects.requireNonNull(scannerViewState, "null cannot be cast to non-null type com.digitalwallet.app.view.util.ScannerViewState");
        publishSubject.onNext(scannerViewState);
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public Function1<Barcode, Boolean> getBarcodeValidator() {
        return this.barcodeValidator;
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public void initializeScanner(SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(surfaceView, "cameraView");
        super.initializeScanner(surfaceView);
        getCompositeDisposable().add(this.scanEmitter.subscribeOn(Schedulers.io()).firstOrError().doOnSuccess(new EligibilityScannerFragmentViewModel$initializeScanner$1(this)).flatMapCompletable(new EligibilityScannerFragmentViewModel$sam$io_reactivex_functions_Function$0(new EligibilityScannerFragmentViewModel$initializeScanner$2(this.dataService))).doOnDispose(new EligibilityScannerFragmentViewModel$initializeScanner$3(this, surfaceView)).observeOn(AndroidSchedulers.mainThread()).subscribe(new EligibilityScannerFragmentViewModel$initializeScanner$4(this), new EligibilityScannerFragmentViewModel$initializeScanner$5(this)));
    }
}
