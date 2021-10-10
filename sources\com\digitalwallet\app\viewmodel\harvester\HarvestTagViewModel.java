package com.digitalwallet.app.viewmodel.harvester;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.app.view.harvester.HarvestTagView;
import com.digitalwallet.app.view.util.ClickMute;
import com.digitalwallet.services.ScannerViewService;
import com.digitalwallet.viewmodel.main.ScannerFragmentViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.vision.barcode.Barcode;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010U\u001a\u00020VJ\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0010H\u0002J\u0006\u0010X\u001a\u00020VJ\u0006\u0010Y\u001a\u00020VJ\u0017\u0010Z\u001a\u0004\u0018\u00010\u00102\u0006\u0010W\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010[J\b\u0010\\\u001a\u00020VH\u0002J\u0006\u0010]\u001a\u00020VJ\u0006\u0010^\u001a\u00020VJ\u0006\u0010_\u001a\u00020VJ\u0006\u0010`\u001a\u00020VJ\u0016\u0010a\u001a\u00020V2\u0006\u0010S\u001a\u00020T2\u0006\u0010-\u001a\u00020\u0010J\u0006\u0010b\u001a\u00020VJ\u0006\u0010c\u001a\u00020VR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\rR\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\rR\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\rR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\rR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\rR\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\rR\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\rR \u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010'R \u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010'R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\rR \u0010I\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n0JX\u0004¢\u0006\u0004\n\u0002\u0010KR \u0010L\u001a\b\u0012\u0004\u0012\u00020\u001d0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\r\"\u0004\bN\u0010'R\u0011\u0010O\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\bP\u00106R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00150\n¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\rR\u000e\u0010S\u001a\u00020TX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HarvestTagViewModel;", "Lcom/digitalwallet/viewmodel/main/ScannerFragmentViewModel;", "model", "Lcom/digitalwallet/app/model/db/harvester/HarvestModel;", "viewService", "Lcom/digitalwallet/services/ScannerViewService;", "harvestDataService", "Lcom/digitalwallet/app/services/HarvestDataService;", "(Lcom/digitalwallet/app/model/db/harvester/HarvestModel;Lcom/digitalwallet/services/ScannerViewService;Lcom/digitalwallet/app/services/HarvestDataService;)V", AuthorizationRequest.Scope.ADDRESS, "Landroidx/databinding/ObservableField;", "", "getAddress", "()Landroidx/databinding/ObservableField;", "barcodeAdded", "Lcom/jakewharton/rxrelay2/PublishRelay;", "", "kotlin.jvm.PlatformType", "getBarcodeAdded", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "barcodeFormats", "", "getBarcodeFormats", "()I", "barcodeNumber", "getBarcodeNumber", "barcodeValidator", "Lkotlin/Function1;", "Lcom/google/android/gms/vision/barcode/Barcode;", "", "getBarcodeValidator", "()Lkotlin/jvm/functions/Function1;", "barcodes", "", "clickMute", "Lcom/digitalwallet/app/view/util/ClickMute;", "comments", "getComments", "setComments", "(Landroidx/databinding/ObservableField;)V", "dateOfHarvest", "Ljava/util/Date;", "getDateOfHarvest", "job", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "jobId", "Ljava/lang/Long;", "landholderContactNumber", "getLandholderContactNumber", "landholderName", "getLandholderName", "lightOn", "Landroidx/databinding/ObservableBoolean;", "getLightOn", "()Landroidx/databinding/ObservableBoolean;", "numOfEasternGreys", "getNumOfEasternGreys", "numOfFemales", "getNumOfFemales", "numOfReds", "getNumOfReds", "numOfWesternGreys", "getNumOfWesternGreys", "numPouchYoungDestroyed", "getNumPouchYoungDestroyed", "numTaggedCarcassesLeftOnProperty", "getNumTaggedCarcassesLeftOnProperty", "setNumTaggedCarcassesLeftOnProperty", "numTaggedCarcassesStoredForProcessor", "getNumTaggedCarcassesStoredForProcessor", "setNumTaggedCarcassesStoredForProcessor", "numYoungAtFootDestroyed", "getNumYoungAtFootDestroyed", "startNullFields", "", "[Landroidx/databinding/ObservableField;", "summaryFilled", "getSummaryFilled", "setSummaryFilled", "summaryStarted", "getSummaryStarted", "tagCount", "getTagCount", Promotion.ACTION_VIEW, "Lcom/digitalwallet/app/view/harvester/HarvestTagView;", "addBarcode", "", "it", "backToScanner", "closeScanner", "convertBarcode", "(Ljava/lang/String;)Ljava/lang/Long;", "doCloseScanner", "goBackFromScanner", "manualEntry", "pauseScan", "resumeScan", "setup", "submitSummary", "toggleTorch", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestTagViewModel.kt */
public final class HarvestTagViewModel extends ScannerFragmentViewModel {
    private final ObservableField<String> address;
    private final PublishRelay<Long> barcodeAdded;
    private final int barcodeFormats = 1;
    private final ObservableField<String> barcodeNumber;
    private final Function1<Barcode, Boolean> barcodeValidator;
    private final List<Long> barcodes;
    private ClickMute clickMute = new ClickMute(500);
    private ObservableField<String> comments;
    private final ObservableField<Date> dateOfHarvest;
    private HarvestDataService harvestDataService;
    private SavedHarvestJob job;
    private Long jobId;
    private final ObservableField<String> landholderContactNumber;
    private final ObservableField<String> landholderName;
    private final ObservableBoolean lightOn;
    private HarvestModel model;
    private final ObservableField<String> numOfEasternGreys;
    private final ObservableField<String> numOfFemales;
    private final ObservableField<String> numOfReds;
    private final ObservableField<String> numOfWesternGreys;
    private final ObservableField<String> numPouchYoungDestroyed;
    private ObservableField<String> numTaggedCarcassesLeftOnProperty;
    private ObservableField<String> numTaggedCarcassesStoredForProcessor;
    private final ObservableField<String> numYoungAtFootDestroyed;
    private final ObservableField<? extends String>[] startNullFields;
    private ObservableField<Boolean> summaryFilled;
    private final ObservableBoolean summaryStarted;
    private final ObservableField<Integer> tagCount;
    private HarvestTagView view;
    private ScannerViewService viewService;

    public static final /* synthetic */ HarvestTagView access$getView$p(HarvestTagViewModel harvestTagViewModel) {
        HarvestTagView harvestTagView = harvestTagViewModel.view;
        if (harvestTagView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        return harvestTagView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public HarvestTagViewModel(HarvestModel harvestModel, ScannerViewService scannerViewService, HarvestDataService harvestDataService2) {
        super(scannerViewService);
        Intrinsics.checkNotNullParameter(harvestModel, "model");
        Intrinsics.checkNotNullParameter(scannerViewService, "viewService");
        Intrinsics.checkNotNullParameter(harvestDataService2, "harvestDataService");
        this.model = harvestModel;
        this.viewService = scannerViewService;
        this.harvestDataService = harvestDataService2;
        ArrayList arrayList = new ArrayList();
        this.barcodes = arrayList;
        PublishRelay<Long> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<Long>()");
        this.barcodeAdded = create;
        this.summaryStarted = new ObservableBoolean(false);
        this.lightOn = new ObservableBoolean(false);
        this.landholderName = new ObservableField<>();
        this.landholderContactNumber = new ObservableField<>();
        this.address = new ObservableField<>();
        this.dateOfHarvest = new ObservableField<>(new Date());
        ObservableField<String> observableField = new ObservableField<>();
        this.numOfEasternGreys = observableField;
        ObservableField<String> observableField2 = new ObservableField<>();
        this.numOfWesternGreys = observableField2;
        ObservableField<String> observableField3 = new ObservableField<>();
        this.numOfReds = observableField3;
        ObservableField<String> observableField4 = new ObservableField<>();
        this.numOfFemales = observableField4;
        ObservableField<String> observableField5 = new ObservableField<>();
        this.numPouchYoungDestroyed = observableField5;
        ObservableField<String> observableField6 = new ObservableField<>();
        this.numYoungAtFootDestroyed = observableField6;
        this.numTaggedCarcassesLeftOnProperty = new ObservableField<>();
        this.numTaggedCarcassesStoredForProcessor = new ObservableField<>();
        ObservableField<String> observableField7 = new ObservableField<>();
        this.comments = observableField7;
        ObservableField<String> observableField8 = this.numTaggedCarcassesLeftOnProperty;
        ObservableField<String> observableField9 = this.numTaggedCarcassesStoredForProcessor;
        this.startNullFields = new ObservableField[]{observableField, observableField2, observableField3, observableField4, observableField5, observableField6, observableField8, observableField9, observableField7};
        this.summaryFilled = new HarvestTagViewModel$summaryFilled$1(this, new Observable[]{observableField, observableField2, observableField4, observableField5, observableField6, observableField8, observableField9});
        this.tagCount = new ObservableField<>(Integer.valueOf(arrayList.size()));
        this.barcodeNumber = new ObservableField<>("");
        getCompositeDisposable().add(create.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel.AnonymousClass1 */
            final /* synthetic */ HarvestTagViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Long l) {
                HarvestTagViewModel.access$getView$p(this.this$0).showTagSuccess(this.this$0.barcodes.size());
                this.this$0.getTagCount().set(Integer.valueOf(this.this$0.barcodes.size()));
            }
        }));
        this.barcodeValidator = new HarvestTagViewModel$barcodeValidator$1(this);
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public int getBarcodeFormats() {
        return this.barcodeFormats;
    }

    public final PublishRelay<Long> getBarcodeAdded() {
        return this.barcodeAdded;
    }

    public final ObservableBoolean getSummaryStarted() {
        return this.summaryStarted;
    }

    public final ObservableBoolean getLightOn() {
        return this.lightOn;
    }

    public final ObservableField<String> getLandholderName() {
        return this.landholderName;
    }

    public final ObservableField<String> getLandholderContactNumber() {
        return this.landholderContactNumber;
    }

    public final ObservableField<String> getAddress() {
        return this.address;
    }

    public final ObservableField<Date> getDateOfHarvest() {
        return this.dateOfHarvest;
    }

    public final ObservableField<String> getNumOfEasternGreys() {
        return this.numOfEasternGreys;
    }

    public final ObservableField<String> getNumOfWesternGreys() {
        return this.numOfWesternGreys;
    }

    public final ObservableField<String> getNumOfReds() {
        return this.numOfReds;
    }

    public final ObservableField<String> getNumOfFemales() {
        return this.numOfFemales;
    }

    public final ObservableField<String> getNumPouchYoungDestroyed() {
        return this.numPouchYoungDestroyed;
    }

    public final ObservableField<String> getNumYoungAtFootDestroyed() {
        return this.numYoungAtFootDestroyed;
    }

    public final ObservableField<String> getNumTaggedCarcassesLeftOnProperty() {
        return this.numTaggedCarcassesLeftOnProperty;
    }

    public final void setNumTaggedCarcassesLeftOnProperty(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.numTaggedCarcassesLeftOnProperty = observableField;
    }

    public final ObservableField<String> getNumTaggedCarcassesStoredForProcessor() {
        return this.numTaggedCarcassesStoredForProcessor;
    }

    public final void setNumTaggedCarcassesStoredForProcessor(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.numTaggedCarcassesStoredForProcessor = observableField;
    }

    public final ObservableField<String> getComments() {
        return this.comments;
    }

    public final void setComments(ObservableField<String> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.comments = observableField;
    }

    public final ObservableField<Boolean> getSummaryFilled() {
        return this.summaryFilled;
    }

    public final void setSummaryFilled(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.summaryFilled = observableField;
    }

    public final ObservableField<Integer> getTagCount() {
        return this.tagCount;
    }

    public final ObservableField<String> getBarcodeNumber() {
        return this.barcodeNumber;
    }

    public final void setup(HarvestTagView harvestTagView, long j) {
        Intrinsics.checkNotNullParameter(harvestTagView, Promotion.ACTION_VIEW);
        this.view = harvestTagView;
        this.jobId = Long.valueOf(j);
        this.summaryStarted.set(false);
        this.lightOn.set(false);
        this.barcodes.clear();
        for (ObservableField<? extends String> observableField : this.startNullFields) {
            observableField.set(null);
        }
        this.dateOfHarvest.set(new Date());
        this.tagCount.set(0);
        getCompositeDisposable().add(this.model.getJobById(j).subscribe(new HarvestTagViewModel$setup$2(this, j)));
    }

    @Override // com.digitalwallet.viewmodel.main.ScannerFragmentViewModel
    public Function1<Barcode, Boolean> getBarcodeValidator() {
        return this.barcodeValidator;
    }

    /* access modifiers changed from: private */
    public final void addBarcode(long j) {
        this.barcodes.add(Long.valueOf(j));
        this.barcodeAdded.accept(Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public final Long convertBarcode(String str) {
        try {
            if (str.length() > 9) {
                return null;
            }
            if (Long.parseLong(str) < 0) {
                return null;
            }
            return Long.valueOf(Long.parseLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void resumeScan() {
        this.viewService.unpause();
    }

    public final void pauseScan() {
        this.viewService.pause();
    }

    public final void manualEntry() {
        this.clickMute.tryDo(new HarvestTagViewModel$manualEntry$1(this));
    }

    public final void addBarcode() {
        this.clickMute.tryDo(new HarvestTagViewModel$addBarcode$1(this));
    }

    public final void toggleTorch() {
        boolean z = !this.lightOn.get();
        if (this.viewService.setTorch(z)) {
            this.lightOn.set(z);
            return;
        }
        HarvestTagView harvestTagView = this.view;
        if (harvestTagView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        harvestTagView.toast(R.string.torch_not_available_RES_2114650509);
    }

    public final void backToScanner() {
        this.clickMute.tryDo(new HarvestTagViewModel$backToScanner$1(this));
    }

    public final void goBackFromScanner() {
        this.clickMute.tryDo(new HarvestTagViewModel$goBackFromScanner$1(this));
    }

    public final void closeScanner() {
        this.clickMute.tryDo(new HarvestTagViewModel$closeScanner$1(this));
    }

    /* access modifiers changed from: private */
    public final void doCloseScanner() {
        if (this.barcodes.size() > 0) {
            HarvestTagView harvestTagView = this.view;
            if (harvestTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
            }
            harvestTagView.showCloseScanner();
            return;
        }
        HarvestTagView harvestTagView2 = this.view;
        if (harvestTagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        harvestTagView2.goBackDirect();
    }

    public final void submitSummary() {
        this.clickMute.tryDo(new HarvestTagViewModel$submitSummary$1(this));
    }
}
