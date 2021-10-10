package com.digitalwallet.app.viewmodel.harvester;

import com.digitalwallet.app.view.harvester.HarvestView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestJobAdapter.kt */
public final class HarvestJobViewHolder$closeJob$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HarvestJobViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestJobViewHolder$closeJob$1(HarvestJobViewHolder harvestJobViewHolder) {
        super(0);
        this.this$0 = harvestJobViewHolder;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        HarvestView harvestView = this.this$0.view;
        Long l = this.this$0.jobId;
        Intrinsics.checkNotNull(l);
        harvestView.closeJob(l.longValue());
    }
}
