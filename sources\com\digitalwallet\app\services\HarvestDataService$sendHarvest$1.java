package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.harvester.HarvestBatch;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatch;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "it", "", "Lcom/digitalwallet/app/model/db/harvester/SavedHarvestTagBatch;", "apply"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestDataService.kt */
public final class HarvestDataService$sendHarvest$1<T, R> implements Function<List<? extends SavedHarvestTagBatch>, CompletableSource> {
    final /* synthetic */ HarvestDataService this$0;

    HarvestDataService$sendHarvest$1(HarvestDataService harvestDataService) {
        this.this$0 = harvestDataService;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(List<? extends SavedHarvestTagBatch> list) {
        return apply((List<SavedHarvestTagBatch>) list);
    }

    public final CompletableSource apply(List<SavedHarvestTagBatch> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (list.size() > 0) {
            final SavedHarvestTagBatch savedHarvestTagBatch = list.get(0);
            return this.this$0.holdingsApi.postHarvestBatch(new HarvestBatch(savedHarvestTagBatch)).doOnComplete(new Action(this) {
                /* class com.digitalwallet.app.services.HarvestDataService$sendHarvest$1.AnonymousClass1 */
                final /* synthetic */ HarvestDataService$sendHarvest$1 this$0;

                {
                    this.this$0 = r1;
                }

                @Override // io.reactivex.functions.Action
                public final void run() {
                    this.this$0.this$0.harvestModel.deleteBatch(savedHarvestTagBatch.getBatch());
                }
            });
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
