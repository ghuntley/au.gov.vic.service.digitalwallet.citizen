package com.digitalwallet.app.view.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.app.databinding.FragmentCreateAccountBinding;
import com.digitalwallet.app.model.login.CreateAccountError;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/digitalwallet/app/model/login/CreateAccountError;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CreateAccountFragment.kt */
public final class CreateAccountFragment$observeEvents$3 extends Lambda implements Function1<CreateAccountError, Unit> {
    final /* synthetic */ CreateAccountFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateAccountFragment$observeEvents$3(CreateAccountFragment createAccountFragment) {
        super(1);
        this.this$0 = createAccountFragment;
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
        AlertDialog.Builder title = new AlertDialog.Builder(this.this$0.getContext()).setCancelable(false).setTitle(R.string.generic_error_title);
        String errorCode = createAccountError.getErrorCode();
        int hashCode = errorCode.hashCode();
        if (hashCode != 538983016) {
            if (hashCode != 538983047) {
            }
            title.setMessage(R.string.error_backend_went_wrong).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
                /* class com.digitalwallet.app.view.login.CreateAccountFragment$observeEvents$3.AnonymousClass3 */
                final /* synthetic */ CreateAccountFragment$observeEvents$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.this$0.this$0.getViewModel().createAccount();
                }
            }).setNegativeButton(R.string.cancel_RES_2114650146, AnonymousClass4.INSTANCE);
            title.show();
        } else if (errorCode.equals(CreateAccountError.CODE_REG_USER_EXISTS)) {
            title.setMessage(R.string.error_email_registered).setPositiveButton(R.string.use_another_email, new DialogInterface.OnClickListener(this) {
                /* class com.digitalwallet.app.view.login.CreateAccountFragment$observeEvents$3.AnonymousClass1 */
                final /* synthetic */ CreateAccountFragment$observeEvents$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.this$0.this$0.getViewModel().getEmail().set("");
                    ((FragmentCreateAccountBinding) this.this$0.this$0.getBinding()).emailEditText.requestFocus();
                    TextInputEditText textInputEditText = ((FragmentCreateAccountBinding) this.this$0.this$0.getBinding()).emailEditText;
                    Intrinsics.checkNotNullExpressionValue(textInputEditText, "binding.emailEditText");
                    ViewUtilsKt.showKeyboard(textInputEditText);
                }
            }).setNegativeButton(R.string.log_in, new DialogInterface.OnClickListener(this) {
                /* class com.digitalwallet.app.view.login.CreateAccountFragment$observeEvents$3.AnonymousClass2 */
                final /* synthetic */ CreateAccountFragment$observeEvents$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.this$0.this$0.login();
                }
            });
            title.show();
        }
        title.setMessage(R.string.error_something_went_wrong).setPositiveButton(R.string.retry, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.app.view.login.CreateAccountFragment$observeEvents$3.AnonymousClass5 */
            final /* synthetic */ CreateAccountFragment$observeEvents$3 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.this$0.this$0.getViewModel().createAccount();
            }
        }).setNegativeButton(R.string.cancel_RES_2114650146, AnonymousClass6.INSTANCE);
        title.show();
    }
}
