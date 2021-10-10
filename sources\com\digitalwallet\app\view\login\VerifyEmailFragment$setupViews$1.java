package com.digitalwallet.app.view.login;

import com.digitalwallet.utilities.FragmentHelperKt;
import com.mukesh.OnOtpCompletionListener;
import kotlin.Metadata;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onOtpCompleted"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailFragment.kt */
public final class VerifyEmailFragment$setupViews$1 implements OnOtpCompletionListener {
    final /* synthetic */ VerifyEmailFragment this$0;

    VerifyEmailFragment$setupViews$1(VerifyEmailFragment verifyEmailFragment) {
        this.this$0 = verifyEmailFragment;
    }

    @Override // com.mukesh.OnOtpCompletionListener
    public final void onOtpCompleted(String str) {
        FragmentHelperKt.hideKeyboard(this.this$0);
        this.this$0.getViewModel().verifyOTP();
    }
}
