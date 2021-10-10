package com.digitalwallet.viewmodel.checkIn;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.widget.Toast;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.utilities.ActionEvent;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.view.util.SpannableTextKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import com.digitalwallet.viewmodel.main.ScannerFragmentViewModel;
import com.google.android.gms.vision.barcode.Barcode;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.ResponseTypeValues;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001GB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010:\u001a\u00020\u0010J\u0006\u0010;\u001a\u00020\u0010J\u0006\u0010<\u001a\u00020\u0010J\u0006\u0010=\u001a\u00020\u0010J\u0006\u0010>\u001a\u00020\u0010J\b\u0010?\u001a\u00020\u0010H\u0002J\u000e\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020B2\b\b\u0002\u0010F\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R'\u0010\r\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u001b0\u001b0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R'\u0010+\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u000f0\u000ej\b\u0012\u0004\u0012\u00020,`\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0013R'\u0010.\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R'\u00100\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0013R'\u00102\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0013R'\u00104\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0013R'\u00106\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0013R'\u00108\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u0010`\u0011¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel;", "Lcom/digitalwallet/viewmodel/main/ScannerFragmentViewModel;", "viewService", "Lcom/digitalwallet/services/ScannerViewService;", "moshi", "Lcom/squareup/moshi/Moshi;", "okHttpClient", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "analytics", "Lcom/digitalwallet/utilities/AnalyticsHelper;", "(Lcom/digitalwallet/services/ScannerViewService;Lcom/squareup/moshi/Moshi;Lokhttp3/OkHttpClient;Landroid/content/Context;Lcom/digitalwallet/utilities/AnalyticsHelper;)V", "backToPreviousScreen", "Landroidx/lifecycle/MutableLiveData;", "Lcom/digitalwallet/utilities/ActionEvent;", "", "Lcom/digitalwallet/utilities/MutableLiveEvent;", "getBackToPreviousScreen", "()Landroidx/lifecycle/MutableLiveData;", "barcodeFormats", "", "getBarcodeFormats", "()I", "barcodeValidator", "Lkotlin/Function1;", "Lcom/google/android/gms/vision/barcode/Barcode;", "", "getBarcodeValidator", "()Lkotlin/jvm/functions/Function1;", "lightOn", "Landroidx/databinding/ObservableBoolean;", "getLightOn", "()Landroidx/databinding/ObservableBoolean;", "loadingSpinnerVisible", "Landroidx/databinding/ObservableField;", "kotlin.jvm.PlatformType", "getLoadingSpinnerVisible", "()Landroidx/databinding/ObservableField;", "manualInputButtonText", "Landroid/text/SpannableStringBuilder;", "getManualInputButtonText", "()Landroid/text/SpannableStringBuilder;", "navigateToCheckIn", "Lcom/digitalwallet/viewmodel/checkIn/CheckInUtils$CheckInCode;", "getNavigateToCheckIn", "navigateToHelpUrl", "getNavigateToHelpUrl", "showManualCodeEmptyMessage", "getShowManualCodeEmptyMessage", "showManualCodeErrorMessage", "getShowManualCodeErrorMessage", "showManualCodeInvalidMessage", "getShowManualCodeInvalidMessage", "showManualEntry", "getShowManualEntry", "showQRCodeInvalidMessage", "getShowQRCodeInvalidMessage", "onClose", "onHelp", "onManualEntry", "pauseScan", "resumeScan", "resumeScanWithDelay", "submitCode", ResponseTypeValues.CODE, "", "toggleTorch", "validateBarcode", "it", "manual", "InvalidRedirect", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: CheckInScannerViewModel.kt */
public final class CheckInScannerViewModel extends ScannerFragmentViewModel {
    private final AnalyticsHelper analytics;
    private final MutableLiveData<ActionEvent<Unit>> backToPreviousScreen = new MutableLiveData<>();
    private final int barcodeFormats;
    private final Function1<Barcode, Boolean> barcodeValidator;
    private final Context context;
    private final ObservableBoolean lightOn = new ObservableBoolean(false);
    private final ObservableField<Boolean> loadingSpinnerVisible = new ObservableField<>((Boolean) false);
    private final SpannableStringBuilder manualInputButtonText;
    private final Moshi moshi;
    private final MutableLiveData<ActionEvent<CheckInUtils.CheckInCode>> navigateToCheckIn = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> navigateToHelpUrl = new MutableLiveData<>();
    private final OkHttpClient okHttpClient;
    private final MutableLiveData<ActionEvent<Unit>> showManualCodeEmptyMessage = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> showManualCodeErrorMessage = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> showManualCodeInvalidMessage = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> showManualEntry = new MutableLiveData<>();
    private final MutableLiveData<ActionEvent<Unit>> showQRCodeInvalidMessage = new MutableLiveData<>();
    private final ScannerViewService viewService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CheckInScannerViewModel(ScannerViewService scannerViewService, Moshi moshi2, @Named("NoInterceptor") OkHttpClient okHttpClient2, Context context2, AnalyticsHelper analyticsHelper) {
        super(scannerViewService);
        Intrinsics.checkNotNullParameter(scannerViewService, "viewService");
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        Intrinsics.checkNotNullParameter(okHttpClient2, "okHttpClient");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(analyticsHelper, "analytics");
        this.viewService = scannerViewService;
        this.moshi = moshi2;
        this.okHttpClient = okHttpClient2;
        this.context = context2;
        this.analytics = analyticsHelper;
        this.manualInputButtonText = SpannableTextKt.getDWStyleSpannableStringBuilder(context2, R.string.check_in_manual_code_button, R.string.check_in_manually, CheckInScannerViewModel$manualInputButtonText$1.INSTANCE);
        this.barcodeFormats = 256;
        this.barcodeValidator = new CheckInScannerViewModel$barcodeValidator$1(this);
    }

    public final MutableLiveData<ActionEvent<Unit>> getNavigateToHelpUrl() {
        return this.navigateToHelpUrl;
    }

    public final MutableLiveData<ActionEvent<Unit>> getBackToPreviousScreen() {
        return this.backToPreviousScreen;
    }

    public final MutableLiveData<ActionEvent<CheckInUtils.CheckInCode>> getNavigateToCheckIn() {
        return this.navigateToCheckIn;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowQRCodeInvalidMessage() {
        return this.showQRCodeInvalidMessage;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowManualEntry() {
        return this.showManualEntry;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowManualCodeEmptyMessage() {
        return this.showManualCodeEmptyMessage;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowManualCodeInvalidMessage() {
        return this.showManualCodeInvalidMessage;
    }

    public final MutableLiveData<ActionEvent<Unit>> getShowManualCodeErrorMessage() {
        return this.showManualCodeErrorMessage;
    }

    public final ObservableBoolean getLightOn() {
        return this.lightOn;
    }

    public final ObservableField<Boolean> getLoadingSpinnerVisible() {
        return this.loadingSpinnerVisible;
    }

    public final SpannableStringBuilder getManualInputButtonText() {
        return this.manualInputButtonText;
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public int getBarcodeFormats() {
        return this.barcodeFormats;
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public Function1<Barcode, Boolean> getBarcodeValidator() {
        return this.barcodeValidator;
    }

    public final void onHelp() {
        ActionEventKt.post(this.navigateToHelpUrl);
    }

    public final void toggleTorch(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        boolean z = !this.lightOn.get();
        if (this.viewService.setTorch(z)) {
            this.lightOn.set(z);
        } else {
            Toast.makeText(context2, (int) R.string.torch_not_available_RES_2131689751, 0).show();
        }
    }

    public final void onManualEntry() {
        ActionEventKt.post(this.showManualEntry);
        AnalyticsHelper.selectContent$default(this.analytics, "Check in - Manual entry button pressed", null, 2, null);
    }

    public final void onClose() {
        ActionEventKt.post(this.backToPreviousScreen);
    }

    public final void resumeScan() {
        this.viewService.unpause();
    }

    public final void pauseScan() {
        this.viewService.pause();
    }

    static /* synthetic */ void validateBarcode$default(CheckInScannerViewModel checkInScannerViewModel, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        checkInScannerViewModel.validateBarcode(str, z);
    }

    /* access modifiers changed from: private */
    public final void validateBarcode(String str, boolean z) {
        pauseScan();
        CheckInUtils.CheckInCode parseUrl = CheckInUtils.Companion.parseUrl(this.context, this.moshi, str);
        if (parseUrl != null) {
            if (z) {
                AnalyticsHelper.selectContent$default(this.analytics, "Check in - Manual entry success", null, 2, null);
            }
            ActionEventKt.postEvent(this.navigateToCheckIn, parseUrl);
            return;
        }
        CheckInScannerViewModel checkInScannerViewModel = this;
        if (z) {
            ActionEventKt.post(checkInScannerViewModel.showManualCodeInvalidMessage);
            AnalyticsHelper.selectContent$default(checkInScannerViewModel.analytics, "Check in - Manual entry invalid", null, 2, null);
            return;
        }
        ActionEventKt.post(checkInScannerViewModel.showQRCodeInvalidMessage);
        AnalyticsHelper.selectContent$default(checkInScannerViewModel.analytics, "Check in - Invalid QR code scan", null, 2, null);
    }

    /* access modifiers changed from: private */
    public final void resumeScanWithDelay() {
        new Handler(Looper.getMainLooper()).postDelayed(new CheckInScannerViewModel$resumeScanWithDelay$1(this), 500);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/digitalwallet/viewmodel/checkIn/CheckInScannerViewModel$InvalidRedirect;", "Ljava/lang/Error;", "Lkotlin/Error;", "()V", "base_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
    /* compiled from: CheckInScannerViewModel.kt */
    public static final class InvalidRedirect extends Error {
        public InvalidRedirect() {
            super("Invalid Redirect");
        }
    }

    public final void submitCode(String str) {
        Intrinsics.checkNotNullParameter(str, ResponseTypeValues.CODE);
        if (StringsKt.isBlank(str)) {
            ActionEventKt.post(this.showManualCodeEmptyMessage);
            resumeScanWithDelay();
            return;
        }
        HttpUrl parse = HttpUrl.parse("https://go.vic.gov.au/" + str);
        if (parse != null) {
            Intrinsics.checkNotNullExpressionValue(parse, "HttpUrl.parse(\"https://g…         return\n        }");
            this.loadingSpinnerVisible.set(true);
            getCompositeDisposable().add(Single.create(new CheckInScannerViewModel$submitCode$1(this, parse)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new CheckInScannerViewModel$submitCode$2(this)).subscribe(new CheckInScannerViewModel$submitCode$3(this), new CheckInScannerViewModel$submitCode$4(this)));
            return;
        }
        CheckInScannerViewModel checkInScannerViewModel = this;
        ActionEventKt.post(checkInScannerViewModel.showManualCodeInvalidMessage);
        AnalyticsHelper.selectContent$default(checkInScannerViewModel.analytics, "Check in - Manual entry failed", null, 2, null);
        checkInScannerViewModel.resumeScanWithDelay();
    }
}
