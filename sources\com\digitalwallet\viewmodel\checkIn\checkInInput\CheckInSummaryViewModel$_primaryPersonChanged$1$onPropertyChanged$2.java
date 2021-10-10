package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.model.PrimaryPersonCheckIn;
import com.digitalwallet.utilities.ActionEventKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSummaryViewModel.kt */
final class CheckInSummaryViewModel$_primaryPersonChanged$1$onPropertyChanged$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PrimaryPersonCheckIn $primaryPerson;
    final /* synthetic */ CheckInSummaryViewModel$_primaryPersonChanged$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInSummaryViewModel$_primaryPersonChanged$1$onPropertyChanged$2(CheckInSummaryViewModel$_primaryPersonChanged$1 checkInSummaryViewModel$_primaryPersonChanged$1, PrimaryPersonCheckIn primaryPersonCheckIn) {
        super(0);
        this.this$0 = checkInSummaryViewModel$_primaryPersonChanged$1;
        this.$primaryPerson = primaryPersonCheckIn;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        PrimaryPersonCheckIn primaryPersonCheckIn = this.$primaryPerson;
        if (primaryPersonCheckIn != null) {
            ActionEventKt.postEvent(this.this$0.this$0.getPresentEditPrimary(), primaryPersonCheckIn);
        }
    }
}
