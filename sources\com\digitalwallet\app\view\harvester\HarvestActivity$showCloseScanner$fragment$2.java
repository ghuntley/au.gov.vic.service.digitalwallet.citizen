package com.digitalwallet.app.view.harvester;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestActivity.kt */
final class HarvestActivity$showCloseScanner$fragment$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HarvestActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestActivity$showCloseScanner$fragment$2(HarvestActivity harvestActivity) {
        super(0);
        this.this$0 = harvestActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.this$0.goBack();
    }
}
