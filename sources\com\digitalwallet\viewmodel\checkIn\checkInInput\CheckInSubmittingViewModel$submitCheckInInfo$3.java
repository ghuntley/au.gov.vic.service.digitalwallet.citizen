package com.digitalwallet.viewmodel.checkIn.checkInInput;

import com.digitalwallet.model.CheckIn;
import com.digitalwallet.utilities.ActionEventKt;
import com.digitalwallet.viewmodel.checkIn.CheckInUtils;
import io.reactivex.functions.Consumer;
import java.net.UnknownHostException;
import kotlin.Metadata;
import timber.log.Timber;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInSubmittingViewModel.kt */
public final class CheckInSubmittingViewModel$submitCheckInInfo$3<T> implements Consumer<Throwable> {
    final /* synthetic */ CheckInUtils.CheckInCode $checkInCode;
    final /* synthetic */ CheckIn $checkInPayload;
    final /* synthetic */ CheckInSubmittingViewModel this$0;

    CheckInSubmittingViewModel$submitCheckInInfo$3(CheckInSubmittingViewModel checkInSubmittingViewModel, CheckIn checkIn, CheckInUtils.CheckInCode checkInCode) {
        this.this$0 = checkInSubmittingViewModel;
        this.$checkInPayload = checkIn;
        this.$checkInCode = checkInCode;
    }

    public final void accept(Throwable th) {
        Timber.e(th);
        if (!this.this$0.isInstantApp().get()) {
            this.this$0.doOnCheckInSuccess(this.$checkInPayload, this.$checkInCode);
        } else if (th instanceof UnknownHostException) {
            ActionEventKt.post(this.this$0.getShowPopUpOfNoInternetConnection());
        } else {
            ActionEventKt.post(this.this$0.getShowPopUpOfNetworkIssue());
        }
    }
}
