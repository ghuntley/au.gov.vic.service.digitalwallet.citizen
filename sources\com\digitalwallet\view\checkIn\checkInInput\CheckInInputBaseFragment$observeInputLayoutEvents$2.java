package com.digitalwallet.view.checkIn.checkInInput;

import android.text.Editable;
import com.digitalwallet.databinding.LayoutCheckInInputBinding;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "Landroidx/databinding/ViewDataBinding;", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 4, 0})
/* compiled from: CheckInInputBaseFragment.kt */
public final class CheckInInputBaseFragment$observeInputLayoutEvents$2 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ LayoutCheckInInputBinding $inputLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckInInputBaseFragment$observeInputLayoutEvents$2(LayoutCheckInInputBinding layoutCheckInInputBinding) {
        super(1);
        this.$inputLayout = layoutCheckInInputBinding;
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
        this.$inputLayout.phoneNumberEditText.post(new Runnable(this) {
            /* class com.digitalwallet.view.checkIn.checkInInput.CheckInInputBaseFragment$observeInputLayoutEvents$2.AnonymousClass1 */
            final /* synthetic */ CheckInInputBaseFragment$observeInputLayoutEvents$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                TextInputEditText textInputEditText = this.this$0.$inputLayout.phoneNumberEditText;
                TextInputEditText textInputEditText2 = this.this$0.$inputLayout.phoneNumberEditText;
                Intrinsics.checkNotNullExpressionValue(textInputEditText2, "inputLayout.phoneNumberEditText");
                Editable text = textInputEditText2.getText();
                textInputEditText.setSelection(text != null ? text.length() : 0);
            }
        });
    }
}
