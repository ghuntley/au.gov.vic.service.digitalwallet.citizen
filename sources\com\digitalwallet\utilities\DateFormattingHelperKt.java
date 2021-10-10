package com.digitalwallet.utilities;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\u0006"}, d2 = {"bindServerDate", "", "textView", "Landroid/widget/TextView;", "date", "Ljava/util/Date;", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: DateFormattingHelper.kt */
public final class DateFormattingHelperKt {
    @BindingAdapter({"date_ddMMyyyy"})
    public static final void bindServerDate(TextView textView, Date date) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setText(date != null ? DateFormattingHelper.INSTANCE.toStringMonthAsWord(date) : null);
    }
}
