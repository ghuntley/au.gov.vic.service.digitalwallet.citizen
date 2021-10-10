package com.digitalwallet.app.view.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.model.login.CreateAccountError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/CreateAccountError;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: VerifyEmailFragment.kt */
public final class VerifyEmailFragment$observeEvents$2 extends Lambda implements Function1<CreateAccountError, Unit> {
    final /* synthetic */ VerifyEmailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyEmailFragment$observeEvents$2(VerifyEmailFragment verifyEmailFragment) {
        super(1);
        this.this$0 = verifyEmailFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreateAccountError createAccountError) {
        invoke(createAccountError);
        return Unit.INSTANCE;
    }

    public final void invoke(CreateAccountError createAccountError) {
        Intrinsics.checkNotNullParameter(createAccountError, "it");
        String errorCode = createAccountError.getErrorCode();
        if (errorCode.hashCode() == 539073443 && errorCode.equals(CreateAccountError.CODE_RESEND_MAX_RETRIES_HIT)) {
            this.this$0.getViewModel().initiateANewSession();
            return;
        }
        AlertDialog.Builder title = new AlertDialog.Builder(this.this$0.getContext()).setCancelable(false).setTitle(R.string.generic_error_title);
        String errorCode2 = createAccountError.getErrorCode();
        int hashCode = errorCode2.hashCode();
        if (hashCode != 538983016) {
            if (hashCode == 539072451 && errorCode2.equals(CreateAccountError.CODE_RESEND_DOWNSTREAM)) {
                title.setMessage(R.string.error_backend_went_wrong).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
                    /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$2.AnonymousClass1 */
                    final /* synthetic */ VerifyEmailFragment$observeEvents$2 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.this$0.this$0.getViewModel().resendEmail();
                    }
                }).setNegativeButton(R.string.cancel_RES_2114650146, AnonymousClass2.INSTANCE);
                title.show();
            }
        } else if (errorCode2.equals(CreateAccountError.CODE_REG_USER_EXISTS)) {
            title.setMessage(R.string.error_email_registered).setPositiveButton(R.string.log_in, new DialogInterface.OnClickListener(this) {
                /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$2.AnonymousClass3 */
                final /* synthetic */ VerifyEmailFragment$observeEvents$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.this$0.this$0.manualLogin();
                }
            });
            title.show();
        }
        title.setMessage(R.string.error_something_went_wrong).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$2.AnonymousClass4 */
            final /* synthetic */ VerifyEmailFragment$observeEvents$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.this$0.this$0.getViewModel().resendEmail();
            }
        }).setNegativeButton(R.string.cancel_RES_2114650146, AnonymousClass5.INSTANCE);
        title.show();
    }
}
