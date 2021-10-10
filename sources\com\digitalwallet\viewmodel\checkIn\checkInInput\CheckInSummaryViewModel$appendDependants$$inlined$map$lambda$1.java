package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.model.DependantCheckIn;
import com.digitalwallet.utilities.ActionEventKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/digitalwallet/viewmodel/checkIn/checkInInput/CheckInSummaryViewModel$appendDependants$1$2"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSummaryViewModel.kt */
public final class CheckInSummaryViewModel$appendDependants$$inlined$map$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $initiallyChecked$inlined;
    final /* synthetic */ DependantCheckIn $it;
    final /* synthetic */ CheckInSummaryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInSummaryViewModel$appendDependants$$inlined$map$lambda$1(DependantCheckIn dependantCheckIn, CheckInSummaryViewModel checkInSummaryViewModel, boolean z) {
        super(0);
        this.$it = dependantCheckIn;
        this.this$0 = checkInSummaryViewModel;
        this.$initiallyChecked$inlined = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        ActionEventKt.postEvent(this.this$0.getPresentEditDependant(), this.$it);
    }
}
