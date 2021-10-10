package com.digitalwallet.app.viewmodel.harvester;

import androidx.databinding.Observable;
import androidx.databinding.ObservableField;
import com.digitalwallet.app.model.HoldingRecordAttributes;
import com.digitalwallet.app.model.KangarooHarvesterQuota;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import com.digitalwallet.app.view.harvester.HarvestView;
import com.digitalwallet.app.view.util.ClickMute;
import com.digitalwallet.viewmodel.base.BaseViewModel;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0002022\u0006\u00104\u001a\u000205H\u0016J\u0006\u00106\u001a\u000202J\u000e\u00107\u001a\u0002022\u0006\u00108\u001a\u000205J\u0006\u00109\u001a\u000202J\u0006\u0010\"\u001a\u000202J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0 J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000202H\u0016J\u0006\u0010@\u001a\u000202J\b\u0010A\u001a\u000202H\u0002J\u0006\u0010B\u001a\u000202J\u0010\u0010C\u001a\u0002022\u0006\u00104\u001a\u000205H\u0016J\u0016\u0010D\u001a\u0002022\u0006\u0010\f\u001a\u00020\r2\u0006\u00100\u001a\u00020\u0002J\b\u0010E\u001a\u000202H\u0016R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001a0\u001a0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001a0\u001a0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR4\u0010\u001e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020! \t*\n\u0012\u0004\u0012\u00020!\u0018\u00010 0 0\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001f\u0010&\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR \u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010+R\u001f\u0010,\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010.\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u000e\u00100\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/digitalwallet/app/viewmodel/harvester/HarvestJobWizardViewModel;", "Lcom/digitalwallet/viewmodel/base/BaseViewModel;", "Lcom/digitalwallet/app/view/harvester/HarvestView;", "model", "Lcom/digitalwallet/app/model/db/harvester/HarvestModel;", "(Lcom/digitalwallet/app/model/db/harvester/HarvestModel;)V", AuthorizationRequest.Scope.ADDRESS, "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getAddress", "()Landroidx/databinding/ObservableField;", "attributes", "Lcom/digitalwallet/app/model/HoldingRecordAttributes;", "clickMute", "Lcom/digitalwallet/app/view/util/ClickMute;", "clickMuteBack", "consentDateTime", "Ljava/util/Date;", "getConsentDateTime", "()Ljava/util/Date;", "setConsentDateTime", "(Ljava/util/Date;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "hasJobs", "", "getHasJobs", "hasZones", "getHasZones", "jobs", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestJob;", "getJobs", "()Lcom/jakewharton/rxrelay2/BehaviorRelay;", "setJobs", "(Lcom/jakewharton/rxrelay2/BehaviorRelay;)V", "landholderContactNumber", "getLandholderContactNumber", "landholderDetailsFilled", "getLandholderDetailsFilled", "setLandholderDetailsFilled", "(Landroidx/databinding/ObservableField;)V", "landholderName", "getLandholderName", "quotaId", "getQuotaId", Promotion.ACTION_VIEW, "clear", "", "closeJob", "jobId", "", AuthorizationRequest.Prompt.CONSENT, "deleteJob", "id", "doneAddress", "getZones", "Lcom/digitalwallet/app/model/KangarooHarvesterQuota;", "go", "screen", "Lcom/digitalwallet/app/view/harvester/HarvestView$Screen;", "goBack", "goToWizardConsent", "goToWizardZone", "saveJob", "scanTags", "setup", "showAddJobSuccess", "app_citizenProdRelease"}, k = 1, mv = {1, 4, 0})
/* compiled from: HarvestJobWizardViewModel.kt */
public final class HarvestJobWizardViewModel extends BaseViewModel implements HarvestView {
    private final ObservableField<String> address;
    private HoldingRecordAttributes attributes;
    private final ClickMute clickMute;
    private final ClickMute clickMuteBack;
    private Date consentDateTime;
    private final CompositeDisposable disposables;
    private final ObservableField<Boolean> hasJobs;
    private final ObservableField<Boolean> hasZones;
    private BehaviorRelay<List<SavedHarvestJob>> jobs;
    private final ObservableField<String> landholderContactNumber;
    private ObservableField<Boolean> landholderDetailsFilled;
    private final ObservableField<String> landholderName;
    private final HarvestModel model;
    private final ObservableField<String> quotaId = new ObservableField<>("");
    private HarvestView view;

    public static final /* synthetic */ HarvestView access$getView$p(HarvestJobWizardViewModel harvestJobWizardViewModel) {
        HarvestView harvestView = harvestJobWizardViewModel.view;
        if (harvestView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        return harvestView;
    }

    @Inject
    public HarvestJobWizardViewModel(HarvestModel harvestModel) {
        Intrinsics.checkNotNullParameter(harvestModel, "model");
        this.model = harvestModel;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.disposables = compositeDisposable;
        ObservableField<String> observableField = new ObservableField<>("");
        this.address = observableField;
        ObservableField<String> observableField2 = new ObservableField<>("");
        this.landholderContactNumber = observableField2;
        ObservableField<String> observableField3 = new ObservableField<>("");
        this.landholderName = observableField3;
        this.hasJobs = new ObservableField<>((Boolean) false);
        this.hasZones = new ObservableField<>((Boolean) false);
        this.landholderDetailsFilled = new HarvestJobWizardViewModel$landholderDetailsFilled$1(this, new Observable[]{observableField2, observableField3, observableField});
        BehaviorRelay<List<SavedHarvestJob>> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create<List<SavedHarvestJob>>()");
        this.jobs = create;
        compositeDisposable.add(create.subscribe(new Consumer<List<? extends SavedHarvestJob>>(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestJobWizardViewModel.AnonymousClass1 */
            final /* synthetic */ HarvestJobWizardViewModel this$0;

            {
                this.this$0 = r1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Consumer
            public /* bridge */ /* synthetic */ void accept(List<? extends SavedHarvestJob> list) {
                accept((List<SavedHarvestJob>) list);
            }

            public final void accept(List<SavedHarvestJob> list) {
                ObservableField<Boolean> hasJobs = this.this$0.getHasJobs();
                Intrinsics.checkNotNullExpressionValue(list, "it");
                hasJobs.set(Boolean.valueOf(list.size() > 0));
            }
        }));
        this.clickMute = new ClickMute(0, 1, null);
        this.clickMuteBack = new ClickMute(500);
    }

    public final ObservableField<String> getQuotaId() {
        return this.quotaId;
    }

    public final ObservableField<String> getAddress() {
        return this.address;
    }

    public final ObservableField<String> getLandholderContactNumber() {
        return this.landholderContactNumber;
    }

    public final ObservableField<String> getLandholderName() {
        return this.landholderName;
    }

    public final ObservableField<Boolean> getHasJobs() {
        return this.hasJobs;
    }

    public final ObservableField<Boolean> getHasZones() {
        return this.hasZones;
    }

    public final Date getConsentDateTime() {
        return this.consentDateTime;
    }

    public final void setConsentDateTime(Date date) {
        this.consentDateTime = date;
    }

    public final ObservableField<Boolean> getLandholderDetailsFilled() {
        return this.landholderDetailsFilled;
    }

    public final void setLandholderDetailsFilled(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.landholderDetailsFilled = observableField;
    }

    public final BehaviorRelay<List<SavedHarvestJob>> getJobs() {
        return this.jobs;
    }

    public final void setJobs(BehaviorRelay<List<SavedHarvestJob>> behaviorRelay) {
        Intrinsics.checkNotNullParameter(behaviorRelay, "<set-?>");
        this.jobs = behaviorRelay;
    }

    public final void setup(HoldingRecordAttributes holdingRecordAttributes, HarvestView harvestView) {
        Intrinsics.checkNotNullParameter(holdingRecordAttributes, "attributes");
        Intrinsics.checkNotNullParameter(harvestView, Promotion.ACTION_VIEW);
        this.attributes = holdingRecordAttributes;
        this.view = harvestView;
        this.hasZones.set(Boolean.valueOf(holdingRecordAttributes.getQuotas().size() > 0));
    }

    @Override // androidx.lifecycle.ViewModel
    public final void clear() {
        this.quotaId.set("");
        this.address.set("");
    }

    public final List<KangarooHarvesterQuota> getZones() {
        HoldingRecordAttributes holdingRecordAttributes = this.attributes;
        if (holdingRecordAttributes == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributes");
        }
        return holdingRecordAttributes.getQuotas();
    }

    /* renamed from: getJobs  reason: collision with other method in class */
    public final void m6getJobs() {
        HoldingRecordAttributes holdingRecordAttributes = this.attributes;
        if (holdingRecordAttributes == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributes");
        }
        List<KangarooHarvesterQuota> quotas = holdingRecordAttributes.getQuotas();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(quotas, 10));
        Iterator<T> it = quotas.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getQuotaId());
        }
        ArrayList arrayList2 = arrayList;
        HarvestModel harvestModel = this.model;
        HoldingRecordAttributes holdingRecordAttributes2 = this.attributes;
        if (holdingRecordAttributes2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributes");
        }
        this.disposables.add(harvestModel.getJobs(holdingRecordAttributes2.getIdentifier()).map(new HarvestJobWizardViewModel$getJobs$1(arrayList2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new HarvestJobWizardViewModel$getJobs$2(this)));
    }

    public final void saveJob() {
        HoldingRecordAttributes holdingRecordAttributes = this.attributes;
        if (holdingRecordAttributes == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributes");
        }
        String identifier = holdingRecordAttributes.getIdentifier();
        HarvestModel harvestModel = this.model;
        Date date = this.consentDateTime;
        Intrinsics.checkNotNull(date);
        String str = this.quotaId.get();
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNullExpressionValue(str, "quotaId.get()!!");
        String str2 = str;
        String str3 = this.address.get();
        Intrinsics.checkNotNull(str3);
        Intrinsics.checkNotNullExpressionValue(str3, "address.get()!!");
        String str4 = str3;
        String str5 = this.landholderName.get();
        Intrinsics.checkNotNull(str5);
        Intrinsics.checkNotNullExpressionValue(str5, "landholderName.get()!!");
        String str6 = str5;
        String str7 = this.landholderContactNumber.get();
        Intrinsics.checkNotNull(str7);
        Intrinsics.checkNotNullExpressionValue(str7, "landholderContactNumber.get()!!");
        harvestModel.saveJob(identifier, date, str2, str4, str6, str7);
        HarvestView harvestView = this.view;
        if (harvestView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Promotion.ACTION_VIEW);
        }
        harvestView.showAddJobSuccess();
    }

    public final void deleteJob(long j) {
        this.model.deleteJob(j);
    }

    public final void goToWizardConsent() {
        this.clickMute.tryDo(new HarvestJobWizardViewModel$goToWizardConsent$1(this));
    }

    public final void consent() {
        this.clickMute.tryDo(new HarvestJobWizardViewModel$consent$1(this));
    }

    private final void goToWizardZone() {
        this.clickMute.tryDo(new HarvestJobWizardViewModel$goToWizardZone$1(this));
    }

    public final void doneAddress() {
        goToWizardZone();
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void goBack() {
        this.clickMuteBack.tryDo(new HarvestJobWizardViewModel$goBack$1(this));
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void scanTags(long j) {
        this.clickMute.tryDo(new HarvestJobWizardViewModel$scanTags$1(this, j));
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void closeJob(long j) {
        this.clickMute.tryDo(new HarvestJobWizardViewModel$closeJob$1(this, j));
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void showAddJobSuccess() {
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.digitalwallet.app.view.harvester.HarvestView
    public void go(HarvestView.Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        throw new IllegalStateException("Check failed.".toString());
    }
}
