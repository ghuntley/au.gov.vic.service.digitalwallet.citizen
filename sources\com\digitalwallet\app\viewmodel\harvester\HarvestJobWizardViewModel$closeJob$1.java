package com.digitalwallet.app.viewmodel.harvester;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestJobWizardViewModel.kt */
final class HarvestJobWizardViewModel$closeJob$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $jobId;
    final /* synthetic */ HarvestJobWizardViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestJobWizardViewModel$closeJob$1(HarvestJobWizardViewModel harvestJobWizardViewModel, long j) {
        super(0);
        this.this$0 = harvestJobWizardViewModel;
        this.$jobId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        HarvestJobWizardViewModel.access$getView$p(this.this$0).closeJob(this.$jobId);
    }
}
