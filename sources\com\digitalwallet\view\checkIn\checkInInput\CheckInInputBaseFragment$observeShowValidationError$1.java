package com.digitalwallet.view.checkIn.checkInInput;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Html;
import au.gov.vic.service.digitalwallet.citizen.R;
import com.digitalwallet.databinding.LayoutCheckInInputBinding;
import com.digitalwallet.utilities.AnalyticsHelper;
import com.digitalwallet.utilities.StandardHelperKt;
import com.digitalwallet.view.util.ViewUtilsKt;
import com.digitalwallet.viewmodel.checkIn.checkInInput.CheckInInputBaseViewModel;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Landroidx/databinding/ViewDataBinding;", "it", "Lcom/digitalwallet/viewmodel/checkIn/checkInInput/CheckInInputBaseViewModel$ValidationError;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInInputBaseFragment.kt */
public final class CheckInInputBaseFragment$observeShowValidationError$1 extends Lambda implements Function1<CheckInInputBaseViewModel.ValidationError, Unit> {
    final /* synthetic */ LayoutCheckInInputBinding $inputLayout;
    final /* synthetic */ CheckInInputBaseFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInInputBaseFragment$observeShowValidationError$1(CheckInInputBaseFragment checkInInputBaseFragment, LayoutCheckInInputBinding layoutCheckInInputBinding) {
        super(1);
        this.this$0 = checkInInputBaseFragment;
        this.$inputLayout = layoutCheckInInputBinding;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CheckInInputBaseViewModel.ValidationError validationError) {
        invoke(validationError);
        return Unit.INSTANCE;
    }

    public final void invoke(final CheckInInputBaseViewModel.ValidationError validationError) {
        Intrinsics.checkNotNullParameter(validationError, "it");
        String analyticsContentType = validationError.getAnalyticsContentType();
        if (analyticsContentType != null) {
            AnalyticsHelper.selectContent$default(this.this$0.getAnalytics(), analyticsContentType, null, 2, null);
        }
        new AlertDialog.Builder(this.this$0.requireContext()).setMessage(Html.fromHtml(this.this$0.getString(validationError.getDialogMessageId()))).setPositiveButton(R.string.ok_RES_2131689719, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment$observeShowValidationError$1.AnonymousClass2 */
            final /* synthetic */ CheckInInputBaseFragment$observeShowValidationError$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                final TextInputEditText textInputEditText = new TextInputEditText[]{this.this$0.$inputLayout.firstNameEditText, this.this$0.$inputLayout.lastNameEditText, this.this$0.$inputLayout.phoneNumberEditText}[validationError.getFocusFieldIndex()];
                Intrinsics.checkNotNullExpressionValue(textInputEditText, "arrayOf(\n               …    )[it.focusFieldIndex]");
                textInputEditText.requestFocus();
                StandardHelperKt.postAfter(100, new Function0<Unit>() {
                    /* class com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment$observeShowValidationError$1.AnonymousClass2.AnonymousClass1 */

                    @Override // kotlin.jvm.functions.Function0
                    public final void invoke() {
                        ViewUtilsKt.showKeyboard(textInputEditText);
                    }
                });
            }
        }).setCancelable(false).create().show();
    }
}
