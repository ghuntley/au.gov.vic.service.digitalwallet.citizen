package com.digitalwallet.app.viewmodel.login;

import com.digitalwallet.app.model.login.RegisterUserResponsePayload;
import com.digitalwallet.utilities.ActionEventKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/RegisterUserResponsePayload;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailViewModel.kt */
public final class VerifyEmailViewModel$initiateANewSession$1<T> implements Consumer<RegisterUserResponsePayload> {
    final /* synthetic */ VerifyEmailViewModel this$0;

    VerifyEmailViewModel$initiateANewSession$1(VerifyEmailViewModel verifyEmailViewModel) {
        this.this$0 = verifyEmailViewModel;
    }

    public final void accept(RegisterUserResponsePayload registerUserResponsePayload) {
        if (Intrinsics.areEqual(VerifyEmailViewModel.access$getVerifyOTPRequestPayload$p(this.this$0).getEmail(), registerUserResponsePayload.getEmail())) {
            VerifyEmailViewModel.access$getVerifyOTPRequestPayload$p(this.this$0).setSessionID(registerUserResponsePayload.getSessionID());
            VerifyEmailViewModel.access$getVerifyOTPRequestPayload$p(this.this$0).setId(registerUserResponsePayload.getId());
            ActionEventKt.post(this.this$0.getEmailResentEvent());
            this.this$0.getShowLoading().set(false);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
