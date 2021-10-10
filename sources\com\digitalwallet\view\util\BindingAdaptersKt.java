package com.digitalwallet.view.util;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"goneWhenEmpty", "", "textView", "Landroid/widget/TextView;", "", "setVisibleOrGone", Promotion.ACTION_VIEW, "Landroid/view/View;", "condition", "base_citizenProdRelease"}, k = 2, mv = {1, 4, 0})
/* compiled from: BindingAdapters.kt */
public final class BindingAdaptersKt {
    @BindingAdapter({"visibleOrGone"})
    public static final void setVisibleOrGone(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, Promotion.ACTION_VIEW);
        view.setVisibility(z ? 0 : 8);
    }

    @BindingAdapter({"goneWhenEmpty"})
    public static final void goneWhenEmpty(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        CharSequence text = textView.getText();
        int i = 0;
        if ((text == null || text.length() == 0) && z) {
            i = 8;
        }
        textView.setVisibility(i);
    }
}
