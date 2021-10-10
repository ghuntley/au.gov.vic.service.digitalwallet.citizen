package com.digitalwallet.app.viewmodel.harvester;

import android.app.ProgressDialog;
import com.digitalwallet.app.model.db.harvester.HarvestModel;
import com.digitalwallet.app.model.db.harvester.SavedHarvestBatch;
import com.digitalwallet.app.model.db.harvester.SavedHarvestJob;
import com.digitalwallet.app.services.HarvestDataService;
import com.digitalwallet.utilities.RetrofitHelper;
import io.reactivex.CompletableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestTagViewModel.kt */
public final class HarvestTagViewModel$submitSummary$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HarvestTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestTagViewModel$submitSummary$1(HarvestTagViewModel harvestTagViewModel) {
        super(0);
        this.this$0 = harvestTagViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        final ProgressDialog showProgressIndicator = HarvestTagViewModel.access$getView$p(this.this$0).showProgressIndicator();
        HarvestModel harvestModel = this.this$0.model;
        SavedHarvestJob savedHarvestJob = this.this$0.job;
        Intrinsics.checkNotNull(savedHarvestJob);
        List<Long> list = CollectionsKt.toList(this.this$0.barcodes);
        Double gpsLatitude = HarvestTagViewModel.access$getView$p(this.this$0).getGpsLatitude();
        Double gpsLongitude = HarvestTagViewModel.access$getView$p(this.this$0).getGpsLongitude();
        String str = this.this$0.getNumOfFemales().get();
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNullExpressionValue(str, "numOfFemales.get()!!");
        int parseInt = Integer.parseInt(str);
        String str2 = this.this$0.getNumOfEasternGreys().get();
        Intrinsics.checkNotNull(str2);
        Intrinsics.checkNotNullExpressionValue(str2, "numOfEasternGreys.get()!!");
        int parseInt2 = Integer.parseInt(str2);
        String str3 = this.this$0.getNumOfWesternGreys().get();
        Intrinsics.checkNotNull(str3);
        Intrinsics.checkNotNullExpressionValue(str3, "numOfWesternGreys.get()!!");
        int parseInt3 = Integer.parseInt(str3);
        String str4 = this.this$0.getNumPouchYoungDestroyed().get();
        Intrinsics.checkNotNull(str4);
        Intrinsics.checkNotNullExpressionValue(str4, "numPouchYoungDestroyed.get()!!");
        int parseInt4 = Integer.parseInt(str4);
        String str5 = this.this$0.getNumYoungAtFootDestroyed().get();
        Intrinsics.checkNotNull(str5);
        Intrinsics.checkNotNullExpressionValue(str5, "numYoungAtFootDestroyed.get()!!");
        int parseInt5 = Integer.parseInt(str5);
        String str6 = this.this$0.getNumTaggedCarcassesLeftOnProperty().get();
        Intrinsics.checkNotNull(str6);
        Intrinsics.checkNotNullExpressionValue(str6, "numTaggedCarcassesLeftOnProperty.get()!!");
        int parseInt6 = Integer.parseInt(str6);
        String str7 = this.this$0.getNumTaggedCarcassesStoredForProcessor().get();
        Intrinsics.checkNotNull(str7);
        Intrinsics.checkNotNullExpressionValue(str7, "numTaggedCarcassesStoredForProcessor.get()!!");
        int parseInt7 = Integer.parseInt(str7);
        String str8 = this.this$0.getComments().get();
        if (str8 == null) {
            str8 = "";
        }
        Intrinsics.checkNotNullExpressionValue(str8, "comments.get() ?: \"\"");
        Date date = this.this$0.getDateOfHarvest().get();
        Intrinsics.checkNotNull(date);
        Intrinsics.checkNotNullExpressionValue(date, "dateOfHarvest.get()!!");
        this.this$0.getCompositeDisposable().add(harvestModel.saveBatch(savedHarvestJob, list, gpsLatitude, gpsLongitude, parseInt, parseInt2, parseInt3, null, parseInt4, parseInt5, parseInt6, parseInt7, str8, date).flatMapCompletable(new Function<SavedHarvestBatch, CompletableSource>(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel$submitSummary$1.AnonymousClass1 */
            final /* synthetic */ HarvestTagViewModel$submitSummary$1 this$0;

            {
                this.this$0 = r1;
            }

            public final CompletableSource apply(SavedHarvestBatch savedHarvestBatch) {
                Intrinsics.checkNotNullParameter(savedHarvestBatch, "it");
                HarvestDataService harvestDataService = this.this$0.this$0.harvestDataService;
                Long id = savedHarvestBatch.getId();
                Intrinsics.checkNotNull(id);
                return harvestDataService.sendHarvest(id.longValue());
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnError(new HarvestTagViewModel$sam$io_reactivex_functions_Consumer$0(new Function1<Throwable, Unit>(RetrofitHelper.Companion) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel$submitSummary$1.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke(th);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "p1");
                ((RetrofitHelper.Companion) this.receiver).filterHttpException(th);
            }
        })).subscribe(new Action(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel$submitSummary$1.AnonymousClass3 */
            final /* synthetic */ HarvestTagViewModel$submitSummary$1 this$0;

            {
                this.this$0 = r1;
            }

            @Override // io.reactivex.functions.Action
            public final void run() {
                showProgressIndicator.hide();
                HarvestTagViewModel.access$getView$p(this.this$0.this$0).showSummarySuccess();
            }
        }, new Consumer<Throwable>(this) {
            /* class com.digitalwallet.app.viewmodel.harvester.HarvestTagViewModel$submitSummary$1.AnonymousClass4 */
            final /* synthetic */ HarvestTagViewModel$submitSummary$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Throwable th) {
                showProgressIndicator.hide();
                HarvestTagViewModel.access$getView$p(this.this$0.this$0).showSummaryBackgroundRetry();
            }
        }));
    }
}
