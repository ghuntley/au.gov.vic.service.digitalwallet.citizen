package com.digitalwallet.app.viewmodel.harvester;

import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: HarvestTagViewModel.kt */
public final class HarvestTagViewModel$addBarcode$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ HarvestTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HarvestTagViewModel$addBarcode$1(HarvestTagViewModel harvestTagViewModel) {
        super(0);
        this.this$0 = harvestTagViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        Long l;
        String str = this.this$0.getBarcodeNumber().get();
        if (!(str == null || (l = this.this$0.convertBarcode(str)) == null)) {
            Long l2 = l;
            this.this$0.addBarcode(l2.longValue());
            if (l != null) {
                l2.longValue();
                this.this$0.getBarcodeNumber().set("");
                if (l != null) {
                    return;
                }
            }
        }
        HarvestTagViewModel.access$getView$p(this.this$0).toast(R.string.unexpected_error_RES_2114650512);
        Unit unit = Unit.INSTANCE;
    }
}
