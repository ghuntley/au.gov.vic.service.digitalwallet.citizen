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
public final class VerifyEmailFragment$observeEvents$4 extends Lambda implements Function1<CreateAccountError, Unit> {
    final /* synthetic */ VerifyEmailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyEmailFragment$observeEvents$4(VerifyEmailFragment verifyEmailFragment) {
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

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008e, code lost:
        if (r7.equals(com.digitalwallet.app.model.login.CreateAccountError.CODE_OTP_HACKY_MISMATCH) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d8, code lost:
        if (r7.equals(com.digitalwallet.app.model.login.CreateAccountError.CODE_OTP_INCORRECT) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00da, code lost:
        r0.setMessage(au.gov.vic.service.digitalwallet.citizen.R.string.error_otp_incorrect).setPositiveButton(au.gov.vic.service.digitalwallet.citizen.R.string.ok_RES_2114650415, new com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass1(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003b, code lost:
        if (r7.equals(com.digitalwallet.app.model.login.CreateAccountError.CODE_LOGIN_BAD_REQUEST) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0044, code lost:
        if (r7.equals(com.digitalwallet.app.model.login.CreateAccountError.CODE_LOGIN_AUTH_FAILED) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004d, code lost:
        if (r7.equals(com.digitalwallet.app.model.login.CreateAccountError.CODE_LOGIN_DOWNSTREAM) != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        r0.setMessage(au.gov.vic.service.digitalwallet.citizen.R.string.error_auto_login_failed).setPositiveButton(au.gov.vic.service.digitalwallet.citizen.R.string.retry, new com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass8(r6)).setNegativeButton(au.gov.vic.service.digitalwallet.citizen.R.string.log_in, new com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass9(r6));
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x013c  */
    public final void invoke(CreateAccountError createAccountError) {
        Intrinsics.checkNotNullParameter(createAccountError, "it");
        AlertDialog.Builder title = new AlertDialog.Builder(this.this$0.getContext()).setCancelable(false).setTitle(R.string.generic_error_title);
        String errorCode = createAccountError.getErrorCode();
        switch (errorCode.hashCode()) {
            case 539012900:
                if (errorCode.equals(CreateAccountError.CODE_OTP_REGISTER_DOWN_B)) {
                    title.setMessage(R.string.error_backend_went_wrong).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass5 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().verifyOTP();
                        }
                    }).setNegativeButton(R.string.cancel_RES_2114650146, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass6 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().clearOtpInput();
                        }
                    });
                    break;
                }
                title.setMessage(R.string.error_something_went_wrong);
                if (!this.this$0.getViewModel().getHasOTPConfirmed()) {
                    title.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass12 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().verifyOTP();
                        }
                    }).setNegativeButton(R.string.cancel_RES_2114650146, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass13 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().clearOtpInput();
                        }
                    });
                    break;
                } else {
                    title.setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass10 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().autoLogin();
                        }
                    }).setNegativeButton(R.string.log_in, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass11 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.manualLogin();
                        }
                    });
                    break;
                }
            case 539013799:
                break;
            case 539013830:
                if (errorCode.equals(CreateAccountError.CODE_OTP_TIMEOUT)) {
                    title.setMessage(R.string.error_otp_session_expired).setPositiveButton(R.string.email_new_code, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass3 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().initiateANewSession();
                        }
                    }).setNegativeButton(R.string.cancel_RES_2114650146, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass4 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().clearOtpInput();
                        }
                    });
                    break;
                }
                title.setMessage(R.string.error_something_went_wrong);
                if (!this.this$0.getViewModel().getHasOTPConfirmed()) {
                }
                break;
            case 539013861:
                if (errorCode.equals(CreateAccountError.CODE_OTP_MAX_RETRIES_HIT)) {
                    title.setMessage(R.string.error_otp_max_retries_hit).setPositiveButton(R.string.email_new_code, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass2 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.getViewModel().initiateANewSession();
                        }
                    });
                    break;
                }
                title.setMessage(R.string.error_something_went_wrong);
                if (!this.this$0.getViewModel().getHasOTPConfirmed()) {
                }
                break;
            case 539013892:
                break;
            case 539014729:
                if (errorCode.equals(CreateAccountError.CODE_OTP_DEVICE_PRINT_DOWN_CDE)) {
                    title.setMessage(R.string.error_account_partially_set).setPositiveButton(R.string.log_in, new DialogInterface.OnClickListener(this) {
                        /* class com.digitalwallet.app.view.login.VerifyEmailFragment$observeEvents$4.AnonymousClass7 */
                        final /* synthetic */ VerifyEmailFragment$observeEvents$4 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.this$0.this$0.manualLogin();
                        }
                    });
                    break;
                }
                title.setMessage(R.string.error_something_went_wrong);
                if (!this.this$0.getViewModel().getHasOTPConfirmed()) {
                }
                break;
            case 539042598:
                break;
            case 539042629:
                break;
            case 539043559:
                break;
            default:
                title.setMessage(R.string.error_something_went_wrong);
                if (!this.this$0.getViewModel().getHasOTPConfirmed()) {
                }
                break;
        }
        title.show();
    }
}
