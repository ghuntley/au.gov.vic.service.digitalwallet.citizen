package com.digitalwallet.app.services;

import com.digitalwallet.app.model.db.harvester.HarvestBatch;
import com.digitalwallet.app.model.db.harvester.SavedHarvestTagBatch;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "run", "com/digitalwallet/app/services/HarvestDataService$sendOtherHarvests$1$1$1$1", "com/digitalwallet/app/services/HarvestDataService$sendOtherHarvests$1$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestDataService.kt */
public final class HarvestDataService$sendOtherHarvests$1$$special$$inlined$fold$lambda$1 implements Action {
    final /* synthetic */ HarvestBatch $batch$inlined;
    final /* synthetic */ SavedHarvestTagBatch $savedBatch$inlined;
    final /* synthetic */ HarvestDataService$sendOtherHarvests$1 this$0;

    HarvestDataService$sendOtherHarvests$1$$special$$inlined$fold$lambda$1(HarvestBatch harvestBatch, SavedHarvestTagBatch savedHarvestTagBatch, HarvestDataService$sendOtherHarvests$1 harvestDataService$sendOtherHarvests$1) {
        this.$batch$inlined = harvestBatch;
        this.$savedBatch$inlined = savedHarvestTagBatch;
        this.this$0 = harvestDataService$sendOtherHarvests$1;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.this$0.harvestModel.deleteBatch(this.$savedBatch$inlined.getBatch());
    }
}
