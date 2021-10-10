package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.harvester.HarvestBatch;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatch;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "batches", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestDataService.kt */
public final class HarvestDataService$sendOtherHarvests$1<T, R> implements Function<List<? extends SavedHarvestTagBatch>, CompletableSource> {
    final /* synthetic */ HarvestDataService this$0;

    HarvestDataService$sendOtherHarvests$1(HarvestDataService harvestDataService) {
        this.this$0 = harvestDataService;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(List<? extends SavedHarvestTagBatch> list) {
        return apply((List<SavedHarvestTagBatch>) list);
    }

    public final CompletableSource apply(List<SavedHarvestTagBatch> list) {
        Intrinsics.checkNotNullParameter(list, "batches");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (T t : list) {
            HarvestBatch harvestBatch = new HarvestBatch(t);
            Completable doOnComplete = this.this$0.holdingsApi.postHarvestBatch(harvestBatch).doOnComplete(new HarvestDataService$sendOtherHarvests$1$$special$$inlined$fold$lambda$1(harvestBatch, t, this));
            Intrinsics.checkNotNullExpressionValue(doOnComplete, "it");
            linkedHashSet.add(doOnComplete);
        }
        return Completable.mergeDelayError(linkedHashSet);
    }
}
