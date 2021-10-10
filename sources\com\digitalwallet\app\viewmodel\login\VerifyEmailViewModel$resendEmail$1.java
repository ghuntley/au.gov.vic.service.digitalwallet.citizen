package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.utilities.ActionEventKt;
import io.reactivex.functions.Action;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailViewModel.kt */
public final class VerifyEmailViewModel$resendEmail$1 implements Action {
    final /* synthetic */ VerifyEmailViewModel this$0;

    VerifyEmailViewModel$resendEmail$1(VerifyEmailViewModel verifyEmailViewModel) {
        this.this$0 = verifyEmailViewModel;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ActionEventKt.post(this.this$0.getEmailResentEvent());
        this.this$0.getShowLoading().set(false);
    }
}
