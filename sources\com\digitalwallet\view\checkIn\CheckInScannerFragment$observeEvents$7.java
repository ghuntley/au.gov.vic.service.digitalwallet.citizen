package com.digitalwallet.view.checkIn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.widget.EditText;
import au.gov.vic.service.digitalwallet.citizen.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInScannerFragment.kt */
public final class CheckInScannerFragment$observeEvents$7 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ CheckInScannerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInScannerFragment$observeEvents$7(CheckInScannerFragment checkInScannerFragment) {
        super(1);
        this.this$0 = checkInScannerFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke(unit);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.this$0.getViewModel().pauseScan();
        final EditText editText = new EditText(this.this$0.requireContext());
        editText.setFilters((InputFilter[]) ArraysKt.plus(editText.getFilters(), new InputFilter.AllCaps()));
        CheckInScannerFragment checkInScannerFragment = this.this$0;
        AlertDialog.Builder message = new AlertDialog.Builder(this.this$0.requireContext()).setTitle(R.string.check_in_title).setMessage(R.string.check_in_scanner_manual_entry_body);
        Intrinsics.checkNotNullExpressionValue(message, "AlertDialog.Builder(requ…canner_manual_entry_body)");
        checkInScannerFragment.setEditText(message, editText).setNegativeButton(R.string.cancel_RES_2131689505, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.view.checkIn.CheckInScannerFragment$observeEvents$7.AnonymousClass1 */
            final /* synthetic */ CheckInScannerFragment$observeEvents$7 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.this$0.this$0.getViewModel().resumeScan();
            }
        }).setPositiveButton(R.string.check_in_submit, new DialogInterface.OnClickListener(this) {
            /* class com.digitalwallet.view.checkIn.CheckInScannerFragment$observeEvents$7.AnonymousClass2 */
            final /* synthetic */ CheckInScannerFragment$observeEvents$7 this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                String obj = editText.getText().toString();
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < obj.length(); i2++) {
                    char charAt = obj.charAt(i2);
                    if (!CharsKt.isWhitespace(charAt)) {
                        sb.append(charAt);
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
                this.this$0.this$0.getViewModel().submitCode(sb2);
            }
        }).setCancelable(false).create().show();
    }
}
