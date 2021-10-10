package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.model.CheckIn;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSubmittingViewModel.kt */
public final class CheckInSubmittingViewModel$submitCheckInInfo$2 implements Action {
    final /* synthetic */ CheckInUtils.CheckInCode $checkInCode;
    final /* synthetic */ CheckIn $checkInPayload;
    final /* synthetic */ CheckInSubmittingViewModel this$0;

    CheckInSubmittingViewModel$submitCheckInInfo$2(CheckInSubmittingViewModel checkInSubmittingViewModel, CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        this.this$0 = checkInSubmittingViewModel;
        this.$checkInPayload = checkIn;
        this.$checkInCode = checkInCode;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.this$0.doOnCheckInSuccess(this.$checkInPayload, this.$checkInCode);
    }
}
